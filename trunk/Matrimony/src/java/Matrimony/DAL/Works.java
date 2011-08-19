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
@Table(name = "Works", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Works.findAll", query = "SELECT w FROM Works w"),
    @NamedQuery(name = "Works.findByWorkID", query = "SELECT w FROM Works w WHERE w.workID = :workID"),
    @NamedQuery(name = "Works.findByPhoneNumber", query = "SELECT w FROM Works w WHERE w.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Works.findByStatus", query = "SELECT w FROM Works w WHERE w.status = :status")})
public class Works implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "WorkID", nullable = false)
    private Integer workID;
    @Lob
    @Size(max = 1073741823)
    @Column(name = "WName", length = 1073741823)
    private String wName;
    @Lob
    @Size(max = 1073741823)
    @Column(name = "Address", length = 1073741823)
    private String address;
    @Size(max = 40)
    @Column(name = "PhoneNumber", length = 40)
    private String phoneNumber;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(mappedBy = "workID")
    private List<AccountDetail> accountDetailList;

    public Works() {
    }

    public Works(Integer workID) {
        this.workID = workID;
    }

    public Integer getWorkID() {
        return workID;
    }

    public void setWorkID(Integer workID) {
        this.workID = workID;
    }

    public String getWName() {
        return wName;
    }

    public void setWName(String wName) {
        this.wName = wName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        hash += (workID != null ? workID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Works)) {
            return false;
        }
        Works other = (Works) object;
        if ((this.workID == null && other.workID != null) || (this.workID != null && !this.workID.equals(other.workID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.DAL.Works[ workID=" + workID + " ]";
    }
    
}
