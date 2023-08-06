package Test_Classes;

import java.time.LocalDateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.User_API_Methods;
import RequestRepository.Post_Create_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Post_Copy {

 public static void extractor() {
		
	int statusCode = User_API_Methods.ResponseStatusCode(Post_Create_Req_Repository.BaseURI(),
			         Post_Create_Req_Repository.Post_Resource(), Post_Create_Req_Repository.Post_TC2());
	 System.out.println(statusCode);
		
	String ResponseBody = User_API_Methods.ResponseBody(Post_Create_Req_Repository.BaseURI(), 
			              Post_Create_Req_Repository.Post_Resource(), Post_Create_Req_Repository.Post_TC2());
		System.out.println(ResponseBody);
		
		LocalDateTime currentdate=LocalDateTime.now();
		String expecteddate=currentdate.toString().substring(0,11);
		JsonPath JspResponse = new JsonPath(ResponseBody);
		String Res_name=JspResponse.getString("name");
		String Res_job=JspResponse.getString("job");
		String Res_createdAt=JspResponse.getString("createdAt");
		Res_createdAt=Res_createdAt.substring(0,11);
		
		//Validate the ResponseBody parameters
		Assert.assertEquals(Res_name, "Ravi");
		Assert.assertEquals(Res_job, "Software Tester");
		Assert.assertEquals(Res_createdAt, expecteddate);
	}
}

