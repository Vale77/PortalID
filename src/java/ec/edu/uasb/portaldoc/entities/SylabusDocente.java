/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "SYLABUS_DOCENTE")
@XmlRootElement
public class SylabusDocente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SylabusDocentePK sylabusDocentePK;

    @Column(name = "NUMERO_CLASES")
    private Integer numeroClases;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NUMERO_CREDITOS")
    private BigDecimal numeroCreditos;
    @Column(name = "MODALIDAD")
    private Character modalidad;
    @Size(max = 100)
    @Column(name = "HORARIO")
    private String horario;
    @Size(max = 8000)
    @Column(name = "DESCRIPCION_MATERIA")
    private String descripcionMateria;
    @Size(max = 8000)
    @Column(name = "OBJETIVO_GENERAL")
    private String objetivoGeneral;
    @Size(max = 8000)
    @Column(name = "OBJETIVO_ESPECIFICO")
    private String objetivoEspecifico;

    @Size(max = 8000)
    @Column(name = "ARTIC_UNID_CURRICULAR")
    private String articUnidCurricular;
    @Size(max = 8000)
    @Column(name = "ARTIC_AMBI_CURRICULAR")
    private String articAmbiCurricular;
    @Size(max = 8000)
    @Column(name = "ARTIC_CAMP_FORMACION")
    private String articCampFormacion;
    @Size(max = 8000)
    @Column(name = "ARTIC_OTRAS_CARAC")
    private String articOtrasCarac;

    @Size(max = 8000)
    @Column(name = "PROCESO_DOCENTE")
    private String procesoDocente;

    @Size(max = 8000)
    @Column(name = "PROCESO_DOCENTE_ACOMP")
    private String procesoDocenteAcomp;
    @Size(max = 8000)
    @Column(name = "PROCESO_DOCENTE_ACTIV")
    private String procesoDocenteActiv;

    @Size(max = 8000)
    @Column(name = "EVALUACION")
    private String evaluacion;

    @Size(max = 8000)
    @Column(name = "EVALUACION_ELEMENTOS")
    private String evaluacionElementos;

    @Size(max = 8000)
    @Column(name = "BIBLIOGRAFIA")
    private String bibliografia;
    @Size(max = 8000)
    @Column(name = "OBSERVACIONES")
    private String observaciones;

    @Size(max = 8000)
    @Column(name = "OBSERVACIONES_UTIL_REC")
    private String observacionesUtilRec;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_SYLABUS")
    private char estadoSylabus;
    @Column(name = "ESTADO_ENVIO")
    private Character estadoEnvio;
    @Column(name = "APROBADO_POR")
    private Long aprobadoPor;
    @Column(name = "FECHA_APROBACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAprobacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCrea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ULTMODIFIC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltmodific;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "USUARIO_CREA")
    private String usuarioCrea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "USUARIO_ULTMODIFIC")
    private String usuarioUltmodific;
    @Size(min = 1, max = 8000)
    @Column(name = "OBSERVACION_COORDINADOR")
    private String observacionCoordinador;
    @Size(max = 8000)
   
    @Column(name = "COA_HORAS_PRACTICAS")
    private String CoaHorasParcticas;
    @Size(max = 8000)
    @Column(name = "COA_TRABAJO_AUTONOMO")
    private String CoaTrabajoAutonomo;
    @Size(max = 8000)
    
    @Column(name = "CCD_SEGUIMIENTO_TUTORIA")
    private String ccdSeguimientoTutoria;
    @Size(max = 8000)
    @Column(name = "LUGAR_ATENCION")
    private String LugarAtencion;

    public SylabusDocente() {
    }

    public SylabusDocente(SylabusDocentePK sylabusDocentePK) {
        this.sylabusDocentePK = sylabusDocentePK;
    }

    public SylabusDocente(SylabusDocentePK sylabusDocentePK, char estadoSylabus, Date fechaCrea, Date fechaUltmodific, String usuarioCrea,
            String usuarioUltmodific, String observacionCoordinador) {
        this.sylabusDocentePK = sylabusDocentePK;
        this.estadoSylabus = estadoSylabus;
        this.fechaCrea = fechaCrea;
        this.fechaUltmodific = fechaUltmodific;
        this.usuarioCrea = usuarioCrea;
        this.usuarioUltmodific = usuarioUltmodific;
        this.observacionCoordinador = observacionCoordinador;
    }

    public SylabusDocente(Long anio, Long ciclo, Long codigoMateria, Long codigoProfesor, Long codigoNivel, Long vacCodnum,
            Long codParalelo, Long codEsp) {
        this.sylabusDocentePK = new SylabusDocentePK(anio, ciclo, codigoMateria, codigoProfesor, codigoNivel, vacCodnum, codParalelo, codEsp);
    }

    public SylabusDocentePK getSylabusDocentePK() {
        return sylabusDocentePK;
    }

    public void setSylabusDocentePK(SylabusDocentePK sylabusDocentePK) {
        this.sylabusDocentePK = sylabusDocentePK;
    }

    public Integer getNumeroClases() {
        return numeroClases;
    }

    public void setNumeroClases(Integer numeroClases) {
        this.numeroClases = numeroClases;
    }

    public BigDecimal getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(BigDecimal numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public Character getModalidad() {
        return modalidad;
    }

    public void setModalidad(Character modalidad) {
        this.modalidad = modalidad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDescripcionMateria() {
        return descripcionMateria;
    }

    public void setDescripcionMateria(String descripcionMateria) {
        this.descripcionMateria = descripcionMateria;
    }

    public String getObjetivoGeneral() {
        return objetivoGeneral;
    }

    public void setObjetivoGeneral(String objetivoGeneral) {
        this.objetivoGeneral = objetivoGeneral;
    }

    public String getObjetivoEspecifico() {
        return objetivoEspecifico;
    }

    public void setObjetivoEspecifico(String objetivoEspecifico) {
        this.objetivoEspecifico = objetivoEspecifico;
    }

    public String getArticUnidCurricular() {
        return articUnidCurricular;
    }

    public void setArticUnidCurricular(String articUnidCurricular) {
        this.articUnidCurricular = articUnidCurricular;
    }

    public String getArticAmbiCurricular() {
        return articAmbiCurricular;
    }

    public void setArticAmbiCurricular(String articAmbiCurricular) {
        this.articAmbiCurricular = articAmbiCurricular;
    }

    public String getArticCampFormacion() {
        return articCampFormacion;
    }

    public void setArticCampFormacion(String articCampFormacion) {
        this.articCampFormacion = articCampFormacion;
    }

    public String getArticOtrasCarac() {
        return articOtrasCarac;
    }

    public void setArticOtrasCarac(String articOtrasCarac) {
        this.articOtrasCarac = articOtrasCarac;
    }

    public String getProcesoDocente() {
        return procesoDocente;
    }

    public void setProcesoDocente(String procesoDocente) {
        this.procesoDocente = procesoDocente;
    }

    public String getProcesoDocenteAcomp() {
        return procesoDocenteAcomp;
    }

    public void setProcesoDocenteAcomp(String procesoDocenteAcomp) {
        this.procesoDocenteAcomp = procesoDocenteAcomp;
    }

    public String getProcesoDocenteActiv() {
        return procesoDocenteActiv;
    }

    public void setProcesoDocenteActiv(String procesoDocenteActiv) {
        this.procesoDocenteActiv = procesoDocenteActiv;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getEvaluacionElementos() {
        return evaluacionElementos;
    }

    public void setEvaluacionElementos(String evaluacionElementos) {
        this.evaluacionElementos = evaluacionElementos;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getObservacionesUtilRec() {
        return observacionesUtilRec;
    }

    public void setObservacionesUtilRec(String observacionesUtilRec) {
        this.observacionesUtilRec = observacionesUtilRec;
    }

    public char getEstadoSylabus() {
        return estadoSylabus;
    }

    public void setEstadoSylabus(char estadoSylabus) {
        this.estadoSylabus = estadoSylabus;
    }

    public Character getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(Character estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public Long getAprobadoPor() {
        return aprobadoPor;
    }

    public void setAprobadoPor(Long aprobadoPor) {
        this.aprobadoPor = aprobadoPor;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
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

    public String getObservacionCoordinador() {
        return observacionCoordinador;
    }

    public void setObservacionCoordinador(String observacionCoordinador) {
        this.observacionCoordinador = observacionCoordinador;
    }

      public String getCoaHorasParcticas() {
        return CoaHorasParcticas;
    }

    public void setCoaHorasParcticas(String CoaHorasParcticas) {
        this.CoaHorasParcticas = CoaHorasParcticas;
    }

    public String getCoaTrabajoAutonomo() {
        return CoaTrabajoAutonomo;
    }

    public void setCoaTrabajoAutonomo(String CoaTrabajoAutonomo) {
        this.CoaTrabajoAutonomo = CoaTrabajoAutonomo;
    }

    public String getCcdSeguimientoTutoria() {
        return ccdSeguimientoTutoria;
    }

    public void setCcdSeguimientoTutoria(String ccdSeguimientoTutoria) {
        this.ccdSeguimientoTutoria = ccdSeguimientoTutoria;
    }

    public String getLugarAtencion() {
        return LugarAtencion;
    }

    public void setLugarAtencion(String LugarAtencion) {
        this.LugarAtencion = LugarAtencion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sylabusDocentePK != null ? sylabusDocentePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SylabusDocente)) {
            return false;
        }
        SylabusDocente other = (SylabusDocente) object;
        if ((this.sylabusDocentePK == null && other.sylabusDocentePK != null) || (this.sylabusDocentePK != null && !this.sylabusDocentePK.equals(other.sylabusDocentePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SylabusDocente{" + "sylabusDocentePK=" + sylabusDocentePK + ", numeroClases=" + numeroClases + ", numeroCreditos=" + numeroCreditos + ", modalidad=" + modalidad + ", horario=" + horario + ", descripcionMateria=" + descripcionMateria + ", objetivoGeneral=" + objetivoGeneral + ", objetivoEspecifico=" + objetivoEspecifico + ", procesoDocente=" + procesoDocente + ", evaluacion=" + evaluacion + ", bibliografia=" + bibliografia + ", observaciones=" + observaciones + ", estadoSylabus=" + estadoSylabus + ", estadoEnvio=" + estadoEnvio + ", aprobadoPor=" + aprobadoPor + ", fechaAprobacion=" + fechaAprobacion + ", fechaCrea=" + fechaCrea + ", fechaUltmodific=" + fechaUltmodific + ", usuarioCrea=" + usuarioCrea + ", usuarioUltmodific=" + usuarioUltmodific + ", observacionCoordinador=" + observacionCoordinador + '}';
    }

}
