package Test_Classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.PUT_API_Method;
import RequestRepository.Put_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Put_TC1 {

	public static void extractor() {
		
		int statusCode = PUT_API_Method.ResponseStatusCode(Put_Req_Repository.BaseURI(), Put_Req_Repository.Put_Resource(), 
				         Put_Req_Repository.Put_TC1());
		System.out.println(statusCode);
		
		String ResponseBody = PUT_API_Method.ResponseBody(Put_Req_Repository.BaseURI(), Put_Req_Repository.Put_Resource(), 
				              Put_Req_Repository.Put_TC1());
		System.out.println(ResponseBody);
		
		JsonPath JspResponse = new JsonPath(ResponseBody);
		String Res_name=JspResponse.getString("name");
		String Res_job=JspResponse.getString("job");
		Assert.assertEquals(Res_name, "Ravi");
		Assert.assertEquals(Res_job, "Software Tester");
	}
}
