package get;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.AirportDataPojo;
import pojo.AirportListDataPojo;
import pojo.AirportListPojo;

import java.util.List;

public class AirportGet {

    @Test
    public void airportTest(){

        RestAssured.baseURI = "https://airportgap.dev-tester.com";
        RestAssured.basePath = "api/airports";

        Response response = RestAssured.given().accept("application/json")
                .header("Authorization","Bearer JrUQ9qQ9hbPM13r57KciPWxG")
                .when().get()
                .then().statusCode(200)
                .extract().response();

      AirportListPojo deserializedResponse = response.as(AirportListPojo.class);
        List<AirportListDataPojo> data = deserializedResponse.getData();

        for (int i = 0; i < data.size(); i++) {
            AirportListDataPojo airport = data.get(i);
            System.out.println(airport.getAttributes().getName());
            System.out.println(airport.getAttributes().getCity());

        }













    }
}
