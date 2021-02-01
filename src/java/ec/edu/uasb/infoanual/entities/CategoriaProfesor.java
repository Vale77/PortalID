/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "CATEGORIA_PROFESOR")
@NamedQueries({
    @NamedQuery(name = "CategoriaProfesor.findAll", query = "SELECT c FROM CategoriaProfesor c")})
public class CategoriaProfesor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_CATEGORIA")
    private Long codigoCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_CATEGORIA")
    private String nombreCategoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_CATEGORIA")
    private BigDecimal valorCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaProfesor")
    private List<Profesor> profesorList;

    public CategoriaProfesor() {
    }

    public CategoriaProfesor(Long codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public CategoriaProfesor(Long codigoCategoria, String nombreCategoria, BigDecimal valorCategoria) {
        this.codigoCategoria = codigoCategoria;
        this.nombreCategoria = nombreCategoria;
        this.valorCategoria = valorCategoria;
    }

    public Long getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Long codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public BigDecimal getValorCategoria() {
        return valorCategoria;
    }

    public void setValorCategoria(BigDecimal valorCategoria) {
        this.valorCategoria = valorCategoria;
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
        hash += (codigoCategoria != null ? codigoCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaProfesor)) {
            return false;
        }
        CategoriaProfesor other = (CategoriaProfesor) object;
        if ((this.codigoCategoria == null && other.codigoCategoria != null) || (this.codigoCategoria != null && !this.codigoCategoria.equals(other.codigoCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CategoriaProfesor{" + "codigoCategoria=" + codigoCategoria + ", nombreCategoria=" + nombreCategoria + ", valorCategoria=" + valorCategoria + ", profesorList=" + profesorList + '}';
    }


    
}
