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
public class TituloProfesorPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_TITULO")
    private long codigoTitulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_PROFESOR")
    private long codigoProfesor;

    public TituloProfesorPK() {
    }

    public TituloProfesorPK(long codigoTitulo, long codigoProfesor) {
        this.codigoTitulo = codigoTitulo;
        this.codigoProfesor = codigoProfesor;
    }

    public long getCodigoTitulo() {
        return codigoTitulo;
    }

    public void setCodigoTitulo(long codigoTitulo) {
        this.codigoTitulo = codigoTitulo;
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
        hash += (int) codigoTitulo;
        hash += (int) codigoProfesor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TituloProfesorPK)) {
            return false;
        }
        TituloProfesorPK other = (TituloProfesorPK) object;
        if (this.codigoTitulo != other.codigoTitulo) {
            return false;
        }
        if (this.codigoProfesor != other.codigoProfesor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.infoanual.entities.TituloProfesorPK[ codigoTitulo=" + codigoTitulo + ", codigoProfesor=" + codigoProfesor + " ]";
    }
    
}
