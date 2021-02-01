/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.bean;

import ec.edu.uasb.seg.constants.LoginStatus;
import ec.edu.uasb.seg.entities.Usuario;
import ec.edu.uasb.seg.session.UsuarioFacadeLocal;
import ec.edu.uasb.utils.JsfUtil;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author victor.barba
 */
@ManagedBean(name = "loginMgmtBean")
@RequestScoped
public class LoginJSFManagedBean implements Serializable {

    private static final long serialVersionUID = 20120423L;
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    private String userName;
    private String password;

    //<editor-fold defaultstate="collapsed" desc="Propiedades ">
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    //</editor-fold>

    /**
     * Creates a new instance of LoginJSFManagedBean
     */
    public LoginJSFManagedBean() {
    }

    public String login() {
        java.util.List<String> msgs = new ArrayList<String>();
        boolean loggedIn = false;
        RequestContext rc = RequestContext.getCurrentInstance();
        FacesContext fc = FacesContext.getCurrentInstance();
        Usuario user = usuarioFacade.login(getUserName(), getPassword());
        if (user.getLoginStatus().equals(LoginStatus.SUCCESSFUL)) {
            loggedIn = true;
            fc.getExternalContext().getSessionMap().put("logined", loggedIn);
            fc.getExternalContext().getSessionMap().put("user", user);
            fc.getExternalContext().getFlash().setKeepMessages(true);
            JsfUtil.addSuccessMessage(null, "Bienvenido(a)");
            return "/principal?faces-redirect=true";
        } else {
            if (user.getLoginStatus().equals(LoginStatus.INACTIVE)) {
                msgs.add("Cuenta Desabilitada: por favor, contacte a su administrador.");
            } else {
                msgs.add("Acceso Fallido: por favor, compruebe su nombre de usuario/contraseña y vuelva a intentarlo.");
                msgs.add("Verifique si su teclado esta en Mayúsculas ó Minúsculas");
            }
            JsfUtil.addErrorMessages(null, msgs);
        }
        rc.addCallbackParam("loggedIn", loggedIn);
        return null;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        return "/principal?faces-redirect=true";

    }

    public String cancelar() {
        userName = null;
        password = null;
        return null;
    }
}
