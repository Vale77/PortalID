/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.entities;

import ec.edu.uasb.portaldoc.entities.CicloAcademico;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "ESPECIALIZACION")
@NamedQueries({
    @NamedQuery(name = "Especializacion.findAll", query = "SELECT e FROM Especializacion e")})
public class Especializacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EspecializacionPK especializacionPK;
    @Column(name = "CODIGO_ESPANT")
    private Long codigoEspant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "NOMBRE_ESP")
    private String nombreEsp;
    @Size(max = 200)
    @Column(name = "TITULO_ESP")
    private String tituloEsp;
    @Column(name = "FINICIO_ESP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finicioEsp;
    @Column(name = "FFIN_ESP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ffinEsp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DURACION_ESP")
    private int duracionEsp;
    @Column(name = "AREAESTUDIO_ESP")
    private Long areaestudioEsp;
    @Column(name = "ANIO_MATRICULA_ESP")
    private Long anioMatriculaEsp;
    @Column(name = "FPRESENTA_TESIS_ESP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fpresentaTesisEsp;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NOTA_MAXIMA_ESP")
    private BigDecimal notaMaximaEsp;
    @Column(name = "PORC_ASIST_ESP")
    private BigDecimal porcAsistEsp;
    @Column(name = "NUM_CRED_MIN_ESP")
    private Integer numCredMinEsp;
    @Column(name = "NUM_CRED_MAX_ESP")
    private Integer numCredMaxEsp;
    @Size(max = 60)
    @Column(name = "EMAIL_ESP")
    private String emailEsp;
    @Column(name = "CODIGO_PROFESOR")
    private Long codigoProfesor;
    @JoinColumn(name = "CODIGO_NIVEACAD", referencedColumnName = "CODIGO_NIVEACAD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NivelAcademico nivelAcademico;
    @JoinColumns({
        @JoinColumn(name = "CODIGO_FACULTAD", referencedColumnName = "CODIGO_FACULTAD", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGO_ESCUELA", referencedColumnName = "CODIGO_ESCUELA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Escuela escuela;
    @JoinColumns({
        @JoinColumn(name = "ANIO", referencedColumnName = "ANIO", insertable = false, updatable = false),
        @JoinColumn(name = "CICLO", referencedColumnName = "CICLO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CicloAcademico cicloAcademico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especializacion")
    private List<ExamComplexivo> examComplexivoList;

    public Especializacion() {
    }

    public Especializacion(EspecializacionPK especializacionPK) {
        this.especializacionPK = especializacionPK;
    }

    public Especializacion(EspecializacionPK especializacionPK, String nombreEsp, int duracionEsp) {
        this.especializacionPK = especializacionPK;
        this.nombreEsp = nombreEsp;
        this.duracionEsp = duracionEsp;
    }

    public Especializacion(long codigoNiveacad, long codigoFacultad, long codigoEscuela, long codigoEsp, long anio, long ciclo) {
        this.especializacionPK = new EspecializacionPK(codigoNiveacad, codigoFacultad, codigoEscuela, codigoEsp, anio, ciclo);
    }

    public EspecializacionPK getEspecializacionPK() {
        return especializacionPK;
    }

    public void setEspecializacionPK(EspecializacionPK especializacionPK) {
        this.especializacionPK = especializacionPK;
    }

    public Long getCodigoEspant() {
        return codigoEspant;
    }

    public void setCodigoEspant(Long codigoEspant) {
        this.codigoEspant = codigoEspant;
    }

    public String getNombreEsp() {
        return nombreEsp;
    }

    public void setNombreEsp(String nombreEsp) {
        this.nombreEsp = nombreEsp;
    }

    public String getTituloEsp() {
        return tituloEsp;
    }

    public void setTituloEsp(String tituloEsp) {
        this.tituloEsp = tituloEsp;
    }

    public Date getFinicioEsp() {
        return finicioEsp;
    }

    public void setFinicioEsp(Date finicioEsp) {
        this.finicioEsp = finicioEsp;
    }

    public Date getFfinEsp() {
        return ffinEsp;
    }

    public void setFfinEsp(Date ffinEsp) {
        this.ffinEsp = ffinEsp;
    }

    public int getDuracionEsp() {
        return duracionEsp;
    }

    public void setDuracionEsp(int duracionEsp) {
        this.duracionEsp = duracionEsp;
    }

    public Long getAreaestudioEsp() {
        return areaestudioEsp;
    }

    public void setAreaestudioEsp(Long areaestudioEsp) {
        this.areaestudioEsp = areaestudioEsp;
    }

    public Long getAnioMatriculaEsp() {
        return anioMatriculaEsp;
    }

    public void setAnioMatriculaEsp(Long anioMatriculaEsp) {
        this.anioMatriculaEsp = anioMatriculaEsp;
    }

    public Date getFpresentaTesisEsp() {
        return fpresentaTesisEsp;
    }

    public void setFpresentaTesisEsp(Date fpresentaTesisEsp) {
        this.fpresentaTesisEsp = fpresentaTesisEsp;
    }

    public BigDecimal getNotaMaximaEsp() {
        return notaMaximaEsp;
    }

    public void setNotaMaximaEsp(BigDecimal notaMaximaEsp) {
        this.notaMaximaEsp = notaMaximaEsp;
    }

    public BigDecimal getPorcAsistEsp() {
        return porcAsistEsp;
    }

    public void setPorcAsistEsp(BigDecimal porcAsistEsp) {
        this.porcAsistEsp = porcAsistEsp;
    }

    public Integer getNumCredMinEsp() {
        return numCredMinEsp;
    }

    public void setNumCredMinEsp(Integer numCredMinEsp) {
        this.numCredMinEsp = numCredMinEsp;
    }

    public Integer getNumCredMaxEsp() {
        return numCredMaxEsp;
    }

    public void setNumCredMaxEsp(Integer numCredMaxEsp) {
        this.numCredMaxEsp = numCredMaxEsp;
    }

    public String getEmailEsp() {
        return emailEsp;
    }

    public void setEmailEsp(String emailEsp) {
        this.emailEsp = emailEsp;
    }

    public Long getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(Long codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public NivelAcademico getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(NivelAcademico nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public Escuela getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public List<ExamComplexivo> getExamComplexivoList() {
        return examComplexivoList;
    }

    public void setExamComplexivoList(List<ExamComplexivo> examComplexivoList) {
        this.examComplexivoList = examComplexivoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (especializacionPK != null ? especializacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especializacion)) {
            return false;
        }
        Especializacion other = (Especializacion) object;
        if ((this.especializacionPK == null && other.especializacionPK != null) || (this.especializacionPK != null && !this.especializacionPK.equals(other.especializacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.infoanual.entities.Especializacion[ especializacionPK=" + especializacionPK + " ]";
    }
    
}
