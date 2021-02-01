/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author victor.barba
 */
@Entity
@Table(name = "CICLO_ACADEMICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CicloAcademico.findAll", query = "SELECT c FROM CicloAcademico c WHERE c.cicloAcademicoPK.anio >= 2011 order by c.cicloAcademicoPK.anio DESC"),
    @NamedQuery(name = "CicloAcademico.findByAnio", query = "SELECT c FROM CicloAcademico c WHERE c.cicloAcademicoPK.anio = :anio"),
    @NamedQuery(name = "CicloAcademico.findByCiclo", query = "SELECT c FROM CicloAcademico c WHERE c.cicloAcademicoPK.ciclo = :ciclo"),
    @NamedQuery(name = "CicloAcademico.findByFInicio", query = "SELECT c FROM CicloAcademico c WHERE c.fInicio = :fInicio"),
    @NamedQuery(name = "CicloAcademico.findByFFinal", query = "SELECT c FROM CicloAcademico c WHERE c.fFinal = :fFinal"),
    @NamedQuery(name = "CicloAcademico.findByNombreCiclo", query = "SELECT c FROM CicloAcademico c WHERE c.nombreCiclo = :nombreCiclo"),
    @NamedQuery(name = "CicloAcademico.findByEstadoCiclo", query = "SELECT c FROM CicloAcademico c WHERE c.estadoCiclo = :estadoCiclo"),
    @NamedQuery(name = "CicloAcademico.findByNrInscripcion", query = "SELECT c FROM CicloAcademico c WHERE c.nrInscripcion = :nrInscripcion"),
    @NamedQuery(name = "CicloAcademico.findByNrMatricula", query = "SELECT c FROM CicloAcademico c WHERE c.nrMatricula = :nrMatricula"),
    @NamedQuery(name = "CicloAcademico.findByNrFormulario", query = "SELECT c FROM CicloAcademico c WHERE c.nrFormulario = :nrFormulario")})
public class CicloAcademico implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CicloAcademicoPK cicloAcademicoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "F_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "F_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFinal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_CICLO")
    private String nombreCiclo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_CICLO")
    private char estadoCiclo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NR_INSCRIPCION")
    private long nrInscripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NR_MATRICULA")
    private long nrMatricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NR_FORMULARIO")
    private long nrFormulario;

    public CicloAcademico() {
    }

    public CicloAcademico(CicloAcademicoPK cicloAcademicoPK) {
        this.cicloAcademicoPK = cicloAcademicoPK;
    }

    public CicloAcademico(CicloAcademicoPK cicloAcademicoPK, Date fInicio, Date fFinal, String nombreCiclo, char estadoCiclo, long nrInscripcion, long nrMatricula, long nrFormulario) {
        this.cicloAcademicoPK = cicloAcademicoPK;
        this.fInicio = fInicio;
        this.fFinal = fFinal;
        this.nombreCiclo = nombreCiclo;
        this.estadoCiclo = estadoCiclo;
        this.nrInscripcion = nrInscripcion;
        this.nrMatricula = nrMatricula;
        this.nrFormulario = nrFormulario;
    }

    public CicloAcademico(long anio, long ciclo) {
        this.cicloAcademicoPK = new CicloAcademicoPK(anio, ciclo);
    }

    public CicloAcademicoPK getCicloAcademicoPK() {
        return cicloAcademicoPK;
    }

    public void setCicloAcademicoPK(CicloAcademicoPK cicloAcademicoPK) {
        this.cicloAcademicoPK = cicloAcademicoPK;
    }

    public Date getFInicio() {
        return fInicio;
    }

    public void setFInicio(Date fInicio) {
        this.fInicio = fInicio;
    }

    public Date getFFinal() {
        return fFinal;
    }

    public void setFFinal(Date fFinal) {
        this.fFinal = fFinal;
    }

    public String getNombreCiclo() {
        return nombreCiclo;
    }

    public void setNombreCiclo(String nombreCiclo) {
        this.nombreCiclo = nombreCiclo;
    }

    public char getEstadoCiclo() {
        return estadoCiclo;
    }

    public void setEstadoCiclo(char estadoCiclo) {
        this.estadoCiclo = estadoCiclo;
    }

    public long getNrInscripcion() {
        return nrInscripcion;
    }

    public void setNrInscripcion(long nrInscripcion) {
        this.nrInscripcion = nrInscripcion;
    }

    public long getNrMatricula() {
        return nrMatricula;
    }

    public void setNrMatricula(long nrMatricula) {
        this.nrMatricula = nrMatricula;
    }

    public long getNrFormulario() {
        return nrFormulario;
    }

    public void setNrFormulario(long nrFormulario) {
        this.nrFormulario = nrFormulario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cicloAcademicoPK != null ? cicloAcademicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CicloAcademico)) {
            return false;
        }
        CicloAcademico other = (CicloAcademico) object;
        if ((this.cicloAcademicoPK == null && other.cicloAcademicoPK != null) || (this.cicloAcademicoPK != null && !this.cicloAcademicoPK.equals(other.cicloAcademicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.portaldoc.entity.CicloAcademico[ cicloAcademicoPK=" + cicloAcademicoPK + " ]";
    }
    
}
