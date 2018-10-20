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
public class calving {
    
    String cowid;
    String calvingdate;
    String insemmethod;
    String sex;
    int birthweight;

    public calving() {
    }
 DBConnect db = new DBConnect();
    Connection myCon = db.myConnect(); 
    HasherSha1 jk = new HasherSha1(); 
    
  

    public String getCowid() {
        return cowid;
    }

    public void setCowid(String cowid) {
        this.cowid = cowid;
    }

    public String getCalvingdate() {
        return calvingdate;
    }

    public void setCalvingdate(String calvingdate) {
        this.calvingdate = calvingdate;
    }

    public String getInsemmethod() {
        return insemmethod;
    }

    public void setInsemmethod(String insemmethod) {
        this.insemmethod = insemmethod;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getBirthweight() {
        return birthweight;
    }

    public void setBirthweight(int birthweight) {
        this.birthweight = birthweight;
    }
    public void clear(){
   
         setCowid(null);
         
          setCalvingdate(null);
         setInsemmethod(null);
         setSex(null);
         setBirthweight(0);
    }
    public void saveCalf() throws SQLException{
          Statement s = null;
         //creates an instance of the DBConnect class
         
         if(myCon!=null){
         System.out.println(myCon);
         s = myCon.createStatement();
         
                    String sql = "INSERT INTO calving "
                            + "(cowid,calvingdate,insemmethod,sex,birthweight) "
                            + "VALUES ('" + getCowid() + "','" 
                            +getCalvingdate() + "','"   
                            + getInsemmethod() + "','"   
                            + getSex() + "','"   
                            + getBirthweight()+ "') ";
                    s.execute(sql);
                    clear();
     }

    }
}
