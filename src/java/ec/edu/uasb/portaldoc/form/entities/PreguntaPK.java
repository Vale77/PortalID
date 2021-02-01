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
public class PreguntaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_PREGUNTA")
    private long codigoPregunta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_ENCUESTA")
    private long codigoEncuesta;

    public PreguntaPK() {
    }

    public PreguntaPK(long codigoPregunta, long codigoEncuesta) {
        this.codigoPregunta = codigoPregunta;
        this.codigoEncuesta = codigoEncuesta;
    }

    public long getCodigoPregunta() {
        return codigoPregunta;
    }

    public void setCodigoPregunta(long codigoPregunta) {
        this.codigoPregunta = codigoPregunta;
    }

    public long getCodigoEncuesta() {
        return codigoEncuesta;
    }

    public void setCodigoEncuesta(long codigoEncuesta) {
        this.codigoEncuesta = codigoEncuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoPregunta;
        hash += (int) codigoEncuesta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntaPK)) {
            return false;
        }
        PreguntaPK other = (PreguntaPK) object;
        if (this.codigoPregunta != other.codigoPregunta) {
            return false;
        }
        if (this.codigoEncuesta != other.codigoEncuesta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.entity.PreguntaPK[ codigoPregunta=" + codigoPregunta + ", codigoEncuesta=" + codigoEncuesta + " ]";
    }
    
}
