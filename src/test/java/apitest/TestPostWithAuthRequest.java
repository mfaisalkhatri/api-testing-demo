package apitest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class TestPostWithAuthRequest {

    @Test
    public void testTokenGeneration () {
        final String requestBody = """
            {
              "username": "admin",
              "password": "secretPass123"
            }""";
        given ().contentType (ContentType.JSON)
            .when ()
            .body (requestBody)
            .post ("http://localhost:3004/auth")
            .then ()
            .statusCode (201)
            .and ()
            .body ("token", notNullValue ());

    }
}