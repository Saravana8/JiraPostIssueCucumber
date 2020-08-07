package com.pages;

public class PayLoad {
	
	public static Input jiraCreateIssue(String summary, String description) {
		
		Issuetype issuetype = new Issuetype();
		issuetype.setName("Bug");

		Project project = new Project();
		project.setKey("MAK");

		Fields fields = new Fields();
		fields.setProject(project);
		fields.setSummary(summary);
		fields.setDescription(description);
		fields.setIssuetype(issuetype);

		Input input = new Input();
		input.setFields(fields);
		return input;
		
	}

}
