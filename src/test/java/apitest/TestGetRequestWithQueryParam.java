package apitest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestGetRequestWithQueryParam {

    @Test
    public void testGetOrderWithQueryParam() {

        given().when()
                .log().all()
                .queryParam("id", 1)
                .get("http://localhost:3004/getOrder")
                .then().log().all()
                .statusCode(200).and()
                .assertThat()
                .body("orders[0].user_id", equalTo("2"));
    }
}
