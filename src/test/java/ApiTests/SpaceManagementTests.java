package ApiTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SpaceManagementTests {
	
	public static String cookievalue;
	public static String spaceId;
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.hub.knime.com";
        cookievalue = "knime_hub_auth=eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ2SHpuYUhTS3RMWmszcnczVlJBN2M4eThsUHlVazU3YndMejRvekFZT1o4In0.eyJleHAiOjE3MTk4NzUxOTIsImlhdCI6MTcxOTg3MzM5MiwiYXV0aF90aW1lIjoxNzE5Nzg2NTcwLCJqdGkiOiIyYzk4OTQ4Zi1jYTE3LTQ2YTAtYWMwOC0zMzljMzVmZjliMDgiLCJpc3MiOiJodHRwczovL2F1dGguaHViLmtuaW1lLmNvbS9hdXRoL3JlYWxtcy9rbmltZSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiI2ZjI0ZDA0Zi0zMDgwLTQxNDAtYjljNy03NmIzOWZlOTA2ODQiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJhdXRoLXJlbHkiLCJzZXNzaW9uX3N0YXRlIjoiYzg4ZTIyOTgtMjk1OC00NTVlLTlmNTktZGM3YzllZmVlZTk2Iiwic2NvcGUiOiJncm91cHMgZW1haWwgb2ZmbGluZV9hY2Nlc3Mgb3BlbmlkIHByb2ZpbGUiLCJzaWQiOiJjODhlMjI5OC0yOTU4LTQ1NWUtOWY1OS1kYzdjOWVmZWVlOTYiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwibmFtZSI6IlN5ZWQgRmFpemFuIEFiYmFzIE1hc29vZCIsImdyb3VwcyI6WyJodWJ1c2VyIl0sInByZWZlcnJlZF91c2VybmFtZSI6ImZhaXphbmFiYmFzIiwiZ2l2ZW5fbmFtZSI6IlN5ZWQgRmFpemFuIEFiYmFzIiwiZmFtaWx5X25hbWUiOiJNYXNvb2QiLCJlbWFpbCI6ImZhaXphbmFiYmFzMTI5NUBnbWFpbC5jb20ifQ.o4kuYbkcTZx819iohGxo_4OibwisE4CxEhYQD0Z7cz9WW0Zewbw3yw_NKONIdgYv09Etm8xCjMLZU3Tacoj1WWfsonYufcK8xisQ8WZbUnbJGz5huW8Ba6z6BfthRlG9KjUKdWcMID10GM_LVN3ifwfvewFm2ylmPxht0DWn-lMqpFEX7EMT1EoF4mdrsFwNk3L_9-U4q1YzhGtm0NJiCjtlSQnxBirIjK0ZlHRFT4XLrRmEkV41n-mjGSiL18uw9CRkt87mUQ7N2pZ5gCPSHiZCHufpQXZfDo9Q0R0jmDlUQjpW7GPRfIFD0A7BYj9MPf0riU-JyaR70XSuOgvmpA";
        spaceId= "TestUnique";
    }
    
    @Test
    public void testCreate() {
     
        String requestBody = "{\"private\":true,\"type\":\"Space\"}";

        String uri = "/repository/Users/account:user:6f24d04f-3080-4140-b9c7-76b39fe90684/"+spaceId+ "?overwrite=false";
        Response response=given().header("Cookie", cookievalue)
        .contentType(ContentType.JSON)
            .body(requestBody)
            .when()
            .put(uri)
            .then()
            .statusCode(201)
            .extract().response();
        
        String responseBody = response.getBody().asString();
      
    }
    
    // Create a public Space
    @Test
    public void PublicSpace() {
    	 String requestBody = "{\"private\":false,\"type\":\"Space\"}";
    	 
    	  String uri = "/repository/Users/account:user:6f24d04f-3080-4140-b9c7-76b39fe90684/"+spaceId+ "?overwrite=false";
          Response response=given().header("Cookie", cookievalue)
          .contentType(ContentType.JSON)
              .body(requestBody)
              .when()
              .put(uri)
              .then()
              .statusCode(201)
              .extract().response();
          
          String responseBody = response.getBody().asString();
        
    	
    }
    
   

    @Test
    public void testDeleteSpace() {
        given()
            .header("Cookie", cookievalue)
            .when()
            .delete("/repository/Users/faizanabbas/" + spaceId)
            .then()
            .statusCode(204);
    }
    
    
}
