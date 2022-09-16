package com.johnny.pack.age.utilsandprops;

import java.io.*;
import java.io.InputStream;
import java.util.Properties;

public class ReadFromPropertiesFile {

    public static void main(String[] args) {

        try(InputStream input = new FileInputStream("src/main/resources/config.properties")){
            Properties prop = new Properties();

            prop.load(input);

            System.out.println(prop.getProperty("db.url"));
            System.out.println(prop.getProperty("db.user"));
            System.out.println(prop.getProperty("db.password"));
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

    }

}
