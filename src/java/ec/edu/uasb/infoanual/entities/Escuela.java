/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.entities;

import ec.edu.uasb.entities.Facultad;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author johana.orozco
 */
@Entity
@Table(name = "ESCUELA")
@NamedQueries({
    @NamedQuery(name = "Escuela.findAll", query = "SELECT e FROM Escuela e")})
public class Escuela implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EscuelaPK escuelaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "NOMBRE_ESCUELA")
    private String nombreEscuela;
    @Size(max = 60)
    @Column(name = "UBIC_ESCUELA")
    private String ubicEscuela;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR_CREDITO")
    private BigDecimal valorCredito;
    @Size(max = 30)
    @Column(name = "NOMBRE_DIRECTOR")
    private String nombreDirector;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PENSUM")
    private char pensum;
    @JoinColumn(name = "CODIGO_FACULTAD", referencedColumnName = "CODIGO_FACULTAD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Facultad facultad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escuela")
    private List<Especializacion> especializacionList;

    public Escuela() {
    }

    public Escuela(EscuelaPK escuelaPK) {
        this.escuelaPK = escuelaPK;
    }

    public Escuela(EscuelaPK escuelaPK, String nombreEscuela, char pensum) {
        this.escuelaPK = escuelaPK;
        this.nombreEscuela = nombreEscuela;
        this.pensum = pensum;
    }

    public Escuela(long codigoFacultad, long codigoEscuela) {
        this.escuelaPK = new EscuelaPK(codigoFacultad, codigoEscuela);
    }

    public EscuelaPK getEscuelaPK() {
        return escuelaPK;
    }

    public void setEscuelaPK(EscuelaPK escuelaPK) {
        this.escuelaPK = escuelaPK;
    }

    public String getNombreEscuela() {
        return nombreEscuela;
    }

    public void setNombreEscuela(String nombreEscuela) {
        this.nombreEscuela = nombreEscuela;
    }

    public String getUbicEscuela() {
        return ubicEscuela;
    }

    public void setUbicEscuela(String ubicEscuela) {
        this.ubicEscuela = ubicEscuela;
    }

    public BigDecimal getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(BigDecimal valorCredito) {
        this.valorCredito = valorCredito;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public char getPensum() {
        return pensum;
    }

    public void setPensum(char pensum) {
        this.pensum = pensum;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public List<Especializacion> getEspecializacionList() {
        return especializacionList;
    }

    public void setEspecializacionList(List<Especializacion> especializacionList) {
        this.especializacionList = especializacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (escuelaPK != null ? escuelaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escuela)) {
            return false;
        }
        Escuela other = (Escuela) object;
        if ((this.escuelaPK == null && other.escuelaPK != null) || (this.escuelaPK != null && !this.escuelaPK.equals(other.escuelaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.infoanual.entities.Escuela[ escuelaPK=" + escuelaPK + " ]";
    }
    
}
