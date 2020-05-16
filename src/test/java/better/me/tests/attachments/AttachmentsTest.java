package better.me.tests.attachments;

import better.me.model.message.Message;
import better.me.tests.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static better.me.enums.UrlConstants.ATTACHMENT_URL;
import static better.me.enums.UrlConstants.MESSAGE_URL;
import static io.restassured.RestAssured.given;

public class AttachmentsTest extends BaseTest {

    @Test(description = "Upload document with 200 code")
    public void uploadDocument() {
        File file = getFile("login_schema_response.json");

        String response = given()
                .multiPart(file)
                .when()
                .post(ATTACHMENT_URL)
                .then()
                .extract()
                .response().as(String.class);

        List<Message> message = Collections.singletonList(getMessage(response));

        Response messageResponse = given()
                .contentType(ContentType.JSON)
                .body(message)
                .when()
                .post(MESSAGE_URL)
                .andReturn();

        System.out.println(messageResponse.getBody().asString());
    }
}
