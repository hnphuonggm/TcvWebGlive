/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gm.ltt.tcv.web.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author X58
 */
@Entity
@Table(name = "USER_ACCOUNT", catalog = "", schema = "VAS_ENTERPRISE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAccount.findAll", query = "SELECT u FROM UserAccount u"),
    @NamedQuery(name = "UserAccount.findById", query = "SELECT u FROM UserAccount u WHERE u.id = :id"),
    @NamedQuery(name = "UserAccount.findByPhone", query = "SELECT u FROM UserAccount u WHERE u.phone = :phone"),
    @NamedQuery(name = "UserAccount.findByPassword", query = "SELECT u FROM UserAccount u WHERE u.password = :password"),
    @NamedQuery(name = "UserAccount.findByCreateDate", query = "SELECT u FROM UserAccount u WHERE u.createDate = :createDate"),
    @NamedQuery(name = "UserAccount.findByStatus", query = "SELECT u FROM UserAccount u WHERE u.status = :status")})
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Double id;
    @Basic(optional = false)
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private BigInteger status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userAccount")
    private Collection<UserSubscribeRegiste> userSubscribeRegisteCollection;

    public UserAccount() {
    }

    public UserAccount(Double id) {
        this.id = id;
    }

    public UserAccount(Double id, String phone, Date createDate, BigInteger status) {
        this.id = id;
        this.phone = phone;
        this.createDate = createDate;
        this.status = status;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<UserSubscribeRegiste> getUserSubscribeRegisteCollection() {
        return userSubscribeRegisteCollection;
    }

    public void setUserSubscribeRegisteCollection(Collection<UserSubscribeRegiste> userSubscribeRegisteCollection) {
        this.userSubscribeRegisteCollection = userSubscribeRegisteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAccount)) {
            return false;
        }
        UserAccount other = (UserAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gm.ltt.tcv.web.entity.UserAccount[ id=" + id + " ]";
    }
    
}
