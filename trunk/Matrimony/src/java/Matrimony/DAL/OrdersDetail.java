/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.DAL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TuyenDN
 */
@Entity
@Table(name = "OrdersDetail", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdersDetail.findAll", query = "SELECT o FROM OrdersDetail o"),
    @NamedQuery(name = "OrdersDetail.findByOrderDetailID", query = "SELECT o FROM OrdersDetail o WHERE o.orderDetailID = :orderDetailID"),
    @NamedQuery(name = "OrdersDetail.findByPrice", query = "SELECT o FROM OrdersDetail o WHERE o.price = :price")})
public class OrdersDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderDetailID", nullable = false)
    private Integer orderDetailID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Price", precision = 53)
    private Double price;
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    @ManyToOne
    private Orders orderID;
    @JoinColumn(name = "NewspaperId", referencedColumnName = "NewspaperID")
    @ManyToOne
    private Newspaper newspaperId;

    public OrdersDetail() {
    }

    public OrdersDetail(Integer orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public Integer getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(Integer orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Orders getOrderID() {
        return orderID;
    }

    public void setOrderID(Orders orderID) {
        this.orderID = orderID;
    }

    public Newspaper getNewspaperId() {
        return newspaperId;
    }

    public void setNewspaperId(Newspaper newspaperId) {
        this.newspaperId = newspaperId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderDetailID != null ? orderDetailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdersDetail)) {
            return false;
        }
        OrdersDetail other = (OrdersDetail) object;
        if ((this.orderDetailID == null && other.orderDetailID != null) || (this.orderDetailID != null && !this.orderDetailID.equals(other.orderDetailID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.DAL.OrdersDetail[ orderDetailID=" + orderDetailID + " ]";
    }
    
}
