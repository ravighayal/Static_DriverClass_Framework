package Test_Classes;

import org.testng.annotations.Test;

import Common_API_Methods.Get_API_Method;
import RequestRepository.Get_Req_Repository;

public class Get_TC1 {

	public static void extractor() {
		
		int statusCode = Get_API_Method.ResponseStatusCode(Get_Req_Repository.BaseURI(), Get_Req_Repository.Get_Resource());
		System.out.println(statusCode);
		
		String ResponseBody = Get_API_Method.ResponseBody(Get_Req_Repository.BaseURI(), Get_Req_Repository.Get_Resource());
		System.out.println(ResponseBody);
		
	}
}
