/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author victor.barba
 */
@Entity
@Table(name = "SYLABUS_BIBLIO")
@XmlRootElement
@NamedQuery(name = "SylabusBiblio.findById", query = "SELECT b FROM SylabusBiblio b where b.sylabusBiblioPK.numeroBiblio = :idBiblio ")
public class SylabusBiblio implements Serializable,Cloneable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SylabusBiblioPK sylabusBiblioPK;
    @Size(max = 8000)
    @Column(name = "BIBLIOGRAFIA")
    private String bibliografia;

    public SylabusBiblio() {
    }

    public SylabusBiblio(SylabusBiblioPK sylabusBiblioPK) {
        this.sylabusBiblioPK = sylabusBiblioPK;
    }

    public SylabusBiblio(SylabusBiblioPK sylabusBiblioPK, String bibliografia) {
        this.sylabusBiblioPK = sylabusBiblioPK;
        this.bibliografia = bibliografia;
    }

    public SylabusBiblioPK getSylabusBiblioPK() {
        return sylabusBiblioPK;
    }

    public void setSylabusBiblioPK(SylabusBiblioPK sylabusBiblioPK) {
        this.sylabusBiblioPK = sylabusBiblioPK;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.sylabusBiblioPK != null ? this.sylabusBiblioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SylabusBiblio other = (SylabusBiblio) obj;
        if (this.sylabusBiblioPK != other.sylabusBiblioPK && (this.sylabusBiblioPK == null || !this.sylabusBiblioPK.equals(other.sylabusBiblioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SylabusBiblio{" + "sylabusBiblioPK=" + sylabusBiblioPK + ", bibliografia=" + bibliografia + '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
