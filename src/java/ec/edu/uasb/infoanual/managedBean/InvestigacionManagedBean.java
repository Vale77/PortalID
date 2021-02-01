/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.managedBean;


import ec.edu.uasb.entities.Ciudad;
import ec.edu.uasb.entities.Facultad;
import ec.edu.uasb.entities.Pais;
import ec.edu.uasb.infoanual.entities.OtraActividadAcademica;
import ec.edu.uasb.infoanual.entities.OtraActividadAcademicaPK;

import ec.edu.uasb.infoanual.entities.PublicacionProfesor;
import ec.edu.uasb.infoanual.entities.PublicacionProfesorPK;

import ec.edu.uasb.infoanual.session.ConsultaFacadeLocal;
import ec.edu.uasb.infoanual.session.FacultadFacadeLocal;
import ec.edu.uasb.infoanual.session.OtraActividadAcademicaFacadeLocal;

import ec.edu.uasb.infoanual.session.PublicacionProfesorFacadeLocal;
import ec.edu.uasb.portaldoc.entities.CicloAcademico;
import ec.edu.uasb.portaldoc.session.CicloAcademicoFacadeLocal;
import ec.edu.uasb.session.CiudadFacadeLocal;
import ec.edu.uasb.session.PaisFacadeLocal;
//import ec.edu.uasb.seg.entities.Usuario;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
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
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
/**
 *
 * @author johana.orozco
 */
@ManagedBean(name = "investigacion")
@ViewScoped
public class InvestigacionManagedBean implements Serializable {

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    private Date feciniciclo;
    private Date fecfinciclo;
    private Long codProfesor;
    private Long anio;
    private String msgtablavacia = "No existen datos Registrados";
    //Fondo Investigaciones UASB
    private List<String[]> listFondInvest = new ArrayList<String[]>();
    //Fondo Investigadores Asociados
    private List<String[]> listInvestAso = new ArrayList<String[]>();
    //Fondo Investigaciones Intersintitucionales
    private List<OtraActividadAcademica> listproyInter = new ArrayList<OtraActividadAcademica>();
    private HtmlSelectOneMenu smproyinterroldoc = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smproyinterlinestra = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smproyintertipo = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smproyinterinforme = new HtmlSelectOneMenu();
    private HtmlInputText itxtproyinternomproyecto = new HtmlInputText();
    private HtmlSelectOneMenu smproyinterestproy = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smproyinterauspicio = new HtmlSelectOneMenu();
    private HtmlInputText itxtproyinternominstitucion = new HtmlInputText();
    private HtmlInputText itxtproyinternomauspicio = new HtmlInputText();
    private HtmlSelectOneMenu smproyinterpais = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smproyinterciudad = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smproyinterfacultad = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smalcanceinter = new HtmlSelectOneMenu();
    private Date feciniproyinter;
    private Date fecfinproyinter;
    OtraActividadAcademica proyinter = new OtraActividadAcademica();
    private List<Ciudad> listCiudadtit = new ArrayList<Ciudad>();
    private List<Facultad> listFacultad = new ArrayList<Facultad>();
    //Publicaciones
    private List<PublicacionProfesor> listpublicacion = new ArrayList<PublicacionProfesor>();
    private List<PublicacionProfesor> listpublicacionformante = new ArrayList<PublicacionProfesor>();
    //Guardado publicaciones
    PublicacionProfesor publicacionprofesor = new PublicacionProfesor();
    private HtmlSelectOneMenu smtippublicacion = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smtipparticipacion = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smpaispub = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smciudadpub = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smformpub = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smidiomapub = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smausppub = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smrol = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smalcact = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smduracion = new HtmlSelectOneMenu();
    private HtmlInputText itxtdetotroausp = new HtmlInputText();
    private boolean bhabdetotausp = false;
    private HtmlInputText itxtdbapellautor = new HtmlInputText();
    private HtmlInputText itxtdbnombreautor = new HtmlInputText();
    private boolean bhabdbdatautor = false;
    private HtmlInputText itxtdbapellcoautor = new HtmlInputText();
    private HtmlInputText itxtdbnombrecoautor = new HtmlInputText();
    private InputTextarea itxtdbtitulo = new InputTextarea();
    private HtmlInputText itxtdbsubtitulo = new HtmlInputText();
    private HtmlInputText itxtdbtitulocapi = new HtmlInputText();
    private HtmlInputText itxtdbnomrev = new HtmlInputText();
    private HtmlInputText itxtdbdesedicion = new HtmlInputText();
    private HtmlInputText itxtdbnomeve = new HtmlInputText();
    private boolean bhabdbtitcap = false;
    private HtmlInputText itxtdbedicion = new HtmlInputText();
    private HtmlInputText itxtdbeditorial = new HtmlInputText();
    private String sanioedicion;
    private String saniovisualizacion;
    private Date dbfecedicion;
    private HtmlSelectOneMenu smdbestado = new HtmlSelectOneMenu();
    private HtmlInputText itxtdbnumpag = new HtmlInputText();
    private HtmlInputText itxtdbtitrevista = new HtmlInputText();
    private boolean bhabdbtitrev = false;
    private HtmlInputText itxtdbvolumen = new HtmlInputText();
    private HtmlInputText itxtdbnumcod = new HtmlInputText();
    private String etcod = "N/A:";
    private HtmlInputText itxtdburl = new HtmlInputText();
    private HtmlInputText itxtdbdetalletipopub = new HtmlInputText();
    private boolean bhabdburl = true;
    private HtmlSelectOneMenu smdbrevpar = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smdbbaserev = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smdbedicion = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smdbtipvarios = new HtmlSelectOneMenu();
    private HtmlInputText itxtdnombase = new HtmlInputText();
    private boolean bhabdnombase = true;
    private LinkedHashMap<String, String> listtippart = new LinkedHashMap<String, String>();
    private LinkedHashMap<String, String> listrol = new LinkedHashMap<String, String>();
    private String sompartserie = "0";
    private String somverdetbiblio = "0";
    private HtmlInputText itxtdtitserie = new HtmlInputText();
    private HtmlInputText itxtbaseindex = new HtmlInputText();
    private HtmlInputText itxtdtit = new HtmlInputText();
    private HtmlInputText itxtdbentidadsede = new HtmlInputText();
    private HtmlInputText itxtentidadsede = new HtmlInputText();
    private HtmlSelectOneMenu smevento = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smmeddif = new HtmlSelectOneMenu();
    private String stettitulo = "Título: ";
    private List<Pais> listPaistit = new ArrayList<Pais>();
    private String labelTipoPub = "Tipo*";
    private String labelAnioPub = "Año*";
    private String labelTitulo = "Título*";
    private String labelPagina = "Número de Páginas*";
    private String labelFecha = "Fecha de Edición*";
    private boolean btitcapitulo = false;
    private boolean beditorial = false;
    private boolean bpagina = false;
    private boolean bcodigo = false;
    private boolean bauspicio = false;
    private boolean bpublicacion = false;
    private boolean bserie = false;
    private boolean bpares = false;
    private boolean bnombrerev = false;
    private boolean bparesrev = false;
    private boolean bbaseindex = false;
    private boolean bnombeve = false;
    private boolean bduracion = false;
    private boolean isRevista = false;
    private boolean bDetalleTipPub = false;
    private boolean bAlcanceAnio = false;
    private boolean bAnioVisualizacion = false;
    private Integer indiceTab = 0;

    @EJB
    private ConsultaFacadeLocal consultaFacade;
    @EJB
    private OtraActividadAcademicaFacadeLocal otraactividadFacade;
    @EJB
    private PaisFacadeLocal paisFacade;
    @EJB
    private CiudadFacadeLocal ciudadFacade;
    @EJB
    private PublicacionProfesorFacadeLocal publicacionFacade;
    @EJB
    private FacultadFacadeLocal facultadFacade;
    @EJB
    private CicloAcademicoFacadeLocal cicloAcademicoFacade;
    private List<CicloAcademico> ciclos = new ArrayList<CicloAcademico>();
//    private Usuario usr = new Usuario();
    @ManagedProperty( value = "#{modal}")
    private modalManagedBean modal1;
    // <editor-fold defaultstate="collapsed" desc="DECLARACION VARIABLES">

    public PublicacionProfesor getPublicacionprofesor() {
        return publicacionprofesor;
    }

    public void setPublicacionprofesor(PublicacionProfesor publicacionprofesor) {
        this.publicacionprofesor = publicacionprofesor;
    }

    public modalManagedBean getModal1() {
        return modal1;
    }

    public void setModal1(modalManagedBean modal1) {
        this.modal1 = modal1;
    }

    public List<PublicacionProfesor> getListpublicacionformante() {
        return listpublicacionformante;
    }

    public void setListpublicacionformante(List<PublicacionProfesor> listpublicacionformante) {
        this.listpublicacionformante = listpublicacionformante;
    }

    public HtmlSelectOneMenu getSmproyinterfacultad() {
        return smproyinterfacultad;
    }

    public void setSmproyinterfacultad(HtmlSelectOneMenu smproyinterfacultad) {
        this.smproyinterfacultad = smproyinterfacultad;
    }

    public List<Facultad> getListFacultad() {
        listFacultad = facultadFacade.findAllactiva();
        return listFacultad;
    }

    public void setListFacultad(List<Facultad> listFacultad) {
        this.listFacultad = listFacultad;
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

    public List<Pais> getListPaistit() {
        listPaistit = paisFacade.findAllorde();
        return listPaistit;
    }

    public void setListPaistit(List<Pais> listPaistit) {
        this.listPaistit = listPaistit;
    }

    public String getStettitulo() {
        return stettitulo;
    }

    public void setStettitulo(String stettitulo) {
        this.stettitulo = stettitulo;
    }

    public List<PublicacionProfesor> getListpublicacion() {
        return listpublicacion;
    }

    public void setListpublicacion(List<PublicacionProfesor> listpublicacion) {
        this.listpublicacion = listpublicacion;
    }

    public HtmlSelectOneMenu getSmtippublicacion() {
        return smtippublicacion;
    }

    public void setSmtippublicacion(HtmlSelectOneMenu smtippublicacion) {
        this.smtippublicacion = smtippublicacion;
    }

    public HtmlSelectOneMenu getSmtipparticipacion() {
        return smtipparticipacion;
    }

    public void setSmtipparticipacion(HtmlSelectOneMenu smtipparticipacion) {
        this.smtipparticipacion = smtipparticipacion;
    }

    public HtmlSelectOneMenu getSmpaispub() {
        return smpaispub;
    }

    public void setSmpaispub(HtmlSelectOneMenu smpaispub) {
        this.smpaispub = smpaispub;
    }

    public HtmlSelectOneMenu getSmciudadpub() {
        return smciudadpub;
    }

    public void setSmciudadpub(HtmlSelectOneMenu smciudadpub) {
        this.smciudadpub = smciudadpub;
    }

    public HtmlSelectOneMenu getSmformpub() {
        return smformpub;
    }

    public void setSmformpub(HtmlSelectOneMenu smformpub) {
        this.smformpub = smformpub;
    }

    public HtmlSelectOneMenu getSmidiomapub() {
        return smidiomapub;
    }

    public void setSmidiomapub(HtmlSelectOneMenu smidiomapub) {
        this.smidiomapub = smidiomapub;
    }

    public HtmlSelectOneMenu getSmausppub() {
        return smausppub;
    }

    public void setSmausppub(HtmlSelectOneMenu smausppub) {
        this.smausppub = smausppub;
    }

    public HtmlInputText getItxtdetotroausp() {
        return itxtdetotroausp;
    }

    public void setItxtdetotroausp(HtmlInputText itxtdetotroausp) {
        this.itxtdetotroausp = itxtdetotroausp;
    }

    public boolean isBhabdetotausp() {
        return bhabdetotausp;
    }

    public void setBhabdetotausp(boolean bhabdetotausp) {
        this.bhabdetotausp = bhabdetotausp;
    }

    public HtmlInputText getItxtdbapellautor() {
        return itxtdbapellautor;
    }

    public void setItxtdbapellautor(HtmlInputText itxtdbapellautor) {
        this.itxtdbapellautor = itxtdbapellautor;
    }

    public HtmlInputText getItxtdbnombreautor() {
        return itxtdbnombreautor;
    }

    public void setItxtdbnombreautor(HtmlInputText itxtdbnombreautor) {
        this.itxtdbnombreautor = itxtdbnombreautor;
    }

    public boolean isBhabdbdatautor() {
        return bhabdbdatautor;
    }

    public void setBhabdbdatautor(boolean bhabdbdatautor) {
        this.bhabdbdatautor = bhabdbdatautor;
    }

    public HtmlInputText getItxtdbapellcoautor() {
        return itxtdbapellcoautor;
    }

    public void setItxtdbapellcoautor(HtmlInputText itxtdbapellcoautor) {
        this.itxtdbapellcoautor = itxtdbapellcoautor;
    }

    public HtmlInputText getItxtdbnombrecoautor() {
        return itxtdbnombrecoautor;
    }

    public void setItxtdbnombrecoautor(HtmlInputText itxtdbnombrecoautor) {
        this.itxtdbnombrecoautor = itxtdbnombrecoautor;
    }

    public InputTextarea getItxtdbtitulo() {
        return itxtdbtitulo;
    }

    public void setItxtdbtitulo(InputTextarea itxtdbtitulo) {
        this.itxtdbtitulo = itxtdbtitulo;
    }

    public HtmlInputText getItxtdbsubtitulo() {
        return itxtdbsubtitulo;
    }

    public void setItxtdbsubtitulo(HtmlInputText itxtdbsubtitulo) {
        this.itxtdbsubtitulo = itxtdbsubtitulo;
    }

    public HtmlInputText getItxtdbtitulocapi() {
        return itxtdbtitulocapi;
    }

    public void setItxtdbtitulocapi(HtmlInputText itxtdbtitulocapi) {
        this.itxtdbtitulocapi = itxtdbtitulocapi;
    }

    public boolean isBhabdbtitcap() {
        return bhabdbtitcap;
    }

    public void setBhabdbtitcap(boolean bhabdbtitcap) {
        this.bhabdbtitcap = bhabdbtitcap;
    }

    public HtmlInputText getItxtdbedicion() {
        return itxtdbedicion;
    }

    public void setItxtdbedicion(HtmlInputText itxtdbedicion) {
        this.itxtdbedicion = itxtdbedicion;
    }

    public HtmlInputText getItxtdbeditorial() {
        return itxtdbeditorial;
    }

    public void setItxtdbeditorial(HtmlInputText itxtdbeditorial) {
        this.itxtdbeditorial = itxtdbeditorial;
    }

    public String getSanioedicion() {
        return sanioedicion;
    }

    public void setSanioedicion(String sanioedicion) {
        this.sanioedicion = sanioedicion;
    }

    public Date getDbfecedicion() {
        return dbfecedicion;
    }

    public void setDbfecedicion(Date dbfecedicion) {
        this.dbfecedicion = dbfecedicion;
    }

    public HtmlSelectOneMenu getSmdbestado() {
        return smdbestado;
    }

    public void setSmdbestado(HtmlSelectOneMenu smdbestado) {
        this.smdbestado = smdbestado;
    }

    public HtmlInputText getItxtdbnumpag() {
        return itxtdbnumpag;
    }

    public void setItxtdbnumpag(HtmlInputText itxtdbnumpag) {
        this.itxtdbnumpag = itxtdbnumpag;
    }

    public HtmlInputText getItxtdbtitrevista() {
        return itxtdbtitrevista;
    }

    public void setItxtdbtitrevista(HtmlInputText itxtdbtitrevista) {
        this.itxtdbtitrevista = itxtdbtitrevista;
    }

    public boolean isBhabdbtitrev() {
        return bhabdbtitrev;
    }

    public void setBhabdbtitrev(boolean bhabdbtitrev) {
        this.bhabdbtitrev = bhabdbtitrev;
    }

    public HtmlInputText getItxtdbvolumen() {
        return itxtdbvolumen;
    }

    public void setItxtdbvolumen(HtmlInputText itxtdbvolumen) {
        this.itxtdbvolumen = itxtdbvolumen;
    }

    public HtmlInputText getItxtdbnumcod() {
        return itxtdbnumcod;
    }

    public void setItxtdbnumcod(HtmlInputText itxtdbnumcod) {
        this.itxtdbnumcod = itxtdbnumcod;
    }

    public String getEtcod() {
        return etcod;
    }

    public void setEtcod(String etcod) {
        this.etcod = etcod;
    }

    public HtmlInputText getItxtdburl() {
        return itxtdburl;
    }

    public void setItxtdburl(HtmlInputText itxtdburl) {
        this.itxtdburl = itxtdburl;
    }

    public boolean isBhabdburl() {
        return bhabdburl;
    }

    public void setBhabdburl(boolean bhabdburl) {
        this.bhabdburl = bhabdburl;
    }

    public HtmlSelectOneMenu getSmdbrevpar() {
        return smdbrevpar;
    }

    public void setSmdbrevpar(HtmlSelectOneMenu smdbrevpar) {
        this.smdbrevpar = smdbrevpar;
    }

    public HtmlSelectOneMenu getSmdbbaserev() {
        return smdbbaserev;
    }

    public void setSmdbbaserev(HtmlSelectOneMenu smdbbaserev) {
        this.smdbbaserev = smdbbaserev;
    }

    public HtmlInputText getItxtdnombase() {
        return itxtdnombase;
    }

    public void setItxtdnombase(HtmlInputText itxtdnombase) {
        this.itxtdnombase = itxtdnombase;
    }

    public boolean isBhabdnombase() {
        return bhabdnombase;
    }

    public void setBhabdnombase(boolean bhabdnombase) {
        this.bhabdnombase = bhabdnombase;
    }

    public LinkedHashMap<String, String> getListtippart() {
        return listtippart;
    }

    public void setListtippart(LinkedHashMap<String, String> listtippart) {
        this.listtippart = listtippart;
    }

    public String getSompartserie() {
        return sompartserie;
    }

    public void setSompartserie(String sompartserie) {
        this.sompartserie = sompartserie;
    }

    public String getSomverdetbiblio() {
        return somverdetbiblio;
    }

    public void setSomverdetbiblio(String somverdetbiblio) {
        this.somverdetbiblio = somverdetbiblio;
    }

    public HtmlInputText getItxtdtitserie() {
        return itxtdtitserie;
    }

    public void setItxtdtitserie(HtmlInputText itxtdtitserie) {
        this.itxtdtitserie = itxtdtitserie;
    }

    public HtmlInputText getItxtdbentidadsede() {
        return itxtdbentidadsede;
    }

    public void setItxtdbentidadsede(HtmlInputText itxtdbentidadsede) {
        this.itxtdbentidadsede = itxtdbentidadsede;
    }

    public HtmlInputText getItxtentidadsede() {
        return itxtentidadsede;
    }

    public void setItxtentidadsede(HtmlInputText itxtentidadsede) {
        this.itxtentidadsede = itxtentidadsede;
    }

    public HtmlSelectOneMenu getSmevento() {
        return smevento;
    }

    public void setSmevento(HtmlSelectOneMenu smevento) {
        this.smevento = smevento;
    }

    public HtmlSelectOneMenu getSmmeddif() {
        return smmeddif;
    }

    public void setSmmeddif(HtmlSelectOneMenu smmeddif) {
        this.smmeddif = smmeddif;
    }

    public List<Ciudad> getListCiudadtit() {
        return listCiudadtit;
    }

    public void setListCiudadtit(List<Ciudad> listCiudadtit) {
        this.listCiudadtit = listCiudadtit;
    }

    public HtmlSelectOneMenu getSmproyinterroldoc() {
        return smproyinterroldoc;
    }

    public void setSmproyinterroldoc(HtmlSelectOneMenu smproyinterroldoc) {
        this.smproyinterroldoc = smproyinterroldoc;
    }

    public HtmlInputText getItxtproyinternomproyecto() {
        return itxtproyinternomproyecto;
    }

    public void setItxtproyinternomproyecto(HtmlInputText itxtproyinternomproyecto) {
        this.itxtproyinternomproyecto = itxtproyinternomproyecto;
    }

    public HtmlSelectOneMenu getSmproyinterestproy() {
        return smproyinterestproy;
    }

    public void setSmproyinterestproy(HtmlSelectOneMenu smproyinterestproy) {
        this.smproyinterestproy = smproyinterestproy;
    }

    public HtmlSelectOneMenu getSmproyinterauspicio() {
        return smproyinterauspicio;
    }

    public void setSmproyinterauspicio(HtmlSelectOneMenu smproyinterauspicio) {
        this.smproyinterauspicio = smproyinterauspicio;
    }

    public HtmlInputText getItxtproyinternominstitucion() {
        return itxtproyinternominstitucion;
    }

    public void setItxtproyinternominstitucion(HtmlInputText itxtproyinternominstitucion) {
        this.itxtproyinternominstitucion = itxtproyinternominstitucion;
    }

    public HtmlSelectOneMenu getSmproyinterpais() {
        return smproyinterpais;
    }

    public void setSmproyinterpais(HtmlSelectOneMenu smproyinterpais) {
        this.smproyinterpais = smproyinterpais;
    }

    public HtmlSelectOneMenu getSmproyinterciudad() {
        return smproyinterciudad;
    }

    public void setSmproyinterciudad(HtmlSelectOneMenu smproyinterciudad) {
        this.smproyinterciudad = smproyinterciudad;
    }

    public Date getFeciniproyinter() {
        return feciniproyinter;
    }

    public void setFeciniproyinter(Date feciniproyinter) {
        this.feciniproyinter = feciniproyinter;
    }

    public Date getFecfinproyinter() {
        return fecfinproyinter;
    }

    public void setFecfinproyinter(Date fecfinproyinter) {
        this.fecfinproyinter = fecfinproyinter;
    }

    public List<String[]> getListInvestAso() {
        return listInvestAso;
    }

    public void setListInvestAso(List<String[]> listInvestAso) {
        this.listInvestAso = listInvestAso;
    }

    public String getMsgtablavacia() {
        return msgtablavacia;
    }

    public void setMsgtablavacia(String msgtablavacia) {
        this.msgtablavacia = msgtablavacia;
    }

    public List<String[]> getListFondInvest() {
        return listFondInvest;
    }

    public void setListFondInvest(List<String[]> listFondInvest) {
        this.listFondInvest = listFondInvest;
    }
    
    public HtmlSelectOneMenu getSmproyinterlinestra() {
        return smproyinterlinestra;
    }

    public void setSmproyinterlinestra(HtmlSelectOneMenu smproyinterlinestra) {
        this.smproyinterlinestra = smproyinterlinestra;
    }
    
    public HtmlSelectOneMenu getSmproyintertipo() {
        return smproyintertipo;
    }

    public void setSmproyintertipo(HtmlSelectOneMenu smproyintertipo) {
        this.smproyintertipo = smproyintertipo;
    }
    
    public HtmlInputText getItxtproyinternomauspicio() {
        return itxtproyinternomauspicio;
    }

    public void setItxtproyinternomauspicio(HtmlInputText itxtproyinternomauspicio) {
        this.itxtproyinternomauspicio = itxtproyinternomauspicio;
    }
    
    public HtmlSelectOneMenu getSmproyinterinforme() {
        return smproyinterinforme;
    }

    public void setSmproyinterinforme(HtmlSelectOneMenu smproyinterinforme) {
        this.smproyinterinforme = smproyinterinforme;
    }
    
    public String getLabelTipoPub() {
        return labelTipoPub;
    }

    public void setLabelTipoPub(String labelTipoPub) {
        this.labelTipoPub = labelTipoPub;
    }
    
    public HtmlSelectOneMenu getSmrol() {
        return smrol;
    }

    public void setSmrol(HtmlSelectOneMenu smrol) {
        this.smrol = smrol;
    }
    
    public LinkedHashMap<String, String> getListrol() {
        return listrol;
    }

    public void setListrol(LinkedHashMap<String, String> listrol) {
        this.listrol = listrol;
    }
    
    public String getLabelAnioPub() {
        return labelAnioPub;
    }

    public void setLabelAnioPub(String labelAnioPub) {
        this.labelAnioPub = labelAnioPub;
    }
    
    public String getLabelTitulo() {
        return labelTitulo;
    }

    public void setLabelTitulo(String labelTitulo) {
        this.labelTitulo = labelTitulo;
    }
    
    public HtmlInputText getItxtdtit() {
        return itxtdtit;
    }

    public void setItxtdtit(HtmlInputText itxtdtit) {
        this.itxtdtit = itxtdtit;
    }
    
    public boolean isBtitcapitulo() {
        return btitcapitulo;
    }

    public void setBtitcapitulo(boolean btitcapitulo) {
        this.btitcapitulo = btitcapitulo;
    }
    
    public boolean isBeditorial() {
        return beditorial;
    }

    public void setBeditorial(boolean beditorial) {
        this.beditorial = beditorial;
    }
    
    public String getLabelPagina() {
        return labelPagina;
    }

    public void setLabelPagina(String labelPagina) {
        this.labelPagina = labelPagina;
    }

    public boolean isBpagina() {
        return bpagina;
    }

    public void setBpagina(boolean bpagina) {
        this.bpagina = bpagina;
    }
    
    public String getLabelFecha() {
        return labelFecha;
    }

    public void setLabelFecha(String labelFecha) {
        this.labelFecha = labelFecha;
    }
    
    public boolean isBcodigo() {
        return bcodigo;
    }

    public void setBcodigo(boolean bcodigo) {
        this.bcodigo = bcodigo;
    }
    
    public boolean isBauspicio() {
        return bauspicio;
    }

    public void setBauspicio(boolean bauspicio) {
        this.bauspicio = bauspicio;
    }
    
    public boolean isBpublicacion() {
        return bpublicacion;
    }

    public void setBpublicacion(boolean bpublicacion) {
        this.bpublicacion = bpublicacion;
    }
    
    public boolean isBserie() {
        return bserie;
    }

    public void setBserie(boolean bserie) {
        this.bserie = bserie;
    }
    
    public boolean isBpares() {
        return bpares;
    }

    public void setBpares(boolean bpares) {
        this.bpares = bpares;
    }
    
    public HtmlSelectOneMenu getSmdbedicion() {
        return smdbedicion;
    }

    public void setSmdbedicion(HtmlSelectOneMenu smdbedicion) {
        this.smdbedicion = smdbedicion;
    }
    
    public HtmlSelectOneMenu getSmdbtipvarios() {
        return smdbtipvarios;
    }

    public void setSmdbtipvarios(HtmlSelectOneMenu smdbtipvarios) {
        this.smdbtipvarios = smdbtipvarios;
    }
    
    public HtmlInputText getItxtdbnomrev() {
        return itxtdbnomrev;
    }

    public void setItxtdbnomrev(HtmlInputText itxtdbnomrev) {
        this.itxtdbnomrev = itxtdbnomrev;
    }
    
    public boolean isBnombrerev() {
        return bnombrerev;
    }

    public void setBnombrerev(boolean bnombrerev) {
        this.bnombrerev = bnombrerev;
    }
    
    public HtmlInputText getItxtdbdesedicion() {
        return itxtdbdesedicion;
    }

    public void setItxtdbdesedicion(HtmlInputText itxtdbdesedicion) {
        this.itxtdbdesedicion = itxtdbdesedicion;
    }
    
    public HtmlInputText getItxtbaseindex() {
        return itxtbaseindex;
    }

    public void setItxtbaseindex(HtmlInputText itxtbaseindex) {
        this.itxtbaseindex = itxtbaseindex;
    }
    
    public boolean isBparesrev() {
        return bparesrev;
    }

    public void setBparesrev(boolean bparesrev) {
        this.bparesrev = bparesrev;
    }
    
    public boolean isBbaseindex() {
        return bbaseindex;
    }

    public void setBbaseindex(boolean bbaseindex) {
        this.bbaseindex = bbaseindex;
    }
    
    public boolean isBnombeve() {
        return bnombeve;
    }

    public void setBnombeve(boolean bnombeve) {
        this.bnombeve = bnombeve;
    }
    
    public HtmlInputText getItxtdbnomeve() {
        return itxtdbnomeve;
    }

    public void setItxtdbnomeve(HtmlInputText itxtdbnomeve) {
        this.itxtdbnomeve = itxtdbnomeve;
    }
    
    public HtmlSelectOneMenu getSmalcact() {
        return smalcact;
    }

    public void setSmalcact(HtmlSelectOneMenu smalcact) {
        this.smalcact = smalcact;
    }
    
    public boolean isBduracion() {
        return bduracion;
    }

    public void setBduracion(boolean bduracion) {
        this.bduracion = bduracion;
    }
    
    public HtmlSelectOneMenu getSmduracion() {
        return smduracion;
    }

    public void setSmduracion(HtmlSelectOneMenu smduracion) {
        this.smduracion = smduracion;
    }
    
    public boolean isIsRevista() {
        return isRevista;
    }

    public void setIsRevista(boolean isRevista) {
        this.isRevista = isRevista;
    }
    
    public boolean isbDetalleTipPub() {
        return bDetalleTipPub;
    }

    public void setbDetalleTipPub(boolean bDetalleTipPub) {
        this.bDetalleTipPub = bDetalleTipPub;
    }
    
    public HtmlInputText getItxtdbdetalletipopub() {
        return itxtdbdetalletipopub;
    }

    public void setItxtdbdetalletipopub(HtmlInputText itxtdbdetalletipopub) {
        this.itxtdbdetalletipopub = itxtdbdetalletipopub;
    }
    
    public Integer getIndiceTab() {
        return indiceTab;
    }

    public void setIndiceTab(Integer indiceTab) {
        this.indiceTab = indiceTab;
    }
    
    public HtmlSelectOneMenu getSmalcanceinter() {
        return smalcanceinter;
    }

    public void setSmalcanceinter(HtmlSelectOneMenu smalcanceinter) {
        this.smalcanceinter = smalcanceinter;
    }
    
    public boolean isbAlcanceAnio() {
        return bAlcanceAnio;
    }

    public void setbAlcanceAnio(boolean bAlcanceAnio) {
        this.bAlcanceAnio = bAlcanceAnio;
    }
    
    public boolean isbAnioVisualizacion() {
        return bAnioVisualizacion;
    }

    public void setbAnioVisualizacion(boolean bAnioVisualizacion) {
        this.bAnioVisualizacion = bAnioVisualizacion;
    }
    
    public String getSaniovisualizacion() {
        return saniovisualizacion;
    }

    public void setSaniovisualizacion(String saniovisualizacion) {
        this.saniovisualizacion = saniovisualizacion;
    }
    
    // </editor-fold>  
    /**
     * Creates a new instance of InvestigacionManagedBean
     */
    public InvestigacionManagedBean() {
//        usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
//        codProfesor = usr.getUsuCodigo();        
    }

    @PostConstruct
    private void init() {
        indiceTab = 0;
        modal1.setBeaninvestigacion(this);
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
        //Programa Fondos  UASB
        recuperaFondoInvest(codProfesor, anio);
        //Programa Investigadores Asociados
        recuperaInvestAsociado(codProfesor, anio);
        //REcupera investigaciones interinstitucionales
        recuperaProyectInter(codProfesor, anio);
        //Recupera Publicaciones
        recuperaPublicacion(codProfesor, anio);
        //Recupera Publicaciones
        recuperaPublicacionFormAnterior(codProfesor);
    }
    // <editor-fold defaultstate="collapsed" desc="FONDO DE INVESTIGACION UASB"> 
    // <editor-fold defaultstate="collapsed" desc="CARGA TABLA INVESTIGACION UASB">  
    
    private void recuperaFondoInvest(Long codProf, Long anio) {
        listFondInvest.clear();
        Vector v = new Vector();
        StringBuilder sql = new StringBuilder();
        sql.append(" execute dbo.sp_genInfoProyecto @anio = ").append(anio).append(" , @profesor = ").append(codProf).append(" ,@rep = 'N'  ");
        v = (Vector) consultaFacade.ejecutaSqlList(sql.toString());
        if (v.size() > 0) {
            for (int i = 0; i < v.size(); i++) {
                Object[] object = (Object[]) v.get(i);
                String[] fondoinvest;
                fondoinvest = new String[15];
                fondoinvest[0] = (object[0] == null ? null : object[0].toString());
                fondoinvest[1] = (object[1] == null ? null : object[1].toString());
                fondoinvest[2] = (object[2] == null ? null : object[2].toString());
                fondoinvest[3] = (object[3] == null ? null : object[3].toString());
                fondoinvest[4] = (object[4] == null ? null : object[4].toString());
                fondoinvest[5] = (object[5] == null ? null : object[5].toString());
                fondoinvest[6] = (object[6] == null ? null : object[6].toString());
                fondoinvest[7] = (object[7] == null ? null : object[7].toString());
                fondoinvest[8] = (object[8] == null ? null : object[8].toString());
                fondoinvest[9] = (object[9] == null ? null : formato.format(object[9]));
                fondoinvest[10] = (object[10] == null ? null : object[10].toString());
                fondoinvest[11] = (object[11] == null ? null : object[11].toString());
                fondoinvest[12] = (object[12] == null ? null : object[12].toString());
                fondoinvest[13] = (object[13] == null ? null : formato.format(object[13]));
                fondoinvest[14] = (object[14] == null ? null : object[14].toString());
                listFondInvest.add(i, fondoinvest);
            }
        }
    }
    // </editor-fold> 
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="INVESTIGADORES ASOCIADOS"> 
    // <editor-fold defaultstate="collapsed" desc="CARGA TABLA INVESTIGADOR ASOCIADO">  

    private void recuperaInvestAsociado(Long codProf, Long anio) {
        listInvestAso.clear();
        Vector v = new Vector();
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT PRO_NOMBRE, area_acad,  'ACOMPAÑAMIENTO' as roldocente,"
                + " 'INVESTIGACION' as lineainvestigacion,"
                + " estado_proyecto, convert(char(10),INV_FECINI,103) as fecini , INV_FECFIN,"
                + " UPPER(PER_APELLIDO)+' '+UPPER(PER_NOMBRE) AS NOMBRE_INVESTIGADOR,"
                + " UPPER(TIP_AFILIACION) AS TIP_AFILIACION"
                + " FROM V_INVESTIGADOR_ASOCIADO"
                + " WHERE CODIGO_PROFESOR  = ").append(codProf).append(" AND ").append(anio).append("between"
                + "(CASE WHEN INV_FECINI IS NULL THEN 1993 WHEN(SELECT anio FROM CICLO_ACADEMICO WHERE INV_FECINI >= CICLO_ACADEMICO.F_INICIO AND INV_FECINI <= CICLO_ACADEMICO.F_FINAL) IS NULL THEN (CASE WHEN (SELECT TOP (1) anio - 1 FROM CICLO_ACADEMICO WHERE INV_FECINI <= CICLO_ACADEMICO.F_FINAL) IS NULL THEN 1993 ELSE(SELECT TOP (1) anio - 1 FROM CICLO_ACADEMICO WHERE INV_FECINI <= CICLO_ACADEMICO.F_FINAL) END) ELSE(SELECT anio FROM CICLO_ACADEMICO WHERE INV_FECINI >= CICLO_ACADEMICO.F_INICIO AND INV_FECINI <= CICLO_ACADEMICO.F_FINAL) END) and"
                + "(CASE WHEN INV_FECFIN IS NULL THEN 2020 WHEN(SELECT anio FROM CICLO_ACADEMICO WHERE INV_FECFIN >= CICLO_ACADEMICO.F_INICIO AND INV_FECFIN <= CICLO_ACADEMICO.F_FINAL) IS NULL THEN (CASE WHEN (SELECT TOP (1) anio - 1 FROM CICLO_ACADEMICO WHERE INV_FECFIN <= CICLO_ACADEMICO.F_FINAL) IS NULL THEN 2020 ELSE(SELECT TOP (1) anio - 1 FROM CICLO_ACADEMICO WHERE INV_FECFIN <= CICLO_ACADEMICO.F_FINAL) END) ELSE(SELECT anio FROM CICLO_ACADEMICO WHERE INV_FECFIN >= CICLO_ACADEMICO.F_INICIO AND INV_FECFIN <= CICLO_ACADEMICO.F_FINAL) END)").append(" ORDER BY  INV_FECINI DESC");

        v = (Vector) consultaFacade.ejecutaSqlList(sql.toString());
        if (v.size() > 0) {
            for (int i = 0; i < v.size(); i++) {
                Object[] object = (Object[]) v.get(i);
                String[] investaso;
                investaso = new String[9];
                investaso[0] = object[0].toString();
                investaso[1] = object[1].toString();
                investaso[2] = object[2].toString();
                investaso[3] = object[3].toString();
                investaso[4] = object[4].toString();
                investaso[5] = (object[5] == null ? null : object[5].toString());
                investaso[6] = (object[6] == null ? null : formato.format(object[6]));
                investaso[7] = object[7].toString();
                investaso[8] = object[8].toString();
                listInvestAso.add(i, investaso);
            }
        }
    }
    // </editor-fold> 
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="INTERINSTITUCIONALES"> 
    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA PROYECTOS INTERINSTITUCIONALES"> 

    private void recuperaProyectInter(Long codProfesor, Long anio) {
        OtraActividadAcademica otactaux = new OtraActividadAcademica();
        Pais paisaxu = new Pais();
        Ciudad ciuaux = new Ciudad();
        List<OtraActividadAcademica> listOtactaux = new ArrayList<OtraActividadAcademica>();
        listproyInter.clear();
        listOtactaux.clear();
        listOtactaux = otraactividadFacade.findProyInter(codProfesor, anio);
        for (int i = 0; i < listOtactaux.size(); i++) {
            otactaux = listOtactaux.get(i);
            if (otactaux.getPaisInvest() != null) {
                paisaxu = paisFacade.finbyCodigo(otactaux.getPaisInvest());
                if (paisaxu != null) {
                    otactaux.setNomPas(paisaxu.getNomPais());
                    if (otactaux.getCiudadInvest() != null) {
                        if (otactaux.getCiudadInvest() != 0) {
                            ciuaux = ciudadFacade.finbyCodigo(otactaux.getPaisInvest(), otactaux.getCiudadInvest());
                            if (ciuaux != null) {
                                otactaux.setNomCiudad(ciuaux.getNomCiudad());
                            }
                        }
                    }
                }

            }
            if (otactaux.getDuracionActividad() != null) {
                switch (Integer.parseInt(otactaux.getDuracionActividad().toString())) {
                    case 1:
                        otactaux.setNomRol("Director/Coordinador");
                        break;
                    case 2:
                        otactaux.setNomRol("Investigador principal");
                        break;
                    case 3:
                        otactaux.setNomRol("Investigador");
                        break;
                    case 4:
                        otactaux.setNomRol("Consultor");
                        break;
                    case 5:
                        otactaux.setNomRol("Miembro comisión ética");
                        break;
                    case 6:
                        otactaux.setNomRol("Miembro tribunal");
                        break;
                    case 7:
                        otactaux.setNomRol("Técnico");
                        break;
                }


            }
            if (otactaux.getTipo2Actividad() != null) {
                switch (otactaux.getTipo2Actividad()) {
                    case 'C':
                        otactaux.setNomEstproyecto("Concluido");
                        break;
                    case 'P':
                        otactaux.setNomEstproyecto("En proceso");
                        break;
                    case 'E':
                        otactaux.setNomEstproyecto("En Elaboración");
                        break;
                    case 'S':
                        otactaux.setNomEstproyecto("Suspendido Temporalmente");
                        break;
                    case 'D':
                        otactaux.setNomEstproyecto("Suspendido Definitivamente");
                        break;

                }
            }
            if (otactaux.getSedeInstActividad() != null) {
                switch (otactaux.getSedeInstActividad()) {
                    case 'U':
                        otactaux.setNomAuspicio("UASB");
                        break;
                    case 'C':
                        otactaux.setNomAuspicio("Cofinanciamiento con UASB");
                        break;
                    case 'O':
                        otactaux.setNomAuspicio("Otros Fondos (especifique)");
                        break;
                    case 'P':
                        otactaux.setNomAuspicio("Cuenta Propia");
                        break;
                }
            }
            if(otactaux.getNum1Actividad() != null){
                switch(otactaux.getNum1Actividad()){
                    case 1:
                        otactaux.setDesLinEstrategica("INVESTIGACIÓN");
                        break;
                    case 2:
                        otactaux.setDesLinEstrategica("VINCULACIÓN");
                        break;
                }
            }
            if(otactaux.getNum2Actividad() != null){
                switch(otactaux.getNum2Actividad()){
                    case 1:
                        otactaux.setDesTipo("Proyecto");
                        break;
                    case 2:
                        otactaux.setDesTipo("Consultoría");
                        break;
                }
            }
            if(otactaux.getTipo3Actividad() != null){
                switch(otactaux.getTipo3Actividad()){
                    case '1':
                        otactaux.setDesInforme("Aprobado");
                        break;
                    case '2':
                        otactaux.setDesInforme("En Proceso");
                        break;
                    case '3':
                        otactaux.setDesInforme("Avance Aceptado");
                        break;
                    case '4':
                        otactaux.setDesInforme("Final");
                        break;
                }
            }
            listproyInter.add(i, otactaux);
        }
    }

    public List<OtraActividadAcademica> getListproyInter() {

        return listproyInter;
    }

    public void setListproyInter(List<OtraActividadAcademica> listproyInter) {
        this.listproyInter = listproyInter;
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="SELECCION DE FILA PARA EDICION">    
    private OtraActividadAcademica selectedProyInter;

    public OtraActividadAcademica getSelectedProyInter() {
        return selectedProyInter;
    }

    public void setSelectedProyInter(OtraActividadAcademica selectedProyInter) {
        this.selectedProyInter = selectedProyInter;
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">  
    public void SaveProyInter() {
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        OtraActividadAcademica proyinteraux = new OtraActividadAcademica();
        if (proyinter != null) {
            if (proyinter.getOtraActividadAcademicaPK() != null) {
                proyinteraux = otraactividadFacade.find(proyinter.getOtraActividadAcademicaPK());
            }
        }
        try {
            proyinter.setFacultad(smproyinterfacultad.getValue() == null ? null : facultadFacade.find(Long.parseLong(smproyinterfacultad.getValue().toString())));
            proyinter.setDuracionActividad(smproyinterroldoc.getValue() == null ? null : Integer.parseInt(smproyinterroldoc.getValue().toString()));
            proyinter.setNum1Actividad(smproyinterlinestra.getValue() == null ? null : Integer.parseInt(smproyinterlinestra.getValue().toString()));
            proyinter.setNombreActividad(itxtproyinternomproyecto.getValue() == null ? null : itxtproyinternomproyecto.getValue().toString().toUpperCase());
            proyinter.setNum2Actividad(smproyintertipo.getValue() == null ? null : Integer.parseInt(smproyintertipo.getValue().toString()));
            proyinter.setTipo2Actividad(smproyinterestproy.getValue() == null ? null : smproyinterestproy.getValue().toString().charAt(0));
            proyinter.setSedeInstActividad(smproyinterauspicio.getValue() == null ? null : smproyinterauspicio.getValue().toString().charAt(0));
            proyinter.setTituloActividad(itxtproyinternominstitucion.getValue() == null ? null : itxtproyinternominstitucion.getValue().toString().toUpperCase());
            proyinter.setInstitucionActividad(itxtproyinternomauspicio.getValue() == null ? null : itxtproyinternomauspicio.getValue().toString().toUpperCase());
            proyinter.setPaisInvest(smproyinterpais.getValue() == null ? null : smproyinterpais.getValue().toString());
            proyinter.setCiudadInvest(smproyinterciudad.getValue() == null ? null : Long.parseLong(smproyinterciudad.getValue().toString()));
            proyinter.setFinicioActividad(new java.sql.Date(feciniproyinter.getTime()));
            proyinter.setFfinActividad(fecfinproyinter == null ? null : new java.sql.Date(fecfinproyinter.getTime()));
            proyinter.setTipo3Actividad(smproyinterinforme.getValue() == null ? null :smproyinterinforme.getValue().toString().charAt(0));
            proyinter.setAlcanceActividad(smalcanceinter.getValue() == null ? null : Long.parseLong(smalcanceinter.getValue().toString()));
            if (proyinteraux.getOtraActividadAcademicaPK() == null) {
                OtraActividadAcademicaPK proyinterpk = new OtraActividadAcademicaPK();
                proyinterpk.setCodigoProfesor(codProfesor);
                proyinterpk.setTipoOtraActividad('I');
                proyinter.setOtraActividadAcademicaPK(proyinterpk);
                proyinter.setFechaCrea(new Date());
                proyinter.setUsuarioCrea("Internet");
                proyinter.setFechaUltmodific(new Date());
                proyinter.setUsuarioUltmodific("Internet");
                otraactividadFacade.create(proyinter);
            } else {
                proyinter.setFechaUltmodific(new Date());
                proyinter.setUsuarioUltmodific("Internet");
                otraactividadFacade.edit(proyinter);
            }
            //Recuepro los datos de los titulos            
            FacesMessage msg = new FacesMessage("Investigación Interinstitucional Guardada");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            recuperaProyectInter(codProfesor, anio);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al Guardar Investigación Interinstitucional");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

        } finally {
            proyinter = new OtraActividadAcademica();
            CancelProyInter();
        }


    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">  

    public void paisProyIntervalueChangeListener() {
        if (smproyinterpais.getValue() != null) {
            listCiudadtit = ciudadFacade.finbyPais((String) smproyinterpais.getValue());
        }
    }

    public void EditProyInter() {
        if (selectedProyInter != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            proyinter = selectedProyInter;
            smproyinterroldoc.setValue(proyinter.getDuracionActividad());
            smproyinterlinestra.setValue(proyinter.getNum1Actividad());
            itxtproyinternomproyecto.setValue(proyinter.getNombreActividad().toString());
            smproyintertipo.setValue(proyinter.getNum2Actividad());
            smproyinterestproy.setValue(proyinter.getTipo2Actividad());
            smproyinterauspicio.setValue(proyinter.getSedeInstActividad());
            smproyinterinforme.setValue(proyinter.getTipo3Actividad());
            itxtproyinternominstitucion.setValue(proyinter.getTituloActividad());
            itxtproyinternomauspicio.setValue(proyinter.getInstitucionActividad());
            smproyinterpais.setValue(proyinter.getPaisInvest());
            paisProyIntervalueChangeListener();
            smproyinterciudad.setValue(proyinter.getCiudadInvest());
            smproyinterfacultad.setValue(proyinter.getFacultad());
            feciniproyinter = new java.sql.Date(proyinter.getFinicioActividad().getTime());
            fecfinproyinter = (proyinter.getFfinActividad() == null ? null : new java.sql.Date(proyinter.getFfinActividad().getTime()));
            smalcanceinter.setValue(proyinter.getAlcanceActividad());
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Proyecto Interinstitucional a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">  

    public void DeleteProyInter() {

        if (selectedProyInter != null) {
            try {
                OtraActividadAcademica proyinteraux = new OtraActividadAcademica();
                proyinteraux = otraactividadFacade.find(selectedProyInter.getOtraActividadAcademicaPK());
                otraactividadFacade.remove(proyinteraux);
                proyinter = new OtraActividadAcademica();
                //Recupero las asignaturas externas
                recuperaProyectInter(codProfesor, anio);
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infoinvestigacion:gproyinter");
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de: Proyecto Interinstitucional", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);


            } finally {
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar un Proyecto Interinstitucional a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");

        }

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">  

    public void CancelProyInter() {
        selectedProyInter = new OtraActividadAcademica();
        proyinter = new OtraActividadAcademica();
        smproyinterroldoc.setValue(null);
        smproyinterlinestra.setValue(null);
        itxtproyinternomproyecto.setValue(null);
        smproyintertipo.setValue(null);
        smproyinterestproy.setValue(null);
        smproyinterauspicio.setValue(null);
        smproyinterfacultad.setValue(null);
        itxtproyinternominstitucion.setValue(null);
        itxtproyinternomauspicio.setValue(null);
        smproyinterpais.setValue(null);
        smproyinterciudad.setValue(null);
        feciniproyinter = null;
        fecfinproyinter = null;
        smalcanceinter.setValue(null);
    }
    // </editor-fold> 
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="PUBLICACIONES"> 
    // <editor-fold defaultstate="collapsed" desc="VALUECHANGELISTENER"> 

    public void paisPublicvalueChangeListener() {
        if (smpaispub.getValue() != null) {
            listCiudadtit = ciudadFacade.finbyPais((String) smpaispub.getValue());
        }
    }

    public void auspPublicvalueChangeListener() {
        if (smausppub.getValue() != null) {
            if (smausppub.getValue().toString().equalsIgnoreCase("O")) {
                bhabdetotausp = true;
            } else {
                bhabdetotausp = false;
                itxtdetotroausp.setValue(null);
            }
        } else {
            bhabdetotausp = false;
            itxtdetotroausp.setValue(null);
        }
    }
    
    public void baseIndexacionValueChangeListener(){
        if(smdbtipvarios.getValue() != null){
            if(smdbtipvarios.getValue().toString().equalsIgnoreCase("3")){
                bbaseindex = true;
            }else{
                bbaseindex = false;
                itxtbaseindex.setValue(null);
            }
        }else{
            bbaseindex = false;
            itxtbaseindex.setValue(null);
        }
    }

    public void tipPublicvalueChangeListener() {
        listtippart.clear();
        listrol.clear();
        itxtdbapellautor.setValue(null);
        itxtdbnombreautor.setValue(null);
        bhabdbdatautor = false;
        bhabdbtitcap = true;
        bhabdbtitrev = true;
        etcod = "N° ISBN:";
        if (smtippublicacion.getValue() != null) {
            if (smtippublicacion.getValue().toString().equalsIgnoreCase("1")) {
                bhabdbdatautor = true;
            }
            if (smtippublicacion.getValue().toString().equalsIgnoreCase("4") || smtippublicacion.getValue().toString().equalsIgnoreCase("5") || smtippublicacion.getValue().toString().equalsIgnoreCase("6")) {
                bhabdbtitcap = false;
            }
            if (smtippublicacion.getValue().toString().equalsIgnoreCase("5") || smtippublicacion.getValue().toString().equalsIgnoreCase("6")) {
                bhabdbtitrev = false;
            }
            if (!smtippublicacion.getValue().toString().equalsIgnoreCase("5") && !smtippublicacion.getValue().toString().equalsIgnoreCase("6")) {
                etcod = "N° ISBN:";
            } else {
                etcod = "N° ISSN:";
            }

            /*if (smtippublicacion.getValue().toString().equalsIgnoreCase("2")) {
                listtippart.put("Editor", "E");
                listtippart.put("Coordinador", "D");
                listtippart.put("Traductor", "T");
                listtippart.put("Compilador", "M");
            } else {
                if (smtippublicacion.getValue().toString().equalsIgnoreCase("11")) {
                    listtippart.put("Autor", "A");
                } else {
                    if (smtippublicacion.getValue().toString().equalsIgnoreCase("4")) {
                        listtippart.put("Autor Capítulo", "A");
                        listtippart.put("Coautor Capítulo", "C");

                    } else {
                        listtippart.put("Autor", "A");
                        listtippart.put("Coautor", "C");
                    }
                }

            }*/
            //Cargo las etiquetas para los titulos

            switch (Integer.parseInt(smtippublicacion.getValue().toString())) {
                case 1:
                case 2:
                case 3:
                    stettitulo = "Título ";
                    break;
                case 4:
                    stettitulo = "Título del Libro";
                    break;
                case 5:
                case 6:
                    stettitulo = "Título Revista ";
                    break;
                case 11:
                    stettitulo = "Título Ponencia ";
                    break;
                case 13:
                    labelTipoPub = "Tipo de Libro*";
                    labelAnioPub = "Año de Públicación*";
                    labelTitulo = "Título*";
                    labelPagina = "Número de Páginas*";
                    labelFecha = "Fecha de Edición*";
                    etcod = "Número ISBN";
                    btitcapitulo = true;
                    beditorial = true;
                    bpagina = true;
                    bcodigo = true;
                    bauspicio = true;
                    bpublicacion = true;
                    bserie = true;
                    bpares = true;
                    bnombrerev = false;
                    bparesrev = false;
                    bnombeve = false;
                    bduracion = false;
                    isRevista = false;
                    bbaseindex = false;
                    bAlcanceAnio = true;
                    bAnioVisualizacion = false;
                    //Lista de tipo de libro
                    listtippart.put("Individual", "I");
                    listtippart.put("Coautoria", "C");
                    listtippart.put("Capítulo en Libro Colectivo", "P");
                    //Lista de rol
                    listrol.put("Autor", "1");
                    listrol.put("Coautor", "2");
                    listrol.put("Editor", "3");
                    listrol.put("Compilador", "4");
                    listrol.put("Revisor", "5");
                    listrol.put("Coordinador de Informe Periódico", "6");
                    break;
                case 14:
                    labelTipoPub = "Tipo de Artículo*";
                    labelAnioPub = "Año de Publicación*";
                    labelTitulo = "Título del Artículo*";
                    labelPagina = "Número de Páginas (Rango)*";
                    labelFecha = "Fecha de Edición*";
                    etcod = "Número ISSN";
                    btitcapitulo = false;
                    beditorial = true;
                    bpagina = true;
                    bcodigo = true;
                    bauspicio = false;
                    bhabdetotausp = false;
                    bpublicacion = true;
                    bserie = false;
                    bpares = false;
                    bnombrerev = true;
                    bparesrev = true;
                    bnombeve = false;
                    bduracion = false;
                    isRevista = true;
                    bbaseindex = false;
                    bAlcanceAnio = true;
                    bAnioVisualizacion = false;
                    //Lista de tipo de revistas
                    listtippart.put("Artículo Académico", "A");
                    listtippart.put("Artículo no Académico", "N");
                    listtippart.put("Reseña", "R");
                    //Lista de rol
                    listrol.put("Autor", "1");
                    listrol.put("Coautor", "2");
                    listrol.put("Revisor", "3");
                    listrol.put("Editor", "4");
                    listrol.put("Director", "5");
                    listrol.put("Coordinador Número Monográfico", "6");
                    break;
                case 15:
                    labelTipoPub = "Tipo de Ponencia*";
                    labelAnioPub = "Año de Presentación*";
                    labelTitulo = "Título Ponencia*";
                    labelPagina = "Número de Páginas";
                    labelFecha = "Fecha de Actividad*";
                    btitcapitulo = false;
                    beditorial =false;
                    bpagina = true;
                    bcodigo = false;
                    bauspicio = false;
                    bhabdetotausp = false;
                    bpublicacion = false;
                    bserie = false;
                    bpares = false;
                    bnombrerev = false;
                    bparesrev = false;
                    bnombeve = true;
                    bduracion = false;
                    isRevista = false;
                    bbaseindex = false;
                    bAlcanceAnio = true;
                    bAnioVisualizacion = false;
                    //Lista de tipo de ponencias
                    listtippart.put("Publicada", "P");
                    listtippart.put("No Publicada", "N");
                    //Lista de rol
                    listrol.put("Autor", "1");
                    listrol.put("Coautor", "2");
                    break;
                case 16:
                    labelTipoPub = "Tipo de Audiovisual*";
                    labelAnioPub = "Año de Presentación*";
                    labelTitulo = "Título del Producto*";
                    labelFecha = "Fecha de Presentación*";
                    btitcapitulo = false;
                    beditorial =false;
                    bpagina = false;
                    bcodigo = false;
                    bauspicio = false;
                    bhabdetotausp = false;
                    bpublicacion = false;
                    bserie = false;
                    bpares = false;
                    bnombrerev = false;
                    bparesrev = false;
                    bnombeve = false;
                    bduracion = true;
                    isRevista = false;
                    bbaseindex = false;
                    bAlcanceAnio = false;
                    bAnioVisualizacion = true;
                    //Lista de tipo de productos audiovisuales
                    listtippart.put("Película", "P");
                    listtippart.put("Documental", "D");
                    listtippart.put("Reportaje", "R");
                    listtippart.put("Libros Fotográficos", "L");
                    listtippart.put("Pieza de Radio", "Z");
                    listtippart.put("Sonoro", "S");
                    listtippart.put("Otro (Especifíque)", "O");
                    //Lista de rol
                    listrol.put("Autor", "1");
                    listrol.put("Coautor", "2");
                    break;
                default:
                    stettitulo = "Título ";
                    break;
            }
        }
    }

    public void formPublicvalueChangeListener() {
        bhabdburl = true;
        if (smformpub.getValue() != null) {
            if (smformpub.getValue().toString().equalsIgnoreCase("D")) {
                bhabdburl = false;
            }
        }
    }

    public void basePublicvalueChangeListener() {
        bhabdnombase = true;
        if (smdbbaserev.getValue() != null) {
            if (smdbbaserev.getValue().toString().equalsIgnoreCase("O")) {
                bhabdnombase = false;
            }
        }
    }
    
    public void detalleTipoPubValueChangeListener(){
        if(smtippublicacion.getValue() != null && smtipparticipacion.getValue() != null){    
            if(Integer.parseInt(smtippublicacion.getValue().toString()) == 16 && smtipparticipacion.getValue().toString().equalsIgnoreCase("O")){
                bDetalleTipPub = true;
            }else{
                bDetalleTipPub = false;
                itxtdbdetalletipopub.setValue(null);
            }
        }else{
            bDetalleTipPub = false;
            itxtdbdetalletipopub.setValue(null);
        }
    }
    
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA PUBLICACIONES"> 

    private void recuperaPublicacion(Long codProfesor, Long anio) {
        PublicacionProfesor pubaux = new PublicacionProfesor();
        Pais paisaxu = new Pais();
        Ciudad ciuaux = new Ciudad();
        List<PublicacionProfesor> listpubaux = new ArrayList<PublicacionProfesor>();
        listpublicacion.clear();
        listpubaux.clear();
        int minYear = anio.intValue() - 3;
        listpubaux = publicacionFacade.findPublicProfesor(codProfesor);
        int cont = 0;
        for (int i = 0; i < listpubaux.size(); i++) {
            pubaux = listpubaux.get(i);
            if (pubaux.getPaisAuspicio() != null) {
                paisaxu = paisFacade.finbyCodigo(pubaux.getPaisAuspicio());
                if (paisaxu != null) {
                    pubaux.setNomPais(paisaxu.getNomPais());
                    if (pubaux.getCiudadAuspicio() != null) {
                        if (pubaux.getCiudadAuspicio() != 0) {
                            ciuaux = ciudadFacade.finbyCodigo(pubaux.getPaisAuspicio(), pubaux.getCiudadAuspicio());
                            if (ciuaux != null) {
                                pubaux.setNomCiudad(ciuaux.getNomCiudad());
                            }
                        }

                    }
                }

            }
            if(pubaux.getCampo10() != null){
                if(Integer.parseInt(pubaux.getCampo10()) >= minYear){
                    listpublicacion.add(cont, pubaux);
                    cont++;
                }
            }
        }
    }

    private void recuperaPublicacionFormAnterior(Long codProfesor) {
        PublicacionProfesor pubaux = new PublicacionProfesor();
        Pais paisaxu = new Pais();
        Ciudad ciuaux = new Ciudad();
        List<PublicacionProfesor> listpubaux = new ArrayList<PublicacionProfesor>();
        listpublicacionformante.clear();
        listpubaux.clear();
        listpubaux = publicacionFacade.findPublicProfFormAnterior(codProfesor);
        for (int i = 0; i < listpubaux.size(); i++) {
            pubaux = listpubaux.get(i);
            if (pubaux.getPaisAuspicio() != null) {
                paisaxu = paisFacade.finbyCodigo(pubaux.getPaisAuspicio());
                if (paisaxu != null) {
                    pubaux.setNomPais(paisaxu.getNomPais());
                    if (pubaux.getCiudadAuspicio() != null) {
                        if (pubaux.getCiudadAuspicio() != 0) {
                            ciuaux = ciudadFacade.finbyCodigo(pubaux.getPaisAuspicio(), pubaux.getCiudadAuspicio());
                            if (ciuaux != null) {
                                pubaux.setNomCiudad(ciuaux.getNomCiudad());
                            }
                        }

                    }
                }

            }
            listpublicacionformante.add(i, pubaux);
        }
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="SELECCION DE FILA PARA EDICION">    
    private PublicacionProfesor selectedPublicacion;

    public PublicacionProfesor getSelectedPublicacion() {
        return selectedPublicacion;
    }

    public void setSelectedPublicacion(PublicacionProfesor selectedPublicacion) {
        this.selectedPublicacion = selectedPublicacion;
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">  
    public void SavePublicacion() {
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        PublicacionProfesor pubprofaux = new PublicacionProfesor();
        if (publicacionprofesor != null) {
            if (publicacionprofesor.getPublicacionProfesorPK() != null) {
                pubprofaux = publicacionFacade.find(publicacionprofesor.getPublicacionProfesorPK());
            }
        }
        try {
            //DATOS GENERALES PUBLICACION
            publicacionprofesor.setTipoPublicacion(smtippublicacion.getValue() == null ? null : Long.parseLong(smtippublicacion.getValue().toString()));
            publicacionprofesor.setPubParticipacion(smtipparticipacion.getValue() == null ? null : smtipparticipacion.getValue().toString().charAt(0));
//            publicacionprofesor.setPubRol(smrol.getValue() == null ? null : Long.parseLong(smrol.getValue().toString()));
            publicacionprofesor.setCampo10(sanioedicion == null ? null : sanioedicion);
            publicacionprofesor.setPaisAuspicio(smpaispub.getValue() == null ? null : smpaispub.getValue().toString());
            publicacionprofesor.setCiudadAuspicio(smciudadpub.getValue() == null ? null : Long.parseLong(smciudadpub.getValue().toString()));
            publicacionprofesor.setPubUrl(itxtdburl.getValue() == null ? null : itxtdburl.getValue().toString());
            //DATOS BIBLIOGRAFICOS
            publicacionprofesor.setPubApellidoAutor(itxtdbapellautor.getValue() == null ? null : itxtdbapellautor.getValue().toString());
            publicacionprofesor.setPubNombreAutor(itxtdbnombreautor.getValue() == null ? null : itxtdbnombreautor.getValue().toString());
            publicacionprofesor.setPubTitulo(itxtdbtitulo.getValue() == null ? null : itxtdbtitulo.getValue().toString());
            publicacionprofesor.setPubNombreCapitulo(itxtdbtitulocapi.getValue() == null ? null : itxtdbtitulocapi.getValue().toString());
            publicacionprofesor.setPubEditorial(itxtdbeditorial.getValue() == null ? null : itxtdbeditorial.getValue().toString());
            publicacionprofesor.setPubNumpaginas(itxtdbnumpag.getValue() == null ? null : itxtdbnumpag.getValue().toString());
            publicacionprofesor.setPubFecedicion(dbfecedicion == null ? null : dbfecedicion);
            if(isRevista){
                publicacionprofesor.setPubNumissn(itxtdbnumcod.getValue() == null ? null : itxtdbnumcod.getValue().toString());
            }else{
                publicacionprofesor.setPubNumisbn(itxtdbnumcod.getValue() == null ? null : itxtdbnumcod.getValue().toString());
            }
            publicacionprofesor.setAuspicioPublicacion(smausppub.getValue() == null ? ' ' : smausppub.getValue().toString().charAt(0));
            publicacionprofesor.setFormaPublicacion(smformpub.getValue() == null ? ' ' : smformpub.getValue().toString().charAt(0));
            publicacionprofesor.setPubPartserie(sompartserie == null ? null : sompartserie.charAt(0));
            publicacionprofesor.setPubTitserie(itxtdtitserie.getValue() == null ? null : itxtdtitserie.getValue().toString());
            publicacionprofesor.setPubRevpares(smdbrevpar.getValue() == null ? null : smdbrevpar.getValue().toString().charAt(0));
//            publicacionprofesor.setPubTipoEdicion(smdbedicion.getValue() == null ? null : Long.parseLong(smdbedicion.getValue().toString()));
//            publicacionprofesor.setPubTiposVarios(smdbtipvarios.getValue() == null ? null : Long.parseLong(smdbtipvarios.getValue().toString()));
            //REVISTAS
            publicacionprofesor.setCampo8(itxtdbnomrev.getValue() == null ? null : itxtdbnomrev.getValue().toString());
            publicacionprofesor.setCampo7(itxtdbdesedicion.getValue() == null ? null : itxtdbdesedicion.getValue().toString());
            publicacionprofesor.setCampo6(itxtbaseindex.getValue() == null ? null : itxtbaseindex.getValue().toString());
            //PONENCIAS
            publicacionprofesor.setCampo5(itxtdbnomeve.getValue() == null ? null : itxtdbnomeve.getValue().toString());
            publicacionprofesor.setPubEntidadsede(itxtdbentidadsede.getValue() == null ? null : itxtdbentidadsede.getValue().toString());
//            publicacionprofesor.setPubAlcance(smalcact.getValue() == null ? null : Long.parseLong(smalcact.getValue().toString()));
            publicacionprofesor.setPubMeddifusion(smmeddif.getValue() == null ? null : smmeddif.getValue().toString().charAt(0));
            publicacionprofesor.setPubEvento(smevento.getValue() == null ? null : smevento.getValue().toString().charAt(0));
            //PRODUCTOS AUDIOVISUALES
//            publicacionprofesor.setPubDuracion(smduracion.getValue() == null ? null : Long.parseLong(smduracion.getValue().toString()));
            publicacionprofesor.setCampo4(itxtdbdetalletipopub.getValue() == null ? null : itxtdbdetalletipopub.getValue().toString());
//            publicacionprofesor.setPubAnioVisualizacion(saniovisualizacion == null ? null : Long.parseLong(saniovisualizacion));
            //OTROS
            publicacionprofesor.setPubIdioma(smidiomapub.getValue() == null ? null : Integer.valueOf(smidiomapub.getValue().toString()));
            publicacionprofesor.setOtroAuspicio(itxtdetotroausp.getValue() == null ? null : itxtdetotroausp.getValue().toString());
            publicacionprofesor.setPubApellidoCoautor(itxtdbapellcoautor.getValue() == null ? null : itxtdbapellcoautor.getValue().toString());
            publicacionprofesor.setPubNombreCoautor(itxtdbnombrecoautor.getValue() == null ? null : itxtdbnombrecoautor.getValue().toString());
            publicacionprofesor.setPubSubtitulo(itxtdbsubtitulo.getValue() == null ? null : itxtdbsubtitulo.getValue().toString());
            publicacionprofesor.setPubEdicion(itxtdbedicion.getValue() == null ? null : itxtdbedicion.getValue().toString());
            publicacionprofesor.setPubEstado(smdbestado.getValue() == null ? null : smdbestado.getValue().toString().charAt(0));
            publicacionprofesor.setPubTitrevista(itxtdbtitrevista.getValue() == null ? null : itxtdbtitrevista.getValue().toString());
            publicacionprofesor.setPubVolumen(itxtdbvolumen.getValue() == null ? null : Integer.valueOf(itxtdbvolumen.getValue().toString()));
            publicacionprofesor.setPubBaserevindexada(smdbbaserev.getValue() == null ? null : smdbbaserev.getValue().toString().charAt(0));
            publicacionprofesor.setPubNomotrabaseindex(itxtdnombase.getValue() == null ? null : itxtdnombase.getValue().toString());
            if (pubprofaux.getPublicacionProfesorPK() == null) {
                PublicacionProfesorPK pubprofpk = new PublicacionProfesorPK();
                pubprofpk.setCodigoProfesor(codProfesor);
                publicacionprofesor.setPublicacionProfesorPK(pubprofpk);
                publicacionprofesor.setFechaCrea(new Date());
                publicacionprofesor.setUsuarioCrea("Internet");
                publicacionprofesor.setFechaUltmodific(new Date());
                publicacionprofesor.setUsuarioUltmodific("Internet");
                publicacionFacade.create(publicacionprofesor);
            } else {

                publicacionprofesor.setFechaUltmodific(new Date());
                publicacionprofesor.setUsuarioUltmodific("Internet");
                publicacionFacade.edit(publicacionprofesor);
            }
            //Recuepro los datos de los titulos            
            FacesMessage msg = new FacesMessage("Publicación Guardada");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            recuperaPublicacion(codProfesor, anio);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al Guardar la Publicación");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        } finally {
            publicacionprofesor = new PublicacionProfesor();
            CancelPub();
        }
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">  

    public void CancelPub() {
        publicacionprofesor = new PublicacionProfesor();
        selectedPublicacion = new PublicacionProfesor();
        smtippublicacion.setValue(null);
        smtipparticipacion.setValue(null);
        smpaispub.setValue(null);
        smciudadpub.setValue(null);
        smformpub.setValue(null);
        smidiomapub.setValue(null);
        smausppub.setValue(null);
        itxtdetotroausp.resetValue();        
        itxtdbapellautor.setValue(null);
        itxtdbnombreautor.setValue(null);
        itxtdbapellcoautor.setValue(null);
        itxtdbnombrecoautor.setValue(null);
        itxtdbtitulo.setValue(null);
        itxtdbsubtitulo.setValue(null);
        itxtdbtitulocapi.setValue(null);
        itxtdbedicion.setValue(null);
        itxtdbeditorial.setValue(null);
        sanioedicion=null;
        dbfecedicion = null;
        smdbestado.setValue(null);
        itxtdbnumpag.setValue(null);
        itxtdbtitrevista.setValue(null);
        itxtdbvolumen.setValue(null);
        etcod = "N° ISBN:";
        itxtdburl.setValue(null);
        smdbrevpar.setValue(null);
        smdbbaserev.setValue(null);
        itxtdnombase.setValue(null);
        sompartserie=null;
        itxtdtitserie.setValue(null);
        itxtdbentidadsede.resetValue();
        smmeddif.setValue(null);
        smevento.setValue(null); 
        itxtdbnumcod.setValue(null);
        bhabdetotausp = false;
        bhabdbdatautor = false;
        bhabdbtitcap = false;
        bhabdbtitrev = false;     
        bhabdburl = true;
        bhabdnombase = true;
        smrol.setValue(null);
        smdbedicion.setValue(null);
        smdbtipvarios.setValue(null);
        itxtdbnomrev.setValue(null);
        itxtdbdesedicion.setValue(null);
        itxtbaseindex.setValue(null);
        itxtdbnomeve.setValue(null);
        smalcact.setValue(null);
        smduracion.setValue(null);
        itxtdbdetalletipopub.setValue(null);
        btitcapitulo = false;
        beditorial = false;
        bpagina = false;
        bcodigo = false;
        bauspicio = false;
        bpublicacion = false;
        bserie = false;
        bpares = false;
        bnombrerev = false;
        bparesrev = false;
        bbaseindex = false;
        bnombeve = false;
        bduracion = false;
        bAlcanceAnio = false;
        bAnioVisualizacion = false;
        saniovisualizacion = null;
        indiceTab = 0;
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">  

    public void DeletePub() {

        if (selectedPublicacion != null) {
            try {
                PublicacionProfesor pubpro = new PublicacionProfesor();
                pubpro = publicacionFacade.find(selectedPublicacion.getPublicacionProfesorPK());
                publicacionFacade.remove(pubpro);
                listpublicacion.remove(selectedPublicacion);
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infoinvestigacion:gdetpub");
                recuperaPublicacion(codProfesor, anio);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage("Error al Eliminar La Publicacion");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Publicación a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">  

    public void EditPub() {

        if (selectedPublicacion != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            publicacionprofesor = selectedPublicacion;
            smtippublicacion.setValue(publicacionprofesor.getTipoPublicacion() == 0 ? null : publicacionprofesor.getTipoPublicacion());
            tipPublicvalueChangeListener();
            smtipparticipacion.setValue(publicacionprofesor.getPubParticipacion() == null ? null : publicacionprofesor.getPubParticipacion());
//            smrol.setValue(publicacionprofesor.getPubRol() == null ? null : publicacionprofesor.getPubRol());
            sanioedicion = (publicacionprofesor.getCampo10() == null ? null : publicacionprofesor.getCampo10());
            smpaispub.setValue(publicacionprofesor.getPaisAuspicio() == null ? null : publicacionprofesor.getPaisAuspicio());
            paisPublicvalueChangeListener();
            smciudadpub.setValue(publicacionprofesor.getCiudadAuspicio() == null ? null : publicacionprofesor.getCiudadAuspicio());
            smformpub.setValue(publicacionprofesor.getFormaPublicacion());
            smidiomapub.setValue(publicacionprofesor.getPubIdioma() == null ? null : publicacionprofesor.getPubIdioma());
            smausppub.setValue(publicacionprofesor.getAuspicioPublicacion());
            auspPublicvalueChangeListener();
            itxtdetotroausp.setValue(publicacionprofesor.getOtroAuspicio() == null ? null : publicacionprofesor.getOtroAuspicio());
            itxtdbapellautor.setValue(publicacionprofesor.getPubApellidoAutor() == null ? null : publicacionprofesor.getPubApellidoAutor());
            itxtdbnombreautor.setValue(publicacionprofesor.getPubNombreAutor() == null ? null : publicacionprofesor.getPubNombreAutor());
            itxtdbapellcoautor.setValue(publicacionprofesor.getPubApellidoCoautor() == null ? null : publicacionprofesor.getPubApellidoCoautor());
            itxtdbnombrecoautor.setValue(publicacionprofesor.getPubNombreCoautor() == null ? null : publicacionprofesor.getPubNombreCoautor());
            itxtdbtitulo.setValue(publicacionprofesor.getPubTitulo() == null ? null : publicacionprofesor.getPubTitulo());
            itxtdbsubtitulo.setValue(publicacionprofesor.getPubSubtitulo() == null ? null : publicacionprofesor.getPubSubtitulo());
            itxtdbtitulocapi.setValue(publicacionprofesor.getPubNombreCapitulo() == null ? null : publicacionprofesor.getPubNombreCapitulo());
            itxtdbedicion.setValue(publicacionprofesor.getPubEdicion() == null ? null : publicacionprofesor.getPubEdicion());
            itxtdbeditorial.setValue(publicacionprofesor.getPubEditorial() == null ? null : publicacionprofesor.getPubEditorial());
            itxtdbnumpag.setValue(publicacionprofesor.getPubNumpaginas() == null ? null : publicacionprofesor.getPubNumpaginas());
            dbfecedicion = (publicacionprofesor.getPubFecedicion() == null ? null : new java.sql.Date(publicacionprofesor.getPubFecedicion().getTime()));            
            /*if (smtippublicacion.getValue().toString().equalsIgnoreCase("1")
                    || smtippublicacion.getValue().toString().equalsIgnoreCase("2")
                    || smtippublicacion.getValue().toString().equalsIgnoreCase("3")
                    || smtippublicacion.getValue().toString().equalsIgnoreCase("4")) {
                sanioedicion = (dbfecedicion == null ? null : formato.format(dbfecedicion).substring(6));
            }*/
            smdbestado.setValue(publicacionprofesor.getPubEstado() == null ? null : publicacionprofesor.getPubEstado());
            itxtdbtitrevista.setValue(publicacionprofesor.getPubTitrevista() == null ? null : publicacionprofesor.getPubTitrevista());
            itxtdbvolumen.setValue(publicacionprofesor.getPubVolumen() == null ? null : publicacionprofesor.getPubVolumen());
            etcod = (publicacionprofesor.getPubNumisbn() == null ? "N° ISSN:" : "N° ISBN:");
            if(smtippublicacion.getValue() != null){
                if(smtippublicacion.getValue().toString().equalsIgnoreCase("14")){
                    itxtdbnumcod.setValue(publicacionprofesor.getPubNumissn()== null ? publicacionprofesor.getPubNumissn() : publicacionprofesor.getPubNumissn());
                }else{
                    itxtdbnumcod.setValue(publicacionprofesor.getPubNumisbn()== null ? publicacionprofesor.getPubNumisbn() : publicacionprofesor.getPubNumisbn());
                }
            }
            itxtdburl.setValue(publicacionprofesor.getPubUrl() == null ? null : publicacionprofesor.getPubUrl());
            smdbrevpar.setValue(publicacionprofesor.getPubRevpares() == null ? null : publicacionprofesor.getPubRevpares());
            smdbbaserev.setValue(publicacionprofesor.getPubBaserevindexada() == null ? null : publicacionprofesor.getPubBaserevindexada());
            basePublicvalueChangeListener();
            itxtdnombase.setValue(publicacionprofesor.getPubNomotrabaseindex() == null ? null : publicacionprofesor.getPubNomotrabaseindex());
            sompartserie = (publicacionprofesor.getPubPartserie() == null ? null : publicacionprofesor.getPubPartserie().toString());
            itxtdtitserie.setValue(publicacionprofesor.getPubTitserie() == null ? null : publicacionprofesor.getPubTitserie());
            itxtdbentidadsede.setValue(publicacionprofesor.getPubEntidadsede() == null ? null : publicacionprofesor.getPubEntidadsede());
            smevento.setValue(publicacionprofesor.getPubEvento() == null ? null : publicacionprofesor.getPubEvento());
            smmeddif.setValue(publicacionprofesor.getPubMeddifusion() == null ? null : publicacionprofesor.getPubMeddifusion());
//            smdbedicion.setValue(publicacionprofesor.getPubTipoEdicion() == null ? null: publicacionprofesor.getPubTipoEdicion());
//            smdbtipvarios.setValue(publicacionprofesor.getPubTiposVarios() == null ? null : publicacionprofesor.getPubTiposVarios());
            itxtdbnomrev.setValue(publicacionprofesor.getCampo8() == null ? null : publicacionprofesor.getCampo8());
            itxtdbdesedicion.setValue(publicacionprofesor.getCampo7() == null ? null : publicacionprofesor.getCampo7());
            itxtbaseindex.setValue(publicacionprofesor.getCampo6() == null ? null : publicacionprofesor.getCampo6());
            baseIndexacionValueChangeListener();
            itxtdbnomeve.setValue(publicacionprofesor.getCampo5() == null ? null : publicacionprofesor.getCampo5());
//            smalcact.setValue(publicacionprofesor.getPubAlcance() == null ? null : publicacionprofesor.getPubAlcance());
//            smduracion.setValue(publicacionprofesor.getPubDuracion() == null ? null : publicacionprofesor.getPubDuracion());
            detalleTipoPubValueChangeListener();
            itxtdbdetalletipopub.setValue(publicacionprofesor.getCampo4() == null ? null : publicacionprofesor.getCampo4());
//            saniovisualizacion = (publicacionprofesor.getPubAnioVisualizacion() == null ? null : publicacionprofesor.getPubAnioVisualizacion().toString());
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una publicación a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    // </editor-fold> 
    // </editor-fold> 

    public void eliminarRegistro(ActionEvent ae) {
        switch (modal1.getActiveIndexAcoordion()) {
            case 1:
                switch (modal1.getActiveIndexTabviewinvestigacion()) {
                    case 1:
                        DeleteProyInter();
                        break;
                    case 2:
                        DeletePub();
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
            case 1:
                switch (modal1.getActiveIndexTabviewinvestigacion()) {
                    case 1:
                        modal1.setUrlmodal("/pages/infoanual/investigacion/investInterinstitucionalModal.xhtml");
                        break;
                    case 2:
                        modal1.setUrlmodal("/pages/infoanual/investigacion/publicacionModal.xhtml");
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
        if (modal1.getActiveIndexAcoordion() == 1) {
            switch (modal1.getActiveIndexTabviewinvestigacion()) {
                case 1:
                    EditProyInter();
                    break;
                case 2:
                    EditPub();
                    break;
                default:
                    break;
            }
        }
    }

    public void onRowSelect(SelectEvent event) {
        if (modal1.getActiveIndexAcoordion() == 1) {
            switch (modal1.getActiveIndexTabviewinvestigacion()) {
                case 1:
                    selectedProyInter = (OtraActividadAcademica) event.getObject();
                    break;
                case 2:
                    selectedPublicacion = (PublicacionProfesor) event.getObject();
                    break;
                default:
                    break;
            }
        }
    }

    private void reset() {
        selectedProyInter = null;
        selectedPublicacion = null;
        indiceTab = 0;
    }

    public void onRowUnselect(UnselectEvent event) {
        reset();
    }
}
