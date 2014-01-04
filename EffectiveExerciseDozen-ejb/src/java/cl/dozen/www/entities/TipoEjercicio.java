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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tipoEjercicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEjercicio.findAll", query = "SELECT t FROM TipoEjercicio t"),
    @NamedQuery(name = "TipoEjercicio.findByTipoEjercicioId", query = "SELECT t FROM TipoEjercicio t WHERE t.tipoEjercicioId = :tipoEjercicioId"),
    @NamedQuery(name = "TipoEjercicio.findByTipoEjercicioNombre", query = "SELECT t FROM TipoEjercicio t WHERE t.tipoEjercicioNombre = :tipoEjercicioNombre"),
    @NamedQuery(name = "TipoEjercicio.findByTipoEjercicioDescripcion", query = "SELECT t FROM TipoEjercicio t WHERE t.tipoEjercicioDescripcion = :tipoEjercicioDescripcion")})
public class TipoEjercicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipoEjercicioId")
    private Integer tipoEjercicioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoEjercicioNombre")
    private String tipoEjercicioNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "tipoEjercicioDescripcion")
    private String tipoEjercicioDescripcion;

    public TipoEjercicio() {
    }

    public TipoEjercicio(Integer tipoEjercicioId) {
        this.tipoEjercicioId = tipoEjercicioId;
    }

    public TipoEjercicio(Integer tipoEjercicioId, String tipoEjercicioNombre, String tipoEjercicioDescripcion) {
        this.tipoEjercicioId = tipoEjercicioId;
        this.tipoEjercicioNombre = tipoEjercicioNombre;
        this.tipoEjercicioDescripcion = tipoEjercicioDescripcion;
    }

    public Integer getTipoEjercicioId() {
        return tipoEjercicioId;
    }

    public void setTipoEjercicioId(Integer tipoEjercicioId) {
        this.tipoEjercicioId = tipoEjercicioId;
    }

    public String getTipoEjercicioNombre() {
        return tipoEjercicioNombre;
    }

    public void setTipoEjercicioNombre(String tipoEjercicioNombre) {
        this.tipoEjercicioNombre = tipoEjercicioNombre;
    }

    public String getTipoEjercicioDescripcion() {
        return tipoEjercicioDescripcion;
    }

    public void setTipoEjercicioDescripcion(String tipoEjercicioDescripcion) {
        this.tipoEjercicioDescripcion = tipoEjercicioDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoEjercicioId != null ? tipoEjercicioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEjercicio)) {
            return false;
        }
        TipoEjercicio other = (TipoEjercicio) object;
        if ((this.tipoEjercicioId == null && other.tipoEjercicioId != null) || (this.tipoEjercicioId != null && !this.tipoEjercicioId.equals(other.tipoEjercicioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dozen.www.entities.TipoEjercicio[ tipoEjercicioId=" + tipoEjercicioId + " ]";
    }
    
}
