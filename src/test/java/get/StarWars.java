package get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class StarWars {

    @Test
    public void test1(){
        /**
         * 1. Constructing request:
         * - providing valid URL
         * - defining HTTP Method(GET)
         * - send request
         * 2. Validate status code of response
         */
        RestAssured.given().relaxedHTTPSValidation()
                .header("Accept","application/json")
                .when().get("https://swapi.dev/api/people")//sending GET request
                .then().statusCode(200)//validating status code is 200
                .log().body(); // print out response body



    }

    @Test
    public void test2(){
        String url = "https://swapi.dev/api/planets";
        RestAssured.given().relaxedHTTPSValidation()
                .header("Accept","application/json")
                .when().get(url)
                .then().statusCode(200)
                .log().body();
    }

    @Test
    public void test3(){

        String url = "https://swapi.dev/api/people";
        Response response = RestAssured.given().header("Accept","application/json")
                .relaxedHTTPSValidation()
                .when().get(url)
                .then().statusCode(200)
                .log().body()
                .extract().response();

        Map<String, Object> map = response.as(new TypeRef<Map<String, Object>>() {
        });
        System.out.println("JSON representation in Java");
        System.out.println();
        System.out.println(map);

        System.out.println(map.get("count"));
        System.out.println(map.get("next"));
    }

    @Test
    public void test4(){

        String url = "https://catfact.ninja/facts";
        Response response = RestAssured.given().header("Accept","application/json")
                .relaxedHTTPSValidation()
                .when().get(url)
                .then().statusCode(200)
                .extract().response();
        Map<String,Object> map = response.as(new TypeRef<Map<String, Object>>() {
        });

        System.out.println(map);
        System.out.println("--------------------");
        System.out.println(map.get("to"));
        System.out.println();
        System.out.println(map.get("total"));

        int toValue = (int)map.get("to");
        Assert.assertEquals(10,toValue);


    }



}
