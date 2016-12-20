package mongoDb;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Filters.*;

/**
 * Created by deepanshu.saxena on 01/06/16.
 */
public class MongoExample {
    public static void main(String[] args) {
//          insert();
//          retrieve();
//            aggregate();
//          retriveOr();
        try {
            try {
                retrieveFromAudit();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public static void insert() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("deep");
        System.out.println("connected to DB successfully");
        DBCollection collection = db.getCollection("users");
        System.out.println("collections users selected successfully");
        BasicDBObject doc = new BasicDBObject("name", "abc").append("email", "abc@gmail.com");
        collection.insert(doc);
        System.out.println("document insert successfully");

    }

    public static void retrieve() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("deep");
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("users");
        FindIterable<Document> iterable_documents = mongoCollection.find(
                and(
                        gte("time", "startdate"),
                        lt("time2", "endDate")));

        for (Document document : mongoCollection.find()) {
            System.out.println("DB Record :: \t \t " + document.toJson());
        }
    }

    public static void retrieveFromAudit() throws ParseException, IOException {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("deep");


        Date endDate = DateTime.now().withTimeAtStartOfDay().toDate();  // toString("yyyy-MM-dd HH:mm:ss");
        Date startDate = DateTime.now().minusDays(1).withTimeAtStartOfDay().toDate();  //.toString("yyyy-MM-dd HH:mm:ss");
        System.out.println(startDate);
        System.out.println(endDate);


        long epochStart = startDate.getTime() / 1000;
        long epochEnd = endDate.getTime() / 1000;

        System.out.println(" epochStart :: " + epochStart);
        System.out.println(" epochEnd :: " + epochEnd);


        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("audit");
        FindIterable<Document> iterable_documents = mongoCollection.find(
                and(
                        gte("event_time", epochStart),
                        lte("event_time", epochEnd)));

        List<Document> results = new ArrayList<Document>();

        MongoCursor<Document> iterator = iterable_documents.iterator();
        while (iterator.hasNext()) {
            results.add(iterator.next());
        }

        ObjectMapper objectMapper = new ObjectMapper();
        List<ReturnInfo> returnInfoList = new ArrayList<>();

        for (Document document : results) {
            ReturnInfo returnInfo = objectMapper.readValue(document.toJson(), ReturnInfo.class);
            System.out.println(returnInfo);

            returnInfoList.add(returnInfo);
        }


        System.out.println(results.size());
        System.out.println(returnInfoList.size());


        List<ReportRow> reportRowList = new ArrayList<ReportRow>();
        BreachReport breachReport = new BreachReport();
        breachReport.setMessage("    ");

        breachReport.setReportName("  ");

        List<String> columnHeaderList = new ArrayList<String>();
        columnHeaderList.add("ReturnId");
        columnHeaderList.add("OrderId");
        columnHeaderList.add("ReturnStatus");
        columnHeaderList.add("ReturnAction");
        columnHeaderList.add("CreatedBy");
        columnHeaderList.add("Comments");
        columnHeaderList.add("CreatedAt");
        columnHeaderList.add("ReturnReason");
        columnHeaderList.add("ReturnSubReason");
        columnHeaderList.add("Amount");

        breachReport.setColumnHeaderList(columnHeaderList);
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        for (ReturnInfo returnInfo : returnInfoList) {
            ReportRow reportRow = new ReportRow();
            List<String> row = new ArrayList<String>();

            row.add(returnInfo.getReturn_id());
            row.add(returnInfo.getOrder_id());
            row.add(returnInfo.getReturn_status());
            row.add(returnInfo.getChosen_action());
            row.add(returnInfo.getAgent_id());
            row.add(returnInfo.getNotes());
            String createdBy = formatter.parseDateTime(returnInfo.getCreated_at()).toString("yyyy-MM-dd HH:mm:ss");
            row.add(createdBy);
//            row.add(returnInfo.getCreated_at());
            row.add(returnInfo.getReason());
            row.add(returnInfo.getSub_reason());
            row.add(String.valueOf(returnInfo.getAmount_given()));

            reportRow.setRowDataList(row);

            reportRowList.add(reportRow);

        }

        breachReport.setReportRowList(reportRowList);

        System.out.println(breachReport.toHtml());

//        MailHelper.sendMail()


//        System.out.println(new Gson().toJson(results));
    }

    public static void aggregate() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("deep");
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("users");


        // Mongo DB Query to Java
        //db.users.aggregate( [{ $match: { status:"A" } },{ $group: {_id : "$cust_id",total:{ $sum:"$amount"}}}])
        // http://pingax.com/trick-convert-mongo-shell-query-equivalent-java-objects/

//        AggregateIterable<Document> aggregateIterable= mongoCollection.aggregate(Arrays.asList(
//                     new Document("$match", new Document("status", "A")),
//                     new Document("$group", new Document("_id", "$cust_id")
//                    .append("total", new Document("$sum", "$amount")))));

        AggregateIterable<Document> aggregateIterable = mongoCollection.aggregate(Arrays.asList(match(eq("status", "A")), group("$cust_id", Accumulators.sum("total", "$amount"))));


        for (Document document : aggregateIterable) {
            System.out.println(document.toJson());
        }
    }

    public static void retriveOr() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("deep");
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("users");
        // db.users.find({cust_id:"A123"},{cust_id:"B123"})
        //http://mongodb.github.io/mongo-java-driver/3.1/builders/filters/
//        FindIterable<Document> findIterable= mongoCollection.find(Filters.and(new Document("cust_id","A123"),new Document("cust_id","B123")));

//        db.users.find({$or:[{cust_id:"A123"},{cust_id:"B123"}]})

//        FindIterable<Document> findIterable= mongoCollection.find(Filters.or(eq("cust_id", "A123"), eq("cust_id", "B123")));

        FindIterable<Document> findIterable = mongoCollection.find(Filters.or(eq("cust_id", "A123"), eq("cust_id", "B123")));

        for (Document document : findIterable) {
            System.out.println(document);
        }
    }
}


// Mongo DB Queries

//db.users.find({$or:[{cust_id:"A123"},{cust_id:"B123"}]})
//
//db.users.find({cust_id:"A123"},{cust_id:"B123"})
//
//db.users.find()
//
//db.users.aggregate( [{ $match: { status:"A" } },{ $group: {_id : "$cust_id",total:{ $sum:"$amount"}}}])