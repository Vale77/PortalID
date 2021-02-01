/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.bean;

import ec.edu.uasb.bean.BaseJSFManagedBean;
import ec.edu.uasb.bean.NavigationJSFManagedBean;
import ec.edu.uasb.bean.exceptions.SyllabusException;
import ec.edu.uasb.portaldoc.entities.AsignaturaSyllabus;
import ec.edu.uasb.portaldoc.entities.CicloAcademico;
import ec.edu.uasb.portaldoc.entities.SylabusBiblio;
import ec.edu.uasb.portaldoc.entities.SylabusBiblioPK;
import ec.edu.uasb.portaldoc.entities.SylabusContenido;
import ec.edu.uasb.portaldoc.entities.SylabusContenidoPK;
import ec.edu.uasb.portaldoc.entities.SylabusDocente;
import ec.edu.uasb.portaldoc.entities.SylabusDocentePK;
import ec.edu.uasb.portaldoc.session.AsignaturaSyllabusFacadeLocal;
import ec.edu.uasb.portaldoc.session.CicloAcademicoFacadeLocal;
import ec.edu.uasb.portaldoc.session.SylabusBiblioFacadeLocal;
import ec.edu.uasb.portaldoc.session.SylabusContenidoFacadeLocal;
import ec.edu.uasb.portaldoc.session.SylabusDocenteFacadeLocal;
import ec.edu.uasb.seg.entities.Usuario;
import ec.edu.uasb.utils.JsfUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author victor.barba
 */
@ManagedBean(name = "regSyllabusBean")
@ViewScoped
public class RegSyllabusJSFManagedBean extends BaseJSFManagedBean implements Serializable {

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
    private final Usuario usr;
    private Long anio;
    private List<AsignaturaSyllabus> asignaturaSyllabuses = new ArrayList<AsignaturaSyllabus>();
    private List<AsignaturaSyllabus> listaAcopiarSyllabus = new ArrayList<AsignaturaSyllabus>();
    private AsignaturaSyllabus asignaturaSelected;
    private AsignaturaSyllabus copiaSelected;
    private SylabusDocente sylabusDocente;
    private SylabusContenido temaSelected;
    private SylabusContenido contenidoEdit;
    private SylabusContenido biblioSelected;
    private SylabusBiblio biblioGenSelected;
    private SylabusBiblio biblioGenEdit;
    private List<CicloAcademico> ciclos = new ArrayList<CicloAcademico>();
    private List<SylabusContenido> temasSylabus = new ArrayList<SylabusContenido>();
    private List<SylabusContenido> biblioSylabus = new ArrayList<SylabusContenido>();
    private List<SylabusBiblio> bibliografias = new ArrayList<SylabusBiblio>();
    private Integer activeTabIndex = 0;
    private Integer activeTabIndexObj = 0;
    private Integer activeTabIndexArtic = 0;
    private Integer activeTabIndexProc = 0;
    private Integer activeTabIndexEval = 0;
    private Integer activeTabIndexObserv = 0;
    private Integer activeTabIndexBiblio = 0;
    private String tituloMantTab;
    private boolean sylabusPendientes;
    private String msgNotificacion;
    private final SimpleDateFormat formatter;
    @ManagedProperty(value = "#{navigationMgmtBean}")
    private NavigationJSFManagedBean navJSFManagedBean;

    //<editor-fold defaultstate="collapsed" desc="Propiedades ">
    public void setNavJSFManagedBean(NavigationJSFManagedBean navJSFManagedBean) {
        this.navJSFManagedBean = navJSFManagedBean;
    }

    public AsignaturaSyllabus getCopiaSelected() {
        return copiaSelected;
    }

    public void setCopiaSelected(AsignaturaSyllabus copiaSelected) {
        this.copiaSelected = copiaSelected;
    }

    public List<AsignaturaSyllabus> getListaAcopiarSyllabus() {
        return listaAcopiarSyllabus;
    }

    public SylabusDocente getSylabusDocente() {
        return sylabusDocente;
    }

    public void setSylabusDocente(SylabusDocente sylabusDocente) {
        this.sylabusDocente = sylabusDocente;
    }

    public SylabusContenido getContenidoEdit() {
        return contenidoEdit;
    }

    public void setContenidoEdit(SylabusContenido contenidoEdit) {
        this.contenidoEdit = contenidoEdit;
    }

    public SylabusContenido getBiblioSelected() {
        return biblioSelected;
    }

    public void setBiblioSelected(SylabusContenido biblioSelected) {
        this.biblioSelected = biblioSelected;
    }

    public SylabusBiblio getBiblioGenSelected() {
        return biblioGenSelected;
    }

    public void setBiblioGenSelected(SylabusBiblio biblioGenSelected) {
        this.biblioGenSelected = biblioGenSelected;
    }

    public SylabusBiblio getBiblioGenEdit() {
        return biblioGenEdit;
    }

    public void setBiblioGenEdit(SylabusBiblio biblioGenEdit) {
        this.biblioGenEdit = biblioGenEdit;
    }

    public Long getAnio() {
        return anio;
    }

    public void setAnio(Long anio) {
        this.anio = anio;
    }

    public AsignaturaSyllabus getAsignaturaSelected() {
        return asignaturaSelected;
    }

    public void setAsignaturaSelected(AsignaturaSyllabus asignaturaSelected) {
        this.asignaturaSelected = asignaturaSelected;
    }

    public List<CicloAcademico> getCiclos() {
        return ciclos;
    }

    public void setCiclos(List<CicloAcademico> ciclos) {
        this.ciclos = ciclos;
    }

    public List<AsignaturaSyllabus> getAsignaturaSyllabuses() {
        return asignaturaSyllabuses;
    }

    public void setAsignaturaSyllabuses(List<AsignaturaSyllabus> asignaturaSyllabuses) {
        this.asignaturaSyllabuses = asignaturaSyllabuses;
    }

    public Integer getActiveTabIndex() {
        return activeTabIndex;
    }

    public void setActiveTabIndex(Integer activeTabIndex) {
        this.activeTabIndex = activeTabIndex;
    }

    public List<SylabusContenido> getTemasSylabus() {
        return temasSylabus;
    }

    public void setTemasSylabus(List<SylabusContenido> temasSylabus) {
        this.temasSylabus = temasSylabus;
    }

    public SylabusContenido getTemaSelected() {
        return temaSelected;
    }

    public void setTemaSelected(SylabusContenido temaSelected) {
        this.temaSelected = temaSelected;
    }

    public List<SylabusContenido> getBiblioSylabus() {
        return biblioSylabus;
    }

    public void setBiblioSylabus(List<SylabusContenido> biblioSylabus) {
        this.biblioSylabus = biblioSylabus;
    }

    public List<SylabusBiblio> getBibliografias() {
        return bibliografias;
    }

    public void setBibliografias(List<SylabusBiblio> bibliografias) {
        this.bibliografias = bibliografias;
    }

    public String getTituloMantTab() {
        return tituloMantTab;
    }

    public void setTituloMantTab(String tituloMantTab) {
        this.tituloMantTab = tituloMantTab;
    }

    public boolean isSylabusPendientes() {
        return sylabusPendientes;
    }

    public void setSylabusPendientes(boolean sylabusPendientes) {
        this.sylabusPendientes = sylabusPendientes;
    }

    public String getMsgNotificacion() {
        return msgNotificacion;
    }

    public void setMsgNotificacion(String msgNotificacion) {
        this.msgNotificacion = msgNotificacion;
    }

    public Integer getActiveTabIndexObj() {
        return activeTabIndexObj;
    }

    public void setActiveTabIndexObj(Integer activeTabIndexObj) {
        this.activeTabIndexObj = activeTabIndexObj;
    }

    public Integer getActiveTabIndexArtic() {
        return activeTabIndexArtic;
    }

    public void setActiveTabIndexArtic(Integer activeTabIndexArtic) {
        this.activeTabIndexArtic = activeTabIndexArtic;
    }

    public Integer getActiveTabIndexProc() {
        return activeTabIndexProc;
    }

    public void setActiveTabIndexProc(Integer activeTabIndexProc) {
        this.activeTabIndexProc = activeTabIndexProc;
    }

    public Integer getActiveTabIndexEval() {
        return activeTabIndexEval;
    }

    public void setActiveTabIndexEval(Integer activeTabIndexEval) {
        this.activeTabIndexEval = activeTabIndexEval;
    }

    public Integer getActiveTabIndexObserv() {
        return activeTabIndexObserv;
    }

    public void setActiveTabIndexObserv(Integer activeTabIndexObserv) {
        this.activeTabIndexObserv = activeTabIndexObserv;
    }

    public Integer getActiveTabIndexBiblio() {
        return activeTabIndexBiblio;
    }

    public void setActiveTabIndexBiblio(Integer activeTabIndexBiblio) {
        this.activeTabIndexBiblio = activeTabIndexBiblio;
    }

    //</editor-fold>
    /**
     * Creates a new instance of RegSyllabusJSFManagedBean
     */
    public RegSyllabusJSFManagedBean() {
        this.setPaginaMant("/pages/syllabus/regSyllabus");
        this.setPaginaTema("/pages/syllabus/regTema"); // debe ser incluida tambien en el navigationBean
        usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        formatter = new SimpleDateFormat("dd MMMM yyyy", new Locale("es"));
    }

    @PostConstruct
    private void recuperarListados() {
        ciclos = cicloAcademicoFacade.findAll();
        if (!ciclos.isEmpty()) {
            anio = ciclos.get(0).getCicloAcademicoPK().getAnio();
            handleCicloChange();
            sylabusPendientes = checkSyllabus();
        }
    }

    @Override
    public void init() {
        copiaSelected = null;
        asignaturaSelected = null;
        activeTabIndex = 0;
        activeTabIndexObj = 0;
        activeTabIndexArtic = 0;
        activeTabIndexProc = 0;
        activeTabIndexEval = 0;
        activeTabIndexObserv = 0;
        activeTabIndexBiblio = 0;
    }

    private void recuperarContenidos() {

        copiaSelected = null;
        temaSelected = null;
        biblioGenSelected = null;
        biblioSelected = null;
        SylabusContenidoPK contenidoPK = new SylabusContenidoPK();
        contenidoPK.setAnio(anio);
        contenidoPK.setCiclo(new Long("1"));
        contenidoPK.setCodigoMateria(asignaturaSelected.getAsignaturaSyllabusPK().getCodigoMateria());
        contenidoPK.setCodigoProfesor(usr.getUsuCodigo());
        contenidoPK.setTipo('C');
        contenidoPK.setCodParalelo(asignaturaSelected.getAsignaturaSyllabusPK().getCodParalelo());
        contenidoPK.setCodigoNivel(asignaturaSelected.getAsignaturaSyllabusPK().getCodigoNivel());
        contenidoPK.setVacCodnum(asignaturaSelected.getAsignaturaSyllabusPK().getVacCodnum());
        contenidoPK.setCodPrograma(asignaturaSelected.getAsignaturaSyllabusPK().getCodPrograma());
        temasSylabus = sylabusContenidoFacade.findContenidoById(contenidoPK);
        numclases = sylabusContenidoFacade.findNumClaseById(contenidoPK);

        biblioSylabus = new ArrayList<SylabusContenido>(temasSylabus);
        bibliografias = sylabusBiblioFacade.findBiblioById(contenidoPK);
        RequestContext.getCurrentInstance().update("formMant:tabView:dataTemas");
        RequestContext.getCurrentInstance().update("formMant:tabView:tabViewBiblio:dataBiblio");
        RequestContext.getCurrentInstance().update("formMant:tabView:tabViewBiblio:dataBiblioGeneral");
    }

    public void prepCopiaSylabusButton_processAction() {
        this.setPaginaMant("/pages/syllabus/regCopiaSyllabus");
        super.nuevoButton_processAction(null);
        listaAcopiarSyllabus = asignaturaSyllabusFacade.getListaAcopiarSyllabus(anio, usr.getUsuCodigo(),
                asignaturaSelected.getAsignaturaSyllabusPK().getCodigoMateria());
        RequestContext.getCurrentInstance().update("formMant:panelMant");
    }

    public void editarSylabusButton_processAction() {
        this.setPaginaMant("/pages/syllabus/regSyllabus");
        super.nuevoButton_processAction(null);
        resetSyllabus();
        cargaTitulos();
        try {
            sylabusDocente = sylabusDocenteFacade.findById(asignaturaSelected);
            sylabusDocente.setNumeroClases(asignaturaSelected.getHorasMateriaDictar() == null ? 0 : asignaturaSelected.getHorasMateriaDictar().intValue());
            sylabusDocente.setNumeroCreditos(asignaturaSelected.getnCreditos() == null ? BigDecimal.ZERO : asignaturaSelected.getnCreditos());
        } catch (SyllabusException ex) {
//            Logger.getLogger(RegSyllabusJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            sylabusDocente = new SylabusDocente();
            sylabusDocente.setNumeroClases(asignaturaSelected.getHorasMateriaDictar() == null ? 0 : asignaturaSelected.getHorasMateriaDictar().intValue());
            sylabusDocente.setNumeroCreditos(asignaturaSelected.getnCreditos() == null ? BigDecimal.ZERO : asignaturaSelected.getnCreditos());
        }
        RequestContext.getCurrentInstance().update("formMant:panelMant");
    }

    private void resetSyllabus() {
        activeTabIndex = 0;
        activeTabIndexObj = 0;
        activeTabIndexArtic = 0;
        activeTabIndexProc = 0;
        activeTabIndexEval = 0;
        activeTabIndexObserv = 0;
        activeTabIndexBiblio = 0;
        sylabusDocente = null;
        biblioSelected = null;
        biblioGenSelected = null;
        temaSelected = null;
        biblioSylabus.clear();
        temasSylabus.clear();
        bibliografias.clear();
    }

    public void handleCicloChange() {
        asignaturaSyllabuses = asignaturaSyllabusFacade.getAsignatSyllabus(anio, usr.getUsuCodigo());
        sylabusPendientes = checkSyllabus();
        asignaturaSelected = null;
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

    //<editor-fold defaultstate="collapsed" desc="Operaciones sobre temas y bibliografía ">
    public void onRowSelect(SelectEvent event) {
        biblioSelected = null;
        temaSelected = null;
        biblioGenSelected = null;
        try {
            switch (activeTabIndex) {
                case 3:
                    contenidoEdit = (SylabusContenido) event.getObject();
                    temaSelected = (SylabusContenido) contenidoEdit.clone();
                    break;
                case 6:
                    if (activeTabIndexBiblio == 0) {
                        contenidoEdit = (SylabusContenido) event.getObject();
                        biblioSelected = (SylabusContenido) contenidoEdit.clone();
                    } else {
                        biblioGenEdit = (SylabusBiblio) event.getObject();
                        biblioGenSelected = (SylabusBiblio) biblioGenEdit.clone();
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(RegSyllabusJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onRowUnselect(UnselectEvent event) {
        temaSelected = null;
        biblioSelected = null;
        biblioGenSelected = null;
    }

    private boolean existeCabecera() {
        return sylabusDocente.getSylabusDocentePK() != null;
    }

    @Override
    public void nuevoButton_processAction(ActionEvent ae) {
        if (!existeCabecera()) {
            super.getNavigationJSFManagedBean().setMsgError("Debe ingresar primero los Objetivos");
            RequestContext.getCurrentInstance().update("dialogMessage");
            RequestContext.getCurrentInstance().execute("errorWidget.show();");
            return;
        }
        temaSelected = null;
        biblioSelected = null;
        biblioGenSelected = null;
        SylabusContenidoPK contenidoPK = new SylabusContenidoPK();
        contenidoPK.setAnio(anio);
        contenidoPK.setCiclo(new Long(1));
        contenidoPK.setCodigoMateria(asignaturaSelected.getAsignaturaSyllabusPK().getCodigoMateria());
        contenidoPK.setCodigoNivel(asignaturaSelected.getAsignaturaSyllabusPK().getCodigoNivel());
        contenidoPK.setCodigoProfesor(usr.getUsuCodigo());
        contenidoPK.setCodParalelo(asignaturaSelected.getAsignaturaSyllabusPK().getCodParalelo());
        contenidoPK.setVacCodnum(asignaturaSelected.getAsignaturaSyllabusPK().getVacCodnum());
        contenidoPK.setCodPrograma(asignaturaSelected.getAsignaturaSyllabusPK().getCodPrograma());
        switch (activeTabIndex) {
            case 3:
                setTituloMantTab("Nuevo Tema");
                contenidoPK.setTipo('C');
                break;
            case 6:
                setTituloMantTab("Nueva Bibliografía");
                if (activeTabIndexBiblio == 0) {
                    contenidoPK.setTipo('B');
                } else {
                    biblioGenEdit = new SylabusBiblio();
                    SylabusBiblioPK bg = new SylabusBiblioPK();
                    bg.setAnio(anio);
                    bg.setCiclo(new Long(1));
                    bg.setCodigoMateria(asignaturaSelected.getAsignaturaSyllabusPK().getCodigoMateria());
                    bg.setCodigoNivel(asignaturaSelected.getAsignaturaSyllabusPK().getCodigoNivel());
                    bg.setCodigoProfesor(usr.getUsuCodigo());
                    bg.setCodParalelo(asignaturaSelected.getAsignaturaSyllabusPK().getCodParalelo());
                    bg.setVacCodnum(asignaturaSelected.getAsignaturaSyllabusPK().getVacCodnum());
                    bg.setCodPrograma(asignaturaSelected.getAsignaturaSyllabusPK().getCodPrograma());
                    biblioGenEdit.setSylabusBiblioPK(bg);
                }
                break;
            default:
                throw new AssertionError();
        }
        SylabusContenido tema = new SylabusContenido(contenidoPK);
        tema.setClase(activeTabIndex == 3 ? "1" : null);
        contenidoEdit = tema;
        RequestContext.getCurrentInstance().execute("mantWidgetTema.show();");
    }

    @Override
    public void editarButton_processAction(ActionEvent ae) {
        switch (activeTabIndex) {
            case 3:
                tituloMantTab = "Editar Tema";
                break;
            case 6:
                tituloMantTab = "Editar Bibliografía";
                break;
            default:
                throw new AssertionError();
        }
    }

    public void eliminarTemaButton_processAction(ActionEvent ae) {
        FacesMessage message = null;
        String msg = null;
        try {
            switch (activeTabIndex) {
                case 3:
                    msg = "Tema eliminado";
                    sylabusContenidoFacade.remove(temaSelected);
                    break;
                case 6:
                    msg = "Bibliografía eliminada";
                    sylabusBiblioFacade.remove(biblioGenSelected);
                    break;
                default:
                    throw new AssertionError();
            }
            recuperarContenidos();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        } catch (Exception e) {
            if (activeTabIndex == 3) {
                msg = "No puedo eliminar este tema.";
            } else {
                msg = "No puedo eliminar esta bibliografía.";
            }
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        } finally {
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void guardarTemaButton_processAction(ActionEvent ae) {
        FacesMessage message = null;
        String msgGuardarTema = null;
        try {
            if (activeTabIndex == 3) {
                if (contenidoEdit.getSylabusContenidoPK().getNumContenido() == null) {
                    sylabusContenidoFacade.create(contenidoEdit);
                    msgGuardarTema = "Tema creado.";
                } else {
                    sylabusContenidoFacade.edit(contenidoEdit);
                    msgGuardarTema = "Tema actualizado.";
                }
            } else if (activeTabIndex == 6 && activeTabIndexBiblio == 0) {
                SylabusContenidoPK tempPk = new SylabusContenidoPK(biblioSelected.getSylabusContenidoPK().getAnio(), biblioSelected.getSylabusContenidoPK().getCiclo(),
                        biblioSelected.getSylabusContenidoPK().getCodigoMateria(), biblioSelected.getSylabusContenidoPK().getCodigoNivel(),
                        biblioSelected.getSylabusContenidoPK().getVacCodnum(), biblioSelected.getSylabusContenidoPK().getCodParalelo(), biblioSelected.getSylabusContenidoPK().getCodPrograma(),
                        biblioSelected.getSylabusContenidoPK().getCodigoProfesor(), biblioSelected.getSylabusContenidoPK().getNumContenido(), 'C');
                SylabusContenido o = sylabusContenidoFacade.find(tempPk);
                if (o != null) {
                    o.setBiblioTema(contenidoEdit.getBiblioTema());
                    sylabusContenidoFacade.edit(o);
                    msgGuardarTema = "Bibliografía actualizada.";
                }
            } else if (activeTabIndex == 6 && activeTabIndexBiblio == 1) {
                if (biblioGenEdit.getSylabusBiblioPK().getNumeroBiblio() == null) {
                    sylabusBiblioFacade.create(biblioGenEdit);
                    msgGuardarTema = "Bibliografía creada.";
                } else {
                    sylabusBiblioFacade.edit(biblioGenEdit);
                    msgGuardarTema = "Bibliografía actualizada.";
                }
            }
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msgGuardarTema, msgGuardarTema);
            recuperarContenidos();
        } catch (Exception e) {
            if (activeTabIndex == 3) {
                if (contenidoEdit.getSylabusContenidoPK().getNumContenido() == null) {
                    msgGuardarTema = "No puedo crear este tema.";
                } else {
                    msgGuardarTema = "No puedo actualizar este tema.";
                }
            } else {
                msgGuardarTema = "No puedo registrar esta bibliografía.";
            }
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgGuardarTema, msgGuardarTema);
        } finally {
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    //</editor-fold>

    public void onTabChangeX(TabChangeEvent event) {
        biblioGenSelected = null;
        biblioSelected = null;
    }

    public void onTabChange(TabChangeEvent event) {
        guardarButton_processAction(null);
        activeTabIndexObj = 0;
        activeTabIndexArtic = 0;
        activeTabIndexProc = 0;
        activeTabIndexEval = 0;
        activeTabIndexObserv = 0;
        activeTabIndexBiblio = 0;
        if (activeTabIndex == 3 || activeTabIndex == 6 || activeTabIndex == 8) {
            recuperarContenidos();
            if (activeTabIndex == 3) {
                RequestContext.getCurrentInstance().execute("widgetDataTemas.unselectAllRows();");
            } else if (activeTabIndex == 6) {
                RequestContext.getCurrentInstance().execute("widgetDataBiblio.unselectAllRows();");
            }
        }
        if (activeTabIndex == 8) {
            try {
                sylabusDocente = sylabusDocenteFacade.findById(asignaturaSelected);
                RequestContext.getCurrentInstance().update("formMant:tabView:preview");
            } catch (SyllabusException ex) {
                Logger.getLogger(RegSyllabusJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                checkSyllabusDocente();
            }
        }
    }

    @Override
    public void guardarButton_processAction(ActionEvent ae) {
        if (sylabusDocente.getSylabusDocentePK() == null) {
            try {
                SylabusDocentePK docentePK = new SylabusDocentePK(asignaturaSelected.getAnio(), asignaturaSelected.getCiclo(),
                        asignaturaSelected.getAsignaturaSyllabusPK().getCodigoMateria(), usr.getUsuCodigo(), asignaturaSelected.getAsignaturaSyllabusPK().getCodigoNivel(),
                        asignaturaSelected.getAsignaturaSyllabusPK().getVacCodnum(), asignaturaSelected.getAsignaturaSyllabusPK().getCodParalelo(),
                        asignaturaSelected.getAsignaturaSyllabusPK().getCodPrograma());
                sylabusDocente.setSylabusDocentePK(docentePK);
                sylabusDocente.setUsuarioCrea(usr.getUsuCedPass());
                sylabusDocente.setFechaCrea(new Date());
                sylabusDocente.setFechaUltmodific(new Date());
                sylabusDocente.setUsuarioUltmodific(usr.getUsuCedPass());
                sylabusDocente.setEstadoEnvio('P');
                sylabusDocente.setEstadoSylabus('P');
                sylabusDocenteFacade.create(sylabusDocente);
            } catch (Exception e) {
                sylabusDocente.setSylabusDocentePK(null);
                return;
            }
        } else if (sylabusDocente.getEstadoSylabus() != 'A') {
            sylabusDocente.setFechaUltmodific(new Date());
            sylabusDocente.setUsuarioUltmodific(usr.getUsuCedPass());
            sylabusDocenteFacade.edit(sylabusDocente);
        }
        JsfUtil.addSuccessMessage(null, "Sílabo actualizado");

    }

    private boolean checkSyllabus() {
        boolean pendientes = false;
        if (!asignaturaSyllabuses.isEmpty()) {
            for (AsignaturaSyllabus syl : asignaturaSyllabuses) {
                //                System.out.println("envio " + syl.getEstadoEnvio() + " estado " + syl.getEstadoSyllabus() + " observ " + syl.getObservacionCoordinador());
                if (syl.getEstadoEnvio() != null && syl.getEstadoSyllabus() != null) {
                    if (syl.getEstadoEnvio().equals("P") && syl.getEstadoSyllabus().equals("P")) {
                        if (syl.getObservacionCoordinador() != null) {
                            msgNotificacion = "Tiene observaciones en uno o más Sílabo. Por favor reviselos !";
                        } else {
                            msgNotificacion = "Tiene Sílabo pendientes. Por favor reviselos !";
                        }
                        pendientes = true;
                        break;
                    }
                }
            }
        }
        RequestContext.getCurrentInstance().update("notificationBarSyl");
        return pendientes;
    }

    private boolean checkSyllabusDocente() {
        ArrayList msgErrores = new ArrayList();
        if (sylabusDocente != null) {
            if (anio == 2020 && (sylabusDocente.getDescripcionMateria() == null || sylabusDocente.getDescripcionMateria().trim().isEmpty())) {
                msgErrores.add("2.1. Descripción de la asignatura");
            }
            if (sylabusDocente.getObjetivoGeneral() == null || sylabusDocente.getObjetivoGeneral().trim().isEmpty()) {
                msgErrores.add("2.2. Objetivo General no registrado");
            }
            if (sylabusDocente.getObjetivoEspecifico() == null || sylabusDocente.getObjetivoEspecifico().trim().isEmpty()) {
                msgErrores.add("2.3. Objetivos Específicos no registrado");
            }
            if (sylabusDocente.getArticUnidCurricular() == null || sylabusDocente.getArticUnidCurricular().trim().isEmpty()) {
                if (asignaturaSelected.getRegsilago() == 2016) {
                    msgErrores.add("Articulación - 3.1. Unidad curricular no registrado");
                }
                if (asignaturaSelected.getRegsilago() == 2019) {
                    msgErrores.add("Articulación - 3.1. Unidad de organización curricular no registrado");
                }
            }
            if (asignaturaSelected.getRegsilago() == 2016) {
                if (sylabusDocente.getArticAmbiCurricular() == null || sylabusDocente.getArticAmbiCurricular().trim().isEmpty()) {
                    msgErrores.add("Articulación - 3.2. Ámbito curricular no registrado");
                }
            }

            if (sylabusDocente.getArticCampFormacion() == null || sylabusDocente.getArticCampFormacion().trim().isEmpty()) {
                if (asignaturaSelected.getRegsilago() == 2016) {
                    msgErrores.add("Articulación - 3.3. Campo de formación no registrado");
                }
                if (asignaturaSelected.getRegsilago() == 209) {
                    msgErrores.add("Articulación - 3.2. Campo de formación no registrado");
                }
            }

            if (temasSylabus.isEmpty()) {
                msgErrores.add("Contenidos - Temas no registrados");
            } else {
                Integer nroClases = 0;
                for (SylabusContenido temasSylabu : temasSylabus) {
                    nroClases = nroClases + new Integer(temasSylabu.getClase());
                }
                if (!nroClases.equals(sylabusDocente.getNumeroClases())) {
                    msgErrores.add("Contenidos - La sumatoria de el número de clases en los temas no corresponde al numero de clases de la asignatura ");
                }
            }
            if (sylabusDocente.getProcesoDocente() == null || sylabusDocente.getProcesoDocente().trim().isEmpty()) {
                if (asignaturaSelected.getRegsilago() == 2016) {
                    msgErrores.add("Proceso docente - 5.1.1. Horas en aula no registrado");
                }
                if (asignaturaSelected.getRegsilago() == 2019) {
                    msgErrores.add("Proceso docente - 5.1.1. Horas lectivas. no registrado");

                }
            }
            if (asignaturaSelected.getRegsilago() == 2016) {
                if (sylabusDocente.getProcesoDocenteAcomp() == null || sylabusDocente.getProcesoDocenteAcomp().trim().isEmpty()) {
                    msgErrores.add("Proceso docente - 5.1.2. Horas trabajo colaborativo no registrado");
                }

            }
            if (asignaturaSelected.getRegsilago() == 2019) {
                if (sylabusDocente.getCcdSeguimientoTutoria() == null || sylabusDocente.getCcdSeguimientoTutoria().trim().isEmpty()) {
                    msgErrores.add("Proceso docente - 5.1.2. Seguimiento y tutoría no registrado");
                }
            }
//            if (sylabusDocente.getProcesoDocenteActiv() == null || sylabusDocente.getProcesoDocenteActiv().trim().isEmpty()) {
//                msgErrores.add("Proceso docente - 5.3. Actividades de aprendizaje no registrado");
//            }
            if (sylabusDocente.getCoaHorasParcticas() == null || sylabusDocente.getCoaHorasParcticas().trim().isEmpty()) {
                if (asignaturaSelected.getRegsilago() == 2016) {
                    msgErrores.add("Proceso docente - 5.2.1. Horas prácticas de aprendizaje no registrado");
                }
                if (asignaturaSelected.getRegsilago() == 2019) {
                    msgErrores.add("Proceso docente - 5.2.2. Aprendizaje práctico. no registrado");
                }
            }
            if (sylabusDocente.getCoaTrabajoAutonomo() == null || sylabusDocente.getCoaTrabajoAutonomo().trim().isEmpty()) {
                if (asignaturaSelected.getRegsilago() == 2016) {
                    msgErrores.add("Proceso docente - 5.2.2. Horas trabajo autónomo no registrado");
                }
                if (asignaturaSelected.getRegsilago() == 2019) {
                    msgErrores.add("Proceso docente - 5.2.1. Aprendizaje autónomo no registrado");
                }
            }
            if (sylabusDocente.getEvaluacion() == null || sylabusDocente.getEvaluacion().trim().isEmpty()) {
                msgErrores.add("Evaluación - 6.1. Criterios para evaluar no registrado");
            }
            if (sylabusDocente.getEvaluacionElementos() == null || sylabusDocente.getEvaluacionElementos().trim().isEmpty()) {
                msgErrores.add("Evaluación - 6.2. Elementos de calificación no registrado");
            }
            for (SylabusContenido o : biblioSylabus) {
                if (o.getBiblioTema() == null || o.getBiblioTema().trim().isEmpty()) {
                    msgErrores.add("Bibliografía - 7.1. Lectura obligatoria no registrada en algún(os) tema(s)");
                    break;
                }
            }
            for (SylabusBiblio o : bibliografias) {
                if (o.getBibliografia() == null || o.getBibliografia().trim().isEmpty()) {
                    msgErrores.add("Bibliografía - 7.2. Lectura de apoyo no registrada");
                    break;
                }
            }
            if (sylabusDocente.getObservaciones() == null || sylabusDocente.getObservaciones().trim().isEmpty()) {
                msgErrores.add("Observaciones - 8.1. Atención a los estudiantes fuera de clase no registrado");
            }
        }
        if (!msgErrores.isEmpty()) {
            super.getNavigationJSFManagedBean().setMsgError(msgErrores.get(0).toString());
            JsfUtil.addErrorMessages(null, msgErrores);
        }
        return msgErrores.isEmpty();
    }

    public void enviarButton_processAction(ActionEvent ae) {
        if (checkSyllabusDocente() == false) {
            RequestContext.getCurrentInstance().update("dialogMessage");
            RequestContext.getCurrentInstance().execute("errorWidget.show();");
            return;
        }
        try {
            sylabusDocente.setEstadoEnvio('E');
            sylabusDocenteFacade.edit(sylabusDocente, usr, asignaturaSelected, FacesContext.getCurrentInstance());
            asignaturaSyllabuses = asignaturaSyllabusFacade.getAsignatSyllabus(anio, usr.getUsuCodigo());
            JsfUtil.addSuccessMessage(null, "Sílabo enviado al coordinador");
            RequestContext.getCurrentInstance().execute("mantWidget.hide();");
            RequestContext.getCurrentInstance().update("formAsignaturas:dataAsig");
        } catch (Exception e) {
//            super.getNavigationJSFManagedBean().setMsgError("No puedo enviar el comunicado. Por favor comuniquese con el call-center de la Universidad");
//            RequestContext.getCurrentInstance().update("dialogMessage");
//            RequestContext.getCurrentInstance().execute("errorWidget.show();");
        }

    }

    public void copiarButton_processAction(ActionEvent ae) {
        try {
            sylabusDocenteFacade.copy(copiaSelected, asignaturaSelected, usr);
            asignaturaSyllabuses = asignaturaSyllabusFacade.getAsignatSyllabus(anio, usr.getUsuCodigo());
            copiaSelected = null;
            JsfUtil.addSuccessMessage(null, "Sílabo copiado !");
            RequestContext.getCurrentInstance().execute("mantWidget.hide();");
            RequestContext.getCurrentInstance().update("formMant:dataAsig");
            RequestContext.getCurrentInstance().update("formAsignaturas:dataAsig");
        } catch (Exception e) {
            super.getNavigationJSFManagedBean().setMsgError("No puedo hacer la copia. Por favor comuniquese con el call-center de la Universidad");
            RequestContext.getCurrentInstance().update("dialogMessage");
            RequestContext.getCurrentInstance().execute("errorWidget.show();");
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
//        System.out.println(urlReporte);
    }
    //<editor-fold defaultstate="collapsed" desc="CargaTitulos">
    private String titUniCurr;
    private String titCampForm;
    private String numclases;

    public String getNumclases() {
        return numclases;
    }

    public void setNumclases(String numclases) {
        this.numclases = numclases;
    }

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
            titUniCurr = "3.1. Unidad de organización curricular";
            titCampForm = "3.2. Campo de formación";
        }
        //titUniCurr
    }
    //</editor-fold>

}
