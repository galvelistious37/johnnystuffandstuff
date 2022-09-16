package com.johnny.pack.age;

import com.johnny.pack.age.city.City;
import com.johnny.pack.age.city.CityDAO;

import java.util.List;

public class RunStuff {
    public static void main(String[] args) {
//        try(Connection con = DBUtils.getMysqlConnection("teams")){
//            String query = "SELECT * " +
//                    "FROM CITY";
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                System.out.println(rs.getInt("CITY_ID"));
//                System.out.println(rs.getString("CITY_NAME"));
//                System.out.println(rs.getString("STATE"));
//            }
//        } catch (SQLException se){
//            se.printStackTrace();
//        }

//        Player player = new Player("Jimmy", "Beam", "Pitcher", 135000.00);
//        PlayerQueries pq = new PlayerQueries();
//        int rowsUpdated = pq.insertPlayer(player);
//        System.out.format("%d rows updated!", rowsUpdated);
//
//        PlayerDAO pq = new PlayerDAO();
//        List<Player> playerList = null;
//        try {
//            playerList = pq.getAllPlayers();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        for(Player p : playerList){
//            System.out.println(p);
//            System.out.println();
//        }

        CityDAO city = new CityDAO();
        System.out.println("Rows inserted: " + city.insertCities());
        List<City> listCity = city.getAllCities();
        for(City c : listCity){
            System.out.println(c);
        }
    }
}
