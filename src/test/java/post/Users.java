package post;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.UserPojo;
import utils.PayloadUtils;

public class Users {

    @Test
    public void createUserTest() {

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "api/users";

        Response response = RestAssured.given().accept("application/json")
                .contentType("application/json")
                .body(PayloadUtils.getUserPayload())
                .when().post()
                .then().statusCode(201)
                .log().body()
                .extract().response();

       UserPojo deserializedResponse = response.as(UserPojo.class);
        System.out.println(deserializedResponse.getName());
        System.out.println(deserializedResponse.getJob());
        System.out.println(deserializedResponse.getId());
    }


}
