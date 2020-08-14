package com.runner;






import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.utilities.JVMReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = { "src//test//resources" }, glue = {"com.stepdef" }, dryRun = false, monochrome = true, tags = {
				"@GetAllJiraissues" }, plugin = { "json:src\\test\\resources\\Reports\\cucumber.json" })
public class TestRunnerClass  {
	
	@AfterClass
	public static void afterClass() {
	
		 JVMReports.generateCucumberReorts(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\cucumber.json");

	}

}
