package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class SoapXMLRequest {
@Test
	public void validateSoapXML() throws IOException
	{
		File f = new File("./SoapRequest/add.xml");
		if(f.exists())
		{
			System.out.println("file Exists");
		}
		FileInputStream fis = new FileInputStream(f);
		String requestbody = IOUtils.toString(fis,"UTF-8");
		baseURI ="http://www.dneonline.com/";
		given()
		.contentType("text/xml").accept(ContentType.XML)
		.body(requestbody).when()
		.post("/calculator.asmx")
		.then()
		.statusCode(200).log().all();

	}
	
}
