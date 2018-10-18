package dairy.farm.record.keeping.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jason
 */
public class DBConnect {
    
    
    public DBConnect(){
            }
    
     public Connection myConnect(){
      Connection connect = null;
    
    try {
                    Class.forName("com.mysql.jdbc.Driver");

                   connect =DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/recorder?zeroDateTimeBehavior=convertToNull","isproject","breaker007");  
  //  System.out.println("connected");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Cannot connect to Recorder DB "+e.getMessage());
        }
            return connect;
                
     }
   /*  public static void main(String args[]){
         DBConnect con = new DBConnect();
         con.myConnect();
     }*/
}