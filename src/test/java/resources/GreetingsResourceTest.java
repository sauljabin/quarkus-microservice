package resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingsResourceTest {

    @Test
    public void testHelloEndpoint() throws UnknownHostException {
        given()
                .when().get("/greetings")
                .then()
                .statusCode(200)
                .body("message", is("Hello World!!!, I am " + InetAddress.getLocalHost().getHostName()));
    }

}