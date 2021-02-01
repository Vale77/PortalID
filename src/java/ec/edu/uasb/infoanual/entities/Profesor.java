/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.entities;

import ec.edu.uasb.entities.Apelativo;
import ec.edu.uasb.entities.Facultad;
import ec.edu.uasb.entities.Nacionalidad;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "PROFESOR")
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p")})
public class Profesor implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_PROFESOR")
    private Long codigoProfesor;
    @Column(name = "CAMPO_PROFESOR")
    private Long campoProfesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CED_PAS_PROFESOR")
    private String cedPasProfesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_PROFESOR")
    private String nombreProfesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "APELLIDO_PROFESOR")
    private String apellidoProfesor;
    @Column(name = "FECHA_NAC_PROFESOR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacProfesor;
    @Size(max = 30)
    @Column(name = "TELEFONO_PROFESOR")
    private String telefonoProfesor;
    @Column(name = "ESTADO_PROFESOR")
    private Character estadoProfesor;
    @Column(name = "FECHA_INICIO_CONTRATO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicioContrato;
    @Column(name = "FECHA_FIN_CONTRATO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinContrato;
    @Size(max = 100)
    @Column(name = "COMENTARIO")
    private String comentario;
    @Size(max = 200)
    @Column(name = "TRABAJO_PROFESOR")
    private String trabajoProfesor;
    @Size(max = 200)
    @Column(name = "DIRTRAB_PROFESOR")
    private String dirtrabProfesor;
    @Size(max = 200)
    @Column(name = "DIRDOM_PROFESOR")
    private String dirdomProfesor;
    @Size(max = 100)
    @Column(name = "TELFDOM_PROFESOR")
    private String telfdomProfesor;
    @Size(max = 3)
    @Column(name = "PAIS_DOM_PROFESOR")
    private String paisDomProfesor;
    @Column(name = "CIUDAD_DOM_PROFESOR")
    private Long ciudadDomProfesor;
    @Size(max = 30)
    @Column(name = "CASILLA_PROFESOR")
    private String casillaProfesor;
    @Size(max = 100)
    @Column(name = "EMAIL_PROFESOR")
    private String emailProfesor;
    @Size(max = 100)
    @Column(name = "EMAILSEC_PROFESOR")
    private String emailsecProfesor;
    @Column(name = "SEXO_PROFESOR")
    private Character sexoProfesor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTCIVIL_PROFESOR")
    private char estcivilProfesor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECINGR_PROFESOR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecingrProfesor;
    @Size(max = 30)
    @Column(name = "LOGIN_PROFESOR")
    private String loginProfesor;
    @Lob
    @Column(name = "CLAVE_PROFESOR")
    private byte[] claveProfesor;
    @Column(name = "DEDICACION_PROFESOR")
    private Character dedicacionProfesor;
    @Size(max = 30)
    @Column(name = "USUARIO_CREA")
    private String usuarioCrea;
    @Size(max = 30)
    @Column(name = "USUARIO_ULTMODIFIC")
    private String usuarioUltmodific;
    @Column(name = "FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCrea;
    @Column(name = "FECHA_ULTMODIFIC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltmodific;
    @Column(name = "ENVCORR_PROFESOR")
    private Character envcorrProfesor;
    @Size(max = 3)
    @Column(name = "PAIS_TRAB_PROFESOR")
    private String paisTrabProfesor;
    @Column(name = "CIUDAD_TRAB_PROFESOR")
    private Long ciudadTrabProfesor;
    @Size(max = 30)
    @Column(name = "RUC_PROFESOR")
    private String rucProfesor;
    @Size(max = 30)
    @Column(name = "CELULAR_PROFESOR")
    private String celularProfesor;
    @Size(max = 100)
    @Column(name = "CARGO_PROFESOR")
    private String cargoProfesor;
    @Column(name = "TIPO_CED_PAS")
    private Character tipoCedPas;
    @Column(name = "CODIGO_BANCO")
    private Long codigoBanco;
    @Column(name = "TIPO_CUENTA")
    private Character tipoCuenta;
    @Size(max = 20)
    @Column(name = "NUMERO_CUENTA")
    private String numeroCuenta;
    @Size(max = 30)
    @Column(name = "CODIGO_PROVINCIA")
    private String codigoProvincia;
    @Size(max = 30)
    @Column(name = "CODIGO_CANTON")
    private String codigoCanton;
    @Size(max = 30)
    @Column(name = "CODIGO_PARROQUIA")
    private String codigoParroquia;
    @Size(max = 3)
    @Column(name = "COD_PAIS_ORIGEN")
    private String codPaisOrigen;
    @Column(name = "COD_CIUDAD_ORIGEN")
    private Long codCiudadOrigen;
    @Size(max = 200)
    @Column(name = "IMAGEN")
    private String imagen;
    @Column(name = "CAMBIO_CLAVE")
    private Character cambioClave;
    @Size(max = 20)
    @Column(name = "NR_MEMO")
    private String nrMemo;
    @Column(name = "IMPRESION_CARNET")
    private Character impresionCarnet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesor")
    private List<ConsulExternDocente> consulExternDocenteList;
    @JoinColumn(name = "CODIGO_NACIONALIDAD", referencedColumnName = "CODIGO_NACIONALIDAD")
    @ManyToOne(optional = false)
    private Nacionalidad nacionalidad;
    @JoinColumn(name = "CODIGO_FACULTAD", referencedColumnName = "CODIGO_FACULTAD")
    @ManyToOne
    private Facultad facultad;
    @JoinColumn(name = "CODIGO_CATEGORIA", referencedColumnName = "CODIGO_CATEGORIA")
    @ManyToOne(optional = false)
    private CategoriaProfesor categoriaProfesor;
    @JoinColumn(name = "CODIGO_APELATIVO", referencedColumnName = "CODIGO_APELATIVO")
    @ManyToOne
    private Apelativo apelativo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesor")
    private List<TituloProfesor> tituloProfesorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesor")
    private List<ExamComplexivo> examComplexivoList;

    public Profesor() {
    }

    public Profesor(Long codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public Profesor(Long codigoProfesor, String cedPasProfesor, String nombreProfesor, String apellidoProfesor, char estcivilProfesor, Date fecingrProfesor) {
        this.codigoProfesor = codigoProfesor;
        this.cedPasProfesor = cedPasProfesor;
        this.nombreProfesor = nombreProfesor;
        this.apellidoProfesor = apellidoProfesor;
        this.estcivilProfesor = estcivilProfesor;
        this.fecingrProfesor = fecingrProfesor;
    }

    public Long getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(Long codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public Long getCampoProfesor() {
        return campoProfesor;
    }

    public void setCampoProfesor(Long campoProfesor) {
        this.campoProfesor = campoProfesor;
    }

    public String getCedPasProfesor() {
        return cedPasProfesor;
    }

    public void setCedPasProfesor(String cedPasProfesor) {
        this.cedPasProfesor = cedPasProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getApellidoProfesor() {
        return apellidoProfesor;
    }

    public void setApellidoProfesor(String apellidoProfesor) {
        this.apellidoProfesor = apellidoProfesor;
    }

    public Date getFechaNacProfesor() {
        return fechaNacProfesor;
    }

    public void setFechaNacProfesor(Date fechaNacProfesor) {
        this.fechaNacProfesor = fechaNacProfesor;
    }

    public String getTelefonoProfesor() {
        return telefonoProfesor;
    }

    public void setTelefonoProfesor(String telefonoProfesor) {
        this.telefonoProfesor = telefonoProfesor;
    }

    public Character getEstadoProfesor() {
        return estadoProfesor;
    }

    public void setEstadoProfesor(Character estadoProfesor) {
        this.estadoProfesor = estadoProfesor;
    }

    public Date getFechaInicioContrato() {
        return fechaInicioContrato;
    }

    public void setFechaInicioContrato(Date fechaInicioContrato) {
        this.fechaInicioContrato = fechaInicioContrato;
    }

    public Date getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(Date fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getTrabajoProfesor() {
        return trabajoProfesor;
    }

    public void setTrabajoProfesor(String trabajoProfesor) {
        this.trabajoProfesor = trabajoProfesor;
    }

    public String getDirtrabProfesor() {
        return dirtrabProfesor;
    }

    public void setDirtrabProfesor(String dirtrabProfesor) {
        this.dirtrabProfesor = dirtrabProfesor;
    }

    public String getDirdomProfesor() {
        return dirdomProfesor;
    }

    public void setDirdomProfesor(String dirdomProfesor) {
        this.dirdomProfesor = dirdomProfesor;
    }

    public String getTelfdomProfesor() {
        return telfdomProfesor;
    }

    public void setTelfdomProfesor(String telfdomProfesor) {
        this.telfdomProfesor = telfdomProfesor;
    }

    public String getPaisDomProfesor() {
        return paisDomProfesor;
    }

    public void setPaisDomProfesor(String paisDomProfesor) {
        this.paisDomProfesor = paisDomProfesor;
    }

    public Long getCiudadDomProfesor() {
        return ciudadDomProfesor;
    }

    public void setCiudadDomProfesor(Long ciudadDomProfesor) {
        this.ciudadDomProfesor = ciudadDomProfesor;
    }

    public String getCasillaProfesor() {
        return casillaProfesor;
    }

    public void setCasillaProfesor(String casillaProfesor) {
        this.casillaProfesor = casillaProfesor;
    }

    public String getEmailProfesor() {
        return emailProfesor;
    }

    public void setEmailProfesor(String emailProfesor) {
        this.emailProfesor = emailProfesor;
    }

    public String getEmailsecProfesor() {
        return emailsecProfesor;
    }

    public void setEmailsecProfesor(String emailsecProfesor) {
        this.emailsecProfesor = emailsecProfesor;
    }

    public Character getSexoProfesor() {
        return sexoProfesor;
    }

    public void setSexoProfesor(Character sexoProfesor) {
        this.sexoProfesor = sexoProfesor;
    }

    public char getEstcivilProfesor() {
        return estcivilProfesor;
    }

    public void setEstcivilProfesor(char estcivilProfesor) {
        this.estcivilProfesor = estcivilProfesor;
    }

    public Date getFecingrProfesor() {
        return fecingrProfesor;
    }

    public void setFecingrProfesor(Date fecingrProfesor) {
        this.fecingrProfesor = fecingrProfesor;
    }

    public String getLoginProfesor() {
        return loginProfesor;
    }

    public void setLoginProfesor(String loginProfesor) {
        this.loginProfesor = loginProfesor;
    }

    public byte[] getClaveProfesor() {
        return claveProfesor;
    }

    public void setClaveProfesor(byte[] claveProfesor) {
        this.claveProfesor = claveProfesor;
    }

    public Character getDedicacionProfesor() {
        return dedicacionProfesor;
    }

    public void setDedicacionProfesor(Character dedicacionProfesor) {
        this.dedicacionProfesor = dedicacionProfesor;
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

    public Character getEnvcorrProfesor() {
        return envcorrProfesor;
    }

    public void setEnvcorrProfesor(Character envcorrProfesor) {
        this.envcorrProfesor = envcorrProfesor;
    }

    public String getPaisTrabProfesor() {
        return paisTrabProfesor;
    }

    public void setPaisTrabProfesor(String paisTrabProfesor) {
        this.paisTrabProfesor = paisTrabProfesor;
    }

    public Long getCiudadTrabProfesor() {
        return ciudadTrabProfesor;
    }

    public void setCiudadTrabProfesor(Long ciudadTrabProfesor) {
        this.ciudadTrabProfesor = ciudadTrabProfesor;
    }

    public String getRucProfesor() {
        return rucProfesor;
    }

    public void setRucProfesor(String rucProfesor) {
        this.rucProfesor = rucProfesor;
    }

    public String getCelularProfesor() {
        return celularProfesor;
    }

    public void setCelularProfesor(String celularProfesor) {
        this.celularProfesor = celularProfesor;
    }

    public String getCargoProfesor() {
        return cargoProfesor;
    }

    public void setCargoProfesor(String cargoProfesor) {
        this.cargoProfesor = cargoProfesor;
    }

    public Character getTipoCedPas() {
        return tipoCedPas;
    }

    public void setTipoCedPas(Character tipoCedPas) {
        this.tipoCedPas = tipoCedPas;
    }

    public Long getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(Long codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public Character getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(Character tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public String getCodigoCanton() {
        return codigoCanton;
    }

    public void setCodigoCanton(String codigoCanton) {
        this.codigoCanton = codigoCanton;
    }

    public String getCodigoParroquia() {
        return codigoParroquia;
    }

    public void setCodigoParroquia(String codigoParroquia) {
        this.codigoParroquia = codigoParroquia;
    }

    public String getCodPaisOrigen() {
        return codPaisOrigen;
    }

    public void setCodPaisOrigen(String codPaisOrigen) {
        this.codPaisOrigen = codPaisOrigen;
    }

    public Long getCodCiudadOrigen() {
        return codCiudadOrigen;
    }

    public void setCodCiudadOrigen(Long codCiudadOrigen) {
        this.codCiudadOrigen = codCiudadOrigen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Character getCambioClave() {
        return cambioClave;
    }

    public void setCambioClave(Character cambioClave) {
        this.cambioClave = cambioClave;
    }

    public String getNrMemo() {
        return nrMemo;
    }

    public void setNrMemo(String nrMemo) {
        this.nrMemo = nrMemo;
    }

    public Character getImpresionCarnet() {
        return impresionCarnet;
    }

    public void setImpresionCarnet(Character impresionCarnet) {
        this.impresionCarnet = impresionCarnet;
    }

    public List<ConsulExternDocente> getConsulExternDocenteList() {
        return consulExternDocenteList;
    }

    public void setConsulExternDocenteList(List<ConsulExternDocente> consulExternDocenteList) {
        this.consulExternDocenteList = consulExternDocenteList;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public CategoriaProfesor getCategoriaProfesor() {
        return categoriaProfesor;
    }

    public void setCategoriaProfesor(CategoriaProfesor categoriaProfesor) {
        this.categoriaProfesor = categoriaProfesor;
    }

    public Apelativo getApelativo() {
        return apelativo;
    }

    public void setApelativo(Apelativo apelativo) {
        this.apelativo = apelativo;
    }

    public List<TituloProfesor> getTituloProfesorList() {
        return tituloProfesorList;
    }

    public void setTituloProfesorList(List<TituloProfesor> tituloProfesorList) {
        this.tituloProfesorList = tituloProfesorList;
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
        hash += (codigoProfesor != null ? codigoProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.codigoProfesor == null && other.codigoProfesor != null) || (this.codigoProfesor != null && !this.codigoProfesor.equals(other.codigoProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Profesor{" + "codigoProfesor=" + codigoProfesor + ", campoProfesor=" + campoProfesor + ", cedPasProfesor=" + cedPasProfesor + ", nombreProfesor=" + nombreProfesor + ", apellidoProfesor=" + apellidoProfesor + ", fechaNacProfesor=" + fechaNacProfesor + ", telefonoProfesor=" + telefonoProfesor + ", estadoProfesor=" + estadoProfesor + ", fechaInicioContrato=" + fechaInicioContrato + ", fechaFinContrato=" + fechaFinContrato + ", comentario=" + comentario + ", trabajoProfesor=" + trabajoProfesor + ", dirtrabProfesor=" + dirtrabProfesor + ", dirdomProfesor=" + dirdomProfesor + ", telfdomProfesor=" + telfdomProfesor + ", paisDomProfesor=" + paisDomProfesor + ", ciudadDomProfesor=" + ciudadDomProfesor + ", casillaProfesor=" + casillaProfesor + ", emailProfesor=" + emailProfesor + ", emailsecProfesor=" + emailsecProfesor + ", sexoProfesor=" + sexoProfesor + ", estcivilProfesor=" + estcivilProfesor + ", fecingrProfesor=" + fecingrProfesor + ", loginProfesor=" + loginProfesor + ", claveProfesor=" + claveProfesor + ", dedicacionProfesor=" + dedicacionProfesor + ", usuarioCrea=" + usuarioCrea + ", usuarioUltmodific=" + usuarioUltmodific + ", fechaCrea=" + fechaCrea + ", fechaUltmodific=" + fechaUltmodific + ", envcorrProfesor=" + envcorrProfesor + ", paisTrabProfesor=" + paisTrabProfesor + ", ciudadTrabProfesor=" + ciudadTrabProfesor + ", rucProfesor=" + rucProfesor + ", celularProfesor=" + celularProfesor + ", cargoProfesor=" + cargoProfesor + ", tipoCedPas=" + tipoCedPas + ", codigoBanco=" + codigoBanco + ", tipoCuenta=" + tipoCuenta + ", numeroCuenta=" + numeroCuenta + ", codigoProvincia=" + codigoProvincia + ", codigoCanton=" + codigoCanton + ", codigoParroquia=" + codigoParroquia + ", codPaisOrigen=" + codPaisOrigen + ", codCiudadOrigen=" + codCiudadOrigen + ", imagen=" + imagen + ", cambioClave=" + cambioClave + ", nrMemo=" + nrMemo + ", impresionCarnet=" + impresionCarnet + ", consulExternDocenteList=" + consulExternDocenteList + ", nacionalidad=" + nacionalidad + ", facultad=" + facultad + ", categoriaProfesor=" + categoriaProfesor + ", apelativo=" + apelativo + ", tituloProfesorList=" + tituloProfesorList + ", examComplexivoList=" + examComplexivoList + '}';
    }

    @Override
    public Profesor clone() {
        Profesor obj = null;
        try {
            obj = (Profesor) super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println(" no se puede duplicar Profesor " + ex.getMessage());
        }
        return obj;
    }
}
