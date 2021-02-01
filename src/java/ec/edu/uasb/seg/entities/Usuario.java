/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.seg.entities;

import ec.edu.uasb.seg.constants.LoginStatus;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;


/**
 *
 * @author victor.barba
 */
@Entity
@Table(name = "PROFESOR")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_PROFESOR")
    private Long usuCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CED_PAS_PROFESOR")
    private String usuCedPass;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOMBRE_PROFESOR")
    private String usuNombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "APELLIDO_PROFESOR")
    private String usuApellUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NR_MEMO")
    private String usuClave;
    @Column(name = "EMAIL_PROFESOR")
    private String usuEmail;
    @Transient
    private Date usuFechaUltimoLogin;
    @Transient
    private String usuEstadoUsuario;
    @Transient
    private LoginStatus loginStatus;

    public Usuario() {
    }

    public Usuario(Long usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public Usuario(Long usuCodigo, String usuCedPass,String usuNombreUsuario,String usuApellUsuario, String usuClave, String usuEstadoUsuario,String usuEmail) {
        this.usuCodigo = usuCodigo;
        this.usuCedPass = usuCedPass;
        this.usuNombreUsuario = usuNombreUsuario;
        this.usuApellUsuario = usuApellUsuario;
        this.usuClave = usuClave;
        this.usuEstadoUsuario = usuEstadoUsuario;
        this.usuEmail = usuEmail;
    }

    public Long getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Long usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public String getUsuNombreUsuario() {
        return usuNombreUsuario;
    }

    public void setUsuNombreUsuario(String usuNombreUsuario) {
        this.usuNombreUsuario = usuNombreUsuario;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public String getUsuEstadoUsuario() {
        return usuEstadoUsuario;
    }

    public void setUsuEstadoUsuario(String usuEstadoUsuario) {
        this.usuEstadoUsuario = usuEstadoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuCodigo != null ? usuCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuCodigo == null && other.usuCodigo != null) || (this.usuCodigo != null && !this.usuCodigo.equals(other.usuCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.seg.entity.Usuario[ usuCodigo=" + usuCodigo + " ]";
    }

    /**
     * @return the loginStatus
     */
    public LoginStatus getLoginStatus() {
        return loginStatus;
    }

    /**
     * @param loginStatus the loginStatus to set
     */
    public void setLoginStatus(LoginStatus loginStatus) {
        this.loginStatus = loginStatus;
    }

    /**
     * @return the usuFechaUltimoLogin
     */
    public Date getUsuFechaUltimoLogin() {
        return usuFechaUltimoLogin;
    }

    /**
     * @param usuFechaUltimoLogin the usuFechaUltimoLogin to set
     */
    public void setUsuFechaUltimoLogin(Date usuFechaUltimoLogin) {
        this.usuFechaUltimoLogin = usuFechaUltimoLogin;
    }

    /**
     * @return the usuCedPass
     */
    public String getUsuCedPass() {
        return usuCedPass;
    }

    /**
     * @param usuCedPass the usuCedPass to set
     */
    public void setUsuCedPass(String usuCedPass) {
        this.usuCedPass = usuCedPass;
    }

    /**
     * @return the usuApellUsuario
     */
    public String getUsuApellUsuario() {
        return usuApellUsuario;
    }

    /**
     * @param usuApellUsuario the usuApellUsuario to set
     */
    public void setUsuApellUsuario(String usuApellUsuario) {
        this.usuApellUsuario = usuApellUsuario;
    }

    /**
     * @return the usuEmail
     */
    public String getUsuEmail() {
        return usuEmail;
    }

    /**
     * @param usuEmail the usuEmail to set
     */
    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }
    
    
}
