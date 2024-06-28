package com.tests.runners;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {"src/test/resources/SalesforceLogin.feature"},
		glue = {"com.tests.simple"}
	
		
		)



public class Runners  extends AbstractTestNGCucumberTests{
	

}
