package test;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void testPost(){
        Map<String, Object> map = new HashMap<String, Object>();

//        map.put("name","sujit");
//        map.put("job", "QA");
//
//        System.out.println(map);

        JSONObject request = new JSONObject(map);

        request.put("name","sujit");
        request.put("job", "QA");

        System.out.println(request.toJSONString());

        baseURI ="https://api.restful-api.dev";

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/objects").
                then().
                statusCode(200).
                log().all();


    }
}
