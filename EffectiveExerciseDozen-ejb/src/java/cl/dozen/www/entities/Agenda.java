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
import javax.xml.bind.annotation.XmlRootElement;

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
    @NamedQuery(name = "Agenda.findByAgrendaDisponible", query = "SELECT a FROM Agenda a WHERE a.agrendaDisponible = :agrendaDisponible"),
    @NamedQuery(name = "Agenda.findByEntrenadorentrenadorRut", query = "SELECT a FROM Agenda a WHERE a.entrenadorentrenadorRut = :entrenadorentrenadorRut")})
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
    @Column(name = "agrendaDisponible")
    private boolean agrendaDisponible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entrenador_entrenadorRut")
    private int entrenadorentrenadorRut;

    public Agenda() {
    }

    public Agenda(Integer agendaId) {
        this.agendaId = agendaId;
    }

    public Agenda(Integer agendaId, Date agendaFecha, Date agendaHora, boolean agrendaDisponible, int entrenadorentrenadorRut) {
        this.agendaId = agendaId;
        this.agendaFecha = agendaFecha;
        this.agendaHora = agendaHora;
        this.agrendaDisponible = agrendaDisponible;
        this.entrenadorentrenadorRut = entrenadorentrenadorRut;
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

    public boolean getAgrendaDisponible() {
        return agrendaDisponible;
    }

    public void setAgrendaDisponible(boolean agrendaDisponible) {
        this.agrendaDisponible = agrendaDisponible;
    }

    public int getEntrenadorentrenadorRut() {
        return entrenadorentrenadorRut;
    }

    public void setEntrenadorentrenadorRut(int entrenadorentrenadorRut) {
        this.entrenadorentrenadorRut = entrenadorentrenadorRut;
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
        return "Agenda{" + "agendaId=" + agendaId + ", agendaFecha=" + agendaFecha + ", agendaHora=" + agendaHora + ", agrendaDisponible=" + agrendaDisponible + ", entrenadorentrenadorRut=" + entrenadorentrenadorRut + '}';
    }

    
}
