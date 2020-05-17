package better.me.tests;

import better.me.config.TestConfig;
import better.me.listeners.LogListener;
import better.me.model.message.*;
import com.github.javafaker.Faker;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.*;

import java.io.File;
import java.util.Collections;

import static io.restassured.RestAssured.given;

@Listeners(LogListener.class)
public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        RestAssured.baseURI = TestConfig.baseUrl;
        RestAssured.requestSpecification = given()
                .header("Language", "en");
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new AllureRestAssured());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        RestAssured.reset();
    }

    protected File getFile(String filename) {
        ClassLoader classLoader = BaseTest.class.getClassLoader();
        return new File(classLoader.getResource("files/" + filename).getFile());
    }

    protected Message getMessage(String fileOguid) {
        ToOrganization toOrganization = new ToOrganization();
        toOrganization.setOrgOguid("33194d4b-527a-45bb-aac6-17e43722c08d");

        Fields fields = new Fields();
        fields.setGrounds(null);
        fields.setSumVat("17.23");
        fields.setCurrency("RUR");
        fields.setSumTotal("1345.32");
        fields.setCostCenter(null);
        fields.setCostAccount(null);
        fields.setDocumentDate("1588118400000");
        fields.setPurchaseOrder(null);
        fields.setDocumentNumber("string");

        Detail detail = new Detail();

        SignedContent signedContent = new SignedContent();
        signedContent.setFileOguid(fileOguid);

        Document document = new Document();
        document.setType("universal_transfer_document.sf");
        document.setVersion("1");
        document.setFields(fields);
        document.setDetails(Collections.singletonList(detail));
        document.setSignedContent(signedContent);

        Message message = new Message();
        message.setMessageType("letter");
        message.setToOrganization(toOrganization);
        message.setDocuments(Collections.singletonList(document));
        return message;
    }

    protected Message getDefaultMessage() {
        ToOrganization toOrganization = new ToOrganization();
        toOrganization.setOrgOguid("875051bc-15e4-497a-91ec-1ef939a9b053");
        toOrganization.setSubOrgOguid("875051bc-15e4-497a-91ec-1ef939a9b053");

        ProxyOrg proxyOrg = new ProxyOrg();
        proxyOrg.setOrgOguid("875051bc-15e4-497a-91ec-1ef939a9b053");
        proxyOrg.setSubOrgOguid("875051bc-15e4-497a-91ec-1ef939a9b053");

        Fields fields = new Fields();
        fields.setGrounds(null);
        fields.setSumVat("17.23");
        fields.setCurrency("RUR");
        fields.setSumTotal("1345.32");
        fields.setCostCenter(null);
        fields.setCostAccount(null);
        fields.setDocumentDate("1588118400000");
        fields.setPurchaseOrder(null);
        fields.setDocumentNumber("string");

        Detail detail = new Detail();
        detail.setLineNumber(1);
        detail.setVat("vat18");
        detail.setSum(1234.5534);
        detail.setCurrency("RUR");
        detail.setIsPaid(true);
        detail.setDatePaid(121231234);

        SignedContent signedContent = new SignedContent();
        signedContent.setIsEncryptedContent(false);
        signedContent.setFileOguid("875051bc-15e4-497a-91ec-1ef939a9b053");
        signedContent.setSignatureOguid("875051bc-15e4-497a-91ec-1ef939a9b053");

        Document document = new Document();
        document.setType("string");
        document.setVersion("string");
        document.setParentOguid("875051bc-15e4-497a-91ec-1ef939a9b053");
        document.setInitialDocumentOguid("875051bc-15e4-497a-91ec-1ef939a9b053");
        document.setInitiatorOguid("875051bc-15e4-497a-91ec-1ef939a9b053");
        document.setSubOrgOguid("875051bc-15e4-497a-91ec-1ef939a9b053");
        document.setExternalId("string");
        document.setComment("string");
        document.setFields(fields);
        document.setDetails(Collections.singletonList(detail));
        document.setIsRequireRecipientSignature(true);
        document.setPackageKey(0);
        document.setSignedContent(signedContent);

        Message message = new Message();
        message.setToOrganization(toOrganization);
        message.setProxyOrg(proxyOrg);
        message.setDocuments(Collections.singletonList(document));
        return message;
    }

}
