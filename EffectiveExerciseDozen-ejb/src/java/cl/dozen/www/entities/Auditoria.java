/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author sergio
 */
@Entity
@Table(name = "auditoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a"),
    @NamedQuery(name = "Auditoria.findByAuditoriaId", query = "SELECT a FROM Auditoria a WHERE a.auditoriaId = :auditoriaId"),
    @NamedQuery(name = "Auditoria.findByAuditoriaTimeStamp", query = "SELECT a FROM Auditoria a WHERE a.auditoriaTimeStamp = :auditoriaTimeStamp"),
    @NamedQuery(name = "Auditoria.findByAuditoriaAccion", query = "SELECT a FROM Auditoria a WHERE a.auditoriaAccion = :auditoriaAccion")})
public class Auditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "auditoriaId")
    private Integer auditoriaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "auditoriaTimeStamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date auditoriaTimeStamp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "auditoriaAccion")
    private String auditoriaAccion;

    public Auditoria() {
    }

    public Auditoria(Integer auditoriaId) {
        this.auditoriaId = auditoriaId;
    }

    public Auditoria(Integer auditoriaId, Date auditoriaTimeStamp, String auditoriaAccion) {
        this.auditoriaId = auditoriaId;
        this.auditoriaTimeStamp = auditoriaTimeStamp;
        this.auditoriaAccion = auditoriaAccion;
    }

    public Integer getAuditoriaId() {
        return auditoriaId;
    }

    public void setAuditoriaId(Integer auditoriaId) {
        this.auditoriaId = auditoriaId;
    }

    public Date getAuditoriaTimeStamp() {
        return auditoriaTimeStamp;
    }

    public void setAuditoriaTimeStamp(Date auditoriaTimeStamp) {
        this.auditoriaTimeStamp = auditoriaTimeStamp;
    }

    public String getAuditoriaAccion() {
        return auditoriaAccion;
    }

    public void setAuditoriaAccion(String auditoriaAccion) {
        this.auditoriaAccion = auditoriaAccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auditoriaId != null ? auditoriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.auditoriaId == null && other.auditoriaId != null) || (this.auditoriaId != null && !this.auditoriaId.equals(other.auditoriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dozen.www.entities.Auditoria[ auditoriaId=" + auditoriaId + " ]";
    }
    
}
