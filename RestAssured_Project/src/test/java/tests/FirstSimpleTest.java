package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
public class FirstSimpleTest {
	
	@Test
	public void test1()
	{
	
	Response response = get("https://reqres.in/api/users?page=2");
	
	System.out.println(response.getStatusCode());
	System.out.println(response.getTime());
	System.out.println(response.getBody().asString());
	System.out.println(response.statusLine());
	System.out.println(response.getHeader("content-type"));
	Assert.assertEquals(response.statusCode(), 200);
	
	}
	@Test
	public void test2()
	{
		baseURI = "https://reqres.in";
		given().
		get("/api/users?page=2").
		then().
		statusCode(200).
		body("data[1].id", equalTo(8)).
		log().all();
	}
	
	}


