package better.me.model.message;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "is_encrypted_content",
        "file_oguid",
        "signature_oguid"
})
public class SignedContent {

    @JsonProperty("is_encrypted_content")
    private Boolean isEncryptedContent;
    @JsonProperty("file_oguid")
    private String fileOguid;
    @JsonProperty("signature_oguid")
    private String signatureOguid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("is_encrypted_content")
    public Boolean getIsEncryptedContent() {
        return isEncryptedContent;
    }

    @JsonProperty("is_encrypted_content")
    public void setIsEncryptedContent(Boolean isEncryptedContent) {
        this.isEncryptedContent = isEncryptedContent;
    }

    @JsonProperty("file_oguid")
    public String getFileOguid() {
        return fileOguid;
    }

    @JsonProperty("file_oguid")
    public void setFileOguid(String fileOguid) {
        this.fileOguid = fileOguid;
    }

    @JsonProperty("signature_oguid")
    public String getSignatureOguid() {
        return signatureOguid;
    }

    @JsonProperty("signature_oguid")
    public void setSignatureOguid(String signatureOguid) {
        this.signatureOguid = signatureOguid;
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
