/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.bean;

import ec.edu.uasb.bean.BaseJSFManagedBean;
import ec.edu.uasb.bean.exceptions.SyllabusException;
import ec.edu.uasb.portaldoc.entities.AsignaturaSyllabus;
import ec.edu.uasb.portaldoc.entities.CicloAcademico;
import ec.edu.uasb.portaldoc.entities.SylabusBiblio;
import ec.edu.uasb.portaldoc.entities.SylabusContenido;
import ec.edu.uasb.portaldoc.entities.SylabusContenidoPK;
import ec.edu.uasb.portaldoc.entities.SylabusDocente;
import ec.edu.uasb.portaldoc.session.AsignaturaSyllabusFacadeLocal;
import ec.edu.uasb.portaldoc.session.CicloAcademicoFacadeLocal;
import ec.edu.uasb.portaldoc.session.SylabusBiblioFacadeLocal;
import ec.edu.uasb.portaldoc.session.SylabusContenidoFacadeLocal;
import ec.edu.uasb.portaldoc.session.SylabusDocenteFacadeLocal;
import ec.edu.uasb.seg.entities.Usuario;
import ec.edu.uasb.utils.JsfUtil;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author victor.barba
 */
@ManagedBean(name = "aprobSyllabusBean")
@ViewScoped
public class AprobJSFManagedBean extends BaseJSFManagedBean implements Serializable {

    private static final long serialVersionUID = 20120420L;
    @EJB
    private CicloAcademicoFacadeLocal cicloAcademicoFacade;
    @EJB
    private AsignaturaSyllabusFacadeLocal asignaturaSyllabusFacade;
    @EJB
    private SylabusDocenteFacadeLocal sylabusDocenteFacade;
    @EJB
    private SylabusContenidoFacadeLocal sylabusContenidoFacade;
    @EJB
    private SylabusBiblioFacadeLocal sylabusBiblioFacade;
    private SylabusDocente sylabusDocente;
    private final Usuario usr;
    private Long anio;
    private AsignaturaSyllabus asignaturaSelected;
    private List<AsignaturaSyllabus> asignaturaSyllabuses = new ArrayList<AsignaturaSyllabus>();
    private List<SylabusContenido> temasSylabus = new ArrayList<SylabusContenido>();
    private List<SylabusContenido> biblioSylabus = new ArrayList<SylabusContenido>();
    private List<SylabusBiblio> bibliografias = new ArrayList<SylabusBiblio>();
    private List<CicloAcademico> ciclos = new ArrayList<CicloAcademico>();
    private String accion;
    private final SimpleDateFormat formatter;

    //<editor-fold defaultstate="collapsed" desc="Propiedades ">
    public Long getAnio() {
        return anio;
    }

    public void setAnio(Long anio) {
        this.anio = anio;
    }

    public List<AsignaturaSyllabus> getAsignaturaSyllabuses() {
        return asignaturaSyllabuses;
    }

    public void setAsignaturaSyllabuses(List<AsignaturaSyllabus> asignaturaSyllabuses) {
        this.asignaturaSyllabuses = asignaturaSyllabuses;
    }

    public List<CicloAcademico> getCiclos() {
        return ciclos;
    }

    public void setCiclos(List<CicloAcademico> ciclos) {
        this.ciclos = ciclos;
    }

    public AsignaturaSyllabus getAsignaturaSelected() {
        return asignaturaSelected;
    }

    public void setAsignaturaSelected(AsignaturaSyllabus asignaturaSelected) {
        this.asignaturaSelected = asignaturaSelected;
    }

    public SylabusDocente getSylabusDocente() {
        return sylabusDocente;
    }

    public void setSylabusDocente(SylabusDocente sylabusDocente) {
        this.sylabusDocente = sylabusDocente;
    }

    public List<SylabusContenido> getTemasSylabus() {
        return temasSylabus;
    }

    public void setTemasSylabus(List<SylabusContenido> temasSylabus) {
        this.temasSylabus = temasSylabus;
    }

    public List<SylabusContenido> getBiblioSylabus() {
        return biblioSylabus;
    }

    public void setBiblioSylabus(List<SylabusContenido> biblioSylabus) {
        this.biblioSylabus = biblioSylabus;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public List<SylabusBiblio> getBibliografias() {
        return bibliografias;
    }

    public void setBibliografias(List<SylabusBiblio> bibliografias) {
        this.bibliografias = bibliografias;
    }

    //</editor-fold>
    public AprobJSFManagedBean() {
        usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        formatter = new SimpleDateFormat("dd MMMM yyyy", new Locale("es"));
    }

    @PostConstruct
    private void recuperarListados() {
//        ciclos = cicloAcademicoFacade.findByEstado('A');
        ciclos = cicloAcademicoFacade.findAll();
        if (!ciclos.isEmpty()) {
            anio = ciclos.get(0).getCicloAcademicoPK().getAnio();
            handleCicloChange();
        }
    }

    public String formatDate(Date date, String pattern) {
        if (date == null) {
            return null;
        }

        if (pattern == null) {
            throw new NullPointerException("pattern");
        }

//        Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        return formatter.format(date);
    }

    public void handleCicloChange() {
        asignaturaSyllabuses = asignaturaSyllabusFacade.getCordinadosSyllabus(anio, usr.getUsuCodigo());
        asignaturaSelected = null;
    }

    private void recuperarContenidos() {
        SylabusContenidoPK contenidoPK = new SylabusContenidoPK();
        contenidoPK.setAnio(anio);
        contenidoPK.setCiclo(new Long(1));
        contenidoPK.setCodigoMateria(asignaturaSelected.getAsignaturaSyllabusPK().getCodigoMateria());
        contenidoPK.setCodigoProfesor(asignaturaSelected.getAsignaturaSyllabusPK().getCodigoProfesor());
        contenidoPK.setTipo('C');
        contenidoPK.setCodParalelo(asignaturaSelected.getAsignaturaSyllabusPK().getCodParalelo());
        contenidoPK.setCodigoNivel(asignaturaSelected.getAsignaturaSyllabusPK().getCodigoNivel());
        contenidoPK.setVacCodnum(asignaturaSelected.getAsignaturaSyllabusPK().getVacCodnum());
        contenidoPK.setCodPrograma(asignaturaSelected.getAsignaturaSyllabusPK().getCodPrograma());
        temasSylabus = sylabusContenidoFacade.findContenidoById(contenidoPK);
        biblioSylabus = new ArrayList<SylabusContenido>(temasSylabus);
        bibliografias = sylabusBiblioFacade.findBiblioById(contenidoPK);
        RequestContext.getCurrentInstance().update("formMant:vistaTemas");
        RequestContext.getCurrentInstance().update("formMant:vistaBiblio");
    }

    public void editarSylabusButton_processAction() {
        this.setPaginaMant("/pages/syllabus/regObservSyllabus");
        super.nuevoButton_processAction(null);
        sylabusDocente = null;
        accion = null;
        try {
            sylabusDocente = sylabusDocenteFacade.findById(asignaturaSelected);
            cargaTitulos();
            recuperarContenidos();
        } catch (SyllabusException ex) {
//            Logger.getLogger(RegSyllabusJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void guardarButton_processAction(ActionEvent ae) {
        if (accion != null) {
            if (accion.equals("P")) {
                sylabusDocente.setEstadoEnvio('P');
                sylabusDocente.setEstadoSylabus('P');
                JsfUtil.addSuccessMessage(null, "Observación registrada y enviada al docente");
            } else {
                sylabusDocente.setEstadoSylabus('A');
                sylabusDocente.setAprobadoPor(usr.getUsuCodigo());
                sylabusDocente.setFechaAprobacion(new Date());
                JsfUtil.addSuccessMessage(null, "Aprobación realizada. Informe enviado al docente");
            }
            try {
                sylabusDocenteFacade.edit(usr, sylabusDocente, asignaturaSelected, FacesContext.getCurrentInstance());
                asignaturaSyllabuses = asignaturaSyllabusFacade.getCordinadosSyllabus(anio, usr.getUsuCodigo());
                super.guardarButton_processAction(ae);
                accion = null;
                RequestContext.getCurrentInstance().update("formAsignaturas:dataAsig");
            } catch (Exception e) {
                super.getNavigationJSFManagedBean().setMsgError("No puedo enviar el comunicado. Por favor comuniquese con el call-center de la Universidad");
                RequestContext.getCurrentInstance().update("dialogMessage");
                RequestContext.getCurrentInstance().execute("errorWidget.show();");
            }
        }
    }

    public void imprimirSp() {
        String urlReporte = "tipo=pdf"
                + "&anio=" + asignaturaSelected.getAnio()
                + "&asig=" + asignaturaSelected.getAsignaturaSyllabusPK().getCodigoMateria()
                + "&per=" + asignaturaSelected.getAsignaturaSyllabusPK().getCodigoNivel()
                + "&par=" + asignaturaSelected.getAsignaturaSyllabusPK().getCodParalelo()
                + "&prog=" + asignaturaSelected.getAsignaturaSyllabusPK().getCodPrograma();

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("urlRep", urlReporte);

    }
    //<editor-fold defaultstate="collapsed" desc="CargaTitulos">
    private String titUniCurr;
    private String titCampForm;

    public String getTitUniCurr() {
        return titUniCurr;
    }

    public void setTitUniCurr(String titUniCurr) {
        this.titUniCurr = titUniCurr;
    }

    public String getTitCampForm() {
        return titCampForm;
    }

    public void setTitCampForm(String titCampForm) {
        this.titCampForm = titCampForm;
    }

    public void cargaTitulos() {
        
        asignaturaSelected.getRegsilago();
        if (asignaturaSelected.getRegsilago() == 2016) {
            titUniCurr = "3.1. Unidad curricular";
            titCampForm = "3.3. Campo de formación";
        } else {
            titUniCurr = "3.1. Unidades de organización curricular";
            titCampForm = "3.2. Campo de formación";
        }

    }
    //</editor-fold>
}
