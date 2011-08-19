/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.DAL;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "Rates", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rates.findAll", query = "SELECT r FROM Rates r"),
    @NamedQuery(name = "Rates.findByRateID", query = "SELECT r FROM Rates r WHERE r.rateID = :rateID"),
    @NamedQuery(name = "Rates.findByRate", query = "SELECT r FROM Rates r WHERE r.rate = :rate"),
    @NamedQuery(name = "Rates.findByMark", query = "SELECT r FROM Rates r WHERE r.mark = :mark")})
public class Rates implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RateID", nullable = false)
    private Integer rateID;
    @Size(max = 20)
    @Column(name = "Rate", length = 20)
    private String rate;
    @Column(name = "Mark")
    private Integer mark;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rateID")
    private List<Accounts> accountsList;

    public Rates() {
    }

    public Rates(Integer rateID) {
        this.rateID = rateID;
    }

    public Integer getRateID() {
        return rateID;
    }

    public void setRateID(Integer rateID) {
        this.rateID = rateID;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @XmlTransient
    public List<Accounts> getAccountsList() {
        return accountsList;
    }

    public void setAccountsList(List<Accounts> accountsList) {
        this.accountsList = accountsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rateID != null ? rateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rates)) {
            return false;
        }
        Rates other = (Rates) object;
        if ((this.rateID == null && other.rateID != null) || (this.rateID != null && !this.rateID.equals(other.rateID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.DAL.Rates[ rateID=" + rateID + " ]";
    }
    
}
