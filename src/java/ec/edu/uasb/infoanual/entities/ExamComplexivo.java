/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author johana.orozco
 */
@Entity
@Table(name = "EXAM_COMPLEXIVO")
@NamedQueries({
    @NamedQuery(name = "ExamComplexivo.findAll", query = "SELECT e FROM ExamComplexivo e")})
public class ExamComplexivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExamComplexivoPK examComplexivoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NRO_EXAMEN_PREPAR")
    private long nroExamenPrepar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NRO_EXAMEN_CALIF")
    private long nroExamenCalif;
    @JoinColumn(name = "CODIGO_PROFESOR", referencedColumnName = "CODIGO_PROFESOR", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profesor profesor;
    @Size(min = 1, max = 60)
    @Column(name = "USUARIO_CREA")
    private String usuarioCrea;
    @Size(min = 1, max = 60)
    @Column(name = "USUARIO_ULTMODIFIC")
    private String usuarioUltmodific;
    @Column(name = "FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCrea;
    @Column(name = "FECHA_ULTMODIFIC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltmodific;
    @Column(name = "TIPO_EXAMEN")
    private char tipoexamen;
    @JoinColumns({
        @JoinColumn(name = "CODIGO_NIVEACAD", referencedColumnName = "CODIGO_NIVEACAD", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGO_FACULTAD", referencedColumnName = "CODIGO_FACULTAD", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGO_ESCUELA", referencedColumnName = "CODIGO_ESCUELA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGO_ESP", referencedColumnName = "CODIGO_ESP", insertable = false, updatable = false),
        @JoinColumn(name = "ANIO", referencedColumnName = "ANIO", insertable = false, updatable = false),
        @JoinColumn(name = "CICLO", referencedColumnName = "CICLO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Especializacion especializacion;

    public ExamComplexivo() {
    }

    public ExamComplexivo(ExamComplexivoPK examComplexivoPK) {
        this.examComplexivoPK = examComplexivoPK;
    }

    public ExamComplexivo(ExamComplexivoPK examComplexivoPK, long nroExamenPrepar, long nroExamenCalif) {
        this.examComplexivoPK = examComplexivoPK;
        this.nroExamenPrepar = nroExamenPrepar;
        this.nroExamenCalif = nroExamenCalif;
    }

    public ExamComplexivo(long codigoNiveacad, long codigoFacultad, long codigoEscuela, long codigoEsp, long anio, long ciclo, long codigoProfesor) {
        this.examComplexivoPK = new ExamComplexivoPK(codigoNiveacad, codigoFacultad, codigoEscuela, codigoEsp, anio, ciclo, codigoProfesor);
    }

    public ExamComplexivoPK getExamComplexivoPK() {
        return examComplexivoPK;
    }

    public void setExamComplexivoPK(ExamComplexivoPK examComplexivoPK) {
        this.examComplexivoPK = examComplexivoPK;
    }

    public long getNroExamenPrepar() {
        return nroExamenPrepar;
    }

    public void setNroExamenPrepar(long nroExamenPrepar) {
        this.nroExamenPrepar = nroExamenPrepar;
    }

    public long getNroExamenCalif() {
        return nroExamenCalif;
    }

    public void setNroExamenCalif(long nroExamenCalif) {
        this.nroExamenCalif = nroExamenCalif;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Especializacion getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(Especializacion especializacion) {
        this.especializacion = especializacion;
    }

    public String getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(String usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    public String getUsuarioUltmodific() {
        return usuarioUltmodific;
    }

    public void setUsuarioUltmodific(String usuarioUltmodific) {
        this.usuarioUltmodific = usuarioUltmodific;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public Date getFechaUltmodific() {
        return fechaUltmodific;
    }

    public void setFechaUltmodific(Date fechaUltmodific) {
        this.fechaUltmodific = fechaUltmodific;
    }

    public char getTipoexamen() {
        return tipoexamen;
    }

    public void setTipoexamen(char tipoexamen) {
        this.tipoexamen = tipoexamen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examComplexivoPK != null ? examComplexivoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamComplexivo)) {
            return false;
        }
        ExamComplexivo other = (ExamComplexivo) object;
        if ((this.examComplexivoPK == null && other.examComplexivoPK != null) || (this.examComplexivoPK != null && !this.examComplexivoPK.equals(other.examComplexivoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.infoanual.entities.ExamComplexivo[ examComplexivoPK=" + examComplexivoPK + " ]";
    }
}
