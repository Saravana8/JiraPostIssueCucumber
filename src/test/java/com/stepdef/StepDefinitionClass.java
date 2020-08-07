package com.stepdef;



import org.testng.AssertJUnit;

import com.pages.Output;
import com.pages.PayLoad;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class StepDefinitionClass {

	RequestSpecification requestSpec;
	Response response;

	@Given("Add payload for create the issue {string},{string}")
	public void add_payload_for_create_the_issue(String summary, String description) {
		PreemptiveBasicAuthScheme scheme = new PreemptiveBasicAuthScheme();
		scheme.setUserName("saravanak49@gmail.com");
		scheme.setPassword("pp55hhm6zINySZ3VflJX0E20");

		requestSpec = new RequestSpecBuilder().setBaseUri("https://sarvan231.atlassian.net")
				.setContentType(ContentType.JSON).setAuth(scheme).build();

		requestSpec = RestAssured.given().log().all().spec(requestSpec).body(PayLoad.jiraCreateIssue(summary, description));

	}

	@When("User should call the API create issue with post http request")
	public void user_should_call_the_API_create_issue_with_post_http_request() {

		response = requestSpec.when().post("/rest/api/2/issue/");

	}

	@Then("User should verify the response code should be {int}")
	public void user_should_verify_the_response_code_should_be(int statusCode) {
		
		AssertJUnit.assertEquals("verifying statuscode",statusCode, response.getStatusCode());

	}

	@Then("User should verify the response body should contains {string}")
	public void user_should_verify_the_response_body_should_contains(String expValue) {
		
		Output resBody = response.as(Output.class);
		AssertJUnit.assertTrue("verifying created msg is present", resBody.getSelf().contains(expValue));
	    
	}

}
