package com.h2.h2runner.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class H2Runner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Override
    public void run( ApplicationArguments args ) {
        try {
            Connection connection = dataSource.getConnection();
            System.out.println( connection.getMetaData().getURL() );
            System.out.println( connection.getMetaData().getUserName() );

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE USER(ID INTEGER NOT NULL, NAME VARCHAR(255), PRIMARY KEY(ID))";
            statement.executeUpdate( sql );


        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
}
