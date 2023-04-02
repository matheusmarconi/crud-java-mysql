package br.com.loja.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    // Nae of your mysql user = root
    private static final String USERNAME = "root";

    // SQL PASSWORD
    private static final String PASSWORD ="1234";

    // database adress, port and name
    // JDBC type to connect
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/loja";

    // Connecting database

    public static Connection createConnectionToMySql() throws Exception {
        // Loading the Class using JVM
        Class.forName("com.mysql.jdbc.Driver");

        //Creating our connection to MySQL
        Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
        return connection;
    }

    public static void main(String[] args) throws Exception {

        // Testing our connection

        Connection con = createConnectionToMySql();

        // To test if the connection is returning null
        if(con!=null){
            System.out.println("Conexão realizada com sucesso!");
            con.close();
        }
    }
}
