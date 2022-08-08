/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymfit;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DbConnection {
    private static String serverName = "localhost";
    private static String username = "root";
    private static String dbName = "gymfit";
    private static Integer port = 3306;
    private static String password = "";
    
    public static Connection getConnection() {
        Connection conn = null;
        
        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName(serverName);
        ds.setUser(username);
        ds.setPassword(password);
        ds.setDatabaseName(dbName);
        ds.setPort(port);
        
        try {
            conn = ds.getConnection();
        }
        catch(SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }
}
