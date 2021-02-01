/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.managedBean;

import ec.edu.uasb.entities.Pais;

import ec.edu.uasb.infoanual.entities.ExamComplexivo;
import ec.edu.uasb.infoanual.entities.ExamComplexivoPK;
import ec.edu.uasb.infoanual.entities.OtraActividadAcademica;
import ec.edu.uasb.infoanual.entities.OtraActividadAcademicaPK;

import ec.edu.uasb.infoanual.entities.Profesor;
import ec.edu.uasb.infoanual.session.ConsultaFacadeLocal;
import ec.edu.uasb.infoanual.session.ExamComplexivoFacadeLocal;
import ec.edu.uasb.infoanual.session.OtraActividadAcademicaFacadeLocal;

import ec.edu.uasb.infoanual.session.ProfesorFacadeLocal;
import ec.edu.uasb.portaldoc.entities.CicloAcademico;
import ec.edu.uasb.portaldoc.session.CicloAcademicoFacadeLocal;
import ec.edu.uasb.session.PaisFacadeLocal;
//import ec.edu.uasb.seg.entities.Usuario;
import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author johana.orozco
 */
@ManagedBean(name = "docencia")
@ViewScoped
public class DocenciaManagedBean implements Serializable {

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    private Date feciniciclo;
    private Date fecfinciclo;
    private Long codProfesor;
    private Long anio;
    private String msgtablavacia = "No existen datos Registrados";
    //Informacion Asginaturas UASB
    private List<String[]> listAsiguasb = new ArrayList<String[]>();
    //Informacion Asginaturas EXTERNAS
    private List<OtraActividadAcademica> listAsigexterna = new ArrayList<OtraActividadAcademica>();
    //INGRESO DE ASIGNATURAS EXTERNAS
    OtraActividadAcademica asig = new OtraActividadAcademica();
    private HtmlInputText itxtunicotext = new HtmlInputText();
    private HtmlInputText itxtPrograma = new HtmlInputText();
    private HtmlInputText itxtAsignatura = new HtmlInputText();
    private HtmlInputText itxtncreditos = new HtmlInputText();
    private HtmlInputText itxtnclases = new HtmlInputText();
    private String itxtnhoras;
    //private HtmlInputText itxtnhoras = new HtmlInputText();
    private HtmlInputText itxtnominstitucion = new HtmlInputText();
    private HtmlSelectOneMenu smorigenpart = new HtmlSelectOneMenu();
    private Date feciniasigext;
    private Date fecfinasigext;
    private HtmlSelectOneMenu smpais = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu sminstitucion = new HtmlSelectOneMenu();
    private List<Pais> listPais = new ArrayList<Pais>();
    private List<String[]> listInstitucion = new ArrayList<String[]>();
    //Informacion TESIS UASB
    private List<String[]> listTesisuasb = new ArrayList<String[]>();
    private List<String[]> listTesdocuasb = new ArrayList<String[]>();
    private List<String[]> listTesmonuasb = new ArrayList<String[]>();
    //Ingreso información Tesis Monografía
    String itxttesmonncon = null;
    String itxttesmonnhor = null;
    //Cotutorias Externas
    private List<OtraActividadAcademica> listCotexterna = new ArrayList<OtraActividadAcademica>();
    //Ingreso Cotutorias Externas
    OtraActividadAcademica cotext = new OtraActividadAcademica();
    private HtmlInputText itxtProgcotext = new HtmlInputText();
    private HtmlSelectOneMenu smrolcotext = new HtmlSelectOneMenu();
    private InputTextarea itxttitcotext = new InputTextarea();
    private Date fecinicotext;
    private Date fecfincotext;
    private HtmlInputText itxtestcotext = new HtmlInputText();
    private HtmlSelectOneMenu smtipcotext = new HtmlSelectOneMenu();
    String itxtnumhcotext = null;
    String itxtnumthcotext = null;
    private HtmlSelectOneMenu sminstcotextr = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smpaiscotext = new HtmlSelectOneMenu();
    //Informacion Examenes COmplexivos
    private List<String[]> listExacomplex = new ArrayList<String[]>();
    private List<String[]> listExacomplexDoc = new ArrayList<String[]>();
    //Guardado Examen Complexivo
    private List<String[]> listAreaUasb = new ArrayList<String[]>();
    private List<String[]> listAreaUasbDoc = new ArrayList<String[]>();
    private int numpreparados;
    private int numcalificado;
    private int numpreparadosdoc;
    private int numcalificadodoc;
    private Profesor profesor = new Profesor();
    private ExamComplexivoPK exacomplexpk = new ExamComplexivoPK();
    private ExamComplexivoPK exacomplexdocpk = new ExamComplexivoPK();
    private HtmlInputText itxtaraeexafin = new HtmlInputText();
    @EJB
    private ConsultaFacadeLocal consultaFacade;
    @EJB
    private OtraActividadAcademicaFacadeLocal otraactividadFacade;
    @EJB
    private ExamComplexivoFacadeLocal examcomplexFacade;
    @EJB
    private ProfesorFacadeLocal profesorFacade;
    @EJB
    private PaisFacadeLocal paisFacade;
    @EJB
    private CicloAcademicoFacadeLocal cicloAcademicoFacade;
    private List<CicloAcademico> ciclos = new ArrayList<CicloAcademico>();
    // private Usuario usr = new Usuario();
    //Inyeccion del Managed Bean par poder usarl
    @ManagedProperty( value = "#{modal}")
    private modalManagedBean modal1;

    // <editor-fold defaultstate="collapsed" desc="DECLARACION VARIABLES">
    public modalManagedBean getModal1() {
        return modal1;
    }

    public void setModal1(modalManagedBean modal1) {
        this.modal1 = modal1;
    }

    public HtmlSelectOneMenu getSmpaiscotext() {
        return smpaiscotext;
    }

    public void setSmpaiscotext(HtmlSelectOneMenu smpaiscotext) {
        this.smpaiscotext = smpaiscotext;
    }

    public HtmlSelectOneMenu getSminstcotextr() {
        return sminstcotextr;
    }

    public void setSminstcotextr(HtmlSelectOneMenu sminstcotextr) {
        this.sminstcotextr = sminstcotextr;
    }

    public List<String[]> getListInstitucion() {
        return listInstitucion;
    }

    public void setListInstitucion(List<String[]> listInstitucion) {
        this.listInstitucion = listInstitucion;
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

    public HtmlSelectOneMenu getSminstitucion() {
        return sminstitucion;
    }

    public void setSminstitucion(HtmlSelectOneMenu sminstitucion) {
        this.sminstitucion = sminstitucion;
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

    public List<String[]> getListExacomplex() {
        return listExacomplex;
    }

    public void setListExacomplex(List<String[]> listExacomplex) {
        this.listExacomplex = listExacomplex;
    }

    public List<String[]> getListExacomplexDoc() {
        return listExacomplexDoc;
    }

    public void setListExacomplexDoc(List<String[]> listExacomplexDoc) {
        this.listExacomplexDoc = listExacomplexDoc;
    }

    public List<String[]> getListAreaUasb() {
        return listAreaUasb;
    }

    public void setListAreaUasb(List<String[]> listAreaUasb) {
        this.listAreaUasb = listAreaUasb;
    }

    public List<String[]> getListAreaUasbDoc() {
        return listAreaUasbDoc;
    }

    public void setListAreaUasbDoc(List<String[]> listAreaUasbDoc) {
        this.listAreaUasbDoc = listAreaUasbDoc;
    }

    public int getNumpreparados() {
        return numpreparados;
    }

    public void setNumpreparados(int numpreparados) {
        this.numpreparados = numpreparados;
    }

    public int getNumcalificado() {
        return numcalificado;
    }

    public void setNumcalificado(int numcalificado) {
        this.numcalificado = numcalificado;
    }

    public int getNumpreparadosdoc() {
        return numpreparadosdoc;
    }

    public void setNumpreparadosdoc(int numpreparadosdoc) {
        this.numpreparadosdoc = numpreparadosdoc;
    }

    public int getNumcalificadodoc() {
        return numcalificadodoc;
    }

    public void setNumcalificadodoc(int numcalificadodoc) {
        this.numcalificadodoc = numcalificadodoc;
    }

    public HtmlInputText getItxtaraeexafin() {
        return itxtaraeexafin;
    }

    public void setItxtaraeexafin(HtmlInputText itxtaraeexafin) {
        this.itxtaraeexafin = itxtaraeexafin;
    }

    public HtmlInputText getItxtProgcotext() {
        return itxtProgcotext;
    }

    public void setItxtProgcotext(HtmlInputText itxtProgcotext) {
        this.itxtProgcotext = itxtProgcotext;
    }

    public HtmlSelectOneMenu getSmrolcotext() {
        return smrolcotext;
    }

    public void setSmrolcotext(HtmlSelectOneMenu smrolcotext) {
        this.smrolcotext = smrolcotext;
    }

    public InputTextarea getItxttitcotext() {
        return itxttitcotext;
    }

    public void setItxttitcotext(InputTextarea itxttitcotext) {
        this.itxttitcotext = itxttitcotext;
    }

    public Date getFecinicotext() {
        return fecinicotext;
    }

    public void setFecinicotext(Date fecinicotext) {
        this.fecinicotext = fecinicotext;
    }

    public Date getFecfincotext() {
        return fecfincotext;
    }

    public void setFecfincotext(Date fecfincotext) {
        this.fecfincotext = fecfincotext;
    }

    public HtmlInputText getItxtestcotext() {
        return itxtestcotext;
    }

    public void setItxtestcotext(HtmlInputText itxtestcotext) {
        this.itxtestcotext = itxtestcotext;
    }

    public HtmlSelectOneMenu getSmtipcotext() {
        return smtipcotext;
    }

    public void setSmtipcotext(HtmlSelectOneMenu smtipcotext) {
        this.smtipcotext = smtipcotext;
    }

    public String getItxtnumhcotext() {
        return itxtnumhcotext;
    }

    public void setItxtnumhcotext(String itxtnumhcotext) {
        this.itxtnumhcotext = itxtnumhcotext;
    }

    public String getItxtnumthcotext() {
        return itxtnumthcotext;
    }

    public void setItxtnumthcotext(String itxtnumthcotext) {
        this.itxtnumthcotext = itxtnumthcotext;
    }

    public List<String[]> getListTesisuasb() {
        return listTesisuasb;
    }

    public void setListTesisuasb(List<String[]> listTesisuasb) {
        this.listTesisuasb = listTesisuasb;
    }

    public String getItxttesmonncon() {
        return itxttesmonncon;
    }

    public void setItxttesmonncon(String itxttesmonncon) {
        this.itxttesmonncon = itxttesmonncon;
    }

    public String getItxttesmonnhor() {
        return itxttesmonnhor;
    }

    public void setItxttesmonnhor(String itxttesmonnhor) {
        this.itxttesmonnhor = itxttesmonnhor;
    }

    public HtmlInputText getItxtunicotext() {
        return itxtunicotext;
    }

    public void setItxtunicotext(HtmlInputText itxtunicotext) {
        this.itxtunicotext = itxtunicotext;
    }

    public HtmlInputText getItxtPrograma() {
        return itxtPrograma;
    }

    public void setItxtPrograma(HtmlInputText itxtPrograma) {
        this.itxtPrograma = itxtPrograma;
    }

    public HtmlInputText getItxtAsignatura() {
        return itxtAsignatura;
    }

    public void setItxtAsignatura(HtmlInputText itxtAsignatura) {
        this.itxtAsignatura = itxtAsignatura;
    }

    public HtmlInputText getItxtncreditos() {
        return itxtncreditos;
    }

    public void setItxtncreditos(HtmlInputText itxtncreditos) {
        this.itxtncreditos = itxtncreditos;
    }

    public HtmlInputText getItxtnclases() {
        return itxtnclases;
    }

    public void setItxtnclases(HtmlInputText itxtnclases) {
        this.itxtnclases = itxtnclases;
    }

    public String getItxtnhoras() {
        return itxtnhoras;
    }

    public void setItxtnhoras(String itxtnhoras) {
        this.itxtnhoras = itxtnhoras;
    }

    public HtmlInputText getItxtnominstitucion() {
        return itxtnominstitucion;
    }

    public void setItxtnominstitucion(HtmlInputText itxtnominstitucion) {
        this.itxtnominstitucion = itxtnominstitucion;
    }

    public HtmlSelectOneMenu getSmorigenpart() {
        return smorigenpart;
    }

    public void setSmorigenpart(HtmlSelectOneMenu smorigenpart) {
        this.smorigenpart = smorigenpart;
    }

    public Date getFeciniasigext() {
        return feciniasigext;
    }

    public void setFeciniasigext(Date feciniasigext) {
        this.feciniasigext = feciniasigext;
    }

    public Date getFecfinasigext() {
        return fecfinasigext;
    }

    public void setFecfinasigext(Date fecfinasigext) {
        this.fecfinasigext = fecfinasigext;
    }

    public ConsultaFacadeLocal getConsultaFacade() {
        return consultaFacade;
    }

    public void setConsultaFacade(ConsultaFacadeLocal consultaFacade) {
        this.consultaFacade = consultaFacade;
    }

    public String getMsgtablavacia() {
        return msgtablavacia;
    }

    public void setMsgtablavacia(String msgtablavacia) {
        this.msgtablavacia = msgtablavacia;
    }

    public List<String[]> getListAsiguasb() {
        return listAsiguasb;
    }

    public void setListAsiguasb(List<String[]> listAsiguasb) {
        this.listAsiguasb = listAsiguasb;
    }
    
    public List<String[]> getListTesdocuasb() {
        return listTesdocuasb;
    }

    public void setListTesdocuasb(List<String[]> listTesdocuasb) {
        this.listTesdocuasb = listTesdocuasb;
    }
    
    public List<String[]> getListTesmonuasb() {
        return listTesmonuasb;
    }

    public void setListTesmonuasb(List<String[]> listTesmonuasb) {
        this.listTesmonuasb = listTesmonuasb;
    }

    // </editor-fold> 
    /**
     * Creates a new instance of DocenciaManagedBean
     */
    public DocenciaManagedBean() {
//        usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
//        codProfesor = usr.getUsuCodigo();
    }

    @PostConstruct
    private void init() {
        modal1.setBeandocencia(this);
        modal1.setBean(this);

        ciclos = cicloAcademicoFacade.findByEstado('A');
        if (!ciclos.isEmpty()) {
            anio = ciclos.get(0).getCicloAcademicoPK().getAnio();
            feciniciclo = ciclos.get(0).getFInicio();
            fecfinciclo = ciclos.get(0).getFFinal();
        }
        codProfesor = Long.parseLong("90");
        retrieveDatos(codProfesor, anio);
    }

    private void retrieveDatos(Long codProf, Long anio) {
        profesor = profesorFacade.finbyCodigo(codProf);
        //Recupero los datos de asignatura UASB
        recuperaAsigUasb(codProf, anio);
        //Reupero las tesis en la UASB
        recuperaTesisUasb(codProf, anio);
        //REcupero las areas academicas por anio
        recuperarAreaAcad(anio);
        //Recupero los examenes complexivos
        recuperaExaComplex(codProf, anio);
        //Recupero las areas academicas con programas de doctorado
        recuperarAreaAcadDoc(anio);
        //Recupero los examenes comprensivos
        recuperaExaCompren(codProf, anio);
    }
    // <editor-fold defaultstate="collapsed" desc="ASIGNATURAS UASB">  

    public void paisvalueChangeListener() {
        Vector v = new Vector();
        StringBuilder sql = new StringBuilder();
        listInstitucion.clear();
        if (smpais.getValue() != null) {
            sql.append(" select codigo_inst, nombre_tipin+ ' '+ NOMBRE_INST as nombre_institucion "
                    + " from institucion inner join TIPO_INSTITUCION "
                    + " on institucion.CODIGO_TIPIN = TIPO_INSTITUCION.CODIGO_TIPIN "
                    + " where institucion.codigo_tipin not in (3,4,5,6) "
                    + " and institucion.PAIS_INST = ").append(smpais.getValue().toString()).append(" order by nombre_institucion");
            v = (Vector) consultaFacade.ejecutaSqlList(sql.toString());
            if (v.size() > 0) {
                for (int i = 0; i < v.size(); i++) {
                    Object[] object = (Object[]) v.get(i);
                    String[] institu;
                    institu = new String[2];
                    institu[1] = (String) object[1];
                    listInstitucion.add(i, institu);

                }
            }

        }
    }

    private void recuperaAsigUasb(Long codProf, Long anio) {
        Vector v1 = new Vector();
        String codigoProfesor = "";
        StringBuilder sqlPro = new StringBuilder();
        sqlPro.append("SELECT vp.CODIGO_PROFESOR " +
            "FROM dbo.PROFESOR p, interfaseOcu.dbo.PROFESOR vp " +
            "WHERE p.CODIGO_PROFESOR = ").append(codProf).append(" " +
            "AND P.CED_PAS_PROFESOR = vp.CED_PAS_PROFESOR;");
        v1 = (Vector) consultaFacade.ejecutaSqlList(sqlPro.toString());
        if(v1.size() > 0){
            for (int i = 0; i < v1.size(); i++){
                Long object = (Long) v1.get(i);
                codigoProfesor = object.toString();
            }
        }
        Vector v = new Vector();
        StringBuilder sql = new StringBuilder();
        /*sql.append(" SELECT  distinct dbo.f_ret_area_materia(V_PENSUM_MATERIA.ANIO,V_PENSUM_MATERIA.CICLO, V_PENSUM_MATERIA.CODIGO_MATERIA,V_PENSUM_MATERIA.CODIGO_NIVEL,'P') programa,"
                + " V_PENSUM_MATERIA.TRIMESTRE,   "
                + " V_PENSUM_MATERIA.H_DOCEN_MATERIA_DICTAR,   "
                + " V_PENSUM_MATERIA.Horas_MATERIA_DICTAR,"
                + " V_PENSUM_MATERIA.NOMBRE_MATERIA, "
                + " V_PENSUM_MATERIA.NUM_ALUMNOS,"
                + " V_PENSUM_MATERIA.nombre_ciclo,"
                + " V_PENSUM_MATERIA.ncreditos,"
                + " isnull(V_PENSUM_MATERIA.numero_clases,0.00),"
                + " V_PENSUM_MATERIA.CODIGO_TMATERIA"
                + " FROM V_PENSUM_MATERIA"
                + " WHERE V_PENSUM_MATERIA.ANIO in (").append(anio).append(" ) AND"
                + " V_PENSUM_MATERIA.CICLO = 1  AND  "
                + " V_PENSUM_MATERIA.CODIGO_PROFESOR =").append(codProf).append(" AND"
                + " V_PENSUM_MATERIA.NUM_ALUMNOS > 0");*/
        //System.out.println("sql->  "+sql.toString() );
        sql.append("SELECT  (SELECT p.NOMBRE_PROGRAMA " + 
                "FROM interfaseOcu.dbo.PROGRAMA p " +
                "WHERE p.PRG_CODIGO = vnm.CODIGO_ESP " +
                "AND P.ANIO = vnm.ANIO) AS PROGRAMA, " +
                "CASE vnm.CODIGO_NIVEL " +
                "WHEN 1 THEN 'PRIMER TRIMESTRE' " +
                "WHEN 2 THEN 'SEGUNDO TRIMESTRE' " +
                "WHEN 3 THEN 'TERCER TRIMESTRE' " +
                "ELSE 'N/A' " +
                "END TRIMESTRE, " +
                "(SELECT UPPER(m.NOMBRE_MATERIA) " +
                "FROM interfaseOcu.dbo.MATERIA m " +
                "WHERE m.CODIGO_MATERIA = vnm.CODIGO_MATERIA) ASIGNATURA, " +
                "(SELECT SUM(CAST(vga.NCLASES_PLANIFICADAS AS INT)) " +
                "FROM interfaseOcu.dbo.V_GRUPO_ASIGNATURA_PROGRAMA vga " +
                "WHERE CAST(SUBSTRING(vga.ANIO, 1, 4) AS INT) = vnm.ANIO " +
                "AND vga.ASS_CODIGO = vnm.CODIGO_MATERIA) NUM_CLASES, " +
                "vnm.NUMEST, " +
                " CASE (SELECT vcp.TIPO_ASIGNATURA " +
                "FROM interfaseOcu.dbo.VISTA_COORDINADOR_PROGRAMA vcp " +
                "WHERE vcp.ANIO = vnm.ANIO " +
                " AND vcp.CODIGO_PROFESOR = vnm.CODIGO_PROFESOR " +
                "AND vcp.CODIGO_MATERIA = vnm.CODIGO_MATERIA) WHEN 'T' THEN 'SI' ELSE 'NO' END TIPO_ASIGNATURA " +
                "FROM    interfaseOcu.dbo.VISTA_NUMESTUDIANTE_MATERIA vnm " +
                "WHERE vnm.CODIGO_PROFESOR =").append(codigoProfesor).append(" " +
                "AND vnm.ANIO =").append(anio);
        v = (Vector) consultaFacade.ejecutaSqlList(sql.toString());
        if (v.size() > 0) {
            for (int i = 0; i < v.size(); i++) {
                Object[] object = (Object[]) v.get(i);
                String[] asign;
                asign = new String[6];
                asign[0] = (String) object[0];
                asign[1] = (String) object[1];
                asign[2] = (String) object[2];
                asign[3] = object[3].toString();
                asign[4] = object[4].toString();
                asign[5] = (String) object[5];
                listAsiguasb.add(i, asign);
            }
        }
    }
    // </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc="ASIGNATURAS EXTERNAS"> 
    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA ASIGNATURA EXTERNA"> 

    public List<OtraActividadAcademica> getListAsigexterna() {
        listAsigexterna = otraactividadFacade.findAsigexterna(codProfesor, anio);
        for (OtraActividadAcademica assig : listAsigexterna) {
            if(assig.getPaisInvest() != null && paisFacade.find(assig.getPaisInvest()) != null && paisFacade.find(assig.getPaisInvest()).getNomPais() != null){
                assig.setNomPas(paisFacade.find(assig.getPaisInvest()).getNomPais());
            }
        }
        return listAsigexterna;
    }

    public void setListAsigexterna(List<OtraActividadAcademica> listAsigexterna) {
        this.listAsigexterna = listAsigexterna;
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="SELECCION DE FILA PARA EDICION">    
    private OtraActividadAcademica selectedAsigExt;

    public OtraActividadAcademica getSelectedAsigExt() {
        return selectedAsigExt;
    }

    public void setSelectedAsigExt(OtraActividadAcademica selectedAsigExt) {
        this.selectedAsigExt = selectedAsigExt;
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">  
    public void SaveAsignExterna() {
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        OtraActividadAcademica asigaux = new OtraActividadAcademica();
        if (asig != null) {
            if (asig.getOtraActividadAcademicaPK() != null) {
                asigaux = otraactividadFacade.find(asig.getOtraActividadAcademicaPK());
            }
        }
        try {
            itxtnominstitucion.setValue(sminstitucion.getValue().toString());
            asig.setNombreActividad(itxtAsignatura.getValue() == null ? " " : itxtAsignatura.getValue().toString().toUpperCase());
            asig.setProgramaActividad(itxtPrograma.getValue() == null ? null : itxtPrograma.getValue().toString().toUpperCase());
            asig.setPaisInvest(smpais.getValue() == null ? null : smpais.getValue().toString());
            asig.setNum2Actividad(itxtnhoras == null ? null : Integer.parseInt(itxtnhoras));
            asig.setInstitucionActividad(itxtnominstitucion.getValue() == null ? null : itxtnominstitucion.getValue().toString().toUpperCase());
            asig.setOrigenParticipacion(smorigenpart.getValue() == null ? null : smorigenpart.getValue().toString());
            asig.setFinicioActividad(new java.sql.Date(feciniasigext.getTime()));
            asig.setFfinActividad(new java.sql.Date(fecfinasigext.getTime()));
            if (smpais.getValue() != null) {
                //Indica que es pais ecuador
                if (smpais.getValue() == "1") {
                    asig.setSedeInstActividad('N');
                } else {
                    asig.setSedeInstActividad('I');
                }
            }
            if (asigaux.getOtraActividadAcademicaPK() == null) {
                OtraActividadAcademicaPK asigextpk = new OtraActividadAcademicaPK();
                asigextpk.setCodigoProfesor(codProfesor);
                asigextpk.setTipoOtraActividad('B');
                asig.setOtraActividadAcademicaPK(asigextpk);
                asig.setFechaUltmodific(new Date());
                asig.setUsuarioUltmodific("Internet");
                asig.setFechaCrea(new Date());
                asig.setUsuarioCrea("Internet");
                otraactividadFacade.create(asig);
            } else {
                asig.setFechaUltmodific(new Date());
                asig.setUsuarioUltmodific("Internet");
                otraactividadFacade.edit(asig);
            }
            //Recuepro los datos de los titulos            
            FacesMessage msg = new FacesMessage("Asignatura (Otras Universidades) Guardada");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            getListAsigexterna();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al Guardar Asignatura (Otras Universidades)");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        } finally {
            asig = new OtraActividadAcademica();
            CancelAsigExt();
        }
    }
    // </editor-fold>    
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">  

    public void DeleteAsigExt() {
        if (selectedAsigExt != null) {
            if (selectedAsigExt.getOtraActividadAcademicaPK() != null) {
                try {
                    OtraActividadAcademica asigext = new OtraActividadAcademica();
                    asigext = otraactividadFacade.find(selectedAsigExt.getOtraActividadAcademicaPK());
                    otraactividadFacade.remove(asigext);
                    //Recupero las asignaturas externas                    
                    RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infoacade:gasigext");
                    asig = new OtraActividadAcademica();
                    getListAsigexterna();
                } catch (Exception e) {
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de: Asignatura (Otras Universidades)", "");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
                }
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Asignatura (Otras Universidades) a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">  
    public void EditAsigExt() {
        if (selectedAsigExt != null) {
            if (selectedAsigExt.getOtraActividadAcademicaPK() != null) {
                RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
                asig = selectedAsigExt;
                itxtAsignatura.setValue(selectedAsigExt.getNombreActividad());
//                itxtnclases.setValue(selectedAsigExt.getDuracionActividad());

                itxtPrograma.setValue(selectedAsigExt.getProgramaActividad());
//                itxtncreditos.setValue(selectedAsigExt.getNum1Actividad());
                smpais.setValue(selectedAsigExt.getPaisInvest());
                paisvalueChangeListener();
                sminstitucion.setValue(selectedAsigExt.getInstitucionActividad());
                itxtnominstitucion.setValue(selectedAsigExt.getInstitucionActividad());
                itxtnhoras = (selectedAsigExt.getNum2Actividad().toString());
                feciniasigext = new java.sql.Date(selectedAsigExt.getFinicioActividad().getTime());
                fecfinasigext = new java.sql.Date(selectedAsigExt.getFfinActividad().getTime());
                smorigenpart.setValue(selectedAsigExt.getOrigenParticipacion());
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Asignatura (Otras Universidades) a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">  

    public void CancelAsigExt() {
        selectedAsigExt = new OtraActividadAcademica();
        asig = new OtraActividadAcademica();
        itxtAsignatura.setValue(null);
        itxtnclases.setValue(null);
        itxtncreditos.setValue(null);
        itxtnominstitucion.setValue(null);
        itxtnhoras = null;
        itxtPrograma.setValue(null);
        feciniasigext = null;
        fecfinasigext = null;
        smorigenpart.setValue(null);
        smpais.setValue(null);
        sminstitucion.setValue(null);
    }
    // </editor-fold> 
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="TESIS UASB">  
    // <editor-fold defaultstate="collapsed" desc="SELECCION DE FILA PARA EDICION">  
    private String[] tesimonografia = new String[21];

    public String[] getTesimonografia() {
        return tesimonografia;
    }

    public void setTesimonografia(String[] tesimonografia) {
        this.tesimonografia = tesimonografia;
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA ">    
    private void recuperaTesisUasb(Long codProf, Long anio) {
        Vector v = new Vector();
        listTesisuasb.clear();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT VISTA_TESIS_MONOGRAFIA.nivel +' EN '+ VISTA_TESIS_MONOGRAFIA.programa,"
                + " (CASE VISTA_TESIS_MONOGRAFIA.TIPO WHEN 'TP' THEN 'Tribunal Plan' "
                + " WHEN 'TU' THEN 'Tutor de tesis' WHEN 'SM' THEN 'Supervisión de monografías' "
                + " WHEN 'LT' THEN 'Lector de tesis' WHEN 'SL' THEN 'Segundo Lector'"
                + " WHEN 'TR' THEN 'Tribunal Tesis' "
                + " WHEN 'DI' THEN 'Director de Tesis' ELSE 'N/I' END) roldocen,  "
                + " VISTA_TESIS_MONOGRAFIA.TITULO_TES_MON,    "
                + " VISTA_TESIS_MONOGRAFIA.FECHA, "
                + " VISTA_TESIS_MONOGRAFIA.F_ENTREGA_DEFINITIVA, "
                + " VISTA_TESIS_MONOGRAFIA.Apellidos + ' '+ VISTA_TESIS_MONOGRAFIA.Nombres NOMBRES,"
                + " (CASE  VISTA_TESIS_MONOGRAFIA.TESIS_MONOGRAFIA WHEN 'D' THEN 'TESIS DOCTORAL'"
                + " WHEN 'M' THEN 'MONOGRAFIA' WHEN 'T' THEN 'TESIS'END) TIPTRABAJO,         "
                + " VISTA_TESIS_MONOGRAFIA.NUM_CONSULTAS,   "
                + " VISTA_TESIS_MONOGRAFIA.NUM_HORAS,   "
                + " VISTA_TESIS_MONOGRAFIA.anio_estudiante,   "
                + " VISTA_TESIS_MONOGRAFIA.ciclo,   "
                + " VISTA_TESIS_MONOGRAFIA.matricula,   "
                + " VISTA_TESIS_MONOGRAFIA.codigo_esp,   "
                + " VISTA_TESIS_MONOGRAFIA.Código codestudiante,  "
                + " VISTA_TESIS_MONOGRAFIA.TIPO,"
                + " VISTA_TESIS_MONOGRAFIA.FECHA_INI, "
                + " VISTA_TESIS_MONOGRAFIA.FECHA_FIN, "
                + " VISTA_TESIS_MONOGRAFIA.TIP_HORAS, "
                + " VISTA_TESIS_MONOGRAFIA.ANIO_ESTUDIANTE, "
                + " VISTA_TESIS_MONOGRAFIA.NOMBRES_PROFESOR,"
                + " VISTA_TESIS_MONOGRAFIA.CODIGO_NIVEACAD,"
                + " (CASE VISTA_TESIS_MONOGRAFIA.ESTADO_TES_MON WHEN 'A' THEN 'EN PROCESO' ELSE 'N/I' END) ESTADO_TES_MON,"
                + " (CASE VISTA_TESIS_MONOGRAFIA.ESTADO_PROCESO WHEN 'P' THEN 'EN PROCESO' WHEN 'C' THEN 'CONLUIDA' END) ESTADO_PROCESO"
                + " FROM VISTA_TESIS_MONOGRAFIA "
                + " WHERE ( VISTA_TESIS_MONOGRAFIA.CODIGO_PROFESOR =").append(codProf).append(" ) AND  ").append(anio).append(""
                + " between  VISTA_TESIS_MONOGRAFIA.ANIO_INICIO and  VISTA_TESIS_MONOGRAFIA.ANIO_FIN"
                // + " and VISTA_TESIS_MONOGRAFIA.CODIGO_NIVEACAD in(1,10,13)"                
                + " ORDER BY VISTA_TESIS_MONOGRAFIA.FECHA DESC");

        v = (Vector) consultaFacade.ejecutaSqlList(sql.toString());
        if (v.size() > 0) {
            int itestm =0, itestd = 0, imon= 0;
            for (int i = 0; i < v.size(); i++) {
                Object[] object = (Object[]) v.get(i);
                String[] asign;
                asign = new String[23];
                asign[0] = object[0].toString();
                asign[1] = (String) object[1];
                asign[2] = (String) object[2];
                asign[3] = (object[3] == null ? null : formato.format(object[3]));
                asign[4] = (object[4] == null ? null : formato.format(object[4]));
                asign[5] = object[5].toString();
                asign[6] = object[6].toString();
                asign[7] = (object[7] == null ? null : object[7].toString());
                asign[8] = (object[8] == null ? null : object[8].toString());
                asign[9] = object[9].toString();
                asign[10] = object[10].toString();
                asign[11] = object[11].toString();
                asign[12] = object[12].toString();
                asign[13] = object[13].toString();
                asign[14] = object[14].toString();
                asign[15] = (object[15] == null ? null : object[15].toString());
                asign[16] = (object[16] == null ? null : object[16].toString());
                asign[17] = (object[17] == null ? null : object[17].toString());
                asign[18] = (object[18] == null ? null : object[18].toString());
                asign[19] = codProf.toString();
                asign[20] = (object[19] == null ? null : object[19].toString());
                asign[21] = (object[20] == null ? null : object[20].toString());
                asign[22] = (object[22] == null ? null : object[22].toString());
                if (object[20].toString().equalsIgnoreCase("1")||object[20].toString().equalsIgnoreCase("10")||object[20].toString().equalsIgnoreCase("13")) {
                    listTesisuasb.add(itestm, asign);
                    itestm++;
                }
                if (object[20].toString().equalsIgnoreCase("3")) {
                    listTesdocuasb.add(itestd, asign);
                    itestd++;
                }
                 if (object[20].toString().equalsIgnoreCase("2")) {
                    listTesmonuasb.add(imon, asign);
                    imon++;
                }
            }
        }
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">  

    public void EditTitMonUsab() {
        if (tesimonografia != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            itxttesmonncon = (tesimonografia[7] == null ? null : tesimonografia[7].toString());
            itxttesmonnhor = (tesimonografia[8] == null ? null : tesimonografia[8].toString());

        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Tutoría a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    // </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">  

    public void CancelTesMonUasb() {
        tesimonografia = new String[21];
        itxttesmonncon = null;
        itxttesmonnhor = (null);

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">  

    public void SaveTesMonUasb() {

        try {
            tesimonografia[7] = (itxttesmonncon.toString().trim().length() == 0 || itxttesmonncon == null ? null : itxttesmonncon);
            tesimonografia[8] = (itxttesmonnhor.toString().trim().length() == 0 || itxttesmonnhor == null ? null : itxttesmonnhor);
            consultaFacade.actTesMonUasb(tesimonografia);
            //Recuepro los datos de los titulos
            RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
            FacesMessage msg = new FacesMessage("Tesis Uasb Actualizada");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            recuperaTesisUasb(codProfesor, anio);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al Guardar Tesis Uasb");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        } finally {
            CancelTesMonUasb();
        }
    }
    // </editor-fold>  
    // </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc="COTUTORIAS EXTERNAS"> 

    public void paisCotExtvalueChangeListener() {

        Vector v = new Vector();
        StringBuilder sql = new StringBuilder();
        listInstitucion.clear();
        if (smpaiscotext.getValue() != null) {
            sql.append(" select codigo_inst, nombre_tipin+ ' '+ NOMBRE_INST as nombre_institucion "
                    + " from institucion inner join TIPO_INSTITUCION "
                    + " on institucion.CODIGO_TIPIN = TIPO_INSTITUCION.CODIGO_TIPIN "
                    + " where institucion.codigo_tipin not in (3,4,5,6) "
                    + " and institucion.PAIS_INST = ").append(smpaiscotext.getValue().toString());
            v = (Vector) consultaFacade.ejecutaSqlList(sql.toString());
            if (v.size() > 0) {
                for (int i = 0; i < v.size(); i++) {
                    Object[] object = (Object[]) v.get(i);
                    String[] institu;
                    institu = new String[2];
                    institu[1] = (String) object[1];
                    listInstitucion.add(i, institu);

                }
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="CARGA TABLA COTUTORIAS EXTERNAS"> 

    public List<OtraActividadAcademica> getListCotexterna() {
        listCotexterna = otraactividadFacade.findCotexterna(codProfesor, anio);
        for (OtraActividadAcademica assig : listCotexterna) {
            assig.setNomPas(paisFacade.find(assig.getPaisInvest()).getNomPais());
        }
        return listCotexterna;
    }

    public void setListCotexterna(List<OtraActividadAcademica> listCotexterna) {
        this.listCotexterna = listCotexterna;
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="SELECCION DE FILA PARA EDICION">    
    private OtraActividadAcademica selectedCotExt;

    public OtraActividadAcademica getSelectedCotExt() {
        return selectedCotExt;
    }

    public void setSelectedCotExt(OtraActividadAcademica selectedCotExt) {
        this.selectedCotExt = selectedCotExt;
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">  
    public void SaveCotExterna() {
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        OtraActividadAcademica cotextaux = new OtraActividadAcademica();
        if (cotext != null) {
            if (cotext.getOtraActividadAcademicaPK() != null) {
                cotextaux = otraactividadFacade.find(cotext.getOtraActividadAcademicaPK());
            }
        }
        try {

            cotext.setInstitucionActividad(sminstcotextr.getValue() == null ? null : sminstcotextr.getValue().toString());
            cotext.setPaisInvest(smpaiscotext.getValue() == null ? null : smpaiscotext.getValue().toString());
            cotext.setProgramaActividad(itxtProgcotext.getValue() == null ? null : itxtProgcotext.getValue().toString().toUpperCase());
            cotext.setTituloActividad(itxttitcotext.getValue() == null ? null : itxttitcotext.getValue().toString().toUpperCase());
            cotext.setFinicioActividad(new java.sql.Date(fecinicotext.getTime()));
            cotext.setFfinActividad(fecfincotext == null ? null : new java.sql.Date(fecfincotext.getTime()));
            cotext.setNombreActividad(itxtestcotext.getValue() == null ? null : itxtestcotext.getValue().toString().toUpperCase());
            cotext.setTipoActividad(smtipcotext.getValue() == null ? null : Long.parseLong(smtipcotext.getValue().toString()));
            cotext.setTipo2Actividad(smrolcotext.getValue() == null ? null : smrolcotext.getValue().toString().charAt(0));
            cotext.setNum1Actividad(itxtnumhcotext == null ? null : Integer.parseInt(itxtnumhcotext.toString()));
            cotext.setNum2Actividad(itxtnumthcotext == null ? null : Integer.parseInt(itxtnumthcotext.toString()));
            if (cotextaux.getOtraActividadAcademicaPK() == null) {
                OtraActividadAcademicaPK cotextpk = new OtraActividadAcademicaPK();
                cotextpk.setCodigoProfesor(codProfesor);
                cotextpk.setTipoOtraActividad('T');
                cotext.setOtraActividadAcademicaPK(cotextpk);
                cotext.setFechaCrea(new Date());
                cotext.setUsuarioCrea("Internet");
                cotext.setFechaUltmodific(new Date());
                cotext.setUsuarioUltmodific("Internet");
                otraactividadFacade.create(cotext);
            } else {
                cotext.setFechaUltmodific(new Date());
                cotext.setUsuarioUltmodific("Internet");
                otraactividadFacade.edit(cotext);
            }
            //Recuepro los datos de los titulos
            FacesMessage msg = new FacesMessage("Cotutoría (Otras Universidades) Guardada");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            getListCotexterna();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error al Guardar Cotutoría (Otras Universidades)");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

        } finally {
            cotext = new OtraActividadAcademica();
        }
        CancelCotExt();

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">  

    public void DeleteCotExt() {
        if (selectedCotExt != null) {
            try {
                OtraActividadAcademica cotextaux = new OtraActividadAcademica();
                cotextaux = otraactividadFacade.find(selectedCotExt.getOtraActividadAcademicaPK());
                otraactividadFacade.remove(cotextaux);
                //Recupero las asignaturas externas
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infoacade:gcotext");

                cotext = new OtraActividadAcademica();
                getListAsigexterna();
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de: Tutoría (Otras Universidades)", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

            } finally {
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Cotutoría (Otras Universidades) a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">  

    public void EditCotExt() {

        if (selectedCotExt != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            cotext = selectedCotExt;
            smpaiscotext.setValue(cotext.getPaisInvest());
            paisvalueChangeListener();
            sminstcotextr.setValue(cotext.getInstitucionActividad());
            //itxtunicotext.setValue(cotext.getInstitucionActividad());
            itxtProgcotext.setValue(cotext.getProgramaActividad());
            itxttitcotext.setValue(cotext.getTituloActividad());
            fecinicotext = (cotext.getFinicioActividad() == null ? null : new java.sql.Date(cotext.getFinicioActividad().getTime()));
            fecfincotext = (cotext.getFfinActividad() == null ? null : new java.sql.Date(cotext.getFfinActividad().getTime()));
            itxtestcotext.setValue(cotext.getNombreActividad().toString());
            smtipcotext.setValue(cotext.getTipoActividad());
            smrolcotext.setValue(cotext.getTipo2Actividad());
            itxtnumhcotext = (cotext.getNum1Actividad() == null ? null : cotext.getNum1Actividad().toString());
            itxtnumthcotext = (cotext.getNum2Actividad() == null ? null : cotext.getNum2Actividad().toString());

        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar una Cotutoría a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">  

    public void CancelCotExt() {
        selectedCotExt = new OtraActividadAcademica();
        cotext = new OtraActividadAcademica();
        itxtunicotext.setValue(null);
        itxtProgcotext.setValue(null);
        itxttitcotext.setValue(null);
        fecinicotext = null;
        fecfincotext = null;
        itxtestcotext.setValue(null);
        smtipcotext.setValue(null);
        smrolcotext.setValue(null);
        itxtnumhcotext = null;
        itxtnumthcotext = null;
        smpaiscotext.setValue(null);
        sminstcotextr.setValue(null);

    }
    // </editor-fold> 
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="EXAMENES COMPLEXIVOS"> 
    // <editor-fold defaultstate="collapsed" desc="SELECCIONAR AREA">  
    private String[] selectareaacad;

    public String[] getSelectareaacad() {
        return selectareaacad;
    }

    public void setSelectareaacad(String[] selectareaacad) {
        this.selectareaacad = selectareaacad;
    }
    // </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc="CARGA TABLA EXAMENES COMPLEXIVOS">  

    private void recuperaExaComplex(Long codProf, Long anio) {
        listExacomplex.clear();
        Vector v = new Vector();
        StringBuilder sql = new StringBuilder();
        sql.append("   SELECT EXAM_COMPLEXIVO.CODIGO_NIVEACAD,  "
                + " EXAM_COMPLEXIVO.CODIGO_ESP,   "
                + " EXAM_COMPLEXIVO.ANIO,   "
                + " EXAM_COMPLEXIVO.CICLO,   "
                + " EXAM_COMPLEXIVO.CODIGO_PROFESOR,   "
                + " EXAM_COMPLEXIVO.NRO_EXAMEN_PREPAR,   "
                + " EXAM_COMPLEXIVO.NRO_EXAMEN_CALIF,   "
                + " EXAM_COMPLEXIVO.CODIGO_FACULTAD,   "
                + " EXAM_COMPLEXIVO.CODIGO_ESCUELA,   "
                + " VISTA_PROGRAMAS_UASB.AREA,   "
                + " VISTA_PROGRAMAS_UASB.NIVEL_ACADEMICO,   "
                + " VISTA_PROGRAMAS_UASB.PROGRAMA,   "
                + " VISTA_PROGRAMAS_UASB.MENCION,  "
                + " VISTA_PROGRAMAS_UASB.NIVEL_ACADEMICO + ' EN ' + VISTA_PROGRAMAS_UASB.PROGRAMA + ' MENCION: '+VISTA_PROGRAMAS_UASB.MENCION AS PROGRAMA   "
                + "  FROM EXAM_COMPLEXIVO,   "
                + "  VISTA_PROGRAMAS_UASB  "
                + "  WHERE  EXAM_COMPLEXIVO.CODIGO_NIVEACAD = VISTA_PROGRAMAS_UASB.CODIGO_NIVEACAD  and  "
                + "   EXAM_COMPLEXIVO.CODIGO_FACULTAD = VISTA_PROGRAMAS_UASB.CODIGO_FACULTAD  and  "
                + "   EXAM_COMPLEXIVO.CODIGO_ESCUELA = VISTA_PROGRAMAS_UASB.CODIGO_ESCUELA  and  "
                + "   EXAM_COMPLEXIVO.CODIGO_ESP = VISTA_PROGRAMAS_UASB.CODIGO_ESP  and  "
                + "   EXAM_COMPLEXIVO.ANIO = VISTA_PROGRAMAS_UASB.ANIO  and  "
                + "   EXAM_COMPLEXIVO.CICLO = VISTA_PROGRAMAS_UASB.CICLO  and  "
                + "   EXAM_COMPLEXIVO.ANIO = ").append(anio).append(" AND  "
                + "  EXAM_COMPLEXIVO.CICLO = 1  AND  "
                + "  EXAM_COMPLEXIVO.CODIGO_PROFESOR = ").append(codProf).append(" ").append("AND "
                + "EXAM_COMPLEXIVO.TIPO_EXAMEN = 'C'");

        v = (Vector) consultaFacade.ejecutaSqlList(sql.toString());
        if (v.size() > 0) {
            for (int i = 0; i < v.size(); i++) {
                Object[] object = (Object[]) v.get(i);
                String[] exacomple;
                exacomple = new String[14];
                exacomple[0] = object[0].toString();
                exacomple[1] = object[1].toString();
                exacomple[2] = object[2].toString();
                exacomple[3] = object[3].toString();
                exacomple[4] = object[4].toString();
                exacomple[5] = object[5].toString();
                exacomple[6] = object[6].toString();
                exacomple[7] = object[7].toString();
                exacomple[8] = object[8].toString();
                exacomple[9] = object[9].toString();
                exacomple[10] = object[10].toString();
                exacomple[11] = object[11].toString();
                exacomple[12] = object[12].toString();
                exacomple[13] = object[13].toString();
                listExacomplex.add(i, exacomple);
            }
        }
    }
    // </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc="SELECCION DE FILA PARA EDICION">    
    private String[] selectedExacomplex;

    public String[] getSelectedExacomplex() {
        return selectedExacomplex;
    }

    public void setSelectedExacomplex(String[] selectedExacomplex) {
        this.selectedExacomplex = selectedExacomplex;
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">  

    public void SaveExaComplex() {
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        ExamComplexivo exacompaux = new ExamComplexivo();
        ExamComplexivo exacomplex = new ExamComplexivo();
        if (selectareaacad != null) {
            try {
                exacompaux = examcomplexFacade.find(exacomplexpk);
                exacomplex.setNroExamenCalif(numcalificado);
                exacomplex.setNroExamenPrepar(numpreparados);
                exacomplex.setProfesor(profesor);
                if (exacompaux == null) {
                    exacomplexpk.setCodigoFacultad(selectareaacad[2] == null ? null : Long.parseLong(selectareaacad[2]));
                    exacomplexpk.setCodigoEscuela(selectareaacad[4] == null ? null : Long.parseLong(selectareaacad[4]));
                    exacomplexpk.setCodigoEsp(selectareaacad[6] == null ? null : Long.parseLong(selectareaacad[6]));
                    exacomplexpk.setCodigoNiveacad(selectareaacad[0] == null ? null : Long.parseLong(selectareaacad[0]));
                    exacomplexpk.setCodigoProfesor(codProfesor == null ? null : codProfesor);
                    exacomplexpk.setAnio(anio);
                    exacomplexpk.setCiclo(1);
                    exacomplex.setExamComplexivoPK(exacomplexpk);
                    exacomplex.setFechaCrea(new Date());
                    exacomplex.setUsuarioCrea("Internet");
                    exacomplex.setFechaUltmodific(new Date());
                    exacomplex.setUsuarioUltmodific("Internet");
                    exacomplex.setTipoexamen('C');
                    examcomplexFacade.create(exacomplex);
                } else {
                    exacomplex = exacompaux;
                    exacomplex.setNroExamenCalif(numcalificado);
                    exacomplex.setNroExamenPrepar(numpreparados);
                    exacomplex.setProfesor(profesor);
                    exacomplex.setFechaUltmodific(new Date());
                    exacomplex.setUsuarioUltmodific("Internet");
                    exacomplex.setTipoexamen('C');
                    examcomplexFacade.edit(exacomplex);
                }
                //Recupero los examenes complexivos                
                FacesMessage msg = new FacesMessage("Examen Final Guardado");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                recuperaExaComplex(profesor.getCodigoProfesor(), anio);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage("Error al Guardar Examen Final");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

            } finally {
                exacomplex = new ExamComplexivo();
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe escoger una área", ""));
        }
        CancelExaComplex();
    }
// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">  

    public void EditExaComplex() {
        if (selectedExacomplex != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            selectareaacad = new String[11];
            selectareaacad[0] = selectedExacomplex[0];
            selectareaacad[1] = selectedExacomplex[10];
            selectareaacad[2] = selectedExacomplex[7];
            selectareaacad[3] = selectedExacomplex[9];
            selectareaacad[4] = selectedExacomplex[8];
            selectareaacad[5] = selectedExacomplex[11];
            selectareaacad[6] = selectedExacomplex[1];
            selectareaacad[7] = selectedExacomplex[5];
            selectareaacad[10] = selectedExacomplex[13];
            numpreparados = Integer.parseInt(selectedExacomplex[5]);
            numcalificado = Integer.parseInt(selectedExacomplex[6]);
            exacomplexpk.setCodigoFacultad(selectareaacad[2] == null ? null : Long.parseLong(selectareaacad[2]));
            exacomplexpk.setCodigoEscuela(selectareaacad[4] == null ? null : Long.parseLong(selectareaacad[4]));
            exacomplexpk.setCodigoEsp(selectareaacad[6] == null ? null : Long.parseLong(selectareaacad[6]));
            exacomplexpk.setCodigoNiveacad(selectareaacad[0] == null ? null : Long.parseLong(selectareaacad[0]));
            exacomplexpk.setCodigoProfesor(codProfesor == null ? null : codProfesor);
            exacomplexpk.setCiclo(1);
            exacomplexpk.setAnio(anio);
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar un examen a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">  

    public void DeleteExaComplex() {
        if (selectedExacomplex != null) {
            try {
                ExamComplexivo exacomplex = new ExamComplexivo();
                ExamComplexivoPK exacomplexpk = new ExamComplexivoPK();
                exacomplexpk.setCodigoFacultad(Long.parseLong(selectedExacomplex[7]));
                exacomplexpk.setCodigoEscuela(Long.parseLong(selectedExacomplex[8]));
                exacomplexpk.setCodigoEsp(Long.parseLong(selectedExacomplex[1]));
                exacomplexpk.setCodigoNiveacad(Long.parseLong(selectedExacomplex[0]));
                exacomplexpk.setCodigoProfesor(profesor.getCodigoProfesor());
                exacomplexpk.setAnio(anio);
                exacomplexpk.setCiclo(1);
                exacomplex = examcomplexFacade.find(exacomplexpk);
                examcomplexFacade.remove(exacomplex);
                listExacomplex.remove(selectedExacomplex);
                //Recupero los examenes complexivos
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infoacade:gexacomplex");
                recuperaExaComplex(codProfesor, anio);

            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de: Examen Final", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar un Examen Final a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">  

    public void CancelExaComplex() {
        selectedExacomplex = null;
        selectareaacad = null;
        numpreparados = 0;
        numcalificado = 0;
        exacomplexpk = new ExamComplexivoPK();
    }
    // </editor-fold> 
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="EXAMENES COMPRENSIVOS"> 
    // <editor-fold defaultstate="collapsed" desc="SELECCIONAR AREA DOCTORADO">  
    private String[] selectareaacaddoc;

    public String[] getSelectareaacaddoc() {
        return selectareaacaddoc;
    }

    public void setSelectareaacaddoc(String[] selectareaacaddoc) {
        this.selectareaacaddoc = selectareaacaddoc;
    }
    // </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc="CARGA TABLA EXAMENES COMPRENSIVOS">  

    private void recuperaExaCompren(Long codProf, Long anio) {
        listExacomplexDoc.clear();
        Vector v = new Vector();
        StringBuilder sql = new StringBuilder();
        sql.append("   SELECT EXAM_COMPLEXIVO.CODIGO_NIVEACAD,  "
                + " EXAM_COMPLEXIVO.CODIGO_ESP,   "
                + " EXAM_COMPLEXIVO.ANIO,   "
                + " EXAM_COMPLEXIVO.CICLO,   "
                + " EXAM_COMPLEXIVO.CODIGO_PROFESOR,   "
                + " EXAM_COMPLEXIVO.NRO_EXAMEN_PREPAR,   "
                + " EXAM_COMPLEXIVO.NRO_EXAMEN_CALIF,   "
                + " EXAM_COMPLEXIVO.CODIGO_FACULTAD,   "
                + " EXAM_COMPLEXIVO.CODIGO_ESCUELA,   "
                + " VISTA_PROGRAMAS_UASB.AREA,   "
                + " VISTA_PROGRAMAS_UASB.NIVEL_ACADEMICO,   "
                + " VISTA_PROGRAMAS_UASB.PROGRAMA,   "
                + " VISTA_PROGRAMAS_UASB.MENCION,  "
                + " VISTA_PROGRAMAS_UASB.NIVEL_ACADEMICO + ' EN ' + VISTA_PROGRAMAS_UASB.PROGRAMA + ' MENCION: '+VISTA_PROGRAMAS_UASB.MENCION AS PROGRAMA   "
                + "  FROM EXAM_COMPLEXIVO,   "
                + "  VISTA_PROGRAMAS_UASB  "
                + "  WHERE  EXAM_COMPLEXIVO.CODIGO_NIVEACAD = VISTA_PROGRAMAS_UASB.CODIGO_NIVEACAD  and  "
                + "   EXAM_COMPLEXIVO.CODIGO_FACULTAD = VISTA_PROGRAMAS_UASB.CODIGO_FACULTAD  and  "
                + "   EXAM_COMPLEXIVO.CODIGO_ESCUELA = VISTA_PROGRAMAS_UASB.CODIGO_ESCUELA  and  "
                + "   EXAM_COMPLEXIVO.CODIGO_ESP = VISTA_PROGRAMAS_UASB.CODIGO_ESP  and  "
                + "   EXAM_COMPLEXIVO.ANIO = VISTA_PROGRAMAS_UASB.ANIO  and  "
                + "   EXAM_COMPLEXIVO.CICLO = VISTA_PROGRAMAS_UASB.CICLO  and  "
                + "   EXAM_COMPLEXIVO.ANIO = ").append(anio).append(" AND  "
                + "  EXAM_COMPLEXIVO.CICLO = 1  AND  "
                + "  EXAM_COMPLEXIVO.CODIGO_PROFESOR = ").append(codProf).append(" ").append("AND "
                + "  EXAM_COMPLEXIVO.TIPO_EXAMEN = 'M'");

        v = (Vector) consultaFacade.ejecutaSqlList(sql.toString());
        if (v.size() > 0) {
            for (int i = 0; i < v.size(); i++) {
                Object[] object = (Object[]) v.get(i);
                String[] exacomple;
                exacomple = new String[14];
                exacomple[0] = object[0].toString();
                exacomple[1] = object[1].toString();
                exacomple[2] = object[2].toString();
                exacomple[3] = object[3].toString();
                exacomple[4] = object[4].toString();
                exacomple[5] = object[5].toString();
                exacomple[6] = object[6].toString();
                exacomple[7] = object[7].toString();
                exacomple[8] = object[8].toString();
                exacomple[9] = object[9].toString();
                exacomple[10] = object[10].toString();
                exacomple[11] = object[11].toString();
                exacomple[12] = object[12].toString();
                exacomple[13] = object[13].toString();
                listExacomplexDoc.add(i, exacomple);
            }
        }
    }
    // </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc="SELECCION DE FILA PARA EDICION">    
    private String[] selectedExaCompren;

    public String[] getSelectedExaCompren() {
        return selectedExaCompren;
    }

    public void setSelectedExaCompren(String[] selectedExaCompren) {
        this.selectedExaCompren = selectedExaCompren;
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">  

    public void saveExaCompren() {
        RequestContext.getCurrentInstance().execute("cingdgeneral.hide()");
        ExamComplexivo exacompaux = new ExamComplexivo();
        ExamComplexivo exacompren = new ExamComplexivo();
        if (selectareaacaddoc != null) {
            try {
                exacompaux = examcomplexFacade.find(exacomplexdocpk);
                exacompren.setNroExamenCalif(numcalificadodoc);
                exacompren.setNroExamenPrepar(numpreparadosdoc);
                exacompren.setProfesor(profesor);
                if (exacompaux == null) {
                    exacomplexdocpk.setCodigoFacultad(selectareaacaddoc[2] == null ? null : Long.parseLong(selectareaacaddoc[2]));
                    exacomplexdocpk.setCodigoEscuela(selectareaacaddoc[4] == null ? null : Long.parseLong(selectareaacaddoc[4]));
                    exacomplexdocpk.setCodigoEsp(selectareaacaddoc[6] == null ? null : Long.parseLong(selectareaacaddoc[6]));
                    exacomplexdocpk.setCodigoNiveacad(selectareaacaddoc[0] == null ? null : Long.parseLong(selectareaacaddoc[0]));
                    exacomplexdocpk.setCodigoProfesor(codProfesor == null ? null : codProfesor);
                    exacomplexdocpk.setAnio(anio);
                    exacomplexdocpk.setCiclo(1);
                    exacompren.setExamComplexivoPK(exacomplexdocpk);
                    exacompren.setFechaCrea(new Date());
                    exacompren.setUsuarioCrea("Internet");
                    exacompren.setFechaUltmodific(new Date());
                    exacompren.setUsuarioUltmodific("Internet");
                    exacompren.setTipoexamen('M');
                    examcomplexFacade.create(exacompren);
                } else {
                    exacompren = exacompaux;
                    exacompren.setNroExamenCalif(numcalificadodoc);
                    exacompren.setNroExamenPrepar(numpreparadosdoc);
                    exacompren.setProfesor(profesor);
                    exacompren.setFechaUltmodific(new Date());
                    exacompren.setUsuarioUltmodific("Internet");
                    exacompren.setTipoexamen('M');
                    examcomplexFacade.edit(exacompren);
                }
                //Recupero los examenes complexivos                
                FacesMessage msg = new FacesMessage("Examen Final Guardado");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                recuperaExaCompren(profesor.getCodigoProfesor(), anio);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage("Error al Guardar Examen Final");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

            } finally {
                exacompren = new ExamComplexivo();
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe escoger una área", ""));
        }
        cancelExaCompren();
    }
// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">  

    public void editExaCompren() {
        if (selectedExaCompren != null) {
            RequestContext.getCurrentInstance().execute("cingdgeneral.show()");
            selectareaacaddoc = new String[11];
            selectareaacaddoc[0] = selectedExaCompren[0];
            selectareaacaddoc[1] = selectedExaCompren[10];
            selectareaacaddoc[2] = selectedExaCompren[7];
            selectareaacaddoc[3] = selectedExaCompren[9];
            selectareaacaddoc[4] = selectedExaCompren[8];
            selectareaacaddoc[5] = selectedExaCompren[11];
            selectareaacaddoc[6] = selectedExaCompren[1];
            selectareaacaddoc[7] = selectedExaCompren[5];
            selectareaacaddoc[10] = selectedExaCompren[13];
            numpreparadosdoc = Integer.parseInt(selectedExaCompren[5]);
            numcalificadodoc = Integer.parseInt(selectedExaCompren[6]);
            exacomplexdocpk.setCodigoFacultad(selectareaacaddoc[2] == null ? null : Long.parseLong(selectareaacaddoc[2]));
            exacomplexdocpk.setCodigoEscuela(selectareaacaddoc[4] == null ? null : Long.parseLong(selectareaacaddoc[4]));
            exacomplexdocpk.setCodigoEsp(selectareaacaddoc[6] == null ? null : Long.parseLong(selectareaacaddoc[6]));
            exacomplexdocpk.setCodigoNiveacad(selectareaacaddoc[0] == null ? null : Long.parseLong(selectareaacaddoc[0]));
            exacomplexdocpk.setCodigoProfesor(codProfesor == null ? null : codProfesor);
            exacomplexdocpk.setCiclo(1);
            exacomplexdocpk.setAnio(anio);
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar un examen a editar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON ELIMINAR">  

    public void DeleteExaCompren() {
        if (selectedExaCompren != null) {
            try {
                ExamComplexivo exacomplex = new ExamComplexivo();
                ExamComplexivoPK exacomplexdocpk = new ExamComplexivoPK();
                exacomplexdocpk.setCodigoFacultad(Long.parseLong(selectedExaCompren[7]));
                exacomplexdocpk.setCodigoEscuela(Long.parseLong(selectedExaCompren[8]));
                exacomplexdocpk.setCodigoEsp(Long.parseLong(selectedExaCompren[1]));
                exacomplexdocpk.setCodigoNiveacad(Long.parseLong(selectedExaCompren[0]));
                exacomplexdocpk.setCodigoProfesor(profesor.getCodigoProfesor());
                exacomplexdocpk.setAnio(anio);
                exacomplexdocpk.setCiclo(1);
                exacomplex = examcomplexFacade.find(exacomplexdocpk);
                examcomplexFacade.remove(exacomplex);
                listExacomplexDoc.remove(selectedExaCompren);
                //Recupero los examenes complexivos
                RequestContext.getCurrentInstance().update("finfoanual:acpinfoanual:infoacade:gexacomplexdoc");
                recuperaExaCompren(codProfesor, anio);

            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo borrar el Registro de: Examen Final", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            }
        } else {
            FacesMessage msg = new FacesMessage("Debe seleccionar un Examen Final a borrar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().update("finfoanual:messagedato");
        }

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">  

    public void cancelExaCompren() {
        selectedExaCompren = null;
        selectareaacaddoc = null;
        numpreparadosdoc = 0;
        numcalificadodoc = 0;
        exacomplexdocpk = new ExamComplexivoPK();
    }
    // </editor-fold> 
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="RECUPERAR AREA">  

    private void recuperarAreaAcad(Long anio) {
        listAreaUasb.clear();
        Vector v = new Vector();

        StringBuilder sql = new StringBuilder();
        sql.append("   SELECT distinct ESPECIALIZACION.CODIGO_NIVEACAD,   "
                + " NIVEL_ACADEMICO.NOMBRE_NIVEACAD,   "
                + " ESPECIALIZACION.CODIGO_FACULTAD,   "
                + " FACULTAD.NOMBRE_FACULTAD,   "
                + " ESPECIALIZACION.CODIGO_ESCUELA,   "
                + " ESCUELA.NOMBRE_ESCUELA,   "
                + " ESPECIALIZACION.CODIGO_ESP,   "
                + " ESPECIALIZACION.NOMBRE_ESP,   "
                + " ESPECIALIZACION.ANIO,   "
                + " ESPECIALIZACION.CICLO,  "
                + " NIVEL_ACADEMICO.NOMBRE_NIVEACAD +' EN '+ESCUELA.NOMBRE_ESCUELA +' MENCION: '+ESPECIALIZACION.NOMBRE_ESP  AS PROGRAMA"
                + " FROM ESPECIALIZACION,   "
                + " NIVEL_ACADEMICO,   "
                + " FACULTAD,   "
                + " ESCUELA  "
                + " WHERE  NIVEL_ACADEMICO.CODIGO_NIVEACAD = ESPECIALIZACION.CODIGO_NIVEACAD  and  "
                + "  ESPECIALIZACION.CODIGO_FACULTAD = FACULTAD.CODIGO_FACULTAD  and  "
                + "  ESCUELA.CODIGO_FACULTAD = ESPECIALIZACION.CODIGO_FACULTAD  and  "
                + "  ESCUELA.CODIGO_ESCUELA = ESPECIALIZACION.CODIGO_ESCUELA  and  "
                + "  ESPECIALIZACION.ANIO = ").append(anio).append(" AND  "
                + "  ESPECIALIZACION.CICLO = 1 and "
                + " NIVEL_ACADEMICO.CODIGO_NIVEACAD = 2"
                + " ORDER BY  FACULTAD.NOMBRE_FACULTAD ASC,   "
                + " ESCUELA.NOMBRE_ESCUELA ASC,   "
                + " ESPECIALIZACION.NOMBRE_ESP ASC, "
                + " NIVEL_ACADEMICO.NOMBRE_NIVEACAD ASC");

        v = (Vector) consultaFacade.ejecutaSqlList(sql.toString());
        if (v.size() > 0) {
            for (int i = 0; i < v.size(); i++) {
                Object[] object = (Object[]) v.get(i);
                String[] areaacad;
                areaacad = new String[11];
                areaacad[0] = object[0].toString();
                areaacad[1] = object[1].toString();
                areaacad[2] = object[2].toString();
                areaacad[3] = object[3].toString();
                areaacad[4] = object[4].toString();
                areaacad[5] = object[5].toString();
                areaacad[6] = object[6].toString();
                areaacad[7] = object[7].toString();
                areaacad[8] = object[8].toString();
                areaacad[9] = object[9].toString();
                areaacad[10] = object[10].toString();
                listAreaUasb.add(i, areaacad);
            }
        }
    }
    // </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc="RECUPERAR AREA DOCTORADO">  

    private void recuperarAreaAcadDoc(Long anio) {
        listAreaUasbDoc.clear();
        Vector v = new Vector();

        StringBuilder sql = new StringBuilder();
        sql.append("   SELECT distinct ESPECIALIZACION.CODIGO_NIVEACAD,   "
                + " NIVEL_ACADEMICO.NOMBRE_NIVEACAD,   "
                + " ESPECIALIZACION.CODIGO_FACULTAD,   "
                + " FACULTAD.NOMBRE_FACULTAD,   "
                + " ESPECIALIZACION.CODIGO_ESCUELA,   "
                + " ESCUELA.NOMBRE_ESCUELA,   "
                + " ESPECIALIZACION.CODIGO_ESP,   "
                + " ESPECIALIZACION.NOMBRE_ESP,   "
                + " ESPECIALIZACION.ANIO,   "
                + " ESPECIALIZACION.CICLO,  "
                + " NIVEL_ACADEMICO.NOMBRE_NIVEACAD +' EN '+ESCUELA.NOMBRE_ESCUELA +' MENCION: '+ESPECIALIZACION.NOMBRE_ESP  AS PROGRAMA"
                + " FROM ESPECIALIZACION,   "
                + " NIVEL_ACADEMICO,   "
                + " FACULTAD,   "
                + " ESCUELA  "
                + " WHERE  NIVEL_ACADEMICO.CODIGO_NIVEACAD = ESPECIALIZACION.CODIGO_NIVEACAD  and  "
                + "  ESPECIALIZACION.CODIGO_FACULTAD = FACULTAD.CODIGO_FACULTAD  and  "
                + "  ESCUELA.CODIGO_FACULTAD = ESPECIALIZACION.CODIGO_FACULTAD  and  "
                + "  ESCUELA.CODIGO_ESCUELA = ESPECIALIZACION.CODIGO_ESCUELA  and  "
                + "  ESPECIALIZACION.ANIO = ").append(anio).append(" AND  "
                + "  ESPECIALIZACION.CICLO = 1 and "
                + " NIVEL_ACADEMICO.CODIGO_NIVEACAD = 3"
                + " ORDER BY  FACULTAD.NOMBRE_FACULTAD ASC,   "
                + " ESCUELA.NOMBRE_ESCUELA ASC,   "
                + " ESPECIALIZACION.NOMBRE_ESP ASC, "
                + " NIVEL_ACADEMICO.NOMBRE_NIVEACAD ASC");

        v = (Vector) consultaFacade.ejecutaSqlList(sql.toString());
        if (v.size() > 0) {
            for (int i = 0; i < v.size(); i++) {
                Object[] object = (Object[]) v.get(i);
                String[] areaacad;
                areaacad = new String[11];
                areaacad[0] = object[0].toString();
                areaacad[1] = object[1].toString();
                areaacad[2] = object[2].toString();
                areaacad[3] = object[3].toString();
                areaacad[4] = object[4].toString();
                areaacad[5] = object[5].toString();
                areaacad[6] = object[6].toString();
                areaacad[7] = object[7].toString();
                areaacad[8] = object[8].toString();
                areaacad[9] = object[9].toString();
                areaacad[10] = object[10].toString();
                listAreaUasbDoc.add(i, areaacad);
            }
        }
    }
    // </editor-fold> 

    public void eliminarRegistro(ActionEvent ae) {
        switch (modal1.getActiveIndexAcoordion()) {
            case 0:
                switch (modal1.getActiveIndexTabviewdocencia()) {
                    case 1:
                        System.out.println(modal1.getBeandocencia());
                        DeleteAsigExt();
                        break;
                    case 3:
                        this.DeleteCotExt();
                        break;
                    case 5:
                        this.DeleteExaComplex();
                        break;
                    case 6:
                        this.DeleteExaCompren();
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
            case 0:
                switch (modal1.getActiveIndexTabviewdocencia()) {
                    case 1:
                        modal1.setUrlmodal("/pages/infoanual/docencia/asigExternaModal.xhtml");
                        break;
                    case 2:
                        modal1.setUrlmodal("/pages/infoanual/docencia/tesMonUasbModal.xhtml");
                        break;
                    /*case 5:
                        modal1.setUrlmodal("/pages/infoanual/docencia/tesMonExtModal.xhtml");
                        break;*/
                    case 5:
                        modal1.setUrlmodal("/pages/infoanual/docencia/exaFinalModal.xhtml");
                        break;
                    case 6:
                        modal1.setUrlmodal("/pages/infoanual/docencia/exaFinalDocModal.xhtml");
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
        int li_edit = 0;
        if (selectedAsigExt != null) {
        } else {
            if (tesimonografia != null) {
            } else {
                if (selectedCotExt != null) {
                } else {
                    if (selectedExacomplex != null) {
                    } else {
                        if(selectedExaCompren != null){
                        }else{
                            li_edit = -1;
                        }
                    }
                }
            }
        }
        if (li_edit == 0) {
            cargaPant(null);
        }
        if (modal1.getActiveIndexAcoordion() == 0) {
            switch (modal1.getActiveIndexTabviewdocencia()) {
                case 1:
                    EditAsigExt();
                    break;
                case 2:
                    EditTitMonUsab();
                    break;
                case 3:
                    EditCotExt();
                    break;
                case 5:
                    EditExaComplex();
                    break;
                case 6:
                    editExaCompren();
                    break;
                default:
                    break;
            }
        }
    }

    public void onRowSelect(SelectEvent event) {
        if (modal1.getActiveIndexAcoordion() == 0) {
            switch (modal1.getActiveIndexTabviewdocencia()) {
                case 1:
                    selectedAsigExt = (OtraActividadAcademica) event.getObject();
                    break;
                case 2:
                    tesimonografia = (String[]) event.getObject();
                    break;
                case 3:
                    selectedCotExt = (OtraActividadAcademica) event.getObject();
                    break;
                case 5:
                    selectedExacomplex = (String[]) event.getObject();
                    break;
                case 6:
                    selectedExaCompren = (String[]) event.getObject();
                    break;
            }
        }
    }

    private void reset() {
        selectedAsigExt = null;
        tesimonografia = null;
        selectedCotExt = null;
        selectedExacomplex = null;
        selectedExaCompren = null;
    }

    public void onRowUnselect(UnselectEvent event) {
        reset();
    }
}
