/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.managedBean;

import ec.edu.uasb.entities.Facultad;
import ec.edu.uasb.entities.Pais;
import ec.edu.uasb.infoanual.entities.AreaVincolectividad;
import ec.edu.uasb.infoanual.entities.DetalleVincolectividad;


import ec.edu.uasb.infoanual.entities.OtraActividadAcademica;
import ec.edu.uasb.infoanual.entities.OtraActividadAcademicaPK;

import ec.edu.uasb.infoanual.session.AreaVincolectividadFacadeLocal;
import ec.edu.uasb.infoanual.session.ConsultaFacadeLocal;
import ec.edu.uasb.infoanual.session.DetalleVincolectividadFacadeLocal;
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
import java.util.Vector;
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
@ManagedBean(name = "vinculacion")
@ViewScoped
public class VinculacionColectividadManagedBean implements Serializable {

    private Long codProfesor;
    private Date feciniciclo;
    private Date fecfinciclo;
    private Long anio;
    
    private String msgtablavacia = "No existen datos Registrados";
    //EDUCACION CONTINUA UASB      
    private List<OtraActividadAcademica> listEduCOnUasb = new ArrayList<OtraActividadAcademica>();
    private List<String[]> listCurAbierto = new ArrayList<String[]>();
    //Ingreso educacion continua
    OtraActividadAcademica educcontuasb = new OtraActividadAcademica();
    private HtmlSelectOneMenu smdtipacteducont = new HtmlSelectOneMenu();
    private List<Facultad> listfacultad = new ArrayList<Facultad>();
    private HtmlSelectOneMenu smfacultad = new HtmlSelectOneMenu();
    private HtmlInputText itxtnominstitucioneducont = new HtmlInputText();
    private HtmlSelectOneMenu smtipinsteducont = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smorigenpart = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smremunadic = new HtmlSelectOneMenu();
    private HtmlInputText itxtnomactividadeducont = new HtmlInputText();
    private String itxthorasdictadas = null;
    private Date dfecinieducont= null;
    private Date dfecfineducont= null;
    private List<Facultad> listFacultad = new ArrayList<Facultad>();
    private List<AreaVincolectividad> listAreVinc = new ArrayList<AreaVincolectividad>();
    private List<DetalleVincolectividad> listDetVinc = new ArrayList<DetalleVincolectividad>();
    private List<Pais> listPais = new ArrayList<Pais>();
    private HtmlSelectOneMenu smprograma = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smparea = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smproyecto = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smedconroldoc = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smalcance = new HtmlSelectOneMenu();
    private String scofinan = "1";
    private boolean bcofinan = false;
    //Actividades  y Eventos UASB    
    private List<OtraActividadAcademica> listActEvenUasb = new ArrayList<OtraActividadAcademica>();
    OtraActividadAcademica actevenuasb = new OtraActividadAcademica();
    private HtmlSelectOneMenu smdtipactactevuasb = new HtmlSelectOneMenu();
    private HtmlInputText itxtnominstiactevuasb = new HtmlInputText();
    private HtmlSelectOneMenu smtipinstactevuasb = new HtmlSelectOneMenu();
    private HtmlInputText itxtnomactiactevuasb = new HtmlInputText();
    private Date dfeciniactevuasb= null;
    private Date dfecfinactevuasb= null;
    private HtmlSelectOneMenu smacteveprograma = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smacteveproyecto = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smacteveconroldoc = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smpais = new HtmlSelectOneMenu();
    private String sactevecofinan = "1";
    private boolean bactevecofinan = false;
    private String snumhprep= null;
    //Actividades  y Eventos Externos
    private List<OtraActividadAcademica> listActEvenext = new ArrayList<OtraActividadAcademica>();
    OtraActividadAcademica actevenext = new OtraActividadAcademica();
    private HtmlSelectOneMenu smdtipactactevext = new HtmlSelectOneMenu();
    private HtmlInputText itxtnominstiactevext = new HtmlInputText();
    private HtmlSelectOneMenu smtipinstactevext = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smtipinsorigpart = new HtmlSelectOneMenu();
    private HtmlInputText itxtnomactiactevext = new HtmlInputText();
    private HtmlInputText itxtobseractevext = new HtmlInputText();
    private Date dfeciniactevext= null;
    private Date dfecfinactevext= null;
    private HtmlSelectOneMenu smacteveextroldoc = new HtmlSelectOneMenu();
    private String sacevextnumhprep= null;
    //Pertenencia Organizaciones Académicas
    private List<OtraActividadAcademica> listPertOrgAcad = new ArrayList<OtraActividadAcademica>();
    OtraActividadAcademica pertorgacad = new OtraActividadAcademica();
    private Date dfecinipertorg= null;
    private Date dfecfinpertorg= null;
    private HtmlInputText itxtpertorgnomborg = new HtmlInputText();
    private HtmlSelectOneMenu smpertorgforpart = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smpertorgtiporg = new HtmlSelectOneMenu();
    private HtmlInputText itxtpertorgobserv = new HtmlInputText();
    @EJB
    private DetalleVincolectividadFacadeLocal detvincolectividadFacade;
    @EJB
    private AreaVincolectividadFacadeLocal arevincolectividadFacade;
    @EJB
    private OtraActividadAcademicaFacadeLocal otraactividadFacade;
    @EJB
    private FacultadFacadeLocal facultadFacade;
    @EJB
    private CicloAcademicoFacadeLocal cicloAcademicoFacade;
    @EJB
    private ConsultaFacadeLocal consultaFacade;
    @EJB
    private PaisFacadeLocal paisFacade;
    private List<CicloAcademico> ciclos = new ArrayList<CicloAcademico>();
//    private Usuario usr = new Usuario();
    @ManagedProperty( value = "#{modal}")
    private modalManagedBean modal1;
    // <editor-fold defaultstate="collapsed" desc="DECLARACION VARIABLES">

    public modalManagedBean getModal1() {
        return modal1;
    }

    public void setModal1(modalManagedBean modal1) {
        this.modal1 = modal1;
    }

    public List<String[]> getListCurAbierto() {
        return listCurAbierto;
    }

    public void setListCurAbierto(List<String[]> listCurAbierto) {
        this.listCurAbierto = listCurAbierto;
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
   
    public List<OtraActividadAcademica> getListPertOrgAcad() {
        return listPertOrgAcad;
    }

    public void setListPertOrgAcad(List<OtraActividadAcademica> listPertOrgAcad) {
        this.listPertOrgAcad = listPertOrgAcad;
    }

    public Date getDfecinipertorg() {
        return dfecinipertorg;
    }

    public void setDfecinipertorg(Date dfecinipertorg) {
        this.dfecinipertorg = dfecinipertorg;
    }

    public Date getDfecfinpertorg() {
        return dfecfinpertorg;
    }

    public void setDfecfinpertorg(Date dfecfinpertorg) {
        this.dfecfinpertorg = dfecfinpertorg;
    }

    public HtmlInputText getItxtpertorgnomborg() {
        return itxtpertorgnomborg;
    }

    public void setItxtpertorgnomborg(HtmlInputText itxtpertorgnomborg) {
        this.itxtpertorgnomborg = itxtpertorgnomborg;
    }

    public HtmlSelectOneMenu getSmpertorgforpart() {
        return smpertorgforpart;
    }

    public void setSmpertorgforpart(HtmlSelectOneMenu smpertorgforpart) {
        this.smpertorgforpart = smpertorgforpart;
    }

    public HtmlSelectOneMenu getSmpertorgtiporg() {
        return smpertorgtiporg;
    }

    public void setSmpertorgtiporg(HtmlSelectOneMenu smpertorgtiporg) {
        this.smpertorgtiporg = smpertorgtiporg;
    }

    public HtmlInputText getItxtpertorgobserv() {
        return itxtpertorgobserv;
    }

    public void setItxtpertorgobserv(HtmlInputText itxtpertorgobserv) {
        this.itxtpertorgobserv = itxtpertorgobserv;
    }

    public String getSacevextnumhprep() {
        return sacevextnumhprep;
    }

    public void setSacevextnumhprep(String sacevextnumhprep) {
        this.sacevextnumhprep = sacevextnumhprep;
    }

    public HtmlSelectOneMenu getSmacteveextroldoc() {
        return smacteveextroldoc;
    }

    public void setSmacteveextroldoc(HtmlSelectOneMenu smacteveextroldoc) {
        this.smacteveextroldoc = smacteveextroldoc;
    }

    public List<OtraActividadAcademica> getListActEvenext() {
        for (OtraActividadAcademica assig : listActEvenext) {
            if(assig.getPaisInvest() != null){
                assig.setNomPas(paisFacade.find(assig.getPaisInvest()).getNomPais());
            }
        }
        return listActEvenext;
    }

    public void setListActEvenext(List<OtraActividadAcademica> listActEvenext) {
        this.listActEvenext = listActEvenext;
    }

    public HtmlSelectOneMenu getSmdtipactactevext() {
        return smdtipactactevext;
    }

    public void setSmdtipactactevext(HtmlSelectOneMenu smdtipactactevext) {
        this.smdtipactactevext = smdtipactactevext;
    }

    public HtmlInputText getItxtnominstiactevext() {
        return itxtnominstiactevext;
    }

    public void setItxtnominstiactevext(HtmlInputText itxtnominstiactevext) {
        this.itxtnominstiactevext = itxtnominstiactevext;
    }

    public HtmlSelectOneMenu getSmtipinstactevext() {
        return smtipinstactevext;
    }

    public void setSmtipinstactevext(HtmlSelectOneMenu smtipinstactevext) {
        this.smtipinstactevext = smtipinstactevext;
    }

    public HtmlInputText getItxtnomactiactevext() {
        return itxtnomactiactevext;
    }

    public void setItxtnomactiactevext(HtmlInputText itxtnomactiactevext) {
        this.itxtnomactiactevext = itxtnomactiactevext;
    }

    public HtmlInputText getItxtobseractevext() {
        return itxtobseractevext;
    }

    public void setItxtobseractevext(HtmlInputText itxtobseractevext) {
        this.itxtobseractevext = itxtobseractevext;
    }

    public Date getDfeciniactevext() {
        return dfeciniactevext;
    }

    public void setDfeciniactevext(Date dfeciniactevext) {
        this.dfeciniactevext = dfeciniactevext;
    }

    public Date getDfecfinactevext() {
        return dfecfinactevext;
    }

    public void setDfecfinactevext(Date dfecfinactevext) {
        this.dfecfinactevext = dfecfinactevext;
    }

    public FacultadFacadeLocal getFacultadFacade() {
        return facultadFacade;
    }

    public void setFacultadFacade(FacultadFacadeLocal facultadFacade) {
        this.facultadFacade = facultadFacade;
    }

    public String getSnumhprep() {
        return snumhprep;
    }

    public void setSnumhprep(String snumhprep) {
        this.snumhprep = snumhprep;
    }

    public HtmlSelectOneMenu getSmacteveprograma() {
        return smacteveprograma;
    }

    public void setSmacteveprograma(HtmlSelectOneMenu smacteveprograma) {
        this.smacteveprograma = smacteveprograma;
    }

    public HtmlSelectOneMenu getSmacteveproyecto() {
        return smacteveproyecto;
    }

    public void setSmacteveproyecto(HtmlSelectOneMenu smacteveproyecto) {
        this.smacteveproyecto = smacteveproyecto;
    }

    public HtmlSelectOneMenu getSmacteveconroldoc() {
        return smacteveconroldoc;
    }

    public void setSmacteveconroldoc(HtmlSelectOneMenu smacteveconroldoc) {
        this.smacteveconroldoc = smacteveconroldoc;
    }

    public String getSactevecofinan() {
        return sactevecofinan;
    }

    public void setSactevecofinan(String sactevecofinan) {
        this.sactevecofinan = sactevecofinan;
    }

    public boolean isBactevecofinan() {
        return bactevecofinan;
    }

    public void setBactevecofinan(boolean bactevecofinan) {
        this.bactevecofinan = bactevecofinan;
    }

    public List<OtraActividadAcademica> getListActEvenUasb() {
        return listActEvenUasb;
    }

    public void setListActEvenUasb(List<OtraActividadAcademica> listActEvenUasb) {
        this.listActEvenUasb = listActEvenUasb;
    }

    public HtmlSelectOneMenu getSmdtipactactevuasb() {
        return smdtipactactevuasb;
    }

    public void setSmdtipactactevuasb(HtmlSelectOneMenu smdtipactactevuasb) {
        this.smdtipactactevuasb = smdtipactactevuasb;
    }

    public HtmlInputText getItxtnominstiactevuasb() {
        return itxtnominstiactevuasb;
    }

    public void setItxtnominstiactevuasb(HtmlInputText itxtnominstiactevuasb) {
        this.itxtnominstiactevuasb = itxtnominstiactevuasb;
    }

    public HtmlSelectOneMenu getSmtipinstactevuasb() {
        return smtipinstactevuasb;
    }

    public void setSmtipinstactevuasb(HtmlSelectOneMenu smtipinstactevuasb) {
        this.smtipinstactevuasb = smtipinstactevuasb;
    }

    public HtmlInputText getItxtnomactiactevuasb() {
        return itxtnomactiactevuasb;
    }

    public void setItxtnomactiactevuasb(HtmlInputText itxtnomactiactevuasb) {
        this.itxtnomactiactevuasb = itxtnomactiactevuasb;
    }

    public Date getDfeciniactevuasb() {
        return dfeciniactevuasb;
    }

    public void setDfeciniactevuasb(Date dfeciniactevuasb) {
        this.dfeciniactevuasb = dfeciniactevuasb;
    }

    public Date getDfecfinactevuasb() {
        return dfecfinactevuasb;
    }

    public void setDfecfinactevuasb(Date dfecfinactevuasb) {
        this.dfecfinactevuasb = dfecfinactevuasb;
    }

    public List<Facultad> getListFacultad(){
        listFacultad = facultadFacade.findAllactiva();
        return listFacultad;
    }
    
    public void setListFacultad(List<Facultad> listFacultad){
        this.listFacultad = listFacultad;
    }
    
    public List<AreaVincolectividad> getListAreVinc() {
        //listAreVinc = arevincolectividadFacade.findAll();
        return listAreVinc;
    }

    public void setListAreVinc(List<AreaVincolectividad> listAreVinc) {
        this.listAreVinc = listAreVinc;
    }

    public String getMsgtablavacia() {
        return msgtablavacia;
    }

    public void setMsgtablavacia(String msgtablavacia) {
        this.msgtablavacia = msgtablavacia;
    }

    public List<OtraActividadAcademica> getListEduCOnUasb() {
        return listEduCOnUasb;
    }

    public void setListEduCOnUasb(List<OtraActividadAcademica> listEduCOnUasb) {
        this.listEduCOnUasb = listEduCOnUasb;
    }

    public HtmlSelectOneMenu getSmdtipacteducont() {
        return smdtipacteducont;
    }

    public void setSmdtipacteducont(HtmlSelectOneMenu smdtipacteducont) {
        this.smdtipacteducont = smdtipacteducont;
    }

    public List<Facultad> getListfacultad() {
        return listfacultad;
    }

    public void setListfacultad(List<Facultad> listfacultad) {
        this.listfacultad = listfacultad;
    }

    public HtmlSelectOneMenu getSmfacultad() {
        return smfacultad;
    }

    public void setSmfacultad(HtmlSelectOneMenu smfacultad) {
        this.smfacultad = smfacultad;
    }

    public HtmlInputText getItxtnominstitucioneducont() {
        return itxtnominstitucioneducont;
    }

    public void setItxtnominstitucioneducont(HtmlInputText itxtnominstitucioneducont) {
        this.itxtnominstitucioneducont = itxtnominstitucioneducont;
    }

    public HtmlSelectOneMenu getSmtipinsteducont() {
        return smtipinsteducont;
    }

    public void setSmtipinsteducont(HtmlSelectOneMenu smtipinsteducont) {
        this.smtipinsteducont = smtipinsteducont;
    }

    public HtmlInputText getItxtnomactividadeducont() {
        return itxtnomactividadeducont;
    }

    public void setItxtnomactividadeducont(HtmlInputText itxtnomactividadeducont) {
        this.itxtnomactividadeducont = itxtnomactividadeducont;
    }
    
    public String getItxthorasdictadas() {
        return itxthorasdictadas;
    }

    public void setItxthorasdictadas(String itxthorasdictadas) {
        this.itxthorasdictadas = itxthorasdictadas;
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

    public List<DetalleVincolectividad> getListDetVinc() {
        return listDetVinc;
    }

    public void setListDetVinc(List<DetalleVincolectividad> listDetVinc) {
        this.listDetVinc = listDetVinc;
    }

    public HtmlSelectOneMenu getSmprograma() {
        return smprograma;
    }

    public void setSmprograma(HtmlSelectOneMenu smprograma) {
        this.smprograma = smprograma;
    }
    
    public HtmlSelectOneMenu getSmparea(){
        return smparea;
    }
    
    public void setSmparea (HtmlSelectOneMenu smparea){
        this.smparea = smparea;
    }

    public HtmlSelectOneMenu getSmproyecto() {
        return smproyecto;
    }

    public void setSmproyecto(HtmlSelectOneMenu smproyecto) {
        this.smproyecto = smproyecto;
    }

    public HtmlSelectOneMenu getSmedconroldoc() {
        return smedconroldoc;
    }

    public void setSmedconroldoc(HtmlSelectOneMenu smedconroldoc) {
        this.smedconroldoc = smedconroldoc;
    }

    public String getScofinan() {
        return scofinan;
    }

    public void setScofinan(String scofinan) {
        this.scofinan = scofinan;
    }

    public boolean isBcofinan() {
        return bcofinan;
    }

    public void setBcofinan(boolean bcofinan) {
        this.bcofinan = bcofinan;
    }
    
    public HtmlSelectOneMenu getSmalcance() {
        return smalcance;
    }

    public void setSmalcance(HtmlSelectOneMenu smalcance) {
        this.smalcance = smalcance;
    }
    
    public List<Pais> getListPais() {
        listPais = paisFacade.findAllorde();
        return listPais;
    }

    public void setListPais(List<Pais> listPais) {
        this.listPais = listPais;
    }
    
    public HtmlSelectOneMenu getSmpais() {
        return smpais;
    }

    public void setSmpais(HtmlSelectOneMenu smpais) {
        this.smpais = smpais;
    }
    
    public HtmlSelectOneMenu getSmtipinsorigpart() {
        return smtipinsorigpart;
    }

    public void setSmtipinsorigpart(HtmlSelectOneMenu smtipinsorigpart) {
        this.smtipinsorigpart = smtipinsorigpart;
    }
    
    public HtmlSelectOneMenu getSmorigenpart() {
        return smorigenpart;
    }

    public void setSmorigenpart(HtmlSelectOneMenu smorigenpart) {
        this.smorigenpart = smorigenpart;
    }
    
    public HtmlSelectOneMenu getSmremunadic() {
        return smremunadic;
    }

    public void setSmremunadic(HtmlSelectOneMenu smremunadic) {
        this.smremunadic = smremunadic;
    }

    // </editor-fold> 
    /**
     * Creates a new instance of VinculacionColectividadManagedBean
     */
    public VinculacionColectividadManagedBean() {
//        usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
//        codProfesor = usr.getUsuCodigo();
    }
    
    @PostConstruct
    private void init() {
        modal1.setBeanvinculacion(this);
        ciclos = cicloAcademicoFacade.findByEstado('A');
        if (!ciclos.isEmpty()) {
            anio = ciclos.get(0).getCicloAcademicoPK().getAnio();
            feciniciclo = ciclos.get(0).getFInicio();
            fecfinciclo = ciclos.get(0).getFFinal();
        }
        codProfesor = Long.parseLong("5");
        retrieveDatos(codProfesor, anio);
    }

    private void retrieveDatos(Long codProfesor, Long anio) {
        //Recupero los cursos de educacion continua
        recuperaEducontuasb(codProfesor, anio);
        //Actividad EVento UASB
        recuperaActEventuasb(codProfesor, anio);
        //Actividad EVento Externo
        recuperaActEventext(codProfesor, anio);
        //Pertenencia Organizaciones
        recuperaPertOrgAcad(codProfesor, anio);

    }
    // <editor-fold defaultstate="collapsed" desc="EDUCACION CONTINUA UASB"> 

    public void programavalueChangeListener() {
        if (smprograma.getValue() != null) {
            listDetVinc = detvincolectividadFacade.finbyArea(smprograma.getValue().toString());
        }
        if (smacteveprograma.getValue() != null) {
            listDetVinc = detvincolectividadFacade.finbyArea(smacteveprograma.getValue().toString());
        }
    }
    
    public void programavalueChangeListenerByArea(){
        if(smparea.getValue() != null){
//            listAreVinc = arevincolectividadFacade.finbyArea(smparea.getValue().toString());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA EDUCACION CONTINUA UASB"> 
    private void recuperaEducontuasb(Long codProfesor, Long anio) {
        listEduCOnUasb.clear();
        listEduCOnUasb = otraactividadFacade.findEducacionContinuaUasb(codProfesor, anio);
        //Recupero los cursos abiertos
        
        Vector v = new Vector();
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT DISTINCT VISTA_CURSOS_ABIERTOS.AREA_ACADEMICA, "
                + " VISTA_CURSOS_ABIERTOS.NOMBRE,   "
                + " (case when VISTA_CURSOS_ABIERTOS.TIPO_EVENTO= 'C' then 'Curso Abierto' end ),   "
                + " VISTA_CURSOS_ABIERTOS.NOMBRE_CONFERENCIA,   "
                + " VISTA_CURSOS_ABIERTOS.NOMBRE_TEVENTO,   "
                + " VISTA_CURSOS_ABIERTOS.CODIGO_TEVENTO,   "
                + " VISTA_CURSOS_ABIERTOS.OBS_EVENTO_PROFESOR,   "
                + " VISTA_CURSOS_ABIERTOS.NUMERO_CLASES  "
                + " FROM VISTA_CURSOS_ABIERTOS "
                + " WHERE ( VISTA_CURSOS_ABIERTOS.CODIGO_PROFESOR = ").append(codProfesor).append(" ) AND  "
                + " ( VISTA_CURSOS_ABIERTOS.CICLO = 1 ) AND  "
                + " ( VISTA_CURSOS_ABIERTOS.ANIO = ").append(anio).append(" ) AND  "
                + " ( VISTA_CURSOS_ABIERTOS.TIPO_EVENTO = 'C' ) AND  "
                + " ( VISTA_CURSOS_ABIERTOS.CODIGO_TEVENTO = 12 )   ");
        v = (Vector) consultaFacade.ejecutaSqlList(sql.toString());
        if (v.size() > 0) {
            for (int i = 0; i < v.size(); i++) {
                Object[] object = (Object[]) v.get(i);
                String[] asign;
                asign = new String[8];
                asign[0] = (object[0]==null? null: object[0].toString());
                asign[1] = (object[1]==null? null:  object[1].toString());
                asign[2] = (object[2]==null? null: object[2].toString());
                asign[3] = (object[3]==null? null: object[3].toString());
                asign[4] = (object[4]==null? null: object[4].toString());
                asign[5] = (object[5]==null? null: object[5].toString());
                asign[6] = (object[6]==null? null: object[6].toString());
                asign[7] = (object[7]==null? null:object[7].toString());   
                listCurAbierto.add(i, asign);
            }
        }
    
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="SELECCION DE FILA PARA EDICION">    
    private OtraActividadAcademica selectededuccontuasb;

    public OtraActividadAcademica getSelectededuccontuasb() {
        return selectededuccontuasb;
    }

    public void setSelectededuccontuasb(OtraActividadAcademica selectededuccontuasb) {
        this.selectededuccontuasb = selectededuccontuasb;
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">  

    public void SaveEducContUasb() {
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        OtraActividadAcademica educcontuasbaux = new OtraActividadAcademica();
        AreaVincolectividad areavin = new AreaVincolectividad();
        Facultad facultad = new Facultad();
        if (educcontuasb != null) {
            if (educcontuasb.getOtraActividadAcademicaPK() != null) {
                educcontuasbaux = otraactividadFacade.find(educcontuasb.getOtraActividadAcademicaPK());
            }
        }
        if(smparea == null){
            smparea = new HtmlSelectOneMenu();
        }
        try {
            educcontuasb.setFinicioActividad(dfecinieducont==null? null: new java.sql.Date(dfecinieducont.getTime()));
            educcontuasb.setFfinActividad(dfecfineducont== null ? null:new java.sql.Date(dfecfineducont.getTime()));
            educcontuasb.setNombreActividad(itxtnomactividadeducont.getValue() == null ? null : itxtnomactividadeducont.getValue().toString().toUpperCase());            
            educcontuasb.setTipoActividad(smdtipacteducont.getValue() == null ? null : Long.parseLong(smdtipacteducont.getValue().toString()));
            educcontuasb.setTipo7Actividad(smedconroldoc.getValue() == null ? null : smedconroldoc.getValue().toString().charAt(0));
            educcontuasb.setHorasDictadas(itxthorasdictadas == null ? null : Long.parseLong(itxthorasdictadas));
            educcontuasb.setOrigenParticipacion(smorigenpart.getValue() == null ? null : smorigenpart.getValue().toString());
            educcontuasb.setNum1Actividad(smremunadic.getValue() == null ? null : Integer.parseInt(smremunadic.getValue().toString()));
            if(smparea.getValue() != null){
                facultad = facultadFacade.find(Long.parseLong(smparea.getValue().toString()));
            }else{
                facultad = new Facultad();
            }
            if (smprograma.getValue() != null) {
                areavin = arevincolectividadFacade.find(Long.parseLong(smprograma.getValue().toString()));
            } else {
                areavin = null;
            }
            educcontuasb.setAreaVinculacion(areavin == null ? null : areavin);
            educcontuasb.setFacultad(facultad == null ? null : facultad);
            educcontuasb.setDetalleVinculacion(smproyecto.getValue() == null ? null : detvincolectividadFacade.find(Long.parseLong(smproyecto.getValue().toString())));
            if (scofinan.equalsIgnoreCase("0")){
                educcontuasb.setSedeInstActividad(smtipinsteducont.getValue() == null ? null : smtipinsteducont.getValue().toString().charAt(0));
                educcontuasb.setTituloActividad(itxtnominstitucioneducont.getValue() == null ? null : itxtnominstitucioneducont.getValue().toString().toUpperCase());
            }else{
                educcontuasb.setSedeInstActividad(null);
                educcontuasb.setTituloActividad(null);
            }
            if (educcontuasbaux.getOtraActividadAcademicaPK() == null) {
                OtraActividadAcademicaPK educcontuasbpk = new OtraActividadAcademicaPK();
                educcontuasbpk.setCodigoProfesor(codProfesor);
                educcontuasbpk.setTipoOtraActividad('R');
                educcontuasb.setOtraActividadAcademicaPK(educcontuasbpk);
                educcontuasb.setFechaCrea(new Date());
                educcontuasb.setUsuarioCrea("Internet");
                educcontuasb.setFechaUltmodific(new Date());
                educcontuasb.setUsuarioUltmodific("Internet");
                otraactividadFacade.create(educcontuasb);
            } else {
                educcontuasb.setFechaUltmodific(new Date());
                educcontuasb.setUsuarioUltmodific("Internet");
                otraactividadFacade.edit(educcontuasb);
            }
            //Recuepro los datos de los titulos
            FacesMessage msg = new FacesMessage("Curso de Formación Continua Guardada");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            recuperaEducontuasb(codProfesor, anio);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al guardar la información");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

        } finally {
            educcontuasb = new OtraActividadAcademica();
            CancelEducContUasb();
        }
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">  

    public void EditEducContUasb() {
        if (selectededuccontuasb != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            educcontuasb = selectededuccontuasb;
            smdtipacteducont.setValue(educcontuasb.getTipoActividad() == null ? null : educcontuasb.getTipoActividad());
            if(smparea != null){
                smparea.setValue(educcontuasb.getFacultad() == null ? null : educcontuasb.getFacultad().getCodigoFacultad());
            }else{
                smparea = new HtmlSelectOneMenu();
                smparea.setValue(educcontuasb.getFacultad() == null ? null : educcontuasb.getFacultad().getCodigoFacultad());
            }
            programavalueChangeListenerByArea();
            smprograma.setValue(educcontuasb.getAreaVinculacion() == null ? null : educcontuasb.getAreaVinculacion().getAvcCodigo());
            programavalueChangeListener();
            smproyecto.setValue(educcontuasb.getDetalleVinculacion() == null ? null : educcontuasb.getDetalleVinculacion().getDavcCodigo());
            itxtnomactividadeducont.setValue(educcontuasb.getNombreActividad() == null ? null : educcontuasb.getNombreActividad().toString());
            itxthorasdictadas = (educcontuasb.getHorasDictadas() == null ? null : educcontuasb.getHorasDictadas().toString());
            dfecinieducont = new java.sql.Date(educcontuasb.getFinicioActividad() == null ? null : educcontuasb.getFinicioActividad().getTime());
            dfecfineducont = new java.sql.Date(educcontuasb.getFfinActividad() == null ? null : educcontuasb.getFfinActividad().getTime());
            scofinan = (educcontuasb.getSedeInstActividad() == null ? "1" : "0");
            setScofinan(educcontuasb.getSedeInstActividad() == null ? "1" : "0");
            if (scofinan.equalsIgnoreCase("0")){
                itxtnominstitucioneducont.setValue(educcontuasb.getTituloActividad() == null ? null : educcontuasb.getTituloActividad().toString());
                smtipinsteducont.setValue(educcontuasb.getSedeInstActividad() == null ? null : educcontuasb.getSedeInstActividad());
            }else{
                itxtnominstitucioneducont.setValue(null);
                 smtipinsteducont.setValue(null);
            }
            smedconroldoc.setValue(educcontuasb.getTipo7Actividad() == null ? null : educcontuasb.getTipo7Actividad());
            smorigenpart.setValue(educcontuasb.getOrigenParticipacion() == null ? null : educcontuasb.getOrigenParticipacion());
            smremunadic.setValue(educcontuasb.getNum1Actividad() == null ? null : educcontuasb.getNum1Actividad());
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Actividad de Formación Continua a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">  

    public void DeleteEducContUasb() {
        if (selectededuccontuasb != null) {
            try {
                OtraActividadAcademica educcontaux = new OtraActividadAcademica();
                educcontaux = otraactividadFacade.find(selectededuccontuasb.getOtraActividadAcademicaPK());
                otraactividadFacade.remove(educcontaux);
                //Recupero las asignaturas externas
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infovinculacion:gformcontinua");
                recuperaEducontuasb(codProfesor, anio);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de: Formación Continua", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

            } finally {
                educcontuasb = new OtraActividadAcademica();
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Actividad de Formación Continua a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">  

    public void CancelEducContUasb() {
        educcontuasb = new OtraActividadAcademica();
        selectededuccontuasb = new OtraActividadAcademica();
        smparea.setValue(null);
        smprograma.setValue(null);
        smproyecto.setValue(null);
        smdtipacteducont.setValue(null);
        smfacultad.setValue(null);
        smedconroldoc.setValue(null);
        itxtnomactividadeducont.setValue(null);
        smalcance.setValue(null);
        dfecinieducont = null;
        dfecfineducont = null;        
        scofinan = "1";
        smtipinsteducont= new HtmlSelectOneMenu();
        itxtnominstitucioneducont.resetValue();
        smorigenpart.setValue(null);
        smremunadic.setValue(null);
        itxthorasdictadas = null;
    }
    // </editor-fold> 
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="ACTIVIDADES Y EVENTOS UASB"> 
    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA ACTIVIDADES Y EVENTOS UASB"> 

    private void recuperaActEventuasb(Long codProfesor, Long anio) {
        listActEvenUasb.clear();
        listActEvenUasb = otraactividadFacade.findActEventoUasb(codProfesor, anio);
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="SELECCION DE FILA PARA EDICION">    
    private OtraActividadAcademica selectedactevenuasb;

    public OtraActividadAcademica getSelectedactevenuasb() {
        return selectedactevenuasb;
    }

    public void setSelectedactevenuasb(OtraActividadAcademica selectedactevenuasb) {
        this.selectedactevenuasb = selectedactevenuasb;
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">  

    public void SaveActEvUasb() {
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        OtraActividadAcademica actevenuasbaux = new OtraActividadAcademica();
        AreaVincolectividad areavin;
        Facultad facultad;
        if (actevenuasb != null) {
            if (actevenuasb.getOtraActividadAcademicaPK() != null) {
                actevenuasbaux = otraactividadFacade.find(actevenuasb.getOtraActividadAcademicaPK());
            }
        }
        if(smparea == null){
            smparea = new HtmlSelectOneMenu();
        }
        try {
            actevenuasb.setTituloActividad(itxtnominstiactevuasb.getValue() == null ? null : itxtnominstiactevuasb.getValue().toString().toUpperCase());
            actevenuasb.setNombreActividad(itxtnomactiactevuasb.getValue() == null ? null : itxtnomactiactevuasb.getValue().toString().toUpperCase());
            actevenuasb.setTipoActividad(smdtipactactevuasb.getValue() == null ? null : Long.parseLong(smdtipactactevuasb.getValue().toString()));
            actevenuasb.setSedeInstActividad(smtipinstactevuasb.getValue() == null ? null : smtipinstactevuasb.getValue().toString().charAt(0));
            actevenuasb.setFinicioActividad(new java.sql.Date(dfeciniactevuasb.getTime()));
            actevenuasb.setFfinActividad(new java.sql.Date(dfecfinactevuasb.getTime()));
            actevenuasb.setDuracionActividad(snumhprep == null ? null : Integer.parseInt(snumhprep));
            actevenuasb.setTipo7Actividad(smacteveconroldoc.getValue() == null ? null : smacteveconroldoc.getValue().toString().charAt(0));
            if(smparea.getValue() != null){
                facultad = facultadFacade.find(Long.parseLong(smparea.getValue().toString()));
            }else{
                facultad = null;
            }
            if (smacteveprograma.getValue() != null) {
                areavin = arevincolectividadFacade.find(Long.parseLong(smacteveprograma.getValue().toString()));
            } else {
                areavin = null;
            }
            actevenuasb.setAreaVinculacion(areavin == null ? null : areavin);
            actevenuasb.setFacultad(facultad == null ? null : facultad);
            actevenuasb.setDetalleVinculacion(smacteveproyecto.getValue() == null ? null : detvincolectividadFacade.find(Long.parseLong(smacteveproyecto.getValue().toString())));
            if(smalcance != null){
                actevenuasb.setAlcanceActividad(smalcance.getValue() == null ? null : Long.parseLong(smalcance.getValue().toString()));
            }else{
                smalcance = new HtmlSelectOneMenu();
                actevenuasb.setAlcanceActividad(smalcance.getValue() == null ? null : Long.parseLong(smalcance.getValue().toString()));
            }
            if (actevenuasbaux.getOtraActividadAcademicaPK() == null) {
                OtraActividadAcademicaPK educcontuasbpk = new OtraActividadAcademicaPK();
                educcontuasbpk.setCodigoProfesor(codProfesor);
                educcontuasbpk.setTipoOtraActividad('U');
                actevenuasb.setOtraActividadAcademicaPK(educcontuasbpk);
                actevenuasb.setFechaCrea(new Date());
                actevenuasb.setUsuarioCrea("Internet");
                actevenuasb.setFechaUltmodific(new Date());
                actevenuasb.setUsuarioUltmodific("Internet");
                otraactividadFacade.create(actevenuasb);
            } else {
                actevenuasb.setFechaUltmodific(new Date());
                actevenuasb.setUsuarioUltmodific("Internet");
                otraactividadFacade.edit(actevenuasb);
            }
            //Recuepro los datos de educacion continua externa             

            FacesMessage msg = new FacesMessage("Actividades Eventos UASB Guardados");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            recuperaActEventuasb(codProfesor, anio);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al guardar la información");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

        } finally {
            actevenuasb = new OtraActividadAcademica();
            CancelActevenUasb();
        }
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">  

    public void EditActevenuasb() {
        if (selectedactevenuasb != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            actevenuasb = selectedactevenuasb;
            itxtnomactiactevuasb.setValue(actevenuasb.getNombreActividad() == null ? null : actevenuasb.getNombreActividad());
            itxtnominstiactevuasb.setValue(actevenuasb.getTituloActividad() == null ? null : actevenuasb.getTituloActividad());
            smdtipactactevuasb.setValue(actevenuasb.getTipoActividad() == null ? null : actevenuasb.getTipoActividad());
            smtipinstactevuasb.setValue(actevenuasb.getSedeInstActividad() == null ? null : actevenuasb.getSedeInstActividad());
            dfeciniactevuasb = (actevenuasb.getFinicioActividad() == null ? null : new java.sql.Date(actevenuasb.getFinicioActividad().getTime()));
            dfecfinactevuasb = (actevenuasb.getFfinActividad() == null ? null : new java.sql.Date(actevenuasb.getFfinActividad().getTime()));
            if(smparea != null){
                smparea.setValue(actevenuasb.getFacultad() == null ? null : actevenuasb.getFacultad().getCodigoFacultad());
            }else{
                smparea = new HtmlSelectOneMenu();
                smparea.setValue(actevenuasb.getFacultad() == null ? null : actevenuasb.getFacultad().getCodigoFacultad());
            }
            programavalueChangeListenerByArea();
            smacteveprograma.setValue(actevenuasb.getAreaVinculacion() == null ? null : actevenuasb.getAreaVinculacion().getAvcCodigo());
            programavalueChangeListener();
            smacteveproyecto.setValue(actevenuasb.getDetalleVinculacion() == null ? null : actevenuasb.getDetalleVinculacion().getDavcCodigo());
            smacteveconroldoc.setValue(actevenuasb.getTipo7Actividad() == null ? null : actevenuasb.getTipo7Actividad());
            sactevecofinan = (actevenuasb.getSedeInstActividad() == null ? "1" : "0");
            snumhprep = (actevenuasb.getDuracionActividad() == null ? null : actevenuasb.getDuracionActividad().toString());
            if(smalcance != null){
                smalcance.setValue(actevenuasb.getAlcanceActividad() == null ? null : actevenuasb.getAlcanceActividad());
            }else{
                smalcance = new HtmlSelectOneMenu();
                smalcance.setValue(actevenuasb.getAlcanceActividad() == null ? null : actevenuasb.getAlcanceActividad());
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Actividad/Evento UASB a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">  

    public void DeleteActeveuasb() {
        if (selectedactevenuasb != null) {
            try {
                OtraActividadAcademica actevenaux = new OtraActividadAcademica();
                actevenaux = otraactividadFacade.find(selectedactevenuasb.getOtraActividadAcademicaPK());
                otraactividadFacade.remove(actevenaux);
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infovinculacion:gacteveuasb");
                recuperaActEventuasb(codProfesor, anio);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de: Actividad/Evento UASB", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);


            } finally {
                actevenuasb = new OtraActividadAcademica();

            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Actividad/Evento UASB a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">  

    public void CancelActevenUasb() {
        actevenuasb = new OtraActividadAcademica();
        selectedactevenuasb = new OtraActividadAcademica();
        smacteveproyecto.setValue(null);
        smacteveprograma.setValue(null);
        smdtipactactevuasb.setValue(null);
        itxtnominstiactevuasb.resetValue();
        smtipinstactevuasb.setValue(null);
        itxtnomactiactevuasb.setValue(null);
        dfeciniactevuasb = null;
        dfecfinactevuasb = null;
        smacteveconroldoc.setValue(null);
        sactevecofinan = "1";
        snumhprep = null;
        smparea.setValue(null);
        smalcance.setValue(null);
    }
    // </editor-fold> 
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="ACTIVIDADES Y EVENTOS EXTERNOS"> 
    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA ACTIVIDADES Y EVENTOS EXTERNAS"> 

    private void recuperaActEventext(Long codProfesor, Long anio) {
        listActEvenext.clear();
        listActEvenext = otraactividadFacade.findActEventoExt(codProfesor, anio);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SELECCION DE FILA PARA EDICION">    
    private OtraActividadAcademica selectedactevenext;

    public OtraActividadAcademica getSelectedactevenext() {
        return selectedactevenext;
    }

    public void setSelectedactevenext(OtraActividadAcademica selectedactevenext) {
        this.selectedactevenext = selectedactevenext;
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">  

    public void SaveActEvext() {
        OtraActividadAcademica actevenextaux = new OtraActividadAcademica();
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        if (actevenext != null) {
            if (actevenext.getOtraActividadAcademicaPK() != null) {
                actevenextaux = otraactividadFacade.find(actevenext.getOtraActividadAcademicaPK());
            }
        }
        if(smpais == null){
            smpais = new HtmlSelectOneMenu();
        }
        try {
            actevenext.setTituloActividad(itxtnominstiactevext.getValue() == null ? null : itxtnominstiactevext.getValue().toString().toUpperCase());
            actevenext.setNombreActividad(itxtnomactiactevext.getValue() == null ? null : itxtnomactiactevext.getValue().toString().toUpperCase());
            actevenext.setTipoActividad(smdtipactactevext.getValue() == null ? null : Long.parseLong(smdtipactactevext.getValue().toString()));
            actevenext.setSedeInstActividad(smtipinstactevext.getValue() == null ? null : smtipinstactevext.getValue().toString().charAt(0));
            actevenext.setNum1Actividad(smtipinsorigpart.getValue() == null ? null : Integer.parseInt(smtipinsorigpart.getValue().toString()));
            actevenext.setFinicioActividad(new java.sql.Date(dfeciniactevext.getTime()));
            actevenext.setFfinActividad(new java.sql.Date(dfecfinactevext.getTime()));
            actevenext.setTipo7Actividad(smacteveextroldoc.getValue() == null ? null : smacteveextroldoc.getValue().toString().charAt(0));
            actevenext.setDuracionActividad(sacevextnumhprep == null ? null : Integer.parseInt(sacevextnumhprep));
            actevenext.setPaisInvest(smpais.getValue() == null ? null : smpais.getValue().toString());
            if (actevenextaux.getOtraActividadAcademicaPK() == null) {
                OtraActividadAcademicaPK educcontuasbpk = new OtraActividadAcademicaPK();
                educcontuasbpk.setCodigoProfesor(codProfesor);
                educcontuasbpk.setTipoOtraActividad('S');
                actevenext.setFacultad(facultadFacade.find(Long.parseLong("1")));
                actevenext.setOtraActividadAcademicaPK(educcontuasbpk);
                actevenext.setFechaCrea(new Date());
                actevenext.setUsuarioCrea("Internet");
                actevenext.setFechaUltmodific(new Date());
                actevenext.setUsuarioUltmodific("Internet");
                otraactividadFacade.create(actevenext);
            } else {
                actevenext.setFechaUltmodific(new Date());
                actevenext.setUsuarioUltmodific("Internet");
                otraactividadFacade.edit(actevenext);
            }
            //Recuepro los datos de educacion continua externa            
            FacesMessage msg = new FacesMessage("Actividades Eventos (otras Universidades) Guardados");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            recuperaActEventext(codProfesor, anio);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al guardar la información");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

        } finally {
            actevenext = new OtraActividadAcademica();
            CancelActevenext();
        }
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">  

    public void EditActevenext() {
        if (selectedactevenext != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            actevenext = selectedactevenext;
            itxtnominstiactevext.setValue(actevenext.getTituloActividad() == null ? null : actevenext.getTituloActividad());
            itxtnomactiactevext.setValue(actevenext.getNombreActividad() == null ? null : actevenext.getNombreActividad());
            smdtipactactevext.setValue(actevenext.getTipoActividad() == null ? null : actevenext.getTipoActividad());
            smtipinstactevext.setValue(actevenext.getSedeInstActividad() == null ? null : actevenext.getSedeInstActividad().toString().charAt(0));
            smtipinsorigpart.setValue(actevenext.getNum1Actividad() == null ? null : actevenext.getNum1Actividad());
            dfeciniactevext = new java.sql.Date(actevenext.getFinicioActividad().getTime());
            dfecfinactevext = new java.sql.Date(actevenext.getFfinActividad().getTime());
            smacteveextroldoc.setValue(actevenext.getTipo7Actividad() == null ? null : actevenext.getTipo7Actividad());
            sacevextnumhprep = (actevenext.getDuracionActividad() == null ? null : actevenext.getDuracionActividad().toString());
            if(smpais != null){
                smpais.setValue(actevenext.getPaisInvest() == null ? null : actevenext.getPaisInvest());
            }else{
                smpais = new HtmlSelectOneMenu();
                smpais.setValue(actevenext.getPaisInvest() == null ? null : actevenext.getPaisInvest());
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Actividad/Evento(Otras Universidades) a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">  

    public void DeleteActeveext() {
        if (selectedactevenext != null) {
            try {
                OtraActividadAcademica actevenaux = new OtraActividadAcademica();
                actevenaux = otraactividadFacade.find(selectedactevenext.getOtraActividadAcademicaPK());
                otraactividadFacade.remove(actevenaux);
                recuperaActEventext(codProfesor, anio);
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infovinculacion:gacteveExt");
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de:Actividad/Evento(Otras Universidades)", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

            } finally {
                actevenext = new OtraActividadAcademica();
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Actividad/Evento(Otras Universidades) a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">  

    public void CancelActevenext() {
        actevenext = new OtraActividadAcademica();
        selectedactevenext = new OtraActividadAcademica();
        smdtipactactevext.setValue(null);
        itxtnominstiactevext.resetValue();
        smtipinstactevext.setValue(null);
        smtipinsorigpart.setValue(null);
        itxtnomactiactevext.setValue(null);
        dfeciniactevext = null;
        dfecfinactevext = null;
        sacevextnumhprep = null;
        smacteveextroldoc.setValue(null);
    }
    // </editor-fold> 
// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="PERTENENCIA ORGANIZACIONES"> 
    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA PERTENENCIA ORGANIZACIONES"> 

    private void recuperaPertOrgAcad(Long codProfesor, Long anio) {
        listPertOrgAcad.clear();
        listPertOrgAcad = otraactividadFacade.findPertOrgAcad(codProfesor, anio);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SELECCION DE FILA PARA EDICION">    
    private OtraActividadAcademica selectedpertorgacad;

    public OtraActividadAcademica getSelectedpertorgacad() {
        return selectedpertorgacad;
    }

    public void setSelectedpertorgacad(OtraActividadAcademica selectedpertorgacad) {
        this.selectedpertorgacad = selectedpertorgacad;
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">  
    public void SavePertOrg() {
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        OtraActividadAcademica actevenextaux = new OtraActividadAcademica();
        if (pertorgacad != null) {
            if (pertorgacad.getOtraActividadAcademicaPK() != null) {
                actevenextaux = otraactividadFacade.find(pertorgacad.getOtraActividadAcademicaPK());
            }
        }
        try {
            pertorgacad.setNombreActividad(itxtpertorgnomborg.getValue() == null ? null : itxtpertorgnomborg.getValue().toString().toUpperCase());
            pertorgacad.setUasbActividad(smpertorgforpart.getValue() == null ? null : smpertorgforpart.getValue().toString().charAt(0));
            pertorgacad.setTipoActividad(smpertorgtiporg.getValue() == null ? null : Long.parseLong(smpertorgtiporg.getValue().toString()));
            pertorgacad.setObsActividad(itxtpertorgobserv.getValue() == null ? null : itxtpertorgobserv.getValue().toString().toUpperCase());
            pertorgacad.setFinicioActividad(new java.sql.Date(dfecinipertorg.getTime()));
            pertorgacad.setFfinActividad(dfecfinpertorg == null ? null : new java.sql.Date(dfecfinpertorg.getTime()));
            if (actevenextaux.getOtraActividadAcademicaPK() == null) {
                OtraActividadAcademicaPK pertorgpk = new OtraActividadAcademicaPK();
                pertorgpk.setCodigoProfesor(codProfesor);
                pertorgpk.setTipoOtraActividad('P');
                pertorgacad.setOtraActividadAcademicaPK(pertorgpk);
                pertorgacad.setFechaCrea(new Date());
                pertorgacad.setUsuarioCrea("Internet");
                pertorgacad.setFechaUltmodific(new Date());
                pertorgacad.setUsuarioUltmodific("Internet");
                otraactividadFacade.create(pertorgacad);
            } else {
                pertorgacad.setFechaUltmodific(new Date());
                pertorgacad.setUsuarioUltmodific("Internet");
                otraactividadFacade.edit(pertorgacad);
            }
            //Recuepro los datos de educacion continua externa

            FacesMessage msg = new FacesMessage("Pertenencia a Organizaciones Guardados");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            recuperaPertOrgAcad(codProfesor, anio);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al guardar la información");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

        } finally {
            pertorgacad = new OtraActividadAcademica();
            CancelPertOrg();
        }
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">  

    public void EditPertOrg() {
        if (selectedpertorgacad != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            pertorgacad = selectedpertorgacad;
            dfecinipertorg = (pertorgacad.getFinicioActividad() == null ? null : new java.sql.Date(pertorgacad.getFinicioActividad().getTime()));
            dfecfinpertorg = (pertorgacad.getFfinActividad() == null ? null : new java.sql.Date(pertorgacad.getFfinActividad().getTime()));
            itxtpertorgnomborg.setValue(pertorgacad.getNombreActividad() == null ? null : pertorgacad.getNombreActividad());
            smpertorgforpart.setValue(pertorgacad.getUasbActividad() == null ? null : pertorgacad.getUasbActividad());
            smpertorgtiporg.setValue(pertorgacad.getTipoActividad() == null ? null : pertorgacad.getTipoActividad());
            itxtpertorgobserv.setValue(pertorgacad.getObsActividad() == null ? null : pertorgacad.getObsActividad());
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Pertenencia Organización a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">  

    public void DeletePertOrg() {
        if (selectedpertorgacad != null) {
            try {
                OtraActividadAcademica actevenaux = new OtraActividadAcademica();
                actevenaux = otraactividadFacade.find(selectedpertorgacad.getOtraActividadAcademicaPK());
                otraactividadFacade.remove(actevenaux);
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infovinculacion:gpertorganizacion");
                recuperaPertOrgAcad(codProfesor, anio);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de: Pertenencia Organizaciones", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

            } finally {
                pertorgacad = new OtraActividadAcademica();

            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar Pertenencia a Organizaciones a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">  

    public void CancelPertOrg() {
        selectedpertorgacad = new OtraActividadAcademica();
        pertorgacad = new OtraActividadAcademica();
        dfecinipertorg = null;
        dfecfinpertorg = null;
        itxtpertorgnomborg.setValue(null);
        smpertorgforpart.setValue(null);
        smpertorgtiporg.setValue(null);
        itxtpertorgobserv.setValue(null);
    }
    // </editor-fold> 
// </editor-fold> 

    public void eliminarRegistro(ActionEvent ae) {
        switch (modal1.getActiveIndexAcoordion()) {
            case 2:
                switch (modal1.getActiveIndexTabviewvinculacion()) {
                    case 0:
                        DeleteEducContUasb();
                        break;
                    case 1:
                        DeleteActeveuasb();
                        break;
                    case 2:
                        DeleteActeveext();
                        break;
                    case 3:
                        DeletePertOrg();
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
            case 2:
                switch (modal1.getActiveIndexTabviewvinculacion()) {
                    case 0:
                        modal1.setUrlmodal("/pages/infoanual/vinculacionColectividad/formacionContinuaModal.xhtml");
                        break;
                    case 1:
                        modal1.setUrlmodal("/pages/infoanual/vinculacionColectividad/actividadEveUasbModal.xhtml");
                        break;
                    case 2:
                        modal1.setUrlmodal("/pages/infoanual/vinculacionColectividad/actividadEveExtModal.xhtml");
                        break;
                    case 3:
                        modal1.setUrlmodal("/pages/infoanual/vinculacionColectividad/pertenenciaOrganizacionModal.xhtml");
                        break;
                    default:
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
        if (modal1.getActiveIndexAcoordion() == 2) {
            switch (modal1.getActiveIndexTabviewvinculacion()) {
                case 0:
                    EditEducContUasb();
                    break;
                case 1:
                    EditActevenuasb();
                    break;
                case 2:
                    EditActevenext();
                    break;
                case 3:
                    EditPertOrg();
                    break;
                default:
                    break;
            }
        }
    }

    public void onRowSelect(SelectEvent event) {
        //ASIGNATURA EXTERNA
        if (modal1.getActiveIndexAcoordion() == 2) {
            switch (modal1.getActiveIndexTabviewvinculacion()) {
                case 0:
                    selectededuccontuasb = (OtraActividadAcademica) event.getObject();
                    break;
                case 1:
                    selectedactevenuasb = (OtraActividadAcademica) event.getObject();
                    break;
                case 2:
                    selectedactevenext = (OtraActividadAcademica) event.getObject();
                    break;
                case 3:
                    selectedpertorgacad = (OtraActividadAcademica) event.getObject();
                    break;
            }
        }
    }

    private void reset() {
        selectededuccontuasb = null;
        selectedactevenuasb = null;
        selectedactevenext = null;
        selectedpertorgacad = null;
    }

    public void onRowUnselect(UnselectEvent event) {
        reset();
    }
}