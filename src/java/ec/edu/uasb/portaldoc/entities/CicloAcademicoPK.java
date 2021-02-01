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
public class CicloAcademicoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIO")
    private long anio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CICLO")
    private long ciclo;

    public CicloAcademicoPK() {
    }

    public CicloAcademicoPK(long anio, long ciclo) {
        this.anio = anio;
        this.ciclo = ciclo;
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
        hash += (int) anio;
        hash += (int) ciclo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CicloAcademicoPK)) {
            return false;
        }
        CicloAcademicoPK other = (CicloAcademicoPK) object;
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
        return "ec.edu.uasb.portaldoc.entity.CicloAcademicoPK[ anio=" + anio + ", ciclo=" + ciclo + " ]";
    }
    
}
