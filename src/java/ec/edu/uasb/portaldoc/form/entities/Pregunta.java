/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.form.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "PREGUNTA",schema = "EVALUACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p"),
    @NamedQuery(name = "Pregunta.findByCodigoPregunta", query = "SELECT p FROM Pregunta p WHERE p.preguntaPK.codigoPregunta = :codigoPregunta"),
    @NamedQuery(name = "Pregunta.findByCodigoEncuesta", query = "SELECT p FROM Pregunta p WHERE p.preguntaPK.codigoEncuesta = :codigoEncuesta order by p.formato"),
    @NamedQuery(name = "Pregunta.findByPreguntaPadre", query = "SELECT p FROM Pregunta p WHERE p.preguntaPadre = :preguntaPadre"),
    @NamedQuery(name = "Pregunta.findByDescripcion", query = "SELECT p FROM Pregunta p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Pregunta.findByReferencia", query = "SELECT p FROM Pregunta p WHERE p.referencia = :referencia"),
    @NamedQuery(name = "Pregunta.findByTipo", query = "SELECT p FROM Pregunta p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Pregunta.findByPeso", query = "SELECT p FROM Pregunta p WHERE p.peso = :peso"),
    @NamedQuery(name = "Pregunta.findByFormato", query = "SELECT p FROM Pregunta p WHERE p.formato = :formato"),
    @NamedQuery(name = "Pregunta.findByNivel", query = "SELECT p FROM Pregunta p WHERE p.nivel = :nivel")})
public class Pregunta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PreguntaPK preguntaPK;
    @Column(name = "PREGUNTA_PADRE")
    private Long preguntaPadre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 20)
    @Column(name = "REFERENCIA")
    private String referencia;
    @Column(name = "TIPO")
    private Character tipo;
    @Column(name = "PESO")
    private Long peso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FORMATO")
    private String formato;
    @Column(name = "NIVEL")
    private Long nivel;
    @JoinColumn(name = "CODIGO_ENCUESTA", referencedColumnName = "CODIGO_ENCUESTA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Encuesta encuesta;

    public Pregunta() {
    }

    public Pregunta(PreguntaPK preguntaPK) {
        this.preguntaPK = preguntaPK;
    }

    public Pregunta(PreguntaPK preguntaPK, String descripcion, String formato) {
        this.preguntaPK = preguntaPK;
        this.descripcion = descripcion;
        this.formato = formato;
    }

    public Pregunta(long codigoPregunta, long codigoEncuesta) {
        this.preguntaPK = new PreguntaPK(codigoPregunta, codigoEncuesta);
    }

    public PreguntaPK getPreguntaPK() {
        return preguntaPK;
    }

    public void setPreguntaPK(PreguntaPK preguntaPK) {
        this.preguntaPK = preguntaPK;
    }

    public Long getPreguntaPadre() {
        return preguntaPadre;
    }

    public void setPreguntaPadre(Long preguntaPadre) {
        this.preguntaPadre = preguntaPadre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Long getPeso() {
        return peso;
    }

    public void setPeso(Long peso) {
        this.peso = peso;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Long getNivel() {
        return nivel;
    }

    public void setNivel(Long nivel) {
        this.nivel = nivel;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preguntaPK != null ? preguntaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.preguntaPK == null && other.preguntaPK != null) || (this.preguntaPK != null && !this.preguntaPK.equals(other.preguntaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.entity.Pregunta[ preguntaPK=" + preguntaPK + " ]";
    }
    
}
