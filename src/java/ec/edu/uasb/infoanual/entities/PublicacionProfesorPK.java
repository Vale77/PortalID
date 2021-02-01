/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author johana.orozco
 */
@Embeddable
public class PublicacionProfesorPK implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_PUBLICACION")
    private long codigoPublicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_PROFESOR")
    private long codigoProfesor;

    public PublicacionProfesorPK() {
    }

    public PublicacionProfesorPK(long codigoPublicacion, long codigoProfesor) {
        this.codigoPublicacion = codigoPublicacion;
        this.codigoProfesor = codigoProfesor;
    }

    public long getCodigoPublicacion() {
        return codigoPublicacion;
    }

    public void setCodigoPublicacion(long codigoPublicacion) {
        this.codigoPublicacion = codigoPublicacion;
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
        hash += (int) codigoPublicacion;
        hash += (int) codigoProfesor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicacionProfesorPK)) {
            return false;
        }
        PublicacionProfesorPK other = (PublicacionProfesorPK) object;
        if (this.codigoPublicacion != other.codigoPublicacion) {
            return false;
        }
        if (this.codigoProfesor != other.codigoProfesor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.infoanual.entities.PublicacionProfesorPK[ codigoPublicacion=" + codigoPublicacion + ", codigoProfesor=" + codigoProfesor + " ]";
    }
    
}
