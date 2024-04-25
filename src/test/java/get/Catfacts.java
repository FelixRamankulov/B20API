package get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class Catfacts {

    @Test
    public void test1(){

        String url = "https://catfact.ninja/facts";
        Response response = RestAssured.given().header("Accept","application/json")
                .when().get(url)
                .then().statusCode(200)
                .extract().response();

        Map<String,Object> deserializedResponse = response.as(new TypeRef<Map<String, Object>>() {
        });

        List<Map<String,Integer>> data = (List<Map<String, Integer>>) deserializedResponse.get("data");

        for (int i = 0; i < data.size(); i++) {
            Map<String,Integer> temp = data.get(i);
            System.out.println(temp.get("length"));

        }

    }










}
