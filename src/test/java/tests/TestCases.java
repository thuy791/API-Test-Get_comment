package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.*;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static io.restassured.path.xml.XmlPath.CompatibilityMode.HTML;
import static org.hamcrest.Matchers.equalTo;


public class TestCases { /* [NOTES]: Must use this class name. */
	public static String BASE_URI = "http://it4895.herokuapp.com/";
	public static String COMMENT_END_POINT = "/it4895/get_comment";
	public static String SCOMMENT_END_POINT = "/it4895/set_comment";
	public static String POST_END_POINT = "/it4895/add_post";
	public static String LOGIN_END_POINT = "/it4895/LogIn";
	public static String SIGNUP_END_POINT = "/it4895/signup";
	public static String TOKEN = "89|wxVj77tWxulLlpHIGOmmPUnifGCEPFlGw5rDH2QS";

	@Test
	public void test_PostComment_ResponseCode_ShouldBe1000() {
		RestAssured.baseURI = //"http://it4895.herokuapp.com/it4985/";
								"https://it4895-nhom5-v2.herokuapp.com/it4788";
		given().urlEncodingEnabled(true)
			.param("id", 28)
			.param("index", "0")
			.param("count", 1)
			.param("token", TOKEN)
			.header("Accept", ContentType.JSON.getAcceptHeader())

			.post(COMMENT_END_POINT)

			.then().statusCode(HttpStatus.SC_OK)
			.body("code", equalTo("1000"))
			.body("message", equalTo("OK"));
	}

	@Test
	public void test_GetComment_ResponseCode_ShouldBe1000() {
		RestAssured.baseURI = "http://it4895.herokuapp.com/";
		given().urlEncodingEnabled(true)
			.param("id", 28)
			.param("index", "0")
			.param("count", 1)
			.param("token", TOKEN)
			.header("Accept", ContentType.JSON.getAcceptHeader())

			.get(COMMENT_END_POINT)

			.then().statusCode(HttpStatus.SC_OK)
			.body("code", equalTo("1000"))
			.body("message", equalTo("OK"));
	}

	@Test
	public void test_GetComment_ShouldBeRedirectToLoginPage() {
		RestAssured.baseURI = "http://it4895.herokuapp.com/";
		Response res = given().urlEncodingEnabled(true)
			.param("id", 28)
			.param("index", "0")
			.param("count", 1)
			.param("token", "123")
			.header("Accept", ContentType.JSON.getAcceptHeader())

			.get(COMMENT_END_POINT)
			.then()
			.statusCode(HttpStatus.SC_OK)
			.contentType(ContentType.HTML).extract().response();

			XmlPath htmlPath = new XmlPath(HTML, res.getBody().asString());
			Assert.assertEquals(htmlPath.getString("html.head.title"), "Login");
	}

	@Test
	public void test_GetComment_ResponseCode_ShouldBe9992() {
		RestAssured.baseURI = "http://it4895.herokuapp.com/";
		given().urlEncodingEnabled(true)
				.param("id", 9999)
				.param("index", "0")
				.param("count", 1)
				.param("token", TOKEN)
				.header("Accept", ContentType.JSON.getAcceptHeader())

				.get(COMMENT_END_POINT)
				.then()
				.statusCode(HttpStatus.SC_OK)
				.body("code", equalTo("9992"));
	}
	@Test
	public void test_GetComment_ResponseCode_ShouldBe1003() {
		RestAssured.baseURI = "http://it4895.herokuapp.com/";
		given().urlEncodingEnabled(true)
				.param("id", 9999)
				.param("index", 0)
				.param("count", "A")
				.param("token", TOKEN)
				.header("Accept", ContentType.JSON.getAcceptHeader())

				.get(COMMENT_END_POINT)
				.then()
				.statusCode(HttpStatus.SC_OK)
				.body("code", equalTo("1003"));
	}
	@Test
	public void test_GetComment_ResponseCode_ShouldBe1004() {
		RestAssured.baseURI = "http://it4895.herokuapp.com/";
		given().urlEncodingEnabled(true)
				.param("id", 9999)
				.param("index", "1")
				.param("count", 0)
				.param("token", TOKEN)
				.header("Accept", ContentType.JSON.getAcceptHeader())

				.get(COMMENT_END_POINT)
				.then()
				.statusCode(HttpStatus.SC_OK)
				.body("code", equalTo("1004"));
	}
	@Test
	public void test_setComment_ResponseCode_ShouldBe1000() {
		RestAssured.baseURI = "http://it4895.herokuapp.com/";
		given().urlEncodingEnabled(true)
				.param("id", 28)
				.param("index", 0)
				.param("count", 0)
				.param("comment", 0)
				.param("token", TOKEN)
				.header("Accept", ContentType.JSON.getAcceptHeader())

				.post(SCOMMENT_END_POINT)

				.then().statusCode(HttpStatus.SC_OK)
				.body("code", equalTo("1000"))
				.body("message", equalTo("OK"));
	}
	@Test
	public void test_SetComment_ResponseCode_ShouldBe9992() {
		RestAssured.baseURI = "http://it4895.herokuapp.com/";
		given().urlEncodingEnabled(true)
				.param("id", 9999)
				.param("index", 0)
				.param("count", 0)
				.param("comment", 0)
				.param("token", TOKEN)
				.header("Accept", ContentType.JSON.getAcceptHeader())

				.get(SCOMMENT_END_POINT)
				.then()
				.statusCode(HttpStatus.SC_OK)
				.body("code", equalTo("9992"));
	}
	@Test
	public void test_SetComment_ShouldBeRedirectToLoginPage() {
		RestAssured.baseURI = "http://it4895.herokuapp.com/";
		Response res = given().urlEncodingEnabled(true)
				.param("id", 28)
				.param("index", 0)
				.param("count", 0)
				.param("comment", 0)
				.param("token", 12)
				.header("Accept", ContentType.JSON.getAcceptHeader())

				.get(SCOMMENT_END_POINT)
				.then()
				.statusCode(HttpStatus.SC_OK)
				.contentType(ContentType.HTML).extract().response();

		XmlPath htmlPath = new XmlPath(HTML, res.getBody().asString());
		Assert.assertEquals(htmlPath.getString("html.head.title"), "Login");
	}
	@Test
	public void test_SetComment_ResponseCode_ShouldBe1003() {
		RestAssured.baseURI = "http://it4895.herokuapp.com/";
		given().urlEncodingEnabled(true)
				.param("id", 9999)
				.param("index", 0)
				.param("count", 0)
				.param("comment", 0)
				.param("token", TOKEN)
				.header("Accept", ContentType.JSON.getAcceptHeader())

				.get(SCOMMENT_END_POINT)
				.then()
				.statusCode(HttpStatus.SC_OK)
				.body("code", equalTo("1003"));
	}

	@Test
	public void test_SetComment_ResponseCode_ShouldBe1004() {
		RestAssured.baseURI = "http://it4895.herokuapp.com/";
		given().urlEncodingEnabled(true)
				.param("id", 9999)
				.param("index", 0)
				.param("count", 0)
				.param("comment", 1 )
				.param("token", TOKEN)
				.header("Accept", ContentType.JSON.getAcceptHeader())

				.get(SCOMMENT_END_POINT)
				.then()
				.statusCode(HttpStatus.SC_OK)
				.body("code", equalTo("1004"));
	}
	@Test
	public void test__ResponseCode_ShouldBe1000() {
		RestAssured.baseURI = "http://it4895.herokuapp.com/";
		given().urlEncodingEnabled(true)
				.param("id", 28)
				.param("index", 0)
				.param("count", 0)
				.param("comment", 0)
				.param("token", TOKEN)
				.header("Accept", ContentType.JSON.getAcceptHeader())

				.post(SCOMMENT_END_POINT)

				.then().statusCode(HttpStatus.SC_OK)
				.body("code", equalTo("1000"))
				.body("message", equalTo("OK"));
	}
}

