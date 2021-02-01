/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.managedBean;


import ec.edu.uasb.entities.Facultad;
import ec.edu.uasb.entities.Pais;
import ec.edu.uasb.infoanual.entities.OtraActividadAcademica;
import ec.edu.uasb.infoanual.entities.OtraActividadAcademicaPK;

import ec.edu.uasb.infoanual.session.FacultadFacadeLocal;
import ec.edu.uasb.infoanual.session.OtraActividadAcademicaFacadeLocal;
import ec.edu.uasb.portaldoc.entities.CicloAcademico;

import ec.edu.uasb.portaldoc.session.CicloAcademicoFacadeLocal;
import ec.edu.uasb.session.PaisFacadeLocal;
//import ec.edu.uasb.seg.entities.Usuario;
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
 * @author johana.orozco
 */
@ManagedBean(name = "gestion")
@ViewScoped
public class GestionAcademica implements Serializable {

    private Long codProfesor;
    private Date feciniciclo;
    private Date fecfinciclo;
    private Long anio;
    
    private String msgtablavacia = "No existen datos Registrados";
    //Funciones Academicas
    private List<OtraActividadAcademica> listFunAcad = new ArrayList<OtraActividadAcademica>();
    OtraActividadAcademica funacad = new OtraActividadAcademica();
    private HtmlSelectOneMenu smtipfunacad = new HtmlSelectOneMenu();
    private HtmlInputText itxtdetfunacad = new HtmlInputText();
    private Date dfecinifunacad;
    private Date dfecfinfunacad;
    private HtmlInputText itxtobsfunacad = new HtmlInputText();
    //Coordinacion Academica
    private List<OtraActividadAcademica> listCoorAcad = new ArrayList<OtraActividadAcademica>();
    OtraActividadAcademica cooracad = new OtraActividadAcademica();
    private HtmlSelectOneMenu smtipcooracad = new HtmlSelectOneMenu();
    private HtmlInputText itxtdetcooracad = new HtmlInputText();
    private Date dfecinicooracad;
    private Date dfecfincooracad;
    private HtmlInputText itxtobscooracad = new HtmlInputText();
    //Miembro Comite Institucional
    private List<OtraActividadAcademica> listComInst = new ArrayList<OtraActividadAcademica>();
    OtraActividadAcademica cominst = new OtraActividadAcademica();
    private HtmlSelectOneMenu smtipcominst = new HtmlSelectOneMenu();
    private HtmlInputText itxtdetcominst = new HtmlInputText();
    private Date dfecinicominst;
    private Date dfecfincominst;
    private HtmlInputText itxtobscominst = new HtmlInputText();
    private String numsesiones;
    private String numanualsesiones;
    //Miembro Comite Tribunal
    private List<OtraActividadAcademica> listComiTri = new ArrayList<OtraActividadAcademica>();
    OtraActividadAcademica comitri = new OtraActividadAcademica();
    private HtmlSelectOneMenu smtipcomitri = new HtmlSelectOneMenu();
    private HtmlInputText itxtdetcomitri = new HtmlInputText();
    private Date dfecinicomitri;
    private Date dfecfincomitri;
    private HtmlInputText itxtobscomitri = new HtmlInputText();
    private HtmlInputText itxtdetatipcom = new HtmlInputText();
    private String numanualsesionescomitri;
    private boolean btipo = false;
    //Diseño Programa de Posgrado
    private List<OtraActividadAcademica> listProgPos = new ArrayList<OtraActividadAcademica>();
    OtraActividadAcademica progpos = new OtraActividadAcademica();
    private HtmlSelectOneMenu smtipprogpos = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smareprogpos = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smestprogpos = new HtmlSelectOneMenu();
    private HtmlInputText itxtdetprogpos = new HtmlInputText();
    private HtmlInputText itxtobsprogpos = new HtmlInputText();
    private Date dfeciniprogpos;
    private Date dfecfinprogpos;
    //Diseño Educacion Continua
    private List<OtraActividadAcademica> listEduCont = new ArrayList<OtraActividadAcademica>();
    OtraActividadAcademica educont = new OtraActividadAcademica();
    private HtmlSelectOneMenu smtipeducont = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smareeducont = new HtmlSelectOneMenu();
    private String numhoraseducont;
    private HtmlInputText itxtdeteducont = new HtmlInputText();
    private HtmlInputText itxtobseducont = new HtmlInputText();
    private Date dfecinieducont;
    private Date dfecfineducont;
    //Organizacion Actividades Vinculacion
    private List<OtraActividadAcademica> listActVinc = new ArrayList<OtraActividadAcademica>();
    OtraActividadAcademica actvinc = new OtraActividadAcademica();
    private HtmlSelectOneMenu smtipactvinc = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smalcactvinc = new HtmlSelectOneMenu();
    private String numhorasactvinc;
    private HtmlInputText itxtdetactvinc = new HtmlInputText();
    private HtmlInputText itxtobsactvinc = new HtmlInputText();
    private Date dfeciniactvinc;
    private Date dfecfinactvinc;
    //Organizacion Actividades Vinculacion
    private List<OtraActividadAcademica> listOtrFun = new ArrayList<OtraActividadAcademica>();
    OtraActividadAcademica otrfun = new OtraActividadAcademica();
    private HtmlInputText itxtdetotrfun = new HtmlInputText();
    private HtmlInputText itxtobsotrfun = new HtmlInputText();
    private Date dfeciniotrfun;
    private Date dfecfinotrfun;
    
    private List<Pais> listperfdocPais = new ArrayList<Pais>();
    private List<Facultad> listFacultad = new ArrayList<Facultad>();
    @EJB
    private FacultadFacadeLocal facultadFacade;
    @EJB
    private OtraActividadAcademicaFacadeLocal otraactividadFacade;
    @EJB
    private PaisFacadeLocal paisFacade;
    @EJB
    private CicloAcademicoFacadeLocal cicloAcademicoFacade;
    private List<CicloAcademico> ciclos = new ArrayList<CicloAcademico>();
   // private Usuario usr = new Usuario();
    @ManagedProperty( value = "#{modal}")
    private modalManagedBean modal1;

    // <editor-fold defaultstate="collapsed" desc="DECLARACION VARIABLES"> 
    public modalManagedBean getModal1() {
        return modal1;
    }

    public void setModal1(modalManagedBean modal1) {
        this.modal1 = modal1;
    }

    public List<Pais> getListperfdocPais() {
        listperfdocPais = paisFacade.findAllorde();
        return listperfdocPais;
    }

    public void setListperfdocPais(List<Pais> listperfdocPais) {
        this.listperfdocPais = listperfdocPais;
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

    public Date getDfecinifunacad() {
        return dfecinifunacad;
    }

    public void setDfecinifunacad(Date dfecinifunacad) {
        this.dfecinifunacad = dfecinifunacad;
    }

    public List<OtraActividadAcademica> getListFunAcad() {
        return listFunAcad;
    }

    public void setListFunAcad(List<OtraActividadAcademica> listFunAcad) {
        this.listFunAcad = listFunAcad;
    }

    public HtmlSelectOneMenu getSmtipfunacad() {
        return smtipfunacad;
    }

    public void setSmtipfunacad(HtmlSelectOneMenu smtipfunacad) {
        this.smtipfunacad = smtipfunacad;
    }

    public HtmlInputText getItxtdetfunacad() {
        return itxtdetfunacad;
    }

    public void setItxtdetfunacad(HtmlInputText itxtdetfunacad) {
        this.itxtdetfunacad = itxtdetfunacad;
    }

    public Date getDfecfinfunacad() {
        return dfecfinfunacad;
    }

    public void setDfecfinfunacad(Date dfecfinfunacad) {
        this.dfecfinfunacad = dfecfinfunacad;
    }

    public HtmlInputText getItxtobsfunacad() {
        return itxtobsfunacad;
    }

    public void setItxtobsfunacad(HtmlInputText itxtobsfunacad) {
        this.itxtobsfunacad = itxtobsfunacad;
    }
    
    public List<OtraActividadAcademica> getListCoorAcad() {
        return listCoorAcad;
    }

    public void setListCoorAcad(List<OtraActividadAcademica> listCoorAcad) {
        this.listCoorAcad = listCoorAcad;
    }
    
    public HtmlSelectOneMenu getSmtipcooracad() {
        return smtipcooracad;
    }

    public void setSmtipcooracad(HtmlSelectOneMenu smtipcooracad) {
        this.smtipcooracad = smtipcooracad;
    }
    
    public HtmlInputText getItxtdetcooracad() {
        return itxtdetcooracad;
    }

    public void setItxtdetcooracad(HtmlInputText itxtdetcooracad) {
        this.itxtdetcooracad = itxtdetcooracad;
    }
    
    public Date getDfecinicooracad() {
        return dfecinicooracad;
    }

    public void setDfecinicooracad(Date dfecinicooracad) {
        this.dfecinicooracad = dfecinicooracad;
    }

    public Date getDfecfincooracad() {
        return dfecfincooracad;
    }

    public void setDfecfincooracad(Date dfecfincooracad) {
        this.dfecfincooracad = dfecfincooracad;
    }

    public HtmlInputText getItxtobscooracad() {
        return itxtobscooracad;
    }

    public void setItxtobscooracad(HtmlInputText itxtobscooracad) {
        this.itxtobscooracad = itxtobscooracad;
    }
    
    public List<OtraActividadAcademica> getListComInst() {
        return listComInst;
    }

    public void setListComInst(List<OtraActividadAcademica> listComInst) {
        this.listComInst = listComInst;
    }

    public HtmlSelectOneMenu getSmtipcominst() {
        return smtipcominst;
    }

    public void setSmtipcominst(HtmlSelectOneMenu smtipcominst) {
        this.smtipcominst = smtipcominst;
    }

    public HtmlInputText getItxtdetcominst() {
        return itxtdetcominst;
    }

    public void setItxtdetcominst(HtmlInputText itxtdetcominst) {
        this.itxtdetcominst = itxtdetcominst;
    }

    public Date getDfecinicominst() {
        return dfecinicominst;
    }

    public void setDfecinicominst(Date dfecinicominst) {
        this.dfecinicominst = dfecinicominst;
    }

    public Date getDfecfincominst() {
        return dfecfincominst;
    }

    public void setDfecfincominst(Date dfecfincominst) {
        this.dfecfincominst = dfecfincominst;
    }

    public HtmlInputText getItxtobscominst() {
        return itxtobscominst;
    }

    public void setItxtobscominst(HtmlInputText itxtobscominst) {
        this.itxtobscominst = itxtobscominst;
    }
    
    public String getNumsesiones() {
        return numsesiones;
    }

    public void setNumsesiones(String numsesiones) {
        this.numsesiones = numsesiones;
    }

    public String getNumanualsesiones() {
        return numanualsesiones;
    }

    public void setNumanualsesiones(String numanualsesiones) {
        this.numanualsesiones = numanualsesiones;
    }
    
    public List<OtraActividadAcademica> getListComiTri() {
        return listComiTri;
    }

    public void setListComiTri(List<OtraActividadAcademica> listComiTri) {
        this.listComiTri = listComiTri;
    }

    public HtmlSelectOneMenu getSmtipcomitri() {
        return smtipcomitri;
    }

    public void setSmtipcomitri(HtmlSelectOneMenu smtipcomitri) {
        this.smtipcomitri = smtipcomitri;
    }

    public HtmlInputText getItxtdetcomitri() {
        return itxtdetcomitri;
    }

    public void setItxtdetcomitri(HtmlInputText itxtdetcomitri) {
        this.itxtdetcomitri = itxtdetcomitri;
    }

    public Date getDfecinicomitri() {
        return dfecinicomitri;
    }

    public void setDfecinicomitri(Date dfecinicomitri) {
        this.dfecinicomitri = dfecinicomitri;
    }

    public Date getDfecfincomitri() {
        return dfecfincomitri;
    }

    public void setDfecfincomitri(Date dfecfincomitri) {
        this.dfecfincomitri = dfecfincomitri;
    }

    public HtmlInputText getItxtobscomitri() {
        return itxtobscomitri;
    }

    public void setItxtobscomitri(HtmlInputText itxtobscomitri) {
        this.itxtobscomitri = itxtobscomitri;
    }

    public String getNumanualsesionescomitri() {
        return numanualsesionescomitri;
    }

    public void setNumanualsesionescomitri(String numanualsesionescomitri) {
        this.numanualsesionescomitri = numanualsesionescomitri;
    }
    
    public List<OtraActividadAcademica> getListProgPos() {
        return listProgPos;
    }

    public void setListProgPos(List<OtraActividadAcademica> listProgPos) {
        this.listProgPos = listProgPos;
    }

    public HtmlSelectOneMenu getSmtipprogpos() {
        return smtipprogpos;
    }

    public void setSmtipprogpos(HtmlSelectOneMenu smtipprogpos) {
        this.smtipprogpos = smtipprogpos;
    }

    public HtmlSelectOneMenu getSmareprogpos() {
        return smareprogpos;
    }

    public void setSmareprogpos(HtmlSelectOneMenu smareprogpos) {
        this.smareprogpos = smareprogpos;
    }

    public HtmlSelectOneMenu getSmestprogpos() {
        return smestprogpos;
    }

    public void setSmestprogpos(HtmlSelectOneMenu smestprogpos) {
        this.smestprogpos = smestprogpos;
    }

    public HtmlInputText getItxtdetprogpos() {
        return itxtdetprogpos;
    }

    public void setItxtdetprogpos(HtmlInputText itxtdetprogpos) {
        this.itxtdetprogpos = itxtdetprogpos;
    }

    public HtmlInputText getItxtobsprogpos() {
        return itxtobsprogpos;
    }

    public void setItxtobsprogpos(HtmlInputText itxtobsprogpos) {
        this.itxtobsprogpos = itxtobsprogpos;
    }

    public Date getDfeciniprogpos() {
        return dfeciniprogpos;
    }

    public void setDfeciniprogpos(Date dfeciniprogpos) {
        this.dfeciniprogpos = dfeciniprogpos;
    }

    public Date getDfecfinprogpos() {
        return dfecfinprogpos;
    }

    public void setDfecfinprogpos(Date dfecfinprogpos) {
        this.dfecfinprogpos = dfecfinprogpos;
    }
    
    public List<Facultad> getListFacultad() {
        listFacultad = facultadFacade.findAllactiva();
        return listFacultad;
    }

    public void setListFacultad(List<Facultad> listFacultad) {
        this.listFacultad = listFacultad;
    }
    
    public List<OtraActividadAcademica> getListEduCont() {
        return listEduCont;
    }

    public void setListEduCont(List<OtraActividadAcademica> listEduCont) {
        this.listEduCont = listEduCont;
    }

    public HtmlSelectOneMenu getSmtipeducont() {
        return smtipeducont;
    }

    public void setSmtipeducont(HtmlSelectOneMenu smtipeducont) {
        this.smtipeducont = smtipeducont;
    }

    public HtmlSelectOneMenu getSmareeducont() {
        return smareeducont;
    }

    public void setSmareeducont(HtmlSelectOneMenu smareeducont) {
        this.smareeducont = smareeducont;
    }

    public String getNumhoraseducont() {
        return numhoraseducont;
    }

    public void setNumhoraseducont(String numhoraseducont) {
        this.numhoraseducont = numhoraseducont;
    }

    public HtmlInputText getItxtdeteducont() {
        return itxtdeteducont;
    }

    public void setItxtdeteducont(HtmlInputText itxtdeteducont) {
        this.itxtdeteducont = itxtdeteducont;
    }

    public HtmlInputText getItxtobseducont() {
        return itxtobseducont;
    }

    public void setItxtobseducont(HtmlInputText itxtobseducont) {
        this.itxtobseducont = itxtobseducont;
    }

    public Date getDfecinieducont() {
        return dfecinieducont;
    }

    public void setDfecinieducont(Date dfecinieducont) {
        this.dfecinieducont = dfecinieducont;
    }

    public Date getDfecfineducont() {
        return dfecfineducont;
    }

    public void setDfecfineducont(Date dfecfineducont) {
        this.dfecfineducont = dfecfineducont;
    }
    
    public List<OtraActividadAcademica> getListActVinc() {
        return listActVinc;
    }

    public void setListActVinc(List<OtraActividadAcademica> listActVinc) {
        this.listActVinc = listActVinc;
    }

    public HtmlSelectOneMenu getSmtipactvinc() {
        return smtipactvinc;
    }

    public void setSmtipactvinc(HtmlSelectOneMenu smtipactvinc) {
        this.smtipactvinc = smtipactvinc;
    }

    public HtmlSelectOneMenu getSmalcactvinc() {
        return smalcactvinc;
    }

    public void setSmalcactvinc(HtmlSelectOneMenu smalcactvinc) {
        this.smalcactvinc = smalcactvinc;
    }

    public String getNumhorasactvinc() {
        return numhorasactvinc;
    }

    public void setNumhorasactvinc(String numhorasactvinc) {
        this.numhorasactvinc = numhorasactvinc;
    }

    public HtmlInputText getItxtdetactvinc() {
        return itxtdetactvinc;
    }

    public void setItxtdetactvinc(HtmlInputText itxtdetactvinc) {
        this.itxtdetactvinc = itxtdetactvinc;
    }

    public HtmlInputText getItxtobsactvinc() {
        return itxtobsactvinc;
    }

    public void setItxtobsactvinc(HtmlInputText itxtobsactvinc) {
        this.itxtobsactvinc = itxtobsactvinc;
    }

    public Date getDfeciniactvinc() {
        return dfeciniactvinc;
    }

    public void setDfeciniactvinc(Date dfeciniactvinc) {
        this.dfeciniactvinc = dfeciniactvinc;
    }

    public Date getDfecfinactvinc() {
        return dfecfinactvinc;
    }

    public void setDfecfinactvinc(Date dfecfinactvinc) {
        this.dfecfinactvinc = dfecfinactvinc;
    }
    
    public boolean isBtipo() {
        return btipo;
    }

    public void setBtipo(boolean btipo) {
        this.btipo = btipo;
    }
    
    public HtmlInputText getItxtdetatipcom() {
        return itxtdetatipcom;
    }

    public void setItxtdetatipcom(HtmlInputText itxtdetatipcom) {
        this.itxtdetatipcom = itxtdetatipcom;
    }

    public List<OtraActividadAcademica> getListOtrFun() {
        return listOtrFun;
    }

    public void setListOtrFun(List<OtraActividadAcademica> listOtrFun) {
        this.listOtrFun = listOtrFun;
    }

    public HtmlInputText getItxtdetotrfun() {
        return itxtdetotrfun;
    }

    public void setItxtdetotrfun(HtmlInputText itxtdetotrfun) {
        this.itxtdetotrfun = itxtdetotrfun;
    }

    public Date getDfeciniotrfun() {
        return dfeciniotrfun;
    }

    public void setDfeciniotrfun(Date dfeciniotrfun) {
        this.dfeciniotrfun = dfeciniotrfun;
    }

    public Date getDfecfinotrfun() {
        return dfecfinotrfun;
    }

    public void setDfecfinotrfun(Date dfecfinotrfun) {
        this.dfecfinotrfun = dfecfinotrfun;
    }

    public HtmlInputText getItxtobsotrfun() {
        return itxtobsotrfun;
    }

    public void setItxtobsotrfun(HtmlInputText itxtobsotrfun) {
        this.itxtobsotrfun = itxtobsotrfun;
    }

    public OtraActividadAcademica getOtrfun() {
        return otrfun;
    }

    public void setOtrfun(OtraActividadAcademica otrfun) {
        this.otrfun = otrfun;
    }

// </editor-fold>  
    /**
     * Creates a new instance of GestionAcademica
     */
    public GestionAcademica() {
//        usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
//        codProfesor = usr.getUsuCodigo();
    }
    
    public void typeValueChangeListener(){
        if(smtipcomitri.getValue() != null){
            if(Integer.parseInt(smtipcomitri.getValue().toString()) == 3){
                btipo = true;
            }else{
                itxtdetatipcom.setValue(null);
                btipo = false;
            }
        }else{
            itxtdetatipcom.setValue(null);
            btipo = false;
        }
    }

    @PostConstruct
    private void init() {
        modal1.setBeangestion(this);
        ciclos = cicloAcademicoFacade.findByEstado('A');
        if (!ciclos.isEmpty()) {
            anio = ciclos.get(0).getCicloAcademicoPK().getAnio();
            feciniciclo = ciclos.get(0).getFInicio();
            fecfinciclo = ciclos.get(0).getFFinal();
        }
        codProfesor = Long.parseLong("90");
        retrieveDatos(codProfesor, anio);
    }

    private void retrieveDatos(Long codProfesor, Long anio) {
        //Recupero las funciones academicas
        recuperaFunAcad(codProfesor, anio);
        //Recupero las Coordinaciones academicas
        recuperaCoorAcad(codProfesor, anio);
        //Recupero los Miembros de Comite Institucional
        recuperaComInst(codProfesor, anio);
        //Recupero los Miembros de Comite Tribunal
        recuperaComiTri(codProfesor, anio);
        //Recupero los Diseños de Programa de Posgrado
        recuperaProgPos(codProfesor, anio);
        //Recupero los Diseños de Educacion Continua
        recuperaEduCont(codProfesor, anio);
        //Recupero Organizacion Actividades Vinculacion
        recuperaActVinc(codProfesor, anio);
        //Recupero Otra Funcion
        recuperaOtrFun(codProfesor, anio);
    }

    // <editor-fold defaultstate="collapsed" desc="FUNCIONES ACADEMICAS"> 
    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA FUNCIONES ACADEMICAS"> 
    private void recuperaFunAcad(Long codProfesor, Long anio) {
        listFunAcad.clear();
        listFunAcad = otraactividadFacade.findFunAcad(codProfesor, anio);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SELECCION DE FILA PARA EDICION">    
    private OtraActividadAcademica selectedfuncacad;

    public OtraActividadAcademica getSelectedfuncacad() {
        return selectedfuncacad;
    }

    public void setSelectedfuncacad(OtraActividadAcademica selectedfuncacad) {
        this.selectedfuncacad = selectedfuncacad;
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">  
    public void SaveFunacad() {
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        OtraActividadAcademica funacadaux = new OtraActividadAcademica();
        if (funacad != null) {
            if (funacad.getOtraActividadAcademicaPK() != null) {
                funacadaux = otraactividadFacade.find(funacad.getOtraActividadAcademicaPK());
            }
        }
        try {
            funacad.setTipoActividad(smtipfunacad.getValue() == null ? null : Long.parseLong(smtipfunacad.getValue().toString()));
            funacad.setNombreActividad(itxtdetfunacad.getValue() == null ? null : itxtdetfunacad.getValue().toString());
            funacad.setFfinActividad(dfecfinfunacad == null ? null : new java.sql.Date(dfecfinfunacad.getTime()));
            funacad.setFinicioActividad(new java.sql.Date(dfecinifunacad.getTime()));
            funacad.setObsActividad(itxtobsfunacad.getValue() == null ? null : itxtobsfunacad.getValue().toString());
            if (funacadaux.getOtraActividadAcademicaPK() == null) {
                OtraActividadAcademicaPK funacadpk = new OtraActividadAcademicaPK();
                funacadpk.setCodigoProfesor(codProfesor);
                funacadpk.setTipoOtraActividad('G');
                funacad.setOtraActividadAcademicaPK(funacadpk);
                funacad.setFechaCrea(new Date());
                funacad.setUsuarioCrea("Internet");
                funacad.setFechaUltmodific(new Date());
                funacad.setUsuarioUltmodific("Internet");
                otraactividadFacade.create(funacad);
            } else {
                funacad.setFechaUltmodific(new Date());
                funacad.setUsuarioUltmodific("Internet");
                otraactividadFacade.edit(funacad);
            }
            //Recuepro los datos de los titulos
            FacesMessage msg = new FacesMessage("Función Académica Guardada");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            recuperaFunAcad(codProfesor, anio);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al guardar la información");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

        } finally {
            funacad = new OtraActividadAcademica();
            CancelFuncacad();
        }
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">  

    public void EditFunacad() {
        if (selectedfuncacad != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            funacad = selectedfuncacad;
            smtipfunacad.setValue(funacad.getTipoActividad() == null ? null : funacad.getTipoActividad());
            itxtdetfunacad.setValue(funacad.getNombreActividad() == null ? null : funacad.getNombreActividad());
            dfecinifunacad = new java.sql.Date(funacad.getFinicioActividad().getTime());
            dfecfinfunacad = (funacad.getFfinActividad() == null ? null : new java.sql.Date(funacad.getFfinActividad().getTime()));
            itxtobsfunacad.setValue(funacad.getObsActividad() == null ? null : funacad.getObsActividad());

        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Función Académica a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">  

    public void DeleteFunacad() {
        if (selectedfuncacad != null) {
            try {
                OtraActividadAcademica actevenaux = new OtraActividadAcademica();
                actevenaux = otraactividadFacade.find(selectedfuncacad.getOtraActividadAcademicaPK());
                otraactividadFacade.remove(actevenaux);
                //Recupero las asignaturas externas
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infogestion:gfunacademica");
                recuperaFunAcad(codProfesor, anio);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de: Función Académica", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            } finally {
                funacad = new OtraActividadAcademica();
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Función Académica a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">  

    public void CancelFuncacad() {
        selectedfuncacad = new OtraActividadAcademica();
        funacad = new OtraActividadAcademica();
        smtipfunacad.setValue(null);
        itxtdetfunacad.setValue(null);
        dfecinifunacad = null;
        dfecfinfunacad = null;
        itxtobsfunacad.setValue(null);
    }
    // </editor-fold> 
// </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc="COORDINACION ACADEMICA">
    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA COORDINACION ACADEMICA">
    private void recuperaCoorAcad(Long codProfesor, Long anio) {
        listCoorAcad.clear();
        listCoorAcad = otraactividadFacade.findCoorAcad(codProfesor, anio);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SELECCION FILA EDICION COORDINACION ACADEMICA">
    private OtraActividadAcademica selectedcooracad;
    
    public OtraActividadAcademica getSelectedcooracad() {
        return selectedcooracad;
    }

    public void setSelectedcooracad(OtraActividadAcademica selectedcooracad) {
        this.selectedcooracad = selectedcooracad;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">
    public void SaveCoorAcad(){
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        OtraActividadAcademica cooracadaux = new OtraActividadAcademica();
        if(cooracad != null){
            if (cooracad.getOtraActividadAcademicaPK() != null) {
                cooracadaux = otraactividadFacade.find(cooracad.getOtraActividadAcademicaPK());
            }
        }
        try {
            cooracad.setTipoActividad(smtipcooracad.getValue() == null ? null : Long.parseLong(smtipcooracad.getValue().toString()));
            cooracad.setNombreActividad(itxtdetcooracad.getValue() == null ? null : itxtdetcooracad.getValue().toString());
            cooracad.setFfinActividad(dfecfincooracad == null ? null : new java.sql.Date(dfecfincooracad.getTime()));
            cooracad.setFinicioActividad(new java.sql.Date(dfecinicooracad.getTime()));
            cooracad.setObsActividad(itxtobscooracad.getValue() == null ? null : itxtobscooracad.getValue().toString());
            if (cooracadaux.getOtraActividadAcademicaPK() == null) {
                OtraActividadAcademicaPK funacadpk = new OtraActividadAcademicaPK();
                funacadpk.setCodigoProfesor(codProfesor);
                funacadpk.setTipoOtraActividad('C');
                cooracad.setOtraActividadAcademicaPK(funacadpk);
                cooracad.setFechaCrea(new Date());
                cooracad.setUsuarioCrea("Internet");
                cooracad.setFechaUltmodific(new Date());
                cooracad.setUsuarioUltmodific("Internet");
                otraactividadFacade.create(cooracad);
            } else {
                cooracad.setFechaUltmodific(new Date());
                cooracad.setUsuarioUltmodific("Internet");
                otraactividadFacade.edit(cooracad);
            }
            //Recuepro los datos de los titulos
            FacesMessage msg = new FacesMessage("Función Académica Guardada");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            recuperaCoorAcad(codProfesor, anio);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al guardar la información");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

        } finally {
            cooracad = new OtraActividadAcademica();
            CancelCoorAcad();
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">
    public void EditCoorAcad() {
        if (selectedcooracad != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            cooracad = selectedcooracad;
            smtipcooracad.setValue(cooracad.getTipoActividad() == null ? null : cooracad.getTipoActividad());
            itxtdetcooracad.setValue(cooracad.getNombreActividad() == null ? null : cooracad.getNombreActividad());
            dfecinicooracad = new java.sql.Date(cooracad.getFinicioActividad().getTime());
            dfecfincooracad = (cooracad.getFfinActividad() == null ? null : new java.sql.Date(cooracad.getFfinActividad().getTime()));
            itxtobscooracad.setValue(cooracad.getObsActividad() == null ? null : cooracad.getObsActividad());
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Coordinación Académica a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">
    public void DeleteCoorAcad() {
        if (selectedcooracad != null) {
            try {
                OtraActividadAcademica actevenaux = new OtraActividadAcademica();
                actevenaux = otraactividadFacade.find(selectedcooracad.getOtraActividadAcademicaPK());
                otraactividadFacade.remove(actevenaux);
                //Recupero las asignaturas externas
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infogestion:gcooracademica");
                recuperaCoorAcad(codProfesor, anio);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de: Coordinación Académica", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            } finally {
                cooracad = new OtraActividadAcademica();
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Coordinación Académica a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">
    public void CancelCoorAcad() {
        selectedcooracad = new OtraActividadAcademica();
        cooracad = new OtraActividadAcademica();
        smtipcooracad.setValue(null);
        itxtdetcooracad.setValue(null);
        dfecinicooracad = null;
        dfecfincooracad = null;
        itxtobscooracad.setValue(null);
    }
    // </editor-fold>
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="MIEMBRO DE COMITE INSTITUCIONAL">
    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA MIEMBRO DE COMITE INSTITUCIONAL">
    private void recuperaComInst(Long codProfesor, Long anio) {
        listComInst.clear();
        listComInst = otraactividadFacade.findComInst(codProfesor, anio);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SELECCION FILA EDICION MIEMBRO DE COMITE INSTITUCIONAL">
    private OtraActividadAcademica selectedcominst;
    
    public OtraActividadAcademica getSelectedcominst() {
        return selectedcominst;
    }

    public void setSelectedcominst(OtraActividadAcademica selectedcominst) {
        this.selectedcominst = selectedcominst;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">
    public void SaveComInst(){
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        OtraActividadAcademica cooracadaux = new OtraActividadAcademica();
        if(cominst != null){
            if (cominst.getOtraActividadAcademicaPK() != null) {
                cooracadaux = otraactividadFacade.find(cominst.getOtraActividadAcademicaPK());
            }
        }
        try {
            cominst.setTipoActividad(smtipcominst.getValue() == null ? null : Long.parseLong(smtipcominst.getValue().toString()));
            cominst.setNombreActividad(itxtdetcominst.getValue() == null ? null : itxtdetcominst.getValue().toString());
            cominst.setNum1Actividad(numsesiones == null ? null : Integer.parseInt(numsesiones));
            cominst.setNum2Actividad(numanualsesiones == null ? null : Integer.parseInt(numanualsesiones));
            cominst.setFfinActividad(dfecfincominst == null ? null : new java.sql.Date(dfecfincominst.getTime()));
            cominst.setFinicioActividad(new java.sql.Date(dfecinicominst.getTime()));
            cominst.setObsActividad(itxtobscominst.getValue() == null ? null : itxtobscominst.getValue().toString());
            if (cooracadaux.getOtraActividadAcademicaPK() == null) {
                OtraActividadAcademicaPK funacadpk = new OtraActividadAcademicaPK();
                funacadpk.setCodigoProfesor(codProfesor);
                funacadpk.setTipoOtraActividad('F');
                cominst.setOtraActividadAcademicaPK(funacadpk);
                cominst.setFechaCrea(new Date());
                cominst.setUsuarioCrea("Internet");
                cominst.setFechaUltmodific(new Date());
                cominst.setUsuarioUltmodific("Internet");
                otraactividadFacade.create(cominst);
            } else {
                cominst.setFechaUltmodific(new Date());
                cominst.setUsuarioUltmodific("Internet");
                otraactividadFacade.edit(cominst);
            }
            //Recuepro los datos de los titulos
            FacesMessage msg = new FacesMessage("Función Académica Guardada");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            recuperaComInst(codProfesor, anio);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al guardar la información");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

        } finally {
            cominst = new OtraActividadAcademica();
            CancelComInst();
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">
    public void EditComInst() {
        if (selectedcominst != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            cominst = selectedcominst;
            smtipcominst.setValue(cominst.getTipoActividad() == null ? null : cominst.getTipoActividad());
            itxtdetcominst.setValue(cominst.getNombreActividad() == null ? null : cominst.getNombreActividad());
            numsesiones = (cominst.getNum1Actividad() == null ? null : cominst.getNum1Actividad().toString());
            numanualsesiones = (cominst.getNum2Actividad() == null ? null : cominst.getNum2Actividad().toString());
            dfecinicominst = new java.sql.Date(cominst.getFinicioActividad().getTime());
            dfecfincominst = (cominst.getFfinActividad() == null ? null : new java.sql.Date(cominst.getFfinActividad().getTime()));
            itxtobscominst.setValue(cominst.getObsActividad() == null ? null : cominst.getObsActividad());
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Coordinación Académica a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">
    public void DeleteComInst() {
        if (selectedcominst != null) {
            try {
                OtraActividadAcademica actevenaux = new OtraActividadAcademica();
                actevenaux = otraactividadFacade.find(selectedcominst.getOtraActividadAcademicaPK());
                otraactividadFacade.remove(actevenaux);
                //Recupero las asignaturas externas
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infogestion:gcominst");
                recuperaComInst(codProfesor, anio);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de: Miembro de Comité Institucional", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            } finally {
                cominst = new OtraActividadAcademica();
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar un Miembro de Comité Institucional a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">
    public void CancelComInst() {
        selectedcominst = new OtraActividadAcademica();
        cominst = new OtraActividadAcademica();
        smtipcominst.setValue(null);
        itxtdetcominst.setValue(null);
        numsesiones = null;
        numanualsesiones = null;
        dfecinicominst = null;
        dfecfincominst = null;
        itxtobscominst.setValue(null);
    }
    // </editor-fold>
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="MIEMBRO DE COMITE TRIBUNAL">
    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA MIEMBRO DE COMITE TRIBUNAL">
    private void recuperaComiTri(Long codProfesor, Long anio) {
        listComiTri.clear();
        listComiTri = otraactividadFacade.findComiTri(codProfesor, anio);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SELECCION FILA EDICION MIEMBRO DE COMITE TRIBUNAL">
    private OtraActividadAcademica selectedcomitri;

    public OtraActividadAcademica getSelectedcomitri() {
        return selectedcomitri;
    }

    public void setSelectedcomitri(OtraActividadAcademica selectedcomitri) {
        this.selectedcomitri = selectedcomitri;
    }
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">
    public void SaveComiTri(){
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        OtraActividadAcademica cooracadaux = new OtraActividadAcademica();
        if(comitri != null){
            if (comitri.getOtraActividadAcademicaPK() != null) {
                cooracadaux = otraactividadFacade.find(comitri.getOtraActividadAcademicaPK());
            }
        }
        try {
            comitri.setTipoActividad(smtipcomitri.getValue() == null ? null : Long.parseLong(smtipcomitri.getValue().toString()));
            comitri.setNombreActividad(itxtdetcomitri.getValue() == null ? null : itxtdetcomitri.getValue().toString());
            comitri.setNum2Actividad(numanualsesionescomitri == null ? null : Integer.parseInt(numanualsesionescomitri));
            comitri.setFfinActividad(dfecfincomitri == null ? null : new java.sql.Date(dfecfincomitri.getTime()));
            comitri.setFinicioActividad(new java.sql.Date(dfecinicomitri.getTime()));
            comitri.setObsActividad(itxtobscomitri.getValue() == null ? null : itxtobscomitri.getValue().toString());
            comitri.setProgramaActividad(itxtdetatipcom.getValue() == null ? null : itxtdetatipcom.getValue().toString());
            if (cooracadaux.getOtraActividadAcademicaPK() == null) {
                OtraActividadAcademicaPK funacadpk = new OtraActividadAcademicaPK();
                funacadpk.setCodigoProfesor(codProfesor);
                funacadpk.setTipoOtraActividad('J');
                comitri.setOtraActividadAcademicaPK(funacadpk);
                comitri.setFechaCrea(new Date());
                comitri.setUsuarioCrea("Internet");
                comitri.setFechaUltmodific(new Date());
                comitri.setUsuarioUltmodific("Internet");
                otraactividadFacade.create(comitri);
            } else {
                comitri.setFechaUltmodific(new Date());
                comitri.setUsuarioUltmodific("Internet");
                otraactividadFacade.edit(comitri);
            }
            //Recupero los datos de los titulos
            FacesMessage msg = new FacesMessage("Miembro Comité Tribunal Guardado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            recuperaComiTri(codProfesor, anio);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al guardar la información");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

        } finally {
            comitri = new OtraActividadAcademica();
            CancelComiTri();
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">
    public void EditComiTri() {
        if (selectedcomitri != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            comitri = selectedcomitri;
            smtipcomitri.setValue(comitri.getTipoActividad() == null ? null : comitri.getTipoActividad());
            typeValueChangeListener();
            itxtdetcomitri.setValue(comitri.getNombreActividad() == null ? null : comitri.getNombreActividad());
            numanualsesionescomitri = (comitri.getNum2Actividad() == null ? null : comitri.getNum2Actividad().toString());
            dfecinicomitri = new java.sql.Date(comitri.getFinicioActividad().getTime());
            dfecfincomitri = (comitri.getFfinActividad() == null ? null : new java.sql.Date(comitri.getFfinActividad().getTime()));
            itxtobscomitri.setValue(comitri.getObsActividad() == null ? null : comitri.getObsActividad());
            itxtdetatipcom.setValue(comitri.getProgramaActividad() == null ? null : comitri.getProgramaActividad());
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar un Miembro de Comité Tribunal a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">
    public void DeleteComiTri() {
        if (selectedcomitri != null) {
            try {
                OtraActividadAcademica actevenaux = new OtraActividadAcademica();
                actevenaux = otraactividadFacade.find(selectedcomitri.getOtraActividadAcademicaPK());
                otraactividadFacade.remove(actevenaux);
                //Recupero las asignaturas externas
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infogestion:gcomitri");
                recuperaComiTri(codProfesor, anio);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de: Miembro de Comité Tribunal", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            } finally {
                comitri = new OtraActividadAcademica();
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar un Miembro de Comité Tribunal a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">
    public void CancelComiTri() {
        selectedcomitri = new OtraActividadAcademica();
        comitri = new OtraActividadAcademica();
        smtipcomitri.setValue(null);
        itxtdetcomitri.setValue(null);
        numanualsesionescomitri = null;
        dfecinicomitri = null;
        dfecfincomitri = null;
        itxtobscomitri.setValue(null);
        btipo = false;
        itxtdetatipcom.setValue(null);
    }
    // </editor-fold>
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="DISEÑO DE PROGRAMA DE POSGRADO">
    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA DISEÑO DE PROGRAMA DE POSGRADO">
    private void recuperaProgPos(Long codProfesor, Long anio) {
        listProgPos.clear();
        listProgPos = otraactividadFacade.findProgPos(codProfesor, anio);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SELECCION FILA EDICION DISEÑO DE PROGRAMA DE POSGRADO">
    private OtraActividadAcademica selectedprogpos;

    public OtraActividadAcademica getSelectedprogpos() {
        return selectedprogpos;
    }

    public void setSelectedprogpos(OtraActividadAcademica selectedprogpos) {
        this.selectedprogpos = selectedprogpos;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">
    public void SaveProgPos(){
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        OtraActividadAcademica cooracadaux = new OtraActividadAcademica();
        if(progpos != null){
            if (progpos.getOtraActividadAcademicaPK() != null) {
                cooracadaux = otraactividadFacade.find(progpos.getOtraActividadAcademicaPK());
            }
        }
        try {
            progpos.setTipoActividad(smtipprogpos.getValue() == null ? null : Long.parseLong(smtipprogpos.getValue().toString()));
            progpos.setNombreActividad(itxtdetprogpos.getValue() == null ? null : itxtdetprogpos.getValue().toString());
            progpos.setFacultad(smareprogpos.getValue() == null ? null : facultadFacade.find(Long.parseLong(smareprogpos.getValue().toString())));
            progpos.setTipo2Actividad(smestprogpos.getValue() == null ? null : smestprogpos.getValue().toString().charAt(0));
            progpos.setFfinActividad(dfecfinprogpos == null ? null : new java.sql.Date(dfecfinprogpos.getTime()));
            progpos.setFinicioActividad(new java.sql.Date(dfeciniprogpos.getTime()));
            progpos.setObsActividad(itxtobsprogpos.getValue() == null ? null : itxtobsprogpos.getValue().toString());
            if (cooracadaux.getOtraActividadAcademicaPK() == null) {
                OtraActividadAcademicaPK funacadpk = new OtraActividadAcademicaPK();
                funacadpk.setCodigoProfesor(codProfesor);
                funacadpk.setTipoOtraActividad('L');
                progpos.setOtraActividadAcademicaPK(funacadpk);
                progpos.setFechaCrea(new Date());
                progpos.setUsuarioCrea("Internet");
                progpos.setFechaUltmodific(new Date());
                progpos.setUsuarioUltmodific("Internet");
                otraactividadFacade.create(progpos);
            } else {
                progpos.setFechaUltmodific(new Date());
                progpos.setUsuarioUltmodific("Internet");
                otraactividadFacade.edit(progpos);
            }
            //Recuepro los datos de los titulos
            FacesMessage msg = new FacesMessage("Diseño de Programa de Posgrado Guardado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            recuperaProgPos(codProfesor, anio);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al guardar la información");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

        } finally {
            progpos = new OtraActividadAcademica();
            CancelProgPos();
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">
    public void EditProgPos() {
        if (selectedprogpos != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            progpos = selectedprogpos;
            smtipprogpos.setValue(progpos.getTipoActividad() == null ? null : progpos.getTipoActividad());
            itxtdetprogpos.setValue(progpos.getNombreActividad() == null ? null : progpos.getNombreActividad());
            smareprogpos.setValue(progpos.getFacultad() == null ? null : progpos.getFacultad());
            smestprogpos.setValue(progpos.getTipo2Actividad() == null ? null : progpos.getTipo2Actividad());
            dfeciniprogpos = new java.sql.Date(progpos.getFinicioActividad().getTime());
            dfecfinprogpos = (progpos.getFfinActividad() == null ? null : new java.sql.Date(progpos.getFfinActividad().getTime()));
            itxtobsprogpos.setValue(progpos.getObsActividad() == null ? null : progpos.getObsActividad());
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar un Diseño de Programa de Posgrado a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">
    public void DeleteProgPos() {
        if (selectedprogpos != null) {
            try {
                OtraActividadAcademica actevenaux = new OtraActividadAcademica();
                actevenaux = otraactividadFacade.find(selectedprogpos.getOtraActividadAcademicaPK());
                otraactividadFacade.remove(actevenaux);
                //Recupero las asignaturas externas
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infogestion:gprogpos");
                recuperaProgPos(codProfesor, anio);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de: Diseño de Programa de Posgrado", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            } finally {
                comitri = new OtraActividadAcademica();
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar un Diseño de Programa de Posgrado a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">
    public void CancelProgPos() {
        selectedprogpos = new OtraActividadAcademica();
        progpos = new OtraActividadAcademica();
        smtipprogpos.setValue(null);
        itxtdetprogpos.setValue(null);
        smareprogpos.setValue(null);
        smestprogpos.setValue(null);
        dfeciniprogpos = null;
        dfecfinprogpos = null;
        itxtobsprogpos.setValue(null);
    }
    // </editor-fold>
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="DISEÑO DE EDUCACION CONTINUA">
    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA DISEÑO DE EDUCACION CONTINUA">
    private void recuperaEduCont(Long codProfesor, Long anio) {
        listEduCont.clear();
        listEduCont = otraactividadFacade.findEduCont(codProfesor, anio);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SELECCION FILA EDICION DISEÑO DE EDUCACION CONTINUA">
    private OtraActividadAcademica selectededucont;

    public OtraActividadAcademica getSelectededucont() {
        return selectededucont;
    }

    public void setSelectededucont(OtraActividadAcademica selectededucont) {
        this.selectededucont = selectededucont;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">
    public void SaveEduCont(){
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        OtraActividadAcademica cooracadaux = new OtraActividadAcademica();
        if(educont != null){
            if (educont.getOtraActividadAcademicaPK() != null) {
                cooracadaux = otraactividadFacade.find(educont.getOtraActividadAcademicaPK());
            }
        }
        try {
            educont.setTipoActividad(smtipeducont.getValue() == null ? null : Long.parseLong(smtipeducont.getValue().toString()));
            educont.setNombreActividad(itxtdeteducont.getValue() == null ? null : itxtdeteducont.getValue().toString());
            educont.setFacultad(smareeducont.getValue() == null ? null : facultadFacade.find(Long.parseLong(smareeducont.getValue().toString())));
            educont.setNum1Actividad(numhoraseducont == null ? null : Integer.parseInt(numhoraseducont));
            educont.setFfinActividad(dfecfineducont == null ? null : new java.sql.Date(dfecfineducont.getTime()));
            educont.setFinicioActividad(new java.sql.Date(dfecinieducont.getTime()));
            educont.setObsActividad(itxtobseducont.getValue() == null ? null : itxtobseducont.getValue().toString());
            if (cooracadaux.getOtraActividadAcademicaPK() == null) {
                OtraActividadAcademicaPK funacadpk = new OtraActividadAcademicaPK();
                funacadpk.setCodigoProfesor(codProfesor);
                funacadpk.setTipoOtraActividad('Q');
                educont.setOtraActividadAcademicaPK(funacadpk);
                educont.setFechaCrea(new Date());
                educont.setUsuarioCrea("Internet");
                educont.setFechaUltmodific(new Date());
                educont.setUsuarioUltmodific("Internet");
                otraactividadFacade.create(educont);
            } else {
                educont.setFechaUltmodific(new Date());
                educont.setUsuarioUltmodific("Internet");
                otraactividadFacade.edit(educont);
            }
            //Recuepro los datos de los titulos
            FacesMessage msg = new FacesMessage("Diseño de Programa de Posgrado Guardado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            recuperaEduCont(codProfesor, anio);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al guardar la información");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

        } finally {
            educont = new OtraActividadAcademica();
            CancelEduCont();
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">
    public void EditEduCont() {
        if (selectededucont != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            educont = selectededucont;
            smtipeducont.setValue(educont.getTipoActividad() == null ? null : educont.getTipoActividad());
            itxtdeteducont.setValue(educont.getNombreActividad() == null ? null : educont.getNombreActividad());
            smareeducont.setValue(educont.getFacultad() == null ? null : educont.getFacultad());
            numhoraseducont = (educont.getNum1Actividad() == null ? null : educont.getNum1Actividad().toString());
            dfecinieducont = new java.sql.Date(educont.getFinicioActividad().getTime());
            dfecfineducont = (educont.getFfinActividad() == null ? null : new java.sql.Date(educont.getFfinActividad().getTime()));
            itxtobseducont.setValue(educont.getObsActividad() == null ? null : educont.getObsActividad());
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar un Diseño de Educacion Continua a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">
    public void DeleteEduCont() {
        if (selectededucont != null) {
            try {
                OtraActividadAcademica actevenaux = new OtraActividadAcademica();
                actevenaux = otraactividadFacade.find(selectededucont.getOtraActividadAcademicaPK());
                otraactividadFacade.remove(actevenaux);
                //Recupero las asignaturas externas
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infogestion:geducont");
                recuperaEduCont(codProfesor, anio);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de: Diseño de Educacion Continua", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            } finally {
                educont = new OtraActividadAcademica();
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar un Diseño de Educacion Continua a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">
    public void CancelEduCont() {
        selectededucont = new OtraActividadAcademica();
        educont = new OtraActividadAcademica();
        smtipeducont.setValue(null);
        itxtdeteducont.setValue(null);
        smareeducont.setValue(null);
        numhoraseducont = null;
        dfecinieducont = null;
        dfecfineducont = null;
        itxtobseducont.setValue(null);
    }
    // </editor-fold>
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="ORGANIZACION ACTIVIDADES VINCULACION">
    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA ORGANIZACION ACTIVIDADES VINCULACION">
    private void recuperaActVinc(Long codProfesor, Long anio) {
        listActVinc.clear();
        listActVinc = otraactividadFacade.findActVinc(codProfesor, anio);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SELECCION FILA EDICION ORGANIZACION ACTIVIDADES VINCULACION">
    private OtraActividadAcademica selectedactvinc;

    public OtraActividadAcademica getSelectedactvinc() {
        return selectedactvinc;
    }

    public void setSelectedactvinc(OtraActividadAcademica selectedactvinc) {
        this.selectedactvinc = selectedactvinc;
    }
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">
    public void SaveActVinc(){
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        OtraActividadAcademica cooracadaux = new OtraActividadAcademica();
        if(actvinc != null){
            if (actvinc.getOtraActividadAcademicaPK() != null) {
                cooracadaux = otraactividadFacade.find(actvinc.getOtraActividadAcademicaPK());
            }
        }
        try {
            actvinc.setTipoActividad(smtipactvinc.getValue() == null ? null : Long.parseLong(smtipactvinc.getValue().toString()));
            actvinc.setNombreActividad(itxtdetactvinc.getValue() == null ? null : itxtdetactvinc.getValue().toString());
            actvinc.setAlcanceActividad(smalcactvinc.getValue() == null ? null : Long.parseLong(smalcactvinc.getValue().toString()));
            actvinc.setNum1Actividad(numhorasactvinc == null ? null : Integer.parseInt(numhorasactvinc));
            actvinc.setFfinActividad(dfecfinactvinc == null ? null : new java.sql.Date(dfecfinactvinc.getTime()));
            actvinc.setFinicioActividad(new java.sql.Date(dfeciniactvinc.getTime()));
            actvinc.setObsActividad(itxtobsactvinc.getValue() == null ? null : itxtobsactvinc.getValue().toString());
            if (cooracadaux.getOtraActividadAcademicaPK() == null) {
                OtraActividadAcademicaPK funacadpk = new OtraActividadAcademicaPK();
                funacadpk.setCodigoProfesor(codProfesor);
                funacadpk.setTipoOtraActividad('W');
                actvinc.setOtraActividadAcademicaPK(funacadpk);
                actvinc.setFechaCrea(new Date());
                actvinc.setUsuarioCrea("Internet");
                actvinc.setFechaUltmodific(new Date());
                actvinc.setUsuarioUltmodific("Internet");
                otraactividadFacade.create(actvinc);
            } else {
                actvinc.setFechaUltmodific(new Date());
                actvinc.setUsuarioUltmodific("Internet");
                otraactividadFacade.edit(actvinc);
            }
            //Recuepro los datos de los titulos
            FacesMessage msg = new FacesMessage("Organizacion Actividades Vinculacion Guardado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            recuperaActVinc(codProfesor, anio);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al guardar la información");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

        } finally {
            actvinc = new OtraActividadAcademica();
            CancelActVinc();
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">
    public void EditActVinc() {
        if (selectedactvinc != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            actvinc = selectedactvinc;
            smtipactvinc.setValue(actvinc.getTipoActividad() == null ? null : actvinc.getTipoActividad());
            itxtdetactvinc.setValue(actvinc.getNombreActividad() == null ? null : actvinc.getNombreActividad());
            smalcactvinc.setValue(actvinc.getAlcanceActividad() == null ? null : actvinc.getAlcanceActividad());
            numhorasactvinc = (actvinc.getNum1Actividad() == null ? null : actvinc.getNum1Actividad().toString());
            dfeciniactvinc = new java.sql.Date(actvinc.getFinicioActividad().getTime());
            dfecfinactvinc = (actvinc.getFfinActividad() == null ? null : new java.sql.Date(actvinc.getFfinActividad().getTime()));
            itxtobsactvinc.setValue(actvinc.getObsActividad() == null ? null : actvinc.getObsActividad());
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Organización Actividades Vinculación a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">
    public void DeleteActVinc() {
        if (selectedactvinc != null) {
            try {
                OtraActividadAcademica actevenaux = new OtraActividadAcademica();
                actevenaux = otraactividadFacade.find(selectedactvinc.getOtraActividadAcademicaPK());
                otraactividadFacade.remove(actevenaux);
                //Recupero las asignaturas externas
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infogestion:gactvinc");
                recuperaActVinc(codProfesor, anio);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de: Organización Actividades Vinculación", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            } finally {
                actvinc = new OtraActividadAcademica();
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Organización Actividades Vinculación a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">
    public void CancelActVinc() {
        selectedactvinc = new OtraActividadAcademica();
        actvinc = new OtraActividadAcademica();
        smtipactvinc.setValue(null);
        itxtdetactvinc.setValue(null);
        smalcactvinc.setValue(null);
        numhorasactvinc = null;
        dfeciniactvinc = null;
        dfecfinactvinc = null;
        itxtobsactvinc.setValue(null);
    }
    // </editor-fold>
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="OTRA FUNCION">
    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA ORGANIZACION ACTIVIDADES VINCULACION">
    private void recuperaOtrFun(Long codProfesor, Long anio) {
        listOtrFun.clear();
        listOtrFun = otraactividadFacade.findOtrFun(codProfesor, anio);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SELECCION FILA EDICION ORGANIZACION ACTIVIDADES VINCULACION">
    private OtraActividadAcademica selectedotrfun;

    public OtraActividadAcademica getSelectedotrfun() {
        return selectedotrfun;
    }

    public void setSelectedotrfun(OtraActividadAcademica selectedotrfun) {
        this.selectedotrfun = selectedotrfun;
    }
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">
    public void saveOtrFun(){
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        OtraActividadAcademica cooracadaux = new OtraActividadAcademica();
        if(otrfun != null){
            if (otrfun.getOtraActividadAcademicaPK() != null) {
                cooracadaux = otraactividadFacade.find(otrfun.getOtraActividadAcademicaPK());
            }
        }
        try {
            otrfun.setNombreActividad(itxtdetotrfun.getValue() == null ? null : itxtdetotrfun.getValue().toString());
            otrfun.setFinicioActividad(new java.sql.Date(dfeciniotrfun.getTime()));
            otrfun.setFfinActividad(new java.sql.Date(dfecfinotrfun.getTime()));
            otrfun.setObsActividad(itxtobsotrfun.getValue() == null ? null : itxtobsotrfun.getValue().toString());
            if (cooracadaux.getOtraActividadAcademicaPK() == null) {
                OtraActividadAcademicaPK funacadpk = new OtraActividadAcademicaPK();
                funacadpk.setCodigoProfesor(codProfesor);
                funacadpk.setTipoOtraActividad('X');
                otrfun.setOtraActividadAcademicaPK(funacadpk);
                otrfun.setFechaCrea(new Date());
                otrfun.setUsuarioCrea("Internet");
                otrfun.setFechaUltmodific(new Date());
                otrfun.setUsuarioUltmodific("Internet");
                otraactividadFacade.create(otrfun);
            } else {
                otrfun.setFechaUltmodific(new Date());
                otrfun.setUsuarioUltmodific("Internet");
                otraactividadFacade.edit(otrfun);
            }
            //Recuepro los datos de los titulos
            FacesMessage msg = new FacesMessage("Otra Función Guardado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            recuperaActVinc(codProfesor, anio);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al guardar la información");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        } finally {
            otrfun = new OtraActividadAcademica();
            CancelOtrFun();
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">
    public void EditOtrFun() {
        if (selectedotrfun != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            otrfun = selectedotrfun;
            itxtdetactvinc.setValue(otrfun.getNombreActividad() == null ? null : otrfun.getNombreActividad());
            dfeciniotrfun = new java.sql.Date(otrfun.getFinicioActividad().getTime());
            dfecfinotrfun = (otrfun.getFfinActividad() == null ? null : new java.sql.Date(otrfun.getFfinActividad().getTime()));
            itxtobsotrfun.setValue(otrfun.getObsActividad() == null ? null : otrfun.getObsActividad());
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar la función a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">
    public void DeleteOtrFun() {
        if (selectedotrfun != null) {
            try {
                OtraActividadAcademica actevenaux = new OtraActividadAcademica();
                actevenaux = otraactividadFacade.find(selectedotrfun.getOtraActividadAcademicaPK());
                otraactividadFacade.remove(actevenaux);
                //Recupero las asignaturas externas
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infogestion:gotrfun");
                recuperaActVinc(codProfesor, anio);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de: Organización Actividades Vinculación", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            } finally {
                otrfun = new OtraActividadAcademica();
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una función a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">
    public void CancelOtrFun() {
        selectedotrfun = new OtraActividadAcademica();
        otrfun = new OtraActividadAcademica();
        itxtdetotrfun.setValue(null);
        dfeciniotrfun = null;
        dfecfinotrfun = null;
        itxtobsotrfun.setValue(null);
    }
    // </editor-fold>
    // </editor-fold>
    
    public void eliminarRegistro(ActionEvent ae) {
        switch (modal1.getActiveIndexAcoordion()) {
            case 3:
                switch (modal1.getActiveIndexTabviewgestion()) {
                    case 0:
                        DeleteFunacad();
                        break;
                    case 1:
                        DeleteCoorAcad();
                        break;
                    case 2:
                        DeleteComInst();
                        break;
                    case 3:
                        DeleteComiTri();
                        break;
                    case 4:
                        DeleteProgPos();
                        break;
                    case 5:
                        DeleteEduCont();
                        break;
                    case 6:
                        DeleteActVinc();
                        break;
                    case 7:
                        DeleteOtrFun();
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
            case 3:
                switch (modal1.getActiveIndexTabviewgestion()) {
                    case 0:
                        modal1.setUrlmodal("/pages/infoanual/gestionAcademica/funcionAcademicaModal.xhtml");
                        break;
                    case 1:
                        modal1.setUrlmodal("/pages/infoanual/gestionAcademica/coordinacionAcademicaModal.xhtml");
                        break;
                    case 2:
                        modal1.setUrlmodal("/pages/infoanual/gestionAcademica/comiteInstitucionalModal.xhtml");
                        break;
                    case 3:
                        modal1.setUrlmodal("/pages/infoanual/gestionAcademica/comiteTribunalModal.xhtml");
                        break;
                    case 4:
                        modal1.setUrlmodal("/pages/infoanual/gestionAcademica/programaPosgradoModal.xhtml");
                        break;
                    case 5:
                        modal1.setUrlmodal("/pages/infoanual/gestionAcademica/educacionContinuaModal.xhtml");
                        break;
                    case 6:
                        modal1.setUrlmodal("/pages/infoanual/gestionAcademica/actividadVinculacionModal.xhtml");
                        break;
                    case 7:
                        modal1.setUrlmodal("/pages/infoanual/gestionAcademica/otraFuncionModal.xhtml");
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
        if (modal1.getActiveIndexAcoordion() == 3) {
            switch (modal1.getActiveIndexTabviewgestion()) {
                case 0:
                    EditFunacad();
                    break;
                case 1:
                    EditCoorAcad();
                    break;
                case 2:
                    EditComInst();
                    break;
                case 3:
                    EditComiTri();
                    break;
                case 4:
                    EditProgPos();
                    break;
                case 5:
                    EditEduCont();
                    break;
                case 6:
                    EditActVinc();
                    break;
                case 7:
                    EditOtrFun();
                    break;
                default:
                    break;
            }
        }
    }

    public void onRowSelect(SelectEvent event) {
        if (modal1.getActiveIndexAcoordion() == 3) {
            switch (modal1.getActiveIndexTabviewgestion()) {
                case 0:
                    selectedfuncacad = (OtraActividadAcademica) event.getObject();
                    break;
                case 1:
                    selectedcooracad = (OtraActividadAcademica) event.getObject();
                    break;
                case 2:
                    selectedcominst = (OtraActividadAcademica) event.getObject();
                    break;
                case 3:
                    selectedcomitri = (OtraActividadAcademica) event.getObject();
                    break;
                case 4:
                    selectedprogpos = (OtraActividadAcademica) event.getObject();
                    break;
                case 5:
                    selectededucont = (OtraActividadAcademica) event.getObject();
                    break;
                case 6:
                    selectedactvinc = (OtraActividadAcademica) event.getObject();
                    break;
                case 7:
                    selectedotrfun = (OtraActividadAcademica) event.getObject();
                    break;
                default:
                    break;
            }

        }
    }

    private void reset() {
        selectedfuncacad = null;
        selectedcooracad = null;
        selectedcominst = null;
        selectedcomitri = null;
        selectedprogpos = null;
        selectededucont = null;
        selectedactvinc = null;
        selectedotrfun = null;
    }

    public void onRowUnselect(UnselectEvent event) {
        reset();
    }
}