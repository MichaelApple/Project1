package db;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            ds = (javax.sql.DataSource)ic.lookup("jdbc/SQLite");
            connection = ds.getConnection();
            System.out.println(connection.getMetaData());

            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT  * FROM ");
//            while (rs.next()) {
//                System.out.println(rs.getInt("cost") + "  Something Like That!");
//            }

        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connection;
    }

}
