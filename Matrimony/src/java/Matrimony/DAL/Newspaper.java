/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.DAL;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TuyenDN
 */
@Entity
@Table(name = "Newspaper", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Newspaper.findAll", query = "SELECT n FROM Newspaper n"),
    @NamedQuery(name = "Newspaper.findByNewspaperID", query = "SELECT n FROM Newspaper n WHERE n.newspaperID = :newspaperID")})
public class Newspaper implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NewspaperID", nullable = false)
    private Integer newspaperID;
    @Lob
    @Size(max = 1073741823)
    @Column(name = "NewspaperName", length = 1073741823)
    private String newspaperName;
    @OneToMany(mappedBy = "newspaperId")
    private List<OrdersDetail> ordersDetailList;

    public Newspaper() {
    }

    public Newspaper(Integer newspaperID) {
        this.newspaperID = newspaperID;
    }

    public Integer getNewspaperID() {
        return newspaperID;
    }

    public void setNewspaperID(Integer newspaperID) {
        this.newspaperID = newspaperID;
    }

    public String getNewspaperName() {
        return newspaperName;
    }

    public void setNewspaperName(String newspaperName) {
        this.newspaperName = newspaperName;
    }

    @XmlTransient
    public List<OrdersDetail> getOrdersDetailList() {
        return ordersDetailList;
    }

    public void setOrdersDetailList(List<OrdersDetail> ordersDetailList) {
        this.ordersDetailList = ordersDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newspaperID != null ? newspaperID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Newspaper)) {
            return false;
        }
        Newspaper other = (Newspaper) object;
        if ((this.newspaperID == null && other.newspaperID != null) || (this.newspaperID != null && !this.newspaperID.equals(other.newspaperID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.DAL.Newspaper[ newspaperID=" + newspaperID + " ]";
    }
    
}
