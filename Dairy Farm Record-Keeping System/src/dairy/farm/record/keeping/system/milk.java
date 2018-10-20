/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dairy.farm.record.keeping.system;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jason M.
 */
public class milk {
    String cowid;
    int  firstmilk;
   int secondmilk;
    int thirdmilk;
    
  DBConnect db = new DBConnect();
    Connection myCon = db.myConnect(); 
    HasherSha1 jk = new HasherSha1(); 
    public milk() {
    }

    public String getCowid() {
        return cowid;
    }

    public void setCowid(String cowid) {
        this.cowid = cowid;
    }

    public double getFirstmilk() {
        return firstmilk;
    }

    public void setFirstmilk(int firstmilk) {
        this.firstmilk = firstmilk;
    }

    public double getSecondmilk() {
        return secondmilk;
    }

    public void setSecondmilk(int secondmilk) {
        this.secondmilk = secondmilk;
    }

    public double getThirdmilk() {
        return thirdmilk;
    }

    public void setThirdmilk(int thirdmilk) {
        this.thirdmilk = thirdmilk;
    }

  
    
      public void clear(){
         setCowid(null);
         setFirstmilk(0);
         setSecondmilk(0);
         setThirdmilk(0);
         
         
         
         
        
    }
     public void saveMilk() throws SQLException{
          Statement s = null;
         //creates an instance of the DBConnect class
         
         if(myCon!=null){
         System.out.println(myCon);
         s = myCon.createStatement();
         
                    String sql = "INSERT INTO milk "
                            + "(cowid,firstmilking,secondmilking,thirdmilking) "
                            + "VALUES ('" + getCowid() + "','"
                            + getFirstmilk() + "','"   
                            + getSecondmilk() + "','"       
                            +getThirdmilk() + "') ";
                    s.execute(sql);
                    clear();
     }

    }
}
