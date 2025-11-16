package test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class RestAssured_06_GetPostExample {

    @Test
    public void testGet(){
    baseURI ="https://api.restful-api.dev";

    given().
            get("/objects").
            then().
            statusCode(200).
            body("[0].name",equalTo("Google Pixel 6 Pro")).
            body("name",hasItems("Apple iPhone 12 Mini, 256GB, Blue","Apple iPhone 12 Pro Max"));
    }
}
