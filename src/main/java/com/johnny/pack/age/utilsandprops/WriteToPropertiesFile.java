package com.johnny.pack.age.utilsandprops;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class WriteToPropertiesFile {

    public static void main(String[] args) {

        try(OutputStream output = new FileOutputStream("src/main/resources/config.properties")){
            Properties prop = new Properties();

            prop.setProperty("db.url", "localhost");
            prop.setProperty("db.user", "root");
            prop.setProperty("db.password", "SlayFace11!!");

            prop.store(output, null);

            System.out.println(prop);
        } catch (IOException io){
            io.printStackTrace();
        }
    }

}
