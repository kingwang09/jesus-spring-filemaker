package org.jesus.jesusspring.filemaker;


import com.filemaker.jdbc.Driver;
import lombok.extern.slf4j.Slf4j;
import org.jesus.jesusspring.hello.entity.Hello;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class FileMakerRepository {
    @Value("${file-maker.datasource.driver-class-name}")
    private String driver;
    @Value("${file-maker.datasource.jdbc-url}")
    private String url;
    @Value("${file-maker.datasource.username}")
    private String username;
    @Value("${file-maker.datasource.password}")
    private String password;

    public void test(){
        log.debug("connection test start...");
        // register the JDBC client driver
        try {
            Driver d = (Driver)Class.forName(driver).newInstance();
        } catch(Exception e) {
            log.error("driver error: ", e);
        }
        // establish a connection to FileMaker
        Connection con = null;
        try {
            con = DriverManager.getConnection(url,username, password);

        } catch(Exception e) {
            log.error("connection error: ", e);
        }
// get connection warnings
        SQLWarning warning = null;
        try {
            warning = con.getWarnings();
            if (warning == null) {
                //System.out.println("No warnings");
                log.info("no error: ");
            }
            while (warning != null) {
                //System.out.println("Warning: "+warning);
                log.warn("Warning: {}", warning);
                warning = warning.getNextWarning();
            }
        } catch (Exception e) {
            log.error("exception: ", e);
        }

        log.debug("connection: {}", con);
        if(con != null) {
            log.info("connection success");

            try {
                DatabaseMetaData databaseMetaData = con.getMetaData();
                log.debug("databaseMetaData: {}", databaseMetaData);
                try(ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[]{"TABLE"})) {
                    while (resultSet.next()) {
                        String tableName = resultSet.getString("TABLE_NAME");
                        String remarks = resultSet.getString("REMARKS");
                        log.info("tableName={}, remarks={}", tableName, remarks);
                    }
                }
            } catch (SQLException e) {
                log.error("metadata error: {}", e);
            }
        }
    }

    public List<Hello> selectHelloList(){
        List<Hello> results = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DriverManager.getConnection(url,username, password);
        } catch(Exception e) {
            log.error("connection error: ", e);
        }

        if(con != null){
            try {
                statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("select id, name from Hello");
                while(resultSet.next()){

                    results.add(Hello.builder()
                                    .id(resultSet.getString("id"))
                                    .name(resultSet.getString("name"))
                            .build());
                }
            } catch (SQLException e) {
                log.error("sql error: {}", e.getMessage(), e);
            } finally {
                try {
                    con.close();
//                    if(statement != null){
//                        statement.close();
//                    }
                } catch (SQLException e) {
                    log.warn("connection & statement close error: {}", e.getMessage(), e);
                }
            }

        }
        return results;
    }
}
