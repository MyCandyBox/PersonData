package com.data.oc.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.conversions.Bson;

import java.util.List;

/**
 * Created by Administrator on 2016/1/3.
 */
public class mongoFactory {

    private String host;
    private int port;
    private String username;
    private String password;

    private static MongoClient mongoClient = null;
    private static MongoDatabase db = null;
    public static MongoDatabase getMongoDD(){

        ServerAddress serverAddress = new ServerAddress("127.0.0.1",27017);
        mongoClient = new MongoClient(serverAddress);
        db = mongoClient.getDatabase("dev");
        return db;
    }
    public static void main(String arge[]){
        try {
            MongoDatabase myDB = mongoFactory.getMongoDD();
            MongoIterable list = myDB.listCollectionNames();
            for (Object item:list
                 ) {
                System.out.print(item.toString());
            }
           MongoCollection col =  myDB.getCollection("abc");


           System.out.print(col.find(new BasicDBObject("username","lu")).first());

            System.out.print("sucess");
        }catch (Exception e){
            e.printStackTrace();
            System.out.print("fail");
        }
    }

}
