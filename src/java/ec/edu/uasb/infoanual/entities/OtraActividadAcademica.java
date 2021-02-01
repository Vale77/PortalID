/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.entities;

import ec.edu.uasb.entities.Facultad;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author johana.orozco
 */
@Entity
@Table(name = "OTRA_ACTIVIDAD_ACADEMICA")
@NamedQueries({
    @NamedQuery(name = "OtraActividadAcademica.findAll", query = "SELECT o FROM OtraActividadAcademica o")})
public class OtraActividadAcademica implements Serializable {

    @Size(max = 3)
    @Column(name = "PAIS_INVEST")
    private String paisInvest;
    @Column(name = "CIUDAD_INVEST")
    private Long ciudadInvest;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OtraActividadAcademicaPK otraActividadAcademicaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FINICIO_ACTIVIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finicioActividad;
    @Column(name = "FFIN_ACTIVIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ffinActividad;
    @Column(name = "TIPO_ACTIVIDAD")
    private Long tipoActividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE_ACTIVIDAD")
    private String nombreActividad;
    @Size(max = 200)
    @Column(name = "INSTITUCION_ACTIVIDAD")
    private String institucionActividad;
    @Size(max = 200)
    @Column(name = "TITULO_ACTIVIDAD")
    private String tituloActividad;
    @Size(max = 100)
    @Column(name = "EMAIL_ACTIVIDAD")
    private String emailActividad;
    @Column(name = "DURACION_ACTIVIDAD")
    private Integer duracionActividad;
    @Column(name = "SEDE_INST_ACTIVIDAD")
    private Character sedeInstActividad;
    @Column(name = "UASB_ACTIVIDAD")
    private Character uasbActividad;
    @Size(max = 200)
    @Column(name = "OBS_ACTIVIDAD")
    private String obsActividad;
    @Column(name = "NUM1_ACTIVIDAD")
    private Integer num1Actividad;
    @Column(name = "NUM2_ACTIVIDAD")
    private Integer num2Actividad;
    @Column(name = "TIPO2_ACTIVIDAD")
    private Character tipo2Actividad;
    @Column(name = "TIPO3_ACTIVIDAD")
    private Character tipo3Actividad;
    @Column(name = "TIPO4_ACTIVIDAD")
    private Character tipo4Actividad;
    @Column(name = "TIPO5_ACTIVIDAD")
    private Character tipo5Actividad;
    @Column(name = "TIPO6_ACTIVIDAD")
    private Character tipo6Actividad;
    @Column(name = "TIPO7_ACTIVIDAD")
    private Character tipo7Actividad;
    @Column(name = "ESTADO_ACTIVIDAD")
    private Character estadoActividad;
    @Size(max = 15)
    @Column(name = "TIPO_INSTITUCION")
    private String tipoInstitucion;
    @Size(max = 50)
    @Column(name = "ORIGEN_PARTICIPACION")
    private String origenParticipacion;
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
    @Size(max = 200)
    @Column(name = "PROGRAMA_ACTIVIDAD")
    private String programaActividad;
    @JoinColumn(name = "CODIGO_FACULTAD", referencedColumnName = "CODIGO_FACULTAD")
    @ManyToOne
    private Facultad facultad;
    @JoinColumn(name = "CODIGO_PROFESOR", referencedColumnName = "CODIGO_PROFESOR", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profesor profesor;
    @JoinColumn(name = "AVC_CODIGO", referencedColumnName = "AVC_CODIGO")
    @ManyToOne(optional = false)
    private AreaVincolectividad areaVinculacion;
    @JoinColumn(name = "DAVC_CODIGO", referencedColumnName = "DAVC_CODIGO")
    @ManyToOne(optional = false)
    private DetalleVincolectividad detalleVinculacion;
    @Column(name = "HORAS_DICTADAS")
    private Long horasDictadas;
    @Column(name = "ALCANCE_ACTIVIDAD")
    private Long alcanceActividad;
    @Transient
    private String nomPas;
    @Transient
    private String nomCiudad;
    @Transient
    private String nomRol;
    @Transient
    private String nomEstproyecto;
    @Transient
    private String nomAuspicio;
    @Transient
    private String desLinEstrategica;
    @Transient
    private String desTipo;
    @Transient
    private String desInforme;

    public String getnomtipo() {
        String variable = "";
        switch (Integer.parseInt(this.tipoActividad.toString())) {
            case 1:
                variable = "Pasantía";
                break;
            case 2:
                variable = "Doctorado";
                break;
            case 3:
                variable = "Posdoctorado";
                break;
            case 4:
                variable = "Posgrado";
                break;
        }

        return variable;
    }

    public String getnomrolcotext() {
        String variable = "";
        if (this.tipo2Actividad != null) {
            if (this.tipo2Actividad.toString().equalsIgnoreCase("TU") || this.tipo2Actividad.toString().equalsIgnoreCase("SM") || this.tipo2Actividad.toString().equalsIgnoreCase("T")) {
                variable = "Tutor";
            }
            if (this.tipo2Actividad.toString().equalsIgnoreCase("TR") || this.tipo2Actividad.toString().equalsIgnoreCase("R")) {
                variable = "Tribunal";
            }
            if (this.tipo2Actividad.toString().equalsIgnoreCase("CT") || this.tipo2Actividad.toString().equalsIgnoreCase("C")) {
                variable = "Cotutor";
            }
            if (this.tipo2Actividad.toString().equalsIgnoreCase("LT") || this.tipo2Actividad.toString().equalsIgnoreCase("SL")) {
                variable = "Lector Tesis";
            }

        } else {
            variable = "n/d";
        }
        return variable;
    }

    public String getnomtipoeducon() {
        String variable = "";
        if (tipoActividad != null) {
            switch (Integer.parseInt(this.tipoActividad.toString())) {
                case 1:
                    variable = "Curso de formación y Capacitación";
                    break;
                case 2:
                    variable = "Taller permanente";
                    break;
                case 3:
                    variable = "Curso Capacitación Docente";
                    break;
                case 4:
                    variable = "Curso Avanzado";
                    break;
            }
        }

        return variable;
    }

    public String getnomtipinsteducon() {
        String variable = "";
        if (sedeInstActividad != null) {
            switch (this.sedeInstActividad) {
                case 'N':
                    variable = "Nacional";
                    break;
                case 'I':
                    variable = "Internacional";
                    break;
                case 'E':
                    variable = "Estado";
                    break;
                case 'C':
                    variable = "Organismo Internacional";
                    break;
                case 'O':
                    variable = "ONG";
                    break;
                case 'M':
                    variable = "Empresa privada";
                    break;
                case 'R':
                    variable = "Organización social";
                    break;
                case 'U':
                    variable = "Universidad";
                    break;
                case 'T':
                    variable = "Otra instancia académica";
                    break;

            }
        }
        return variable;
    }

    public String getnomtipactactevuasb() {
        String variable = "";
        if (tipoActividad != null) {
            switch (Integer.parseInt(this.tipoActividad.toString())) {
                case 5:
                    variable = "Seminario";
                    break;
                case 6:
                    variable = "Congreso";
                    break;
                case 7:
                    variable = "Simposio";
                    break;
                case 8:
                    variable = "Conferencia";
                    break;
                case 9:
                    variable = "Encuentro";
                    break;
                case 10:
                    variable = "Conversatorio";
                    break;
                case 11:
                    variable = "Coloquio";
                    break;
                case 12:
                    variable = "Mesa Redonda";
                    break;
                case 13:
                    variable = "Foro";
                    break;
                case 14:
                    variable = "Taller específico";
                    break;
                case 15:
                    variable = "Curso";
                    break;
                case 21:
                    variable = "Grupo de discusión";
                    break;
                case 22:
                    variable = "Panel";
                    break;    
                default:
                    break;
            }
        }

        return variable;
    }

    public String getnomtippartacteven() {
        String variable = "";
        if (this.uasbActividad != null) {
            switch (this.uasbActividad) {
                case 'P':
                    variable = "Ponencia Escrita";
                    break;
                case 'S':
                    variable = "Sin Ponencia";
                    break;
                case 'O':
                    variable = "Organizador";
                    break;
            }
        }
        return variable;
    }

    public String getnomorigenacteven() {
        String variable = "";
        if (this.origenParticipacion != null) {
            if (this.origenParticipacion.equalsIgnoreCase("convenioUASB")) {
                variable = "Convenio con UASB";
            }
            if (this.origenParticipacion.equalsIgnoreCase("cuentaPropia")) {
                variable = "Cuenta propia";
            }

        }
        return variable;
    }

    public String getnomlintrabpertorg() {
        String variable = "";
        if (sedeInstActividad != null) {
            switch (this.sedeInstActividad) {
                case 'D':
                    variable = "Docencia";
                    break;
                case 'I':
                    variable = "Investigación";
                    break;
                case 'V':
                    variable = "Vinculación colectividad";
                    break;
            }
        }
        return variable;
    }

    public String getnompartpertorg() {
        String variable = "";
        if (this.uasbActividad != null) {
            switch (this.uasbActividad) {
                case 'D':
                    variable = "Directiva";
                    break;
                case 'M':
                    variable = "Miembro";
                    break;

            }
        }
        return variable;
    }

    public String getnomtiporgpertorg() {
        String variable = "";
        if (tipoActividad != null) {
            switch (Integer.parseInt(this.tipoActividad.toString())) {
                case 1:
                    variable = "Universitaria";
                    break;
                case 2:
                    variable = "ONG";
                    break;
                case 3:
                    variable = "Nacional";
                    break;
                case 4:
                    variable = "Internacional";
                    break;
                case 5:
                    variable = "Estado";
                    break;
                case 6:
                    variable = "Organismo Internacional";
                    break;
                case 7:
                    variable = "ONG";
                    break;
                case 8:
                    variable = "Empresa privada";
                    break;
                case 9:
                    variable = "Organización social";
                    break;
                case 10:
                    variable = "Universidad";
                    break;
                case 11:
                    variable = "Otra instancia académica";
                    break;
                case -1:
                    variable = "Otros (indique)";
                    break;
            }
        }
        return variable;
    }

    public String getnomfuncion() {
        String variable = "";
        switch (Integer.parseInt(this.tipoActividad.toString())) {
            case 1:
                variable = "Autoridad institucional";
                break;
            case 2:
                variable = "Con licencia para función pública";
                break;
            case 3:
                variable = "Coordinador de actividades de educación continúa";
                break;
            case 4:
                variable = "Director académico de doctorado";
                break;
            case 5:
                variable = "Coordinador de maestría o especialización superior";
                break;
            case 6:
                variable = "Delegado institucional";
                break;
            case 7:
                variable = "Director de área académica";
                break;
            case 8:
                variable = "Editor de la revista institucional";
                break;
            case 9:
                variable = "Integrantes de directiva gremial";
                break;
            case 10:
                variable = "Miembros de Comité, comisión o grupo de trabajo";
                break;
            case 11:
                variable = "Miembros de Comité Editorial de una revista institucional";
                break;
            case 12:
                variable = "Rector";
                break;
            case 13:
                variable = "Vicerrector";
                break;
            case 14:
                variable = "Director General Académico";
                break;
            case 15:
                variable = "Director de área";
                break;
            case 16:
                variable = "Coordinador de investigaciones";
                break;
            case 17:
                variable = "Coordinador del Comité de Vinculación con la Colectividad";
                break;
            case 18:
                variable = "Coordinador del PADH";
                break;
            case 19:
                variable = "Comité de Coordinación Académica";
                break;
            case 20:
                variable = "Otro";
                break;
            case 21:
                variable = "Consejo Superior                                                                                                            ";
                break;
        }

        return variable;
    }
    
    public String getnomcoordinacion() {
        String variable = "";
        switch (Integer.parseInt(this.tipoActividad.toString())) {
            case 1:
                variable = "Doctorado";
                break;
            case 2:
                variable = "Maestría";
                break;
            case 3:
                variable = "Especialización Superior";
                break;
            case 4:
                variable = "Cátedra";
                break;
            case 5:
                variable = "Observatorio Permanente";
                break;
            case 6:
                variable = "Taller Permanente";
                break;
            case 7:
                variable = "Coordinador de Curso Avanzado";
                break;
            case 8:
                variable = "Coordinador de Curso Abierto";
                break;
            case 9:
                variable = "Coordinador de Curso de Capacitación y Actualización";
                break;
            case 10:
                variable = "Director de Revista Indexada";
                break;
            case 11:
                variable = "Director de Revista no Indexada";
                break;
            case 12:
                variable = "Coordinador de Número de Monográfico de Revista Indexada";
                break;
        }
        return variable;
    }
    
    public String getnomcomiteinstitucional() {
        String variable = "";
        switch (Integer.parseInt(this.tipoActividad.toString())) {
            case 1:
                variable = "Escalafón";
                break;
            case 2:
                variable = "Licencias";
                break;
            case 3:
                variable = "Docencia";
                break;
            case 4:
                variable = "Publicaciones";
                break;
            case 5:
                variable = "Planificación";
                break;
            case 6:
                variable = "Evaluación Interna";
                break;
            case 7:
                variable = "Investigación";
                break;
            case 8:
                variable = "Vinculación";
                break;
            case 9:
                variable = "Informática";
                break;
            case 10:
                variable = "Normas";
                break;
            case 11:
                variable = "Comité de Bienes";
                break;
            case 12:
                variable = "Comité de Ayuda Financiera";
                break;
            case 13:
                variable = "Junta de Licitaciones";
                break;
            case 14:
                variable = "Fondo Construir";
                break;
            case 15:
                variable = "Comité de Promoción";
                break;
            case 16:
                variable = "Comité de Admisión";
                break;
            case 17:
                variable = "Comité del Fondo de Jubilación";
                break;
            case 18:
                variable = "Comité Editorial";
                break;     
        }
        return variable;
    }
    
    public String getnomcomitetribunal() {
        String variable = "";
        switch (Integer.parseInt(this.tipoActividad.toString())) {
            case 1:
                variable = "Comité de Posgrado";
                break;
            case 2:
                variable = "Tribunal de Concurso Para Docentes";
                break;
            case 3:
                variable = "Otro (Especifíque)";
                break;
        }
        return variable;
    }
    
    public String getnomprogposgrado() {
        String variable = "";
        switch (Integer.parseInt(this.tipoActividad.toString())) {
            case 1:
                variable = "Doctorado";
                break;
            case 2:
                variable = "Maestria de Investigación";
                break;
            case 3:
                variable = "Maestria Profesional";
                break;
            case 4:
                variable = "Especialización Superior";
                break;
        }
        return variable;
    }
    
    public String getnomprogeducont() {
        String variable = "";
        switch (Integer.parseInt(this.tipoActividad.toString())) {
            case 1:
                variable = "Curso Avanzado";
                break;
            case 2:
                variable = "Curso Abierto";
                break;
            case 3:
                variable = "Curso de Capacitación y Actualización";
                break;
            case 4:
                variable = "Taller Permanente";
                break;
        }
        return variable;
    }
    
    public String getnomprogactvinc() {
        String variable = "";
        if(this.tipoActividad != null) {
            switch (Integer.parseInt(this.tipoActividad.toString())) {
                case 1:
                    variable = "Seminario";
                    break;
                case 2:
                    variable = "Congreso";
                    break;
                case 3:
                    variable = "Simposio Conferencia";
                    break;
                case 4:
                    variable = "Encuentro";
                    break;
                case 5:
                    variable = "Conversatorio";
                    break;
                case 6:
                    variable = "Coloquio";
                    break;
                case 7:
                    variable = "Taller";
                    break;
                case 8:
                    variable = "Mesa Redonda";
                    break;
                case 9:
                    variable = "Foro";
                    break;
                case 10:
                    variable = "Grupo de Discusión";
                    break;
                case 11:
                    variable = "Panel";
                    break;
            }
        }
        return variable;
    }
    
    public String getnomestadoprogpos() {
        String variable = "";
        switch (Integer.parseInt(this.tipo2Actividad.toString())) {
            case 1:
                variable = "En Proceso";
                break;
            case 2:
                variable = "Aprobado CCA";
                break;
            case 3:
                variable = "Aprobado CES";
                break;
        }
        return variable;
    }

    public String getnomtipactperfdoc() {
        String variable = "";
        switch (Integer.parseInt(this.tipoActividad.toString())) {
            case 1:
                variable = "Proyectos de posgrado";
                break;
            case 2:
                variable = "Realización de tesis";
                break;
            case 3:
                variable = "Curso de perfeccionamiento docente";
                break;
            case 4:
                variable = "Actividad de actualización docente";
                break;
            case 5:
                variable = "Programa Doctorado";
                break;
            case 6:
                variable = "Programa Maestría";
                break;
            case -1:
                variable = "Otra (especifique)";
                break;
        }

        return variable;
    }

    public String geteduccontnomrol() {
        String variable = "";
        if (this.tipo7Actividad != null) {
            switch (this.tipo7Actividad) {
                case 'C':
                    variable = "Coordinador";
                    break;
                case 'D':
                    variable = "Docente";
                    break;
                case 'O':
                    variable = "Organizador";
                    break;
                case 'E':
                    variable = "Expositor";
                    break;
                case 'M':
                    variable = "Moderador";
                    break;
                case 'I':
                    variable = "Directivo";
                    break;
                case 'B':
                    variable = "Miembro";
                case 'R':
                    variable = "Con Certificado";
                    break;
            }
        }
        return variable;
    }
 public String getperfdocestado() {
        String variable = "";
        if (this.tipo2Actividad != null) {
            switch (this.tipo2Actividad) {
                case 'C':
                    variable = "Concluido";
                    break;
                case 'E':
                    variable = "Ejecución";
                    break;
                default:
                    break;
            }
        }
        return variable;
    }
 
    public String getDescricionAlcance(){
        String desAlcance = "";
        if(this.alcanceActividad != null){
            switch(this.alcanceActividad.intValue()){
                case 1:
                    desAlcance = "NACIONAL";
                    break;
                case 2:
                    desAlcance = "INTERNACIONAL";
                    break;
                default:
                    break;
            }
        }
        return desAlcance;
    }
    
    public String getDesOrigenParticipacion(){
        String desOrigenParticipacion = "";
        if(this.num1Actividad != null){
            switch(this.num1Actividad){
                case 1:
                    desOrigenParticipacion = "Cuenta Propia";
                    break;
                case 2:
                    desOrigenParticipacion = "Origen UASB";
                    break;
            }
        }
        return desOrigenParticipacion;
    }
    
    public String getDesOrigenParticipacionTexto(){
        String desOrigenParticipacion = "";
        if(this.origenParticipacion != null){
            if(this.origenParticipacion.equalsIgnoreCase("convenioUASB")){
                desOrigenParticipacion = "CONVENIO UASB";
            }else{
                if(this.origenParticipacion.equalsIgnoreCase("cuentaPropia")){
                    desOrigenParticipacion = "CUENTA PROPIA";
                }
            }
        }
        return desOrigenParticipacion;
    }
 
    public OtraActividadAcademica() {
    }

    public OtraActividadAcademica(OtraActividadAcademicaPK otraActividadAcademicaPK) {
        this.otraActividadAcademicaPK = otraActividadAcademicaPK;
    }

    public OtraActividadAcademica(OtraActividadAcademicaPK otraActividadAcademicaPK, Date finicioActividad, String nombreActividad, String usuarioCrea, String usuarioUltmodific, Date fechaCrea, Date fechaUltmodific) {
        this.otraActividadAcademicaPK = otraActividadAcademicaPK;
        this.finicioActividad = finicioActividad;
        this.nombreActividad = nombreActividad;
        this.usuarioCrea = usuarioCrea;
        this.usuarioUltmodific = usuarioUltmodific;
        this.fechaCrea = fechaCrea;
        this.fechaUltmodific = fechaUltmodific;
    }

    public OtraActividadAcademica(long codigoActividad, long codigoProfesor, char tipoOtraActividad) {
        this.otraActividadAcademicaPK = new OtraActividadAcademicaPK(codigoActividad, codigoProfesor, tipoOtraActividad);
    }

    public OtraActividadAcademicaPK getOtraActividadAcademicaPK() {
        return otraActividadAcademicaPK;
    }

    public void setOtraActividadAcademicaPK(OtraActividadAcademicaPK otraActividadAcademicaPK) {
        this.otraActividadAcademicaPK = otraActividadAcademicaPK;
    }

    public String getProgramaActividad() {
        return programaActividad;
    }

    public void setProgramaActividad(String programaActividad) {
        this.programaActividad = programaActividad;
    }

    public Date getFinicioActividad() {
        return finicioActividad;
    }

    public void setFinicioActividad(Date finicioActividad) {
        this.finicioActividad = finicioActividad;
    }

    public Date getFfinActividad() {
        return ffinActividad;
    }

    public void setFfinActividad(Date ffinActividad) {
        this.ffinActividad = ffinActividad;
    }

    public Long getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(Long tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getInstitucionActividad() {
        return institucionActividad;
    }

    public void setInstitucionActividad(String institucionActividad) {
        this.institucionActividad = institucionActividad;
    }

    public String getTituloActividad() {
        return tituloActividad;
    }

    public void setTituloActividad(String tituloActividad) {
        this.tituloActividad = tituloActividad;
    }

    public String getEmailActividad() {
        return emailActividad;
    }

    public void setEmailActividad(String emailActividad) {
        this.emailActividad = emailActividad;
    }

    public Integer getDuracionActividad() {
        return duracionActividad;
    }

    public void setDuracionActividad(Integer duracionActividad) {
        this.duracionActividad = duracionActividad;
    }

    public Character getSedeInstActividad() {
        return sedeInstActividad;
    }

    public void setSedeInstActividad(Character sedeInstActividad) {
        this.sedeInstActividad = sedeInstActividad;
    }

    public Character getUasbActividad() {
        return uasbActividad;
    }

    public void setUasbActividad(Character uasbActividad) {
        this.uasbActividad = uasbActividad;
    }

    public String getObsActividad() {
        return obsActividad;
    }

    public void setObsActividad(String obsActividad) {
        this.obsActividad = obsActividad;
    }

    public Integer getNum1Actividad() {
        return num1Actividad;
    }

    public void setNum1Actividad(Integer num1Actividad) {
        this.num1Actividad = num1Actividad;
    }

    public Integer getNum2Actividad() {
        return num2Actividad;
    }

    public void setNum2Actividad(Integer num2Actividad) {
        this.num2Actividad = num2Actividad;
    }

    public Character getTipo2Actividad() {
        return tipo2Actividad;
    }

    public void setTipo2Actividad(Character tipo2Actividad) {
        this.tipo2Actividad = tipo2Actividad;
    }

    public Character getTipo3Actividad() {
        return tipo3Actividad;
    }

    public void setTipo3Actividad(Character tipo3Actividad) {
        this.tipo3Actividad = tipo3Actividad;
    }

    public Character getTipo4Actividad() {
        return tipo4Actividad;
    }

    public void setTipo4Actividad(Character tipo4Actividad) {
        this.tipo4Actividad = tipo4Actividad;
    }

    public Character getTipo5Actividad() {
        return tipo5Actividad;
    }

    public void setTipo5Actividad(Character tipo5Actividad) {
        this.tipo5Actividad = tipo5Actividad;
    }

    public Character getTipo6Actividad() {
        return tipo6Actividad;
    }

    public void setTipo6Actividad(Character tipo6Actividad) {
        this.tipo6Actividad = tipo6Actividad;
    }

    public Character getTipo7Actividad() {
        return tipo7Actividad;
    }

    public void setTipo7Actividad(Character tipo7Actividad) {
        this.tipo7Actividad = tipo7Actividad;
    }

    public Character getEstadoActividad() {
        return estadoActividad;
    }

    public void setEstadoActividad(Character estadoActividad) {
        this.estadoActividad = estadoActividad;
    }

    public String getTipoInstitucion() {
        return tipoInstitucion;
    }

    public void setTipoInstitucion(String tipoInstitucion) {
        this.tipoInstitucion = tipoInstitucion;
    }

    public String getOrigenParticipacion() {
        return origenParticipacion;
    }

    public void setOrigenParticipacion(String origenParticipacion) {
        this.origenParticipacion = origenParticipacion;
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

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (otraActividadAcademicaPK != null ? otraActividadAcademicaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OtraActividadAcademica)) {
            return false;
        }
        OtraActividadAcademica other = (OtraActividadAcademica) object;
        if ((this.otraActividadAcademicaPK == null && other.otraActividadAcademicaPK != null) || (this.otraActividadAcademicaPK != null && !this.otraActividadAcademicaPK.equals(other.otraActividadAcademicaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.infoanual.entities.OtraActividadAcademica[ otraActividadAcademicaPK=" + otraActividadAcademicaPK + " ]";
    }

    public String getPaisInvest() {
        return paisInvest;
    }

    public void setPaisInvest(String paisInvest) {
        this.paisInvest = paisInvest;
    }

    public Long getCiudadInvest() {
        return ciudadInvest;
    }

    public void setCiudadInvest(Long ciudadInvest) {
        this.ciudadInvest = ciudadInvest;
    }

    public String getNomPas() {
        return nomPas;
    }

    public void setNomPas(String nomPas) {
        this.nomPas = nomPas;
    }

    public String getNomCiudad() {
        return nomCiudad;
    }

    public void setNomCiudad(String nomCiudad) {
        this.nomCiudad = nomCiudad;
    }

    public String getNomRol() {
        return nomRol;
    }

    public void setNomRol(String nomRol) {
        this.nomRol = nomRol;
    }

    public String getNomEstproyecto() {
        return nomEstproyecto;
    }

    public void setNomEstproyecto(String nomEstproyecto) {
        this.nomEstproyecto = nomEstproyecto;
    }

    public String getNomAuspicio() {
        return nomAuspicio;
    }

    public void setNomAuspicio(String nomAuspicio) {
        this.nomAuspicio = nomAuspicio;
    }

    public AreaVincolectividad getAreaVinculacion() {
        return areaVinculacion;
    }

    public void setAreaVinculacion(AreaVincolectividad areaVinculacion) {
        this.areaVinculacion = areaVinculacion;
    }

    public DetalleVincolectividad getDetalleVinculacion() {
        return detalleVinculacion;
    }

    public void setDetalleVinculacion(DetalleVincolectividad detalleVinculacion) {
        this.detalleVinculacion = detalleVinculacion;
    }
    
    public Long getHorasDictadas() {
        return horasDictadas;
    }

    public void setHorasDictadas(Long horasDictadas) {
        this.horasDictadas = horasDictadas;
    }
    
    public Long getAlcanceActividad() {
        return alcanceActividad;
    }

    public void setAlcanceActividad(Long alcanceActividad) {
        this.alcanceActividad = alcanceActividad;
    }
    
    public String getDesLinEstrategica() {
        return desLinEstrategica;
    }

    public void setDesLinEstrategica(String desLinEstrategica) {
        this.desLinEstrategica = desLinEstrategica;
    }
    
    public String getDesTipo() {
        return desTipo;
    }

    public void setDesTipo(String desTipo) {
        this.desTipo = desTipo;
    }
    
    public String getDesInforme() {
        return desInforme;
    }

    public void setDesInforme(String desInforme) {
        this.desInforme = desInforme;
    }
}
