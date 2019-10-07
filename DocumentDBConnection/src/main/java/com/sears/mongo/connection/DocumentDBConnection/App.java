package com.sears.mongo.connection.DocumentDBConnection;

import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		String template = "mongodb://%s:%s@%s/giftRegistry?ssl=true&replicaSet=rs0&readpreference=%s";
		String username = "grappUser";
		String password = "grappUser";
		String clusterEndpoint = "giftregistry-db.cluster-c3ekl0nftuic.us-east-2.docdb.amazonaws.com:27017";
		String readPreference = "secondaryPreferred";
		String connectionString = String.format(template, username, password, clusterEndpoint, readPreference);
		
		System.out.println(connectionString);

		String keystore = "C:\\Users\\nattar\\Downloads\\rds-ca-certs";
		String keystorePassword = "grappUser";

		System.setProperty("javax.net.ssl.trustStore", keystore);
		System.setProperty("javax.net.ssl.trustStorePassword", keystorePassword);

		MongoClientURI clientURI = new MongoClientURI(connectionString);

		try {
			MongoClient mongoClient = new MongoClient(clientURI);
			List<String> dbs = mongoClient.getDatabaseNames();
			System.out.println(dbs);
		} catch (Exception e) {
			System.out.println(e);
		}

//        MongoDatabase testDB = mongoClient.getDatabase("test");
//        MongoCollection<Document> numbersCollection = testDB.getCollection("numbers");
//
//        Document doc = new Document("name", "pi").append("value", 3.14159);

	}
}
