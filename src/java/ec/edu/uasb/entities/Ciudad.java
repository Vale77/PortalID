/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author johana.orozco
 */
@Entity
@Table(name = "CIUDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")})
public class Ciudad implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CiudadPK ciudadPK;
    @Size(max = 30)
    @Column(name = "NOM_CIUDAD")
    private String nomCiudad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PU_TRANSP")
    private BigDecimal puTransp;

    public Ciudad() {
    }

    public Ciudad(CiudadPK ciudadPK) {
        this.ciudadPK = ciudadPK;
    }

    public Ciudad(int codCiudad, String codPais) {
        this.ciudadPK = new CiudadPK(codCiudad, codPais);
    }

    public CiudadPK getCiudadPK() {
        return ciudadPK;
    }

    public void setCiudadPK(CiudadPK ciudadPK) {
        this.ciudadPK = ciudadPK;
    }

    public String getNomCiudad() {
        return nomCiudad;
    }

    public void setNomCiudad(String nomCiudad) {
        this.nomCiudad = nomCiudad;
    }

    public BigDecimal getPuTransp() {
        return puTransp;
    }

    public void setPuTransp(BigDecimal puTransp) {
        this.puTransp = puTransp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciudadPK != null ? ciudadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.ciudadPK == null && other.ciudadPK != null) || (this.ciudadPK != null && !this.ciudadPK.equals(other.ciudadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "ciudadPK=" + ciudadPK + ", nomCiudad=" + nomCiudad + ", puTransp=" + puTransp + '}';
    }

    @Override
    public Ciudad clone() {
        Ciudad obj = null;
        try {
            obj = (Ciudad) super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println(" no se puede duplicar Ciudad " + ex.getMessage());
        }
        return obj;
    }
}
