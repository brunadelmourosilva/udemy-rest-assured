import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class PutPatchDeleteExamples {
    private final String baseURI = "https://reqres.in/api";

    @Test
    public void testPut() {
        Map<String, Object> map = new HashMap<>();

        //building a map and convert to json format
        JSONObject request = new JSONObject(map);
        request.put("name", "Raghav");
        request.put("job", "Teacher");

        //given a header of type json and assert that the file will be a json, we will pass the body
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                //when the url passed will be:
                        when().
                put(baseURI.concat("/users/2")).
                //then assert that status code is 201 and show response on console with .log().all()
                        then().
                statusCode(200).log().all();
    }

    @Test
    public void testPatch(){
        Map<String, Object> map = new HashMap<>();

        //building a map and convert to json format
        JSONObject request = new JSONObject(map);
        request.put("name", "Raghav");
        request.put("job", "Teacher");

        //given a header of type json and assert that the file will be a json, we will pass the body
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                //when the url passed will be:
                        when().
                patch(baseURI.concat("/users/2")).
                //then assert that status code is 201 and show response on console with .log().all()
                        then().
                statusCode(200).log().all();
    }


    @Test
    public void deletePatch(){
                //when the url passed will be:
                        when().
                delete(baseURI.concat("/users/2")).
                //then assert that status code is 201 and show response on console with .log().all()
                        then().
                statusCode(204).log().all();
    }
}

