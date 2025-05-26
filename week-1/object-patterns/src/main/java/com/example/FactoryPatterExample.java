package com.example;

// Abstract-Class or Interface

interface Connection {
}

class PostgresConnection implements Connection {
}

class CassandraConnection implements Connection {
}

// Factory Class
class ConnectionFactory {

    //Factory-Method
    public static Connection getConnection(String dbType) {
        if (dbType.equals("postgres")) {
            //..
            // driver
            // url
            // username
            // password
            //....
            PostgresConnection connection = new PostgresConnection();
            return connection;
        } else if (dbType.equals("cassandra")) {
            //..
            // driver
            // url
            // username
            // password
            //....
            CassandraConnection connection = new CassandraConnection();
            return connection;
        } else {
            throw new IllegalArgumentException("invalid dabatse type");
        }
    }
}


public class FactoryPatterExample {

    public static void main(String[] args) {


        //-------------------------------------------------------
        // team-1 : module ( UPI )
        //-------------------------------------------------------

        String dbType = "postgres"; // | cassandraa
        Connection connection = ConnectionFactory.getConnection(dbType);

        //-------------------------------------------------------
        // team-2 : module ( NEFT )
        //-------------------------------------------------------

        dbType = "cassandra"; // | postgres
        connection = ConnectionFactory.getConnection(dbType);


    }

}
