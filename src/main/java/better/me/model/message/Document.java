package better.me.model.message;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "version",
        "parent_oguid",
        "initial_document_oguid",
        "initiator_oguid",
        "sub_org_oguid",
        "external_id",
        "comment",
        "fields",
        "details",
        "is_require_recipient_signature",
        "package_key",
        "signed_content"
})
public class Document {

    @JsonProperty("type")
    private String type;
    @JsonProperty("version")
    private String version;
    @JsonProperty("parent_oguid")
    private String parentOguid;
    @JsonProperty("initial_document_oguid")
    private String initialDocumentOguid;
    @JsonProperty("initiator_oguid")
    private String initiatorOguid;
    @JsonProperty("sub_org_oguid")
    private String subOrgOguid;
    @JsonProperty("external_id")
    private String externalId;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("fields")
    private Fields fields;
    @JsonProperty("details")
    private List<Detail> details = null;
    @JsonProperty("is_require_recipient_signature")
    private Boolean isRequireRecipientSignature;
    @JsonProperty("package_key")
    private Integer packageKey;
    @JsonProperty("signed_content")
    private SignedContent signedContent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("parent_oguid")
    public String getParentOguid() {
        return parentOguid;
    }

    @JsonProperty("parent_oguid")
    public void setParentOguid(String parentOguid) {
        this.parentOguid = parentOguid;
    }

    @JsonProperty("initial_document_oguid")
    public String getInitialDocumentOguid() {
        return initialDocumentOguid;
    }

    @JsonProperty("initial_document_oguid")
    public void setInitialDocumentOguid(String initialDocumentOguid) {
        this.initialDocumentOguid = initialDocumentOguid;
    }

    @JsonProperty("initiator_oguid")
    public String getInitiatorOguid() {
        return initiatorOguid;
    }

    @JsonProperty("initiator_oguid")
    public void setInitiatorOguid(String initiatorOguid) {
        this.initiatorOguid = initiatorOguid;
    }

    @JsonProperty("sub_org_oguid")
    public String getSubOrgOguid() {
        return subOrgOguid;
    }

    @JsonProperty("sub_org_oguid")
    public void setSubOrgOguid(String subOrgOguid) {
        this.subOrgOguid = subOrgOguid;
    }

    @JsonProperty("external_id")
    public String getExternalId() {
        return externalId;
    }

    @JsonProperty("external_id")
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
    }

    @JsonProperty("fields")
    public Fields getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(Fields fields) {
        this.fields = fields;
    }

    @JsonProperty("details")
    public List<Detail> getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    @JsonProperty("is_require_recipient_signature")
    public Boolean getIsRequireRecipientSignature() {
        return isRequireRecipientSignature;
    }

    @JsonProperty("is_require_recipient_signature")
    public void setIsRequireRecipientSignature(Boolean isRequireRecipientSignature) {
        this.isRequireRecipientSignature = isRequireRecipientSignature;
    }

    @JsonProperty("package_key")
    public Integer getPackageKey() {
        return packageKey;
    }

    @JsonProperty("package_key")
    public void setPackageKey(Integer packageKey) {
        this.packageKey = packageKey;
    }

    @JsonProperty("signed_content")
    public SignedContent getSignedContent() {
        return signedContent;
    }

    @JsonProperty("signed_content")
    public void setSignedContent(SignedContent signedContent) {
        this.signedContent = signedContent;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
