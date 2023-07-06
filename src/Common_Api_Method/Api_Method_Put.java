package Common_Api_Method;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Api_Method_Put {
	
	public static int ResponseStatusCode(String BaseURI, String Resource, String requestBody) {
		RestAssured.baseURI = BaseURI; 
		
		int StatusCode = given().header("Content-Type","application/json").body(requestBody).
			when().put(Resource).then().extract().statusCode();
		
		return StatusCode;
	}
	
	public static String Response_Body(String BaseURI, String Resource, String requestBody) {
		RestAssured.baseURI = BaseURI; 
		
		String ResponseBody = given().header("Content-Type","application/json").body(requestBody).
			when().put(Resource).then().extract().asString();
		
		return ResponseBody;
	}

}
