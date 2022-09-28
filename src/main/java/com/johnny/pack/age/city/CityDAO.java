package com.johnny.pack.age.city;

import com.johnny.pack.age.utilsandprops.DBUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {
    private DBUtils dbUtils = new DBUtils();

    public List<City> readFromFile(){
        List<City> tempCityList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\Cities.txt"))){
            String line = "";
            while((line = br.readLine()) != null){
                City tempCity = new City();
                String[] arrCity = line.split(",");
                tempCity.setName(arrCity[0]);
                tempCity.setStateId(Integer.parseInt(arrCity[1]));
                tempCityList.add(tempCity);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempCityList;
    }

    public int insertCities(){
        List<City> listCity = readFromFile();
        int status = 0;
        for(City city : listCity){
            String query = "" +
                    "INSERT INTO CITY (CITY_NAME, STATE_ID) " +
                    "VALUES (?, ?)";
            try(Connection con = dbUtils.getMysqlConnection();
                PreparedStatement ps = con.prepareStatement(query)){
                    ps.setString(1, city.getName());
                    ps.setInt(2, city.getStateId());
                    status += ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    public List<City> getAllCities(){
        List<City> listCity = new ArrayList<>();
        String query = "" +
                "SELECT * " +
                "FROM CITY";
        try(Connection con = dbUtils.getMysqlConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    City city = new City();
                    city.setId(rs.getInt("CITY_ID"));
                    city.setStateId(rs.getInt("STATE_ID"));
                    city.setName(rs.getString("CITY_NAME"));
                    listCity.add(city);
                }
            }
        } catch (SQLException e){
            e.getMessage();
        }
        return listCity;
    }
}
