/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.form.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author victor.barba
 */
@Embeddable
public class EncuestaRealizadaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_ALUMNO")
    private Long codigoAlumno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIO")
    private Long anio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CICLO")
    private Long ciclo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_MATERIA")
    private Long codigoMateria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_NIVEL")
    private Long codigoNivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_ENCUESTA")
    private Long codigoEncuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_PROFESOR")
    private Long codigoProfesor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_ESP")
    private Long codigoEsp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_REGISTRO")
    private String tipoRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_PARALELO")
    private Long codigoParalelo;

    public EncuestaRealizadaPK() {
    }

    public EncuestaRealizadaPK(Long codigoAlumno, Long anio, Long ciclo, Long codigoMateria, Long codigoEncuesta,
            Long codigoProfesor, String tipoRegistro, Long codigoEsp, Long codigoNivel, Long codigoParalelo) {
        this.codigoAlumno = codigoAlumno;
        this.anio = anio;
        this.ciclo = ciclo;
        this.codigoMateria = codigoMateria;
        this.codigoEncuesta = codigoEncuesta;
        this.codigoProfesor = codigoProfesor;
        this.tipoRegistro = tipoRegistro;
        this.codigoEsp = codigoEsp;
        this.codigoNivel = codigoNivel;
        this.codigoParalelo = codigoParalelo;
    }

    public long getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(Long codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public Long getAnio() {
        return anio;
    }

    public void setAnio(Long anio) {
        this.anio = anio;
    }

    public Long getCiclo() {
        return ciclo;
    }

    public void setCiclo(Long ciclo) {
        this.ciclo = ciclo;
    }

    public Long getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(Long codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public Long getCodigoEncuesta() {
        return codigoEncuesta;
    }

    public void setCodigoEncuesta(Long codigoEncuesta) {
        this.codigoEncuesta = codigoEncuesta;
    }

    public Long getCodigoProfesor() {
        return codigoProfesor;
    }

    public Long getCodigoEsp() {
        return codigoEsp;
    }

    public void setCodigoEsp(Long codigoEsp) {
        this.codigoEsp = codigoEsp;
    }

    public void setCodigoProfesor(Long codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public Long getCodigoNivel() {
        return codigoNivel;
    }

    public void setCodigoNivel(Long codigoNivel) {
        this.codigoNivel = codigoNivel;
    }

    public Long getCodigoParalelo() {
        return codigoParalelo;
    }

    public void setCodigoParalelo(Long codigoParalelo) {
        this.codigoParalelo = codigoParalelo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.codigoAlumno != null ? this.codigoAlumno.hashCode() : 0);
        hash = 79 * hash + (this.anio != null ? this.anio.hashCode() : 0);
        hash = 79 * hash + (this.ciclo != null ? this.ciclo.hashCode() : 0);
        hash = 79 * hash + (this.codigoMateria != null ? this.codigoMateria.hashCode() : 0);
        hash = 79 * hash + (this.codigoNivel != null ? this.codigoNivel.hashCode() : 0);
        hash = 79 * hash + (this.codigoEncuesta != null ? this.codigoEncuesta.hashCode() : 0);
        hash = 79 * hash + (this.codigoProfesor != null ? this.codigoProfesor.hashCode() : 0);
        hash = 79 * hash + (this.codigoEsp != null ? this.codigoEsp.hashCode() : 0);
        hash = 79 * hash + (this.tipoRegistro != null ? this.tipoRegistro.hashCode() : 0);
        hash = 79 * hash + (this.codigoParalelo != null ? this.codigoParalelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EncuestaRealizadaPK other = (EncuestaRealizadaPK) obj;
        if ((this.tipoRegistro == null) ? (other.tipoRegistro != null) : !this.tipoRegistro.equals(other.tipoRegistro)) {
            return false;
        }
        if (this.codigoAlumno != other.codigoAlumno && (this.codigoAlumno == null || !this.codigoAlumno.equals(other.codigoAlumno))) {
            return false;
        }
        if (this.anio != other.anio && (this.anio == null || !this.anio.equals(other.anio))) {
            return false;
        }
        if (this.ciclo != other.ciclo && (this.ciclo == null || !this.ciclo.equals(other.ciclo))) {
            return false;
        }
        if (this.codigoMateria != other.codigoMateria && (this.codigoMateria == null || !this.codigoMateria.equals(other.codigoMateria))) {
            return false;
        }
        if (this.codigoNivel != other.codigoNivel && (this.codigoNivel == null || !this.codigoNivel.equals(other.codigoNivel))) {
            return false;
        }
        if (this.codigoEncuesta != other.codigoEncuesta && (this.codigoEncuesta == null || !this.codigoEncuesta.equals(other.codigoEncuesta))) {
            return false;
        }
        if (this.codigoProfesor != other.codigoProfesor && (this.codigoProfesor == null || !this.codigoProfesor.equals(other.codigoProfesor))) {
            return false;
        }
        if (this.codigoEsp != other.codigoEsp && (this.codigoEsp == null || !this.codigoEsp.equals(other.codigoEsp))) {
            return false;
        }
        if (this.codigoParalelo != other.codigoParalelo && (this.codigoParalelo == null || !this.codigoParalelo.equals(other.codigoParalelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EncuestaRealizadaPK{" + "codigoAlumno=" + codigoAlumno + ", anio=" + anio + ", ciclo=" + ciclo + ", codigoMateria=" + codigoMateria + ", codigoNivel=" + codigoNivel + ", codigoEncuesta=" + codigoEncuesta + ", codigoProfesor=" + codigoProfesor + ", codigoEsp=" + codigoEsp + ", tipoRegistro=" + tipoRegistro + ", codigoParalelo=" + codigoParalelo + '}';
    }

}
