/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.bean;

import ec.edu.uasb.portaldoc.bean.AprobJSFManagedBean;
import ec.edu.uasb.portaldoc.bean.RegSyllabusJSFManagedBean;
import java.io.Serializable;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.CloseEvent;

/**
 *
 * @author victor.barba
 */
@ManagedBean(name = "navigationMgmtBean")
@SessionScoped
public class NavigationJSFManagedBean implements Serializable {

    private static final long serialVersionUID = 20120425L;
    private static final String paginaPortal = "/general/contenido";
    private String selectedIncludePath = "/general/bienvenida";
    private String openPage = "/WEB-INF/templates/includes/sinContenido";
    private String msgError = null;
    private String displayReporte = null;
    private String nombreReporte;
    private BaseJSFManagedBean baseJSFManagedBean = new BaseJSFManagedBean();
    private String nombreOpcion;

    /**
     * @return the openPage
     */
    public String getOpenPage() {
        return openPage;
    }

    /**
     * @param openPage the openPage to set
     */
    public void setOpenPage(String openPage) {
        this.openPage = openPage;
    }
    //<editor-fold defaultstate="collapsed" desc="Propiedades">

    /**
     * @return the msgError
     */
    public String getMsgError() {
        return msgError;
    }

    /**
     * @param msgError the msgError to set
     */
    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    /**
     * @return the selectedIncludePath
     */
    public String getSelectedIncludePath() {
        return selectedIncludePath;
    }

    /**
     * @param selectedIncludePath the selectedIncludePath to set
     */
    public void setSelectedIncludePath(String selectedIncludePath) {
        this.selectedIncludePath = selectedIncludePath;
    }

    /**
     * @return the displayReporte
     */
    public String getDisplayReporte() {
        return displayReporte;
    }

    /**
     * @param displayReporte the displayReporte to set
     */
    public void setDisplayReporte(String displayReporte) {
        this.displayReporte = displayReporte;
    }

    /**
     * @return the paginaPortal
     */
    public String getPaginaPortal() {
        return paginaPortal;
    }

    /**
     * @return the nombreReporte
     */
    public String getNombreReporte() {
        return nombreReporte;
    }

    /**
     * @param nombreReporte the nombreReporte to set
     */
    public void setNombreReporte(String nombreReporte) {
        this.nombreReporte = nombreReporte;
    }

    /**
     * @return the baseJSFManagedBean
     */
    public Object getBaseJSFManagedBean() {
        return baseJSFManagedBean;
    }

    /**
     * @param baseJSFManagedBean the baseJSFManagedBean to set
     */
    public void setBaseJSFManagedBean(BaseJSFManagedBean baseJSFManagedBean) {
        this.baseJSFManagedBean = baseJSFManagedBean;
    }

    /**
     * @return the nombreOpcion
     */
    public String getNombreOpcion() {
        return nombreOpcion;
    }

    /**
     * @param nombreOpcion the nombreOpcion to set
     */
    public void setNombreOpcion(String nombreOpcion) {
        this.nombreOpcion = nombreOpcion;
    }
    //</editor-fold>

    /**
     * Creates a new instance of NavigationJSFManagedBean
     */
    public NavigationJSFManagedBean() {
    }

    public void navigationPathChange(ActionEvent ae) {
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        selectedIncludePath = (String) map.get("includePath");
        nombreOpcion = ae.getComponent().getAttributes().get("value").toString();
        if (selectedIncludePath == null) {
            selectedIncludePath = "/general/bienvenida";
//        } else if (selectedIncludePath.equals("miCuenta")) {
//            selectedIncludePath = "/general/enConstruccion";
        } else if (selectedIncludePath.equals("/pages/syllabus/syllabus")) {
            AprobJSFManagedBean aprob = (AprobJSFManagedBean) context.getApplication().evaluateExpressionGet(context, "#{aprobSyllabusBean}", AprobJSFManagedBean.class);
            aprob.handleCicloChange();
        } else if (selectedIncludePath.equals("/pages/syllabus/syllaCoordinador")) {
            RegSyllabusJSFManagedBean regSilabo = (RegSyllabusJSFManagedBean) context.getApplication().evaluateExpressionGet(context, "#{regSyllabusBean}", RegSyllabusJSFManagedBean.class);
            regSilabo.handleCicloChange();
        }
    }

    public void handleClose(CloseEvent event) {
        displayReporte = null;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("urlRep");
    }
}
