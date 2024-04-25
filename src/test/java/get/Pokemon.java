package get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class Pokemon {

    @Test
    public void test1(){

        String url = "https://pokeapi.co/api/v2/pokemon";
    Response response = RestAssured.given().header("Accept","application/json")
                .when().get(url)
                .then().statusCode(200)
//                .log().body()
                .extract().response();

        Map<String,Object> deserializedResponse = response.as(new TypeRef<Map<String, Object>>() {
        });

        int count = (int) deserializedResponse.get("count");
        Assert.assertEquals(1302,count);

      List <Map<String,String>> results = (List<Map<String, String>>) deserializedResponse.get("results");

        for (int i = 0; i < results.size(); i++) {
            Map<String,String> tempMap = results.get(i);
            System.out.println(tempMap.get("name"));
        }

    }

    @Test
    public void test2(){

        String url = "https://pokeapi.co/api/v2/type";
        Response response = RestAssured.given().header("Accept","application/json")
                .when().get(url)
                .then().statusCode(200)
                .extract().response();
        Map<String,Object> deserializedResponse = response.as(new TypeRef<Map<String, Object>>() {
        });

        List<Map<String,String>> results = (List<Map<String, String>>) deserializedResponse.get("results");

        for (int i = 0; i < results.size(); i++) {
            Map<String, String> temp = results.get(i);
            System.out.println(temp.get("url"));

        }
    }



}
