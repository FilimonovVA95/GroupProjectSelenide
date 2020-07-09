package company.name.positive;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAssuredTest {

    @Test
    public void getResource() {
        when()
                .get("https://jsonplaceholder.typicode.com/posts/65").
        then()
                .statusCode(200)
                .assertThat().body("id", equalTo(65), "userId", equalTo(7))
                .log().all();
    }

    @Test
    public void postCreateResource() {
        given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body("{\n" +
                        "    \"title\": \"oneMassage\",\n" +
                        "    \"body\": \"twoMessage\",\n" +
                        "    \"userId\": \"007\"\n" +
                        "}").
        when()
                .post("https://jsonplaceholder.typicode.com/posts").
        then()
                .statusCode(201).log().all();
    }

    @Test
    public void putUpdateResource() {
        given()
                .header("Content-Type", "Application/Json")
                .body("{\n" +
                        "    \"id\": \"11\",\n" +
                        "    \"title\": \"threeMessage\",\n" +
                        "    \"body\": \"fourMessage\",\n" +
                        "    \"userId\": \"7\"\n" +
                        "}").
        when()
                .put("https://jsonplaceholder.typicode.com/posts/11").
        then()
                .statusCode(200).log().all();
    }
}
