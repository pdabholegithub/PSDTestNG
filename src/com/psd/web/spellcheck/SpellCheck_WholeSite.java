package com.psd.web.spellcheck;

import java.util.List;

import org.languagetool.*;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpellCheck_WholeSite {

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.igfindia.org");
        driver.manage().window().maximize();

        // Collect all visible text
        List<WebElement> elements = driver.findElements(By.xpath("//*[not(self::script or self::style)]"));
        StringBuilder allText = new StringBuilder();

        for (WebElement e : elements) {
            if (e.isDisplayed()) {
                allText.append(e.getText()).append(" ");
            }
        }

        // Initialize spell checker
        JLanguageTool langTool = new JLanguageTool(new AmericanEnglish());
        List<RuleMatch> matches = langTool.check(allText.toString());

        if (matches.isEmpty()) {
            System.out.println("✅ No spelling errors found!");
        } else {
            System.out.println("❌ Found spelling issues:");
            for (RuleMatch match : matches) {
                System.out.println("Error: " + allText.substring(match.getFromPos(), match.getToPos()));
                System.out.println("Suggestion: " + match.getSuggestedReplacements());
            }
        }

        driver.quit();
    }
}
