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
public class cow {
    String cowid;
    String dob;
    String dateofpurchase;
    String locaction;
    String sex;

    DBConnect db = new DBConnect();//db instance
    Connection myCon = db.myConnect(); //db connection instance
    HasherSha1 jk = new HasherSha1(); //hashing class instance
    
    public cow() {
    }

    public String getCowid() {
        return cowid;
    }

    public void setCowid(String cowid) {
        this.cowid = cowid;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDateofpurchase() {
        return dateofpurchase;
    }

    public void setDateofpurchase(String dateofpurchase) {
        this.dateofpurchase = dateofpurchase;
    }

    public String getLocaction() {
        return locaction;
    }

    public void setLocaction(String locaction) {
        this.locaction = locaction;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
     public void clear(){
        
          setLocaction(null);
         setSex(null);
    }
     public void saveUser() throws SQLException{
          Statement s = null;
         //creates an instance of the DBConnect class
         
         if(myCon!=null){
         System.out.println(myCon);
         s = myCon.createStatement();
         
                    String sql = "INSERT INTO user "
                            + "(uname,password) "
                            + "VALUES ('" + getCowid() + "','"
                            +  getDob() + "','"   
                            + getDateofpurchase() + "','"   
                            + getLocaction() + "','"      
                            + getSex()+ "') ";
                    s.execute(sql);
                    clear();
     }

    }
    
}
