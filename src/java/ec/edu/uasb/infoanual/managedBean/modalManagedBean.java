/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.managedBean;


import ec.edu.uasb.portaldoc.entities.CicloAcademico;
import ec.edu.uasb.portaldoc.session.CicloAcademicoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author johana.orozco
 */
@ManagedBean(name = "modal")
@ViewScoped
public class modalManagedBean implements Serializable {

    private String urlmodal = "/pages/infoanual/comodin.xhtml";
    private Object bean;
    private Object beandocencia;
    private Object beaninvestigacion;
    private Object beanvinculacion;
    private Object beangestion;
    private Object beanpresencia;
    private Object beanperfeccionamiento;
    private Integer activeIndexAcoordion = 0;
    private Integer activeIndexTabviewdocencia = 0;
    private Integer activeIndexTabviewinvestigacion = 0;
    private Integer activeIndexTabviewvinculacion = 0;
    private Integer activeIndexTabviewgestion = 0;
    private Integer activeIndexTabviewperfecdoc = 0;
    private Integer activeIndexTabviewpresencia = 0;
    private List<CicloAcademico> ciclos = new ArrayList<CicloAcademico>();
    private Long anio;
    private String displayReporte = null;
    private String cicloactivo= null;
  // private Usuario usr;
    @EJB
    private CicloAcademicoFacadeLocal cicloAcademicoFacade;
    private boolean renderPdf = false;

    public String getCicloactivo() {
        return cicloactivo;
    }

    public void setCicloactivo(String cicloactivo) {
        this.cicloactivo = cicloactivo;
    }

    // <editor-fold defaultstate="collapsed" desc="DECLARACION VARIABLES"> 
    /**
     * @return the renderPdf
     */
    
    
    public boolean isRenderPdf() {
        return renderPdf;
    }

   
    /**
     * @param renderPdf the renderPdf to set
     */
    
    
    public void setRenderPdf(boolean renderPdf) {
        this.renderPdf = renderPdf;
    }

    public Object getBeanpresencia() {
        return beanpresencia;
    }

    public void setBeanpresencia(Object beanpresencia) {
        this.beanpresencia = beanpresencia;
    }

    public Integer getActiveIndexTabviewpresencia() {
        return activeIndexTabviewpresencia;
    }

    public void setActiveIndexTabviewpresencia(Integer activeIndexTabviewpresencia) {
        this.activeIndexTabviewpresencia = activeIndexTabviewpresencia;
    }

    public Integer getActiveIndexTabviewgestion() {
        return activeIndexTabviewgestion;
    }

    public void setActiveIndexTabviewgestion(Integer activeIndexTabviewgestion) {
        this.activeIndexTabviewgestion = activeIndexTabviewgestion;
    }

    public Object getBeangestion() {
        return beangestion;
    }

    public void setBeangestion(Object beangestion) {
        this.beangestion = beangestion;
    }

    public Integer getActiveIndexTabviewvinculacion() {
        return activeIndexTabviewvinculacion;
    }

    public void setActiveIndexTabviewvinculacion(Integer activeIndexTabviewvinculacion) {
        this.activeIndexTabviewvinculacion = activeIndexTabviewvinculacion;
    }

    public Object getBeanvinculacion() {
        return beanvinculacion;
    }

    public void setBeanvinculacion(Object beanvinculacion) {
        this.beanvinculacion = beanvinculacion;
    }

    public Object getBeaninvestigacion() {
        return beaninvestigacion;
    }

    public void setBeaninvestigacion(Object beaninvestigacion) {
        this.beaninvestigacion = beaninvestigacion;
    }

    public Object getBeandocencia() {
        return beandocencia;
    }

    public void setBeandocencia(Object beandocencia) {
        this.beandocencia = beandocencia;
    }

    public Integer getActiveIndexTabviewinvestigacion() {
        return activeIndexTabviewinvestigacion;
    }

    public void setActiveIndexTabviewinvestigacion(Integer activeIndexTabviewinvestigacion) {
        this.activeIndexTabviewinvestigacion = activeIndexTabviewinvestigacion;
    }

    public String getUrlmodal() {
        return urlmodal;
    }

    public void setUrlmodal(String urlmodal) {
        this.urlmodal = urlmodal;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Integer getActiveIndexAcoordion() {
        return activeIndexAcoordion;
    }

    public void setActiveIndexAcoordion(Integer activeIndexAcoordion) {
        this.activeIndexAcoordion = activeIndexAcoordion;
    }

    public Integer getActiveIndexTabviewdocencia() {
        return activeIndexTabviewdocencia;
    }

    public void setActiveIndexTabviewdocencia(Integer activeIndexTabviewdocencia) {
        this.activeIndexTabviewdocencia = activeIndexTabviewdocencia;
    }

    /**
     * @return the anio
     */
    public Long getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(Long anio) {
        this.anio = anio;
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
     * @return the ciclos
     */
    public List<CicloAcademico> getCiclos() {
        return ciclos;
    }

    /**
     * @param ciclos the ciclos to set
     */
    public void setCiclos(List<CicloAcademico> ciclos) {
        this.ciclos = ciclos;
    }
    
    public CicloAcademicoFacadeLocal getCicloAcademicoFacade() {
        return cicloAcademicoFacade;
    }

    public void setCicloAcademicoFacade(CicloAcademicoFacadeLocal cicloAcademicoFacade) {
        this.cicloAcademicoFacade = cicloAcademicoFacade;
    }
    
    public Object getBeanperfeccionamiento() {
        return beanperfeccionamiento;
    }

    public void setBeanperfeccionamiento(Object beanperfeccionamiento) {
        this.beanperfeccionamiento = beanperfeccionamiento;
    }
    
    public Integer getActiveIndexTabviewperfecdoc() {
        return activeIndexTabviewperfecdoc;
    }

    public void setActiveIndexTabviewperfecdoc(Integer activeIndexTabviewperfecdoc) {
        this.activeIndexTabviewperfecdoc = activeIndexTabviewperfecdoc;
    }
    
    // </editor-fold> 

    /**
     * Creates a new instance of modalManagedBean
     */
    public modalManagedBean() {
    //    usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
    }

    @PostConstruct
    private void recuperarListados() {
        ciclos = cicloAcademicoFacade.findAllActivos();
        if (!ciclos.isEmpty()) {
            anio = getCiclos().get(0).getCicloAcademicoPK().getAnio();
            cicloactivo = cicloAcademicoFacade.findByEstado('A').get(0).getNombreCiclo();
            imprimirSp();
        }
    }

    public void onTabChange(AjaxBehaviorEvent aEvent) {
    }

    public void onTabChangeAcoordion(TabChangeEvent aEvent) {
        if (activeIndexAcoordion == 0) {
            bean = beandocencia;
        } else if (activeIndexAcoordion == 1) {
            bean = beaninvestigacion;
        } else if (activeIndexAcoordion == 2) {
            bean = beanvinculacion;
        } else if (activeIndexAcoordion == 3) {
            bean = beangestion;
        } else if (activeIndexAcoordion == 4) {
            bean = beanperfeccionamiento;
        } else if (activeIndexAcoordion == 5) {
            bean = beanpresencia;
        }
    }

    public void imprimirSp() {
        if (anio != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            String url = context.getExternalContext().getRequestScheme()
                    + "://" + context.getExternalContext().getRequestServerName()
                    + ":" + context.getExternalContext().getRequestServerPort()
                    + "/Syllabus/servlet?anio=" + anio                 
                    + "&reporte=informeAnual"
                    + "&contexto=" + context.getExternalContext().getRealPath("/reportes");
            this.setDisplayReporte(url);
            renderPdf=true;
        } else {
            renderPdf=false;
            this.setDisplayReporte(null);
        }
    }
}
