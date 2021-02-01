/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author johana.orozco
 */
@Embeddable
public class OtraActividadAcademicaPK implements Serializable {
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull    
    @Column(name = "CODIGO_ACTIVIDAD")
    private long codigoActividad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_PROFESOR")
    private long codigoProfesor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_OTRA_ACTIVIDAD")
    private char tipoOtraActividad;

    public OtraActividadAcademicaPK() {
    }

    public OtraActividadAcademicaPK(long codigoActividad, long codigoProfesor, char tipoOtraActividad) {
        this.codigoActividad = codigoActividad;
        this.codigoProfesor = codigoProfesor;
        this.tipoOtraActividad = tipoOtraActividad;
    }

    public long getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(long codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public long getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(long codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public char getTipoOtraActividad() {
        return tipoOtraActividad;
    }

    public void setTipoOtraActividad(char tipoOtraActividad) {
        this.tipoOtraActividad = tipoOtraActividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoActividad;
        hash += (int) codigoProfesor;
        hash += (int) tipoOtraActividad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OtraActividadAcademicaPK)) {
            return false;
        }
        OtraActividadAcademicaPK other = (OtraActividadAcademicaPK) object;
        if (this.codigoActividad != other.codigoActividad) {
            return false;
        }
        if (this.codigoProfesor != other.codigoProfesor) {
            return false;
        }
        if (this.tipoOtraActividad != other.tipoOtraActividad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.infoanual.entities.OtraActividadAcademicaPK[ codigoActividad=" + codigoActividad + ", codigoProfesor=" + codigoProfesor + ", tipoOtraActividad=" + tipoOtraActividad + " ]";
    }
    
}
