/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author johana.orozco
 */
@Entity
@Table(name = "PAIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p")})
public class Pais implements Serializable,Cloneable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "COD_PAIS")
    private String codPais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOM_PAIS")
    private String nomPais;
 

    public Pais() {
    }

    public Pais(String codPais) {
        this.codPais = codPais;
    }

    public Pais(String codPais, String nomPais) {
        this.codPais = codPais;
        this.nomPais = nomPais;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getNomPais() {
        return nomPais;
    }

    public void setNomPais(String nomPais) {
        this.nomPais = nomPais;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPais != null ? codPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.codPais == null && other.codPais != null) || (this.codPais != null && !this.codPais.equals(other.codPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pais{" + "codPais=" + codPais + ", nomPais=" + nomPais + '}';
    }

    @Override
    public Pais clone(){
        Pais obj=null;
        try{
            obj= (Pais) super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar Pais "+ex.getMessage());
        }
        return obj;
    }
    
}
