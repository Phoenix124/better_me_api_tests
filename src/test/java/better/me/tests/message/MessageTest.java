package better.me.tests.message;

import better.me.model.message.Message;
import better.me.tests.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.List;

import static better.me.enums.UrlConstants.ATTACHMENT_URL;
import static better.me.enums.UrlConstants.MESSAGE_URL;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class MessageTest extends BaseTest {

    @Test(description = "Upload document with 200 code")
    public void uploadDocument() {
        File file = getFile("Byte.txt");

        Response response = given()
                .multiPart(file)
                .when()
                .post(ATTACHMENT_URL)
                .andReturn();

        assertEquals(HttpURLConnection.HTTP_CREATED, response.getStatusCode());
        assertNotNull(response.getBody());

        String fileId = response.as(String.class);
        List<Message> message = Collections.singletonList(getMessage(fileId));

        Response messageResponse = given()
                .contentType(ContentType.JSON)
                .body(message)
                .when()
                .post(MESSAGE_URL)
                .andReturn();

        assertEquals(HttpURLConnection.HTTP_OK, messageResponse.getStatusCode());
        assertNotNull(messageResponse.getBody());
    }
}
