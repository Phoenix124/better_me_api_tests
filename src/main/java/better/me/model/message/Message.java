package better.me.model.message;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "to_org",
        "proxy_org",
        "documents"
})
public class Message {

    @JsonProperty("message_type")
    private String messageType;
    @JsonProperty("to_org")
    private ToOrganization toOrganization;
    @JsonProperty("proxy_org")
    private ProxyOrg proxyOrg;
    @JsonProperty("documents")
    private List<Document> documents = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("message_type")
    public String getMessageType() {
        return messageType;
    }

    @JsonProperty("message_type")
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @JsonProperty("to_org")
    public ToOrganization getToOrganization() {
        return toOrganization;
    }

    @JsonProperty("to_org")
    public void setToOrganization(ToOrganization toOrganization) {
        this.toOrganization = toOrganization;
    }

    @JsonProperty("proxy_org")
    public ProxyOrg getProxyOrg() {
        return proxyOrg;
    }

    @JsonProperty("proxy_org")
    public void setProxyOrg(ProxyOrg proxyOrg) {
        this.proxyOrg = proxyOrg;
    }

    @JsonProperty("documents")
    public List<Document> getDocuments() {
        return documents;
    }

    @JsonProperty("documents")
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
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