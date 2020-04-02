package better.me.tests;

import better.me.config.TestConfig;
import better.me.listeners.LogListener;
import com.github.javafaker.Faker;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;

@Listeners(LogListener.class)
public class BaseTest {

    protected Faker FAKER = new Faker();

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        RestAssured.baseURI = TestConfig.baseUrl;
        RestAssured.requestSpecification = given()
                .contentType(ContentType.JSON)
                .header("Language", "en");
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new AllureRestAssured());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        RestAssured.reset();
    }

}
