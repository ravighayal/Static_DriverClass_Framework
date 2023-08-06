package Test_Classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.User_API_Methods;
import RequestRepository.Post_Create_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Post_TC2 {

 public static void extractor() {
		
	int statusCode = User_API_Methods.ResponseStatusCode(Post_Create_Req_Repository.BaseURI(),
			         Post_Create_Req_Repository.Post_Resource(), Post_Create_Req_Repository.Post_TC2());
	 System.out.println(statusCode);
		
	String ResponseBody = User_API_Methods.ResponseBody(Post_Create_Req_Repository.BaseURI(), 
			              Post_Create_Req_Repository.Post_Resource(), Post_Create_Req_Repository.Post_TC2());
		System.out.println(ResponseBody);
		
		JsonPath JspResponse = new JsonPath(ResponseBody);
		String Res_name=JspResponse.getString("name");
		String Res_job=JspResponse.getString("job");
		Assert.assertEquals(Res_name, "Ravi");
		Assert.assertEquals(Res_job, "Software Tester");
	}
}

