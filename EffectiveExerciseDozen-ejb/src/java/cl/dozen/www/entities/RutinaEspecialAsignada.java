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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "rutinaEspecialAsignada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RutinaEspecialAsignada.findAll", query = "SELECT r FROM RutinaEspecialAsignada r"),
    @NamedQuery(name = "RutinaEspecialAsignada.findByRutinaEspecialAsignadaId", query = "SELECT r FROM RutinaEspecialAsignada r WHERE r.rutinaEspecialAsignadaId = :rutinaEspecialAsignadaId"),
    @NamedQuery(name = "RutinaEspecialAsignada.findByRutinaEspecialAsignadaInicio", query = "SELECT r FROM RutinaEspecialAsignada r WHERE r.rutinaEspecialAsignadaInicio = :rutinaEspecialAsignadaInicio"),
    @NamedQuery(name = "RutinaEspecialAsignada.findByRutinaEspecialAsignadaTermino", query = "SELECT r FROM RutinaEspecialAsignada r WHERE r.rutinaEspecialAsignadaTermino = :rutinaEspecialAsignadaTermino"),
    @NamedQuery(name = "RutinaEspecialAsignada.findByRutinaEspecialAsignadaComentario", query = "SELECT r FROM RutinaEspecialAsignada r WHERE r.rutinaEspecialAsignadaComentario = :rutinaEspecialAsignadaComentario")})
public class RutinaEspecialAsignada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rutinaEspecialAsignadaId")
    private Integer rutinaEspecialAsignadaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rutinaEspecialAsignadaInicio")
    @Temporal(TemporalType.DATE)
    private Date rutinaEspecialAsignadaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rutinaEspecialAsignadaTermino")
    @Temporal(TemporalType.DATE)
    private Date rutinaEspecialAsignadaTermino;
    @Size(max = 300)
    @Column(name = "rutinaEspecialAsignadaComentario")
    private String rutinaEspecialAsignadaComentario;
    @JoinColumn(name = "cliente_clienteRut", referencedColumnName = "clienteRut")
    @ManyToOne(optional = false)
    private Cliente clienteclienteRut;
    @JoinColumn(name = "rutinaEjercicioEspecializada_rutinaEjercicioEspecializadaId", referencedColumnName = "rutinaEjercicioEspecializadaId")
    @ManyToOne(optional = false)
    private RutinaEjercicioEspecializada rutinaEjercicioEspecializadarutinaEjercicioEspecializadaId;

    public RutinaEspecialAsignada() {
    }

    public RutinaEspecialAsignada(Integer rutinaEspecialAsignadaId) {
        this.rutinaEspecialAsignadaId = rutinaEspecialAsignadaId;
    }

    public RutinaEspecialAsignada(Integer rutinaEspecialAsignadaId, Date rutinaEspecialAsignadaInicio, Date rutinaEspecialAsignadaTermino) {
        this.rutinaEspecialAsignadaId = rutinaEspecialAsignadaId;
        this.rutinaEspecialAsignadaInicio = rutinaEspecialAsignadaInicio;
        this.rutinaEspecialAsignadaTermino = rutinaEspecialAsignadaTermino;
    }

    public Integer getRutinaEspecialAsignadaId() {
        return rutinaEspecialAsignadaId;
    }

    public void setRutinaEspecialAsignadaId(Integer rutinaEspecialAsignadaId) {
        this.rutinaEspecialAsignadaId = rutinaEspecialAsignadaId;
    }

    public Date getRutinaEspecialAsignadaInicio() {
        return rutinaEspecialAsignadaInicio;
    }

    public void setRutinaEspecialAsignadaInicio(Date rutinaEspecialAsignadaInicio) {
        this.rutinaEspecialAsignadaInicio = rutinaEspecialAsignadaInicio;
    }

    public Date getRutinaEspecialAsignadaTermino() {
        return rutinaEspecialAsignadaTermino;
    }

    public void setRutinaEspecialAsignadaTermino(Date rutinaEspecialAsignadaTermino) {
        this.rutinaEspecialAsignadaTermino = rutinaEspecialAsignadaTermino;
    }

    public String getRutinaEspecialAsignadaComentario() {
        return rutinaEspecialAsignadaComentario;
    }

    public void setRutinaEspecialAsignadaComentario(String rutinaEspecialAsignadaComentario) {
        this.rutinaEspecialAsignadaComentario = rutinaEspecialAsignadaComentario;
    }

    public Cliente getClienteclienteRut() {
        return clienteclienteRut;
    }

    public void setClienteclienteRut(Cliente clienteclienteRut) {
        this.clienteclienteRut = clienteclienteRut;
    }

    public RutinaEjercicioEspecializada getRutinaEjercicioEspecializadarutinaEjercicioEspecializadaId() {
        return rutinaEjercicioEspecializadarutinaEjercicioEspecializadaId;
    }

    public void setRutinaEjercicioEspecializadarutinaEjercicioEspecializadaId(RutinaEjercicioEspecializada rutinaEjercicioEspecializadarutinaEjercicioEspecializadaId) {
        this.rutinaEjercicioEspecializadarutinaEjercicioEspecializadaId = rutinaEjercicioEspecializadarutinaEjercicioEspecializadaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutinaEspecialAsignadaId != null ? rutinaEspecialAsignadaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RutinaEspecialAsignada)) {
            return false;
        }
        RutinaEspecialAsignada other = (RutinaEspecialAsignada) object;
        if ((this.rutinaEspecialAsignadaId == null && other.rutinaEspecialAsignadaId != null) || (this.rutinaEspecialAsignadaId != null && !this.rutinaEspecialAsignadaId.equals(other.rutinaEspecialAsignadaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dozen.www.entities.RutinaEspecialAsignada[ rutinaEspecialAsignadaId=" + rutinaEspecialAsignadaId + " ]";
    }
    
}
