package get;

import io.restassured.RestAssured;
import org.junit.Test;

public class Itunes {


    @Test
    public void test1(){

        /**
         * 1. Specify URL/endpoint
         * 2. COnstruct request
         * 3. Send request
         * 4. Validate response status code
         */

        RestAssured.given().header("Accept","application/json")
                .when().get("https://itunes.apple.com/search?term=michael+jackson&limit=1")
                .then().statusCode(200);



    }








}
