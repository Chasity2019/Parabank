package cucumberframework.steps;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpenNewAccountSteps {
    private final static String PARABANK_URL = "https://parabank.parasoft.com/parabank/index.htm";
    private final static String USERNAME_XPATH =  "/html/body/div[1]/div[3]/div[1]/div/form/div[1]/input";
    private final static String PASSWORD_XPATH = "/html/body/div[1]/div[3]/div[1]/div/form/div[2]/input";
    
    private final static String USERNAME_ID = "test25";
    private final static String PASSWORD = "test25";
    
	WebDriver driver;

	@Before public void setup() throws IOException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
				"/geckodriver.exe"); this.driver = new FirefoxDriver();
				this.driver.manage().window().maximize();
				this.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}

	@Given("User navigates to the  website")
	public void user_navigates_to_the_website() throws InterruptedException {
		this.driver.get(PARABANK_URL);
		TimeUnit.SECONDS.sleep(1);
	}

	@Given("User enters valid username")
	public void user_enters_valid_username() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		
		this.driver.findElement(By.xpath(USERNAME_XPATH)).sendKeys(USERNAME_ID);
	}

	@Given("User enters valid password")
	public void user_enters_valid_password() {
		this.driver.findElement(By.xpath(PASSWORD_XPATH)).sendKeys(PASSWORD);
	}

	@When("User clicks on the Login button")
	public void user_clicks_on_the_login_button() {
		this.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[3]/input")).click(); 
	}

	@Then("User is taken to home page successfully")
	public void user_is_taken_to_home_page_successfully() {
		WebElement openNewAccountLink = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[1]/a"));
		assertEquals(true, openNewAccountLink.isDisplayed());
	}

	@Given("User clicks on Open New Account button")
	public void user_clicks_on_open_new_account_button() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);

		this.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[1]/a")).click();
	}

	@Given("User selects from the account type drop down {string}")
	public void user_selects_from_the_account_type_drop_down(String accountType) {
		
		Select drpAccountType = new Select  (this.driver.findElement(By.xpath("//*[@id=\"type\"]")));
		drpAccountType.selectByVisibleText(accountType.trim());
	}

	@Given("User selects from the account number drop down {string}")
	public void user_selects_from_the_account_number_drop_down(String accountNumber) throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		Select drpAccountNumber = new Select (this.driver.findElement(By.id("fromAccountId")));
		 
		TimeUnit.SECONDS.sleep(1); 
		
		drpAccountNumber.selectByIndex(0);
		
		//drpAccountNumber.selectByVisibleText(accountNumber.trim());
	}

	@When("User clicks on the Open New Account button")
	public void user_clicks_on_the_open_new_account_button() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
	    
		this.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div/input")).click(); 
	}

	@Then("User is taken to congratulations account opened page successfully {string}")
	public void user_is_taken_to_congratulations_account_opened_page_successfully(String message) {
		WebElement openNewAccountLink = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/h1"));
		assertEquals(openNewAccountLink.getText(), message);
		driver.close();
	}

}
