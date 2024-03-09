package Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class listManagementObjects {

	@FindBy(xpath="//a[contains(text(),'Campaign Management')]")
	public static WebElement campaignManagementButton; 
	@FindBy(xpath="(//a[contains(text(),'Interface Management')])[3]")
	public static WebElement interfaceManagementButton; 
	@FindBy(xpath="(//a[contains(text(),'List Management')])[2]")
	public static WebElement listManagementButton; 	
	@FindBy(xpath="//*[@id=\"Search_List_Management_search\"]/span/button")
	public static WebElement SearchButton;
	
		
	@FindBy(xpath="(//div[contains(text(),'Product Type')])[1]")
	public static WebElement productTypeButton;
	
	@FindBy(xpath="//*[@id=\"Search_List_Management_mod\"]/span/button")
	public static WebElement ModifyButton;
	
	
	
	@FindBy(xpath="//*[@id=\"List_Management_Product_Type_add\"]/span/button")
	public static WebElement AddproductButton;
	
	
	@FindBy(id="List_Management_Product_Type_cfg_lang")
	public static WebElement LanguageSelect;
	
	@FindBy(id="List_Management_Product_Type_cfg_desc")
	public static WebElement ProductNameInput;
	
	@FindBy(id="List_Management_Product_Type_cfg_value")
	public static WebElement ProductValueInput;
	
	@FindBy(id="List_Management_Product_Type_cfg_incominglabel")
	public static WebElement ProductIncomingLabelInput;
	
	@FindBy(xpath="//*[@id=\"List_Management_Product_Type_syslabel_cfg_submit\"]/span/button")
	public static WebElement okProductTypeButton;
	
	
	@FindBy(xpath="//*[@id=\"label\"]")
	public static WebElement productTypeSearchInput;
	
	@FindBy(xpath="//*[@id=\"List_Management_Product_Type_search\"]/span/button")
	public static WebElement productTypeSearchButton;
	

}
