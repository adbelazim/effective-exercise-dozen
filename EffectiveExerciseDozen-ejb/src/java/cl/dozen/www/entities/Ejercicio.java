/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rob_sandova
 */
@Entity
@Table(name = "ejercicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ejercicio.findAll", query = "SELECT e FROM Ejercicio e"),
    @NamedQuery(name = "Ejercicio.findByEjercicioId", query = "SELECT e FROM Ejercicio e WHERE e.ejercicioId = :ejercicioId"),
    @NamedQuery(name = "Ejercicio.findByEjercicioNombre", query = "SELECT e FROM Ejercicio e WHERE e.ejercicioNombre = :ejercicioNombre"),
    @NamedQuery(name = "Ejercicio.findByEjercicioDescripcion", query = "SELECT e FROM Ejercicio e WHERE e.ejercicioDescripcion = :ejercicioDescripcion"),
    @NamedQuery(name = "Ejercicio.findByEjercicioLink", query = "SELECT e FROM Ejercicio e WHERE e.ejercicioLink = :ejercicioLink")})
public class Ejercicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ejercicioId")
    private Integer ejercicioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ejercicioNombre")
    private String ejercicioNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "ejercicioDescripcion")
    private String ejercicioDescripcion;
    @Size(max = 200)
    @Column(name = "ejercicioLink")
    private String ejercicioLink;
    @JoinColumn(name = "tipoEjercicio_tipoEjercicioId", referencedColumnName = "tipoEjercicioId")
    @ManyToOne(optional = false)
    private TipoEjercicio tipoEjerciciotipoEjercicioId;

    public Ejercicio() {
    }

    public Ejercicio(Integer ejercicioId) {
        this.ejercicioId = ejercicioId;
    }

    public Ejercicio(Integer ejercicioId, String ejercicioNombre, String ejercicioDescripcion) {
        this.ejercicioId = ejercicioId;
        this.ejercicioNombre = ejercicioNombre;
        this.ejercicioDescripcion = ejercicioDescripcion;
    }

    public Integer getEjercicioId() {
        return ejercicioId;
    }

    public void setEjercicioId(Integer ejercicioId) {
        this.ejercicioId = ejercicioId;
    }

    public String getEjercicioNombre() {
        return ejercicioNombre;
    }

    public void setEjercicioNombre(String ejercicioNombre) {
        this.ejercicioNombre = ejercicioNombre;
    }

    public String getEjercicioDescripcion() {
        return ejercicioDescripcion;
    }

    public void setEjercicioDescripcion(String ejercicioDescripcion) {
        this.ejercicioDescripcion = ejercicioDescripcion;
    }

    public String getEjercicioLink() {
        return ejercicioLink;
    }

    public void setEjercicioLink(String ejercicioLink) {
        this.ejercicioLink = ejercicioLink;
    }

    public TipoEjercicio getTipoEjerciciotipoEjercicioId() {
        return tipoEjerciciotipoEjercicioId;
    }

    public void setTipoEjerciciotipoEjercicioId(TipoEjercicio tipoEjerciciotipoEjercicioId) {
        this.tipoEjerciciotipoEjercicioId = tipoEjerciciotipoEjercicioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ejercicioId != null ? ejercicioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ejercicio)) {
            return false;
        }
        Ejercicio other = (Ejercicio) object;
        if ((this.ejercicioId == null && other.ejercicioId != null) || (this.ejercicioId != null && !this.ejercicioId.equals(other.ejercicioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ejercicio{" + "ejercicioId=" + ejercicioId + ", ejercicioNombre=" + ejercicioNombre + ", ejercicioDescripcion=" + ejercicioDescripcion + ", ejercicioLink=" + ejercicioLink + ", tipoEjerciciotipoEjercicioId=" + tipoEjerciciotipoEjercicioId + '}';
    }

    
    
}
