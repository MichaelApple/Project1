package main.java.db;


import main.java.enums.AgeGroup;
import main.java.enums.Sex;
import main.java.enums.ToySize;
import main.java.model.Toy;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Miha on 13.03.2017.
 */
public class Database {

    private static Connection connection;
    private static InitialContext ic;
    private static DataSource ds;

    public static Connection getConnection() {

        try {
            ic = new javax.naming.InitialContext();
            ds = (javax.sql.DataSource)ic.lookup("jdbc/Playroom");
            connection = ds.getConnection();

        } catch (SQLException | NamingException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }

        return connection;
    }

    public static List<Toy> fillRoomByDefault()  {
        List<Toy> allToys = new ArrayList<>();
        Database.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT  t.toy, p.cost, s.size, a.age_group, sex.sex FROM PlayRoom p " +
                    "LEFT JOIN Toys t on p.toy = t.id " +
                    "LEFT JOIN Size s on p.size = s.id " +
                    "LEFT JOIN Age_groups a on p.age_group = a.id " +
                    "LEFT JOIN Sex sex on p.sex = sex.id "
            );
            while (rs.next()) {
                allToys.add(new Toy(rs.getString("toy"), rs.getInt("cost"), ToySize.valueOf(rs.getString("size")),  AgeGroup.valueOf(rs.getString("age_group")), Sex.valueOf(rs.getString("sex"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allToys;
    }
}
