package com.examAPI.tests.bases;

import org.testng.annotations.BeforeClass;


import com.examAPI.POJOS.Data;
import com.examAPI.POJOS.GPojo;
import com.examAPI.constants.EndURIs;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BaseTestMethods {
    
	public static Response response = null;
	public static int id;
	//public static TekExtentReports report = null;
		
	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI=ReusableMethods.getUrl();
	}	
	public static Response getMethod() {
		Response response = RestAssured
				.given()
				.contentType(ContentType.TEXT)
				.when()
				.get(EndURIs.GET_DATA);
		/*GPojo object = new GPojo();
		GPojo[] list = response.as(GPojo[].class);
		for(int i=0;i<list.length;i++) {
			
			object.setId(list[i].getId());
			object.setEmployee_name(list[i].getEmployee_name());
			object.setEmployee_salary(list[i].getEmployee_salary());
			object.setEmployee_age(list[i].getEmployee_age());
			object.setProfile_image(list[i].getProfile_image());
		}*/
		return response;
	}
	public static Response createMethod() {
		Response response = RestAssured 
				.given()
				.contentType(ContentType.JSON)
				.body(ReusableMethods.setCreateData())
				.when()
				.post(EndURIs.CREATE_DATA);
		response.then().contentType(ContentType.JSON);
		id = response.jsonPath().get("$.data.id");
		System.out.println(id);
		Data object = response.as(Data.class);
		object.getAdditionalProperties().get(object);
		System.out.println(object.getData());
		return response;
	}
	public static Response readMethod() {
	
		Response response = RestAssured
				.given()
				.when()
				.contentType(ContentType.JSON)
				.get(EndURIs.GET_DATA_ID);
				return response;
		}	
		
		public static Response deleteMethod() {
			
			String did = String.valueOf(id);
			Response response = RestAssured 
					.given().log().all(true)
					.contentType(ContentType.JSON)
					.when()
					.delete(EndURIs.DELETE_DATA+"/"+did); 
					response.prettyPrint();
					return response;
		}
		public static Response deleteMethodID() {
			Response response = RestAssured 
					.given().log().all(true)
					.contentType(ContentType.JSON)
					.when()
					.delete(EndURIs.DELETE_DATA+"/0"); 
					return response;
		}

	}
