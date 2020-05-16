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

    protected Faker FAKER = new Faker();

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
        return new File(classLoader.getResource("schemas/" + filename).getFile());
    }

    protected Message getMessage(String fileOguid) {
        ToOrganization toOrganization = new ToOrganization();
        toOrganization.setOrgOguid("875051bc-15e4-497a-91ec-1ef939a9b053");
        toOrganization.setSubOrgOguid("875051bc-15e4-497a-91ec-1ef939a9b053");

        ProxyOrg proxyOrg = new ProxyOrg();
        proxyOrg.setOrgOguid("875051bc-15e4-497a-91ec-1ef939a9b053");
        proxyOrg.setSubOrgOguid("875051bc-15e4-497a-91ec-1ef939a9b053");

        Fields fields = new Fields();
        fields.setLineNumber(1);
        fields.setVat("vat18");
        fields.setSum(12345.5534);
        fields.setCurrency("RUB");
        fields.setIsPaid(true);
        fields.setDatePaid(121231234);

        Detail detail = new Detail();
        detail.setLineNumber(1);
        detail.setVat("vat18");
        detail.setSum(1234.5534);
        detail.setCurrency("RUR");
        detail.setIsPaid(true);
        detail.setDatePaid(121231234);

        SignedContent signedContent = new SignedContent();
        signedContent.setIsEncryptedContent(false);
        signedContent.setFileOguid(fileOguid);
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

    protected Message getDefaultMessage() {
        ToOrganization toOrganization = new ToOrganization();
        toOrganization.setOrgOguid("875051bc-15e4-497a-91ec-1ef939a9b053");
        toOrganization.setSubOrgOguid("875051bc-15e4-497a-91ec-1ef939a9b053");

        ProxyOrg proxyOrg = new ProxyOrg();
        proxyOrg.setOrgOguid("875051bc-15e4-497a-91ec-1ef939a9b053");
        proxyOrg.setSubOrgOguid("875051bc-15e4-497a-91ec-1ef939a9b053");

        Fields fields = new Fields();
        fields.setLineNumber(1);
        fields.setVat("vat18");
        fields.setSum(12345.5534);
        fields.setCurrency("RUB");
        fields.setIsPaid(true);
        fields.setDatePaid(121231234);

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
