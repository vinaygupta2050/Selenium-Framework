package com.test.listeners;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.test.WebDriverEngine.WebDriverFactory;
public class MethodInvocationListener implements ITestListener{

	@Override
	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		System.out.println("Inside OnFinish");
		WebDriverFactory.getDriver().quit();
	}

	@Override
	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Inside onStart");
			WebDriverFactory.setDriver();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		File screenSot= ((TakesScreenshot)WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		ITestNGMethod method = result.getMethod();
		try {
			FileUtils.copyFile(screenSot, new File("D:\\"+result.getInstanceName()+"."+method.getMethodName()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		File screenSot= ((TakesScreenshot)WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		ITestNGMethod method = result.getMethod();
		try {
			FileUtils.copyFile(screenSot, new File("D:\\"+result.getInstanceName()+"."+method.getMethodName()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	

}
