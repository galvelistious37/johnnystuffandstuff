package com.johnny.pack.age.player;

import com.johnny.pack.age.utilsandprops.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {
    DBUtils dbUtils;

    public PlayerDAO(){}

    public int insertPlayer(Player player) throws SQLException {
        int status = 0;
        String query = "" +
                "INSERT INTO " +
                "PLAYER (FIRST_NAME, LAST_NAME, AGE, HEIGHT, WEIGHT, POSITION, SALARY) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try(Connection con = dbUtils.getMysqlConnection();
            PreparedStatement ps = con.prepareStatement(query)){
                ps.setString(1, player.getFirstName());
                ps.setString(2, player.getLastName());
                ps.setInt(3, player.getAge());
                ps.setInt(4, player.getHeight());
                ps.setInt(5, player.getWeight());
                ps.setString(6, player.getPosition());
                ps.setDouble(7, player.getSalary());
                status = ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
        return status;
    }

    public List<Player> getAllPlayers() throws SQLException{
        List<Player> tempList = new ArrayList<>();
        try(Connection con = dbUtils.getMysqlConnection()){
            String query = "" +
                    "SELECT * " +
                    "FROM   PLAYER";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Player p = new Player();
                p.setPlayerId   (rs.getInt("PLAYER_ID"));
                p.setTeamId     (rs.getInt("TEAM_ID"));
                p.setFirstName  (rs.getString("FIRST_NAME"));
                p.setLastName   (rs.getString("LAST_NAME"));
                p.setAge        (rs.getInt("AGE"));
                p.setHeight     (rs.getInt("HEIGHT"));
                p.setWeight     (rs.getInt("WEIGHT"));
                p.setPosition   (rs.getString("POSITION"));
                p.setSalary     (rs.getDouble("SALARY"));

                tempList.add(p);
            }
        } catch(SQLException e){
            throw e;
        }
        return tempList;
    }
}
