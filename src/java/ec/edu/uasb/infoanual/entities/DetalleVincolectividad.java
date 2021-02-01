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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author johana.orozco
 */
@Entity
@Table(name = "DETALLE_VINCOLECTIVIDAD")


public class DetalleVincolectividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DAVC_CODIGO")
    private Long davcCodigo;
  
    @Column(name = "DAVC_NOMBRE")
    private String davcNombre;
    @Size(max = 200)
     @JoinColumn(name = "AVC_CODIGO", referencedColumnName = "AVC_CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AreaVincolectividad areaVinculacion;
    
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleVinculacion")
    private List<OtraActividadAcademica> otraActividadList;

    public DetalleVincolectividad() {
    }

    public DetalleVincolectividad(Long davcCodigo) {
        this.davcCodigo = davcCodigo;
    }

    public DetalleVincolectividad(Long davcCodigo,Long avcCodigo, String davcNombre) {
        this.davcCodigo = davcCodigo;  
        this.davcNombre = davcNombre;
        
    }

    public AreaVincolectividad getAreaVinculacion() {
        return areaVinculacion;
    }

    public void setAreaVinculacion(AreaVincolectividad areaVinculacion) {
        this.areaVinculacion = areaVinculacion;
    }

    public Long getDavcCodigo() {
        return davcCodigo;
    }

    public void setDavcCodigo(Long davcCodigo) {
        this.davcCodigo = davcCodigo;
    }

    public String getDavcNombre() {
        return davcNombre;
    }
    public void setDavcNombre(String davcNombre) {
        this.davcNombre = davcNombre;
    }

    public List<OtraActividadAcademica> getOtraActividadList() {
        return otraActividadList;
    }

    public void setOtraActividadList(List<OtraActividadAcademica> otraActividadList) {
        this.otraActividadList = otraActividadList;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (davcCodigo != null ? davcCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaVincolectividad)) {
            return false;
        }
        DetalleVincolectividad other = (DetalleVincolectividad) object;
        if ((this.davcCodigo == null && other.davcCodigo != null) || (this.davcCodigo != null && !this.davcCodigo.equals(other.davcCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.infoanual.entities.DetalleVincolectividad[ davcCodigo=" + davcCodigo + " ]";
    }
    
}
