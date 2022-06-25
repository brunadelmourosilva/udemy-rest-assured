import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestExamples {

    @Test
    public void testOne() {

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        int statusCode = response.getStatusCode();

        System.out.println(statusCode);
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.header("content-type"));

        assertEquals(statusCode, 200);
    }
}
