import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class GetAndPostExamples {
    private final String baseURI = "https://reqres.in/api";


    @Test
    public void testGet() {

        //given an url
        given().
                get(baseURI.concat("/users?page=2")).
        //then assert that status code is 200 and the body should be equals position and has the following items
        then().
                statusCode(200).
                body("data[4].first_name", equalTo("George")).
                body("data.first_name", hasItems("George", "Rachel"));
    }

    @Test
    public void testPost() {
        Map<String, Object> map = new HashMap<>();

        //building a map and convert to json format
        JSONObject request = new JSONObject(map);
        request.put("name", "Raghav");
        request.put("job", "Teacher");


        System.out.println(request.toJSONString());

        //given a header of type json and assert that the file will be a json, we will pass the body
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        //when the url passed will be:
        when().
                post(baseURI.concat("/users")).
        //then assert that status code is 201 and show response on console with .log().all()
        then().
        statusCode(201).log().all();
    }
}
