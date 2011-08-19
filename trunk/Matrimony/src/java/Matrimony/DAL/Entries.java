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
@Table(name = "Entries", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entries.findAll", query = "SELECT e FROM Entries e"),
    @NamedQuery(name = "Entries.findByEntryID", query = "SELECT e FROM Entries e WHERE e.entryID = :entryID"),
    @NamedQuery(name = "Entries.findByStatus", query = "SELECT e FROM Entries e WHERE e.status = :status")})
public class Entries implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EntryID", nullable = false)
    private Integer entryID;
    @Lob
    @Size(max = 1073741823)
    @Column(name = "EntryTitle", length = 1073741823)
    private String entryTitle;
    @Lob
    @Size(max = 1073741823)
    @Column(name = "Content", length = 1073741823)
    private String content;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entryID")
    private List<Accounts> accountsList;

    public Entries() {
    }

    public Entries(Integer entryID) {
        this.entryID = entryID;
    }

    public Integer getEntryID() {
        return entryID;
    }

    public void setEntryID(Integer entryID) {
        this.entryID = entryID;
    }

    public String getEntryTitle() {
        return entryTitle;
    }

    public void setEntryTitle(String entryTitle) {
        this.entryTitle = entryTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        hash += (entryID != null ? entryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entries)) {
            return false;
        }
        Entries other = (Entries) object;
        if ((this.entryID == null && other.entryID != null) || (this.entryID != null && !this.entryID.equals(other.entryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.DAL.Entries[ entryID=" + entryID + " ]";
    }
    
}
