/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.form.datamodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author victor.barba
 */
@Entity
public class EncuEvalDocente implements Serializable {

    private static final long serialVersionUID = 106L;
    @EmbeddedId
    protected EncuEvalDocentePK encuEvalDocentePK;
    @Column(name = "CODIGO_ENCUESTA")
    private Long codigoEncuesta;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "REFERENCIA")
    private String referencia;

    @Column(name = "CICLO")
    private Long ciclo;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "NOMBRE_PROFESOR")
    private String nombres;
    @Column(name = "APELLIDO_PROFESOR")
    private String apellidos;
    @Column(name = "IDENTIF_MATERIA")
    private String identifMateria;
    @Column(name = "NOMBRE_MATERIA")
    private String nombreMateria;
    @Column(name = "HABILITADO")
    private String habilitado;    
    @Column(name = "TRIMESTRE")
    private String nombreNivel;
    @Column(name = "PROGRAMA")
    private String programa;    
    @Column(name = "MENCION")
    private String mencion; 
    
    public EncuEvalDocente() {
    }

    public EncuEvalDocente(EncuEvalDocentePK encuEvalDocentePK, Long codigoProfesor, Long codigoEncuesta, String titulo, String referencia, Long ciclo,
            Date fechaInicio, Date fechaFin, Long codigoMateria, String estado, String nombres, String apellidos, String identifMateria,
            String nombreMateria, String nombreNivel,String habilitado,String programa, String mencion) {
        this.encuEvalDocentePK = encuEvalDocentePK;
        this.codigoEncuesta = codigoEncuesta;
        this.titulo = titulo;
        this.referencia = referencia;
        this.ciclo = ciclo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identifMateria = identifMateria;
        this.nombreMateria = nombreMateria;
        this.nombreNivel = nombreNivel;
        this.habilitado = habilitado;
        this.programa = programa;
        this.mencion = mencion;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getMencion() {
        return mencion;
    }

    public void setMencion(String mencion) {
        this.mencion = mencion;
    }

    public String getIdentifMateria() {
        return identifMateria;
    }

    public void setIdentifMateria(String identifMateria) {
        this.identifMateria = identifMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getNombreNivel() {
        return nombreNivel;
    }

    public void setNombreNivel(String nombreNivel) {
        this.nombreNivel = nombreNivel;
    }

    public EncuEvalDocentePK getEncuEvalDocentePK() {
        return encuEvalDocentePK;
    }

    public void setEncuEvalDocentePK(EncuEvalDocentePK encuEvalDocentePK) {
        this.encuEvalDocentePK = encuEvalDocentePK;
    }

    public Long getCodigoEncuesta() {
        return codigoEncuesta;
    }

    public void setCodigoEncuesta(Long codigoEncuesta) {
        this.codigoEncuesta = codigoEncuesta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Long getCiclo() {
        return ciclo;
    }

    public void setCiclo(Long ciclo) {
        this.ciclo = ciclo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.encuEvalDocentePK != null ? this.encuEvalDocentePK.hashCode() : 0);
        hash = 13 * hash + (this.codigoEncuesta != null ? this.codigoEncuesta.hashCode() : 0);
        hash = 13 * hash + (this.titulo != null ? this.titulo.hashCode() : 0);
        hash = 13 * hash + (this.referencia != null ? this.referencia.hashCode() : 0);
        hash = 13 * hash + (this.ciclo != null ? this.ciclo.hashCode() : 0);
        hash = 13 * hash + (this.fechaInicio != null ? this.fechaInicio.hashCode() : 0);
        hash = 13 * hash + (this.fechaFin != null ? this.fechaFin.hashCode() : 0);
        hash = 13 * hash + (this.estado != null ? this.estado.hashCode() : 0);
        hash = 13 * hash + (this.nombres != null ? this.nombres.hashCode() : 0);
        hash = 13 * hash + (this.apellidos != null ? this.apellidos.hashCode() : 0);
        hash = 13 * hash + (this.identifMateria != null ? this.identifMateria.hashCode() : 0);
        hash = 13 * hash + (this.nombreMateria != null ? this.nombreMateria.hashCode() : 0);
        hash = 13 * hash + (this.nombreNivel != null ? this.nombreNivel.hashCode() : 0);
        hash = 13 * hash + (this.programa != null ? this.programa.hashCode() : 0);
        hash = 13 * hash + (this.mencion != null ? this.mencion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EncuEvalDocente other = (EncuEvalDocente) obj;
        if (this.encuEvalDocentePK != other.encuEvalDocentePK && (this.encuEvalDocentePK == null || !this.encuEvalDocentePK.equals(other.encuEvalDocentePK))) {
            return false;
        }
        if (this.codigoEncuesta != other.codigoEncuesta && (this.codigoEncuesta == null || !this.codigoEncuesta.equals(other.codigoEncuesta))) {
            return false;
        }
        if ((this.titulo == null) ? (other.titulo != null) : !this.titulo.equals(other.titulo)) {
            return false;
        }
        if ((this.referencia == null) ? (other.referencia != null) : !this.referencia.equals(other.referencia)) {
            return false;
        }
        if (this.ciclo != other.ciclo && (this.ciclo == null || !this.ciclo.equals(other.ciclo))) {
            return false;
        }
        if (this.fechaInicio != other.fechaInicio && (this.fechaInicio == null || !this.fechaInicio.equals(other.fechaInicio))) {
            return false;
        }
        if (this.fechaFin != other.fechaFin && (this.fechaFin == null || !this.fechaFin.equals(other.fechaFin))) {
            return false;
        }
        if ((this.estado == null) ? (other.estado != null) : !this.estado.equals(other.estado)) {
            return false;
        }
        if ((this.nombres == null) ? (other.nombres != null) : !this.nombres.equals(other.nombres)) {
            return false;
        }
        if ((this.apellidos == null) ? (other.apellidos != null) : !this.apellidos.equals(other.apellidos)) {
            return false;
        }
        if ((this.identifMateria == null) ? (other.identifMateria != null) : !this.identifMateria.equals(other.identifMateria)) {
            return false;
        }
        if ((this.nombreMateria == null) ? (other.nombreMateria != null) : !this.nombreMateria.equals(other.nombreMateria)) {
            return false;
        }
        if ((this.nombreNivel == null) ? (other.nombreNivel != null) : !this.nombreNivel.equals(other.nombreNivel)) {
            return false;
        }
        if ((this.programa == null) ? (other.programa != null) : !this.programa.equals(other.programa)) {
            return false;
        }    
        if ((this.mencion == null) ? (other.mencion != null) : !this.mencion.equals(other.mencion)) {
            return false;
        }            
        return true;
    }

    @Override
    public String toString() {
        return "EncuEvalDocente{" + "encuEvalDocentePK=" + encuEvalDocentePK + ", codigoEncuesta=" + codigoEncuesta + ", titulo=" + titulo + ", referencia=" + referencia + ", ciclo=" + ciclo + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado + ", nombres=" + nombres + ", apellidos=" + apellidos + ", identifMateria=" + identifMateria + ", nombreMateria=" + nombreMateria + ", habilitado=" + habilitado + ", nombreNivel=" + nombreNivel + ", programa=" + programa + ", mencion=" + mencion + '}';
    }



}
