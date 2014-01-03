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
 * @author rob_sandova
 */
@Entity
@Table(name = "historialPago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialPago.findAll", query = "SELECT h FROM HistorialPago h"),
    @NamedQuery(name = "HistorialPago.findByHistorialPagoNumeroBoleta", query = "SELECT h FROM HistorialPago h WHERE h.historialPagoNumeroBoleta = :historialPagoNumeroBoleta"),
    @NamedQuery(name = "HistorialPago.findByHistorialPagoFechaPago", query = "SELECT h FROM HistorialPago h WHERE h.historialPagoFechaPago = :historialPagoFechaPago"),
    @NamedQuery(name = "HistorialPago.findByHistorialPagoMonto", query = "SELECT h FROM HistorialPago h WHERE h.historialPagoMonto = :historialPagoMonto"),
    @NamedQuery(name = "HistorialPago.findByHistorialPagoObservacion", query = "SELECT h FROM HistorialPago h WHERE h.historialPagoObservacion = :historialPagoObservacion")})
public class HistorialPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "historialPagoNumeroBoleta")
    private Integer historialPagoNumeroBoleta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "historialPagoFechaPago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date historialPagoFechaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "historialPagoMonto")
    private int historialPagoMonto;
    @Size(max = 90)
    @Column(name = "historialPagoObservacion")
    private String historialPagoObservacion;
    @JoinColumn(name = "cliente_clienteRut", referencedColumnName = "clienteRut")
    @ManyToOne(optional = false)
    private Cliente clienteclienteRut;

    public HistorialPago() {
    }

    public HistorialPago(Integer historialPagoNumeroBoleta) {
        this.historialPagoNumeroBoleta = historialPagoNumeroBoleta;
    }

    public HistorialPago(Integer historialPagoNumeroBoleta, Date historialPagoFechaPago, int historialPagoMonto) {
        this.historialPagoNumeroBoleta = historialPagoNumeroBoleta;
        this.historialPagoFechaPago = historialPagoFechaPago;
        this.historialPagoMonto = historialPagoMonto;
    }

    public Integer getHistorialPagoNumeroBoleta() {
        return historialPagoNumeroBoleta;
    }

    public void setHistorialPagoNumeroBoleta(Integer historialPagoNumeroBoleta) {
        this.historialPagoNumeroBoleta = historialPagoNumeroBoleta;
    }

    public Date getHistorialPagoFechaPago() {
        return historialPagoFechaPago;
    }

    public void setHistorialPagoFechaPago(Date historialPagoFechaPago) {
        this.historialPagoFechaPago = historialPagoFechaPago;
    }

    public int getHistorialPagoMonto() {
        return historialPagoMonto;
    }

    public void setHistorialPagoMonto(int historialPagoMonto) {
        this.historialPagoMonto = historialPagoMonto;
    }

    public String getHistorialPagoObservacion() {
        return historialPagoObservacion;
    }

    public void setHistorialPagoObservacion(String historialPagoObservacion) {
        this.historialPagoObservacion = historialPagoObservacion;
    }

    public Cliente getClienteclienteRut() {
        return clienteclienteRut;
    }

    public void setClienteclienteRut(Cliente clienteclienteRut) {
        this.clienteclienteRut = clienteclienteRut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historialPagoNumeroBoleta != null ? historialPagoNumeroBoleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialPago)) {
            return false;
        }
        HistorialPago other = (HistorialPago) object;
        if ((this.historialPagoNumeroBoleta == null && other.historialPagoNumeroBoleta != null) || (this.historialPagoNumeroBoleta != null && !this.historialPagoNumeroBoleta.equals(other.historialPagoNumeroBoleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dozen.www.entities.HistorialPago[ historialPagoNumeroBoleta=" + historialPagoNumeroBoleta + " ]";
    }
    
}
