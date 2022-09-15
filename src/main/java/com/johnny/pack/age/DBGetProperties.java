package com.johnny.pack.age;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBGetProperties {

    public String getPropertyString(String prop){
        String value = "";
        try(InputStream input = new FileInputStream("src/main/resources/config.properties")){
            Properties props = new Properties();
            props.load(input);
            value = props.getProperty(prop);
        } catch(IOException ex){
            ex.printStackTrace();
        }
        return value;
    }
}
