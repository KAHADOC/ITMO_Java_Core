package JDBC_App;

import java.sql.*;

public class JdbcApp {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:;INIT=RUNSCRIPT FROM 'classpath:boat_tables.sql';")) {
            System.out.println("have a valid connection " + connection.isValid(0));
            System.out.println("Results of the first query:");
            PreparedStatement ps_first = connection.prepareStatement("select boat_name, departure, arrival, sum(weight) as total_catch from catch c \n" +
                    "join trips on trips.id = c.trip_id\n" +
                    "group by boat_name, departure, arrival\n" +
                    "order by boat_name, departure;");
            ResultSet resultSet = ps_first.executeQuery();
            while (resultSet.next()) {
                System.out.println("Boat: "+resultSet.getString("boat_name")+" | dates: "+resultSet.getDate(2)+" - "+resultSet.getDate(3)+" | Total catch: "+resultSet.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
