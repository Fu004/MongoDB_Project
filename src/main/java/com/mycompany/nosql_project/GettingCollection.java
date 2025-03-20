package com.mycompany.nosql_project;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.mycompany.nosql_project.MongoDBUtils;
import com.mycompany.nosql_project.MyConstants;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class GettingCollection {

   public static void main(String[] args) throws UnknownHostException {

       MongoClient mongoClient = MongoDBUtils.getMongoClient();
       DB db = mongoClient.getDB(MyConstants.DB_NAME);

       // Collection trong MongoDB tương đương với Table trong
       // cơ sở dữ liệu quan hệ (Oracle, MySQL,SQLServer,..)
       DBCollection dept = db.getCollection("Department");
       
       System.out.println("Collection: "+ dept);
       
       // Số Document.
       // Chú ý: Document trong MongoDB tương ứng với 1 dòng
       // dữ liệu trong cơ sở dữ liệu quan hệ.
       long rowCount = dept.count();
       System.out.println(" Document count: "+ rowCount);
       
       System.out.println(" ------------ ");
       
       // Danh sách tất cả Các Collection.
       Set<String> collections = db.getCollectionNames();
       
       for(String coll: collections)  {
           System.out.println("Collection: "+ coll);
       }
       
   }

}