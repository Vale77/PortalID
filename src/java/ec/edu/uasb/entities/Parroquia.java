/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author victor.barba
 */
@Entity
@Table(name = "PARROQUIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parroquia.findAll", query = "SELECT p FROM Parroquia p"),
    @NamedQuery(name = "Parroquia.findByCodigoPais", query = "SELECT p FROM Parroquia p WHERE p.parroquiaPK.codigoPais = :codigoPais"),
    @NamedQuery(name = "Parroquia.findByCodigoProvincia", query = "SELECT p FROM Parroquia p WHERE p.parroquiaPK.codigoProvincia = :codigoProvincia"),
    @NamedQuery(name = "Parroquia.findByCodigoCanton", query = "SELECT p FROM Parroquia p WHERE p.parroquiaPK.codigoCanton = :codigoCanton"),
    @NamedQuery(name = "Parroquia.findByCodigoParroquia", query = "SELECT p FROM Parroquia p WHERE p.parroquiaPK.codigoParroquia = :codigoParroquia"),
    @NamedQuery(name = "Parroquia.findByNombreParroquia", query = "SELECT p FROM Parroquia p WHERE p.nombreParroquia = :nombreParroquia")})
public class Parroquia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParroquiaPK parroquiaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_PARROQUIA")
    private String nombreParroquia;
    @JoinColumns({
        @JoinColumn(name = "CODIGO_PAIS", referencedColumnName = "CODIGO_PAIS", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGO_PROVINCIA", referencedColumnName = "CODIGO_PROVINCIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGO_CANTON", referencedColumnName = "CODIGO_CANTON", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Canton canton;

    public Parroquia() {
    }

    public Parroquia(ParroquiaPK parroquiaPK) {
        this.parroquiaPK = parroquiaPK;
    }

    public Parroquia(ParroquiaPK parroquiaPK, String nombreParroquia) {
        this.parroquiaPK = parroquiaPK;
        this.nombreParroquia = nombreParroquia;
    }

    public Parroquia(String codigoPais, String codigoProvincia, String codigoCanton, String codigoParroquia) {
        this.parroquiaPK = new ParroquiaPK(codigoPais, codigoProvincia, codigoCanton, codigoParroquia);
    }

    public ParroquiaPK getParroquiaPK() {
        return parroquiaPK;
    }

    public void setParroquiaPK(ParroquiaPK parroquiaPK) {
        this.parroquiaPK = parroquiaPK;
    }

    public String getNombreParroquia() {
        return nombreParroquia;
    }

    public void setNombreParroquia(String nombreParroquia) {
        this.nombreParroquia = nombreParroquia;
    }

    public Canton getCanton() {
        return canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parroquiaPK != null ? parroquiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parroquia)) {
            return false;
        }
        Parroquia other = (Parroquia) object;
        if ((this.parroquiaPK == null && other.parroquiaPK != null) || (this.parroquiaPK != null && !this.parroquiaPK.equals(other.parroquiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.portaldoc.entity.Parroquia[ parroquiaPK=" + parroquiaPK + " ]";
    }
    
}
