/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author johana.orozco
 */
@Embeddable
public class EspecializacionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_NIVEACAD")
    private long codigoNiveacad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_FACULTAD")
    private long codigoFacultad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_ESCUELA")
    private long codigoEscuela;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_ESP")
    private long codigoEsp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIO")
    private long anio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CICLO")
    private long ciclo;

    public EspecializacionPK() {
    }

    public EspecializacionPK(long codigoNiveacad, long codigoFacultad, long codigoEscuela, long codigoEsp, long anio, long ciclo) {
        this.codigoNiveacad = codigoNiveacad;
        this.codigoFacultad = codigoFacultad;
        this.codigoEscuela = codigoEscuela;
        this.codigoEsp = codigoEsp;
        this.anio = anio;
        this.ciclo = ciclo;
    }

    public long getCodigoNiveacad() {
        return codigoNiveacad;
    }

    public void setCodigoNiveacad(long codigoNiveacad) {
        this.codigoNiveacad = codigoNiveacad;
    }

    public long getCodigoFacultad() {
        return codigoFacultad;
    }

    public void setCodigoFacultad(long codigoFacultad) {
        this.codigoFacultad = codigoFacultad;
    }

    public long getCodigoEscuela() {
        return codigoEscuela;
    }

    public void setCodigoEscuela(long codigoEscuela) {
        this.codigoEscuela = codigoEscuela;
    }

    public long getCodigoEsp() {
        return codigoEsp;
    }

    public void setCodigoEsp(long codigoEsp) {
        this.codigoEsp = codigoEsp;
    }

    public long getAnio() {
        return anio;
    }

    public void setAnio(long anio) {
        this.anio = anio;
    }

    public long getCiclo() {
        return ciclo;
    }

    public void setCiclo(long ciclo) {
        this.ciclo = ciclo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoNiveacad;
        hash += (int) codigoFacultad;
        hash += (int) codigoEscuela;
        hash += (int) codigoEsp;
        hash += (int) anio;
        hash += (int) ciclo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspecializacionPK)) {
            return false;
        }
        EspecializacionPK other = (EspecializacionPK) object;
        if (this.codigoNiveacad != other.codigoNiveacad) {
            return false;
        }
        if (this.codigoFacultad != other.codigoFacultad) {
            return false;
        }
        if (this.codigoEscuela != other.codigoEscuela) {
            return false;
        }
        if (this.codigoEsp != other.codigoEsp) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        if (this.ciclo != other.ciclo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.infoanual.entities.EspecializacionPK[ codigoNiveacad=" + codigoNiveacad + ", codigoFacultad=" + codigoFacultad + ", codigoEscuela=" + codigoEscuela + ", codigoEsp=" + codigoEsp + ", anio=" + anio + ", ciclo=" + ciclo + " ]";
    }
    
}
