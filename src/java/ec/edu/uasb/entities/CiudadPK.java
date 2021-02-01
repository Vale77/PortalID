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
 * @author johana.orozco
 */
@Embeddable
public class CiudadPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIUDAD")
    private int codCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "COD_PAIS")
    private String codPais;

    public CiudadPK() {
    }

    public CiudadPK(int codCiudad, String codPais) {
        this.codCiudad = codCiudad;
        this.codPais = codPais;
    }

    public int getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(int codCiudad) {
        this.codCiudad = codCiudad;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCiudad;
        hash += (codPais != null ? codPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CiudadPK)) {
            return false;
        }
        CiudadPK other = (CiudadPK) object;
        if (this.codCiudad != other.codCiudad) {
            return false;
        }
        if ((this.codPais == null && other.codPais != null) || (this.codPais != null && !this.codPais.equals(other.codPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.infoanual.entities.CiudadPK[ codCiudad=" + codCiudad + ", codPais=" + codPais + " ]";
    }
    
}
