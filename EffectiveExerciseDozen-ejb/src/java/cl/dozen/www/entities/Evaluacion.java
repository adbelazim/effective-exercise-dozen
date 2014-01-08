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
 * @author sergio
 */
@Entity
@Table(name = "evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e"),
    @NamedQuery(name = "Evaluacion.findByEvaluacionId", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionId = :evaluacionId"),
    @NamedQuery(name = "Evaluacion.findByEvaluacionFecha", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionFecha = :evaluacionFecha"),
    @NamedQuery(name = "Evaluacion.findByEvaluacionEstatura", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionEstatura = :evaluacionEstatura"),
    @NamedQuery(name = "Evaluacion.findByEvaluacionPeso", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionPeso = :evaluacionPeso"),
    @NamedQuery(name = "Evaluacion.findByEvaluacionBiceps", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionBiceps = :evaluacionBiceps"),
    @NamedQuery(name = "Evaluacion.findByEvaluacionIliaco", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionIliaco = :evaluacionIliaco"),
    @NamedQuery(name = "Evaluacion.findByEvaluacionTriceps", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionTriceps = :evaluacionTriceps"),
    @NamedQuery(name = "Evaluacion.findByEvaluacionEscapular", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionEscapular = :evaluacionEscapular"),
    @NamedQuery(name = "Evaluacion.findByEvaluacionPGC", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionPGC = :evaluacionPGC"),
    @NamedQuery(name = "Evaluacion.findByEvaluacionIMC", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionIMC = :evaluacionIMC"),
    @NamedQuery(name = "Evaluacion.findByEvaluacionSuma", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionSuma = :evaluacionSuma"),
    @NamedQuery(name = "Evaluacion.findByEvaluacionAbdominal", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionAbdominal = :evaluacionAbdominal"),
    @NamedQuery(name = "Evaluacion.findByEvaluacionObservacion", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionObservacion = :evaluacionObservacion")})
public class Evaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "evaluacionId")
    private Integer evaluacionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evaluacionFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date evaluacionFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evaluacionEstatura")
    private float evaluacionEstatura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evaluacionPeso")
    private float evaluacionPeso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evaluacionBiceps")
    private int evaluacionBiceps;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evaluacionIliaco")
    private int evaluacionIliaco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evaluacionTriceps")
    private int evaluacionTriceps;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evaluacionEscapular")
    private int evaluacionEscapular;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evaluacionPGC")
    private float evaluacionPGC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evaluacionIMC")
    private float evaluacionIMC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evaluacionSuma")
    private int evaluacionSuma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evaluacionAbdominal")
    private int evaluacionAbdominal;
    @Size(max = 200)
    @Column(name = "evaluacionObservacion")
    private String evaluacionObservacion;
    @JoinColumn(name = "entrenador_entrenadorRut", referencedColumnName = "entrenadorRut")
    @ManyToOne(optional = false)
    private Entrenador entrenadorentrenadorRut;
    @JoinColumn(name = "cliente_clienteRut", referencedColumnName = "clienteRut")
    @ManyToOne(optional = false)
    private Cliente clienteclienteRut;

    public Evaluacion() {
    }

    public Evaluacion(Integer evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    public Evaluacion(Integer evaluacionId, Date evaluacionFecha, float evaluacionEstatura, float evaluacionPeso, int evaluacionBiceps, int evaluacionIliaco, int evaluacionTriceps, int evaluacionEscapular, float evaluacionPGC, float evaluacionIMC, int evaluacionSuma, int evaluacionAbdominal) {
        this.evaluacionId = evaluacionId;
        this.evaluacionFecha = evaluacionFecha;
        this.evaluacionEstatura = evaluacionEstatura;
        this.evaluacionPeso = evaluacionPeso;
        this.evaluacionBiceps = evaluacionBiceps;
        this.evaluacionIliaco = evaluacionIliaco;
        this.evaluacionTriceps = evaluacionTriceps;
        this.evaluacionEscapular = evaluacionEscapular;
        this.evaluacionPGC = evaluacionPGC;
        this.evaluacionIMC = evaluacionIMC;
        this.evaluacionSuma = evaluacionSuma;
        this.evaluacionAbdominal = evaluacionAbdominal;
    }

    public Integer getEvaluacionId() {
        return evaluacionId;
    }

    public void setEvaluacionId(Integer evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    public Date getEvaluacionFecha() {
        return evaluacionFecha;
    }

    public void setEvaluacionFecha(Date evaluacionFecha) {
        this.evaluacionFecha = evaluacionFecha;
    }

    public float getEvaluacionEstatura() {
        return evaluacionEstatura;
    }

    public void setEvaluacionEstatura(float evaluacionEstatura) {
        this.evaluacionEstatura = evaluacionEstatura;
    }

    public float getEvaluacionPeso() {
        return evaluacionPeso;
    }

    public void setEvaluacionPeso(float evaluacionPeso) {
        this.evaluacionPeso = evaluacionPeso;
    }

    public int getEvaluacionBiceps() {
        return evaluacionBiceps;
    }

    public void setEvaluacionBiceps(int evaluacionBiceps) {
        this.evaluacionBiceps = evaluacionBiceps;
    }

    public int getEvaluacionIliaco() {
        return evaluacionIliaco;
    }

    public void setEvaluacionIliaco(int evaluacionIliaco) {
        this.evaluacionIliaco = evaluacionIliaco;
    }

    public int getEvaluacionTriceps() {
        return evaluacionTriceps;
    }

    public void setEvaluacionTriceps(int evaluacionTriceps) {
        this.evaluacionTriceps = evaluacionTriceps;
    }

    public int getEvaluacionEscapular() {
        return evaluacionEscapular;
    }

    public void setEvaluacionEscapular(int evaluacionEscapular) {
        this.evaluacionEscapular = evaluacionEscapular;
    }

    public float getEvaluacionPGC() {
        return evaluacionPGC;
    }

    public void setEvaluacionPGC(float evaluacionPGC) {
        this.evaluacionPGC = evaluacionPGC;
    }

    public float getEvaluacionIMC() {
        return evaluacionIMC;
    }

    public void setEvaluacionIMC(float evaluacionIMC) {
        this.evaluacionIMC = evaluacionIMC;
    }

    public int getEvaluacionSuma() {
        return evaluacionSuma;
    }

    public void setEvaluacionSuma(int evaluacionSuma) {
        this.evaluacionSuma = evaluacionSuma;
    }

    public int getEvaluacionAbdominal() {
        return evaluacionAbdominal;
    }

    public void setEvaluacionAbdominal(int evaluacionAbdominal) {
        this.evaluacionAbdominal = evaluacionAbdominal;
    }

    public String getEvaluacionObservacion() {
        return evaluacionObservacion;
    }

    public void setEvaluacionObservacion(String evaluacionObservacion) {
        this.evaluacionObservacion = evaluacionObservacion;
    }

    public Entrenador getEntrenadorentrenadorRut() {
        return entrenadorentrenadorRut;
    }

    public void setEntrenadorentrenadorRut(Entrenador entrenadorentrenadorRut) {
        this.entrenadorentrenadorRut = entrenadorentrenadorRut;
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
        hash += (evaluacionId != null ? evaluacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluacion)) {
            return false;
        }
        Evaluacion other = (Evaluacion) object;
        if ((this.evaluacionId == null && other.evaluacionId != null) || (this.evaluacionId != null && !this.evaluacionId.equals(other.evaluacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dozen.www.entities.Evaluacion[ evaluacionId=" + evaluacionId + " ]";
    }
    
}
