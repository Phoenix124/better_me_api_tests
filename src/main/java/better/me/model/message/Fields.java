package better.me.model.message;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "line_number\"",
        "vat",
        "sum",
        "currency",
        "is_paid",
        "date_paid"
})
public class Fields {

    @JsonProperty("line_number\"")
    private Integer lineNumber;
    @JsonProperty("vat")
    private String vat;
    @JsonProperty("sum")
    private Double sum;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("is_paid")
    private Boolean isPaid;
    @JsonProperty("date_paid")
    private Integer datePaid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("line_number\"")
    public Integer getLineNumber() {
        return lineNumber;
    }

    @JsonProperty("line_number\"")
    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    @JsonProperty("vat")
    public String getVat() {
        return vat;
    }

    @JsonProperty("vat")
    public void setVat(String vat) {
        this.vat = vat;
    }

    @JsonProperty("sum")
    public Double getSum() {
        return sum;
    }

    @JsonProperty("sum")
    public void setSum(Double sum) {
        this.sum = sum;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("is_paid")
    public Boolean getIsPaid() {
        return isPaid;
    }

    @JsonProperty("is_paid")
    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    @JsonProperty("date_paid")
    public Integer getDatePaid() {
        return datePaid;
    }

    @JsonProperty("date_paid")
    public void setDatePaid(Integer datePaid) {
        this.datePaid = datePaid;
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