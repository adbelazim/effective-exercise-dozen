/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rob_sandova
 */
@Entity
@Table(name = "plan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plan.findAll", query = "SELECT p FROM Plan p"),
    @NamedQuery(name = "Plan.findByPlanId", query = "SELECT p FROM Plan p WHERE p.planId = :planId"),
    @NamedQuery(name = "Plan.findByPlanNombre", query = "SELECT p FROM Plan p WHERE p.planNombre = :planNombre"),
    @NamedQuery(name = "Plan.findByPlanPrecio", query = "SELECT p FROM Plan p WHERE p.planPrecio = :planPrecio"),
    @NamedQuery(name = "Plan.findByPlanDescripcion", query = "SELECT p FROM Plan p WHERE p.planDescripcion = :planDescripcion")})
public class Plan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "planId")
    private Integer planId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "planNombre")
    private String planNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "planPrecio")
    private int planPrecio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "planDescripcion")
    private String planDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planplanId")
    private Collection<PlanContratado> planContratadoCollection;

    public Plan() {
    }

    public Plan(Integer planId) {
        this.planId = planId;
    }

    public Plan(Integer planId, String planNombre, int planPrecio, String planDescripcion) {
        this.planId = planId;
        this.planNombre = planNombre;
        this.planPrecio = planPrecio;
        this.planDescripcion = planDescripcion;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getPlanNombre() {
        return planNombre;
    }

    public void setPlanNombre(String planNombre) {
        this.planNombre = planNombre;
    }

    public int getPlanPrecio() {
        return planPrecio;
    }

    public void setPlanPrecio(int planPrecio) {
        this.planPrecio = planPrecio;
    }

    public String getPlanDescripcion() {
        return planDescripcion;
    }

    public void setPlanDescripcion(String planDescripcion) {
        this.planDescripcion = planDescripcion;
    }

    @XmlTransient
    public Collection<PlanContratado> getPlanContratadoCollection() {
        return planContratadoCollection;
    }

    public void setPlanContratadoCollection(Collection<PlanContratado> planContratadoCollection) {
        this.planContratadoCollection = planContratadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planId != null ? planId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plan)) {
            return false;
        }
        Plan other = (Plan) object;
        if ((this.planId == null && other.planId != null) || (this.planId != null && !this.planId.equals(other.planId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dozen.www.entities.Plan[ planId=" + planId + " ]";
    }
    
}
