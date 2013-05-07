/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bspor
 */
public class MySqlDB {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    
    public void openConnection (String driverClass, String url, String user, String password) {
        try {
            Class.forName(driverClass); 
            conn= DriverManager.getConnection(url, user, password);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySqlDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
                Logger.getLogger(MySqlDB.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public List<Map<String, Object>> getAllRecords (String table) throws SQLException {
        List<Map<String,Object>> results = new ArrayList<>();
        
        String sql = "SELECT * FROM " + table;
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        
        return results;
        
    }
}
