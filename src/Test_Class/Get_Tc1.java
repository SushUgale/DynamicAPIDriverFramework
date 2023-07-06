package Test_Class;

import Common_Api_Method.Api_Method_Get;
import Request_Repository.Get_Request_Repository;

public class Get_Tc1 {
	public static void extractor() {

		int statusCode = Api_Method_Get.ResponsestatusCode(Get_Request_Repository.BaseURI(),
				Get_Request_Repository.Get_Resource());

		System.out.println(statusCode);

		String ResponseBody = Api_Method_Get.ResponseBody(Get_Request_Repository.BaseURI(),
				Get_Request_Repository.Get_Resource());

		System.out.println(ResponseBody);

	}

}
