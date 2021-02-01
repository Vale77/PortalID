/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.form.bean;


import ec.edu.uasb.bean.NavigationJSFManagedBean;
import ec.edu.uasb.form.FormField;
import ec.edu.uasb.portaldoc.form.datamodel.DocenteEncuestaDatamodel;
import ec.edu.uasb.portaldoc.form.datamodel.EncuEvalDocente;
import ec.edu.uasb.portaldoc.form.entities.Pregunta;
import ec.edu.uasb.portaldoc.form.entities.Respuesta;
import ec.edu.uasb.portaldoc.form.entities.RespuestaPK;
import ec.edu.uasb.portaldoc.form.session.EncuestaRealizadaFacadeLocal;
import ec.edu.uasb.portaldoc.form.session.PreguntaFacadeLocal;
import ec.edu.uasb.seg.entities.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.extensions.model.dynaform.DynaFormControl;
import org.primefaces.extensions.model.dynaform.DynaFormLabel;
import org.primefaces.extensions.model.dynaform.DynaFormModel;
import org.primefaces.extensions.model.dynaform.DynaFormRow;

/**
 *
 * @author victor.barba
 */
@ManagedBean(name = "docenteFormBean")
@ViewScoped
public class DocenteFormJSFManagedBean implements Serializable {

    private static final long serialVersionUID = 20120425L;
    @EJB
    private EncuestaRealizadaFacadeLocal encuestaRealizadaFacade;
    @EJB
    private PreguntaFacadeLocal preguntaFacade;
    private Long codCordinador;
    private List catalogo = new ArrayList();
    private DocenteEncuestaDatamodel encuestaDatamodel;
    private Object objSelected;
    private List<SelectItem> opcRadio = new ArrayList<SelectItem>();
    private List<SelectItem> opcRadioSino = new ArrayList<SelectItem>();
    private List<SelectItem> opcTitulos = new ArrayList<SelectItem>();
    private DynaFormModel modelo = new DynaFormModel();
    private List<Pregunta> preguntas;
    @ManagedProperty(value = "#{navigationMgmtBean}")
    private NavigationJSFManagedBean navJSFManagedBean;
    private String openPage = "/WEB-INF/templates/includes/sinContenido";

    public String getOpenPage() {
        return openPage;
    }

    public void setOpenPage(String openPage) {
        this.openPage = openPage;
    }

    //<editor-fold defaultstate="collapsed" desc="Propiedades ">
    public Object getObjSelected() {
        return objSelected;
    }

    public void setObjSelected(Object objSelected) {
        this.objSelected = objSelected;
    }

    public DocenteEncuestaDatamodel getEncuestaDatamodel() {
        return encuestaDatamodel;
    }

    public void setEncuestaDatamodel(DocenteEncuestaDatamodel encuestaDatamodel) {
        this.encuestaDatamodel = encuestaDatamodel;
    }

    /**
     * @param navJSFManagedBean the navJSFManagedBean to set
     */
    public void setNavJSFManagedBean(NavigationJSFManagedBean navJSFManagedBean) {
        this.navJSFManagedBean = navJSFManagedBean;
    }

    /**
     * @return the modelo
     */
    public DynaFormModel getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(DynaFormModel modelo) {
        this.modelo = modelo;
    }
    //</editor-fold>

    /**
     * Creates a new instance of DocenteFormJSFManagedBean
     */
    public DocenteFormJSFManagedBean() {
        opcRadio.add(new SelectItem(1, ""));
        opcRadio.add(new SelectItem(2, ""));
        opcRadio.add(new SelectItem(3, ""));
        opcRadio.add(new SelectItem(4, ""));
        opcRadio.add(new SelectItem(5, ""));
        opcTitulos.add(new SelectItem(1, "Deficiente"));
        opcTitulos.add(new SelectItem(2, "Regular"));
        opcTitulos.add(new SelectItem(3, "Bueno"));
        opcTitulos.add(new SelectItem(4, "Muy Bueno"));
        opcTitulos.add(new SelectItem(5, "Excelente"));
        opcRadioSino.add(new SelectItem("1", "Si"));
        opcRadioSino.add(new SelectItem("0", "No"));
    }

    @PostConstruct
    public void init() {
        Usuario usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        codCordinador = usr.getUsuCodigo();
        catalogo = encuestaRealizadaFacade.encuestasDisponibles(codCordinador, "EVAL_DOCENTE");
        encuestaDatamodel = new DocenteEncuestaDatamodel(catalogo);
        objSelected = null;
    }

    private void retrieveFormulario(long enc) {
        modelo = new DynaFormModel();
        preguntas = preguntaFacade.findByEncuesta(enc);
        int nroPreguntas = preguntas.size();
        DynaFormRow fila;
        int j = 0;
        DynaFormLabel label[] = new DynaFormLabel[nroPreguntas];
        DynaFormControl control[] = new DynaFormControl[nroPreguntas];
        for (int i = 0; i < nroPreguntas; i++) {
            Pregunta pregunta = preguntas.get(i);
            fila = getModelo().createRegularRow();
            if (!pregunta.getTipo().equals('4')) {
                if (!pregunta.getTipo().equals('5')) {
                    j++;
                    label[i] = fila.addLabel(j + ". " + pregunta.getDescripcion(), 1, 1);
                } else {
                    label[i] = fila.addLabel(pregunta.getDescripcion(), 1, 1);
                }
                if (pregunta.getTipo().equals('1')) {
                    control[i] = fila.addControl(new FormField("", pregunta, opcRadio, true), "radiochoice", 1, 1);
                } else if (pregunta.getTipo().equals('2')) {
                    control[i] = fila.addControl(new FormField(pregunta, false), "textarea", 1, 1);
                } else if (pregunta.getTipo().equals('3')) {
                    control[i] = fila.addControl(new FormField("", pregunta, opcRadioSino, true), "radiochoice", 1, 1);
                } else if (pregunta.getTipo().equals('5')) {
                    control[i] = fila.addControl(new FormField("", pregunta, opcTitulos, false), "radiochoiceTit", 1, 1);
                }
                label[i].setForControl(control[i]);
            } else {
                fila.addControl(pregunta.getDescripcion(), "separator", 3, 1);
                j = 0;
            }
        }
    }

    public void onRowSelect(SelectEvent se) {
        if (objSelected != null) {
            EncuEvalDocente encuEvalDocente = (EncuEvalDocente) se.getObject();
            navJSFManagedBean.setOpenPage("/pages/formulario");
            modelo = new DynaFormModel();
            if (!encuEvalDocente.getEstado().equals("1") && encuEvalDocente.getHabilitado().equals("S"))  {
                retrieveFormulario(encuEvalDocente.getCodigoEncuesta());
            }
        }
    }

    public void onRowUnselect(UnselectEvent se) {
        modelo = new DynaFormModel();
    }

    public void saveBtn_actionProccess(ActionEvent ae) {
        boolean ok = true;
        String msgError = null;
        EncuEvalDocente encuEvalDocente = (EncuEvalDocente) objSelected;
        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        for (DynaFormControl dynaFormControl : getModelo().getControls()) {
            if (dynaFormControl.getData() instanceof FormField) {
                FormField ff = (FormField) dynaFormControl.getData();
                if (!dynaFormControl.getType().equals("radiochoiceTit")) {
                    if (ff.isRequired() && (ff.getValue() == null || StringUtils.isBlank(ff.getValue().toString()))) {
                        ok = false;
                        msgError = "Por favor, haga una revisión del formulario";
                        break;
                    } else {
                        if (ff.getValue() != null && StringUtils.isNotBlank(ff.getValue().toString())) {
//                            System.out.println(" dynaFormControl.getKey()" + ((Pregunta) ff.getKey()).getPreguntaPK().getCodigoPregunta() + " dynaFormControl.getKey()" + dynaFormControl.getKey() + " dynaFormControl.getRow() " + dynaFormControl.getRow() + " ff.getValue() " + ff.getValue() + "  " + dynaFormControl.getType());
                            Respuesta resp = new Respuesta();
                            RespuestaPK respPK = new RespuestaPK();
                            respPK.setAnio(encuEvalDocente.getEncuEvalDocentePK().getAnio());
                            respPK.setCiclo(encuEvalDocente.getCiclo());
                            respPK.setCodigoEncuesta(encuEvalDocente.getCodigoEncuesta());
                            respPK.setCodigoMateria(encuEvalDocente.getEncuEvalDocentePK().getCodigoMateria());
                            respPK.setCodigoProfesor(encuEvalDocente.getEncuEvalDocentePK().getCodigoProfesor());
                            respPK.setCodigoPregunta(((Pregunta) ff.getKey()).getPreguntaPK().getCodigoPregunta());
                            respPK.setCodigoEsp(encuEvalDocente.getEncuEvalDocentePK().getCodigoEsp());
                            respPK.setCodigoNivel(encuEvalDocente.getEncuEvalDocentePK().getCodigoNivel());
                            respPK.setCodigoParalelo(encuEvalDocente.getEncuEvalDocentePK().getCodigoParalelo());
                            resp.setRespuestaPK(respPK);
                            resp.setFecha(new Date());

                            if (!dynaFormControl.getType().equals("textarea")) {
                                resp.setValor(new Long(ff.getValue().toString()));
                            } else {
                                resp.setTexto(ff.getValue().toString());
                            }
                            respuestas.add(resp);
                        }
                    }
                }
            }
        }
        if (ok) {
            msgError = encuestaRealizadaFacade.createEncuesta(codCordinador, encuEvalDocente, respuestas, FacesContext.getCurrentInstance(),"Coordinados");
        } else {
            msgError = "No ha contestado todas las preguntas. " + msgError;
        }

        navJSFManagedBean.setMsgError(msgError);
        if (msgError == null) {
            RequestContext.getCurrentInstance().execute("window.location.reload();");
            respuestas = null;
        }
    }

    public String submitForm() {
        FacesMessage.Severity sev = FacesContext.getCurrentInstance().getMaximumSeverity();
        boolean hasErrors = (sev != null && (FacesMessage.SEVERITY_ERROR.compareTo(sev) >= 0));
        RequestContext.getCurrentInstance().addCallbackParam("isValid", !hasErrors && navJSFManagedBean.getMsgError() != null);
        return null;
    }
}
