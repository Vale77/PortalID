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
public class EscuelaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_FACULTAD")
    private long codigoFacultad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_ESCUELA")
    private long codigoEscuela;

    public EscuelaPK() {
    }

    public EscuelaPK(long codigoFacultad, long codigoEscuela) {
        this.codigoFacultad = codigoFacultad;
        this.codigoEscuela = codigoEscuela;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoFacultad;
        hash += (int) codigoEscuela;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscuelaPK)) {
            return false;
        }
        EscuelaPK other = (EscuelaPK) object;
        if (this.codigoFacultad != other.codigoFacultad) {
            return false;
        }
        if (this.codigoEscuela != other.codigoEscuela) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.infoanual.entities.EscuelaPK[ codigoFacultad=" + codigoFacultad + ", codigoEscuela=" + codigoEscuela + " ]";
    }
    
}
