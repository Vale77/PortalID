/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author victor.barba
 */
@Embeddable
public class ParroquiaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODIGO_PAIS")
    private String codigoPais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CODIGO_PROVINCIA")
    private String codigoProvincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CODIGO_CANTON")
    private String codigoCanton;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CODIGO_PARROQUIA")
    private String codigoParroquia;

    public ParroquiaPK() {
    }

    public ParroquiaPK(String codigoPais, String codigoProvincia, String codigoCanton, String codigoParroquia) {
        this.codigoPais = codigoPais;
        this.codigoProvincia = codigoProvincia;
        this.codigoCanton = codigoCanton;
        this.codigoParroquia = codigoParroquia;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public String getCodigoCanton() {
        return codigoCanton;
    }

    public void setCodigoCanton(String codigoCanton) {
        this.codigoCanton = codigoCanton;
    }

    public String getCodigoParroquia() {
        return codigoParroquia;
    }

    public void setCodigoParroquia(String codigoParroquia) {
        this.codigoParroquia = codigoParroquia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPais != null ? codigoPais.hashCode() : 0);
        hash += (codigoProvincia != null ? codigoProvincia.hashCode() : 0);
        hash += (codigoCanton != null ? codigoCanton.hashCode() : 0);
        hash += (codigoParroquia != null ? codigoParroquia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParroquiaPK)) {
            return false;
        }
        ParroquiaPK other = (ParroquiaPK) object;
        if ((this.codigoPais == null && other.codigoPais != null) || (this.codigoPais != null && !this.codigoPais.equals(other.codigoPais))) {
            return false;
        }
        if ((this.codigoProvincia == null && other.codigoProvincia != null) || (this.codigoProvincia != null && !this.codigoProvincia.equals(other.codigoProvincia))) {
            return false;
        }
        if ((this.codigoCanton == null && other.codigoCanton != null) || (this.codigoCanton != null && !this.codigoCanton.equals(other.codigoCanton))) {
            return false;
        }
        if ((this.codigoParroquia == null && other.codigoParroquia != null) || (this.codigoParroquia != null && !this.codigoParroquia.equals(other.codigoParroquia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.portaldoc.entity.ParroquiaPK[ codigoPais=" + codigoPais + ", codigoProvincia=" + codigoProvincia + ", codigoCanton=" + codigoCanton + ", codigoParroquia=" + codigoParroquia + " ]";
    }
    
}
