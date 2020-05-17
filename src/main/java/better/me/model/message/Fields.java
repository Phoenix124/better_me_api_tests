package better.me.model.message;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "grounds",
        "sum_vat",
        "currency",
        "sum_total",
        "cost_center",
        "cost_account",
        "document_date",
        "purchase_order",
        "document_number"
})
public class Fields {

    @JsonProperty("grounds")
    private Object grounds;
    @JsonProperty("sum_vat")
    private String sumVat;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("sum_total")
    private String sumTotal;
    @JsonProperty("cost_center")
    private Object costCenter;
    @JsonProperty("cost_account")
    private Object costAccount;
    @JsonProperty("document_date")
    private String documentDate;
    @JsonProperty("purchase_order")
    private Object purchaseOrder;
    @JsonProperty("document_number")
    private String documentNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("grounds")
    public Object getGrounds() {
        return grounds;
    }

    @JsonProperty("grounds")
    public void setGrounds(Object grounds) {
        this.grounds = grounds;
    }

    @JsonProperty("sum_vat")
    public String getSumVat() {
        return sumVat;
    }

    @JsonProperty("sum_vat")
    public void setSumVat(String sumVat) {
        this.sumVat = sumVat;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("sum_total")
    public String getSumTotal() {
        return sumTotal;
    }

    @JsonProperty("sum_total")
    public void setSumTotal(String sumTotal) {
        this.sumTotal = sumTotal;
    }

    @JsonProperty("cost_center")
    public Object getCostCenter() {
        return costCenter;
    }

    @JsonProperty("cost_center")
    public void setCostCenter(Object costCenter) {
        this.costCenter = costCenter;
    }

    @JsonProperty("cost_account")
    public Object getCostAccount() {
        return costAccount;
    }

    @JsonProperty("cost_account")
    public void setCostAccount(Object costAccount) {
        this.costAccount = costAccount;
    }

    @JsonProperty("document_date")
    public String getDocumentDate() {
        return documentDate;
    }

    @JsonProperty("document_date")
    public void setDocumentDate(String documentDate) {
        this.documentDate = documentDate;
    }

    @JsonProperty("purchase_order")
    public Object getPurchaseOrder() {
        return purchaseOrder;
    }

    @JsonProperty("purchase_order")
    public void setPurchaseOrder(Object purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    @JsonProperty("document_number")
    public String getDocumentNumber() {
        return documentNumber;
    }

    @JsonProperty("document_number")
    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
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