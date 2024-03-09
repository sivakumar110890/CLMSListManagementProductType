package testSuite;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Objects.listManagementObjects;
import commonFunctions.commonFunctions;

public class TC_01_ListManagement_productAdd extends commonFunctions{
	static Logger log = Logger.getLogger(TC_01_ListManagement_productAdd.class);	

	public void ListmanagementNavigation() {
		PageFactory.initElements(driver, listManagementObjects.class);
		listManagementObjects.campaignManagementButton.click();
		listManagementObjects.interfaceManagementButton.click();
		listManagementObjects.listManagementButton.click();
		listManagementObjects.SearchButton.click();
	}
	public void productTypeAdd() {
		listManagementObjects.productTypeButton.click();
		listManagementObjects.ModifyButton.click();
		listManagementObjects.AddproductButton.click();

	}
	public void SelectLanguageFrench() {
		Select selectLanguage = new Select(listManagementObjects.LanguageSelect);
		selectLanguage.selectByVisibleText("French");

		listManagementObjects.ProductNameInput.sendKeys("OPENET_"+prop.getProperty("productId"));
		listManagementObjects.ProductValueInput.sendKeys(prop.getProperty("productId"));
		listManagementObjects.ProductIncomingLabelInput.sendKeys(prop.getProperty("productId"));

	}

	public void SelectLanguageEnglish() {
		Select selectLanguageEng = new Select(listManagementObjects.LanguageSelect);
		selectLanguageEng.selectByVisibleText("English");
		listManagementObjects.ProductNameInput.sendKeys("OPENET_"+prop.getProperty("productId"));
	}

	public void SelectLanguageKikongo() {
		Select selectLanguageKikongo = new Select(listManagementObjects.LanguageSelect);
		selectLanguageKikongo.selectByVisibleText("Kikongo");
		listManagementObjects.ProductNameInput.sendKeys("OPENET_"+prop.getProperty("productId"));
	}

	public void SelectLanguageSwahili() {
		Select selectLanguageSwahili = new Select(listManagementObjects.LanguageSelect);
		selectLanguageSwahili.selectByVisibleText("Swahili");
		listManagementObjects.ProductNameInput.sendKeys("OPENET_"+prop.getProperty("productId"));
	}

	public void SelectLanguageLingala() {
		Select selectLanguageLingala = new Select(listManagementObjects.LanguageSelect);
		selectLanguageLingala.selectByVisibleText("Lingala");
		listManagementObjects.ProductNameInput.sendKeys("OPENET_"+prop.getProperty("productId"));
	}

	public void SelectLanguageTshiluba() {
		Select selectLanguageTshiluba = new Select(listManagementObjects.LanguageSelect);
		selectLanguageTshiluba.selectByVisibleText("Tshiluba");
		listManagementObjects.ProductNameInput.sendKeys("OPENET_"+prop.getProperty("productId"));
		listManagementObjects.okProductTypeButton.click();
	}


	public void ProductSearch() throws IOException, InterruptedException {
		log.info(" == Product id search test beginning == ");
		Thread.sleep(5000);
		listManagementObjects.productTypeSearchInput.sendKeys("OPENET_"+prop.getProperty("productId"));
		listManagementObjects.productTypeSearchButton.click();

		log.info(" == Product id search test end == ");
	}
	public void TakeaScreenshotAfterProductSearch() throws IOException {
		TakesScreenshot takescreenshot = (TakesScreenshot)driver;
		File Source = takescreenshot.getScreenshotAs(OutputType.FILE);
		File Destination = new File(System.getProperty("user.dir")+"//screenshot//TC_01_Product_Type.png");
		FileHandler.copy(Source, Destination);



	}
	@Test(dataProvider = "testData")
	public void testExecutionproductTypeAdd() throws IOException, InterruptedException {
		ListmanagementNavigation();
		productTypeAdd();
		SelectLanguageFrench();
		SelectLanguageEnglish();
		SelectLanguageKikongo();
		SelectLanguageLingala();
		SelectLanguageSwahili();
		SelectLanguageTshiluba();
		ProductSearch();
		TakeaScreenshotAfterProductSearch();
	}
	


}
