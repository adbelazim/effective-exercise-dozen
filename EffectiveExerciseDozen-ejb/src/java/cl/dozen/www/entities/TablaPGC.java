/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tablaPGC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TablaPGC.findAll", query = "SELECT t FROM TablaPGC t"),
    @NamedQuery(name = "TablaPGC.findByTablaPGCId", query = "SELECT t FROM TablaPGC t WHERE t.tablaPGCId = :tablaPGCId"),
    @NamedQuery(name = "TablaPGC.findByTablaPGCTotal", query = "SELECT t FROM TablaPGC t WHERE t.tablaPGCTotal = :tablaPGCTotal"),
    @NamedQuery(name = "TablaPGC.findByTablaPGCSexo", query = "SELECT t FROM TablaPGC t WHERE t.tablaPGCSexo = :tablaPGCSexo"),
    @NamedQuery(name = "TablaPGC.findByTablaPGCSuma", query = "SELECT t FROM TablaPGC t WHERE t.tablaPGCSuma = :tablaPGCSuma"),
    @NamedQuery(name = "TablaPGC.findByTablaPGCGrupoEtareo", query = "SELECT t FROM TablaPGC t WHERE t.tablaPGCGrupoEtareo = :tablaPGCGrupoEtareo")})
public class TablaPGC implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tablaPGCId")
    private Integer tablaPGCId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tablaPGCTotal")
    private float tablaPGCTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tablaPGCSexo")
    private int tablaPGCSexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tablaPGCSuma")
    private int tablaPGCSuma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tablaPGCGrupoEtareo")
    private int tablaPGCGrupoEtareo;

    public TablaPGC() {
    }

    public TablaPGC(Integer tablaPGCId) {
        this.tablaPGCId = tablaPGCId;
    }

    public TablaPGC(Integer tablaPGCId, float tablaPGCTotal, int tablaPGCSexo, int tablaPGCSuma, int tablaPGCGrupoEtareo) {
        this.tablaPGCId = tablaPGCId;
        this.tablaPGCTotal = tablaPGCTotal;
        this.tablaPGCSexo = tablaPGCSexo;
        this.tablaPGCSuma = tablaPGCSuma;
        this.tablaPGCGrupoEtareo = tablaPGCGrupoEtareo;
    }

    public Integer getTablaPGCId() {
        return tablaPGCId;
    }

    public void setTablaPGCId(Integer tablaPGCId) {
        this.tablaPGCId = tablaPGCId;
    }

    public float getTablaPGCTotal() {
        return tablaPGCTotal;
    }

    public void setTablaPGCTotal(float tablaPGCTotal) {
        this.tablaPGCTotal = tablaPGCTotal;
    }

    public int getTablaPGCSexo() {
        return tablaPGCSexo;
    }

    public void setTablaPGCSexo(int tablaPGCSexo) {
        this.tablaPGCSexo = tablaPGCSexo;
    }

    public int getTablaPGCSuma() {
        return tablaPGCSuma;
    }

    public void setTablaPGCSuma(int tablaPGCSuma) {
        this.tablaPGCSuma = tablaPGCSuma;
    }

    public int getTablaPGCGrupoEtareo() {
        return tablaPGCGrupoEtareo;
    }

    public void setTablaPGCGrupoEtareo(int tablaPGCGrupoEtareo) {
        this.tablaPGCGrupoEtareo = tablaPGCGrupoEtareo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tablaPGCId != null ? tablaPGCId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TablaPGC)) {
            return false;
        }
        TablaPGC other = (TablaPGC) object;
        if ((this.tablaPGCId == null && other.tablaPGCId != null) || (this.tablaPGCId != null && !this.tablaPGCId.equals(other.tablaPGCId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dozen.www.entities.TablaPGC[ tablaPGCId=" + tablaPGCId + " ]";
    }
    
}
