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
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author victor.barba
 */
@Entity
@Table(name = "SYLABUS_CONTENIDO")
@XmlRootElement
@NamedQuery(name = "SylabusContenido.findById", query = "SELECT c FROM SylabusContenido c where c.sylabusContenidoPK.numContenido = :idContenido ")
public class SylabusContenido implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SylabusContenidoPK sylabusContenidoPK;

    @Size(max = 8000)
    @Column(name = "TEMA")
    private String tema;
    @Size(max = 100)
    @Column(name = "CLASE")
    private String clase;
    @Size(max = 8000)
    @Column(name = "SUBTEMA")
    private String subtema;
    @Size(max = 8000)
    @Column(name = "BIBLIOGRAFIA")
    private String biblioTema;
    @Column(name = "ORDEN")
    private Integer orden;
    @Transient 
    private Integer numClases;
 

    public Integer getclaseint() {
        Integer variable = null;
        if (this.clase != null) {
            variable = Integer.parseInt(this.clase);
        }
        return variable;
    }

    public SylabusContenido() {
    }

    public SylabusContenido(SylabusContenidoPK sylabusContenidoPK) {
        this.sylabusContenidoPK = sylabusContenidoPK;
    }

    public SylabusContenido(Long anio, Long ciclo, Long codigoMateria, Long codNivel, Long vacCodnum, Long codParalelo, Long codPrograma, Long codigoProfesor, Long numContenido, char tipo) {
        this.sylabusContenidoPK = new SylabusContenidoPK(anio, ciclo, codigoMateria, codNivel, vacCodnum, codParalelo, codPrograma, codigoProfesor, numContenido, tipo);
    }

    public SylabusContenidoPK getSylabusContenidoPK() {
        return sylabusContenidoPK;
    }

    public void setSylabusContenidoPK(SylabusContenidoPK sylabusContenidoPK) {
        this.sylabusContenidoPK = sylabusContenidoPK;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getSubtema() {
        return subtema;
    }

    public void setSubtema(String subtema) {
        this.subtema = subtema;
    }

    public String getBiblioTema() {
        return biblioTema;
    }

    public void setBiblioTema(String biblioTema) {
        this.biblioTema = biblioTema;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getNumClases() {
        return numClases;
    }

    public void setNumClases(Integer numClases) {
        this.numClases = numClases;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sylabusContenidoPK != null ? sylabusContenidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SylabusContenido)) {
            return false;
        }
        SylabusContenido other = (SylabusContenido) object;
        return !((this.sylabusContenidoPK == null && other.sylabusContenidoPK != null) || (this.sylabusContenidoPK != null && !this.sylabusContenidoPK.equals(other.sylabusContenidoPK)));
    }

    @Override
    public String toString() {
        return "SylabusContenido{" + "sylabusContenidoPK=" + sylabusContenidoPK + ", tema=" + tema + ", clase=" + clase + ", subtema=" + subtema + ", biblioTema=" + biblioTema + ", orden=" + orden + '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
