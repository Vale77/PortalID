/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.entities;

import ec.edu.uasb.infoanual.entities.Especializacion;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "NIVEL_ACADEMICO")
@NamedQueries({
    @NamedQuery(name = "NivelAcademico.findAll", query = "SELECT n FROM NivelAcademico n")})
public class NivelAcademico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_NIVEACAD")
    private Long codigoNiveacad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_NIVEACAD")
    private String nombreNiveacad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PORC_ASIST_NIVEACAD")
    private BigDecimal porcAsistNiveacad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_CRED_MIN_NIVEACAD")
    private int numCredMinNiveacad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_CRED_MAX_NIVEACAD")
    private int numCredMaxNiveacad;
    @Column(name = "DURACION_NIVEACAD")
    private Integer duracionNiveacad;
    @Size(max = 60)
    @Column(name = "REQUISITO_NIVEACAD")
    private String requisitoNiveacad;
    @Size(max = 60)
    @Column(name = "CANDIDATO_NIVELACAD")
    private String candidatoNivelacad;
    @Column(name = "VALOR_MATRICULA")
    private BigDecimal valorMatricula;
    @Column(name = "VALOR_COLEGIATURA")
    private BigDecimal valorColegiatura;
    @Column(name = "ESTADO_NIVELACAD")
    private Character estadoNivelacad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivelAcademico")
    private List<Especializacion> especializacionList;

    public NivelAcademico() {
    }

    public NivelAcademico(Long codigoNiveacad) {
        this.codigoNiveacad = codigoNiveacad;
    }

    public NivelAcademico(Long codigoNiveacad, String nombreNiveacad, BigDecimal porcAsistNiveacad, int numCredMinNiveacad, int numCredMaxNiveacad) {
        this.codigoNiveacad = codigoNiveacad;
        this.nombreNiveacad = nombreNiveacad;
        this.porcAsistNiveacad = porcAsistNiveacad;
        this.numCredMinNiveacad = numCredMinNiveacad;
        this.numCredMaxNiveacad = numCredMaxNiveacad;
    }

    public Long getCodigoNiveacad() {
        return codigoNiveacad;
    }

    public void setCodigoNiveacad(Long codigoNiveacad) {
        this.codigoNiveacad = codigoNiveacad;
    }

    public String getNombreNiveacad() {
        return nombreNiveacad;
    }

    public void setNombreNiveacad(String nombreNiveacad) {
        this.nombreNiveacad = nombreNiveacad;
    }

    public BigDecimal getPorcAsistNiveacad() {
        return porcAsistNiveacad;
    }

    public void setPorcAsistNiveacad(BigDecimal porcAsistNiveacad) {
        this.porcAsistNiveacad = porcAsistNiveacad;
    }

    public int getNumCredMinNiveacad() {
        return numCredMinNiveacad;
    }

    public void setNumCredMinNiveacad(int numCredMinNiveacad) {
        this.numCredMinNiveacad = numCredMinNiveacad;
    }

    public int getNumCredMaxNiveacad() {
        return numCredMaxNiveacad;
    }

    public void setNumCredMaxNiveacad(int numCredMaxNiveacad) {
        this.numCredMaxNiveacad = numCredMaxNiveacad;
    }

    public Integer getDuracionNiveacad() {
        return duracionNiveacad;
    }

    public void setDuracionNiveacad(Integer duracionNiveacad) {
        this.duracionNiveacad = duracionNiveacad;
    }

    public String getRequisitoNiveacad() {
        return requisitoNiveacad;
    }

    public void setRequisitoNiveacad(String requisitoNiveacad) {
        this.requisitoNiveacad = requisitoNiveacad;
    }

    public String getCandidatoNivelacad() {
        return candidatoNivelacad;
    }

    public void setCandidatoNivelacad(String candidatoNivelacad) {
        this.candidatoNivelacad = candidatoNivelacad;
    }

    public BigDecimal getValorMatricula() {
        return valorMatricula;
    }

    public void setValorMatricula(BigDecimal valorMatricula) {
        this.valorMatricula = valorMatricula;
    }

    public BigDecimal getValorColegiatura() {
        return valorColegiatura;
    }

    public void setValorColegiatura(BigDecimal valorColegiatura) {
        this.valorColegiatura = valorColegiatura;
    }

    public Character getEstadoNivelacad() {
        return estadoNivelacad;
    }

    public void setEstadoNivelacad(Character estadoNivelacad) {
        this.estadoNivelacad = estadoNivelacad;
    }

    public List<Especializacion> getEspecializacionList() {
        return especializacionList;
    }

    public void setEspecializacionList(List<Especializacion> especializacionList) {
        this.especializacionList = especializacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoNiveacad != null ? codigoNiveacad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelAcademico)) {
            return false;
        }
        NivelAcademico other = (NivelAcademico) object;
        if ((this.codigoNiveacad == null && other.codigoNiveacad != null) || (this.codigoNiveacad != null && !this.codigoNiveacad.equals(other.codigoNiveacad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.infoanual.entities.NivelAcademico[ codigoNiveacad=" + codigoNiveacad + " ]";
    }
    
}
