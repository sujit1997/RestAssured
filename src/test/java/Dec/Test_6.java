package Dec;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Test_6 {

    @Test
    public void testGet(){

        baseURI = "https://api.restful-api.dev";

        given().get("/objects").then().statusCode(200).body("[2].name",equalTo("Apple iPhone 12 Pro Max"));
    }

    @Test
    public void testPost(){
        Map<String, Object> map = new HashMap<String,Object>();
        //map.put("\"year\"","2019");
        //map.put("price","1849.99");

       // System.out.println(map);

        JSONObject request = new JSONObject();
        request.put("year","2019");
        request.put("2019","Replace with block comment");
        System.out.println(request.toJSONString());

       // given().body(request.toJSONString()).when().post("https://api.restful-api.dev/objects").then().statusCode(200);
    }
}
