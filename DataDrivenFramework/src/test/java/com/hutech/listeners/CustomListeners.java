package com.hutech.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hutech.base.TestBase;

public class CustomListeners implements ITestListener {
	
	
	public void onFinish(ITestContext arg0)
	{
		
	}
	
	
	public void onStart(ITestContext arg0)
	{
		
	}
	
	
	public void onTestFailure(ITestResult arg0)
	{
		try {
			TestBase.CaptureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void onTestSkipped(ITestResult arg0)
	{
		
	}
	
	
	public void onTestStart(ITestResult arg0)
	{
		
	}
	
	public void onTestSuccess(ITestResult arg0)
	{
		
		
		
	}

}
