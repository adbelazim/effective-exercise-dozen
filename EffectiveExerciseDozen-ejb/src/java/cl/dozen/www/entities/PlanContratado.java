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
 * @author root
 */
@Entity
@Table(name = "plan_contratado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanContratado.findAll", query = "SELECT p FROM PlanContratado p"),
    @NamedQuery(name = "PlanContratado.findByClienteCodigo", query = "SELECT p FROM PlanContratado p WHERE p.clienteCodigo = :clienteCodigo"),
    @NamedQuery(name = "PlanContratado.findByPlanContratadoFechaPago", query = "SELECT p FROM PlanContratado p WHERE p.planContratadoFechaPago = :planContratadoFechaPago"),
    @NamedQuery(name = "PlanContratado.findByPlanContratadoMonto", query = "SELECT p FROM PlanContratado p WHERE p.planContratadoMonto = :planContratadoMonto"),
    @NamedQuery(name = "PlanContratado.findByPlanContratadoObservacion", query = "SELECT p FROM PlanContratado p WHERE p.planContratadoObservacion = :planContratadoObservacion")})
public class PlanContratado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente_codigo")
    private Integer clienteCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plan_contratado_fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date planContratadoFechaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plan_contratado_monto")
    private double planContratadoMonto;
    @Size(max = 100)
    @Column(name = "plan_contratado_observacion")
    private String planContratadoObservacion;
    @JoinColumn(name = "plan_id", referencedColumnName = "plan_id")
    @ManyToOne(optional = false)
    private Plan planId;
    @JoinColumn(name = "cliente_codigo", referencedColumnName = "cliente_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Cliente cliente;

    public PlanContratado() {
    }

    public PlanContratado(Integer clienteCodigo) {
        this.clienteCodigo = clienteCodigo;
    }

    public PlanContratado(Integer clienteCodigo, Date planContratadoFechaPago, double planContratadoMonto) {
        this.clienteCodigo = clienteCodigo;
        this.planContratadoFechaPago = planContratadoFechaPago;
        this.planContratadoMonto = planContratadoMonto;
    }

    public Integer getClienteCodigo() {
        return clienteCodigo;
    }

    public void setClienteCodigo(Integer clienteCodigo) {
        this.clienteCodigo = clienteCodigo;
    }

    public Date getPlanContratadoFechaPago() {
        return planContratadoFechaPago;
    }

    public void setPlanContratadoFechaPago(Date planContratadoFechaPago) {
        this.planContratadoFechaPago = planContratadoFechaPago;
    }

    public double getPlanContratadoMonto() {
        return planContratadoMonto;
    }

    public void setPlanContratadoMonto(double planContratadoMonto) {
        this.planContratadoMonto = planContratadoMonto;
    }

    public String getPlanContratadoObservacion() {
        return planContratadoObservacion;
    }

    public void setPlanContratadoObservacion(String planContratadoObservacion) {
        this.planContratadoObservacion = planContratadoObservacion;
    }

    public Plan getPlanId() {
        return planId;
    }

    public void setPlanId(Plan planId) {
        this.planId = planId;
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
        hash += (clienteCodigo != null ? clienteCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanContratado)) {
            return false;
        }
        PlanContratado other = (PlanContratado) object;
        if ((this.clienteCodigo == null && other.clienteCodigo != null) || (this.clienteCodigo != null && !this.clienteCodigo.equals(other.clienteCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dozen.www.entities.PlanContratado[ clienteCodigo=" + clienteCodigo + " ]";
    }
    
}
