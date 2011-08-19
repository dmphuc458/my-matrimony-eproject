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
@Table(name = "Educations", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Educations.findAll", query = "SELECT e FROM Educations e"),
    @NamedQuery(name = "Educations.findByEducationID", query = "SELECT e FROM Educations e WHERE e.educationID = :educationID"),
    @NamedQuery(name = "Educations.findByAcademicTitle", query = "SELECT e FROM Educations e WHERE e.academicTitle = :academicTitle"),
    @NamedQuery(name = "Educations.findByStatus", query = "SELECT e FROM Educations e WHERE e.status = :status")})
public class Educations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EducationID", nullable = false)
    private Integer educationID;
    @Size(max = 250)
    @Column(name = "AcademicTitle", length = 250)
    private String academicTitle;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(mappedBy = "educationID")
    private List<AccountDetail> accountDetailList;

    public Educations() {
    }

    public Educations(Integer educationID) {
        this.educationID = educationID;
    }

    public Integer getEducationID() {
        return educationID;
    }

    public void setEducationID(Integer educationID) {
        this.educationID = educationID;
    }

    public String getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
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
        hash += (educationID != null ? educationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Educations)) {
            return false;
        }
        Educations other = (Educations) object;
        if ((this.educationID == null && other.educationID != null) || (this.educationID != null && !this.educationID.equals(other.educationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.DAL.Educations[ educationID=" + educationID + " ]";
    }
    
}
