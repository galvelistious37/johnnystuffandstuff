package com.johnny.pack.age.state;

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

public class StateDAO {
    private DBUtils dbUtils = new DBUtils();

    private List<State> readFromFile() throws IOException{
        List<State> tempStateList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\States.txt"))){
            String line;
            while((line = br.readLine()) != null){
                State tempState = new State();
                String[] stateArray = line.split(",");
                tempState.setStateId(Integer.parseInt(stateArray[0]));
                tempState.setName(stateArray[1]);
                tempStateList.add(tempState);
            }
        } catch (IOException e) {
            throw new IOException("Problem reading from file");
        }
        return tempStateList;
    }

    public int insertStates() throws IOException, SQLException{
        List<State> stateList = readFromFile();
        int status = 0;
        for(State state : stateList){
            insertStateObject(state);
        }
        return status;
    }

    public int insertStateObject(State state) throws SQLException{
        int status = 0;
        String query = "" +
                "INSERT INTO STATE (STATE_ID, STATE_NAME) " +
                "VALUES (?, ?)";
        try(Connection con = dbUtils.getMysqlConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, state.getStateId());
            ps.setString(2, state.getName());
            status += ps.executeUpdate();
        }
        return status;
    }

    public int insertStateOnlyName(String name) throws SQLException{
        int status = 0;
        String query = "" +
                "INSERT INTO STATE(STATE_NAME) " +
                "VALUES(?)";
        try(Connection con = dbUtils.getMysqlConnection()){
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            status += ps.executeUpdate();
        }
        return status;
    }

    public List<State> getAllStates() throws SQLException{
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
        }
        return listState;
    }
}
