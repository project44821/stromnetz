import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
 
public class Datenbank {
 
    public static void main(String[] args) {
 
       
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
 
       
        try {
 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException cnfex) {
 
            System.out.println("Problem beim Laden oder "
                    + "Registrierung des MS Access JDBC driver");
            cnfex.printStackTrace();
        }
 
      
        try {
 
            String msAccDB = "C:\\Users\\Kuiper\\Desktop\\XML\\XML\\test.accdb";
            String dbURL = "jdbc:ucanaccess://" + msAccDB; 
 
            
            connection = DriverManager.getConnection(dbURL); 
 
           
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM test");
            
            //DZ
            PreparedStatement p = connection.prepareStatement("INSERT INTO test (NodeID, Power, Ref, Latitude, Longitude) VALUES (?, ?, ?, ?, ?)");
            
            //DZ
            ArrayList<Stromnetz> liste = Main.getList();
            for(int i = 0; i < liste.size(); i++)
            {
            	String id = liste.get(i).getID();
            	String ref = liste.get(i).getRef();
            	String power = liste.get(i).getPower();
            	String lat = liste.get(i).getLat();
            	String lon = liste.get(i).getLong();
            	
            	p.setString(1, id);
            	p.setString(2, ref);
            	p.setString(3, power);
            	p.setString(4, lat);
            	p.setString(5, lon);
            	p.executeUpdate();
            }
            
            
           while(resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "\t" + 
                        resultSet.getString(2) + "\t" + 
                        resultSet.getString(3) + "\t" +
                        resultSet.getString(4));
            }
        }
        catch(SQLException sqlex){
            sqlex.printStackTrace();
        }
        finally {
 
            
            try {
                if(null != connection) {
 
                    
                    resultSet.close();
                    statement.close();
 
                    
                    connection.close();
                }
            }
            catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
    }
}