/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author victor.barba
 */
@Entity
@Table(name = "PROVINCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p"),
    @NamedQuery(name = "Provincia.findByCodigoPais", query = "SELECT p FROM Provincia p WHERE p.provinciaPK.codigoPais = :codigoPais order by p.nombreProvincia"),
    @NamedQuery(name = "Provincia.findByCodigoProvincia", query = "SELECT p FROM Provincia p WHERE p.provinciaPK.codigoProvincia = :codigoProvincia"),
    @NamedQuery(name = "Provincia.findByNombreProvincia", query = "SELECT p FROM Provincia p WHERE p.nombreProvincia = :nombreProvincia")})
public class Provincia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProvinciaPK provinciaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_PROVINCIA")
    private String nombreProvincia;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "provincia1")
    private Provincia provincia;
    @JoinColumns({
        @JoinColumn(name = "CODIGO_PAIS", referencedColumnName = "CODIGO_PAIS", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGO_PROVINCIA", referencedColumnName = "CODIGO_PROVINCIA", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Provincia provincia1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provincia")
    private Collection<Canton> cantonCollection;

    public Provincia() {
    }

    public Provincia(ProvinciaPK provinciaPK) {
        this.provinciaPK = provinciaPK;
    }

    public Provincia(ProvinciaPK provinciaPK, String nombreProvincia) {
        this.provinciaPK = provinciaPK;
        this.nombreProvincia = nombreProvincia;
    }

    public Provincia(String codigoPais, String codigoProvincia) {
        this.provinciaPK = new ProvinciaPK(codigoPais, codigoProvincia);
    }

    public ProvinciaPK getProvinciaPK() {
        return provinciaPK;
    }

    public void setProvinciaPK(ProvinciaPK provinciaPK) {
        this.provinciaPK = provinciaPK;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Provincia getProvincia1() {
        return provincia1;
    }

    public void setProvincia1(Provincia provincia1) {
        this.provincia1 = provincia1;
    }

    @XmlTransient
    public Collection<Canton> getCantonCollection() {
        return cantonCollection;
    }

    public void setCantonCollection(Collection<Canton> cantonCollection) {
        this.cantonCollection = cantonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provinciaPK != null ? provinciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) object;
        if ((this.provinciaPK == null && other.provinciaPK != null) || (this.provinciaPK != null && !this.provinciaPK.equals(other.provinciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.portaldoc.entity.Provincia[ provinciaPK=" + provinciaPK + " ]";
    }
    
}
