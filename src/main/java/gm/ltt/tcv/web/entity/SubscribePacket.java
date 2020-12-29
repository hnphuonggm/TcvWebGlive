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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SUBSCRIBE_PACKET", catalog = "", schema = "VAS_ENTERPRISE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubscribePacket.findAll", query = "SELECT s FROM SubscribePacket s"),
    @NamedQuery(name = "SubscribePacket.findById", query = "SELECT s FROM SubscribePacket s WHERE s.id = :id"),
    @NamedQuery(name = "SubscribePacket.findByName", query = "SELECT s FROM SubscribePacket s WHERE s.name = :name"),
    @NamedQuery(name = "SubscribePacket.findByPrice", query = "SELECT s FROM SubscribePacket s WHERE s.price = :price"),
    @NamedQuery(name = "SubscribePacket.findByUnit", query = "SELECT s FROM SubscribePacket s WHERE s.unit = :unit"),
    @NamedQuery(name = "SubscribePacket.findByCreateDate", query = "SELECT s FROM SubscribePacket s WHERE s.createDate = :createDate"),
    @NamedQuery(name = "SubscribePacket.findByStatus", query = "SELECT s FROM SubscribePacket s WHERE s.status = :status")})
public class SubscribePacket implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Double id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PRICE")
    private BigInteger price;
    @Column(name = "UNIT")
    private BigInteger unit;
    @Basic(optional = false)
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private BigInteger status;
    @JoinColumn(name = "SUBSCRIBE_SERVICE", referencedColumnName = "ID")
    @ManyToOne
    private SubscribeService subscribeService;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subscribePacket")
    private Collection<UserSubscribeRegiste> userSubscribeRegisteCollection;

    public SubscribePacket() {
    }

    public SubscribePacket(Double id) {
        this.id = id;
    }

    public SubscribePacket(Double id, Date createDate, BigInteger status) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public BigInteger getUnit() {
        return unit;
    }

    public void setUnit(BigInteger unit) {
        this.unit = unit;
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

    public SubscribeService getSubscribeService() {
        return subscribeService;
    }

    public void setSubscribeService(SubscribeService subscribeService) {
        this.subscribeService = subscribeService;
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
        if (!(object instanceof SubscribePacket)) {
            return false;
        }
        SubscribePacket other = (SubscribePacket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gm.ltt.tcv.web.entity.SubscribePacket[ id=" + id + " ]";
    }
    
}
