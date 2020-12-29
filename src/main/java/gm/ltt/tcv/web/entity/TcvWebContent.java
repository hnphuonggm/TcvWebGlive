/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gm.ltt.tcv.web.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "TCV_WEB_CONTENT", catalog = "", schema = "VAS_ENTERPRISE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TcvWebContent.findAll", query = "SELECT t FROM TcvWebContent t"),
    @NamedQuery(name = "TcvWebContent.findById", query = "SELECT t FROM TcvWebContent t WHERE t.id = :id"),
    @NamedQuery(name = "TcvWebContent.findByKey", query = "SELECT t FROM TcvWebContent t WHERE t.key = :key"),
    @NamedQuery(name = "TcvWebContent.findByCreatedAt", query = "SELECT t FROM TcvWebContent t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TcvWebContent.findByUpdatedAt", query = "SELECT t FROM TcvWebContent t WHERE t.updatedAt = :updatedAt")})
public class TcvWebContent implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Double id;
    @Column(name = "KEY")
    private String key;
    @Lob
    @Column(name = "VALUE")
    private String value;
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public TcvWebContent() {
    }

    public TcvWebContent(Double id) {
        this.id = id;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
        if (!(object instanceof TcvWebContent)) {
            return false;
        }
        TcvWebContent other = (TcvWebContent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gm.ltt.tcv.web.entity.TcvWebContent[ id=" + id + " ]";
    }
    
}
