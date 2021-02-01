/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.managedBean;

import ec.edu.uasb.entities.Ciudad;
import ec.edu.uasb.infoanual.entities.OtraActividadAcademica;
import ec.edu.uasb.infoanual.entities.OtraActividadAcademicaPK;
import ec.edu.uasb.entities.Pais;
import ec.edu.uasb.infoanual.entities.PublicacionProfesor;
import ec.edu.uasb.infoanual.entities.PublicacionProfesorPK;
import ec.edu.uasb.session.CiudadFacadeLocal;
import ec.edu.uasb.infoanual.session.OtraActividadAcademicaFacadeLocal;
import ec.edu.uasb.session.PaisFacadeLocal;
import ec.edu.uasb.infoanual.session.PublicacionProfesorFacadeLocal;
import ec.edu.uasb.portaldoc.entities.CicloAcademico;
import ec.edu.uasb.portaldoc.session.CicloAcademicoFacadeLocal;
import ec.edu.uasb.seg.entities.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author johana.orozco
 */
@ManagedBean(name = "presencia")
@ViewScoped
public class PresenciaSocialManagedBean implements Serializable {

    private Long codProfesor;
    private Date feciniciclo;
    private Date fecfinciclo;
    private Long anio;
 
    private String msgtablavacia = "No existen datos Registrados";
    //Presencia en Medios
    private List<PublicacionProfesor> listpresmedios = new ArrayList<PublicacionProfesor>();
    PublicacionProfesor presmedio = new PublicacionProfesor();
    private HtmlSelectOneMenu smpresmedtipmedio = new HtmlSelectOneMenu();
    private HtmlInputText itxtpresmeddescripcion = new HtmlInputText();
    private String spresmednumpre;
    //Distinciones Academicas
    private List<OtraActividadAcademica> listDisAcad = new ArrayList<OtraActividadAcademica>();
    OtraActividadAcademica disacad = new OtraActividadAcademica();
    private Date dfecdistacad;
    private HtmlSelectOneMenu smdisacadalcance = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smdisacadtipdist = new HtmlSelectOneMenu();
    private HtmlInputText itxtdisacadnombdist = new HtmlInputText();
    private HtmlInputText itxtdisacadinstitucion = new HtmlInputText();
    private HtmlSelectOneMenu smdisacadpais = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smdisacadciudad = new HtmlSelectOneMenu();
    private HtmlInputText itxtdisacadobservacion = new HtmlInputText();
    private List<Pais> listPaisdist = new ArrayList<Pais>();
    private List<Ciudad> listCiudaddist = new ArrayList<Ciudad>();
    @EJB
    private PublicacionProfesorFacadeLocal publicacionFacade;
    @EJB
    private OtraActividadAcademicaFacadeLocal otraactividadFacade;
    @EJB
    private PaisFacadeLocal paisFacade;
    @EJB
    private CiudadFacadeLocal ciudadFacade;
    @EJB
    private CicloAcademicoFacadeLocal cicloAcademicoFacade;
    private List<CicloAcademico> ciclos = new ArrayList<CicloAcademico>();
    private Usuario usr = new Usuario();
    @ManagedProperty(value = "#{modal}")
    private modalManagedBean modal1;
// <editor-fold defaultstate="collapsed" desc="DECLARACION VARIABLES"> 

    public Date getFeciniciclo() {
        return feciniciclo;
    }

    public void setFeciniciclo(Date feciniciclo) {
        this.feciniciclo = feciniciclo;
    }

    public Date getFecfinciclo() {
        return fecfinciclo;
    }

    public void setFecfinciclo(Date fecfinciclo) {
        this.fecfinciclo = fecfinciclo;
    }

    public List<Ciudad> getListCiudaddist() {
        return listCiudaddist;
    }

    public void setListCiudaddist(List<Ciudad> listCiudaddist) {
        this.listCiudaddist = listCiudaddist;
    }

    public List<Pais> getListPaisdist() {
        listPaisdist = paisFacade.findAllorde();
        return listPaisdist;
    }

    public void setListPaisdist(List<Pais> listPaisdist) {
        this.listPaisdist = listPaisdist;
    }

    public List<PublicacionProfesor> getListpresmedios() {
        return listpresmedios;
    }

    public String getSpresmednumpre() {
        return spresmednumpre;
    }

    public List<OtraActividadAcademica> getListDisAcad() {
        return listDisAcad;
    }

    public void setListDisAcad(List<OtraActividadAcademica> listDisAcad) {
        this.listDisAcad = listDisAcad;
    }

    public Date getDfecdistacad() {
        return dfecdistacad;
    }

    public void setDfecdistacad(Date dfecdistacad) {
        this.dfecdistacad = dfecdistacad;
    }

    public HtmlSelectOneMenu getSmdisacadalcance() {
        return smdisacadalcance;
    }

    public void setSmdisacadalcance(HtmlSelectOneMenu smdisacadalcance) {
        this.smdisacadalcance = smdisacadalcance;
    }

    public HtmlSelectOneMenu getSmdisacadtipdist() {
        return smdisacadtipdist;
    }

    public void setSmdisacadtipdist(HtmlSelectOneMenu smdisacadtipdist) {
        this.smdisacadtipdist = smdisacadtipdist;
    }

    public HtmlInputText getItxtdisacadnombdist() {
        return itxtdisacadnombdist;
    }

    public void setItxtdisacadnombdist(HtmlInputText itxtdisacadnombdist) {
        this.itxtdisacadnombdist = itxtdisacadnombdist;
    }

    public HtmlInputText getItxtdisacadinstitucion() {
        return itxtdisacadinstitucion;
    }

    public void setItxtdisacadinstitucion(HtmlInputText itxtdisacadinstitucion) {
        this.itxtdisacadinstitucion = itxtdisacadinstitucion;
    }

    public HtmlSelectOneMenu getSmdisacadpais() {
        return smdisacadpais;
    }

    public void setSmdisacadpais(HtmlSelectOneMenu smdisacadpais) {
        this.smdisacadpais = smdisacadpais;
    }

    public HtmlSelectOneMenu getSmdisacadciudad() {
        return smdisacadciudad;
    }

    public void setSmdisacadciudad(HtmlSelectOneMenu smdisacadciudad) {
        this.smdisacadciudad = smdisacadciudad;
    }

    public HtmlInputText getItxtdisacadobservacion() {
        return itxtdisacadobservacion;
    }

    public void setItxtdisacadobservacion(HtmlInputText itxtdisacadobservacion) {
        this.itxtdisacadobservacion = itxtdisacadobservacion;
    }

    public void setSpresmednumpre(String spresmednumpre) {
        this.spresmednumpre = spresmednumpre;
    }

    public void setListpresmedios(List<PublicacionProfesor> listpresmedios) {
        this.listpresmedios = listpresmedios;
    }

    public PublicacionProfesor getPresmedio() {
        return presmedio;
    }

    public void setPresmedio(PublicacionProfesor presmedio) {
        this.presmedio = presmedio;
    }

    public HtmlInputText getItxtpresmeddescripcion() {
        return itxtpresmeddescripcion;
    }

    public void setItxtpresmeddescripcion(HtmlInputText itxtpresmeddescripcion) {
        this.itxtpresmeddescripcion = itxtpresmeddescripcion;
    }

    public HtmlSelectOneMenu getSmpresmedtipmedio() {
        return smpresmedtipmedio;
    }

    public void setSmpresmedtipmedio(HtmlSelectOneMenu smpresmedtipmedio) {
        this.smpresmedtipmedio = smpresmedtipmedio;
    }

   
    public String getMsgtablavacia() {
        return msgtablavacia;
    }

    public void setMsgtablavacia(String msgtablavacia) {
        this.msgtablavacia = msgtablavacia;
    }

    public List<CicloAcademico> getCiclos() {
        return ciclos;
    }

    public void setCiclos(List<CicloAcademico> ciclos) {
        this.ciclos = ciclos;
    }

    public modalManagedBean getModal1() {
        return modal1;
    }

    public void setModal1(modalManagedBean modal1) {
        this.modal1 = modal1;
    }
// </editor-fold> 

    /**
     * Creates a new instance of PresenciaSocialManagedBean
     */
    public PresenciaSocialManagedBean() {
        usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        codProfesor = usr.getUsuCodigo();
    }

    @PostConstruct
    private void init() {
        modal1.setBeanpresencia(this);
        ciclos = cicloAcademicoFacade.findByEstado('A');
        if (!ciclos.isEmpty()) {
            anio = ciclos.get(0).getCicloAcademicoPK().getAnio();
            feciniciclo = ciclos.get(0).getFInicio();
            fecfinciclo = ciclos.get(0).getFFinal();
        }
        retrieveDatos(codProfesor, anio);
    }

    private void retrieveDatos(Long codProfesor, Long anio) {
        //Recupero los cursos de educacion continua
        recuperaPresMediosProf(codProfesor, anio);
        //Recupero las distinciones academicas
        recuperaDistAcadProf(codProfesor, anio);
    }

    // <editor-fold defaultstate="collapsed" desc="PRESENCIA SOCIAL"> 
    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA PRESENCIA SOCIAL"> 
    private void recuperaPresMediosProf(Long codProfesor, Long anio) {
        listpresmedios.clear();
        listpresmedios = publicacionFacade.findPresMedProfesor(codProfesor, anio);
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="SELECCION DE FILA PARA EDICION">    
    private PublicacionProfesor selectedpresmedio;

    public PublicacionProfesor getSelectedpresmedio() {
        return selectedpresmedio;
    }

    public void setSelectedpresmedio(PublicacionProfesor selectedpresmedio) {
        this.selectedpresmedio = selectedpresmedio;
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">  
    public void SavePresMed() {
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        PublicacionProfesor presmedaux = new PublicacionProfesor();

        if (presmedio != null) {
            if (presmedio.getPublicacionProfesorPK() != null) {
                presmedaux = publicacionFacade.find(presmedio.getPublicacionProfesorPK());
            }
        }
        try {
            presmedio.setCampo9(smpresmedtipmedio.getValue() == null ? null : smpresmedtipmedio.getValue().toString());
            presmedio.setCampo7(itxtpresmeddescripcion.getValue() == null ? null : itxtpresmeddescripcion.getValue().toString());
            presmedio.setCampo8(spresmednumpre == null ? null : spresmednumpre);
            if (presmedaux.getPublicacionProfesorPK() == null) {
                PublicacionProfesorPK pubprofpk = new PublicacionProfesorPK();
                pubprofpk.setCodigoProfesor(codProfesor);
                presmedio.setPublicacionProfesorPK(pubprofpk);
                presmedio.setTipoPublicacion(-1);
                presmedio.setCampo10(anio.toString());
                presmedio.setFechaCrea(new Date());
                presmedio.setUsuarioCrea("Internet");
                presmedio.setFechaUltmodific(new Date());
                presmedio.setUsuarioUltmodific("Internet");
                publicacionFacade.create(presmedio);
            } else {
                presmedio.setFechaUltmodific(new Date());
                presmedio.setUsuarioUltmodific("Internet");
                publicacionFacade.edit(presmedio);
            }
            //Recuepro los datos de los titulos
            FacesMessage msg = new FacesMessage("Presencia Medios Guardada");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            recuperaPresMediosProf(codProfesor, anio);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al guardar la información");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

        } finally {
            presmedio = new PublicacionProfesor();
            CancelPresMed();
        }

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">  

    public void EditPresMed() {
        if (selectedpresmedio != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            presmedio = selectedpresmedio;
            smpresmedtipmedio.setValue(presmedio.getCampo9() == null ? null : presmedio.getCampo9());
            itxtpresmeddescripcion.setValue(presmedio.getCampo7() == null ? null : presmedio.getCampo7());
            spresmednumpre = (presmedio.getCampo8() == null ? null : presmedio.getCampo8().toString());
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar un registro de Presencia en Medios a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">  

    public void DeletePresMed() {
        if (selectedpresmedio != null) {
            try {
                PublicacionProfesor presmedaux = new PublicacionProfesor();
                presmedaux = publicacionFacade.find(selectedpresmedio.getPublicacionProfesorPK());
                publicacionFacade.remove(presmedaux);
                //Recupero las asignaturas externas
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infopresencia:gpresMed");
                recuperaPresMediosProf(codProfesor, anio);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de: Presencia en Medios", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

            } finally {
                presmedio = new PublicacionProfesor();
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar registro de Presencia en Medios a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">  

    public void CancelPresMed() {
        presmedio = new PublicacionProfesor();
        selectedpresmedio = new PublicacionProfesor();
        smpresmedtipmedio.setValue(null);
        itxtpresmeddescripcion.setValue(null);
        spresmednumpre = null;

    }
    // </editor-fold> 
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="DISTINCION ACADEMICA"> 

    public void paisDistChangeListener() {
        if (smdisacadpais.getValue() != null) {
            listCiudaddist = ciudadFacade.finbyPais((String) smdisacadpais.getValue());
        }
    }
    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA DISTINCION ACADEMICA"> 

    private void recuperaDistAcadProf(Long codProfesor, Long anio) {
               OtraActividadAcademica distacadux = new OtraActividadAcademica();
        List<OtraActividadAcademica> listdistacadaux = new ArrayList<OtraActividadAcademica>();
        Pais paisaxu = new Pais();
        Ciudad ciuaux = new Ciudad();
        listDisAcad.clear();
        listdistacadaux.clear();
        listdistacadaux = otraactividadFacade.findDistAcad(codProfesor, anio);
        for (int i = 0; i < listdistacadaux.size(); i++) {
            distacadux = listdistacadaux.get(i);
            if (distacadux.getPaisInvest() != null) {
                paisaxu = paisFacade.finbyCodigo(distacadux.getPaisInvest());
                if (paisaxu != null) {
                    distacadux.setNomPas(paisaxu.getNomPais());
                    if (distacadux.getCiudadInvest() != null) {
                        if (distacadux.getCiudadInvest() != 0) {
                            ciuaux = ciudadFacade.finbyCodigo(distacadux.getPaisInvest(), distacadux.getCiudadInvest());
                            if (ciuaux != null) {
                                distacadux.setNomCiudad(ciuaux.getNomCiudad());
                            }
                        }
                    }
                }
            }
            if (distacadux.getTipo2Actividad() != null) {
                if (distacadux.getTipo2Actividad() != 0) {
                    switch (distacadux.getTipo2Actividad()) {
                        case 'C':
                            distacadux.setNomEstproyecto("Condecoración");
                            break;
                        case 'P':
                            distacadux.setNomEstproyecto("Premio");
                            break;
                        case 'M':
                            distacadux.setNomEstproyecto("Mención");
                            break;
                        case 'R':
                            distacadux.setNomEstproyecto("Reconocimiento");
                            break;

                    }
                }
            }

            listDisAcad.add(i, distacadux);

        }


    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="SELECCION DE FILA PARA EDICION">    
    private OtraActividadAcademica selecteddisacad;

    public OtraActividadAcademica getSelecteddisacad() {
        return selecteddisacad;
    }

    public void setSelecteddisacad(OtraActividadAcademica selecteddisacad) {
        this.selecteddisacad = selecteddisacad;
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">  
    public void SaveDistAcad() {
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        OtraActividadAcademica distacadaux = new OtraActividadAcademica();
        if (disacad != null) {
            if (disacad.getOtraActividadAcademicaPK() != null) {
                distacadaux = otraactividadFacade.find(disacad.getOtraActividadAcademicaPK());
            }
        }
        try {
            disacad.setNombreActividad(itxtdisacadnombdist.getValue() == null ? null : itxtdisacadnombdist.getValue().toString());
            disacad.setInstitucionActividad(itxtdisacadinstitucion.getValue() == null ? null : itxtdisacadinstitucion.getValue().toString());
            disacad.setObsActividad(itxtdisacadobservacion.getValue() == null ? null : itxtdisacadobservacion.getValue().toString());
            disacad.setSedeInstActividad(smdisacadalcance.getValue() == null ? null : smdisacadalcance.getValue().toString().charAt(0));
            disacad.setTipo2Actividad(smdisacadtipdist.getValue() == null ? null : smdisacadtipdist.getValue().toString().charAt(0));
            disacad.setPaisInvest(smdisacadpais.getValue() == null ? null : smdisacadpais.getValue().toString());
            disacad.setCiudadInvest(smdisacadciudad.getValue() == null ? null : Long.parseLong(smdisacadciudad.getValue().toString()));
            disacad.setFinicioActividad(new java.sql.Date(dfecdistacad.getTime()));
            if (distacadaux.getOtraActividadAcademicaPK() == null) {
                OtraActividadAcademicaPK distacadpk = new OtraActividadAcademicaPK();
                distacadpk.setCodigoProfesor(codProfesor);
                distacadpk.setTipoOtraActividad('D');
                disacad.setOtraActividadAcademicaPK(distacadpk);
                disacad.setFechaCrea(new Date());
                disacad.setUsuarioCrea("Internet");
                disacad.setFechaUltmodific(new Date());
                disacad.setUsuarioUltmodific("Internet");
                otraactividadFacade.create(disacad);
            } else {
                disacad.setFechaUltmodific(new Date());
                disacad.setUsuarioUltmodific("Internet");
                otraactividadFacade.edit(disacad);
            }
            //Recuepro los datos de los titulos            
            FacesMessage msg = new FacesMessage("Distinción Académica Guardada");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            recuperaDistAcadProf(codProfesor, anio);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al Guardar Distinción Académica");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

        } finally {
            disacad = new OtraActividadAcademica();
            CancelDistAcad();
        }

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">  

    public void EditDistAcad() {
        if (selecteddisacad != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            disacad = selecteddisacad;
            itxtdisacadnombdist.setValue(disacad.getNombreActividad() == null ? null : disacad.getNombreActividad());
            itxtdisacadinstitucion.setValue(disacad.getInstitucionActividad() == null ? null : disacad.getInstitucionActividad());
            smdisacadalcance.setValue(disacad.getSedeInstActividad() == null ? null : disacad.getSedeInstActividad());
            smdisacadtipdist.setValue(disacad.getTipo2Actividad() == null ? null : disacad.getTipo2Actividad());
            smdisacadpais.setValue(disacad.getPaisInvest() == null ? null : disacad.getPaisInvest());
            smdisacadciudad.setValue(disacad.getCiudadInvest() == null ? null : disacad.getCiudadInvest());
            paisDistChangeListener();
            itxtdisacadobservacion.setValue(disacad.getObsActividad() == null ? null : disacad.getObsActividad());
            dfecdistacad = new java.sql.Date(disacad.getFinicioActividad().getTime());
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar un registro de Distinción Académica a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">  

    public void DeleteDistAcad() {
        if (selecteddisacad != null) {
            try {
                OtraActividadAcademica distacadaux = new OtraActividadAcademica();
                distacadaux = otraactividadFacade.find(selecteddisacad.getOtraActividadAcademicaPK());
                otraactividadFacade.remove(distacadaux);
                //Recupero las asignaturas externas
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infopresencia:gdistAcad");
                recuperaDistAcadProf(codProfesor, anio);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de: Distinción Académica", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

            } finally {
                disacad = new OtraActividadAcademica();
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar registro de Distinción Académica a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">  

    public void CancelDistAcad() {
        disacad = new OtraActividadAcademica();
        selecteddisacad = new OtraActividadAcademica();
        dfecdistacad = null;
        smdisacadalcance.setValue(null);
        smdisacadtipdist.setValue(null);
        itxtdisacadnombdist.setValue(null);
        itxtdisacadinstitucion.setValue(null);
        smdisacadpais.setValue(null);
        smdisacadciudad.setValue(null);
        itxtdisacadobservacion.setValue(null);

    }
    // </editor-fold> 
    // </editor-fold> 

    public void eliminarRegistro(ActionEvent ae) {
        switch (modal1.getActiveIndexAcoordion()) {
            case 5:
                switch (modal1.getActiveIndexTabviewpresencia()) {
                    case 0:
                        DeletePresMed();
                        break;
                    case 1:
                        DeleteDistAcad();
                        break;
                }
                break;
            default:
                break;
        }
        RequestContext.getCurrentInstance().execute("cconfelgeneral.hide()");
    }

    public void cargaPant(ActionEvent ae) {
        switch (modal1.getActiveIndexAcoordion()) {
            case 5:
                switch (modal1.getActiveIndexTabviewpresencia()) {
                    case 0:
                        modal1.setUrlmodal("/pages/infoanual/presenciaSocial/presenciaMediosModal.xhtml");
                        break;
                    case 1:
                        modal1.setUrlmodal("/pages/infoanual/presenciaSocial/distincionAcademicaModal.xhtml");
                        break;
                }
                break;
            default:
                break;
        }
    }

    public void nuevoRegistro() {
        reset();
        cargaPant(null);
        RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
    }

    public void editarRegistro(ActionEvent ae) {
        cargaPant(null);
        if (modal1.getActiveIndexAcoordion() == 5) {
            switch (modal1.getActiveIndexTabviewpresencia()) {
                case 0:
                    EditPresMed();
                    break;
                case 1:
                    EditDistAcad();
                    break;
                default:
                    break;

            }
        }
    }

    public void onRowSelect(SelectEvent event) {
        if (modal1.getActiveIndexAcoordion() == 5) {
            switch (modal1.getActiveIndexTabviewpresencia()) {
                case 0:
                    selectedpresmedio = (PublicacionProfesor) event.getObject();
                    break;
                case 1:
                    selecteddisacad = (OtraActividadAcademica) event.getObject();
                    break;
                default:
                    break;
            }
        }
    }

    private void reset() {
        selectedpresmedio = null;
        selecteddisacad = null;
    }

    public void onRowUnselect(UnselectEvent event) {
        reset();
    }
}
