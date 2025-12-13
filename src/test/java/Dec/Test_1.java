package Dec;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Test_1 {
    @Test
    public void test1(){

        Response response= get("https://api.restful-api.dev/objects");

        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void test_2(){
        baseURI ="https://api.restful-api.dev";
        given().get("/objects").then().statusCode(200);
        given().get("/objects").then().statusCode(200).body("[0].id",equalTo("1")).log().all();
    }

}
