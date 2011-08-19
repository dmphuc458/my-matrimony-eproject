/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.DAL;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Accounts", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a"),
    @NamedQuery(name = "Accounts.findByAccountID", query = "SELECT a FROM Accounts a WHERE a.accountID = :accountID"),
    @NamedQuery(name = "Accounts.findByAccountName", query = "SELECT a FROM Accounts a WHERE a.accountName = :accountName"),
    @NamedQuery(name = "Accounts.findByPassword", query = "SELECT a FROM Accounts a WHERE a.password = :password"),
    @NamedQuery(name = "Accounts.findByRole", query = "SELECT a FROM Accounts a WHERE a.role = :role"),
    @NamedQuery(name = "Accounts.findByCreateDate", query = "SELECT a FROM Accounts a WHERE a.createDate = :createDate"),
    @NamedQuery(name = "Accounts.findByExpirationDate", query = "SELECT a FROM Accounts a WHERE a.expirationDate = :expirationDate"),
    @NamedQuery(name = "Accounts.findByStatus", query = "SELECT a FROM Accounts a WHERE a.status = :status")})
public class Accounts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AccountID", nullable = false)
    private Integer accountID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AccountName", nullable = false, length = 50)
    private String accountName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Password", nullable = false, length = 20)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Role", nullable = false, length = 10)
    private String role;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreateDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "ExpirationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    @Column(name = "Status")
    private Boolean status;
    @JoinColumn(name = "RelationID", referencedColumnName = "RelationID", nullable = false)
    @ManyToOne(optional = false)
    private Relationships relationID;
    @JoinColumn(name = "RateID", referencedColumnName = "RateID", nullable = false)
    @ManyToOne(optional = false)
    private Rates rateID;
    @JoinColumn(name = "EntryID", referencedColumnName = "EntryID", nullable = false)
    @ManyToOne(optional = false)
    private Entries entryID;
    @OneToMany(mappedBy = "accountID")
    private List<AccountDetail> accountDetailList;
    @OneToMany(mappedBy = "accountID")
    private List<Orders> ordersList;
    @OneToMany(mappedBy = "accountID")
    private List<Views> viewsList;

    public Accounts() {
    }

    public Accounts(Integer accountID) {
        this.accountID = accountID;
    }

    public Accounts(Integer accountID, String accountName, String password, String role, Date createDate) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.password = password;
        this.role = role;
        this.createDate = createDate;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Relationships getRelationID() {
        return relationID;
    }

    public void setRelationID(Relationships relationID) {
        this.relationID = relationID;
    }

    public Rates getRateID() {
        return rateID;
    }

    public void setRateID(Rates rateID) {
        this.rateID = rateID;
    }

    public Entries getEntryID() {
        return entryID;
    }

    public void setEntryID(Entries entryID) {
        this.entryID = entryID;
    }

    @XmlTransient
    public List<AccountDetail> getAccountDetailList() {
        return accountDetailList;
    }

    public void setAccountDetailList(List<AccountDetail> accountDetailList) {
        this.accountDetailList = accountDetailList;
    }

    @XmlTransient
    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @XmlTransient
    public List<Views> getViewsList() {
        return viewsList;
    }

    public void setViewsList(List<Views> viewsList) {
        this.viewsList = viewsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountID != null ? accountID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.accountID == null && other.accountID != null) || (this.accountID != null && !this.accountID.equals(other.accountID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.DAL.Accounts[ accountID=" + accountID + " ]";
    }
    
}
