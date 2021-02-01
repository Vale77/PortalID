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
public class ConsulExternDocentePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIO")
    private long anio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CICLO")
    private long ciclo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_PROFESOR")
    private long codigoProfesor;

    public ConsulExternDocentePK() {
    }

    public ConsulExternDocentePK(long anio, long ciclo, long codigoProfesor) {
        this.anio = anio;
        this.ciclo = ciclo;
        this.codigoProfesor = codigoProfesor;
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

    public long getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(long codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) anio;
        hash += (int) ciclo;
        hash += (int) codigoProfesor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsulExternDocentePK)) {
            return false;
        }
        ConsulExternDocentePK other = (ConsulExternDocentePK) object;
        if (this.anio != other.anio) {
            return false;
        }
        if (this.ciclo != other.ciclo) {
            return false;
        }
        if (this.codigoProfesor != other.codigoProfesor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.infoanual.entities.ConsulExternDocentePK[ anio=" + anio + ", ciclo=" + ciclo + ", codigoProfesor=" + codigoProfesor + " ]";
    }
    
}
