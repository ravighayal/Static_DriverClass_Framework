package Test_Classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.Patch_API_Method;
import RequestRepository.Patch_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Patch_TC1 {

	public static void extractor() {
		
		int statusCode = Patch_API_Method.ResponseStatusCode(Patch_Req_Repository.BaseURI(),
				         Patch_Req_Repository.Patch_Resource(), Patch_Req_Repository.Patch_TC1());
		System.out.println(statusCode);
		
		String ResponseBody = Patch_API_Method.ResponseBody(Patch_Req_Repository.BaseURI(), 
				              Patch_Req_Repository.Patch_Resource(), Patch_Req_Repository.Patch_TC1());
		System.out.println(ResponseBody);
		
		JsonPath JspResponse = new JsonPath(ResponseBody);
		String Res_name=JspResponse.getString("name");
		String Res_job=JspResponse.getString("job");
		Assert.assertEquals(Res_name, "Ravi");
		Assert.assertEquals(Res_job, "Software Tester");
	}
	
}