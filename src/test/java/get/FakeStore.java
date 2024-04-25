package get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class FakeStore {

    @Test
    public void test1(){

        String url = "https://fakestoreapi.com/products/5";
        Response response = RestAssured.given().header("Accept","application/json")
                .when().get(url)
                .then().statusCode(200)
                .extract().response();

        Map<String,Object> deserializedResponse = response.as(new TypeRef<Map<String, Object>>() {
        });


        int id =(int) deserializedResponse.get("id");

        //validating id
        Assert.assertEquals(5,id);

        String category =(String) deserializedResponse.get("category");
        Assert.assertEquals("jewelery",category);

        int price =(int) deserializedResponse.get("price");
        Assert.assertEquals(695, price);

      Map<String,Object> ratingMap = (Map<String, Object>) deserializedResponse.get("rating");
      double rate = (double) ratingMap.get("rate");
      Assert.assertEquals(4.6,rate,0.0);

        System.out.println(deserializedResponse.get("description"));



    }
    @Test
    public void test2(){
        String url = "https://reqres.in/api/users/2";
        Response response = RestAssured.given().header("Accept","application/json")
                .when().get(url)
                .then().statusCode(200)
                .extract().response();

        Map<String,Object> deserializedResponse = response.as(new TypeRef<Map<String, Object>>() {
        });


        Map<String,Object> dataMap = (Map<String, Object>) deserializedResponse.get("data");

//        for (int i = 0; i < 1; i++) {
//            System.out.println(dataMap);
//
//        }
        System.out.println(dataMap);
        Assert.assertEquals(2,dataMap.get("id"));
        Assert.assertEquals("janet.weaver@reqres.in",dataMap.get("email"));
        Assert.assertEquals("Janet",dataMap.get("first_name"));
        Assert.assertEquals("Weaver",dataMap.get("last_name"));
        Assert.assertEquals("https://reqres.in/img/faces/2-image.jpg",dataMap.get("avatar"));

        Map<String, Object> supportMap = (Map<String, Object>) deserializedResponse.get("support");

        String text = supportMap.get("text").toString();
        System.out.println(text);
        Assert.assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!",text);
    }

    @Test
    public void test3(){
        String url = "https://covid-api.com/api/regions?per_page=20&order=name&sort=asc";
        Response response = RestAssured.given().header("Accept","application/json")
                .when().get(url)
                .then().statusCode(200)
                .extract().response();

        Map<String,Object> deserializedResponse = response.as(new TypeRef<Map<String, Object>>() {
        });

        String perPage = deserializedResponse.get("per_page").toString();
        System.out.println(perPage);
        Assert.assertEquals("20",perPage);

        int totalValue = (int) deserializedResponse.get("total");
        System.out.println(totalValue);
        Assert.assertEquals(1002,totalValue);

        List<Map<String,String>> dataList = (List<Map<String, String>>) deserializedResponse.get("data");

        for (int i = 0; i < dataList.size(); i++) {
            Map<String,String> temp = dataList.get(i);
            System.out.println(temp.get("name"));

        }



    }

    @Test
    public void test4(){
        String url = "https://covid-api.com/api/regions";
        Response response = RestAssured.given().header("Accept","application/json")
                .queryParam("per_page","20")
                .queryParam("order","name")
                .queryParam("sort","asc")
                .when().get(url)
                .then().statusCode(200)
                .extract().response();

        Map<String ,Object>  parsedResponse = response.as(new TypeRef<Map<String, Object>>() {
        });

        String  perPage = (String) parsedResponse.get("per_page");
        Assert.assertEquals("20",perPage);


        int total = (int) parsedResponse.get("total");
        Assert.assertEquals(1002,total);

        List<Map<String,String>> dataMap = (List<Map<String, String>>) parsedResponse.get("data");


        for (int i = 0; i < dataMap.size(); i++) {
            Map<String,String > tempMap = dataMap.get(i);
            System.out.println(tempMap.get("name"));

        }


    }


    @Test
    public void test5(){

        String url = "https://fakestoreapi.com/products";
        Response response = RestAssured.given().header("Accept","application/json")
                .when().get(url)
                .then().statusCode(200)
                .extract().response();

        List<Map<String,Object>> productsList = response.as(new TypeRef<List<Map<String, Object>>>() {
        });

        for (int i = 0; i < productsList.size(); i++) {
            Map<String,Object> temp = productsList.get(i);
            String title = temp.get("title").toString();
            double price = Double.parseDouble(temp.get("price").toString());
            System.out.println("Title is: " + title);
            System.out.println("Price is: " + price);

            System.out.println(temp.get("description"));



        }







    }





}
