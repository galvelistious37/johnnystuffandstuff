package com.johnny.pack.age.state;

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

public class StateDAO {
    DBUtils dbUtils = new DBUtils();

    public List<State> readFromFile(){
        List<State> tempStateList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\States.txt"))){
            String line = "";
            while((line = br.readLine()) != null){
                State tempState = new State();
                String[] stateArray = line.split(",");
                tempState.setStateId(Integer.parseInt(stateArray[0]));
                tempState.setName(stateArray[1]);
                tempStateList.add(tempState);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempStateList;
    }

    public int insertStates(){
        List<State> stateList = readFromFile();
        int status = 0;
        for(State state : stateList){
            String query = "" +
                    "INSERT INTO STATE (STATE_ID, STATE_NAME)" +
                    "VALUES (?, ?)";
            try(Connection con = dbUtils.getMysqlConnection();
                PreparedStatement ps = con.prepareStatement(query)){
                ps.setInt(1, state.getStateId());
                ps.setString(2, state.getName());
                status += ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    public List<State> getAllStates(){
        List<State> listState = new ArrayList<>();
        String query = "" +
                "SELECT * " +
                "FROM STATE";
        try(Connection con = dbUtils.getMysqlConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    State State = new State();
                    State.setStateId(rs.getInt("State_ID"));
                    State.setName(rs.getString("State_NAME"));
                    listState.add(State);
                }
            }
        } catch (SQLException e){
            e.getMessage();
        }
        return listState;
    }
}
