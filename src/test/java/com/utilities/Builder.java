package com.utilities;

import java.io.IOException;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Builder {
	public static RequestSpecification getBuilder() throws IOException {

		PreemptiveBasicAuthScheme scheme = new PreemptiveBasicAuthScheme();
		scheme.setUserName(UtilityClass.getData("username"));
		scheme.setPassword(UtilityClass.getData("password"));

		RequestSpecification req = new RequestSpecBuilder().setBaseUri(UtilityClass.getData("Baseuri"))
				.setContentType(ContentType.JSON).setAuth(scheme).build();
		return req;

	}

}
