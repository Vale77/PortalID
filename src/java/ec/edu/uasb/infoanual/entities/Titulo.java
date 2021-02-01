/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.entities;

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
@Table(name = "TITULO")
@NamedQueries({
    @NamedQuery(name = "Titulo.findAll", query = "SELECT t FROM Titulo t")})
public class Titulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_TITULO")
    private Long codigoTitulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_TITULO")
    private String nombreTitulo;
    @Size(max = 100)
    @Column(name = "NOMBRE_FEM_TITULO")
    private String nombreFemTitulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_TITULO")
    private char tipoTitulo;
    @Column(name = "TIPO_TITULO_POSGRADO")
    private Character tipoTituloPosgrado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "titulo")
    private List<TituloProfesor> tituloProfesorList;

    public Titulo() {
    }

    public String getnomtiptitulo() {
        String variable = "";     
            if (this.tipoTitulo == 'P') {
                variable = "PREGRADO";
            } else {
                if (this.tipoTitulo == 'G') {
                    variable = "POSGRADO";
                }
            }
        return variable;
    }    
    public Titulo(Long codigoTitulo) {
        this.codigoTitulo = codigoTitulo;
    }

    public Titulo(Long codigoTitulo, String nombreTitulo, char tipoTitulo) {
        this.codigoTitulo = codigoTitulo;
        this.nombreTitulo = nombreTitulo;
        this.tipoTitulo = tipoTitulo;
    }

    public Long getCodigoTitulo() {
        return codigoTitulo;
    }

    public void setCodigoTitulo(Long codigoTitulo) {
        this.codigoTitulo = codigoTitulo;
    }

    public String getNombreTitulo() {
        return nombreTitulo;
    }

    public void setNombreTitulo(String nombreTitulo) {
        this.nombreTitulo = nombreTitulo;
    }

    public String getNombreFemTitulo() {
        return nombreFemTitulo;
    }

    public void setNombreFemTitulo(String nombreFemTitulo) {
        this.nombreFemTitulo = nombreFemTitulo;
    }

    public char getTipoTitulo() {
        return tipoTitulo;
    }

    public void setTipoTitulo(char tipoTitulo) {
        this.tipoTitulo = tipoTitulo;
    }

    public Character getTipoTituloPosgrado() {
        return tipoTituloPosgrado;
    }

    public void setTipoTituloPosgrado(Character tipoTituloPosgrado) {
        this.tipoTituloPosgrado = tipoTituloPosgrado;
    }

    public List<TituloProfesor> getTituloProfesorList() {
        return tituloProfesorList;
    }

    public void setTituloProfesorList(List<TituloProfesor> tituloProfesorList) {
        this.tituloProfesorList = tituloProfesorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTitulo != null ? codigoTitulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Titulo)) {
            return false;
        }
        Titulo other = (Titulo) object;
        if ((this.codigoTitulo == null && other.codigoTitulo != null) || (this.codigoTitulo != null && !this.codigoTitulo.equals(other.codigoTitulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.infoanual.entities.Titulo[ codigoTitulo=" + codigoTitulo + " ]";
    }
    
}
