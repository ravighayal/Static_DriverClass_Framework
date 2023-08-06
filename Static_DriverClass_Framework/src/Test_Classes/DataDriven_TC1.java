package Test_Classes;

import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;
import Common_API_Methods.Common_Utility_Method;
import Common_API_Methods.User_API_Methods;
import RequestRepository.DataDriven_RequestRepository;
import RequestRepository.Post_Create_Req_Repository;
import io.restassured.path.json.JsonPath;

public class DataDriven_TC1 {

	private static final String ResponseBody = null;
	private static final Object Res_id = null;
	private static final Object Req_id = null;
	public static void extractor() throws IOException {
		
		int statusCode = Common_Utility_Method.ResponseStatusCode(DataDriven_RequestRepository.BaseURI(),
				DataDriven_RequestRepository.Post_Resource(), DataDriven_RequestRepository.Post_TC2());
		 System.out.println(statusCode);
			
		String ResponseBody = Common_Utility_Method.ResponseBody(DataDriven_RequestRepository.BaseURI(), 
				DataDriven_RequestRepository.Post_Resource(), DataDriven_RequestRepository.Post_TC2());
			System.out.println(ResponseBody);	
	}
	public static void validator (String Request, String Response)	{	
			JsonPath JspRequest = new JsonPath(Request);
			String Req_name = JspRequest.getString("name");
			String Req_job = JspRequest.getString("job");
			LocalDateTime currentdate = LocalDateTime.now();
			String expecteddate = currentdate.toString().substring(0,11);
			
			JsonPath JspResponse = new JsonPath(ResponseBody);
			String Res_name=JspResponse.getString("name");
			String Res_job=JspResponse.getString("job");
			String Res_Job=JspResponse.getString("id");
			String Res_createdAt=JspResponse.getString("createdAt");
			Res_createdAt=Res_createdAt.substring(0,11);
			
			Assert.assertEquals(Res_name, Req_name);
			Assert.assertEquals(Res_job, Req_job);
			Assert.assertNotNull(Req_id);
			Assert.assertNotEquals(Res_id, 0);
			Assert.assertEquals(Res_createdAt, expecteddate);
			
		}
	}

