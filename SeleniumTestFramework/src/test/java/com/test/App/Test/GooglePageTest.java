package com.test.App.Test;
import org.testng.annotations.Test;
import com.test.App.Pages.GoogleHomePage;

public class GooglePageTest {

	@Test(testName="verifyGoogleSearchFunctionality",description = "Verify Google Search Feature")
	public void verifyGoogleSearchFunctionality() {
		GoogleHomePage googlePage = new GoogleHomePage();
		googlePage.launchGoogleApp().enterSearchQuery("facebook").clickOnSearchButton();

	}
}
