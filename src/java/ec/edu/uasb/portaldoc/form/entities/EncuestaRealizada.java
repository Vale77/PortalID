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
@Table(name = "ENCUESTA_REALIZADA",schema = "EVALUACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EncuestaRealizada.findAll", query = "SELECT e FROM EncuestaRealizada e"),
    @NamedQuery(name = "EncuestaRealizada.findByCodigoAlumno", query = "SELECT e FROM EncuestaRealizada e WHERE e.encuestaRealizadaPK.codigoAlumno = :codigoAlumno"),
    @NamedQuery(name = "EncuestaRealizada.findByAnio", query = "SELECT e FROM EncuestaRealizada e WHERE e.encuestaRealizadaPK.anio = :anio"),
    @NamedQuery(name = "EncuestaRealizada.findByCiclo", query = "SELECT e FROM EncuestaRealizada e WHERE e.encuestaRealizadaPK.ciclo = :ciclo"),
    @NamedQuery(name = "EncuestaRealizada.findByCodigoMateria", query = "SELECT e FROM EncuestaRealizada e WHERE e.encuestaRealizadaPK.codigoMateria = :codigoMateria"),
    @NamedQuery(name = "EncuestaRealizada.findByCodigoEncuesta", query = "SELECT e FROM EncuestaRealizada e WHERE e.encuestaRealizadaPK.codigoEncuesta = :codigoEncuesta"),
    @NamedQuery(name = "EncuestaRealizada.findByCodigoProfesor", query = "SELECT e FROM EncuestaRealizada e WHERE e.encuestaRealizadaPK.codigoProfesor = :codigoProfesor"),
    @NamedQuery(name = "EncuestaRealizada.findByFecha", query = "SELECT e FROM EncuestaRealizada e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "EncuestaRealizada.findByRealizada", query = "SELECT e FROM EncuestaRealizada e WHERE e.realizada = :realizada")})
public class EncuestaRealizada implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EncuestaRealizadaPK encuestaRealizadaPK;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "REALIZADA")
    private Character realizada;

    public EncuestaRealizada() {
    }

    public EncuestaRealizada(EncuestaRealizadaPK encuestaRealizadaPK) {
        this.encuestaRealizadaPK = encuestaRealizadaPK;
    }

    public EncuestaRealizada(Long codigoAlumno, Long anio, Long ciclo, Long codigoMateria, Long codigoEncuesta, Long codigoProfesor,
            Long codigoEsp, Long codigoNivel,Long codigoParalelo) {
        this.encuestaRealizadaPK = new EncuestaRealizadaPK(codigoAlumno, anio, ciclo, 
                codigoMateria, codigoEncuesta, codigoProfesor,"C",codigoEsp, codigoNivel,codigoParalelo);
    }

    public EncuestaRealizadaPK getEncuestaRealizadaPK() {
        return encuestaRealizadaPK;
    }

    public void setEncuestaRealizadaPK(EncuestaRealizadaPK encuestaRealizadaPK) {
        this.encuestaRealizadaPK = encuestaRealizadaPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Character getRealizada() {
        return realizada;
    }

    public void setRealizada(Character realizada) {
        this.realizada = realizada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (encuestaRealizadaPK != null ? encuestaRealizadaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EncuestaRealizada)) {
            return false;
        }
        EncuestaRealizada other = (EncuestaRealizada) object;
        if ((this.encuestaRealizadaPK == null && other.encuestaRealizadaPK != null) || (this.encuestaRealizadaPK != null && !this.encuestaRealizadaPK.equals(other.encuestaRealizadaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.entity.EncuestaRealizada[ encuestaRealizadaPK=" + encuestaRealizadaPK + " ]";
    }
    
}
