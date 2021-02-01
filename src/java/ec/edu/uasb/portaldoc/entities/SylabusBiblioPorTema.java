/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author victor.barba
 */
@Entity
public class SylabusBiblioPorTema implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CON_ANIO")
    private int conAnio;
    @Column(name = "CON_CICLO")
    private int conCiclo;
    @Column(name = "CON_CODIGO_MATERIA")
    private long conCodigoMateria;
    @Column(name = "CON_CODIGO_PROFESOR")
    private long conCodigoProfesor;
    @Column(name = "CON_CODIGO_NIVEL")
    private Long conCodigoNivel;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CON_NUM_CONTENIDO")
    private Long conNumContenido;
    @Size(max = 8000)
    @Column(name = "CON_TEMA")
    private String tema;
    @Size(max = 8000)
    @Column(name = "BIBLIOGRAFIA")
    private String bibliograf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIO")
    private int anio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CICLO")
    private int ciclo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_MATERIA")
    private long codigoMateria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_PROFESOR")
    private long codigoProfesor;
    @Column(name = "CODIGO_NIVEL")
    private Long codigoNivel;
    @Column(name = "NUM_CONTENIDO")
    private Long numContenido;
    @Size(max = 8000)
    @Column(name = "SUBTEMA")
    private String subtema;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO")
    private char tipo;

    public SylabusBiblioPorTema() {
    }

    public SylabusBiblioPorTema(int conAnio, int conCiclo, long conCodigoMateria, long conCodigoProfesor, Long conCodigoNivel, Long conNumContenido,
            String tema, String bibliograf, int anio, int ciclo, long codigoMateria, long codigoProfesor, Long codigoNivel, Long numContenido,
            String subtema, char tipo) {
        this.conAnio = conAnio;
        this.conCiclo = conCiclo;
        this.conCodigoMateria = conCodigoMateria;
        this.conCodigoProfesor = conCodigoProfesor;
        this.conCodigoNivel = conCodigoNivel;
        this.conNumContenido = conNumContenido;
        this.tema = tema;
        this.bibliograf = bibliograf;
        this.anio = anio;
        this.ciclo = ciclo;
        this.codigoMateria = codigoMateria;
        this.codigoProfesor = codigoProfesor;
        this.codigoNivel = codigoNivel;
        this.numContenido = numContenido;
        this.subtema = subtema;
        this.tipo = tipo;
    }

    public int getConAnio() {
        return conAnio;
    }

    public void setConAnio(int conAnio) {
        this.conAnio = conAnio;
    }

    public int getConCiclo() {
        return conCiclo;
    }

    public void setConCiclo(int conCiclo) {
        this.conCiclo = conCiclo;
    }

    public long getConCodigoMateria() {
        return conCodigoMateria;
    }

    public void setConCodigoMateria(long conCodigoMateria) {
        this.conCodigoMateria = conCodigoMateria;
    }

    public long getConCodigoProfesor() {
        return conCodigoProfesor;
    }

    public void setConCodigoProfesor(long conCodigoProfesor) {
        this.conCodigoProfesor = conCodigoProfesor;
    }

    public Long getConCodigoNivel() {
        return conCodigoNivel;
    }

    public void setConCodigoNivel(Long conCodigoNivel) {
        this.conCodigoNivel = conCodigoNivel;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getBibliograf() {
        return bibliograf;
    }

    public void setBibliograf(String bibliograf) {
        this.bibliograf = bibliograf;
    }

    public Long getConNumContenido() {
        return conNumContenido;
    }

    public void setConNumContenido(Long conNumContenido) {
        this.conNumContenido = conNumContenido;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public long getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(long codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public long getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(long codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public Long getCodigoNivel() {
        return codigoNivel;
    }

    public void setCodigoNivel(Long codigoNivel) {
        this.codigoNivel = codigoNivel;
    }

    public Long getNumContenido() {
        return numContenido;
    }

    public void setNumContenido(Long numContenido) {
        this.numContenido = numContenido;
    }

    public String getSubtema() {
        return subtema;
    }

    public void setSubtema(String subtema) {
        this.subtema = subtema;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (int) (this.conNumContenido ^ (this.conNumContenido >>> 32));
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
        final SylabusBiblioPorTema other = (SylabusBiblioPorTema) obj;
        if (this.conNumContenido != other.conNumContenido) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SylabusBiblioPorTema{" + "conAnio=" + conAnio + ", conCiclo=" + conCiclo + ", conCodigoMateria=" + conCodigoMateria + ", conCodigoProfesor=" + conCodigoProfesor + ", conCodigoNivel=" + conCodigoNivel + ", conNumContenido=" + conNumContenido + ", tema=" + tema + ", bibliograf=" + bibliograf + ", anio=" + anio + ", ciclo=" + ciclo + ", codigoMateria=" + codigoMateria + ", codigoProfesor=" + codigoProfesor + ", codigoNivel=" + codigoNivel + ", numContenido=" + numContenido + ", subtema=" + subtema + ", tipo=" + tipo + '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
