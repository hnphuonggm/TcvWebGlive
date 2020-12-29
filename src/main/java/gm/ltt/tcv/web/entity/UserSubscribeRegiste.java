/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gm.ltt.tcv.web.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author X58
 */
@Entity
@Table(name = "USER_SUBSCRIBE_REGISTE", catalog = "", schema = "VAS_ENTERPRISE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserSubscribeRegiste.findAll", query = "SELECT u FROM UserSubscribeRegiste u"),
    @NamedQuery(name = "UserSubscribeRegiste.findById", query = "SELECT u FROM UserSubscribeRegiste u WHERE u.id = :id"),
    @NamedQuery(name = "UserSubscribeRegiste.findByCreateDate", query = "SELECT u FROM UserSubscribeRegiste u WHERE u.createDate = :createDate"),
    @NamedQuery(name = "UserSubscribeRegiste.findByStatus", query = "SELECT u FROM UserSubscribeRegiste u WHERE u.status = :status")})
public class UserSubscribeRegiste implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Double id;
    @Basic(optional = false)
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private BigInteger status;
    @JoinColumn(name = "SUBSCRIBE_PACKET", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private SubscribePacket subscribePacket;
    @JoinColumn(name = "USER_ACCOUNT", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private UserAccount userAccount;

    public UserSubscribeRegiste() {
    }

    public UserSubscribeRegiste(Double id) {
        this.id = id;
    }

    public UserSubscribeRegiste(Double id, Date createDate, BigInteger status) {
        this.id = id;
        this.createDate = createDate;
        this.status = status;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
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

    public SubscribePacket getSubscribePacket() {
        return subscribePacket;
    }

    public void setSubscribePacket(SubscribePacket subscribePacket) {
        this.subscribePacket = subscribePacket;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
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
        if (!(object instanceof UserSubscribeRegiste)) {
            return false;
        }
        UserSubscribeRegiste other = (UserSubscribeRegiste) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gm.ltt.tcv.web.entity.UserSubscribeRegiste[ id=" + id + " ]";
    }
    
}
