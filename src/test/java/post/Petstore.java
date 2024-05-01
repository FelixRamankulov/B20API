package post;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.PetPojo;
import utils.PayloadUtils;

public class Petstore {


    @Test
    public void createPetTest() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "pet";

        Response response = RestAssured.given().accept("application/json")
                .contentType("application/json")
                .body(PayloadUtils.getPetPayload("12311","Zeus","Sleeping"))
                .when().post()
                .then().statusCode(200)
                .extract().response();

        PetPojo deserializedResponse = response.as(PetPojo.class);
        System.out.println(deserializedResponse.getName());
        System.out.println(deserializedResponse.getStatus());



    }


}
