/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.entities;

import ec.edu.uasb.infoanual.entities.Escuela;
import ec.edu.uasb.infoanual.entities.OtraActividadAcademica;
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
@Table(name = "FACULTAD")
@NamedQueries({
    @NamedQuery(name = "Facultad.findAll", query = "SELECT f FROM Facultad f")})
public class Facultad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_FACULTAD")
    private Long codigoFacultad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "NOMBRE_FACULTAD")
    private String nombreFacultad;
    @Size(max = 60)
    @Column(name = "UBICACION_FACULTAD")
    private String ubicacionFacultad;
    @Size(max = 60)
    @Column(name = "NOMBRE_DECANO")
    private String nombreDecano;
    @Size(max = 60)
    @Column(name = "NOMBRE_SUBDECANO")
    private String nombreSubdecano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SIGLA_FACULTAD")
    private String siglaFacultad;
    @Size(max = 60)
    @Column(name = "EMAIL_ENVIO")
    private String emailEnvio;
    @Size(max = 60)
    @Column(name = "EMAIL_COPIA")
    private String emailCopia;
    @Column(name = "CODIGO_PROFESOR")
    private Long codigoProfesor;
    @OneToMany(mappedBy = "facultad")
    private List<Profesor> profesorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facultad")
    private List<Escuela> escuelaList;
    @OneToMany(mappedBy = "facultad")
    private List<OtraActividadAcademica> otraActividadAcademicaList;

    public Facultad() {
    }

    public Facultad(Long codigoFacultad) {
        this.codigoFacultad = codigoFacultad;
    }

    public Facultad(Long codigoFacultad, String nombreFacultad, String siglaFacultad) {
        this.codigoFacultad = codigoFacultad;
        this.nombreFacultad = nombreFacultad;
        this.siglaFacultad = siglaFacultad;
    }

    public Long getCodigoFacultad() {
        return codigoFacultad;
    }

    public void setCodigoFacultad(Long codigoFacultad) {
        this.codigoFacultad = codigoFacultad;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }

    public String getUbicacionFacultad() {
        return ubicacionFacultad;
    }

    public void setUbicacionFacultad(String ubicacionFacultad) {
        this.ubicacionFacultad = ubicacionFacultad;
    }

    public String getNombreDecano() {
        return nombreDecano;
    }

    public void setNombreDecano(String nombreDecano) {
        this.nombreDecano = nombreDecano;
    }

    public String getNombreSubdecano() {
        return nombreSubdecano;
    }

    public void setNombreSubdecano(String nombreSubdecano) {
        this.nombreSubdecano = nombreSubdecano;
    }

    public String getSiglaFacultad() {
        return siglaFacultad;
    }

    public void setSiglaFacultad(String siglaFacultad) {
        this.siglaFacultad = siglaFacultad;
    }

    public String getEmailEnvio() {
        return emailEnvio;
    }

    public void setEmailEnvio(String emailEnvio) {
        this.emailEnvio = emailEnvio;
    }

    public String getEmailCopia() {
        return emailCopia;
    }

    public void setEmailCopia(String emailCopia) {
        this.emailCopia = emailCopia;
    }

    public Long getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(Long codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public List<Profesor> getProfesorList() {
        return profesorList;
    }

    public void setProfesorList(List<Profesor> profesorList) {
        this.profesorList = profesorList;
    }

    public List<Escuela> getEscuelaList() {
        return escuelaList;
    }

    public void setEscuelaList(List<Escuela> escuelaList) {
        this.escuelaList = escuelaList;
    }

    public List<OtraActividadAcademica> getOtraActividadAcademicaList() {
        return otraActividadAcademicaList;
    }

    public void setOtraActividadAcademicaList(List<OtraActividadAcademica> otraActividadAcademicaList) {
        this.otraActividadAcademicaList = otraActividadAcademicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoFacultad != null ? codigoFacultad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facultad)) {
            return false;
        }
        Facultad other = (Facultad) object;
        if ((this.codigoFacultad == null && other.codigoFacultad != null) || (this.codigoFacultad != null && !this.codigoFacultad.equals(other.codigoFacultad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.infoanual.entities.Facultad[ codigoFacultad=" + codigoFacultad + " ]";
    }
    
}
