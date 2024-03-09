package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Objects.logInObjects;

public class commonFunctions {
	public static Properties prop;
	public static WebDriver driver;
	static Logger log = Logger.getLogger(commonFunctions.class);
	
	public static Properties LoadPropertyFile() throws IOException {
		FileInputStream fileinput = new FileInputStream(System.getProperty("user.dir")+"//config//config.properties");
		prop = new Properties();
		prop.load(fileinput);
		return prop;
		
		
	
	}
	
	@BeforeSuite
	public void LaunchBrowser() throws IOException {
		LoadPropertyFile();
		log.info("===========================");
		log.info("===== CLMS List management test case started ====");
		PropertyConfigurator.configure(System.getProperty("user.dir")+"//config/log4j.properties");
		String url =prop.getProperty("url");
		String browser =prop.getProperty("browser");
		String username =prop.getProperty("username");
		String password =prop.getProperty("password");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chrome_latest\\chromedriver.exe");
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(opt);
			log.info("===== Choosed Chrome Browser ====");
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\\\Selenium\\\\drivers\\\\chrome_latest\\\\chromedriver.exe");
			driver = new FirefoxDriver();
			log.info("===== Choosed Firefox browser ====");
		}
		driver.navigate().to(url);
		log.info("===== Logged in to Url : "+url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		PageFactory.initElements(driver, logInObjects.class);
		logInObjects.usernameInput.sendKeys(username);
		logInObjects.passwordInput.sendKeys(password);
		logInObjects.submitButton.click();
	}
	
	@AfterSuite
	public void quitBrowser() {
		driver.quit();
		
	}

}
