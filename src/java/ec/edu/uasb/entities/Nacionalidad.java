/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.entities;

import ec.edu.uasb.infoanual.entities.Profesor;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "NACIONALIDAD")
@NamedQueries({
    @NamedQuery(name = "Nacionalidad.findAll", query = "SELECT n FROM Nacionalidad n  order by n.nombreNacionalidad")})
public class Nacionalidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_NACIONALIDAD")
    private Long codigoNacionalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "NOMBRE_NACIONALIDAD")
    private String nombreNacionalidad;
    @Size(max = 60)
    @Column(name = "CONESUP_NACIONALIDAD")
    private String conesupNacionalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nacionalidad")
    private List<Profesor> profesorList;

    public Nacionalidad() {
    }

    public Nacionalidad(Long codigoNacionalidad) {
        this.codigoNacionalidad = codigoNacionalidad;
    }

    public Nacionalidad(Long codigoNacionalidad, String nombreNacionalidad) {
        this.codigoNacionalidad = codigoNacionalidad;
        this.nombreNacionalidad = nombreNacionalidad;
    }

    public Long getCodigoNacionalidad() {
        return codigoNacionalidad;
    }

    public void setCodigoNacionalidad(Long codigoNacionalidad) {
        this.codigoNacionalidad = codigoNacionalidad;
    }

    public String getNombreNacionalidad() {
        return nombreNacionalidad;
    }

    public void setNombreNacionalidad(String nombreNacionalidad) {
        this.nombreNacionalidad = nombreNacionalidad;
    }

    public String getConesupNacionalidad() {
        return conesupNacionalidad;
    }

    public void setConesupNacionalidad(String conesupNacionalidad) {
        this.conesupNacionalidad = conesupNacionalidad;
    }

    public List<Profesor> getProfesorList() {
        return profesorList;
    }

    public void setProfesorList(List<Profesor> profesorList) {
        this.profesorList = profesorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoNacionalidad != null ? codigoNacionalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nacionalidad)) {
            return false;
        }
        Nacionalidad other = (Nacionalidad) object;
        if ((this.codigoNacionalidad == null && other.codigoNacionalidad != null) || (this.codigoNacionalidad != null && !this.codigoNacionalidad.equals(other.codigoNacionalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nacionalidad{" + "codigoNacionalidad=" + codigoNacionalidad + ", nombreNacionalidad=" + nombreNacionalidad + ", conesupNacionalidad=" + conesupNacionalidad + ", profesorList=" + profesorList + '}';
    }


    
}
