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
       String gender;
    String phone;
    String address;
    String email;
    int age;
   String speciality;
  double salary;
    
         DBConnect db = new DBConnect();//db instance
    Connection myCon = db.myConnect(); //db connection instance
    HasherSha1 jk = new HasherSha1(); //hashing class instance
    
     public Staff() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DBConnect getDb() {
        return db;
    }

    public void setDb(DBConnect db) {
        this.db = db;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
      public void clear(){
        setAddress(null);
        setAge(0);
        setEmail(null);
        setFname(null);
        setGender(null);
        setLname(null);
        setPhone(null);
         setSpeciality(null);
          setSalary(0);
    }
  public void saveStaff() throws SQLException{
          Statement s = null;
         //creates an instance of the DBConnect class
         
         if(myCon!=null){
         System.out.println(myCon);
         s = myCon.createStatement();
         
                    String sql = "INSERT INTO staff "
                            + "(fname,lname,gender,phone,address,"
                            + "email,age,salary,speciality) "
                            + "VALUES ('" + getFname() + "','"
                            + getLname() + "','"                       
                            + getGender()+ "'" + ",'"
                            + getPhone() + "','"
                            + getAddress()+ "','"
                            + getEmail()+ "','"
                            + getAge()+"," 
                            + getSalary()+"," 
                            +getSpeciality()+ "') ";
                    s.execute(sql);
                    clear();
     }} 
     

    
}
