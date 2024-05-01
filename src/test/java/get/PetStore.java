package get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.PetPojo;

import java.util.List;
import java.util.Map;

public class PetStore {

    @Test
    public void test1() {
        String url = "https://petstore.swagger.io/v2/pet/754135";
        Response response = RestAssured.given().header("Accept", "application/json")
                .when().get(url)
                .then().statusCode(200)
                .extract().response();

        Map<String, Object> deserializedResponse = response.as(new TypeRef<Map<String, Object>>() {
        });

        String name = (String) deserializedResponse.get("name");
        Assert.assertEquals("lily", name);

        String status = deserializedResponse.get("status").toString();
        Assert.assertEquals("available", status);

        List<Map<String, String>> tag = (List<Map<String, String>>) deserializedResponse.get("tags");
        for (int i = 0; i < tag.size(); i++) {
            Map<String, String> temp = tag.get(i);
            System.out.println(temp.get("name"));

        }
    }

    @Test
    public void test2() {
        //https://petstore.swagger.io/v2/pet/754135
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet/754135";

        String url = "https://petstore.swagger.io/v2/pet/754135";

        Response response = RestAssured.given().accept("application/json")
                .when().get()
                .then().statusCode(200)
                .log().body()
                .extract().response();

        PetPojo deserializedResponse = response.as(PetPojo.class);

        Assert.assertEquals("rocky", deserializedResponse.getName());

        Assert.assertEquals("don't touch", deserializedResponse.getStatus());

    }
    @Test
    public void test3(){
        String url = "https://petstore.swagger.io/v2/pet/12311";

        Response response = RestAssured.given().accept("application/json")
                .when().get(url)
                .then().statusCode(200)
                .log().body()
                .extract().response();

        PetPojo parsedResponse = response.as(PetPojo.class);
        System.out.println(parsedResponse.getName());
        System.out.println(parsedResponse.getStatus());
    }
}
