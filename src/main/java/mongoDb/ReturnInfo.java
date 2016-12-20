package mongoDb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by deepanshu.saxena on 23/08/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReturnInfo {

    private String return_id;
    private String order_id;
    private String return_status;
    private String chosen_action;
    private String agent_id;
    private String notes;
    private String created_at;
    private String reason;
    private String sub_reason;
    private double amount_given;

    public String getReturn_id() {
        return return_id;
    }

    public void setReturn_id(String return_id) {
        this.return_id = return_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getReturn_status() {
        return return_status;
    }

    public void setReturn_status(String return_status) {
        this.return_status = return_status;
    }

    public String getChosen_action() {
        return chosen_action;
    }

    public void setChosen_action(String chosen_action) {
        this.chosen_action = chosen_action;
    }

    public String getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(String agent_id) {
        this.agent_id = agent_id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSub_reason() {
        return sub_reason;
    }

    public void setSub_reason(String sub_reason) {
        this.sub_reason = sub_reason;
    }

    public double getAmount_given() {
        return amount_given;
    }

    public void setAmount_given(double amount_given) {
        this.amount_given = amount_given;
    }

    @Override
    public String toString() {
        return "ReturnInfo{" +
                "return_id='" + return_id + '\'' +
                ", order_id='" + order_id + '\'' +
                ", return_status='" + return_status + '\'' +
                ", chosen_action='" + chosen_action + '\'' +
                ", agent_id='" + agent_id + '\'' +
                ", notes='" + notes + '\'' +
                ", created_at='" + created_at + '\'' +
                ", reason='" + reason + '\'' +
                ", sub_reason='" + sub_reason + '\'' +
                ", amount_given=" + amount_given +
                '}';
    }
}
