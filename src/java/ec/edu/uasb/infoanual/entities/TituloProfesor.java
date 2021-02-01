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
@Table(name = "TITULO_PROFESOR")
@NamedQueries({
    @NamedQuery(name = "TituloProfesor.findAll", query = "SELECT t FROM TituloProfesor t")})

public class TituloProfesor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TituloProfesorPK tituloProfesorPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "UNIVERSIDAD")
    private String universidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PAIS_UNIVERSIDAD")
    private String paisUniversidad;
    @Column(name = "USAR_TITULO")
    private Character usarTitulo;
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
    @Size(max = 20)
    @Column(name = "REGISTRO_CONESUP")
    private String registroConesup;
    @Size(max = 300)
    @Column(name = "TITULO_CONESUP")
    private String tituloConesup;
    @Column(name = "TIPO_TITULO")
    private Character tipoTitulo;
    @Column(name = "NIVEL_POSGRADO")
    private Character nivelPosgrado;
    @Column(name = "SELECCION_TITULO")
    private Character seleccionTitulo;
    @Column(name = "FECHA_TITULO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTitulo;
    @Column(name = "CIUDAD_UNIVERSIDAD")
    private long ciudadUniversidad;
    @JoinColumn(name = "CODIGO_TITULO", referencedColumnName = "CODIGO_TITULO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Titulo titulo;
    @JoinColumn(name = "CODIGO_PROFESOR", referencedColumnName = "CODIGO_PROFESOR", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profesor profesor;
   @Transient
   private String nomPas;
     @Transient
   private String nomCiudad;
   

    public TituloProfesor() {
      
    }

   

    public TituloProfesor(TituloProfesorPK tituloProfesorPK) {
        this.tituloProfesorPK = tituloProfesorPK;
    }

    public TituloProfesor(TituloProfesorPK tituloProfesorPK, String universidad, String paisUniversidad) {
        this.tituloProfesorPK = tituloProfesorPK;
        this.universidad = universidad;
        this.paisUniversidad = paisUniversidad;
    }

    public TituloProfesor(long codigoTitulo, long codigoProfesor) {
        this.tituloProfesorPK = new TituloProfesorPK(codigoTitulo, codigoProfesor);
    }

    public TituloProfesorPK getTituloProfesorPK() {
        return tituloProfesorPK;
    }

    public void setTituloProfesorPK(TituloProfesorPK tituloProfesorPK) {
        this.tituloProfesorPK = tituloProfesorPK;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getPaisUniversidad() {
        return paisUniversidad;
    }

    public void setPaisUniversidad(String paisUniversidad) {
        this.paisUniversidad = paisUniversidad;
    }

    public Character getUsarTitulo() {
        return usarTitulo;
    }

    public void setUsarTitulo(Character usarTitulo) {
        this.usarTitulo = usarTitulo;
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

    public String getRegistroConesup() {
        return registroConesup;
    }

    public void setRegistroConesup(String registroConesup) {
        this.registroConesup = registroConesup;
    }

    public String getTituloConesup() {
        return tituloConesup;
    }

    public void setTituloConesup(String tituloConesup) {
        this.tituloConesup = tituloConesup;
    }

    public Character getTipoTitulo() {
        return tipoTitulo;
    }

    public void setTipoTitulo(Character tipoTitulo) {
        this.tipoTitulo = tipoTitulo;
    }

    public Character getNivelPosgrado() {
        return nivelPosgrado;
    }

    public void setNivelPosgrado(Character nivelPosgrado) {
        this.nivelPosgrado = nivelPosgrado;
    }

    public Character getSeleccionTitulo() {
        return seleccionTitulo;
    }

    public void setSeleccionTitulo(Character seleccionTitulo) {
        this.seleccionTitulo = seleccionTitulo;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getNomPas() {
        return nomPas;
    }

    public void setNomPas(String nomPas) {
        this.nomPas = nomPas;
    }

    public Date getFechaTitulo() {
        return fechaTitulo;
    }

    public void setFechaTitulo(Date fechaTitulo) {
        this.fechaTitulo = fechaTitulo;
    }

    public long getCiudadUniversidad() {
        return ciudadUniversidad;
    }

    public void setCiudadUniversidad(long ciudadUniversidad) {
        this.ciudadUniversidad = ciudadUniversidad;
    }

    public String getNomCiudad() {
        return nomCiudad;
    }

    public void setNomCiudad(String nomCiudad) {
        this.nomCiudad = nomCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tituloProfesorPK != null ? tituloProfesorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TituloProfesor)) {
            return false;
        }
        TituloProfesor other = (TituloProfesor) object;
        if ((this.tituloProfesorPK == null && other.tituloProfesorPK != null) || (this.tituloProfesorPK != null && !this.tituloProfesorPK.equals(other.tituloProfesorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.infoanual.entities.TituloProfesor[ tituloProfesorPK=" + tituloProfesorPK + " ]";
    }

   
 
    
}
