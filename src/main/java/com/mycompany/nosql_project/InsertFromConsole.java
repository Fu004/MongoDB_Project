package com.mycompany.nosql_project;

import java.net.UnknownHostException;

import com.mycompany.nosql_project.MongoDBUtils;
import com.mycompany.nosql_project.MyConstants;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import java.util.Scanner;
import jdk.jfr.Description;

public class InsertFromConsole {

 public static void main(String args[]) throws UnknownHostException {

      // Kết nối tới MongoDB.
     MongoClient mongoClient = MongoDBUtils.getMongoClient();

     // Kết nối tới Database
     // (Không nhất thiết DB này phải tồn tại sẵn
     // nó sẽ được tự động tạo ra nếu chưa tồn tại).
     DB db = mongoClient.getDB(MyConstants.DB_NAME);

     // Lấy ra Collection với tên Department.
     // Không nhất thiết Collection này phải tồn tại trong DB.
     DBCollection dept = db.getCollection("Department");
     Scanner sc = new Scanner(System.in);
     
     
     
     System.out.println("Enter Dep_Id:");
     int id = sc.nextInt();
     System.out.println("Enter Dept_No:");
     String deptno = sc.nextLine();
     System.out.println("Enter Dept_Name:");
     String deptname = sc.nextLine();
     System.out.println("Enter Dept_Location:");
     String location = sc.nextLine();
     System.out.println("Enter Dept_DesCription:");
     String des = sc.nextLine();
     
     // Insert Document 1
     BasicDBObject doc1 = new BasicDBObject();
     doc1.append("_id", id);
     doc1.append("dept_no", deptno);
     doc1.append("dept_name", deptname);
     doc1.append("location", location);
     doc1.append("Description", des);
     dept.insert(doc1);
   
     System.out.println("Done!");
 }
}