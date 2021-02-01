package ec.edu.uasb.infoanual.managedBean;


import ec.edu.uasb.entities.Pais;
import ec.edu.uasb.infoanual.entities.OtraActividadAcademica;
import ec.edu.uasb.infoanual.entities.OtraActividadAcademicaPK;

import ec.edu.uasb.infoanual.session.OtraActividadAcademicaFacadeLocal;
import ec.edu.uasb.portaldoc.entities.CicloAcademico;

import ec.edu.uasb.portaldoc.session.CicloAcademicoFacadeLocal;
import ec.edu.uasb.session.PaisFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
 * @author juan.jaramillo
 */
@ManagedBean(name = "perfeccionamiento")
@ViewScoped
public class PerfeccionamientoDocente implements Serializable{
    //VARIABLES GENERALES
    private Long codProfesor;
    private Long anio;
    private Date feciniciclo;
    private Date fecfinciclo;
    private String msgtablavacia = "No existen datos Registrados";
    //VARIABLES PARA PERFECCIONAMIENTO DOCENTE
    private List<OtraActividadAcademica> listPerfDoc = new ArrayList<OtraActividadAcademica>();
    OtraActividadAcademica perfdoc = new OtraActividadAcademica();
    private HtmlSelectOneMenu smperfdocestado = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smperfdocpais = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smtipactperfdoc = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smperfdoctiporg = new HtmlSelectOneMenu();
    private HtmlInputText itxtnomactividadperfdoc = new HtmlInputText();
    private HtmlInputText itxtinstitucionperfdoc = new HtmlInputText();
    private HtmlInputText itxtdetotrotipactperfdoc = new HtmlInputText();
    private HtmlInputText itxtobsperfdoc = new HtmlInputText();
    private HtmlInputText itxtdetatipperfecdoc = new HtmlInputText();
    private String sperfdocnumh;
    private Date dfeciniperfdoc;
    private Date dfecfinperfdoc;
    //VARIABLES DE APOYO
    private List<CicloAcademico> ciclos = new ArrayList<CicloAcademico>();
    private List<Pais> listperfdocPais = new ArrayList<Pais>();
    private boolean btipo = false;
    //VARIABLES ENTERPRISE JAVABEANS
    @EJB
    private CicloAcademicoFacadeLocal cicloAcademicoFacade;
    @EJB
    private OtraActividadAcademicaFacadeLocal otraactividadFacade;
    @EJB
    private PaisFacadeLocal paisFacade;
    //private Usuario usr = new Usuario();
    //Iyeccion del Managed Bean
    @ManagedProperty( value = "#{modal}")
    private modalManagedBean modal1;
    
    // <editor-fold defaultstate="collapsed" desc="DECLARACION VARIABLES">
    public modalManagedBean getModal1() {
        return modal1;
    }

    public void setModal1(modalManagedBean modal1) {
        this.modal1 = modal1;
    }

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
    
    public String getMsgtablavacia() {
        return msgtablavacia;
    }

    public void setMsgtablavacia(String msgtablavacia) {
        this.msgtablavacia = msgtablavacia;
    }

    public List<OtraActividadAcademica> getListPerfDoc() {
        return listPerfDoc;
    }

    public void setListPerfDoc(List<OtraActividadAcademica> listPerfDoc) {
        this.listPerfDoc = listPerfDoc;
    }

    public HtmlSelectOneMenu getSmperfdocestado() {
        return smperfdocestado;
    }

    public void setSmperfdocestado(HtmlSelectOneMenu smperfdocestado) {
        this.smperfdocestado = smperfdocestado;
    }

    public HtmlSelectOneMenu getSmperfdocpais() {
        return smperfdocpais;
    }

    public void setSmperfdocpais(HtmlSelectOneMenu smperfdocpais) {
        this.smperfdocpais = smperfdocpais;
    }

    public HtmlSelectOneMenu getSmtipactperfdoc() {
        return smtipactperfdoc;
    }

    public void setSmtipactperfdoc(HtmlSelectOneMenu smtipactperfdoc) {
        this.smtipactperfdoc = smtipactperfdoc;
    }

    public HtmlSelectOneMenu getSmperfdoctiporg() {
        return smperfdoctiporg;
    }

    public void setSmperfdoctiporg(HtmlSelectOneMenu smperfdoctiporg) {
        this.smperfdoctiporg = smperfdoctiporg;
    }

    public HtmlInputText getItxtnomactividadperfdoc() {
        return itxtnomactividadperfdoc;
    }

    public void setItxtnomactividadperfdoc(HtmlInputText itxtnomactividadperfdoc) {
        this.itxtnomactividadperfdoc = itxtnomactividadperfdoc;
    }

    public HtmlInputText getItxtinstitucionperfdoc() {
        return itxtinstitucionperfdoc;
    }

    public void setItxtinstitucionperfdoc(HtmlInputText itxtinstitucionperfdoc) {
        this.itxtinstitucionperfdoc = itxtinstitucionperfdoc;
    }

    public HtmlInputText getItxtdetotrotipactperfdoc() {
        return itxtdetotrotipactperfdoc;
    }

    public void setItxtdetotrotipactperfdoc(HtmlInputText itxtdetotrotipactperfdoc) {
        this.itxtdetotrotipactperfdoc = itxtdetotrotipactperfdoc;
    }

    public HtmlInputText getItxtobsperfdoc() {
        return itxtobsperfdoc;
    }

    public void setItxtobsperfdoc(HtmlInputText itxtobsperfdoc) {
        this.itxtobsperfdoc = itxtobsperfdoc;
    }

    public Date getDfeciniperfdoc() {
        return dfeciniperfdoc;
    }

    public void setDfeciniperfdoc(Date dfeciniperfdoc) {
        this.dfeciniperfdoc = dfeciniperfdoc;
    }

    public Date getDfecfinperfdoc() {
        return dfecfinperfdoc;
    }

    public void setDfecfinperfdoc(Date dfecfinperfdoc) {
        this.dfecfinperfdoc = dfecfinperfdoc;
    }

    public String getSperfdocnumh() {
        return sperfdocnumh;
    }

    public void setSperfdocnumh(String sperfdocnumh) {
        this.sperfdocnumh = sperfdocnumh;
    }
    
    public List<Pais> getListperfdocPais() {
        listperfdocPais = paisFacade.findAllorde();
        return listperfdocPais;
    }

    public void setListperfdocPais(List<Pais> listperfdocPais) {
        this.listperfdocPais = listperfdocPais;
    }
    
    public HtmlInputText getItxtdetatipperfecdoc() {
        return itxtdetatipperfecdoc;
    }

    public void setItxtdetatipperfecdoc(HtmlInputText itxtdetatipperfecdoc) {
        this.itxtdetatipperfecdoc = itxtdetatipperfecdoc;
    }
    
    public boolean isBtipo() {
        return btipo;
    }

    public void setBtipo(boolean btipo) {
        this.btipo = btipo;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="METODOS GENERALES">
    public PerfeccionamientoDocente(){
        //usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        //codProfesor = usr.getUsuCodigo();
    }
    @PostConstruct
    public void init(){
        modal1.setBeanperfeccionamiento(this);
        ciclos = cicloAcademicoFacade.findByEstado('A');
        if (!ciclos.isEmpty()) {
            anio = ciclos.get(0).getCicloAcademicoPK().getAnio();
            feciniciclo = ciclos.get(0).getFInicio();
            fecfinciclo = ciclos.get(0).getFFinal();
        }
        codProfesor = Long.parseLong("34");
        retrieveDatos(codProfesor, anio);
    }
    
    private void retrieveDatos(Long codProfesor, Long anio) {
        //Recupero el perfeccionamiento docente
        recuperaPerfDoc(codProfesor, anio);
    }
    
    public void typeValueChangeListener(){
        if(smtipactperfdoc.getValue() != null){
            if(Integer.parseInt(smtipactperfdoc.getValue().toString()) == -1){
                btipo = true;
            }else{
                itxtdetatipperfecdoc.setValue(null);
                btipo = false;
            }
        }else{
            itxtdetatipperfecdoc.setValue(null);
            btipo = false;
        }
    } 
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="PERFECCIONAMIENTO DOCENTE">
    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA PERFECCIONAMIENTO DOCENTE"> 
    private void recuperaPerfDoc(Long codProfesor, Long anio) {
        listPerfDoc.clear();
        listPerfDoc = otraactividadFacade.findPerfDoc(codProfesor, anio);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SELECCION DE FILA PARA EDICION">    
    private OtraActividadAcademica selectedperfdoc;

    public OtraActividadAcademica getSelectedperfdoc() {
        return selectedperfdoc;
    }

    public void setSelectedperfdoc(OtraActividadAcademica selectedperfdoc) {
        this.selectedperfdoc = selectedperfdoc;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">
    public void SavePerfDoc() {
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        OtraActividadAcademica perfdocaux = new OtraActividadAcademica();
        if (perfdoc != null) {
            if (perfdoc.getOtraActividadAcademicaPK() != null) {
                perfdocaux = otraactividadFacade.find(perfdoc.getOtraActividadAcademicaPK());
            }
        }
        try {
            perfdoc.setTipo2Actividad(smperfdocestado.getValue()== null ? null : smperfdocestado.getValue().toString().charAt(0));
            perfdoc.setPaisInvest(smperfdocpais.getValue()== null ? null :smperfdocpais.getValue().toString() );
            perfdoc.setTipoActividad(smtipactperfdoc.getValue() == null ? null : Long.parseLong(smtipactperfdoc.getValue().toString()));
            perfdoc.setNombreActividad(itxtnomactividadperfdoc.getValue() == null ? null : itxtnomactividadperfdoc.getValue().toString().toUpperCase());
            perfdoc.setInstitucionActividad(itxtinstitucionperfdoc.getValue() == null ? null : itxtinstitucionperfdoc.getValue().toString().toUpperCase());
            perfdoc.setTituloActividad(smtipactperfdoc.getValue().toString().equalsIgnoreCase("-1") ? itxtdetotrotipactperfdoc.getValue() == null ? null : itxtdetotrotipactperfdoc.getValue().toString().toUpperCase() : null);
            perfdoc.setSedeInstActividad(smperfdoctiporg.getValue() == null ? null : smperfdoctiporg.getValue().toString().charAt(0));
            perfdoc.setObsActividad(itxtobsperfdoc.getValue() == null ? null : itxtobsperfdoc.getValue().toString().toUpperCase());
            perfdoc.setDuracionActividad(sperfdocnumh == null ? null : Integer.parseInt(sperfdocnumh));
            perfdoc.setFinicioActividad(new java.sql.Date(dfeciniperfdoc.getTime()));
            perfdoc.setFfinActividad(dfecfinperfdoc == null ? null : new java.sql.Date(dfecfinperfdoc.getTime()));
            perfdoc.setProgramaActividad(itxtdetatipperfecdoc.getValue() == null ? null : itxtdetatipperfecdoc.getValue().toString());
            if (perfdocaux.getOtraActividadAcademicaPK() == null) {
                OtraActividadAcademicaPK perfdocpk = new OtraActividadAcademicaPK();
                perfdocpk.setCodigoProfesor(codProfesor);
                perfdocpk.setTipoOtraActividad('O');
                perfdoc.setOtraActividadAcademicaPK(perfdocpk);
                perfdoc.setFechaCrea(new Date());
                perfdoc.setUsuarioCrea("Internet");
                perfdoc.setFechaUltmodific(new Date());
                perfdoc.setUsuarioUltmodific("Internet");
                otraactividadFacade.create(perfdoc);
            } else {
                perfdoc.setFechaUltmodific(new Date());
                perfdoc.setUsuarioUltmodific("Internet");
                otraactividadFacade.edit(perfdoc);
            }
            //Recuepro los datos de los titulos
            FacesMessage msg = new FacesMessage("Perfeccionamiento Docente Guardado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            recuperaPerfDoc(codProfesor, anio);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al guardar la información");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

        } finally {
            perfdoc = new OtraActividadAcademica();
            CancelPerfDoc();
        }
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">
    public void EditPerfDoc() {
        if (selectedperfdoc != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            perfdoc = selectedperfdoc;
            smtipactperfdoc.setValue(perfdoc.getTipoActividad() == null ? null : perfdoc.getTipoActividad());
            typeValueChangeListener();
            itxtnomactividadperfdoc.setValue(perfdoc.getNombreActividad() == null ? null : perfdoc.getNombreActividad());
            itxtdetotrotipactperfdoc.setValue(perfdoc.getTituloActividad() == null ? null : perfdoc.getTituloActividad());
            itxtinstitucionperfdoc.setValue(perfdoc.getInstitucionActividad() == null ? null : perfdoc.getInstitucionActividad());
            sperfdocnumh = (perfdoc.getDuracionActividad() == null ? null : perfdoc.getDuracionActividad().toString());
            smperfdoctiporg.setValue(perfdoc.getSedeInstActividad() == null ? null : perfdoc.getSedeInstActividad().charValue());
            dfeciniperfdoc = (perfdoc.getFinicioActividad() == null ? null : new java.sql.Date(perfdoc.getFinicioActividad().getTime()));
            dfecfinperfdoc = (perfdoc.getFfinActividad() == null ? null : new java.sql.Date(perfdoc.getFfinActividad().getTime()));
            itxtobsperfdoc.setValue(perfdoc.getObsActividad() == null ? null : perfdoc.getObsActividad());
            smperfdocpais.setValue(perfdoc.getPaisInvest()== null ? null : perfdoc.getPaisInvest() );
            smperfdocestado.setValue(perfdoc.getTipo2Actividad()== null ? null : perfdoc.getTipo2Actividad());
            itxtdetatipperfecdoc.setValue(perfdoc.getProgramaActividad() == null ? null : perfdoc.getProgramaActividad());
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Perfeccionamiento a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">
    public void DeletePerfDoc() {
        if (selectedperfdoc != null) {
            try {
                OtraActividadAcademica perfdocaux;
                perfdocaux = otraactividadFacade.find(selectedperfdoc.getOtraActividadAcademicaPK());
                otraactividadFacade.remove(perfdocaux);
                //Recupero las asignaturas externas
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:perfecdoce:gperfdocente");
                recuperaPerfDoc(codProfesor, anio);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de: Perfeccionamiento Docente", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            } finally {
                perfdoc = new OtraActividadAcademica();
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar un registro de Perfeccionamiento Docente a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">  

    public void CancelPerfDoc() {
        selectedperfdoc = new OtraActividadAcademica();
        perfdoc = new OtraActividadAcademica();
        smperfdocestado.setValue(null);
        smperfdocpais.setValue(null);
        smtipactperfdoc.setValue(null);
        itxtnomactividadperfdoc.setValue(null);
        itxtinstitucionperfdoc.setValue(null);
        itxtdetotrotipactperfdoc.setValue(null);
        smperfdoctiporg.setValue(null);
        itxtobsperfdoc.setValue(null);    
        sperfdocnumh=null;    
        dfeciniperfdoc = null;
        dfecfinperfdoc = null;
        itxtdetatipperfecdoc.setValue(null);
    }
    // </editor-fold>
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="METODOS MANEJO DE BEAN">
    public void nuevoRegistro() {
        reset();
        cargaPant(null);
        RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
    }
    
    public void cargaPant(ActionEvent ae){
        if (modal1.getActiveIndexAcoordion() == 4){
            switch (modal1.getActiveIndexTabviewperfecdoc()){
                case 0:
                    modal1.setUrlmodal("/pages/infoanual/perfeccionamientoDocente/perfeccionamientoDocenteModal.xhtml");
                    break;
                default:
                    break;
            }
        }
    }
    
    public void editarRegistro(ActionEvent ae){
        cargaPant(null);
        if (modal1.getActiveIndexAcoordion() == 4){
            switch (modal1.getActiveIndexTabviewperfecdoc()){
                case 0:
                    EditPerfDoc();
                    break;
                default:
                    break;
            }
        }
    }
    
    public void onRowSelect(SelectEvent event){
        if (modal1.getActiveIndexAcoordion() == 4){
            switch (modal1.getActiveIndexTabviewperfecdoc()){
                case 0:
                    selectedperfdoc = (OtraActividadAcademica) event.getObject();
                    break;
                default:
                    break;
            }
        }
    }
    
    public void onRowUnselect(UnselectEvent event) {
        reset();
    }
    
    private void reset() {
        selectedperfdoc = null;
    }
    
    public void eliminarRegistro(ActionEvent ae){
        if (modal1.getActiveIndexAcoordion() == 4){
            switch (modal1.getActiveIndexTabviewperfecdoc()){
                case 0:
                    DeletePerfDoc();
                    break;
                default:
                    break;
            }
        }
        RequestContext.getCurrentInstance().execute("cconfelgeneral.hide()");
    }
    // </editor-fold>
}