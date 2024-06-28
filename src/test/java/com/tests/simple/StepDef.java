package com.tests.simple;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.automation.pages.ForgotPasswordPage;
import com.automation.pages.LoginPage;
import com.automation.pages.SalesforceHomePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StepDef {
	WebDriver driver;
	protected static Logger mylog=LogManager.getLogger(StepDef.class);
	LoginPage login;
	SalesforceHomePage home;
	ForgotPasswordPage fpage;
	Alert alert;
	public void launchBrowser(String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			mylog.info("chrome browser instance chrome created.");
			mylog.info("chrome browser instance chrome created.");
		
			driver.manage().window().maximize();
			mylog.info("window is maximized");
			
			
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			mylog.info("firefox browser instance chrome created.");
		
			driver.manage().window().maximize();
			mylog.info("window is maximized");
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			mylog.info("edge browser instance chrome created.");
			driver.manage().window().maximize();
			mylog.info("window is maximized");
			break;

		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			driver.manage().window().maximize();
			break;

		

		default:
			mylog.error("Unsupported browser: " + browserName);
		}


	}
	public void goToUrl(String url) throws InterruptedException {
		driver.get(url);
		mylog.info(url + "is entered");
		
		
	}
	
	public void closeBrowser() {
		driver.close();
		mylog.info("browser instance closed");
		driver=null;
	}
	@Before
	public void setUpEachScenario() {
		
		launchBrowser("chrome");
		
	}
	
	
	public void tearDown() {
		closeBrowser();
	}
	
	@Given("the url {string}")
	public void the_url(String url) throws InterruptedException {
		goToUrl(url); 
	}

	@When("i land in {string}")
	public void i_land_in(String pageName) {
		if(pageName.equalsIgnoreCase("loginpage")) {
			login=new LoginPage(driver);		
			
		}
		else if(pageName.equalsIgnoreCase("SalesforceHomePage")) {
			home=new SalesforceHomePage(driver);
		}
		else if(pageName.equalsIgnoreCase("ForgotPasswordPage")) {
			 fpage=new ForgotPasswordPage(driver);
		}
	    
	}

	

	@When("i enter the username as {string}")
	public void i_enter_the_username_as(String string) {
	 login.enterUserName(string);
	}

	@When("i clear the password")
	public void i_clear_the_password() {
	    login.clearPassword();
	}

	@When("i click on the button")
	public void i_click_on_the_button() {
	  login.clickLoginButton();
	}

	@Then("i should see the error msg")
	public void i_should_see_the_error_msg() {
	 System.out.print("Error msg displayed");
	}

	@When("i enter the password as {string}")
	public void i_enter_the_password_as(String string) {
	   login.enterPwd(string);
	}
	@When("i click on the rememberme checkbox")
	public void i_click_on_the_rememberme_checkbox() {
	 login.checkRememberMe();
	 
	}
	@When("i click on Usermenudropdown")
	public void i_click_on_usermenudropdown() {
	   home.clickuserNameDropdown();
	}

	@When("i click on Logout")
	public void i_click_on_logout() {
	   home.userNameDropdown("Logout");
	}


@When("i click forgotPassword")
public void i_click_forgot_password() {
   login.clickForgotPwd();
}

@When("i enter the username in forgotPage as {string}")
public void i_enter_the_username_in_forgot_page_as(String string) {
    fpage.enterUserName("radhi@company.sandbox");
}

@When("i click Continue")
public void i_click_continue() {
   fpage.clickContinue();
}



	





}
