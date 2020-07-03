package resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingsResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/greetings")
                .then()
                .statusCode(200)
                .body("message", is("Hello World!!!"));
    }

}