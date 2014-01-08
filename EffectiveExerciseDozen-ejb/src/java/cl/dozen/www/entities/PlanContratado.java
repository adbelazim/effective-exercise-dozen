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
import javax.persistence.OneToOne;
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
@Table(name = "planContratado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanContratado.findAll", query = "SELECT p FROM PlanContratado p"),
    @NamedQuery(name = "PlanContratado.findByClienteclienteRut", query = "SELECT p FROM PlanContratado p WHERE p.clienteclienteRut = :clienteclienteRut"),
    @NamedQuery(name = "PlanContratado.findByPlanContratadoFechaInicio", query = "SELECT p FROM PlanContratado p WHERE p.planContratadoFechaInicio = :planContratadoFechaInicio"),
    @NamedQuery(name = "PlanContratado.findByPlanContratadoMonto", query = "SELECT p FROM PlanContratado p WHERE p.planContratadoMonto = :planContratadoMonto"),
    @NamedQuery(name = "PlanContratado.findByPlanContratadoObservacion", query = "SELECT p FROM PlanContratado p WHERE p.planContratadoObservacion = :planContratadoObservacion")})
public class PlanContratado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente_clienteRut")
    private Integer clienteclienteRut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "planContratadoFechaInicio")
    @Temporal(TemporalType.DATE)
    private Date planContratadoFechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "planContratadoMonto")
    private int planContratadoMonto;
    @Size(max = 90)
    @Column(name = "planContratadoObservacion")
    private String planContratadoObservacion;
    @JoinColumn(name = "plan_planId", referencedColumnName = "planId")
    @ManyToOne(optional = false)
    private Plan planplanId;
    @JoinColumn(name = "cliente_clienteRut", referencedColumnName = "clienteRut", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Cliente cliente;

    public PlanContratado() {
    }

    public PlanContratado(Integer clienteclienteRut) {
        this.clienteclienteRut = clienteclienteRut;
    }

    public PlanContratado(Integer clienteclienteRut, Date planContratadoFechaInicio, int planContratadoMonto) {
        this.clienteclienteRut = clienteclienteRut;
        this.planContratadoFechaInicio = planContratadoFechaInicio;
        this.planContratadoMonto = planContratadoMonto;
    }

    public Integer getClienteclienteRut() {
        return clienteclienteRut;
    }

    public void setClienteclienteRut(Integer clienteclienteRut) {
        this.clienteclienteRut = clienteclienteRut;
    }

    public Date getPlanContratadoFechaInicio() {
        return planContratadoFechaInicio;
    }

    public void setPlanContratadoFechaInicio(Date planContratadoFechaInicio) {
        this.planContratadoFechaInicio = planContratadoFechaInicio;
    }

    public int getPlanContratadoMonto() {
        return planContratadoMonto;
    }

    public void setPlanContratadoMonto(int planContratadoMonto) {
        this.planContratadoMonto = planContratadoMonto;
    }

    public String getPlanContratadoObservacion() {
        return planContratadoObservacion;
    }

    public void setPlanContratadoObservacion(String planContratadoObservacion) {
        this.planContratadoObservacion = planContratadoObservacion;
    }

    public Plan getPlanplanId() {
        return planplanId;
    }

    public void setPlanplanId(Plan planplanId) {
        this.planplanId = planplanId;
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
        if (!(object instanceof PlanContratado)) {
            return false;
        }
        PlanContratado other = (PlanContratado) object;
        if ((this.clienteclienteRut == null && other.clienteclienteRut != null) || (this.clienteclienteRut != null && !this.clienteclienteRut.equals(other.clienteclienteRut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dozen.www.entities.PlanContratado[ clienteclienteRut=" + clienteclienteRut + " ]";
    }
    
}
