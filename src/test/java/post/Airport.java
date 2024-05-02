package post;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.AirportAttributesPojo;
import pojo.AirportDataPojo;
import pojo.AirportFromToPojo;
import pojo.AirportPojo;
import utils.PayloadUtils;

public class Airport {

    @Test
    public void createTest() {

        RestAssured.baseURI = "https://airportgap.com";
        RestAssured.basePath = "api/airports/distance";

        Response response = RestAssured.given().accept("application/json")
                .contentType("application/json")
                .header("Authorization", "Bearer JrUQ9qQ9hbPM13r57KciPWxG")
                .body(PayloadUtils.getAirportPayload())
                .when().post()
                .then().statusCode(200)
//                .log().body()
                .extract().response();

        AirportPojo deserializedResponse = response.as(AirportPojo.class);

        AirportDataPojo data = deserializedResponse.getData();

        AirportAttributesPojo attributes = data.getAttributes();

        AirportFromToPojo fromAirport = attributes.getFrom_airport();

        System.out.println("From airport name is: " + fromAirport.getName());
        System.out.println("From airport city is: " + fromAirport.getCity());

        //to Airport

        AirportFromToPojo toAirport = attributes.getTo_airport();
        System.out.println("To airport name is: " + toAirport.getName());
        System.out.println("To airport is: " + toAirport.getCity());

        System.out.println("Distance in kilometers is " + attributes.getKilometers());

        System.out.println("Distance in miles is " + attributes.getMiles());


    }

}
