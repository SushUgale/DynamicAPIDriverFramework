package Request_Repository;

public class Patch_Request_Repository {
	public static String BaseURI() {
		String BaseURI = "https://reqres.in/";
		return BaseURI;
			
		}
		
		public static String patch_Resource(){
			String Resource = "api/users/2";
			return Resource;
		}
		
		public static String patch_Req_TC1(){
			String requestBody ="{\r\n"
					+ "    \"name\": \"morpheus\",\r\n"
					+ "    \"job\": \"zion resident\"\r\n"
					+ "}";
		return requestBody;
		}

}
