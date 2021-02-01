/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.entities;

import ec.edu.uasb.portaldoc.entities.CicloAcademico;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author johana.orozco
 */
@Entity
@Table(name = "CONSUL_EXTERN_DOCENTE")
@NamedQueries({
    @NamedQuery(name = "ConsulExternDocente.findAll", query = "SELECT c FROM ConsulExternDocente c")})
public class ConsulExternDocente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsulExternDocentePK consulExternDocentePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NRO_ESTIM_PERSONAS")
    private long nroEstimPersonas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NRO_ESTIM_CONSULTAS")
    private long nroEstimConsultas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NRO_ESTIM_HORAS_DEDICADA")
    private long nroEstimHorasDedicada;
    @Column(name = "NRO_HORAS_PREP_CLASES")
    private Long nroHorasPrepClases;
    @Lob
    @Column(name = "MATERIAL_APOYO")
    private String materialApoyo;
    @Lob
    @Column(name = "TECNOLOGIA_APOYO")
    private String tecnologiaApoyo;
    @Size(max = 60)
    @Column(name = "PUB_TIPO_MEDIO")
    private String pubTipoMedio;
    @Lob
    @Column(name = "PUB_DESCRIPCION")
    private String pubDescripcion;
    @Column(name = "PUB_NUMERO_PUBLICA")
    private Long pubNumeroPublica;
    @JoinColumn(name = "CODIGO_PROFESOR", referencedColumnName = "CODIGO_PROFESOR", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profesor profesor;
    @JoinColumns({
        @JoinColumn(name = "ANIO", referencedColumnName = "ANIO", insertable = false, updatable = false),
        @JoinColumn(name = "CICLO", referencedColumnName = "CICLO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CicloAcademico cicloAcademico;

    public ConsulExternDocente() {
    }

    public ConsulExternDocente(ConsulExternDocentePK consulExternDocentePK) {
        this.consulExternDocentePK = consulExternDocentePK;
    }

    public ConsulExternDocente(ConsulExternDocentePK consulExternDocentePK, long nroEstimPersonas, long nroEstimConsultas, long nroEstimHorasDedicada) {
        this.consulExternDocentePK = consulExternDocentePK;
        this.nroEstimPersonas = nroEstimPersonas;
        this.nroEstimConsultas = nroEstimConsultas;
        this.nroEstimHorasDedicada = nroEstimHorasDedicada;
    }

    public ConsulExternDocente(long anio, long ciclo, long codigoProfesor) {
        this.consulExternDocentePK = new ConsulExternDocentePK(anio, ciclo, codigoProfesor);
    }

    public ConsulExternDocentePK getConsulExternDocentePK() {
        return consulExternDocentePK;
    }

    public void setConsulExternDocentePK(ConsulExternDocentePK consulExternDocentePK) {
        this.consulExternDocentePK = consulExternDocentePK;
    }

    public long getNroEstimPersonas() {
        return nroEstimPersonas;
    }

    public void setNroEstimPersonas(long nroEstimPersonas) {
        this.nroEstimPersonas = nroEstimPersonas;
    }

    public long getNroEstimConsultas() {
        return nroEstimConsultas;
    }

    public void setNroEstimConsultas(long nroEstimConsultas) {
        this.nroEstimConsultas = nroEstimConsultas;
    }

    public long getNroEstimHorasDedicada() {
        return nroEstimHorasDedicada;
    }

    public void setNroEstimHorasDedicada(long nroEstimHorasDedicada) {
        this.nroEstimHorasDedicada = nroEstimHorasDedicada;
    }

    public Long getNroHorasPrepClases() {
        return nroHorasPrepClases;
    }

    public void setNroHorasPrepClases(Long nroHorasPrepClases) {
        this.nroHorasPrepClases = nroHorasPrepClases;
    }

    public String getMaterialApoyo() {
        return materialApoyo;
    }

    public void setMaterialApoyo(String materialApoyo) {
        this.materialApoyo = materialApoyo;
    }

    public String getTecnologiaApoyo() {
        return tecnologiaApoyo;
    }

    public void setTecnologiaApoyo(String tecnologiaApoyo) {
        this.tecnologiaApoyo = tecnologiaApoyo;
    }

    public String getPubTipoMedio() {
        return pubTipoMedio;
    }

    public void setPubTipoMedio(String pubTipoMedio) {
        this.pubTipoMedio = pubTipoMedio;
    }

    public String getPubDescripcion() {
        return pubDescripcion;
    }

    public void setPubDescripcion(String pubDescripcion) {
        this.pubDescripcion = pubDescripcion;
    }

    public Long getPubNumeroPublica() {
        return pubNumeroPublica;
    }

    public void setPubNumeroPublica(Long pubNumeroPublica) {
        this.pubNumeroPublica = pubNumeroPublica;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consulExternDocentePK != null ? consulExternDocentePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsulExternDocente)) {
            return false;
        }
        ConsulExternDocente other = (ConsulExternDocente) object;
        if ((this.consulExternDocentePK == null && other.consulExternDocentePK != null) || (this.consulExternDocentePK != null && !this.consulExternDocentePK.equals(other.consulExternDocentePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.infoanual.entities.ConsulExternDocente[ consulExternDocentePK=" + consulExternDocentePK + " ]";
    }
    
}
