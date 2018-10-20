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
public class medical {
    String cowid;
    String history;
    String symptoms;
    String diagnosis;
    String treatment;
    String result;
    String date;

     DBConnect db = new DBConnect();
    Connection myCon = db.myConnect(); 
    HasherSha1 jk = new HasherSha1(); 
    public medical() {
    }

    public String getCowid() {
        return cowid;
    }

    public void setCowid(String cowid) {
        this.cowid = cowid;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
      public void clear(){
         setCowid(null);
        setHistory(null);
          setSymptoms(null) ;
         setDiagnosis(null);
         setTreatment(null);
         setResult(null) ;
          setDate(null);
         
         
         
        
    }
     public void saveMedical() throws SQLException{
          Statement s = null;
         //creates an instance of the DBConnect class
         
         if(myCon!=null){
         System.out.println(myCon);
         s = myCon.createStatement();
         
                    String sql = "INSERT INTO user "
                            + "(cowid,histroy,symptoms,diagnosis) "
                            +"(treatment,result,date)"
                            + "VALUES ('" + getCowid() + "','"
                            +getHistory() + "','"   
                            + getSymptoms() + "','"
                            + getDiagnosis() + "','"
                            +getTreatment() + "','"
                            + getResult()  + "','"
                            +getDate() + "') ";
                    s.execute(sql);
                    clear();
     }
}
}