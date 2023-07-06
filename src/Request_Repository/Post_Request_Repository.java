package Request_Repository;

import java.io.IOException;
import java.util.ArrayList;

import Common_Api_Method.Common_Utility_Method;

public class Post_Request_Repository {
	public static String BaseURI() {
		String BaseURI = "https://reqres.in/";
		return BaseURI;
			
		}
		
		public static String post_Resource(){
			String Resource = "api/users";
			return Resource;
		}
		
		public static String post_Req_TC1() throws IOException{
			ArrayList <String> Req_Data = Common_Utility_Method.ReadDataExcel("PostAPI", "TC2");
		
			
			System.out.println(Req_Data);
			String req_name = Req_Data.get(1);
			String req_job = Req_Data.get(2);
			
			String requestBody = "{\r\n"
					+ "    \"name\": \""+req_name+"\",\r\n"
					+ "    \"job\": \""+req_job+"\"\r\n"
					+ "}";
		return requestBody;
		}


}
