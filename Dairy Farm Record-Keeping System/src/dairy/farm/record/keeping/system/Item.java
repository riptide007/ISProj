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

public class Item {
      
    private String itemname;
    private double quantity;
    private String purchasedate;
    private String unit;
    private String itemtype;
    private double cost;
    
     DBConnect db = new DBConnect();//db instance
    Connection myCon = db.myConnect(); //db connection instance
    HasherSha1 jk = new HasherSha1(); //hashing class instance
    public Item() {
    }

    

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getPurchasedate() {
        return purchasedate;
    }

    public void setPurchasedate(String purchasedate) {
        this.purchasedate = purchasedate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getItemtype() {
        return itemtype;
    }

    public void setItemtype(String itemtype) {
        this.itemtype = itemtype;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
      public void clear(){
         setItemname(null);
          setQuantity(0);
         setPurchasedate(null);
         setUnit(null);
         setItemtype(null);
          setCost(0);
    }
  public void saveItem() throws SQLException{
          Statement s = null;
         //creates an instance of the DBConnect class
         
         if(myCon!=null){
         System.out.println(myCon);
         s = myCon.createStatement();
         
                    String sql = "INSERT INTO item "
                            + "(itemname,itemtype,quantity,unit,cost,"
                            + "purchasedate) "
                            + "VALUES ('" +  getItemname() + "','"
                            + getItemtype() + "','"                       
                            +getQuantity()+ "'" + ",'"
                            + getUnit() + "','"
                            + getCost()+ "','"
                            +getPurchasedate()+ "') ";
                    s.execute(sql);
                    clear();
     }}

}
