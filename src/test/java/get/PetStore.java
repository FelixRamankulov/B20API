package get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class PetStore {

    @Test
    public void test1(){
        String url = "https://petstore.swagger.io/v2/pet/754135";
        Response response = RestAssured.given().header("Accept","application/json")
                .when().get(url)
                .then().statusCode(200)
                .extract().response();

        Map<String,Object> deserializedResponse = response.as(new TypeRef<Map<String, Object>>() {
        });

       String name = (String) deserializedResponse.get("name");
        Assert.assertEquals("lily",name);

        String status = deserializedResponse.get("status").toString();
        Assert.assertEquals("available",status);

        List<Map<String,String>> tag = (List<Map<String, String>>) deserializedResponse.get("tags");
        for (int i = 0; i < tag.size(); i++) {
            Map<String,String> temp = tag.get(i);
            System.out.println(temp.get("name"));

        }
    }
}
