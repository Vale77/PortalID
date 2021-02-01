/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author johana.orozco
 */
@Entity
@Table(name = "PUBLICACION_PROFESOR")
@NamedQueries({
    @NamedQuery(name = "PublicacionProfesor.findAll", query = "SELECT p FROM PublicacionProfesor p")})
public class PublicacionProfesor implements Serializable {

    @Size(max = 3)
    @Column(name = "PAIS_AUSPICIO")
    private String paisAuspicio;
    @Column(name = "CIUDAD_AUSPICIO")
    private Long ciudadAuspicio;
    @Size(max = 100)
    @Column(name = "PUB_APELLIDO_AUTOR")
    private String pubApellidoAutor;
    @Size(max = 100)
    @Column(name = "PUB_NOMBRE_AUTOR")
    private String pubNombreAutor;
    @Size(max = 100)
    @Column(name = "PUB_APELLIDO_COAUTOR")
    private String pubApellidoCoautor;
    @Size(max = 100)
    @Column(name = "PUB_NOMBRE_COAUTOR")
    private String pubNombreCoautor;
    @Size(max = 200)
    @Column(name = "PUB_TITULO")
    private String pubTitulo;
    @Size(max = 200)
    @Column(name = "PUB_SUBTITULO")
    private String pubSubtitulo;
    @Size(max = 30)
    @Column(name = "PUB_EDICION")
    private String pubEdicion;
    @Column(name = "PUB_CIUEDITORIAL")
    private Long pubCiueditorial;
    @Size(max = 3)
    @Column(name = "PUB_PAIEDITORIAL")
    private String pubPaieditorial;
    @Size(max = 200)
    @Column(name = "PUB_EDITORIAL")
    private String pubEditorial;
    @Column(name = "PUB_FECEDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pubFecedicion;
    @Size(max = 30)
    @Column(name = "PUB_NUMPAGINAS")
    private String pubNumpaginas;
    @Size(max = 200)
    @Column(name = "PUB_TITREVISTA")
    private String pubTitrevista;
    @Column(name = "PUB_VOLUMEN")
    private Integer pubVolumen;
    @Size(max = 100)
    @Column(name = "PUB_NUMISBN")
    private String pubNumisbn;
    @Size(max = 100)
    @Column(name = "PUB_NUMISSN")
    private String pubNumissn;
    @Size(max = 200)
    @Column(name = "PUB_URL")
    private String pubUrl;
    @Column(name = "PUB_IDIOMA")
    private Integer pubIdioma;
    @Size(max = 500)
    @Column(name = "PUB_NOMBRE_CAPITULO")
    private String pubNombreCapitulo;
    @Column(name = "PUB_PARTICIPACION")
    private Character pubParticipacion;
    @Column(name = "PUB_REVPARES")
    private Character pubRevpares;
    @Column(name = "PUB_ESTADO")
    private Character pubEstado;
    @Column(name = "PUB_BASEREVINDEXADA")
    private Character pubBaserevindexada;
    @Size(max = 200)
    @Column(name = "PUB_NOMOTRABASEINDEX")
    private String pubNomotrabaseindex;
    @Column(name = "PUB_PARTSERIE")
    private Character pubPartserie;
    @Size(max = 200)
    @Column(name = "PUB_ENTIDADSEDE")
    private String pubEntidadsede;
    @Column(name = "PUB_EVENTO")
    private Character pubEvento;
    @Column(name = "PUB_MEDDIFUSION")
    private Character pubMeddifusion;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PublicacionProfesorPK publicacionProfesorPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_PUBLICACION")
    private long tipoPublicacion;
    @Size(max = 500)
    @Column(name = "CAMPO1")
    private String campo1;
    @Size(max = 500)
    @Column(name = "CAMPO2")
    private String campo2;
    @Size(max = 500)
    @Column(name = "CAMPO3")
    private String campo3;
    @Size(max = 500)
    @Column(name = "CAMPO4")
    private String campo4;
    @Size(max = 500)
    @Column(name = "CAMPO5")
    private String campo5;
    @Size(max = 500)
    @Column(name = "CAMPO6")
    private String campo6;
    @Size(max = 500)
    @Column(name = "CAMPO7")
    private String campo7;
    @Size(max = 500)
    @Column(name = "CAMPO8")
    private String campo8;
    @Size(max = 500)
    @Column(name = "CAMPO9")
    private String campo9;
    @Size(max = 500)
    @Column(name = "CAMPO10")
    private String campo10;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FORMA_PUBLICACION")
    private char formaPublicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AUSPICIO_PUBLICACION")
    private char auspicioPublicacion;
    @Size(max = 100)
    @Column(name = "OTRO_AUSPICIO")
    private String otroAuspicio;
    @Size(max = 500)
    @Column(name = "OBSERVACION_PUBLICACION")
    private String observacionPublicacion;
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
    @Column(name = "PUB_TITSERIE")
    private String pubTitserie;
    @Transient
    private String nomCiudad;
    @Transient
    private String nomPais;

    public PublicacionProfesor() {
    }

   public String getdatbiblio() {
        String variable = "";
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        if (this.pubApellidoAutor == null && this.campo1 != null) {
            variable = null;
            switch (Integer.parseInt(String.valueOf(tipoPublicacion))) {
                case 1:
                case 2:
                case 4:
                case 5:
                    variable = (this.campo1 == null ? "" : "AUTOR: " + this.campo1 + " ");
                    break;
                case 3:
                case 6:
                    variable = (this.campo1 == null ? "" : "AUTOR: " + this.campo1 + " ");
                    break;
                default:
                    break;
            }
            switch (Integer.parseInt(String.valueOf(tipoPublicacion))) {
                case 1:
                case 2:
                case 4:
                case 5:
                    variable = variable + (this.campo2 == null ? "" : "TÍTULO: " + this.campo2 + " ");
                    break;
                case 3:

                    variable = variable + (this.campo2 == null ? "" : "CIUDAD: " + this.campo2 + " ");
                    break;
                case 6:
                    variable = variable + (this.campo2 == null ? "" : "AUTOR: " + this.campo2 + " ");
                    break;
                default:
                    break;
            }
            switch (Integer.parseInt(String.valueOf(tipoPublicacion))) {
                case 1:
                case 2:
                    variable = variable + (this.campo3 == null ? "" : "PIE DE IMPRENTA: " + this.campo3 + " ");
                    break;
                case 3:
                    variable = variable + (this.campo3 == null ? "" : "PUBLICACIÓN: " + this.campo3 + " ");
                    break;
                case 4:
                    variable = variable + (this.campo3 == null ? "" : "EN: " + this.campo3 + " ");
                    break;
                case 5:
                    variable = variable + (this.campo3 == null ? "" : "CIUDAD EDITORIAL: " + this.campo3 + " ");
                    break;
                default:
                    break;
            }
            switch (Integer.parseInt(String.valueOf(tipoPublicacion))) {
                case 1:
                case 2:
                    variable = variable + (this.campo4 == null ? "" : "DESCRIPCIÓN FÍSICA: " + this.campo4 + " ");
                    break;
                case 3:
                    variable = variable + (this.campo4 == null ? "" : "COLECCION O SERIE: " + this.campo4 + " ");
                    break;
                case 4:
                    variable = variable + (this.campo4 == null ? "" : "PIE DE IMPRENTA: " + this.campo4 + " ");
                    break;
                case 5:
                case 6:
                    variable = variable + (this.campo4 == null ? "" : "PUBLICACIÓN: " + this.campo4 + " ");
                    break;
                default:
                    break;
            }
             switch (Integer.parseInt(String.valueOf(tipoPublicacion))) {
                case 1:
                
                    variable = variable + (this.campo5 == null ? "" : "COLECCION O SERIE: " + this.campo5 + " ");
                    break;
                case 2:
                    variable = variable + (this.campo5 == null ? "" : "OTROS AUTORES: " + this.campo5 + " ");
                    break;
                case 4:
                    variable = variable + (this.campo5 == null ? "" : "DESCRIPCIÓN FÍSICA: " + this.campo5 + " ");
                    break;               
                default:
                    break;
            }
             variable = variable +(this.campo10== null?"":" AÑO: "+this.campo10);
        } else {
            variable = null;
            variable = (this.pubApellidoAutor == null ? "" : "AUTOR: " + this.pubApellidoAutor) + " " + (this.pubNombreAutor == null ? "" : this.pubNombreAutor);
            variable = variable + (this.pubApellidoCoautor == null ? "" : " COAUTOR: " + this.pubApellidoCoautor) + " " + (this.pubNombreCoautor == null ? "" : this.pubNombreCoautor);
            variable = variable + (this.pubTitulo == null ? "" : " TÍTULO: " + this.pubTitulo);
            variable = variable + (this.pubSubtitulo == null ? "" : " SUBTITULO: " + this.pubSubtitulo);
            variable = variable + (this.pubEdicion == null ? "" : " EDICIÓN: " + this.pubEdicion);
            variable = variable + (this.pubFecedicion == null ? "" : " Fecha Edición: " + formateador.format(this.pubFecedicion));
            variable = variable + (this.pubNumpaginas == null ? "" : " Número Pág.:  " + this.pubNumpaginas);
            variable = variable + (this.tipoPublicacion == 5 || this.tipoPublicacion == 6 ? "Título: " + (this.pubTitrevista == null ? "" : this.pubTitrevista) : "");
            variable = variable + (this.pubVolumen == null ? "" : " Volumén:  " + this.pubVolumen);
            variable = variable + (this.pubNumissn == null ? "" : " ISSN: " + this.pubNumissn);
            variable = variable + (this.pubNumisbn == null ? "" : " ISBN: " + this.pubNumisbn);
            variable = variable + (this.formaPublicacion == 'D' ? " Digital " + (this.pubUrl == null ? "" : this.pubUrl) : " Impreso ");
        }
        return variable;
    }

    public String getnomtippublicacion() {
        String variable = "";
        switch (Integer.parseInt(String.valueOf(tipoPublicacion))) {
            case 1:
                variable = "Libros de autoría personal";
                break;
            case 2:
                variable = "Libros  que actúa como editor, compilador o coordinador";
                break;
            case 3:
                variable = "Participación como miembro del Comité Editorial";
                break;
            case 4:
                variable = "Autoría de capítulo dentro de un libro colectivo";
                break;
            case 5:
                variable = "Publicación de artículos en revistas académicas indexadas";
                break;
            case 6:
                variable = "Publicación de artículos en revistas académicas no indexadas";
                break;
            case 7: case 11:
                variable = "Ponencia con formato de artículo académico";
                break;
            case 8:
                variable = "Página Web";
                break;
            case 9:
                variable = "Tesis";
                break;
            case 10:
                variable = "Otro";
                break;

            default:
                variable = "Otro";
                break;
        }

        return variable;
    }

    public String getnomformpub() {
        String variable = "";
        switch (this.formaPublicacion) {
            case 'I':
                variable = "Impreso";
                break;
            case 'D':
                variable = "Digital";
                break;
            default:
                variable = "Otro";
                break;
        }
        return variable;
    }

    public String getnomausp() {
        String variable = "";
        switch (this.auspicioPublicacion) {
            case 'U':
                variable = "UASB";
                break;
            case 'O':
                variable = "Otro(Especifique)";
                break;
            case 'N':
                variable = "N/A";
                break;
            default:
                variable = "N/A";
                break;
        }
        return variable;
    }

    public String getnomtippart() {
        String variable = "";
        if (pubParticipacion != null) {
            switch (this.pubParticipacion) {
                case 'A':
                    variable = "Autor";
                    break;
                case 'C':
                    variable = "Coautor";
                    break;
                case 'E':
                    variable = "Editor";
                    break;
                case 'D':
                    variable = "Coordinador";
                    break;
                case 'T':
                    variable = "Traductor";
                    break;
                case 'M':
                    variable = "Compilador";
                    break;
                default:
                    variable = "N/A";
                    break;
            }
        }
        return variable;
    }

    public String getnomidioma() {
        String variable = "";
        if (pubIdioma != null) {
            switch (Integer.parseInt(String.valueOf(this.pubIdioma))) {
                case 1:
                    variable = "Español";
                    break;
                case 2:
                    variable = "Inglés";
                    break;
                case 3:
                    variable = "Francés";
                    break;
                case 4:
                    variable = "Italiano";
                    break;
                case 5:
                    variable = "Portugués";
                    break;
                case 6:
                    variable = "Otro";
                    break;
                default:
                    variable = "Otro";
                    break;
            }
        }
        return variable;
    }

    public PublicacionProfesor(PublicacionProfesorPK publicacionProfesorPK) {
        this.publicacionProfesorPK = publicacionProfesorPK;
    }

    public PublicacionProfesor(PublicacionProfesorPK publicacionProfesorPK, long tipoPublicacion, char formaPublicacion, char auspicioPublicacion, String usuarioCrea, String usuarioUltmodific, Date fechaCrea, Date fechaUltmodific) {
        this.publicacionProfesorPK = publicacionProfesorPK;
        this.tipoPublicacion = tipoPublicacion;
        this.formaPublicacion = formaPublicacion;
        this.auspicioPublicacion = auspicioPublicacion;
        this.usuarioCrea = usuarioCrea;
        this.usuarioUltmodific = usuarioUltmodific;
        this.fechaCrea = fechaCrea;
        this.fechaUltmodific = fechaUltmodific;
    }

    public PublicacionProfesor(long codigoPublicacion, long codigoProfesor) {
        this.publicacionProfesorPK = new PublicacionProfesorPK(codigoPublicacion, codigoProfesor);
    }

    public PublicacionProfesorPK getPublicacionProfesorPK() {
        return publicacionProfesorPK;
    }

    public void setPublicacionProfesorPK(PublicacionProfesorPK publicacionProfesorPK) {
        this.publicacionProfesorPK = publicacionProfesorPK;
    }

    public long getTipoPublicacion() {
        return tipoPublicacion;
    }

    public void setTipoPublicacion(long tipoPublicacion) {
        this.tipoPublicacion = tipoPublicacion;
    }

    public String getCampo1() {
        return campo1;
    }

    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }

    public String getCampo2() {
        return campo2;
    }

    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }

    public String getCampo3() {
        return campo3;
    }

    public void setCampo3(String campo3) {
        this.campo3 = campo3;
    }

    public String getCampo4() {
        return campo4;
    }

    public void setCampo4(String campo4) {
        this.campo4 = campo4;
    }

    public String getCampo5() {
        return campo5;
    }

    public void setCampo5(String campo5) {
        this.campo5 = campo5;
    }

    public String getCampo6() {
        return campo6;
    }

    public void setCampo6(String campo6) {
        this.campo6 = campo6;
    }

    public String getCampo7() {
        return campo7;
    }

    public void setCampo7(String campo7) {
        this.campo7 = campo7;
    }

    public String getCampo8() {
        return campo8;
    }

    public void setCampo8(String campo8) {
        this.campo8 = campo8;
    }

    public String getCampo9() {
        return campo9;
    }

    public void setCampo9(String campo9) {
        this.campo9 = campo9;
    }

    public String getCampo10() {
        return campo10;
    }

    public void setCampo10(String campo10) {
        this.campo10 = campo10;
    }

    public char getFormaPublicacion() {
        return formaPublicacion;
    }

    public void setFormaPublicacion(char formaPublicacion) {
        this.formaPublicacion = formaPublicacion;
    }

    public char getAuspicioPublicacion() {
        return auspicioPublicacion;
    }

    public void setAuspicioPublicacion(char auspicioPublicacion) {
        this.auspicioPublicacion = auspicioPublicacion;
    }

    public String getOtroAuspicio() {
        return otroAuspicio;
    }

    public void setOtroAuspicio(String otroAuspicio) {
        this.otroAuspicio = otroAuspicio;
    }

    public String getObservacionPublicacion() {
        return observacionPublicacion;
    }

    public void setObservacionPublicacion(String observacionPublicacion) {
        this.observacionPublicacion = observacionPublicacion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (publicacionProfesorPK != null ? publicacionProfesorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicacionProfesor)) {
            return false;
        }
        PublicacionProfesor other = (PublicacionProfesor) object;
        if ((this.publicacionProfesorPK == null && other.publicacionProfesorPK != null) || (this.publicacionProfesorPK != null && !this.publicacionProfesorPK.equals(other.publicacionProfesorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.infoanual.entities.PublicacionProfesor[ publicacionProfesorPK=" + publicacionProfesorPK + " ]";
    }

    public String getPaisAuspicio() {
        return paisAuspicio;
    }

    public void setPaisAuspicio(String paisAuspicio) {
        this.paisAuspicio = paisAuspicio;
    }

    public Long getCiudadAuspicio() {
        return ciudadAuspicio;
    }

    public void setCiudadAuspicio(Long ciudadAuspicio) {
        this.ciudadAuspicio = ciudadAuspicio;
    }

    public String getPubApellidoAutor() {
        return pubApellidoAutor;
    }

    public void setPubApellidoAutor(String pubApellidoAutor) {
        this.pubApellidoAutor = pubApellidoAutor;
    }

    public String getPubNombreAutor() {
        return pubNombreAutor;
    }

    public void setPubNombreAutor(String pubNombreAutor) {
        this.pubNombreAutor = pubNombreAutor;
    }

    public String getPubApellidoCoautor() {
        return pubApellidoCoautor;
    }

    public void setPubApellidoCoautor(String pubApellidoCoautor) {
        this.pubApellidoCoautor = pubApellidoCoautor;
    }

    public String getPubNombreCoautor() {
        return pubNombreCoautor;
    }

    public void setPubNombreCoautor(String pubNombreCoautor) {
        this.pubNombreCoautor = pubNombreCoautor;
    }

    public String getPubTitulo() {
        return pubTitulo;
    }

    public void setPubTitulo(String pubTitulo) {
        this.pubTitulo = pubTitulo;
    }

    public String getPubSubtitulo() {
        return pubSubtitulo;
    }

    public void setPubSubtitulo(String pubSubtitulo) {
        this.pubSubtitulo = pubSubtitulo;
    }

    public String getPubEdicion() {
        return pubEdicion;
    }

    public void setPubEdicion(String pubEdicion) {
        this.pubEdicion = pubEdicion;
    }

    public Long getPubCiueditorial() {
        return pubCiueditorial;
    }

    public void setPubCiueditorial(Long pubCiueditorial) {
        this.pubCiueditorial = pubCiueditorial;
    }

    public String getPubPaieditorial() {
        return pubPaieditorial;
    }

    public void setPubPaieditorial(String pubPaieditorial) {
        this.pubPaieditorial = pubPaieditorial;
    }

    public String getPubEditorial() {
        return pubEditorial;
    }

    public void setPubEditorial(String pubEditorial) {
        this.pubEditorial = pubEditorial;
    }

    public Date getPubFecedicion() {
        return pubFecedicion;
    }

    public void setPubFecedicion(Date pubFecedicion) {
        this.pubFecedicion = pubFecedicion;
    }

    public String getPubNumpaginas() {
        return pubNumpaginas;
    }

    public void setPubNumpaginas(String pubNumpaginas) {
        this.pubNumpaginas = pubNumpaginas;
    }

    public String getPubTitrevista() {
        return pubTitrevista;
    }

    public void setPubTitrevista(String pubTitrevista) {
        this.pubTitrevista = pubTitrevista;
    }

    public Integer getPubVolumen() {
        return pubVolumen;
    }

    public void setPubVolumen(Integer pubVolumen) {
        this.pubVolumen = pubVolumen;
    }

    public String getPubNumisbn() {
        return pubNumisbn;
    }

    public void setPubNumisbn(String pubNumisbn) {
        this.pubNumisbn = pubNumisbn;
    }

    public String getPubNumissn() {
        return pubNumissn;
    }

    public void setPubNumissn(String pubNumissn) {
        this.pubNumissn = pubNumissn;
    }

    public String getPubUrl() {
        return pubUrl;
    }

    public void setPubUrl(String pubUrl) {
        this.pubUrl = pubUrl;
    }

    public Integer getPubIdioma() {
        return pubIdioma;
    }

    public void setPubIdioma(Integer pubIdioma) {
        this.pubIdioma = pubIdioma;
    }

    public String getPubNombreCapitulo() {
        return pubNombreCapitulo;
    }

    public void setPubNombreCapitulo(String pubNombreCapitulo) {
        this.pubNombreCapitulo = pubNombreCapitulo;
    }

    public Character getPubParticipacion() {
        return pubParticipacion;
    }

    public void setPubParticipacion(Character pubParticipacion) {
        this.pubParticipacion = pubParticipacion;
    }

    public Character getPubRevpares() {
        return pubRevpares;
    }

    public void setPubRevpares(Character pubRevpares) {
        this.pubRevpares = pubRevpares;
    }

    public Character getPubEstado() {
        return pubEstado;
    }

    public void setPubEstado(Character pubEstado) {
        this.pubEstado = pubEstado;
    }

    public Character getPubBaserevindexada() {
        return pubBaserevindexada;
    }

    public void setPubBaserevindexada(Character pubBaserevindexada) {
        this.pubBaserevindexada = pubBaserevindexada;
    }

    public String getPubNomotrabaseindex() {
        return pubNomotrabaseindex;
    }

    public void setPubNomotrabaseindex(String pubNomotrabaseindex) {
        this.pubNomotrabaseindex = pubNomotrabaseindex;
    }

    public String getNomCiudad() {
        return nomCiudad;
    }

    public void setNomCiudad(String nomCiudad) {
        this.nomCiudad = nomCiudad;
    }

    public String getNomPais() {
        return nomPais;
    }

    public void setNomPais(String nomPais) {
        this.nomPais = nomPais;
    }

    public Character getPubPartserie() {
        return pubPartserie;
    }

    public void setPubPartserie(Character pubPartserie) {
        this.pubPartserie = pubPartserie;
    }

    public String getPubEntidadsede() {
        return pubEntidadsede;
    }

    public void setPubEntidadsede(String pubEntidadsede) {
        this.pubEntidadsede = pubEntidadsede;
    }

    public Character getPubEvento() {
        return pubEvento;
    }

    public void setPubEvento(Character pubEvento) {
        this.pubEvento = pubEvento;
    }

    public Character getPubMeddifusion() {
        return pubMeddifusion;
    }

    public void setPubMeddifusion(Character pubMeddifusion) {
        this.pubMeddifusion = pubMeddifusion;
    }

    public String getPubTitserie() {
        return pubTitserie;
    }

    public void setPubTitserie(String pubTitserie) {
        this.pubTitserie = pubTitserie;
    }
}
