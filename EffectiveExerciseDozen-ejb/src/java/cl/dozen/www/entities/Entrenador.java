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
 * @author root
 */
@Entity
@Table(name = "entrenador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrenador.findAll", query = "SELECT e FROM Entrenador e"),
    @NamedQuery(name = "Entrenador.findByEntrenadorRut", query = "SELECT e FROM Entrenador e WHERE e.entrenadorRut = :entrenadorRut"),
    @NamedQuery(name = "Entrenador.findByEntrenadorNombre", query = "SELECT e FROM Entrenador e WHERE e.entrenadorNombre = :entrenadorNombre"),
    @NamedQuery(name = "Entrenador.findByEntrenadorApellidoPaterno", query = "SELECT e FROM Entrenador e WHERE e.entrenadorApellidoPaterno = :entrenadorApellidoPaterno"),
    @NamedQuery(name = "Entrenador.findByEntrenadorApellidoMaterno", query = "SELECT e FROM Entrenador e WHERE e.entrenadorApellidoMaterno = :entrenadorApellidoMaterno"),
    @NamedQuery(name = "Entrenador.findByEntrenadorDireccion", query = "SELECT e FROM Entrenador e WHERE e.entrenadorDireccion = :entrenadorDireccion"),
    @NamedQuery(name = "Entrenador.findByEntrenadorTelefono", query = "SELECT e FROM Entrenador e WHERE e.entrenadorTelefono = :entrenadorTelefono"),
    @NamedQuery(name = "Entrenador.findByEntrenadorSexo", query = "SELECT e FROM Entrenador e WHERE e.entrenadorSexo = :entrenadorSexo"),
    @NamedQuery(name = "Entrenador.findByEntrenadorMail", query = "SELECT e FROM Entrenador e WHERE e.entrenadorMail = :entrenadorMail")})
public class Entrenador implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entrenadorentrenadorRut")
    private Collection<RutinaEspecializada> rutinaEspecializadaCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "entrenadorRut")
    private Integer entrenadorRut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "entrenadorNombre")
    private String entrenadorNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "entrenadorApellidoPaterno")
    private String entrenadorApellidoPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "entrenadorApellidoMaterno")
    private String entrenadorApellidoMaterno;
    @Size(max = 90)
    @Column(name = "entrenadorDireccion")
    private String entrenadorDireccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entrenadorTelefono")
    private int entrenadorTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "entrenadorSexo")
    private String entrenadorSexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "entrenadorMail")
    private String entrenadorMail;

    public Entrenador() {
    }

    public Entrenador(Integer entrenadorRut) {
        this.entrenadorRut = entrenadorRut;
    }

    public Entrenador(Integer entrenadorRut, String entrenadorNombre, String entrenadorApellidoPaterno, String entrenadorApellidoMaterno, int entrenadorTelefono, String entrenadorSexo, String entrenadorMail) {
        this.entrenadorRut = entrenadorRut;
        this.entrenadorNombre = entrenadorNombre;
        this.entrenadorApellidoPaterno = entrenadorApellidoPaterno;
        this.entrenadorApellidoMaterno = entrenadorApellidoMaterno;
        this.entrenadorTelefono = entrenadorTelefono;
        this.entrenadorSexo = entrenadorSexo;
        this.entrenadorMail = entrenadorMail;
    }

    public Integer getEntrenadorRut() {
        return entrenadorRut;
    }

    public void setEntrenadorRut(Integer entrenadorRut) {
        this.entrenadorRut = entrenadorRut;
    }

    public String getEntrenadorNombre() {
        return entrenadorNombre;
    }

    public void setEntrenadorNombre(String entrenadorNombre) {
        this.entrenadorNombre = entrenadorNombre;
    }

    public String getEntrenadorApellidoPaterno() {
        return entrenadorApellidoPaterno;
    }

    public void setEntrenadorApellidoPaterno(String entrenadorApellidoPaterno) {
        this.entrenadorApellidoPaterno = entrenadorApellidoPaterno;
    }

    public String getEntrenadorApellidoMaterno() {
        return entrenadorApellidoMaterno;
    }

    public void setEntrenadorApellidoMaterno(String entrenadorApellidoMaterno) {
        this.entrenadorApellidoMaterno = entrenadorApellidoMaterno;
    }

    public String getEntrenadorDireccion() {
        return entrenadorDireccion;
    }

    public void setEntrenadorDireccion(String entrenadorDireccion) {
        this.entrenadorDireccion = entrenadorDireccion;
    }

    public int getEntrenadorTelefono() {
        return entrenadorTelefono;
    }

    public void setEntrenadorTelefono(int entrenadorTelefono) {
        this.entrenadorTelefono = entrenadorTelefono;
    }

    public String getEntrenadorSexo() {
        return entrenadorSexo;
    }

    public void setEntrenadorSexo(String entrenadorSexo) {
        this.entrenadorSexo = entrenadorSexo;
    }

    public String getEntrenadorMail() {
        return entrenadorMail;
    }

    public void setEntrenadorMail(String entrenadorMail) {
        this.entrenadorMail = entrenadorMail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entrenadorRut != null ? entrenadorRut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrenador)) {
            return false;
        }
        Entrenador other = (Entrenador) object;
        if ((this.entrenadorRut == null && other.entrenadorRut != null) || (this.entrenadorRut != null && !this.entrenadorRut.equals(other.entrenadorRut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dozen.www.entities.Entrenador[ entrenadorRut=" + entrenadorRut + " ]";
    }

    @XmlTransient
    public Collection<RutinaEspecializada> getRutinaEspecializadaCollection() {
        return rutinaEspecializadaCollection;
    }

    public void setRutinaEspecializadaCollection(Collection<RutinaEspecializada> rutinaEspecializadaCollection) {
        this.rutinaEspecializadaCollection = rutinaEspecializadaCollection;
    }
    
}
