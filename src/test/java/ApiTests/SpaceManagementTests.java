package ApiTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;


import io.restassured.RestAssured;
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
        cookievalue = "knime_hub_auth=eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ2SHpuYUhTS3RMWmszcnczVlJBN2M4eThsUHlVazU3YndMejRvekFZT1o4In0.eyJleHAiOjE3MTk3ODgzNzAsImlhdCI6MTcxOTc4NjU3MCwiYXV0aF90aW1lIjoxNzE5Nzg2NTcwLCJqdGkiOiI4ZTM5ODVmMS04YTU5LTQ2NmYtYjRiZS02NDdhYTFjZGIxNmEiLCJpc3MiOiJodHRwczovL2F1dGguaHViLmtuaW1lLmNvbS9hdXRoL3JlYWxtcy9rbmltZSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiI2ZjI0ZDA0Zi0zMDgwLTQxNDAtYjljNy03NmIzOWZlOTA2ODQiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJhdXRoLXJlbHkiLCJzZXNzaW9uX3N0YXRlIjoiYzg4ZTIyOTgtMjk1OC00NTVlLTlmNTktZGM3YzllZmVlZTk2Iiwic2NvcGUiOiJncm91cHMgZW1haWwgb2ZmbGluZV9hY2Nlc3Mgb3BlbmlkIHByb2ZpbGUiLCJzaWQiOiJjODhlMjI5OC0yOTU4LTQ1NWUtOWY1OS1kYzdjOWVmZWVlOTYiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwibmFtZSI6IlN5ZWQgRmFpemFuIEFiYmFzIE1hc29vZCIsImdyb3VwcyI6WyJodWJ1c2VyIl0sInByZWZlcnJlZF91c2VybmFtZSI6ImZhaXphbmFiYmFzIiwiZ2l2ZW5fbmFtZSI6IlN5ZWQgRmFpemFuIEFiYmFzIiwiZmFtaWx5X25hbWUiOiJNYXNvb2QiLCJlbWFpbCI6ImZhaXphbmFiYmFzMTI5NUBnbWFpbC5jb20ifQ.eL5HVB53eL9ap8ULt78y3Ujb017kmBrr_l42Do2xI-Fm5VapFrJUki7-9YAXYs8cTf8Mnj64VP6xvs9VTdeSzZGZ1-8M1m9vgNJXleLw_h3YYfXuaQYnfyg3GI9vvHBL8trKGyyPRBA3uSgCKPD9_ZcK5gKnFldf3GAedDWjmnH3UIaQg0thKz7anfSQ7Pf-0_Za-e9Gur2Iln4kYI8D8DV-_EwTS1Hqs54eLnDCBlRRXSp3e045GIRfVujxqr-8CsxyEORf3r4KwuD-eQLjLqRJOTU1TmQzpe8sCvWxLZRry6yVjLBbIdiqKeM4bFfqUjyDWQeH-JrZtnfAKTr9IQ";
       spaceId= "TestUnique";
    }
    
    @Test
    public void testCreate() throws Exception {
        // Create a map to hold JSON object key-value pairs.
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("private", true);
        jsonMap.put("type", "Space");

        // Convert map to JSON string using Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(jsonMap);

        given().header("Cookie", cookievalue)
            .body(requestBody).queryParam("overwrite", false)
            .when()
            .put("/repository/Users/account%3Auser%3A6f24d04f-3080-4140-b9c7-76b39fe90684/"+spaceId)
            .then().statusCode(201);        
      
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