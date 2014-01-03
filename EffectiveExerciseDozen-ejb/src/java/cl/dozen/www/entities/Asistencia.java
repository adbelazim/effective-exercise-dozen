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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rob_sandova
 */
@Entity
@Table(name = "asistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistencia.findAll", query = "SELECT a FROM Asistencia a"),
    @NamedQuery(name = "Asistencia.findByClienteclienteRut", query = "SELECT a FROM Asistencia a WHERE a.clienteclienteRut = :clienteclienteRut"),
    @NamedQuery(name = "Asistencia.findByAsistenciaFecha", query = "SELECT a FROM Asistencia a WHERE a.asistenciaFecha = :asistenciaFecha"),
    @NamedQuery(name = "Asistencia.findByAsistenciaMaquina", query = "SELECT a FROM Asistencia a WHERE a.asistenciaMaquina = :asistenciaMaquina"),
    @NamedQuery(name = "Asistencia.findByAsistenciaClase", query = "SELECT a FROM Asistencia a WHERE a.asistenciaClase = :asistenciaClase")})
public class Asistencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente_clienteRut")
    private Integer clienteclienteRut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asistencia_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date asistenciaFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asistencia_maquina")
    private boolean asistenciaMaquina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asistencia_clase")
    private boolean asistenciaClase;
    @JoinColumn(name = "cliente_clienteRut", referencedColumnName = "clienteRut", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Cliente cliente;

    public Asistencia() {
    }

    public Asistencia(Integer clienteclienteRut) {
        this.clienteclienteRut = clienteclienteRut;
    }

    public Asistencia(Integer clienteclienteRut, Date asistenciaFecha, boolean asistenciaMaquina, boolean asistenciaClase) {
        this.clienteclienteRut = clienteclienteRut;
        this.asistenciaFecha = asistenciaFecha;
        this.asistenciaMaquina = asistenciaMaquina;
        this.asistenciaClase = asistenciaClase;
    }

    public Integer getClienteclienteRut() {
        return clienteclienteRut;
    }

    public void setClienteclienteRut(Integer clienteclienteRut) {
        this.clienteclienteRut = clienteclienteRut;
    }

    public Date getAsistenciaFecha() {
        return asistenciaFecha;
    }

    public void setAsistenciaFecha(Date asistenciaFecha) {
        this.asistenciaFecha = asistenciaFecha;
    }

    public boolean getAsistenciaMaquina() {
        return asistenciaMaquina;
    }

    public void setAsistenciaMaquina(boolean asistenciaMaquina) {
        this.asistenciaMaquina = asistenciaMaquina;
    }

    public boolean getAsistenciaClase() {
        return asistenciaClase;
    }

    public void setAsistenciaClase(boolean asistenciaClase) {
        this.asistenciaClase = asistenciaClase;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteclienteRut != null ? clienteclienteRut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistencia)) {
            return false;
        }
        Asistencia other = (Asistencia) object;
        if ((this.clienteclienteRut == null && other.clienteclienteRut != null) || (this.clienteclienteRut != null && !this.clienteclienteRut.equals(other.clienteclienteRut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dozen.www.entities.Asistencia[ clienteclienteRut=" + clienteclienteRut + " ]";
    }
    
}
