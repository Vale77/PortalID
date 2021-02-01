/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.form.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author victor.barba
 */
@Entity
@Table(name = "ENCUESTA_CALENDARIO", schema = "EVALUACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EncuestaCalendario.findAll", query = "SELECT e FROM EncuestaCalendario e"),
    @NamedQuery(name = "EncuestaCalendario.findByAnio", query = "SELECT e FROM EncuestaCalendario e WHERE e.encuestaCalendarioPK.anio = :anio"),
    @NamedQuery(name = "EncuestaCalendario.findByCiclo", query = "SELECT e FROM EncuestaCalendario e WHERE e.encuestaCalendarioPK.ciclo = :ciclo"),
    @NamedQuery(name = "EncuestaCalendario.findByCodigoMateria", query = "SELECT e FROM EncuestaCalendario e WHERE e.encuestaCalendarioPK.codigoMateria = :codigoMateria"),
    @NamedQuery(name = "EncuestaCalendario.findByCodigoEncuesta", query = "SELECT e FROM EncuestaCalendario e WHERE e.encuestaCalendarioPK.codigoEncuesta = :codigoEncuesta"),
    @NamedQuery(name = "EncuestaCalendario.findByFechaInicio", query = "SELECT e FROM EncuestaCalendario e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "EncuestaCalendario.findByFechaFin", query = "SELECT e FROM EncuestaCalendario e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "EncuestaCalendario.findByCodigoProfesor", query = "SELECT e FROM EncuestaCalendario e WHERE e.encuestaCalendarioPK.codigoProfesor = :codigoProfesor"),
    @NamedQuery(name = "EncuestaCalendario.findByFInicioCalificacion", query = "SELECT e FROM EncuestaCalendario e WHERE e.fInicioCalificacion = :fInicioCalificacion"),
    @NamedQuery(name = "EncuestaCalendario.findByFFinCalificacion", query = "SELECT e FROM EncuestaCalendario e WHERE e.fFinCalificacion = :fFinCalificacion"),
    @NamedQuery(name = "EncuestaCalendario.findByEstadoEncuesta", query = "SELECT e FROM EncuestaCalendario e WHERE e.estadoEncuesta = :estadoEncuesta")})
public class EncuestaCalendario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EncuestaCalendarioPK encuestaCalendarioPK;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "F_INICIO_CALIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fInicioCalificacion;
    @Column(name = "F_FIN_CALIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFinCalificacion;
    @Column(name = "ESTADO_ENCUESTA")
    private Character estadoEncuesta;
    @JoinColumn(name = "CODIGO_ENCUESTA", referencedColumnName = "CODIGO_ENCUESTA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Encuesta encuesta;

    public EncuestaCalendario() {
    }

    public EncuestaCalendario(EncuestaCalendarioPK encuestaCalendarioPK) {
        this.encuestaCalendarioPK = encuestaCalendarioPK;
    }

    public EncuestaCalendario(Long anio, Long ciclo, Long codigoMateria, Long codigoEncuesta, Long codigoProfesor, Long codigoEsp, Long codigoNivel, Long codigoParalelo) {
        this.encuestaCalendarioPK = new EncuestaCalendarioPK(anio, ciclo, codigoMateria, codigoEncuesta, codigoProfesor, codigoEsp, codigoNivel, codigoParalelo);
    }

    public EncuestaCalendarioPK getEncuestaCalendarioPK() {
        return encuestaCalendarioPK;
    }

    public void setEncuestaCalendarioPK(EncuestaCalendarioPK encuestaCalendarioPK) {
        this.encuestaCalendarioPK = encuestaCalendarioPK;
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

    public Date getFInicioCalificacion() {
        return fInicioCalificacion;
    }

    public void setFInicioCalificacion(Date fInicioCalificacion) {
        this.fInicioCalificacion = fInicioCalificacion;
    }

    public Date getFFinCalificacion() {
        return fFinCalificacion;
    }

    public void setFFinCalificacion(Date fFinCalificacion) {
        this.fFinCalificacion = fFinCalificacion;
    }

    public Character getEstadoEncuesta() {
        return estadoEncuesta;
    }

    public void setEstadoEncuesta(Character estadoEncuesta) {
        this.estadoEncuesta = estadoEncuesta;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (encuestaCalendarioPK != null ? encuestaCalendarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EncuestaCalendario)) {
            return false;
        }
        EncuestaCalendario other = (EncuestaCalendario) object;
        if ((this.encuestaCalendarioPK == null && other.encuestaCalendarioPK != null) || (this.encuestaCalendarioPK != null && !this.encuestaCalendarioPK.equals(other.encuestaCalendarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.entity.EncuestaCalendario[ encuestaCalendarioPK=" + encuestaCalendarioPK + " ]";
    }
}
