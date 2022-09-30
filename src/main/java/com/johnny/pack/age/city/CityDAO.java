package com.johnny.pack.age.city;

import com.johnny.pack.age.utilsandprops.DBUtils;

import java.io.BufferedReader;
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

    private List<City> readFromFile(String filename) throws IOException{
        List<City> tempCityList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = br.readLine()) != null){
                City tempCity = new City();
                String[] arrCity = line.split(",");
                tempCity.setName(arrCity[0]);
                tempCity.setStateId(Integer.parseInt(arrCity[1]));
                tempCityList.add(tempCity);
            }
        } catch(IOException e){
            throw new IOException("Problem finding input file");
        }
        return tempCityList;
    }

    public int insertCities(String filename) throws IOException, SQLException{
        List<City> listCity = readFromFile(filename);
        int status = 0;
        for(City city : listCity){
            status += insertCityObject(city);
        }
        return status;
    }

    public int insertCityObject(City city) throws SQLException {
        int status = 0;
        String query = "" +
                "INSERT INTO CITY (CITY_NAME, STATE_ID) " +
                "VALUES (?, ?)";
        try(Connection con = dbUtils.getMysqlConnection();
            PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, city.getName());
            ps.setInt(2, city.getStateId());
            status += ps.executeUpdate();
        }
        return status;
    }

    public int insertCityByName(String name, int stateId) throws SQLException{
        int status = 0;
        String query = "" +
                "INSERT INTO CITY (STATE_ID, CITY_NAME) " +
                "VALUES (?,?)";
        try(Connection con = dbUtils.getMysqlConnection()){
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, stateId);
            ps.setString(2, name);
            status += ps.executeUpdate();
        }
        return status;
    }

    public List<City> getAllCities() throws SQLException {
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
        }
        return listCity;
    }
}
