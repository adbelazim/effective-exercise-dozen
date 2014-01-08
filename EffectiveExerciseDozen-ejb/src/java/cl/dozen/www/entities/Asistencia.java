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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "asistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistencia.findAll", query = "SELECT a FROM Asistencia a"),
    @NamedQuery(name = "Asistencia.findByClienteclienteRut", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.clienteclienteRut = :clienteclienteRut"),
    @NamedQuery(name = "Asistencia.findByAsistenciaFecha", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.asistenciaFecha = :asistenciaFecha"),
    @NamedQuery(name = "Asistencia.findByAsistenciaMaquina", query = "SELECT a FROM Asistencia a WHERE a.asistenciaMaquina = :asistenciaMaquina"),
    @NamedQuery(name = "Asistencia.findByAsistenciaClase", query = "SELECT a FROM Asistencia a WHERE a.asistenciaClase = :asistenciaClase")})
public class Asistencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsistenciaPK asistenciaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asistencia_maquina")
    private boolean asistenciaMaquina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asistencia_clase")
    private boolean asistenciaClase;
    @JoinColumn(name = "cliente_clienteRut", referencedColumnName = "clienteRut", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;

    public Asistencia() {
    }

    public Asistencia(AsistenciaPK asistenciaPK) {
        this.asistenciaPK = asistenciaPK;
    }

    public Asistencia(AsistenciaPK asistenciaPK, boolean asistenciaMaquina, boolean asistenciaClase) {
        this.asistenciaPK = asistenciaPK;
        this.asistenciaMaquina = asistenciaMaquina;
        this.asistenciaClase = asistenciaClase;
    }

    public Asistencia(int clienteclienteRut, Date asistenciaFecha) {
        this.asistenciaPK = new AsistenciaPK(clienteclienteRut, asistenciaFecha);
    }

    public AsistenciaPK getAsistenciaPK() {
        return asistenciaPK;
    }

    public void setAsistenciaPK(AsistenciaPK asistenciaPK) {
        this.asistenciaPK = asistenciaPK;
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
        hash += (asistenciaPK != null ? asistenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistencia)) {
            return false;
        }
        Asistencia other = (Asistencia) object;
        if ((this.asistenciaPK == null && other.asistenciaPK != null) || (this.asistenciaPK != null && !this.asistenciaPK.equals(other.asistenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dozen.www.entities.Asistencia[ asistenciaPK=" + asistenciaPK + " ]";
    }
    
}
