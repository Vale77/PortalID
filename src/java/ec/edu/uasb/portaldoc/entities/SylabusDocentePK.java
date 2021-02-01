/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.entities;

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
public class SylabusDocentePK implements Serializable {

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
    @Column(name = "CODIGO_PROFESOR")
    private Long codigoProfesor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_NIVEL")
    private Long codigoNivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VAC_CODNUM")
    private Long vacCodnum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PARALELO")
    private Long codParalelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PROGRAMA")
    private Long codPrograma;

    public SylabusDocentePK() {
    }

    public SylabusDocentePK(Long anio, Long ciclo, Long codigoMateria, Long codigoProfesor, Long codigoNivel, Long vacCodnum,
            Long codParalelo, Long codPrograma) {
        this.anio = anio;
        this.ciclo = ciclo;
        this.codigoMateria = codigoMateria;
        this.codigoProfesor = codigoProfesor;
        this.codigoNivel = codigoNivel;
        this.vacCodnum = vacCodnum;
        this.codParalelo = codParalelo;
        this.codPrograma = codPrograma;
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

    public Long getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(Long codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public Long getCodigoNivel() {
        return codigoNivel;
    }

    public void setCodigoNivel(Long codigoNivel) {
        this.codigoNivel = codigoNivel;
    }

    public Long getVacCodnum() {
        return vacCodnum;
    }

    public void setVacCodnum(Long vacCodnum) {
        this.vacCodnum = vacCodnum;
    }

    public Long getCodParalelo() {
        return codParalelo;
    }

    public void setCodParalelo(Long codParalelo) {
        this.codParalelo = codParalelo;
    }

    public Long getCodPrograma() {
        return codPrograma;
    }

    public void setCodPrograma(Long codPrograma) {
        this.codPrograma = codPrograma;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.anio != null ? this.anio.hashCode() : 0);
        hash = 83 * hash + (this.ciclo != null ? this.ciclo.hashCode() : 0);
        hash = 83 * hash + (this.codigoMateria != null ? this.codigoMateria.hashCode() : 0);
        hash = 83 * hash + (this.codigoProfesor != null ? this.codigoProfesor.hashCode() : 0);
        hash = 83 * hash + (this.codigoNivel != null ? this.codigoNivel.hashCode() : 0);
        hash = 83 * hash + (this.vacCodnum != null ? this.vacCodnum.hashCode() : 0);
        hash = 83 * hash + (this.codParalelo != null ? this.codParalelo.hashCode() : 0);
        hash = 83 * hash + (this.codPrograma != null ? this.codPrograma.hashCode() : 0);
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
        final SylabusDocentePK other = (SylabusDocentePK) obj;
        if (this.anio != other.anio && (this.anio == null || !this.anio.equals(other.anio))) {
            return false;
        }
        if (this.ciclo != other.ciclo && (this.ciclo == null || !this.ciclo.equals(other.ciclo))) {
            return false;
        }
        if (this.codigoMateria != other.codigoMateria && (this.codigoMateria == null || !this.codigoMateria.equals(other.codigoMateria))) {
            return false;
        }
        if (this.codigoProfesor != other.codigoProfesor && (this.codigoProfesor == null || !this.codigoProfesor.equals(other.codigoProfesor))) {
            return false;
        }
        if (this.codigoNivel != other.codigoNivel && (this.codigoNivel == null || !this.codigoNivel.equals(other.codigoNivel))) {
            return false;
        }
        if (this.vacCodnum != other.vacCodnum && (this.vacCodnum == null || !this.vacCodnum.equals(other.vacCodnum))) {
            return false;
        }
        if (this.codParalelo != other.codParalelo && (this.codParalelo == null || !this.codParalelo.equals(other.codParalelo))) {
            return false;
        }
        return !(this.codPrograma != other.codPrograma && (this.codPrograma == null || !this.codPrograma.equals(other.codPrograma)));
    }

    @Override
    public String toString() {
        return "SylabusDocentePK{" + "anio=" + anio + ", ciclo=" + ciclo + ", codigoMateria=" + codigoMateria + ", codigoProfesor=" + codigoProfesor + ", codigoNivel=" + codigoNivel + ", vacCodnum=" + vacCodnum + ", codParalelo=" + codParalelo + ", codPrograma=" + codPrograma + '}';
    }

}
