/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dairy.farm.record.keeping.system;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Jason M.
 */
@Entity
@Table(name = "item", catalog = "recorder", schema = "")
@NamedQueries({
    @NamedQuery(name = "Item_1.findAll", query = "SELECT i FROM Item_1 i")
    , @NamedQuery(name = "Item_1.findById", query = "SELECT i FROM Item_1 i WHERE i.id = :id")
    , @NamedQuery(name = "Item_1.findByItemid", query = "SELECT i FROM Item_1 i WHERE i.itemid = :itemid")
    , @NamedQuery(name = "Item_1.findByItemName", query = "SELECT i FROM Item_1 i WHERE i.itemName = :itemName")
    , @NamedQuery(name = "Item_1.findByItemtype", query = "SELECT i FROM Item_1 i WHERE i.itemtype = :itemtype")
    , @NamedQuery(name = "Item_1.findByQuantity", query = "SELECT i FROM Item_1 i WHERE i.quantity = :quantity")
    , @NamedQuery(name = "Item_1.findByPrice", query = "SELECT i FROM Item_1 i WHERE i.price = :price")
    , @NamedQuery(name = "Item_1.findByUnit", query = "SELECT i FROM Item_1 i WHERE i.unit = :unit")
    , @NamedQuery(name = "Item_1.findByPurchasedate", query = "SELECT i FROM Item_1 i WHERE i.purchasedate = :purchasedate")
    , @NamedQuery(name = "Item_1.findByIsActive", query = "SELECT i FROM Item_1 i WHERE i.isActive = :isActive")})
public class Item_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "itemid")
    private String itemid;
    @Column(name = "itemName")
    private String itemName;
    @Column(name = "itemtype")
    private String itemtype;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Integer price;
    @Column(name = "unit")
    private String unit;
    @Column(name = "purchasedate")
    private String purchasedate;
    @Column(name = "isActive")
    private Boolean isActive;

    public Item_1() {
    }

    public Item_1(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        String oldItemid = this.itemid;
        this.itemid = itemid;
        changeSupport.firePropertyChange("itemid", oldItemid, itemid);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        String oldItemName = this.itemName;
        this.itemName = itemName;
        changeSupport.firePropertyChange("itemName", oldItemName, itemName);
    }

    public String getItemtype() {
        return itemtype;
    }

    public void setItemtype(String itemtype) {
        String oldItemtype = this.itemtype;
        this.itemtype = itemtype;
        changeSupport.firePropertyChange("itemtype", oldItemtype, itemtype);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        Integer oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        Integer oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        String oldUnit = this.unit;
        this.unit = unit;
        changeSupport.firePropertyChange("unit", oldUnit, unit);
    }

    public String getPurchasedate() {
        return purchasedate;
    }

    public void setPurchasedate(String purchasedate) {
        String oldPurchasedate = this.purchasedate;
        this.purchasedate = purchasedate;
        changeSupport.firePropertyChange("purchasedate", oldPurchasedate, purchasedate);
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        Boolean oldIsActive = this.isActive;
        this.isActive = isActive;
        changeSupport.firePropertyChange("isActive", oldIsActive, isActive);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item_1)) {
            return false;
        }
        Item_1 other = (Item_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dairy.farm.record.keeping.system.Item_1[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
