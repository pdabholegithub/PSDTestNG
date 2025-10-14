package com.impactguru.testcases.IGF_Testcases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.impactguru.testcases.Test_Base_Class;

public class IGF_AllLinks_ValidBroken_CICD extends Test_Base_Class {

    private String filePath;

    @BeforeMethod
    public void openSite() {
        // Navigate to IGF site
        driver.get("https://www.igfindia.org/");

        // CSV file path inside project workspace
        File reportsDir = new File(System.getProperty("user.dir") + "/reports");
        if (!reportsDir.exists()) {
            reportsDir.mkdirs();
        }
        filePath = reportsDir + "/BrokenLinksReport_IGF.csv";
    }

    @Test
    public void validateAllLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + links.size());

        int brokenCount = 0;

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("URL,StatusCode,Result\n");

            for (WebElement link : links) {
                String url = link.getAttribute("href");

                // Skip non-http links
                if (url == null || url.isEmpty() || (!url.startsWith("http://") && !url.startsWith("https://"))) {
                    writer.append(url == null ? "null" : url).append(",,Skipped\n");
                    continue;
                }

                try {
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setConnectTimeout(5000); // 5 sec timeout
                    connection.setReadTimeout(5000);
                    connection.setRequestMethod("HEAD");
                    connection.connect();

                    int responseCode = connection.getResponseCode();
                    String result = (responseCode >= 400) ? "Broken" : "Valid";

                    if (responseCode >= 400) {
                        brokenCount++;
                        System.out.println("❌ Broken Link: " + url + " | " + responseCode);
                    }

                    writer.append(url).append(",").append(String.valueOf(responseCode)).append(",").append(result).append("\n");
                    writer.flush();

                } catch (IOException e) {
                    brokenCount++;
                    System.out.println("⚠️ Exception for URL: " + url + " -> " + e.getMessage());
                    writer.append(url).append(",,Exception\n");
                    writer.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Failed to write report file: " + e.getMessage());
        }

        System.out.println("Report generated at: " + filePath);
        System.out.println("Total broken links: " + brokenCount);

        // Fail test if too many broken links
        Assert.assertTrue(brokenCount < 5, "Too many broken links found: " + brokenCount);
    }
}
