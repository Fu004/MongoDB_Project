package com.mycompany.nosql_project;

import java.net.UnknownHostException;

import com.mycompany.nosql_project.MongoDBUtils;
import com.mycompany.nosql_project.MyConstants;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class QueryDemo {

  public static void main(String args[]) throws UnknownHostException {
   
      // Kết nối tới MongoDB.
      MongoClient mongoClient = MongoDBUtils.getMongoClient();

      DB db = mongoClient.getDB(MyConstants.DB_NAME);

      DBCollection dept = db.getCollection("Department");

      // Truy vấn tất cả các object trong Collection.
      DBCursor cursor = dept.find();
      int i = 1;
      while (cursor.hasNext()) {
          System.out.println("Document: " + i);
          System.out.println(cursor.next());
          i++;
      }//hello

  }
}