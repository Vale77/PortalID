/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author victor.barba
 */
@Embeddable
public class SylabusContenidoPK implements Serializable {

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
    @NotNull
    @Column(name = "CODIGO_PROFESOR")
    private Long codigoProfesor;
//    @Basic(optional = false)
//    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_CONTENIDO")
    private Long numContenido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO")
    private char tipo;

    public SylabusContenidoPK() {
    }

    public SylabusContenidoPK(Long anio, Long ciclo, Long codigoMateria, Long codigoNivel, Long vacCodnum, Long codParalelo, Long codPrograma,
            Long codigoProfesor, Long numContenido, char tipo) {
        this.anio = anio;
        this.ciclo = ciclo;
        this.codigoMateria = codigoMateria;
        this.codigoNivel = codigoNivel;
        this.vacCodnum = vacCodnum;
        this.codParalelo = codParalelo;
        this.codPrograma = codPrograma;
        this.codigoProfesor = codigoProfesor;
        this.numContenido = numContenido;
        this.tipo = tipo;
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

    public Long getNumContenido() {
        return numContenido;
    }

    public void setNumContenido(Long numContenido) {
        this.numContenido = numContenido;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
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
        int hash = 5;
        hash = 53 * hash + (this.anio != null ? this.anio.hashCode() : 0);
        hash = 53 * hash + (this.ciclo != null ? this.ciclo.hashCode() : 0);
        hash = 53 * hash + (this.codigoMateria != null ? this.codigoMateria.hashCode() : 0);
        hash = 53 * hash + (this.codigoNivel != null ? this.codigoNivel.hashCode() : 0);
        hash = 53 * hash + (this.vacCodnum != null ? this.vacCodnum.hashCode() : 0);
        hash = 53 * hash + (this.codParalelo != null ? this.codParalelo.hashCode() : 0);
        hash = 53 * hash + (this.codPrograma != null ? this.codPrograma.hashCode() : 0);
        hash = 53 * hash + (this.codigoProfesor != null ? this.codigoProfesor.hashCode() : 0);
        hash = 53 * hash + (this.numContenido != null ? this.numContenido.hashCode() : 0);
        hash = 53 * hash + this.tipo;
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
        final SylabusContenidoPK other = (SylabusContenidoPK) obj;
        if (this.anio != other.anio) {
            return false;
        }
        if (this.ciclo != other.ciclo) {
            return false;
        }
        if (this.codigoMateria != other.codigoMateria) {
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
        if (this.codPrograma != other.codPrograma && (this.codPrograma == null || !this.codPrograma.equals(other.codPrograma))) {
            return false;
        }
        if (this.codigoProfesor != other.codigoProfesor) {
            return false;
        }
        if (this.numContenido != other.numContenido && (this.numContenido == null || !this.numContenido.equals(other.numContenido))) {
            return false;
        }
        return this.tipo == other.tipo;
    }

    @Override
    public String toString() {
        return "SylabusContenidoPK{" + "anio=" + anio + ", codigoMateria=" + codigoMateria + ", codigoNivel=" + codigoNivel + ", vacCodnum=" + vacCodnum + ", codParalelo=" + codParalelo + ", codPrograma=" + codPrograma + ", codigoProfesor=" + codigoProfesor + ", numContenido=" + numContenido + '}';
    }

}
