package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseSetup {
	public WebDriver driver;
	public WebDriverWait wait = null;

	public void baseSetup1() throws FileNotFoundException, IOException {

		System.out.println("Initiating Test for Crome");
		System.setProperty("webdriver.chrome.driver", "D:\\Browsers\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 60);
		driver.manage().window().maximize();

	}

	public void baseSetup() throws FileNotFoundException, IOException {

		System.out.println("launching firefox browser");
		System.setProperty("webdriver.gecko.driver", "D:\\Browsers\\geckodriver.exe");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 60);
		driver.manage().window().maximize();

	}
	
	public Properties getPropertyData() throws IOException
	{
		FileInputStream fis =new FileInputStream("config.properties");
		Properties prop =new Properties();
		prop.load(fis);
		return prop;
	}
}
