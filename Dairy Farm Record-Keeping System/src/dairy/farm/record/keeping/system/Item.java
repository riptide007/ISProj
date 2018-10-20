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
      String itemid;
    private String itemname;
    private int quantity;
    private String purchasedate;
    private String unit;
    private String itemtype;
    private int cost;
    
    DBConnect db = new DBConnect();
    Connection myCon = db.myConnect(); 
    HasherSha1 jk = new HasherSha1(); 
    public Item() {
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
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
        this.quantity = (int) quantity;
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

    public void setCost(int cost) {
        this.cost = cost;
    }
      public void clear(){
          setItemid(null);
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
                            + "(itemid,itemname,itemtype,quantity,price,unit,"
                            + "purchasedate) "
                            + "VALUES ('" + getItemid() + "','"
                             + getItemname() + "','" 
                            + getItemtype() + "','"                       
                            +getQuantity()+ "'" + ",'"
                            + getUnit() + "','"
                            + getCost()+ "','"
                            +getPurchasedate()+ "') ";
                    s.execute(sql);
                    clear();
     }}

}
