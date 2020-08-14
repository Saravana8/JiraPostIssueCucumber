package com.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReports {

	public static void generateCucumberReorts(String jsonFile) {

		Configuration con = new Configuration(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Reports"),
				"Jira Account Validations");
		
		con.addClassifications("OS", "Windows 10");
		con.addClassifications("Browser", "Chrome");
		con.addClassifications("Environment", "UAT");
		
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		
		ReportBuilder builder = new ReportBuilder(jsonFiles, con);
		builder.generateReports();
	}

}
