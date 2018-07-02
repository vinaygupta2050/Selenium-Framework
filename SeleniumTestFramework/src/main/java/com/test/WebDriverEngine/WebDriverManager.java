package com.test.WebDriverEngine;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverManager {

	protected static WebDriver createInstance() throws MalformedURLException
	{
		WebDriver dr;
		dr= new RemoteWebDriver(new URL(getHubUrl()),getDesiredCapabilities());	
		return dr;
	}
	
	private static DesiredCapabilities getDesiredCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		capabilities.setVersion("67");
		return capabilities;
	}
	
	private static String getHubUrl()
	{
		String hubUrl="http://127.0.0.1:4454/wd/hub";
		return hubUrl;
	}
}
