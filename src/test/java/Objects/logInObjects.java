package Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class logInObjects {
	
	@FindBy(id="uid")
	public static WebElement usernameInput;
	
	@FindBy(id="pwd")
	public static WebElement passwordInput;
	
	@FindBy(id="submit")
	public static WebElement submitButton;
}
