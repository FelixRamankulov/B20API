package get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.CatDataPojo;
import pojo.FactPojo;
import pojo.LinksPojo;

import java.util.List;
import java.util.Map;

public class Catfacts {

    @Test
    public void test1() {

        String url = "https://catfact.ninja/facts";
        Response response = RestAssured.given().header("Accept", "application/json")
                .when().get(url)
                .then().statusCode(200)
                .extract().response();

        Map<String, Object> deserializedResponse = response.as(new TypeRef<Map<String, Object>>() {
        });

        List<Map<String, Integer>> data = (List<Map<String, Integer>>) deserializedResponse.get("data");

        for (int i = 0; i < data.size(); i++) {
            Map<String, Integer> temp = data.get(i);
            System.out.println(temp.get("length"));

        }

    }

    @Test
    public void test3() {


        String url = "https://catfact.ninja/facts";
        Response response = RestAssured.given().header("Accept", "application/json")
                .when().get(url)
                .then().statusCode(200)
                .extract().response();

        FactPojo deserializedResponse = response.as(FactPojo.class);

        List<CatDataPojo> dataList = deserializedResponse.getData();

        for (int i = 0; i < dataList.size(); i++) {
            CatDataPojo temp = dataList.get(i);
            System.out.println(temp.getFact());
            String fact = temp.getFact();
            int factLength = fact.length();
            Assert.assertEquals(factLength, temp.getLength());

        }

        List<LinksPojo> linkList = deserializedResponse.getLinks();

        for (int i = 0; i < linkList.size(); i++) {
            LinksPojo temp = linkList.get(i);
            System.out.println(temp.getUrl());
            System.out.println("---");
            System.out.println(temp.getLabel());
            System.out.println("---");
            System.out.println(temp.isActive());
            System.out.println("___________________________");
        }


    }


}
