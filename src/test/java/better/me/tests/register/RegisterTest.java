package better.me.tests.register;

import better.me.payloads.UserPayload;
import better.me.tests.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static better.me.enums.UrlConstants.REGISTER_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RegisterTest extends BaseTest {

    @Test(description = "Register user with valid data and valid response schema")
    public void registerUserWithValidData() {
        UserPayload userPayload = new UserPayload(FAKER.name().username(), "test", "bob@gmail.com");

        given()
                .body(userPayload)
                .when()
                .post(REGISTER_URL)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(matchesJsonSchemaInClasspath("schemas/register_schema_response.json"));
    }

    @Test(description = "Register user with empty username and get 500 code error")
    public void registerUserWithEmptyUsername() {
        UserPayload userPayload = new UserPayload("", "test", "bob@gmail.com");

        given()
                .body(userPayload)
                .when()
                .post(REGISTER_URL)
                .then()
                .assertThat()
                .statusCode(500);
    }

    @Test(description = "Register user with empty password and get 500 code error")
    public void registerUserWithEmptyPassword() {
        UserPayload userPayload = new UserPayload(FAKER.name().username(), "", "bob@gmail.com");

        given()
                .body(userPayload)
                .when()
                .post(REGISTER_URL)
                .then()
                .assertThat()
                .statusCode(500);
    }

    @Test(description = "Register user with empty email and get 500 code error")
    public void registerUserWithEmptyEmail() {
        UserPayload userPayload = new UserPayload(FAKER.name().username(), "test", "");

        given()
                .body(userPayload)
                .when()
                .post(REGISTER_URL)
                .then()
                .assertThat()
                .statusCode(500);
    }

    @Test(description = "Register user with empty fields and get 500 code error")
    public void registerUserWithEmptyFields() {
        UserPayload userPayload = new UserPayload();

        given()
                .body(userPayload)
                .when()
                .post(REGISTER_URL)
                .then()
                .assertThat()
                .statusCode(500);
    }

    @Test(description = "Register user with valid request method")
    public void registerUserWithInvalidRequest() {
        given()
                .when()
                .get(REGISTER_URL)
                .then()
                .assertThat()
                .statusCode(404);
    }
}
