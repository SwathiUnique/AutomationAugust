package com.examAPI.tests.EndToEnd;

import org.testng.annotations.Test;

import com.examAPI.tests.bases.BaseTestMethods;
import com.examAPI.tests.bases.ReusableMethods;

import io.restassured.response.Response;

public class EndToEndTestcases extends BaseTestMethods{
	@Test(priority=1)
	public static void getData_TC01() {
		Response response = getMethod();
		ReusableMethods.verifyStatusCode(response,200);
		ReusableMethods.validateStatusCode(response, "success");
		ReusableMethods.validateDataSize(response);

	}
	@Test(priority=2)
	public static void create_TC02() {
		Response response = createMethod();
		ReusableMethods.verifyStatusCode(response,200);
		ReusableMethods.validateStatusCode(response, "success");
		ReusableMethods.validateCreateData(response);
		/*verify the name,salary and age data from response is as same as in the request
		extract the id,print it to console and store it to send to next requests.*/
	}
	@Test(priority=3)
	public static void delete_TC03() {
		Response response = deleteMethod();
		ReusableMethods.verifyStatusCode(response,200);
		ReusableMethods.validateStatusCode(response, "success");
		//id which you have entered in the path parameter is same as in the response
		//fetch the message data and print it to console
	}
	@Test(priority=4)
	public static void deleteID0_TC04() {
		Response response = deleteMethodID();
		ReusableMethods.verifyStatusCode(response,400);
		ReusableMethods.validateStatusCode(response, "error");
	}
	@Test(priority=5)
	public static void getDataID2_TC05() {
		Response response = readMethod();
		ReusableMethods.verifyStatusCode(response,200);
		ReusableMethods.validateContentType(response,"contentType");
		
		}
}	
