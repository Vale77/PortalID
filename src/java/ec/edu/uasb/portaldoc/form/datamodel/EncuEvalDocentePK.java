/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.form.datamodel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author victor.barba
 */
@Embeddable
public class EncuEvalDocentePK implements Serializable {

    @Column(name = "CODIGO_PROFESOR")
    private Long codigoProfesor;
    @Column(name = "CODIGO_MATERIA")
    private Long codigoMateria;
    @Column(name = "CODIGO_ESP")
    private Long codigoEsp;
    @Column(name = "CODIGO_NIVEL")
    private Long codigoNivel;
    @Column(name = "CODIGO_PARALELO")
    private Long codigoParalelo;
    @Column(name = "ANIO")
    private Long anio;

    public Long getCodigoNivel() {
        return codigoNivel;
    }

    public void setCodigoNivel(Long codigoNivel) {
        this.codigoNivel = codigoNivel;
    }

    public EncuEvalDocentePK() {
    }

    public Long getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(Long codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public Long getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(Long codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public Long getCodigoEsp() {
        return codigoEsp;
    }

    public void setCodigoEsp(Long codigoEsp) {
        this.codigoEsp = codigoEsp;
    }

    public Long getCodigoParalelo() {
        return codigoParalelo;
    }

    public void setCodigoParalelo(Long codigoParalelo) {
        this.codigoParalelo = codigoParalelo;
    }

    public Long getAnio() {
        return anio;
    }

    public void setAnio(Long anio) {
        this.anio = anio;
    }

    public EncuEvalDocentePK(Long codigoProfesor, Long codigoMateria, Long codigoEsp, Long codigoNivel, Long codigoParalelo, Long anio) {
        this.codigoProfesor = codigoProfesor;
        this.codigoMateria = codigoMateria;
        this.codigoEsp = codigoEsp;
        this.codigoNivel = codigoNivel;
        this.codigoParalelo = codigoParalelo;
        this.anio = anio;
    }

    @Override
    public String toString() {
        return codigoProfesor + "-" + codigoMateria + ";" + codigoEsp + ":" + codigoNivel + "_" + codigoParalelo+"@"+anio;
    }

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (this.codigoProfesor != null ? this.codigoProfesor.hashCode() : 0);
        hash = 13 * hash + (this.codigoMateria != null ? this.codigoMateria.hashCode() : 0);
        hash = 13 * hash + (this.codigoEsp != null ? this.codigoEsp.hashCode() : 0);
        hash = 13 * hash + (this.codigoNivel != null ? this.codigoNivel.hashCode() : 0);
        hash = 13 * hash + (this.codigoParalelo != null ? this.codigoParalelo.hashCode() : 0);
        hash = 13 * hash + (this.anio != null ? this.anio.hashCode() : 0);
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
        final EncuEvalDocentePK other = (EncuEvalDocentePK) obj;
        if (this.codigoProfesor != other.codigoProfesor && (this.codigoProfesor == null || !this.codigoProfesor.equals(other.codigoProfesor))) {
            return false;
        }
        if (this.codigoMateria != other.codigoMateria && (this.codigoMateria == null || !this.codigoMateria.equals(other.codigoMateria))) {
            return false;
        }
        if (this.codigoEsp != other.codigoEsp && (this.codigoEsp == null || !this.codigoEsp.equals(other.codigoEsp))) {
            return false;
        }
        if (this.codigoNivel != other.codigoNivel && (this.codigoNivel == null || !this.codigoNivel.equals(other.codigoNivel))) {
            return false;
        }
        if (this.codigoParalelo != other.codigoParalelo && (this.codigoParalelo == null || !this.codigoParalelo.equals(other.codigoParalelo))) {
            return false;
        }
        if (this.anio != other.anio && (this.anio == null || !this.anio.equals(other.anio))) {
            return false;
        }
        return true;
    }

}
