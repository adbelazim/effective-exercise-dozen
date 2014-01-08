/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByClienteRut", query = "SELECT c FROM Cliente c WHERE c.clienteRut = :clienteRut"),
    @NamedQuery(name = "Cliente.findByClienteCodigo", query = "SELECT c FROM Cliente c WHERE c.clienteCodigo = :clienteCodigo"),
    @NamedQuery(name = "Cliente.findByClienteNombre", query = "SELECT c FROM Cliente c WHERE c.clienteNombre = :clienteNombre"),
    @NamedQuery(name = "Cliente.findByClienteApellidoPaterno", query = "SELECT c FROM Cliente c WHERE c.clienteApellidoPaterno like :clienteApellidoPaterno"),
    @NamedQuery(name = "Cliente.findByClienteApellidoMaterno", query = "SELECT c FROM Cliente c WHERE c.clienteApellidoMaterno = :clienteApellidoMaterno"),
    @NamedQuery(name = "Cliente.findByClienteDireccion", query = "SELECT c FROM Cliente c WHERE c.clienteDireccion = :clienteDireccion"),
    @NamedQuery(name = "Cliente.findByClienteComuna", query = "SELECT c FROM Cliente c WHERE c.clienteComuna = :clienteComuna"),
    @NamedQuery(name = "Cliente.findByClienteFechaNacimiento", query = "SELECT c FROM Cliente c WHERE c.clienteFechaNacimiento = :clienteFechaNacimiento"),
    @NamedQuery(name = "Cliente.findByClienteMail", query = "SELECT c FROM Cliente c WHERE c.clienteMail = :clienteMail"),
    @NamedQuery(name = "Cliente.findByClienteTelefono", query = "SELECT c FROM Cliente c WHERE c.clienteTelefono = :clienteTelefono"),
    @NamedQuery(name = "Cliente.findByClienteTelefonoEmergencia", query = "SELECT c FROM Cliente c WHERE c.clienteTelefonoEmergencia = :clienteTelefonoEmergencia"),
    @NamedQuery(name = "Cliente.findByClienteSexo", query = "SELECT c FROM Cliente c WHERE c.clienteSexo = :clienteSexo"),
    @NamedQuery(name = "Cliente.findByClienteEstadoCivil", query = "SELECT c FROM Cliente c WHERE c.clienteEstadoCivil = :clienteEstadoCivil")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "clienteRut")
    private Integer clienteRut;
    @Basic(optional = false)
    @Column(name = "clienteCodigo")
    private int clienteCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "clienteNombre")
    private String clienteNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "clienteApellidoPaterno")
    private String clienteApellidoPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "clienteApellidoMaterno")
    private String clienteApellidoMaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "clienteDireccion")
    private String clienteDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "clienteComuna")
    private String clienteComuna;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clienteFechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date clienteFechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "clienteMail")
    private String clienteMail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clienteTelefono")
    private int clienteTelefono;
    @Column(name = "clienteTelefonoEmergencia")
    private Integer clienteTelefonoEmergencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "clienteSexo")
    private String clienteSexo;
    @Size(max = 10)
    @Column(name = "clienteEstadoCivil")
    private String clienteEstadoCivil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteclienteRut")
    private Collection<Agendamiento> agendamientoCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente")
    private PlanContratado planContratado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteclienteRut")
    private Collection<HistorialPago> historialPagoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteclienteRut")
    private Collection<RutinaEspecialAsignada> rutinaEspecialAsignadaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteclienteRut")
    private Collection<Evaluacion> evaluacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Collection<Asistencia> asistenciaCollection;

    public Cliente() {
    }

    public Cliente(Integer clienteRut) {
        this.clienteRut = clienteRut;
    }

    public Cliente(Integer clienteRut, int clienteCodigo, String clienteNombre, String clienteApellidoPaterno, String clienteApellidoMaterno, String clienteDireccion, String clienteComuna, Date clienteFechaNacimiento, String clienteMail, int clienteTelefono, String clienteSexo) {
        this.clienteRut = clienteRut;
        this.clienteCodigo = clienteCodigo;
        this.clienteNombre = clienteNombre;
        this.clienteApellidoPaterno = clienteApellidoPaterno;
        this.clienteApellidoMaterno = clienteApellidoMaterno;
        this.clienteDireccion = clienteDireccion;
        this.clienteComuna = clienteComuna;
        this.clienteFechaNacimiento = clienteFechaNacimiento;
        this.clienteMail = clienteMail;
        this.clienteTelefono = clienteTelefono;
        this.clienteSexo = clienteSexo;
    }

    public Integer getClienteRut() {
        return clienteRut;
    }

    public void setClienteRut(Integer clienteRut) {
        this.clienteRut = clienteRut;
    }

    public int getClienteCodigo() {
        return clienteCodigo;
    }

    public void setClienteCodigo(int clienteCodigo) {
        this.clienteCodigo = clienteCodigo;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getClienteApellidoPaterno() {
        return clienteApellidoPaterno;
    }

    public void setClienteApellidoPaterno(String clienteApellidoPaterno) {
        this.clienteApellidoPaterno = clienteApellidoPaterno;
    }

    public String getClienteApellidoMaterno() {
        return clienteApellidoMaterno;
    }

    public void setClienteApellidoMaterno(String clienteApellidoMaterno) {
        this.clienteApellidoMaterno = clienteApellidoMaterno;
    }

    public String getClienteDireccion() {
        return clienteDireccion;
    }

    public void setClienteDireccion(String clienteDireccion) {
        this.clienteDireccion = clienteDireccion;
    }

    public String getClienteComuna() {
        return clienteComuna;
    }

    public void setClienteComuna(String clienteComuna) {
        this.clienteComuna = clienteComuna;
    }

    public Date getClienteFechaNacimiento() {
        return clienteFechaNacimiento;
    }

    public void setClienteFechaNacimiento(Date clienteFechaNacimiento) {
        this.clienteFechaNacimiento = clienteFechaNacimiento;
    }

    public String getClienteMail() {
        return clienteMail;
    }

    public void setClienteMail(String clienteMail) {
        this.clienteMail = clienteMail;
    }

    public int getClienteTelefono() {
        return clienteTelefono;
    }

    public void setClienteTelefono(int clienteTelefono) {
        this.clienteTelefono = clienteTelefono;
    }

    public Integer getClienteTelefonoEmergencia() {
        return clienteTelefonoEmergencia;
    }

    public void setClienteTelefonoEmergencia(Integer clienteTelefonoEmergencia) {
        this.clienteTelefonoEmergencia = clienteTelefonoEmergencia;
    }

    public String getClienteSexo() {
        return clienteSexo;
    }

    public void setClienteSexo(String clienteSexo) {
        this.clienteSexo = clienteSexo;
    }

    public String getClienteEstadoCivil() {
        return clienteEstadoCivil;
    }

    public void setClienteEstadoCivil(String clienteEstadoCivil) {
        this.clienteEstadoCivil = clienteEstadoCivil;
    }

    @XmlTransient
    public Collection<Agendamiento> getAgendamientoCollection() {
        return agendamientoCollection;
    }

    public void setAgendamientoCollection(Collection<Agendamiento> agendamientoCollection) {
        this.agendamientoCollection = agendamientoCollection;
    }

    public PlanContratado getPlanContratado() {
        return planContratado;
    }

    public void setPlanContratado(PlanContratado planContratado) {
        this.planContratado = planContratado;
    }

    @XmlTransient
    public Collection<HistorialPago> getHistorialPagoCollection() {
        return historialPagoCollection;
    }

    public void setHistorialPagoCollection(Collection<HistorialPago> historialPagoCollection) {
        this.historialPagoCollection = historialPagoCollection;
    }

    @XmlTransient
    public Collection<RutinaEspecialAsignada> getRutinaEspecialAsignadaCollection() {
        return rutinaEspecialAsignadaCollection;
    }

    public void setRutinaEspecialAsignadaCollection(Collection<RutinaEspecialAsignada> rutinaEspecialAsignadaCollection) {
        this.rutinaEspecialAsignadaCollection = rutinaEspecialAsignadaCollection;
    }

    @XmlTransient
    public Collection<Evaluacion> getEvaluacionCollection() {
        return evaluacionCollection;
    }

    public void setEvaluacionCollection(Collection<Evaluacion> evaluacionCollection) {
        this.evaluacionCollection = evaluacionCollection;
    }

    @XmlTransient
    public Collection<Asistencia> getAsistenciaCollection() {
        return asistenciaCollection;
    }

    public void setAsistenciaCollection(Collection<Asistencia> asistenciaCollection) {
        this.asistenciaCollection = asistenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteRut != null ? clienteRut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.clienteRut == null && other.clienteRut != null) || (this.clienteRut != null && !this.clienteRut.equals(other.clienteRut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dozen.www.entities.Cliente[ clienteRut=" + clienteRut + " ]";
    }
    
}
