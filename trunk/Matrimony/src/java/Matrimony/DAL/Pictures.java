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
@Table(name = "Pictures", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pictures.findAll", query = "SELECT p FROM Pictures p"),
    @NamedQuery(name = "Pictures.findByPictureID", query = "SELECT p FROM Pictures p WHERE p.pictureID = :pictureID"),
    @NamedQuery(name = "Pictures.findByPictureName", query = "SELECT p FROM Pictures p WHERE p.pictureName = :pictureName")})
public class Pictures implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PictureID", nullable = false)
    private Integer pictureID;
    @Size(max = 250)
    @Column(name = "PictureName", length = 250)
    private String pictureName;
    @Lob
    @Size(max = 1073741823)
    @Column(name = "PictureURL", length = 1073741823)
    private String pictureURL;
    @OneToMany(mappedBy = "pictureID")
    private List<AccountDetail> accountDetailList;

    public Pictures() {
    }

    public Pictures(Integer pictureID) {
        this.pictureID = pictureID;
    }

    public Integer getPictureID() {
        return pictureID;
    }

    public void setPictureID(Integer pictureID) {
        this.pictureID = pictureID;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
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
        hash += (pictureID != null ? pictureID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pictures)) {
            return false;
        }
        Pictures other = (Pictures) object;
        if ((this.pictureID == null && other.pictureID != null) || (this.pictureID != null && !this.pictureID.equals(other.pictureID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.DAL.Pictures[ pictureID=" + pictureID + " ]";
    }
    
}
