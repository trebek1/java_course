package com.example.mypackage;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try{
            //Connection conn = DriverManager.getConnection("jdbc:sqlite:d:\\databases\\testjava.db");

            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/Merlin/code/java_course/db/testjava.db");
            // conn.setAutoCommit(false);
            Statement statement = conn.createStatement();


            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");

            // statement.execute("INSERT INTO contacts (name, phone, email)" + "VALUES('Alex', 44012, 'alex@a.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email)" + "VALUES('JOE', 44012, 'j@a.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email)" + "VALUES('Jane', 44012, 'jane@a.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email)" + "VALUES('BOB', 44012, 'bob@a.com')");
            // statement.execute("UPDATE contacts SET phone=3532522345 WHERE name='Jane'");

            // statement.execute("DELETE from contacts WHERE name='JOE'");
            statement.execute("SELECT * from contacts");
            ResultSet results = statement.getResultSet();
            while(results.next()){
                System.out.println(results.getString("name")+ " " + results.getInt("phone") + " " + results.getString("email"));
            }

            // need a new statement instance for each query if using multiple query
            // can only reuse var if done with results set;

            //if error happens close methods may not fire
            results.close();

            statement.close();
            conn.close();
        } catch (SQLException e){
            System.out.println("Something went wrong " + e.getMessage());
        }
    }
}
