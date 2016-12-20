package bs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by deepanshu.saxena on 16/08/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PartnerTaskMap {
    private String count;
    private String name;
    private String sub_issue_name; // Change here
    private String sub_issue_id; // Change here


    public String getSub_issue_id() {
        return sub_issue_id;
    }

    public void setSub_issue_id(String sub_issue_id) {
        this.sub_issue_id = sub_issue_id;
    }

    public String getSub_issue_name() {
        return sub_issue_name;
    }

    public void setSub_issue_name(String sub_issue_name) {
        this.sub_issue_name = sub_issue_name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

