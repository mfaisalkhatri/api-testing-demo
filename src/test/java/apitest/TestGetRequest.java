package apitest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestGetRequest {

    @Test
    public void testGetAllOrders() {

        given().when()
                .log()
                .all()
                .get("http://localhost:3004/getAllOrders")
                .then()
                .log()
                .all()
                .statusCode(200);

    }
}
