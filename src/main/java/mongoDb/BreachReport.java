package mongoDb;

import java.util.List;

/**
 * Created by deepanshu.saxena on 23/08/16.
 */
public class BreachReport {
    private String reportName;
    private String message;
    private List<String> columnHeaderList;
    private List<ReportRow> reportRowList;


    //reportRowList means complete one row
    // add column header in the columnHeaderList


    public String toHtml() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html><body>" + message + "<h2 align=\"center\">" + reportName + "</h2><br/><div style='width:1800px; margin-bottom: 20px'><table style='border-collapse:collapse'><thead><tr>");

        // Newly Added for CallSchedule Status Purpose *********
        if (columnHeaderList == null) {
            stringBuilder.append("</table></div><p>, \n" + "<br></p></body></html>");
            return stringBuilder.toString();
        }
        //Till here
        for (String columnName : columnHeaderList) {

            stringBuilder.append("<th style='background:rgb(186, 186, 186);color:black;padding: 2pt 3pt;border:1px solid'>" + (columnName.isEmpty() ? "-" : columnName) + "</th>");

        }

        stringBuilder.append("</tr></thead>");
        //serialize columnHeaderList
        for (ReportRow row : reportRowList) {
            stringBuilder.append(row.toHtml());
        }
        stringBuilder.append("</table><p>, \n" + "<br></p></body></html>");


        return stringBuilder.toString();


    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ReportRow> getReportRowList() {
        return reportRowList;
    }

    public void setReportRowList(List<ReportRow> reportRowList) {
        this.reportRowList = reportRowList;
    }

    public List<String> getColumnHeaderList() {
        return columnHeaderList;
    }

    public void setColumnHeaderList(List<String> columnHeaderList) {
        this.columnHeaderList = columnHeaderList;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }
}
