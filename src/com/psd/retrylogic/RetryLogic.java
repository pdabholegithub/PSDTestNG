package com.psd.retrylogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer {
	int initialcount = 0;
	int retrytimes = 2;
	@Override
	public boolean retry(ITestResult result) {
		if (initialcount < retrytimes) {
			initialcount++;
			return true; // retry
		}
		return false;// don't retry
	}

}
