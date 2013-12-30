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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author root
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByClienteRut", query = "SELECT c FROM Cliente c WHERE c.clienteRut = :clienteRut"),
    @NamedQuery(name = "Cliente.findByClienteCodigo", query = "SELECT c FROM Cliente c WHERE c.clienteCodigo = :clienteCodigo"),
    @NamedQuery(name = "Cliente.findByClienteNombre", query = "SELECT c FROM Cliente c WHERE c.clienteNombre = :clienteNombre"),
    @NamedQuery(name = "Cliente.findByClienteApellido", query = "SELECT c FROM Cliente c WHERE c.clienteApellido = :clienteApellido"),
    @NamedQuery(name = "Cliente.findByClienteFechaNacimiento", query = "SELECT c FROM Cliente c WHERE c.clienteFechaNacimiento = :clienteFechaNacimiento"),
    @NamedQuery(name = "Cliente.findByClienteDireccion", query = "SELECT c FROM Cliente c WHERE c.clienteDireccion = :clienteDireccion"),
    @NamedQuery(name = "Cliente.findByClienteMail", query = "SELECT c FROM Cliente c WHERE c.clienteMail = :clienteMail"),
    @NamedQuery(name = "Cliente.findByClienteTelefono", query = "SELECT c FROM Cliente c WHERE c.clienteTelefono = :clienteTelefono"),
    @NamedQuery(name = "Cliente.findByClienteTelefonoEmergencia", query = "SELECT c FROM Cliente c WHERE c.clienteTelefonoEmergencia = :clienteTelefonoEmergencia"),
    @NamedQuery(name = "Cliente.findByClienteSexo", query = "SELECT c FROM Cliente c WHERE c.clienteSexo = :clienteSexo"),
    @NamedQuery(name = "Cliente.findByClienteEstadoCivil", query = "SELECT c FROM Cliente c WHERE c.clienteEstadoCivil = :clienteEstadoCivil")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente_rut")
    private int clienteRut;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cliente_codigo")
    private Integer clienteCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "cliente_nombre")
    private String clienteNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "cliente_apellido")
    private String clienteApellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente_fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date clienteFechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "cliente_direccion")
    private String clienteDireccion;
    @Size(max = 45)
    @Column(name = "cliente_mail")
    private String clienteMail;
    @Column(name = "cliente_telefono")
    private Integer clienteTelefono;
    @Column(name = "cliente_telefono_emergencia")
    private Integer clienteTelefonoEmergencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente_sexo")
    private char clienteSexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cliente_estado_civil")
    private String clienteEstadoCivil;

    public Cliente() {
    }

    public Cliente(Integer clienteCodigo) {
        this.clienteCodigo = clienteCodigo;
    }

    public Cliente(Integer clienteCodigo, int clienteRut, String clienteNombre, String clienteApellido, Date clienteFechaNacimiento, String clienteDireccion, char clienteSexo, String clienteEstadoCivil) {
        this.clienteCodigo = clienteCodigo;
        this.clienteRut = clienteRut;
        this.clienteNombre = clienteNombre;
        this.clienteApellido = clienteApellido;
        this.clienteFechaNacimiento = clienteFechaNacimiento;
        this.clienteDireccion = clienteDireccion;
        this.clienteSexo = clienteSexo;
        this.clienteEstadoCivil = clienteEstadoCivil;
    }

    public int getClienteRut() {
        return clienteRut;
    }

    public void setClienteRut(int clienteRut) {
        this.clienteRut = clienteRut;
    }

    public Integer getClienteCodigo() {
        return clienteCodigo;
    }

    public void setClienteCodigo(Integer clienteCodigo) {
        this.clienteCodigo = clienteCodigo;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getClienteApellido() {
        return clienteApellido;
    }

    public void setClienteApellido(String clienteApellido) {
        this.clienteApellido = clienteApellido;
    }

    public Date getClienteFechaNacimiento() {
        return clienteFechaNacimiento;
    }

    public void setClienteFechaNacimiento(Date clienteFechaNacimiento) {
        this.clienteFechaNacimiento = clienteFechaNacimiento;
    }

    public String getClienteDireccion() {
        return clienteDireccion;
    }

    public void setClienteDireccion(String clienteDireccion) {
        this.clienteDireccion = clienteDireccion;
    }

    public String getClienteMail() {
        return clienteMail;
    }

    public void setClienteMail(String clienteMail) {
        this.clienteMail = clienteMail;
    }

    public Integer getClienteTelefono() {
        return clienteTelefono;
    }

    public void setClienteTelefono(Integer clienteTelefono) {
        this.clienteTelefono = clienteTelefono;
    }

    public Integer getClienteTelefonoEmergencia() {
        return clienteTelefonoEmergencia;
    }

    public void setClienteTelefonoEmergencia(Integer clienteTelefonoEmergencia) {
        this.clienteTelefonoEmergencia = clienteTelefonoEmergencia;
    }

    public char getClienteSexo() {
        return clienteSexo;
    }

    public void setClienteSexo(char clienteSexo) {
        this.clienteSexo = clienteSexo;
    }

    public String getClienteEstadoCivil() {
        return clienteEstadoCivil;
    }

    public void setClienteEstadoCivil(String clienteEstadoCivil) {
        this.clienteEstadoCivil = clienteEstadoCivil;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.clienteCodigo == null && other.clienteCodigo != null) || (this.clienteCodigo != null && !this.clienteCodigo.equals(other.clienteCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "clienteRut=" + clienteRut + ", clienteCodigo=" + clienteCodigo + ", clienteNombre=" + clienteNombre + ", clienteApellido=" + clienteApellido + ", clienteFechaNacimiento=" + clienteFechaNacimiento + ", clienteDireccion=" + clienteDireccion + ", clienteMail=" + clienteMail + ", clienteTelefono=" + clienteTelefono + ", clienteTelefonoEmergencia=" + clienteTelefonoEmergencia + ", clienteSexo=" + clienteSexo + ", clienteEstadoCivil=" + clienteEstadoCivil + '}';
    }

   
    
}
