/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.DAL;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TuyenDN
 */
@Entity
@Table(name = "Relationships", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relationships.findAll", query = "SELECT r FROM Relationships r"),
    @NamedQuery(name = "Relationships.findByRelationID", query = "SELECT r FROM Relationships r WHERE r.relationID = :relationID"),
    @NamedQuery(name = "Relationships.findByRelationship", query = "SELECT r FROM Relationships r WHERE r.relationship = :relationship"),
    @NamedQuery(name = "Relationships.findByBeginDate", query = "SELECT r FROM Relationships r WHERE r.beginDate = :beginDate"),
    @NamedQuery(name = "Relationships.findByEndDate", query = "SELECT r FROM Relationships r WHERE r.endDate = :endDate")})
public class Relationships implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RelationID", nullable = false)
    private Integer relationID;
    @Size(max = 50)
    @Column(name = "Relationship", length = 50)
    private String relationship;
    @Column(name = "BeginDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relationID")
    private List<Accounts> accountsList;

    public Relationships() {
    }

    public Relationships(Integer relationID) {
        this.relationID = relationID;
    }

    public Integer getRelationID() {
        return relationID;
    }

    public void setRelationID(Integer relationID) {
        this.relationID = relationID;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        hash += (relationID != null ? relationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relationships)) {
            return false;
        }
        Relationships other = (Relationships) object;
        if ((this.relationID == null && other.relationID != null) || (this.relationID != null && !this.relationID.equals(other.relationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.DAL.Relationships[ relationID=" + relationID + " ]";
    }
    
}
