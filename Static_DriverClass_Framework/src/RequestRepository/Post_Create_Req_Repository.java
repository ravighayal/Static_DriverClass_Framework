package RequestRepository;

public class Post_Create_Req_Repository {
	
	public static String BaseURI() {
        String baseURI = "https://reqres.in/";
        return baseURI; 
	}
	
	public static String Post_Resource() {
		String Post_Resource = "api/users";
		return Post_Resource;
	}
	
	public static String Post_TC2() {
		String RequestBody ="{\r\n"
				+ "    \"name\": \"Ravi\",\r\n"
				+ "    \"job\": \"Software Tester\"\r\n"
				+ "}";
		return RequestBody;
	}

}
