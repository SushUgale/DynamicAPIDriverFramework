package Test_Class;

import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_Api_Method.Api_Method_Post;
import Common_Api_Method.Common_Utility_Method;

import Request_Repository.Post_Request_Repository;
import io.restassured.path.json.JsonPath;

public class Post_Tc1 {
	
	
	public static void extractor() throws IOException
	{
		for(int i = 0; i<5; i++){
			    int statusCode = Api_Method_Post.ResponseStatusCode(Post_Request_Repository.BaseURI(),
			    Post_Request_Repository.post_Resource(),Post_Request_Repository.post_Req_TC1());
		    if (statusCode==201){
		    	//System.out.println(statusCode);
		    	String responseBody = Api_Method_Post.Response_Body
		    	(Post_Request_Repository.BaseURI(),
		    	Post_Request_Repository.post_Resource(),
		    	Post_Request_Repository.post_Req_TC1());
		    	//System.out.println(responseBody);

		    	String requestBody = Post_Request_Repository.post_Req_TC1();
		    	Common_Utility_Method.EvidenceFileCreator("Post_Tc1", requestBody, responseBody, statusCode);
		    	Validation(requestBody, responseBody);
		        break;
		     
		    } else {
			System.out.println("incorrect status code");
		    }
		  }
	}
	

        public static void Validation (String Request, String Response) {
        	JsonPath jspRequest = new JsonPath(Request);
    		String req_name = jspRequest.getString("name");
    		String req_job = jspRequest.getString("job");
    		LocalDateTime currentdate = LocalDateTime.now();
    		String expectedDate = currentdate.toString().substring(0, 10);
    		
    	    JsonPath jspResponse = new JsonPath(Response);
		    String res_name = jspResponse.getString("name");
		    String res_job = jspResponse.getString("job");
		    int res_id = jspResponse.getInt("id");
		    //System.out.println(res_name);
		   //System.out.println(res_job);
		    //System.out.println(res_id);
		    
		    String res_createdAt = jspResponse.getString("createdAt");
		    res_createdAt = res_createdAt.substring(0,10);
		   // System.out.println(res_createdAt);
		    
		    Assert.assertEquals(res_name, req_name);
		    Assert.assertEquals(res_job, req_job);
		    Assert.assertNotNull(res_id);
		    Assert.assertNotEquals(0, res_id);
		    Assert.assertEquals(res_createdAt, expectedDate);
		}
}


