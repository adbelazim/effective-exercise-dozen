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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Grupo.findByIdgrupoNombre", query = "SELECT g FROM Grupo g WHERE g.idgrupoNombre = :idgrupoNombre"),
    @NamedQuery(name = "Grupo.findByUsuarioNombre", query = "SELECT g FROM Grupo g WHERE g.usuarioNombre = :usuarioNombre"),
    @NamedQuery(name = "Grupo.findByGrupoNombre", query = "SELECT g FROM Grupo g WHERE g.grupoNombre = :grupoNombre")})
public class Grupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgrupoNombre")
    private Integer idgrupoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "usuarioNombre")
    private String usuarioNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "grupoNombre")
    private String grupoNombre;

    public Grupo() {
    }

    public Grupo(Integer idgrupoNombre) {
        this.idgrupoNombre = idgrupoNombre;
    }

    public Grupo(Integer idgrupoNombre, String usuarioNombre, String grupoNombre) {
        this.idgrupoNombre = idgrupoNombre;
        this.usuarioNombre = usuarioNombre;
        this.grupoNombre = grupoNombre;
    }

    public Integer getIdgrupoNombre() {
        return idgrupoNombre;
    }

    public void setIdgrupoNombre(Integer idgrupoNombre) {
        this.idgrupoNombre = idgrupoNombre;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getGrupoNombre() {
        return grupoNombre;
    }

    public void setGrupoNombre(String grupoNombre) {
        this.grupoNombre = grupoNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrupoNombre != null ? idgrupoNombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.idgrupoNombre == null && other.idgrupoNombre != null) || (this.idgrupoNombre != null && !this.idgrupoNombre.equals(other.idgrupoNombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dozen.www.entities.Grupo[ idgrupoNombre=" + idgrupoNombre + " ]";
    }
    
}
