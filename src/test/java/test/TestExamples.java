package test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExamples {
    @Test
    public void test_1(){

        Response response = get("https://api.restful-api.dev/objects");

        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
   }
   @Test
   public void test_2(){
        baseURI = "https://api.restful-api.dev";
        given().when().get("/objects").then().statusCode(200).body("[0].id",equalTo("1")).log().all();
   }
}
