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

public class Staff {
   
        String fname;
    String lname;
    String nid;
       String gender;
    String phone;
    String address;
    String email;
    String dob;
  int salary;
    
 DBConnect db = new DBConnect();
    Connection myCon = db.myConnect(); 
    HasherSha1 jk = new HasherSha1(); 
    
     public Staff() {
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }



    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
      public void clear(){
           setNid(null);
        setAddress(null);
       setDob(null);
        setEmail(null);
        setFname(null);
        setGender(null);
        setLname(null);
        setPhone(null);
          setSalary(0);
    }
  public void saveStaff() throws SQLException{
          Statement s = null;
         //creates an instance of the DBConnect class
         
         if(myCon!=null){
         System.out.println(myCon);
         s = myCon.createStatement();
         
                    String sql = "INSERT INTO staff "
                            + "(nid,fname,lname,gender,phone,address,"
                            + "email,dob,salary) "
                            + "VALUES ('" +  getNid()+ "','"
                            +getFname() + "','"  
                            + getLname() + "','"                       
                            + getGender()+ "'" + ",'"
                            + getPhone() + "','"
                            + getAddress()+ "','"
                            + getEmail()+ "','"
                            +getDob()+"," 
                            + getSalary()+ "') ";
                    s.execute(sql);
                    clear();
     }} 
     

    
}
