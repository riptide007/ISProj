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
    double  firstmilk;
    double secondmilk;
    double thirdmilk;
    double total;
  DBConnect db = new DBConnect();//db instance
    Connection myCon = db.myConnect(); //db connection instance
    HasherSha1 jk = new HasherSha1(); //hashing class instance
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

    public void setFirstmilk(double firstmilk) {
        this.firstmilk = firstmilk;
    }

    public double getSecondmilk() {
        return secondmilk;
    }

    public void setSecondmilk(double secondmilk) {
        this.secondmilk = secondmilk;
    }

    public double getThirdmilk() {
        return thirdmilk;
    }

    public void setThirdmilk(double thirdmilk) {
        this.thirdmilk = thirdmilk;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
      public void clear(){
         setCowid(null);
         setFirstmilk(0);
         setSecondmilk(0);
         setThirdmilk(0);
          setTotal(0);
         
         
         
        
    }
     public void saveCow() throws SQLException{
          Statement s = null;
         //creates an instance of the DBConnect class
         
         if(myCon!=null){
         System.out.println(myCon);
         s = myCon.createStatement();
         
                    String sql = "INSERT INTO user "
                            + "(cowid,firstmilking,secondmilking,thirdmilking,total) "
                            + "VALUES ('" + getCowid() + "','"
                            + getFirstmilk() + "','"   
                            + getSecondmilk() + "','"   
                            + getThirdmilk() + "','"      
                            +getTotal()+ "') ";
                    s.execute(sql);
                    clear();
     }

    }
}
