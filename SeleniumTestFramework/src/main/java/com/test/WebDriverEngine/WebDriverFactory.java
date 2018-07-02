package com.test.WebDriverEngine;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

	public static  WebDriver driver;

	public static WebDriver getDriver() {
		return  driver;
	}

	public static void setDriver() throws MalformedURLException {
		
		driver = WebDriverManager.createInstance();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}
	
}
