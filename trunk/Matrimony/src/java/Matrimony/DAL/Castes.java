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
@Table(name = "Castes", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Castes.findAll", query = "SELECT c FROM Castes c"),
    @NamedQuery(name = "Castes.findByCasteID", query = "SELECT c FROM Castes c WHERE c.casteID = :casteID"),
    @NamedQuery(name = "Castes.findByStatus", query = "SELECT c FROM Castes c WHERE c.status = :status")})
public class Castes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CasteID", nullable = false)
    private Integer casteID;
    @Lob
    @Size(max = 1073741823)
    @Column(name = "CasteName", length = 1073741823)
    private String casteName;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(mappedBy = "casteID")
    private List<AccountDetail> accountDetailList;

    public Castes() {
    }

    public Castes(Integer casteID) {
        this.casteID = casteID;
    }

    public Integer getCasteID() {
        return casteID;
    }

    public void setCasteID(Integer casteID) {
        this.casteID = casteID;
    }

    public String getCasteName() {
        return casteName;
    }

    public void setCasteName(String casteName) {
        this.casteName = casteName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @XmlTransient
    public List<AccountDetail> getAccountDetailList() {
        return accountDetailList;
    }

    public void setAccountDetailList(List<AccountDetail> accountDetailList) {
        this.accountDetailList = accountDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (casteID != null ? casteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Castes)) {
            return false;
        }
        Castes other = (Castes) object;
        if ((this.casteID == null && other.casteID != null) || (this.casteID != null && !this.casteID.equals(other.casteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.DAL.Castes[ casteID=" + casteID + " ]";
    }
    
}
