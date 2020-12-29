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
@Table(name = "SUBSCRIBE_SERVICE", catalog = "", schema = "VAS_ENTERPRISE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubscribeService.findAll", query = "SELECT s FROM SubscribeService s"),
    @NamedQuery(name = "SubscribeService.findById", query = "SELECT s FROM SubscribeService s WHERE s.id = :id"),
    @NamedQuery(name = "SubscribeService.findByName", query = "SELECT s FROM SubscribeService s WHERE s.name = :name"),
    @NamedQuery(name = "SubscribeService.findByDescription", query = "SELECT s FROM SubscribeService s WHERE s.description = :description"),
    @NamedQuery(name = "SubscribeService.findByCreateDate", query = "SELECT s FROM SubscribeService s WHERE s.createDate = :createDate"),
    @NamedQuery(name = "SubscribeService.findByStatus", query = "SELECT s FROM SubscribeService s WHERE s.status = :status")})
public class SubscribeService implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Double id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private BigInteger status;
    @OneToMany(mappedBy = "subscribeService")
    private Collection<SubscribePacket> subscribePacketCollection;

    public SubscribeService() {
    }

    public SubscribeService(Double id) {
        this.id = id;
    }

    public SubscribeService(Double id, Date createDate, BigInteger status) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public Collection<SubscribePacket> getSubscribePacketCollection() {
        return subscribePacketCollection;
    }

    public void setSubscribePacketCollection(Collection<SubscribePacket> subscribePacketCollection) {
        this.subscribePacketCollection = subscribePacketCollection;
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
        if (!(object instanceof SubscribeService)) {
            return false;
        }
        SubscribeService other = (SubscribeService) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gm.ltt.tcv.web.entity.SubscribeService[ id=" + id + " ]";
    }
    
}
