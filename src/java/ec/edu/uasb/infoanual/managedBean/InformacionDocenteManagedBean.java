/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.managedBean;


import ec.edu.uasb.entities.Ciudad;
import ec.edu.uasb.entities.Pais;
import ec.edu.uasb.infoanual.entities.Profesor;
import ec.edu.uasb.infoanual.entities.Titulo;
import ec.edu.uasb.infoanual.entities.TituloProfesor;
import ec.edu.uasb.session.CiudadFacadeLocal;
import ec.edu.uasb.infoanual.session.ConsultaFacadeLocal;

import ec.edu.uasb.infoanual.session.ProfesorFacadeLocal;
import ec.edu.uasb.infoanual.session.TituloFacadeLocal;
import ec.edu.uasb.infoanual.session.TituloProfesorFacadeLocal;
import ec.edu.uasb.portaldoc.entities.CicloAcademico;
import ec.edu.uasb.portaldoc.session.CicloAcademicoFacadeLocal;
import ec.edu.uasb.seg.entities.Usuario;
import ec.edu.uasb.session.PaisFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.Vector;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;

/**
 *
 * @author johana.orozco
 */
@ManagedBean(name = "infoDocente")
@ViewScoped
public class InformacionDocenteManagedBean implements Serializable {

    private Long codProfesor;
    private Long anio;
 
    private String msgtablavacia = "No existen datos Registrados";
    private HtmlOutputText txtcedDocente = new HtmlOutputText();
    private HtmlOutputText txtapellDocente = new HtmlOutputText();
    private HtmlOutputText txtnombreDocente = new HtmlOutputText();
    private HtmlOutputText txtareaDocente = new HtmlOutputText();
    private HtmlOutputText txtmailDocente = new HtmlOutputText();
    private HtmlOutputText txtteldomDocente = new HtmlOutputText();
    private HtmlOutputText txttelofiDocente = new HtmlOutputText();
    private HtmlOutputText txttelcelDocente = new HtmlOutputText();
    private HtmlOutputText txtdirdomDocente = new HtmlOutputText();
    private HtmlOutputText txtdirtraDocente = new HtmlOutputText();
    private Character srenviocorDocente;
    //Informacion Contratacion
    private HtmlOutputText txtcategoriadoc = new HtmlOutputText();
    private HtmlOutputText txtdedicaciondoc = new HtmlOutputText();
    private HtmlOutputText txtescalafondoc = new HtmlOutputText();
    private HtmlOutputText txtfecinicontdoc = new HtmlOutputText();
    /*PARA EL INGRESO DE TITULOS POR PROFESOR*/
    private List<TituloProfesor> listTituloProfesor = new ArrayList<TituloProfesor>();
    private HtmlSelectOneMenu smtitulo = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smpais = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smciudad = new HtmlSelectOneMenu();
    private HtmlInputText itxtuniversidad = new HtmlInputText();
    private List<Titulo> listTitulo = new ArrayList<Titulo>();
    private List<Pais> listPaistit = new ArrayList<Pais>();
    private List<Ciudad> listCiudadtit = new ArrayList<Ciudad>();
    private TituloProfesor selectTitprof = new TituloProfesor();
    private Date fectit;
    private HtmlInputText itxtregconesup = new HtmlInputText();
    private String msgvaltitprof;
    private Profesor profesor = new Profesor();
    private TituloProfesor titprofesor = new TituloProfesor();
    @EJB
    private ProfesorFacadeLocal profesorFacade;
    @EJB
    private TituloProfesorFacadeLocal tituloProfesorfacade;
    @EJB
    private PaisFacadeLocal paisFacade;
    @EJB
    private TituloFacadeLocal tituloFacade;
    @EJB
    private CiudadFacadeLocal ciudadFacade;
    @EJB
    private ConsultaFacadeLocal consultaFacade;
    @EJB
    private CicloAcademicoFacadeLocal cicloAcademicoFacade;
    private List<CicloAcademico> ciclos = new ArrayList<CicloAcademico>();
    private Usuario usr = new Usuario();
    // <editor-fold defaultstate="collapsed" desc="DECLARACION VARIABLES"> 

    public HtmlOutputText getTxtcedDocente() {
        return txtcedDocente;
    }

    public void setTxtcedDocente(HtmlOutputText txtcedDocente) {
        this.txtcedDocente = txtcedDocente;
    }

    public HtmlOutputText getTxtapellDocente() {
        return txtapellDocente;
    }

    public void setTxtapellDocente(HtmlOutputText txtapellDocente) {
        this.txtapellDocente = txtapellDocente;
    }

    public HtmlOutputText getTxtnombreDocente() {
        return txtnombreDocente;
    }

    public void setTxtnombreDocente(HtmlOutputText txtnombreDocente) {
        this.txtnombreDocente = txtnombreDocente;
    }

    public HtmlOutputText getTxtareaDocente() {
        return txtareaDocente;
    }

    public void setTxtareaDocente(HtmlOutputText txtareaDocente) {
        this.txtareaDocente = txtareaDocente;
    }

    public HtmlOutputText getTxtmailDocente() {
        return txtmailDocente;
    }

    public void setTxtmailDocente(HtmlOutputText txtmailDocente) {
        this.txtmailDocente = txtmailDocente;
    }

    public HtmlOutputText getTxtteldomDocente() {
        return txtteldomDocente;
    }

    public void setTxtteldomDocente(HtmlOutputText txtteldomDocente) {
        this.txtteldomDocente = txtteldomDocente;
    }

    public HtmlOutputText getTxttelofiDocente() {
        return txttelofiDocente;
    }

    public void setTxttelofiDocente(HtmlOutputText txttelofiDocente) {
        this.txttelofiDocente = txttelofiDocente;
    }

    public HtmlOutputText getTxttelcelDocente() {
        return txttelcelDocente;
    }

    public void setTxttelcelDocente(HtmlOutputText txttelcelDocente) {
        this.txttelcelDocente = txttelcelDocente;
    }

    public HtmlOutputText getTxtdirdomDocente() {
        return txtdirdomDocente;
    }

    public void setTxtdirdomDocente(HtmlOutputText txtdirdomDocente) {
        this.txtdirdomDocente = txtdirdomDocente;
    }

    public HtmlOutputText getTxtdirtraDocente() {
        return txtdirtraDocente;
    }

    public void setTxtdirtraDocente(HtmlOutputText txtdirtraDocente) {
        this.txtdirtraDocente = txtdirtraDocente;
    }

    public Character getSrenviocorDocente() {
        return srenviocorDocente;
    }

    public void setSrenviocorDocente(Character srenviocorDocente) {
        this.srenviocorDocente = srenviocorDocente;
    }

    public HtmlOutputText getTxtcategoriadoc() {
        return txtcategoriadoc;
    }

    public void setTxtcategoriadoc(HtmlOutputText txtcategoriadoc) {
        this.txtcategoriadoc = txtcategoriadoc;
    }

    public HtmlOutputText getTxtdedicaciondoc() {
        return txtdedicaciondoc;
    }

    public void setTxtdedicaciondoc(HtmlOutputText txtdedicaciondoc) {
        this.txtdedicaciondoc = txtdedicaciondoc;
    }

    public HtmlOutputText getTxtescalafondoc() {
        return txtescalafondoc;
    }

    public void setTxtescalafondoc(HtmlOutputText txtescalafondoc) {
        this.txtescalafondoc = txtescalafondoc;
    }

    public HtmlOutputText getTxtfecinicontdoc() {
        return txtfecinicontdoc;
    }

    public void setTxtfecinicontdoc(HtmlOutputText txtfecinicontdoc) {
        this.txtfecinicontdoc = txtfecinicontdoc;
    }

    public List<TituloProfesor> getListTituloProfesor() {
        return listTituloProfesor;
    }

    public void setListTituloProfesor(List<TituloProfesor> listTituloProfesor) {
        this.listTituloProfesor = listTituloProfesor;
    }

    public HtmlSelectOneMenu getSmtitulo() {
        return smtitulo;
    }

    public void setSmtitulo(HtmlSelectOneMenu smtitulo) {
        this.smtitulo = smtitulo;
    }

    public HtmlSelectOneMenu getSmpais() {
        return smpais;
    }

    public void setSmpais(HtmlSelectOneMenu smpais) {
        this.smpais = smpais;
    }

    public HtmlSelectOneMenu getSmciudad() {
        return smciudad;
    }

    public void setSmciudad(HtmlSelectOneMenu smciudad) {
        this.smciudad = smciudad;
    }

    public HtmlInputText getItxtuniversidad() {
        return itxtuniversidad;
    }

    public void setItxtuniversidad(HtmlInputText itxtuniversidad) {
        this.itxtuniversidad = itxtuniversidad;
    }

    public List<Titulo> getListTitulo() {
        return listTitulo;
    }

    public void setListTitulo(List<Titulo> listTitulo) {
        this.listTitulo = listTitulo;
    }

    public List<Ciudad> getListCiudadtit() {
        return listCiudadtit;
    }

    public void setListCiudadtit(List<Ciudad> listCiudadtit) {
        this.listCiudadtit = listCiudadtit;
    }

    public TituloProfesor getSelectTitprof() {
        return selectTitprof;
    }

    public void setSelectTitprof(TituloProfesor selectTitprof) {
        this.selectTitprof = selectTitprof;
    }

    public Date getFectit() {
        return fectit;
    }

    public void setFectit(Date fectit) {
        this.fectit = fectit;
    }

    public HtmlInputText getItxtregconesup() {
        return itxtregconesup;
    }

    public void setItxtregconesup(HtmlInputText itxtregconesup) {
        this.itxtregconesup = itxtregconesup;
    }

    public String getMsgvaltitprof() {
        return msgvaltitprof;
    }

    public void setMsgvaltitprof(String msgvaltitprof) {
        this.msgvaltitprof = msgvaltitprof;
    }

    public ProfesorFacadeLocal getProfesorFacade() {
        return profesorFacade;
    }

    public void setProfesorFacade(ProfesorFacadeLocal profesorFacade) {
        this.profesorFacade = profesorFacade;
    }

    public CiudadFacadeLocal getCiudadFacade() {
        return ciudadFacade;
    }

    public void setCiudadFacade(CiudadFacadeLocal ciudadFacade) {
        this.ciudadFacade = ciudadFacade;
    }

    public List<Pais> getListPaistit() {
        listPaistit = paisFacade.findAll();
        return listPaistit;
    }

    public void setListPaistit(List<Pais> listPaistit) {
        this.listPaistit = listPaistit;
    }

    public Long getCodProfesor() {
        return codProfesor;
    }

    public void setCodProfesor(Long codProfesor) {
        this.codProfesor = codProfesor;
    }

    public Long getAnio() {
        return anio;
    }

    public void setAnio(Long anio) {
        this.anio = anio;
    }

    

    public String getMsgtablavacia() {
        return msgtablavacia;
    }

    public void setMsgtablavacia(String msgtablavacia) {
        this.msgtablavacia = msgtablavacia;
    }

    // </editor-fold> 
    /**
     * Creates a new instance of DatPersonalManagedBean
     */
    public InformacionDocenteManagedBean() {
        usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        codProfesor = usr.getUsuCodigo();        
    }

    @PostConstruct
    private void init() {
         ciclos = cicloAcademicoFacade.findByEstado('A');
        if (!ciclos.isEmpty()) {
            anio = ciclos.get(0).getCicloAcademicoPK().getAnio();
        }           
        retrieveDatos(codProfesor, anio);
    }

// <editor-fold defaultstate="collapsed" desc="DATOS DOCENTE"> 
    private void retrieveDatos(Long codProf, Long anio) {
        if (codProfesor != null) {
            profesor = profesorFacade.finbyCodigo(codProf);
            //Asigno datos Personales          
            txtcedDocente.setValue(profesor.getCedPasProfesor() == null ? null : profesor.getCedPasProfesor());
            txtapellDocente.setValue(profesor.getApellidoProfesor() == null ? null : profesor.getApellidoProfesor());
            txtnombreDocente.setValue(profesor.getNombreProfesor() == null ? null : profesor.getNombreProfesor());
            txtareaDocente.setValue(profesor.getFacultad().getNombreFacultad() == null ? null : profesor.getFacultad().getNombreFacultad());
            txtmailDocente.setValue(profesor.getEmailProfesor() == null ? null : profesor.getEmailProfesor());
            txtteldomDocente.setValue(profesor.getTelfdomProfesor() == null ? null : profesor.getTelfdomProfesor());
            txttelofiDocente.setValue(profesor.getTelefonoProfesor() == null ? null : profesor.getTelefonoProfesor());
            txttelcelDocente.setValue(profesor.getCelularProfesor() == null ? null : profesor.getCelularProfesor());
            txtdirdomDocente.setValue(profesor.getDirdomProfesor() == null ? null : profesor.getDirdomProfesor());
            txtdirtraDocente.setValue(profesor.getDirtrabProfesor() == null ? null : profesor.getDirtrabProfesor());
            srenviocorDocente = profesor.getEnvcorrProfesor();
            //Recuepro los datos de los titulos
            recuperaTitulo(codProf);
            //rECUPERO EL CONTRATO
            recuperaContrato(codProf);
        }
    }
    // </editor-fold>  
// <editor-fold defaultstate="collapsed" desc="CONTRATO DOCENTE">  

    private void recuperaContrato(Long codProf) {
        Vector v = new Vector();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT TOP (1)dbo.CONTRATO_DOCENTE.CDO_CODIGO, dbo.TIPO_CONTRATO.TCO_NOMBRE,"
                + "   dbo.TIPO_DEDICACION.TDE_NOMBRE, "
                + "   convert(char(10),CONTRATO_DOCENTE.CDO_FECINI_CONTRATO,103) as[dd/mm/yyyy],"
                + "isnull(ESCALAFON.ESC_NOMBRE ,'N/D') as escalafon"
                + " FROM  dbo.CONTRATO_DOCENTE   WITH (NOLOCK) INNER JOIN"
                + " dbo.TIPO_CONTRATO ON dbo.CONTRATO_DOCENTE.TCO_CODIGO = dbo.TIPO_CONTRATO.TCO_CODIGO INNER JOIN"
                + " dbo.TIPO_DEDICACION ON dbo.CONTRATO_DOCENTE.TDE_CODIGO = dbo.TIPO_DEDICACION.TDE_CODIGO LEFT OUTER JOIN"
                + " dbo.ESCALAFON ON dbo.CONTRATO_DOCENTE.ESC_CODIGO = dbo.ESCALAFON.ESC_CODIGO"
                + " where doc_codigo = ").append(codProf.toString()).append(" ORDER BY  dbo.CONTRATO_DOCENTE.CDO_FECINI_CONTRATO DESC");
        v = (Vector) consultaFacade.ejecutaSqlList(sql.toString());
        if (v.size() > 0) {
            Object[] object = (Object[]) v.get(0);
            txtcategoriadoc.setValue(object[1] == null ? null : object[1].toString());
            txtdedicaciondoc.setValue(object[2] == null ? null : object[2].toString());
            txtfecinicontdoc.setValue(object[3] == null ? null : object[3].toString());
            txtescalafondoc.setValue(object[4] == null ? null : object[4].toString());
        }

    }
    // </editor-fold>  
// <editor-fold defaultstate="collapsed" desc="TITULOS DOCENTE"> 
    // <editor-fold defaultstate="collapsed" desc="CARGA TABLA DE TITULOS ">  

    private void recuperaTitulo(Long codProfesor) {
        TituloProfesor titaux = new TituloProfesor();
        Pais paisaxu = new Pais();
        Ciudad ciuaux = new Ciudad();
        List<TituloProfesor> listTitaux = new ArrayList<TituloProfesor>();
        listTituloProfesor.clear();
        listTitaux.clear();
        listTitaux = tituloProfesorfacade.finbyProfesor(codProfesor);
        for (int i = 0; i < listTitaux.size(); i++) {
            titaux = listTitaux.get(i);
            paisaxu = paisFacade.finbyCodigo(titaux.getPaisUniversidad());
            if (paisaxu != null) {
                titaux.setNomPas(paisaxu.getNomPais());
                if (titaux.getCiudadUniversidad() != 0) {
                    ciuaux = ciudadFacade.finbyCodigo(titaux.getPaisUniversidad(), titaux.getCiudadUniversidad());
                    if (ciuaux != null) {
                        titaux.setNomCiudad(ciuaux.getNomCiudad());
                    }
                }
            }

            listTituloProfesor.add(i, titaux);
        }

    }
    // </editor-fold> 

    // </editor-fold> 
    public void paisvalueChangeListener() {
        if (smpais.getValue() != null) {
            listCiudadtit = ciudadFacade.finbyPais((String) smpais.getValue());
        }
    }
}
