package test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssured_04_Test1 {

    @Test
    public void test_1(){

        Response response = RestAssured.get("https://api.restful-api.dev/objects");

        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());

        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode,200);


    }
}
