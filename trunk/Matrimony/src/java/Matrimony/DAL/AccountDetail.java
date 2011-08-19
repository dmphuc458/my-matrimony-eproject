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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TuyenDN
 */
@Entity
@Table(name = "AccountDetail", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountDetail.findAll", query = "SELECT a FROM AccountDetail a"),
    @NamedQuery(name = "AccountDetail.findByAccountDetailID", query = "SELECT a FROM AccountDetail a WHERE a.accountDetailID = :accountDetailID"),
    @NamedQuery(name = "AccountDetail.findByFName", query = "SELECT a FROM AccountDetail a WHERE a.fName = :fName"),
    @NamedQuery(name = "AccountDetail.findByMName", query = "SELECT a FROM AccountDetail a WHERE a.mName = :mName"),
    @NamedQuery(name = "AccountDetail.findByLName", query = "SELECT a FROM AccountDetail a WHERE a.lName = :lName"),
    @NamedQuery(name = "AccountDetail.findByGender", query = "SELECT a FROM AccountDetail a WHERE a.gender = :gender"),
    @NamedQuery(name = "AccountDetail.findByHeight", query = "SELECT a FROM AccountDetail a WHERE a.height = :height"),
    @NamedQuery(name = "AccountDetail.findByWeight", query = "SELECT a FROM AccountDetail a WHERE a.weight = :weight"),
    @NamedQuery(name = "AccountDetail.findByBirthday", query = "SELECT a FROM AccountDetail a WHERE a.birthday = :birthday"),
    @NamedQuery(name = "AccountDetail.findByPhoneNumber", query = "SELECT a FROM AccountDetail a WHERE a.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "AccountDetail.findByEmail", query = "SELECT a FROM AccountDetail a WHERE a.email = :email"),
    @NamedQuery(name = "AccountDetail.findByMaritalStatus", query = "SELECT a FROM AccountDetail a WHERE a.maritalStatus = :maritalStatus"),
    @NamedQuery(name = "AccountDetail.findByMotherTongue", query = "SELECT a FROM AccountDetail a WHERE a.motherTongue = :motherTongue")})
public class AccountDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AccountDetailID", nullable = false)
    private Integer accountDetailID;
    @Size(max = 30)
    @Column(name = "FName", length = 30)
    private String fName;
    @Size(max = 20)
    @Column(name = "MName", length = 20)
    private String mName;
    @Size(max = 20)
    @Column(name = "LName", length = 20)
    private String lName;
    @Size(max = 20)
    @Column(name = "Gender", length = 20)
    private String gender;
    @Column(name = "Height")
    private Integer height;
    @Column(name = "Weight")
    private Integer weight;
    @Column(name = "Birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Size(max = 20)
    @Column(name = "PhoneNumber", length = 20)
    private String phoneNumber;
    @Lob
    @Size(max = 1073741823)
    @Column(name = "Address", length = 1073741823)
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "Email", length = 50)
    private String email;
    @Size(max = 30)
    @Column(name = "MaritalStatus", length = 30)
    private String maritalStatus;
    @Size(max = 50)
    @Column(name = "MotherTongue", length = 50)
    private String motherTongue;
    @Lob
    @Size(max = 1073741823)
    @Column(name = "Description", length = 1073741823)
    private String description;
    @JoinColumn(name = "WorkID", referencedColumnName = "WorkID")
    @ManyToOne
    private Works workID;
    @JoinColumn(name = "ReligionID", referencedColumnName = "ReligionID")
    @ManyToOne
    private Religions religionID;
    @JoinColumn(name = "PictureID", referencedColumnName = "PictureID")
    @ManyToOne
    private Pictures pictureID;
    @JoinColumn(name = "EducationID", referencedColumnName = "EducationID")
    @ManyToOne
    private Educations educationID;
    @JoinColumn(name = "CountryID", referencedColumnName = "CountryID")
    @ManyToOne
    private Countries countryID;
    @JoinColumn(name = "CityID", referencedColumnName = "CityID")
    @ManyToOne
    private Cities cityID;
    @JoinColumn(name = "CasteID", referencedColumnName = "CasteID")
    @ManyToOne
    private Castes casteID;
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
    @ManyToOne
    private Accounts accountID;

    public AccountDetail() {
    }

    public AccountDetail(Integer accountDetailID) {
        this.accountDetailID = accountDetailID;
    }

    public Integer getAccountDetailID() {
        return accountDetailID;
    }

    public void setAccountDetailID(Integer accountDetailID) {
        this.accountDetailID = accountDetailID;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getMName() {
        return mName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMotherTongue() {
        return motherTongue;
    }

    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Works getWorkID() {
        return workID;
    }

    public void setWorkID(Works workID) {
        this.workID = workID;
    }

    public Religions getReligionID() {
        return religionID;
    }

    public void setReligionID(Religions religionID) {
        this.religionID = religionID;
    }

    public Pictures getPictureID() {
        return pictureID;
    }

    public void setPictureID(Pictures pictureID) {
        this.pictureID = pictureID;
    }

    public Educations getEducationID() {
        return educationID;
    }

    public void setEducationID(Educations educationID) {
        this.educationID = educationID;
    }

    public Countries getCountryID() {
        return countryID;
    }

    public void setCountryID(Countries countryID) {
        this.countryID = countryID;
    }

    public Cities getCityID() {
        return cityID;
    }

    public void setCityID(Cities cityID) {
        this.cityID = cityID;
    }

    public Castes getCasteID() {
        return casteID;
    }

    public void setCasteID(Castes casteID) {
        this.casteID = casteID;
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
        hash += (accountDetailID != null ? accountDetailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountDetail)) {
            return false;
        }
        AccountDetail other = (AccountDetail) object;
        if ((this.accountDetailID == null && other.accountDetailID != null) || (this.accountDetailID != null && !this.accountDetailID.equals(other.accountDetailID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.DAL.AccountDetail[ accountDetailID=" + accountDetailID + " ]";
    }
    
}
