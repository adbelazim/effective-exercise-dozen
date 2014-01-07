/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author rob_sandova
 */
@Entity
@Table(name = "rutinaEspecializada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RutinaEspecializada.findAll", query = "SELECT r FROM RutinaEspecializada r"),
    @NamedQuery(name = "RutinaEspecializada.findByRutinaEspecializadaId", query = "SELECT r FROM RutinaEspecializada r WHERE r.rutinaEspecializadaId = :rutinaEspecializadaId"),
    @NamedQuery(name = "RutinaEspecializada.findByRutinaEspecializadaNombre", query = "SELECT r FROM RutinaEspecializada r WHERE r.rutinaEspecializadaNombre = :rutinaEspecializadaNombre"),
    @NamedQuery(name = "RutinaEspecializada.findByRutinaEspecializadaDescripcion", query = "SELECT r FROM RutinaEspecializada r WHERE r.rutinaEspecializadaDescripcion = :rutinaEspecializadaDescripcion"),
    @NamedQuery(name = "RutinaEspecializada.findByRutinaEspecializadaObjetivo", query = "SELECT r FROM RutinaEspecializada r WHERE r.rutinaEspecializadaObjetivo = :rutinaEspecializadaObjetivo")})
public class RutinaEspecializada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rutinaEspecializadaId")
    private Integer rutinaEspecializadaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "rutinaEspecializadaNombre")
    private String rutinaEspecializadaNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "rutinaEspecializadaDescripcion")
    private String rutinaEspecializadaDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rutinaEspecializadaObjetivo")
    private String rutinaEspecializadaObjetivo;
    @JoinColumn(name = "entrenador_entrenadorRut", referencedColumnName = "entrenadorRut")
    @ManyToOne(optional = false)
    private Entrenador entrenadorentrenadorRut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutinaEspecializadarutinaEspecializadaId")
    private Collection<RutinaEjercicioEspecializada> rutinaEjercicioEspecializadaCollection;

    public RutinaEspecializada() {
    }

    public RutinaEspecializada(Integer rutinaEspecializadaId) {
        this.rutinaEspecializadaId = rutinaEspecializadaId;
    }

    public RutinaEspecializada(Integer rutinaEspecializadaId, String rutinaEspecializadaNombre, String rutinaEspecializadaDescripcion, String rutinaEspecializadaObjetivo) {
        this.rutinaEspecializadaId = rutinaEspecializadaId;
        this.rutinaEspecializadaNombre = rutinaEspecializadaNombre;
        this.rutinaEspecializadaDescripcion = rutinaEspecializadaDescripcion;
        this.rutinaEspecializadaObjetivo = rutinaEspecializadaObjetivo;
    }

    public Integer getRutinaEspecializadaId() {
        return rutinaEspecializadaId;
    }

    public void setRutinaEspecializadaId(Integer rutinaEspecializadaId) {
        this.rutinaEspecializadaId = rutinaEspecializadaId;
    }

    public String getRutinaEspecializadaNombre() {
        return rutinaEspecializadaNombre;
    }

    public void setRutinaEspecializadaNombre(String rutinaEspecializadaNombre) {
        this.rutinaEspecializadaNombre = rutinaEspecializadaNombre;
    }

    public String getRutinaEspecializadaDescripcion() {
        return rutinaEspecializadaDescripcion;
    }

    public void setRutinaEspecializadaDescripcion(String rutinaEspecializadaDescripcion) {
        this.rutinaEspecializadaDescripcion = rutinaEspecializadaDescripcion;
    }

    public String getRutinaEspecializadaObjetivo() {
        return rutinaEspecializadaObjetivo;
    }

    public void setRutinaEspecializadaObjetivo(String rutinaEspecializadaObjetivo) {
        this.rutinaEspecializadaObjetivo = rutinaEspecializadaObjetivo;
    }

    public Entrenador getEntrenadorentrenadorRut() {
        return entrenadorentrenadorRut;
    }

    public void setEntrenadorentrenadorRut(Entrenador entrenadorentrenadorRut) {
        this.entrenadorentrenadorRut = entrenadorentrenadorRut;
    }

    @XmlTransient
    public Collection<RutinaEjercicioEspecializada> getRutinaEjercicioEspecializadaCollection() {
        return rutinaEjercicioEspecializadaCollection;
    }

    public void setRutinaEjercicioEspecializadaCollection(Collection<RutinaEjercicioEspecializada> rutinaEjercicioEspecializadaCollection) {
        this.rutinaEjercicioEspecializadaCollection = rutinaEjercicioEspecializadaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutinaEspecializadaId != null ? rutinaEspecializadaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RutinaEspecializada)) {
            return false;
        }
        RutinaEspecializada other = (RutinaEspecializada) object;
        if ((this.rutinaEspecializadaId == null && other.rutinaEspecializadaId != null) || (this.rutinaEspecializadaId != null && !this.rutinaEspecializadaId.equals(other.rutinaEspecializadaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dozen.www.entities.RutinaEspecializada[ rutinaEspecializadaId=" + rutinaEspecializadaId + " ]";
    }
    
}
