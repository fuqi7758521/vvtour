package com.usual.utils;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

public class InsertDocumentApp {
	
	public static void main(String[] args) {
		 
		try {
 
			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("chengtour");
 
			// get a single collection
			DBCollection collection = db.getCollection("tests");
 
			// BasicDBObject example
			System.out.println("BasicDBObject example...");
			BasicDBObject document = new BasicDBObject();
			document.put("admin_name", "alvin");
			document.put("real_name", "武尧");
 
			BasicDBObject documentDetail = new BasicDBObject();
			documentDetail.put("ADMIN_MNG", "http://fwe.url");
			documentDetail.put("index", "vps_index1");
			documentDetail.put("active", "true");
			document.put("right", documentDetail);
 
			collection.insert(document);
 
			DBCursor cursorDoc = collection.find();
			while (cursorDoc.hasNext()) {
				System.out.println(cursorDoc.next());
			}
 
			collection.remove(new BasicDBObject());
 
			// BasicDBObjectBuilder example
			System.out.println("BasicDBObjectBuilder example...");
			BasicDBObjectBuilder documentBuilder = BasicDBObjectBuilder.start()
				.add("database", "chengtour")
                                .add("table", "hosting");
 
			BasicDBObjectBuilder documentBuilderDetail = BasicDBObjectBuilder.start()
                                .add("records", "99")
                                .add("index", "vps_index1")
				.add("active", "true");
 
			documentBuilder.add("detail", documentBuilderDetail.get());
 
			collection.insert(documentBuilder.get());
 
			DBCursor cursorDocBuilder = collection.find();
			while (cursorDocBuilder.hasNext()) {
				System.out.println(cursorDocBuilder.next());
			}
 
			collection.remove(new BasicDBObject());
 
			// Map example
			System.out.println("Map example...");
			Map<String, Object> documentMap = new HashMap<String, Object>();
			documentMap.put("database", "mkyongDB");
			documentMap.put("table", "hosting");
 
			Map<String, Object> documentMapDetail = new HashMap<String, Object>();
			documentMapDetail.put("records", "99");
			documentMapDetail.put("index", "vps_index1");
			documentMapDetail.put("active", "true");
 
			documentMap.put("detail", documentMapDetail);
 
			collection.insert(new BasicDBObject(documentMap));
 
			DBCursor cursorDocMap = collection.find();
			while (cursorDocMap.hasNext()) {
				System.out.println(cursorDocMap.next());
			}
 
			collection.remove(new BasicDBObject());
 
			// JSON parse example
			System.out.println("JSON parse example...");
 
			String json = "{'database' : 'mkyongDB','table' : 'hosting'," +
			"'detail' : {'records' : 99, 'index' : 'vps_index1', 'active' : 'true'}}}";
 
			DBObject dbObject = (DBObject)JSON.parse(json);
 
			collection.insert(dbObject);
 
			DBCursor cursorDocJSON = collection.find();
			while (cursorDocJSON.hasNext()) {
				System.out.println(cursorDocJSON.next());
			}
 
			collection.remove(new BasicDBObject());
 
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}
 
	}

}
