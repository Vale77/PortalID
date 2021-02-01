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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author johana.orozco
 */
@Entity
@Table(name = "AREA_VINCOLECTIVIDAD")
//@NamedQueries({
//    @NamedQuery(name = "areaVincolectividad.findAll", query = "SELECT f FROM areaVincolectividad f")})

public class AreaVincolectividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AVC_CODIGO")
    private Long avcCodigo;
   
    @Column(name = "AVC_NOMBRE")
    private String avcNombre;    
    @Size(max = 200)
     @Column(name = "CODIGO_FACULTAD")
    private Long codigoFacultad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaVinculacion")
    private List<DetalleVincolectividad> detareaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaVinculacion")
    private List<OtraActividadAcademica> otraActividadList;
    

    public AreaVincolectividad() {
    }

    public AreaVincolectividad(Long avcCodigo) {
        this.avcCodigo = avcCodigo;
    }

    public AreaVincolectividad(Long avcCodigo, String avcNombre) {
        this.avcCodigo = avcCodigo;
        this.avcNombre = avcNombre;
        
    }

    public Long getAvcCodigo() {
        return avcCodigo;
    }

    public void setAvcCodigo(Long avcCodigo) {
        this.avcCodigo = avcCodigo;
    }

    public String getAvcNombre() {
        return avcNombre;
    }

    public void setAvcNombre(String avcNombre) {
        this.avcNombre = avcNombre;
    }

    public List<DetalleVincolectividad> getDetareaList() {
        return detareaList;
    }

    public void setDetareaList(List<DetalleVincolectividad> detareaList) {
        this.detareaList = detareaList;
    }

    public Long getCodigoFacultad() {
        return codigoFacultad;
    }

    public void setCodigoFacultad(Long codigoFacultad) {
        this.codigoFacultad = codigoFacultad;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (avcCodigo != null ? avcCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaVincolectividad)) {
            return false;
        }
        AreaVincolectividad other = (AreaVincolectividad) object;
        if ((this.avcCodigo == null && other.avcCodigo != null) || (this.avcCodigo != null && !this.avcCodigo.equals(other.avcCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.infoanual.entities.AreaVincolectividad[ avcCodigo=" + avcCodigo + " ]";
    }

    public List<OtraActividadAcademica> getOtraActividadList() {
        return otraActividadList;
    }

    public void setOtraActividadList(List<OtraActividadAcademica> otraActividadList) {
        this.otraActividadList = otraActividadList;
    }
    
    
}
