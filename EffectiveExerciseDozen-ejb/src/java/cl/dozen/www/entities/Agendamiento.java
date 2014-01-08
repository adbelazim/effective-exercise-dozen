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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "agendamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agendamiento.findAll", query = "SELECT a FROM Agendamiento a"),
    @NamedQuery(name = "Agendamiento.findByAgendamientoId", query = "SELECT a FROM Agendamiento a WHERE a.agendamientoId = :agendamientoId"),
    @NamedQuery(name = "Agendamiento.findByAgendamientoFecha", query = "SELECT a FROM Agendamiento a WHERE a.agendamientoFecha = :agendamientoFecha"),
    @NamedQuery(name = "Agendamiento.findByAgendamientoHora", query = "SELECT a FROM Agendamiento a WHERE a.agendamientoHora = :agendamientoHora")})
public class Agendamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "agendamientoId")
    private Integer agendamientoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "agendamientoFecha")
    @Temporal(TemporalType.DATE)
    private Date agendamientoFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "agendamientoHora")
    @Temporal(TemporalType.TIME)
    private Date agendamientoHora;
    @JoinColumn(name = "cliente_clienteRut", referencedColumnName = "clienteRut")
    @ManyToOne(optional = false)
    private Cliente clienteclienteRut;
    @JoinColumn(name = "agenda_agendaId", referencedColumnName = "agendaId")
    @ManyToOne(optional = false)
    private Agenda agendaagendaId;

    public Agendamiento() {
    }

    public Agendamiento(Integer agendamientoId) {
        this.agendamientoId = agendamientoId;
    }

    public Agendamiento(Integer agendamientoId, Date agendamientoFecha, Date agendamientoHora) {
        this.agendamientoId = agendamientoId;
        this.agendamientoFecha = agendamientoFecha;
        this.agendamientoHora = agendamientoHora;
    }

    public Integer getAgendamientoId() {
        return agendamientoId;
    }

    public void setAgendamientoId(Integer agendamientoId) {
        this.agendamientoId = agendamientoId;
    }

    public Date getAgendamientoFecha() {
        return agendamientoFecha;
    }

    public void setAgendamientoFecha(Date agendamientoFecha) {
        this.agendamientoFecha = agendamientoFecha;
    }

    public Date getAgendamientoHora() {
        return agendamientoHora;
    }

    public void setAgendamientoHora(Date agendamientoHora) {
        this.agendamientoHora = agendamientoHora;
    }

    public Cliente getClienteclienteRut() {
        return clienteclienteRut;
    }

    public void setClienteclienteRut(Cliente clienteclienteRut) {
        this.clienteclienteRut = clienteclienteRut;
    }

    public Agenda getAgendaagendaId() {
        return agendaagendaId;
    }

    public void setAgendaagendaId(Agenda agendaagendaId) {
        this.agendaagendaId = agendaagendaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agendamientoId != null ? agendamientoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agendamiento)) {
            return false;
        }
        Agendamiento other = (Agendamiento) object;
        if ((this.agendamientoId == null && other.agendamientoId != null) || (this.agendamientoId != null && !this.agendamientoId.equals(other.agendamientoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dozen.www.entities.Agendamiento[ agendamientoId=" + agendamientoId + " ]";
    }
    
}
