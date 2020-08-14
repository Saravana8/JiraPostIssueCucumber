package com.utilities;

public enum APIResources {
	
	createJiraIssue("/rest/api/2/issue"),
	getJiraIssue("/rest/api/2/search"),
	updateJiraIssue("/rest/api/2/issue"),
	deleteJiraIssue("/rest/api/3/issue");
	
	String resource;
	
	APIResources(String resource){
		this.resource=resource;
		
	}
	
	public String getResource() {
		return resource;
		

	}
	
	
	

}
