package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class GetAndPostExamples {
	
/*	@Test
	public void testGet()
	{
		baseURI ="https://reqres.in/api/";
		given().
		get("users?page=2").
		then().statusCode(200).
		body("data[3].first_name", equalTo("Byron")).
		body("data.first_name", hasItems("George","Rachel"));
	} */
	@Test
	public void testPost()
	{
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Minati");
//		map.put("job", "Teacher");
//		System.out.println(map);
		
	JSONObject request = new JSONObject();
		request.put("name", "Minati");
		request.put("job", "Teacher");
		request.put("id", "1234");
		System.out.println(request.toJSONString());
	baseURI="https://reqres.in/api/";	
	given().header("Content-Type","application/json").contentType(ContentType.JSON).
	body(request.toJSONString()).
	when().
	post("/users").
	then().statusCode(201).and().statusCode(402).
	log().all();
	}

}
