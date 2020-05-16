package better.me.model.message;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "org_oguid",
        "sub_org_oguid"
})
public class ToOrganization {

    @JsonProperty("org_oguid")
    private String orgOguid;
    @JsonProperty("sub_org_oguid")
    private String subOrgOguid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("org_oguid")
    public String getOrgOguid() {
        return orgOguid;
    }

    @JsonProperty("org_oguid")
    public void setOrgOguid(String orgOguid) {
        this.orgOguid = orgOguid;
    }

    @JsonProperty("sub_org_oguid")
    public String getSubOrgOguid() {
        return subOrgOguid;
    }

    @JsonProperty("sub_org_oguid")
    public void setSubOrgOguid(String subOrgOguid) {
        this.subOrgOguid = subOrgOguid;
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
