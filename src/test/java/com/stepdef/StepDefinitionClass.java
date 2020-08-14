package com.stepdef;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.AssertJUnit;

import com.pages.Output;
import com.pages.PayLoad;
import com.utilities.APIResources;
import com.utilities.Builder;
import com.utilities.UtilityClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinitionClass extends UtilityClass {

	RequestSpecification requestSpec;
	Response response;
	static String issueId;

	@Given("Add payload for create the issue {string},{string}")
	public void add_payload_for_create_the_issue(String summary, String description) throws IOException {

		requestSpec = RestAssured.given().spec(Builder.getBuilder())
				.body(PayLoad.jiraCreateIssue(summary, description));

	}

	@When("User should call {string} with {string} http request")
	public void user_should_call_with_http_request(String resource, String reqType) throws ParseException {

		APIResources apiResources = APIResources.valueOf(resource);
		String resourceName = apiResources.getResource();

		if (reqType.equals("Get")) {
			response = requestSpec.when().get(resourceName);

		} else if (reqType.equals("Post")) {

			response = requestSpec.when().post(resourceName);
			JSONParser parser = new JSONParser();
			JSONObject j = (JSONObject) parser.parse(response.getBody().asString());
			issueId = (String) j.get("key");
			System.out.println("Issueid is "+issueId);

		} else if (reqType.equals("Put")) {

			response = requestSpec.when().put(resourceName + "/" + issueId);

		} else if (reqType.equals("delete")) {

			response = requestSpec.when().delete(resourceName + "/" + issueId);

		} else {
			System.err.println("No Matches found");
		}

	}

	@Then("User should verify the response code should be {int}")
	public void user_should_verify_the_response_code_should_be(int statusCode) {

		AssertJUnit.assertEquals("verifying statuscode", statusCode, response.getStatusCode());

	}

	@Then("User should verify the response body should contains {string}")
	public void user_should_verify_the_response_body_should_contains(String expValue) {

		Output resBody = response.as(Output.class);
		AssertJUnit.assertTrue("verifying sarvan name is present", resBody.getSelf().contains(expValue));

	}

	@Given("Add payload for update the issue {string},{string}")
	public void add_payload_for_update_the_issue(String summary, String description) throws IOException {
		requestSpec = RestAssured.given().spec(Builder.getBuilder())
				.body(PayLoad.jiraCreateIssue(summary, description));

	}

	@Given("User add the baseuri")
	public void user_add_the_baseuri() throws IOException {

		requestSpec = RestAssured.given().log().all().spec(Builder.getBuilder());

	}

}
