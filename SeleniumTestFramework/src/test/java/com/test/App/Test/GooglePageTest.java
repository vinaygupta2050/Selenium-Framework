package com.test.App.Test;
import org.testng.annotations.Test;
import com.test.App.Pages.GoogleHomePage;
import com.test.utils.ExcelDataProvider;

public class GooglePageTest {

	@Test(testName="verifyGoogleSearchFunctionality",description = "Verify Google Search Feature",enabled=false)
	public void verifyGoogleSearchFunctionality() {
		GoogleHomePage googlePage = new GoogleHomePage();
		googlePage.launchGoogleApp().enterSearchQuery("facebook").clickOnSearchButton();

	}
	
	@Test(dataProvider="excelDataProvider",dataProviderClass = ExcelDataProvider.class,enabled=true)
	public void testDataProvider(String name,String mobile,String SurName) {
		System.out.println(name+"|"+mobile+"|"+SurName);

	}
}
