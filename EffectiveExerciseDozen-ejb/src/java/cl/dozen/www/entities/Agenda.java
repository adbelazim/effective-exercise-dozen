/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a"),
    @NamedQuery(name = "Agenda.findByAgendaId", query = "SELECT a FROM Agenda a WHERE a.agendaId = :agendaId"),
    @NamedQuery(name = "Agenda.findByAgendaFecha", query = "SELECT a FROM Agenda a WHERE a.agendaFecha = :agendaFecha"),
    @NamedQuery(name = "Agenda.findByAgendaHora", query = "SELECT a FROM Agenda a WHERE a.agendaHora = :agendaHora"),
    @NamedQuery(name = "Agenda.findByAgendaDisponible", query = "SELECT a FROM Agenda a WHERE a.agendaDisponible = :agendaDisponible")})
public class Agenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "agendaId")
    private Integer agendaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "agendaFecha")
    @Temporal(TemporalType.DATE)
    private Date agendaFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "agendaHora")
    @Temporal(TemporalType.TIME)
    private Date agendaHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "agendaDisponible")
    private boolean agendaDisponible;
    @JoinColumn(name = "entrenador_entrenadorRut", referencedColumnName = "entrenadorRut")
    @ManyToOne(optional = false)
    private Entrenador entrenadorentrenadorRut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agendaagendaId")
    private Collection<Agendamiento> agendamientoCollection;

    public Agenda() {
    }

    public Agenda(Integer agendaId) {
        this.agendaId = agendaId;
    }

    public Agenda(Integer agendaId, Date agendaFecha, Date agendaHora, boolean agendaDisponible) {
        this.agendaId = agendaId;
        this.agendaFecha = agendaFecha;
        this.agendaHora = agendaHora;
        this.agendaDisponible = agendaDisponible;
    }

    public Integer getAgendaId() {
        return agendaId;
    }

    public void setAgendaId(Integer agendaId) {
        this.agendaId = agendaId;
    }

    public Date getAgendaFecha() {
        return agendaFecha;
    }

    public void setAgendaFecha(Date agendaFecha) {
        this.agendaFecha = agendaFecha;
    }

    public Date getAgendaHora() {
        return agendaHora;
    }

    public void setAgendaHora(Date agendaHora) {
        this.agendaHora = agendaHora;
    }

    public boolean getAgendaDisponible() {
        return agendaDisponible;
    }

    public void setAgendaDisponible(boolean agendaDisponible) {
        this.agendaDisponible = agendaDisponible;
    }

    public Entrenador getEntrenadorentrenadorRut() {
        return entrenadorentrenadorRut;
    }

    public void setEntrenadorentrenadorRut(Entrenador entrenadorentrenadorRut) {
        this.entrenadorentrenadorRut = entrenadorentrenadorRut;
    }

    @XmlTransient
    public Collection<Agendamiento> getAgendamientoCollection() {
        return agendamientoCollection;
    }

    public void setAgendamientoCollection(Collection<Agendamiento> agendamientoCollection) {
        this.agendamientoCollection = agendamientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agendaId != null ? agendaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.agendaId == null && other.agendaId != null) || (this.agendaId != null && !this.agendaId.equals(other.agendaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dozen.www.entities.Agenda[ agendaId=" + agendaId + " ]";
    }
    
}
