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
@Table(name = "V_USER_SUBSCRIBE_ACTIVE", catalog = "", schema = "VAS_ENTERPRISE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VUserSubscribeActive.findAll", query = "SELECT v FROM VUserSubscribeActive v"),
    @NamedQuery(name = "VUserSubscribeActive.findById", query = "SELECT v FROM VUserSubscribeActive v WHERE v.id = :id"),
    @NamedQuery(name = "VUserSubscribeActive.findByUserAccount", query = "SELECT v FROM VUserSubscribeActive v WHERE v.userAccount = :userAccount"),
    @NamedQuery(name = "VUserSubscribeActive.findBySubscribePacket", query = "SELECT v FROM VUserSubscribeActive v WHERE v.subscribePacket = :subscribePacket"),
    @NamedQuery(name = "VUserSubscribeActive.findByCreateDate", query = "SELECT v FROM VUserSubscribeActive v WHERE v.createDate = :createDate"),
    @NamedQuery(name = "VUserSubscribeActive.findByCreateTime", query = "SELECT v FROM VUserSubscribeActive v WHERE v.createTime = :createTime"),
    @NamedQuery(name = "VUserSubscribeActive.findByStatus", query = "SELECT v FROM VUserSubscribeActive v WHERE v.status = :status")})
public class VUserSubscribeActive implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ID")
    @Id
    private double id;
    @Basic(optional = false)
    @Column(name = "USER_ACCOUNT")
    private double userAccount;
    @Basic(optional = false)
    @Column(name = "SUBSCRIBE_PACKET")
    private double subscribePacket;
    @Basic(optional = false)
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "CREATE_TIME")
    private BigInteger createTime;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private BigInteger status;

    public VUserSubscribeActive() {
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(double userAccount) {
        this.userAccount = userAccount;
    }

    public double getSubscribePacket() {
        return subscribePacket;
    }

    public void setSubscribePacket(double subscribePacket) {
        this.subscribePacket = subscribePacket;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigInteger getCreateTime() {
        return createTime;
    }

    public void setCreateTime(BigInteger createTime) {
        this.createTime = createTime;
    }

    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }
    
}
