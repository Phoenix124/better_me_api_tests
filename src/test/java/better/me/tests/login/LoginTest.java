package better.me.tests.login;

import better.me.dataprovider.UserCredentials;
import better.me.tests.BaseTest;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static better.me.enums.UrlConstants.Login_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class LoginTest extends BaseTest {

    @Test(description = "Login user with valid credentials",
            dataProvider = "userCredential", dataProviderClass = UserCredentials.class)
    public void loginUserWithValidData(String username, String password) {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(username);
        authScheme.setPassword(password);
        RestAssured.authentication = authScheme;

        given()
                .when()
                .get(Login_URL)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test(description = "Login user with valid credentials and valid response schema",
            dataProvider = "userCredential", dataProviderClass = UserCredentials.class)
    public void loginUserWithValidDataAndInvalidSchema(String username, String password) {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(username);
        authScheme.setPassword(password);
        RestAssured.authentication = authScheme;

        given()
                .when()
                .get(Login_URL)
                .then()
                .assertThat()
                .statusCode(200)
                .and().body(matchesJsonSchemaInClasspath("schemas/login_schema_response.json"));
    }

    @Test(description = "Login without credentials")
    public void loginWithoutCredentials() {
        given()
                .when()
                .get(Login_URL)
                .then()
                .assertThat()
                .statusCode(401);
    }

    @Test(description = "Login with invalid request method",
            dataProvider = "userCredential", dataProviderClass = UserCredentials.class)
    public void loginWithInvalidRequest(String username, String password) {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(username);
        authScheme.setPassword(password);
        RestAssured.authentication = authScheme;

        given()
                .when()
                .post(Login_URL)
                .then()
                .assertThat()
                .statusCode(404);
    }

    @Test(description = "Login with valid request method and expect valid content type",
            dataProvider = "userCredential", dataProviderClass = UserCredentials.class)
    public void loginWithInvalidResponseContentType(String username, String password) {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(username);
        authScheme.setPassword(password);
        RestAssured.authentication = authScheme;

        given()
                .when()
                .get(Login_URL)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON);
    }

    @Test(description = "Login with invalid request method")
    public void loginUserWithInValidData() {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("username");
        authScheme.setPassword("password");
        RestAssured.authentication = authScheme;

        given()
                .when()
                .get(Login_URL)
                .then()
                .assertThat()
                .statusCode(401);
    }
}
