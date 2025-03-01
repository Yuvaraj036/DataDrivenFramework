package com.hutech.utilities;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hutech.base.TestBase;

public class ExtentManager  {
	
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest	
	public void setReport()
	{
		
		htmlReporter=new ExtentSparkReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation script Reports");
		htmlReporter.config().setReportName("Automation Test results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("automation tester", "yuvaraj");
		extent.setSystemInfo("Organization", "Hutech");
	}
	
	@AfterTest
	public void endreport()
	{
		extent.flush();
	}
	
	
	//@Test
	public void doLogin()
	{
		
		test=extent.createTest("Login Test");
	}
	
	//@Test
	public void doFail()
	{
		test=extent.createTest("User Test");
		Assert.fail("User Test failed");
	}
	
	//@Test
	public void isSkip()
	{
		test=extent.createTest("skip test");
		throw new SkipException("Skipped the test case");
	}

	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String methodName=result.getMethod().getMethodName();
			
		}else if(result.getStatus()==ITestResult.SKIP)
		{
			String methodName=result.getMethod().getMethodName();
			
		}else if(result.getStatus()==ITestResult.SUCCESS)
		{
		String methodName=result.getMethod().getMethodName();
		
		}
		
	}
	
	

}
