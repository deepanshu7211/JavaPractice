package mongoDb;

import java.util.List;

/**
 * Created by deepanshu.saxena on 23/08/16.
 */

public class ReportRow {
    private List<String> rowDataList;

    public List<String> getRowDataList() {
        return rowDataList;
    }

    public void setRowDataList(List<String> rowDataList) {
        this.rowDataList = rowDataList;
    }


    public String toHtml() {

        StringBuilder tableRow = new StringBuilder();
        tableRow.append("<tr>");
        for (String rowData : rowDataList) {
            if (rowData == null) {
                rowData = "-";
            }

            tableRow.append("<td style='color:black;padding: 2pt 3pt;border:1px solid'  >" + (rowData.isEmpty() ? "-" : rowData) + "</td>");
        }
        //tableRow="<tr><td align=\"center\" >"+rowDataList.get(0)+"</td><td align=\"center\" >"+rowDataList.get(1)+"</td></tr>";
        return tableRow.toString();

    }
}
