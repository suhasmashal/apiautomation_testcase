import io.restassured.RestAssured;
import java.util.Properties;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;


public class swaggerwork {
    String access_token;

    {
        access_token = " ";
    }

    static String ClientId = "upskills_admin";
    static String secret = "Talent4$$";
    static String val = "Basic dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9jbGllbnQ6dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9zZWNyZXQ=";
    public void main(String args[]){
        String payload = "{\n" +
                "    \"username\":\"upskills_admin\",\n" +
                "    \"password\":\"Talent4$$\"\n" +
                "}";



    }

    @Test(priority = 1)
    public void token() {

        Response responsePost = RestAssured.given().header("Authorization", "Basic dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9jbGllbnQ6dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9zZWNyZXQ=")
                .given().header("Accept", "application/json")
                .given().param("grant_type", "client_credentials").contentType(ContentType.JSON).log().all()
                .post("http://rest-api.upskills.in/api/rest_admin/oauth2/token/client_credentials");

        String abc = responsePost.getBody().asString();
        System.out.println(abc);
        System.out.println(abc.substring(Integer.parseInt("260")));
        System.out.println(abc.substring(Integer.parseInt("276"), Integer.parseInt("316")));
        access_token = responsePost.body().asString().substring(Integer.parseInt("276"), Integer.parseInt("316"));
        System.out.println("token is:" +access_token);
        System.out.println("Status code is " +responsePost.getStatusCode());
        Assert.assertEquals(responsePost.getStatusCode(), 200, "expected status code is not matching");
    }

    @Test(priority = 2)
    public void authorization(){
        Response res=given().headers("Authorization","Bearer "+access_token)
                .contentType("application/json").when().post("http://rest-api.upskills.in/doc/admin/#/");
        System.out.println("token is:" +access_token);
        System.out.println("status code of authorization " +res.getStatusCode());
    }

    @Test(priority = 3)
    public void login() {
        String payload = "{\n" +
                "    \"username\":\"upskills_admin\",\n" +
                "    \"password\":\"Talent4$$\"\n" +
                "}";
        Response reslogin = given().headers("Authorization", "Bearer " + access_token).given().headers("Content-Type", "application/json").body(payload).when()
                .post("http://rest-api.upskills.in/api/rest_admin/login");
        System.out.println("The status code for login is: " + reslogin.getStatusCode());
        Assert.assertEquals(reslogin.getStatusCode(), 200, "expected status code is not matching");
    }

    @Test(priority = 4)
    public void Userdetails(){
        Response respuserdetail = given().header("Authorization","Bearer "+access_token)
                .given().get("http://rest-api.upskills.in/api/rest_admin/user");
        Assert.assertEquals(respuserdetail.getStatusCode(), 200, "expected status code is not matching");
        System.out.println(respuserdetail.getBody().asString());
    }

    @Test(priority = 5)
    public void AddProduct(){

        String payload1="{\n" +
                "  \"model\": \"Lenovo Ideapad Laptop\",\n" +
                "  \"quantity\": \"1000\",\n" +
                "  \"price\": \"44000.00\",\n" +
                "  \"tax_class_id\": \"1\",\n" +
                "  \"manufacturer_id\": \"20\",\n" +
                "  \"sku\": \"demo sku\",\n" +
                "  \"product_seo_url\": [\n" +
                "    {\n" +
                "      \"keyword\": \"demo-keyword\",\n" +
                "      \"language_id\": \"1\",\n" +
                "      \"store_id\": \"0\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"1\",\n" +
                "  \"points\": 0,\n" +
                "  \"reward\": 0,\n" +
                "  \"image\": \"\",\n" +
                "  \"other_images\": [\n" +
                "    \"\"\n" +
                "  ],\n" +
                "  \"shipping\": \"1\",\n" +
                "  \"stock_status_id\": 0,\n" +
                "  \"upc\": \"\",\n" +
                "  \"ean\": \"\",\n" +
                "  \"jan\": \"\",\n" +
                "  \"isbn\": \"\",\n" +
                "  \"mpn\": \"\",\n" +
                "  \"location\": \"\",\n" +
                "  \"date_available\": \"2017-05-12\",\n" +
                "  \"weight\": 0,\n" +
                "  \"weight_class_id\": 0,\n" +
                "  \"length\": 0,\n" +
                "  \"width\": 0,\n" +
                "  \"height\": 0,\n" +
                "  \"length_class_id\": 0,\n" +
                "  \"subtract\": 0,\n" +
                "  \"minimum\": 0,\n" +
                "  \"sort_order\": \"\",\n" +
                "  \"product_store\": [\n" +
                "    \"0\"\n" +
                "  ],\n" +
                "  \"product_related\": [\n" +
                "    \"34\"\n" +
                "  ],\n" +
                "  \"product_filter\": [\n" +
                "    \"34\"\n" +
                "  ],\n" +
                "  \"product_description\": [\n" +
                "    {\n" +
                "      \"language_id\": \"1\",\n" +
                "      \"name\": \"Lenovo Ideapad Laptop\",\n" +
                "      \"description\": \"Description of the product\",\n" +
                "      \"meta_title\": \"Lenovo Ideapad Laptop\",\n" +
                "      \"meta_description\": \"Meta description of the product\",\n" +
                "      \"meta_keyword\": \"demo, keyword, demo2\",\n" +
                "      \"tag\": \"Product's tag, comma separeted\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"product_category\": [\n" +
                "    \"25\"\n" +
                "  ],\n" +
                "  \"product_special\": [\n" +
                "    {\n" +
                "      \"customer_group_id\": \"1\",\n" +
                "      \"price\": \"200\",\n" +
                "      \"priority\": \"1\",\n" +
                "      \"date_start\": \"2015-02-23\",\n" +
                "      \"date_end\": \"2019-02-23\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"product_discount\": [\n" +
                "    {\n" +
                "      \"name\": \"demo name\",\n" +
                "      \"customer_group_id\": \"1\",\n" +
                "      \"price\": \"200\",\n" +
                "      \"priority\": \"1\",\n" +
                "      \"quantity\": \"1\",\n" +
                "      \"date_start\": \"2015-02-23\",\n" +
                "      \"date_end\": \"2019-02-23\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"product_attribute\": [\n" +
                "    {\n" +
                "      \"attribute_id\": \"16\",\n" +
                "      \"product_attribute_description\": [\n" +
                "        {\n" +
                "          \"text\": \"demo name\",\n" +
                "          \"language_id\": \"1\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"product_option\": [\n" +
                "    {\n" +
                "      \"type\": \"radio\",\n" +
                "      \"option_id\": \"11\",\n" +
                "      \"required\": \"1\",\n" +
                "      \"product_option_value\": [\n" +
                "        {\n" +
                "          \"price\": \"10.00\",\n" +
                "          \"price_prefix\": \"+\",\n" +
                "          \"subtract\": \"1\",\n" +
                "          \"points\": \"0\",\n" +
                "          \"points_prefix\": \"+\",\n" +
                "          \"weight\": \"0\",\n" +
                "          \"weight_prefix\": \"+\",\n" +
                "          \"option_value_id\": \"46\",\n" +
                "          \"quantity\": \"0\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        Response resaddprod = given().header("Authorization","Bearer "+access_token)
                .headers("Content-Type","application/json").body(payload1)
                .when().post("http://rest-api.upskills.in/api/rest_admin/products");
        JsonPath jp=new JsonPath(resaddprod.getBody().asString());
        System.out.println(resaddprod.getBody().asString());
        Assert.assertEquals(resaddprod.getStatusCode(), 200, "expected status code is not matching");
        System.out.println("status code for add product is" +resaddprod.getStatusCode());
    }

    @Test(priority = 6)
    public void GetproductId(){

        Response resprodid = given().header("Authorization","Bearer "+access_token).contentType("application/json")
                .when().post("http://rest-api.upskills.in/doc/admin/#/Products/products.details");
        Assert.assertEquals(resprodid.getStatusCode(), 200, "expected status code is not matching");
        System.out.println("status code for add product  ID is" +resprodid.getStatusCode());
    }

    @Test(priority = 7)
    public void AddCategoryservice(){

        Response resaddcat = given().header("Authorization","Bearer "+access_token).contentType("application/json")
                .when().post("http://rest-api.upskills.in/doc/admin/#/Category/category.add");
        Assert.assertEquals(resaddcat.getStatusCode(), 200, "expected status code is not matching");
        System.out.println("status code for add category service is" +resaddcat.getStatusCode());
    }
}

