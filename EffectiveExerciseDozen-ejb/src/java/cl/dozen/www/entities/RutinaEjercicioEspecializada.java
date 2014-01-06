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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "rutinaEjercicioEspecializada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RutinaEjercicioEspecializada.findAll", query = "SELECT r FROM RutinaEjercicioEspecializada r"),
    @NamedQuery(name = "RutinaEjercicioEspecializada.findByRutinaEjercicioEspecializadaId", query = "SELECT r FROM RutinaEjercicioEspecializada r WHERE r.rutinaEjercicioEspecializadaId = :rutinaEjercicioEspecializadaId"),
    @NamedQuery(name = "RutinaEjercicioEspecializada.findByRutinaEjercicioEspecializadaRepeticion", query = "SELECT r FROM RutinaEjercicioEspecializada r WHERE r.rutinaEjercicioEspecializadaRepeticion = :rutinaEjercicioEspecializadaRepeticion"),
    @NamedQuery(name = "RutinaEjercicioEspecializada.findByRutinaEjercicioEspecializadaSerie", query = "SELECT r FROM RutinaEjercicioEspecializada r WHERE r.rutinaEjercicioEspecializadaSerie = :rutinaEjercicioEspecializadaSerie"),
    @NamedQuery(name = "RutinaEjercicioEspecializada.findByRutinaEjercicioEspecializadaPeso", query = "SELECT r FROM RutinaEjercicioEspecializada r WHERE r.rutinaEjercicioEspecializadaPeso = :rutinaEjercicioEspecializadaPeso"),
    @NamedQuery(name = "RutinaEjercicioEspecializada.findByRutinaEjercicioEspecializadaObservacion", query = "SELECT r FROM RutinaEjercicioEspecializada r WHERE r.rutinaEjercicioEspecializadaObservacion = :rutinaEjercicioEspecializadaObservacion")})
public class RutinaEjercicioEspecializada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rutinaEjercicioEspecializadaId")
    private Integer rutinaEjercicioEspecializadaId;
    @Column(name = "rutinaEjercicioEspecializadaRepeticion")
    private Integer rutinaEjercicioEspecializadaRepeticion;
    @Column(name = "rutinaEjercicioEspecializadaSerie")
    private Integer rutinaEjercicioEspecializadaSerie;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rutinaEjercicioEspecializadaPeso")
    private Float rutinaEjercicioEspecializadaPeso;
    @Size(max = 1000)
    @Column(name = "rutinaEjercicioEspecializadaObservacion")
    private String rutinaEjercicioEspecializadaObservacion;
    @JoinColumn(name = "rutinaEspecializada_rutinaEspecializadaId", referencedColumnName = "rutinaEspecializadaId")
    @ManyToOne(optional = false)
    private RutinaEspecializada rutinaEspecializadarutinaEspecializadaId;
    @JoinColumn(name = "ejercicio_ejercicioId", referencedColumnName = "ejercicioId")
    @ManyToOne(optional = false)
    private Ejercicio ejercicioejercicioId;

    public RutinaEjercicioEspecializada() {
    }

    public RutinaEjercicioEspecializada(Integer rutinaEjercicioEspecializadaId) {
        this.rutinaEjercicioEspecializadaId = rutinaEjercicioEspecializadaId;
    }

    public Integer getRutinaEjercicioEspecializadaId() {
        return rutinaEjercicioEspecializadaId;
    }

    public void setRutinaEjercicioEspecializadaId(Integer rutinaEjercicioEspecializadaId) {
        this.rutinaEjercicioEspecializadaId = rutinaEjercicioEspecializadaId;
    }

    public Integer getRutinaEjercicioEspecializadaRepeticion() {
        return rutinaEjercicioEspecializadaRepeticion;
    }

    public void setRutinaEjercicioEspecializadaRepeticion(Integer rutinaEjercicioEspecializadaRepeticion) {
        this.rutinaEjercicioEspecializadaRepeticion = rutinaEjercicioEspecializadaRepeticion;
    }

    public Integer getRutinaEjercicioEspecializadaSerie() {
        return rutinaEjercicioEspecializadaSerie;
    }

    public void setRutinaEjercicioEspecializadaSerie(Integer rutinaEjercicioEspecializadaSerie) {
        this.rutinaEjercicioEspecializadaSerie = rutinaEjercicioEspecializadaSerie;
    }

    public Float getRutinaEjercicioEspecializadaPeso() {
        return rutinaEjercicioEspecializadaPeso;
    }

    public void setRutinaEjercicioEspecializadaPeso(Float rutinaEjercicioEspecializadaPeso) {
        this.rutinaEjercicioEspecializadaPeso = rutinaEjercicioEspecializadaPeso;
    }

    public String getRutinaEjercicioEspecializadaObservacion() {
        return rutinaEjercicioEspecializadaObservacion;
    }

    public void setRutinaEjercicioEspecializadaObservacion(String rutinaEjercicioEspecializadaObservacion) {
        this.rutinaEjercicioEspecializadaObservacion = rutinaEjercicioEspecializadaObservacion;
    }

    public RutinaEspecializada getRutinaEspecializadarutinaEspecializadaId() {
        return rutinaEspecializadarutinaEspecializadaId;
    }

    public void setRutinaEspecializadarutinaEspecializadaId(RutinaEspecializada rutinaEspecializadarutinaEspecializadaId) {
        this.rutinaEspecializadarutinaEspecializadaId = rutinaEspecializadarutinaEspecializadaId;
    }

    public Ejercicio getEjercicioejercicioId() {
        return ejercicioejercicioId;
    }

    public void setEjercicioejercicioId(Ejercicio ejercicioejercicioId) {
        this.ejercicioejercicioId = ejercicioejercicioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutinaEjercicioEspecializadaId != null ? rutinaEjercicioEspecializadaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RutinaEjercicioEspecializada)) {
            return false;
        }
        RutinaEjercicioEspecializada other = (RutinaEjercicioEspecializada) object;
        if ((this.rutinaEjercicioEspecializadaId == null && other.rutinaEjercicioEspecializadaId != null) || (this.rutinaEjercicioEspecializadaId != null && !this.rutinaEjercicioEspecializadaId.equals(other.rutinaEjercicioEspecializadaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dozen.www.entities.RutinaEjercicioEspecializada[ rutinaEjercicioEspecializadaId=" + rutinaEjercicioEspecializadaId + " ]";
    }
    
}
