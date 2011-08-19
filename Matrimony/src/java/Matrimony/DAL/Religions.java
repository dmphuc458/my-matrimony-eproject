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
@Table(name = "Religions", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Religions.findAll", query = "SELECT r FROM Religions r"),
    @NamedQuery(name = "Religions.findByReligionID", query = "SELECT r FROM Religions r WHERE r.religionID = :religionID"),
    @NamedQuery(name = "Religions.findByStatus", query = "SELECT r FROM Religions r WHERE r.status = :status")})
public class Religions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReligionID", nullable = false)
    private Integer religionID;
    @Lob
    @Size(max = 1073741823)
    @Column(name = "ReligionName", length = 1073741823)
    private String religionName;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(mappedBy = "religionID")
    private List<AccountDetail> accountDetailList;

    public Religions() {
    }

    public Religions(Integer religionID) {
        this.religionID = religionID;
    }

    public Integer getReligionID() {
        return religionID;
    }

    public void setReligionID(Integer religionID) {
        this.religionID = religionID;
    }

    public String getReligionName() {
        return religionName;
    }

    public void setReligionName(String religionName) {
        this.religionName = religionName;
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
        hash += (religionID != null ? religionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Religions)) {
            return false;
        }
        Religions other = (Religions) object;
        if ((this.religionID == null && other.religionID != null) || (this.religionID != null && !this.religionID.equals(other.religionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.DAL.Religions[ religionID=" + religionID + " ]";
    }
    
}
