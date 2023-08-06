package Test_Classes;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.Common_Utility_Method;
import Common_API_Methods.Retry_API_Method;
import RequestRepository.Post_Retry_Repository;
import io.restassured.path.json.JsonPath;

public class Retry_TC1 {

	public static void extractor() throws IOException {
		for (int i = 0; i < 5; i++) {
			int statusCode = Retry_API_Method.ResponseStatusCode(Post_Retry_Repository.BaseURI(),
					Post_Retry_Repository.Post_Resource(), Post_Retry_Repository.Post_Req_TC1());
			if (statusCode == 201) {
				System.out.println("StatusCode is Correct:" + statusCode);
				String ResponseBody = Retry_API_Method.ResponseBody(Post_Retry_Repository.BaseURI(),
						Post_Retry_Repository.Post_Resource(), Post_Retry_Repository.Post_Req_TC1());
				System.out.println(ResponseBody);
				String RequestBody = Post_Retry_Repository.Post_Req_TC1();
				Common_Utility_Method.EvidenceCreator("Evidence", RequestBody, ResponseBody, statusCode);
				validator(ResponseBody, RequestBody);
				break;
			} else {
				System.out.println("StatusCode Is Incorrect");
			}
		}
	}

	public static void validator(String responseBody, String requestBody) {
		JsonPath JspResponse = new JsonPath(responseBody);
		String Res_name = JspResponse.getString("name");
		String Res_job = JspResponse.getString("job");
		Assert.assertEquals(Res_name, "Ravi");
		Assert.assertEquals(Res_job, "Software Tester");
	}
}
