package com.test.App.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.test.WebDriverEngine.WebDriverFactory;

public class GoogleHomePage {
	
	@FindBy(xpath="//*[@id=\'lst-ib\']")
	WebElement txtSearchBox;
	
	//input[@name='btnK']
	@FindBy(xpath="//*[@id=\'lst-ib\']")
	WebElement btnSearch;
	
	public GoogleHomePage()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(),this);
	}
	
	public GoogleHomePage launchGoogleApp()
	{
		WebDriverFactory.getDriver().get("http://www.google.com");
		return this;
	}
	public GoogleHomePage enterSearchQuery(String query)
	{
		System.out.println("Entering Search Query as :"+query);
		txtSearchBox.sendKeys(query);
		return this;	
	}
	
	public GoogleHomePage clickOnSearchButton()
	{
		btnSearch.click();
		return this;	
	}
}
