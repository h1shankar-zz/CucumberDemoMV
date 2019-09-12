package steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;

import base.BaseSetup;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsDef extends BaseSetup {
	Properties prop;
	BaseSetup b;

	@Before
	public void getSetup() throws FileNotFoundException, IOException {
	System.out.println("base setup method executed");
		
		b = new BaseSetup();
		b.baseSetup1();
	}
	@Given("^Open the Chrom and launch the application$")
	public void open_the_Chrom_and_launch_the_application() throws IOException, InterruptedException {
		prop = b.getPropertyData();
		String u = prop.getProperty("url");
		System.out.println("uri  " + u);
		b.driver.get(u);
		Thread.sleep(1000);

	}

	@When("^open blog center$")
	public void open_blog_center() {
		System.out.println(" in open_blog_center");
	}

	@Then("^count the number of blog available$")
	public void count_the_number_of_blog_available() {
		System.out.println("in count_the_number_of_blog_available");

		JavascriptExecutor js = (JavascriptExecutor) b.driver;
		String sText = js.executeScript("document.title;").toString();
		System.out.println("titl  "+sText);
	}

	@After
	public void tearDown() {
		System.out.println("in tearDown");
		b.driver.quit();
	}
}
