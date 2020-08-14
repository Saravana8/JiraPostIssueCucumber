package com.stepdef;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksClass {

	@Before("@UpdateJiraissue or @Deleteissue")
	public void beforeScenario() throws IOException, ParseException {
		if(StepDefinitionClass.issueId == null) {
		StepDefinitionClass steps = new StepDefinitionClass();
		steps.add_payload_for_create_the_issue("user unable to verify login functionality", "login button not working properly");
		steps.user_should_call_with_http_request("createJiraIssue", "Post");
		}

	}
    
	@After
	public void afterScenario() {

	}

}
