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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "CANTON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Canton.findAll", query = "SELECT c FROM Canton c"),
    @NamedQuery(name = "Canton.findByCodigoPais", query = "SELECT c FROM Canton c WHERE c.cantonPK.codigoPais = :codigoPais"),
    @NamedQuery(name = "Canton.findByCodigoProvincia", query = "SELECT c FROM Canton c WHERE c.cantonPK.codigoProvincia = :codigoProvincia"),
    @NamedQuery(name = "Canton.findByCodigoCanton", query = "SELECT c FROM Canton c WHERE c.cantonPK.codigoCanton = :codigoCanton"),
    @NamedQuery(name = "Canton.findByNombreCanton", query = "SELECT c FROM Canton c WHERE c.nombreCanton = :nombreCanton")})
public class Canton implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CantonPK cantonPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_CANTON")
    private String nombreCanton;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "canton")
    private Collection<Parroquia> parroquiaCollection;
    @JoinColumns({
        @JoinColumn(name = "CODIGO_PAIS", referencedColumnName = "CODIGO_PAIS", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGO_PROVINCIA", referencedColumnName = "CODIGO_PROVINCIA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Provincia provincia;

    public Canton() {
    }

    public Canton(CantonPK cantonPK) {
        this.cantonPK = cantonPK;
    }

    public Canton(CantonPK cantonPK, String nombreCanton) {
        this.cantonPK = cantonPK;
        this.nombreCanton = nombreCanton;
    }

    public Canton(String codigoPais, String codigoProvincia, String codigoCanton) {
        this.cantonPK = new CantonPK(codigoPais, codigoProvincia, codigoCanton);
    }

    public CantonPK getCantonPK() {
        return cantonPK;
    }

    public void setCantonPK(CantonPK cantonPK) {
        this.cantonPK = cantonPK;
    }

    public String getNombreCanton() {
        return nombreCanton;
    }

    public void setNombreCanton(String nombreCanton) {
        this.nombreCanton = nombreCanton;
    }

    @XmlTransient
    public Collection<Parroquia> getParroquiaCollection() {
        return parroquiaCollection;
    }

    public void setParroquiaCollection(Collection<Parroquia> parroquiaCollection) {
        this.parroquiaCollection = parroquiaCollection;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cantonPK != null ? cantonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Canton)) {
            return false;
        }
        Canton other = (Canton) object;
        if ((this.cantonPK == null && other.cantonPK != null) || (this.cantonPK != null && !this.cantonPK.equals(other.cantonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.portaldoc.entity.Canton[ cantonPK=" + cantonPK + " ]";
    }
    
}
