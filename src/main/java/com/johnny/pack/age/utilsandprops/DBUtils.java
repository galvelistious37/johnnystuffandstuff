package com.johnny.pack.age.utilsandprops;

import java.sql.Connection;
import java.sql.SQLException;

import com.johnny.pack.age.utilsandprops.DBGetProperties;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DBUtils {

    public Connection getMysqlConnection(){

        Connection con = null;

        try{
            DBGetProperties getProps= new DBGetProperties();
            MysqlDataSource mysqlDS = new MysqlDataSource();

            mysqlDS.setURL(getProps.getPropertyString("db.url"));
            mysqlDS.setUser(getProps.getPropertyString("db.user"));
            mysqlDS.setPassword(getProps.getPropertyString("db.password"));
            con = mysqlDS.getConnection();
        } catch (SQLException se){
            se.printStackTrace();
        }
        return con;
    }
}
