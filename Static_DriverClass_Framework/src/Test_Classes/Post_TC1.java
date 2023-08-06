package Test_Classes;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common_API_Methods.API_Methods;
import RequestRepository.Post_Req_Repository;
import RequestRepository.Post_Retry_Repository;
import io.restassured.path.json.JsonPath;

public class Post_TC1 {
 
	public static void extractor() {
		
		int statusCode = API_Methods.ResponseStatusCode(Post_Req_Repository.BaseURI(), Post_Req_Repository.Post_Resource(), 
				         Post_Req_Repository.Post_Req_TC1());
		System.out.println(statusCode);
		
		String ResponseBody = API_Methods.ResponseBody(Post_Req_Repository.BaseURI(), Post_Req_Repository.Post_Resource(), 
				              Post_Req_Repository.Post_Req_TC1());
		System.out.println(ResponseBody);
		
		JsonPath JspResponse = new JsonPath(ResponseBody);
		String Res_token=JspResponse.getString("token");
		Assert.assertEquals(Res_token, "QpwL5tke4Pnpja7X4");
	}
}
