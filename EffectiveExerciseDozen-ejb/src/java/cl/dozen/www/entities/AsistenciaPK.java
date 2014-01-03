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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sergio
 */
@Embeddable
public class AsistenciaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente_clienteRut")
    private int clienteclienteRut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asistencia_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date asistenciaFecha;

    public AsistenciaPK() {
    }

    public AsistenciaPK(int clienteclienteRut, Date asistenciaFecha) {
        this.clienteclienteRut = clienteclienteRut;
        this.asistenciaFecha = asistenciaFecha;
    }

    public int getClienteclienteRut() {
        return clienteclienteRut;
    }

    public void setClienteclienteRut(int clienteclienteRut) {
        this.clienteclienteRut = clienteclienteRut;
    }

    public Date getAsistenciaFecha() {
        return asistenciaFecha;
    }

    public void setAsistenciaFecha(Date asistenciaFecha) {
        this.asistenciaFecha = asistenciaFecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) clienteclienteRut;
        hash += (asistenciaFecha != null ? asistenciaFecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaPK)) {
            return false;
        }
        AsistenciaPK other = (AsistenciaPK) object;
        if (this.clienteclienteRut != other.clienteclienteRut) {
            return false;
        }
        if ((this.asistenciaFecha == null && other.asistenciaFecha != null) || (this.asistenciaFecha != null && !this.asistenciaFecha.equals(other.asistenciaFecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dozen.www.entities.AsistenciaPK[ clienteclienteRut=" + clienteclienteRut + ", asistenciaFecha=" + asistenciaFecha + " ]";
    }
    
}
