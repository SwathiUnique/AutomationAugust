package com.examAPI.tests.bases;

import static org.hamcrest.Matchers.containsString;

import org.hamcrest.Matchers;

import com.APIExam.test.DeletePojo;
import com.examAPI.POJOS.CreatePojo;
import com.examAPI.Utilities.projectUtilities;

import groovy.transform.ToString;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class ReusableMethods {
	public static String url;
	public static String username;
	public static String password;
	public static projectUtilities fileObject = new projectUtilities();

	public static String getUrl() {
		url = fileObject.getPropertyValue("urikey","baseURI"); 
		return url;
	}
	
	public static CreatePojo setCreateData() {
		String name = fileObject.getPropertyValue("name","createDetails");
		String salary = fileObject.getPropertyValue("salary","createDetails");
		String age = fileObject.getPropertyValue("age","createDetails");
		CreatePojo createDetails = new CreatePojo();
		createDetails.setName(name);
		createDetails.setSalary(salary);
		createDetails.setAge(age);
		return createDetails;
	}
	/*public static void getReadData(Response response) {
		String accNo = fileObject.getPropertyValue("accountno","createDetails");
		ReadPojo[] readDetails = response.as(ReadPojo[].class); 
		for(int i=0;i<readDetails.length;i++) {
			if((readDetails[i].getAccountno()).equalsIgnoreCase(accNo)) {
				fileObject.setProperty("departmentno", "1","updateDetails");
				fileObject.setProperty("userid",readDetails[i].getUserid(),"updateDetails");
				fileObject.setProperty("id",readDetails[i].getId(),"updateDetails");
				break;
			}
		}
	}
	public static UpdatePojo updateData() {
		String depNo = fileObject.getPropertyValue("departmentno","updateDetails");

		String id = fileObject.getPropertyValue("id","updateDetails");
		String userid = fileObject.getPropertyValue("userid","updateDetails");
		UpdatePojo updateData = new UpdatePojo();
		updateData.setDepartmentno(depNo);

		updateData.setId(id);
		updateData.setUserid(userid);
		return updateData ;
	}*/
	/*public static DeletePojo deleteData() {
		String id = fileObject.getPropertyValue("id","updateDetails");
		String userid = fileObject.getPropertyValue("userid","updateDetails");
		DeletePojo deleteDetails = new DeletePojo();
		deleteDetails.setId(id);
		deleteDetails.setUserid(userid);
		return deleteDetails ;
	}*/
	public static void verifyStatusCode(Response response, int statusCode) {
		response.then().statusCode(statusCode);
	}
	public static void validateStatusCode(Response response, String status) {
		response.then().body("status", Matchers.equalTo(status));
	}
	public static void validateContentType(Response response,String contentType) {
		response.then().contentType(ContentType.JSON);
	}
	public static void validateDataSize(Response response) {
		int noOfEmployees = response.jsonPath().getInt("data.size()");
		System.out.println("Number of employees are "+noOfEmployees);
	}
	public static void validateCreateData(Response response) {
		response.then().assertThat().body(containsString(fileObject.getPropertyValue("name","createDetails")));
	}
	/*public static void logHeaders(Response response) {
		response.then().log().headers();
	}*/
}
