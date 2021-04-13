package tests;

import api.Auth;
import api.Bodies;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Tests extends BaseTest {

    Bodies bodies = new Bodies();

    @Test
    @DisplayName("Add to product cart")
    public void addToCart() {
        Map<String, String> cookies = new Auth().login("qaguru@qa.guru", "qaguru@qa.guru1");

        String body = bodies.bodyComputer();

        Response response = given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookies(cookies)
                .body(body)
                .when()
                .post("/addproducttocart/details/16/1")
                .then()
                .statusCode(200)
                .log().body()
                .body("success", is(true))
                .extract().response();


        System.out.println(response.statusCode());
    }

    @Test
    @DisplayName("Add product review")
    public void addProductReview() {
        Map<String, String> cookies = new Auth().login("qaguru@qa.guru", "qaguru@qa.guru1");

        String body = bodies.bodyReview();

        Response response = given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookies(cookies)
                .body(body)
                .when()
                .post("/productreviews/32")
                .then()
                .statusCode(200)
                .log().body()
                .extract().response();

        System.out.println(response.statusCode());
    }

}
