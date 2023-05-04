
package dbprogramming1;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class LAB8 {

    public static void main(String[] args) {

        String URL = "jdbc:mysql://localhost:3306/mydb1";
        String username = "root";
        String password = "Xntwpz092...";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection = DriverManager.getConnection(URL, username, password);
            System.out.println("Database Connected");
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM student";
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                System.out.println(result.getString(1) + " " + result.getString(2) + " " + 
                        result.getString(3) + " " + result.getString(4) + " " + result.getString(5));

            }
            
            

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LAB8.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LAB8.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
