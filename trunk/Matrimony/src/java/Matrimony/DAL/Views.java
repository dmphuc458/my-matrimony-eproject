/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.DAL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TuyenDN
 */
@Entity
@Table(name = "Views", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Views.findAll", query = "SELECT v FROM Views v"),
    @NamedQuery(name = "Views.findByViewID", query = "SELECT v FROM Views v WHERE v.viewID = :viewID"),
    @NamedQuery(name = "Views.findByViewedAccountID", query = "SELECT v FROM Views v WHERE v.viewedAccountID = :viewedAccountID"),
    @NamedQuery(name = "Views.findByViewDate", query = "SELECT v FROM Views v WHERE v.viewDate = :viewDate")})
public class Views implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ViewID", nullable = false)
    private Integer viewID;
    @Column(name = "ViewedAccountID")
    private Integer viewedAccountID;
    @Column(name = "ViewDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date viewDate;
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
    @ManyToOne
    private Accounts accountID;

    public Views() {
    }

    public Views(Integer viewID) {
        this.viewID = viewID;
    }

    public Integer getViewID() {
        return viewID;
    }

    public void setViewID(Integer viewID) {
        this.viewID = viewID;
    }

    public Integer getViewedAccountID() {
        return viewedAccountID;
    }

    public void setViewedAccountID(Integer viewedAccountID) {
        this.viewedAccountID = viewedAccountID;
    }

    public Date getViewDate() {
        return viewDate;
    }

    public void setViewDate(Date viewDate) {
        this.viewDate = viewDate;
    }

    public Accounts getAccountID() {
        return accountID;
    }

    public void setAccountID(Accounts accountID) {
        this.accountID = accountID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (viewID != null ? viewID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Views)) {
            return false;
        }
        Views other = (Views) object;
        if ((this.viewID == null && other.viewID != null) || (this.viewID != null && !this.viewID.equals(other.viewID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.DAL.Views[ viewID=" + viewID + " ]";
    }
    
}
