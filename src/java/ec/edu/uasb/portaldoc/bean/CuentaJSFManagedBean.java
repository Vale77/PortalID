/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.bean;

import ec.edu.uasb.bean.NavigationJSFManagedBean;
import ec.edu.uasb.entities.Apelativo;
import ec.edu.uasb.entities.Ciudad;
import ec.edu.uasb.entities.Nacionalidad;
import ec.edu.uasb.entities.Pais;
import ec.edu.uasb.infoanual.entities.Profesor;
import ec.edu.uasb.session.ApelativoFacadeLocal;
import ec.edu.uasb.session.NacionalidadFacadeLocal;
import ec.edu.uasb.session.PaisFacadeLocal;
import ec.edu.uasb.infoanual.session.ProfesorFacadeLocal;
import ec.edu.uasb.entities.Canton;
import ec.edu.uasb.entities.Parroquia;
import ec.edu.uasb.entities.Provincia;
import ec.edu.uasb.session.CantonFacadeLocal;
import ec.edu.uasb.session.ParroquiaFacadeLocal;
import ec.edu.uasb.session.ProvinciaFacadeLocal;
import ec.edu.uasb.seg.entities.Usuario;
import ec.edu.uasb.session.CiudadFacadeLocal;
import ec.edu.uasb.utils.JsfUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author victor.barba
 */
@ManagedBean(name = "cuentaBean")
@ViewScoped
public class CuentaJSFManagedBean {
    
    @EJB
    private ApelativoFacadeLocal apelativoFacade;
    @EJB
    private NacionalidadFacadeLocal nacionalidadFacade;
    @EJB
    private ParroquiaFacadeLocal parroquiaFacade;
    @EJB
    private ProvinciaFacadeLocal provinciaFacade;
    @EJB
    private CantonFacadeLocal cantonFacade;
    @EJB
    private CiudadFacadeLocal ciudadFacade;
    @EJB
    private PaisFacadeLocal paisFacade;
    @EJB
    private ProfesorFacadeLocal profesorFacade;
    private Usuario usr;
    private Profesor profesor;
    private List<Pais> listPaises = new ArrayList<Pais>();
    private List<Ciudad> listCiudades = new ArrayList<Ciudad>();
    private List<Pais> listPaisesDom = new ArrayList<Pais>();
    private List<Ciudad> listCiudadesDom = new ArrayList<Ciudad>();
    private List<Pais> listPaisesTrab = new ArrayList<Pais>();
    private List<Ciudad> listCiudadesTrab = new ArrayList<Ciudad>();
    private List<Canton> listCantones = new ArrayList<Canton>();
    private List<Parroquia> listParroquias = new ArrayList<Parroquia>();
    private List<Provincia> listProvincias = new ArrayList<Provincia>();
    private List<Nacionalidad> listNacionalidad = new ArrayList<Nacionalidad>();
    private List<Apelativo> listApelativos = new ArrayList<Apelativo>();
    private boolean editarFicha = true;
    @ManagedProperty(value = "#{navigationMgmtBean}")
    private NavigationJSFManagedBean navJSFManagedBean;

    //<editor-fold defaultstate="collapsed" desc="Propiedades ">
    /**
     * @param navJSFManagedBean the navJSFManagedBean to set
     */
    public void setNavJSFManagedBean(NavigationJSFManagedBean navJSFManagedBean) {
        this.navJSFManagedBean = navJSFManagedBean;
    }

    /**
     * @return the profesor
     */
    public Profesor getProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    /**
     * @return the listPaises
     */
    public List<Pais> getListPaises() {
        return listPaises;
    }

    /**
     * @param listPaises the listPaises to set
     */
    public void setListPaises(List<Pais> listPaises) {
        this.listPaises = listPaises;
    }

    /**
     * @return the listCiudades
     */
    public List<Ciudad> getListCiudades() {
        return listCiudades;
    }

    /**
     * @param listCiudades the listCiudades to set
     */
    public void setListCiudades(List<Ciudad> listCiudades) {
        this.listCiudades = listCiudades;
    }

    /**
     * @return the listCantones
     */
    public List<Canton> getListCantones() {
        return listCantones;
    }

    /**
     * @param listCantones the listCantones to set
     */
    public void setListCantones(List<Canton> listCantones) {
        this.listCantones = listCantones;
    }

    /**
     * @return the listParroquias
     */
    public List<Parroquia> getListParroquias() {
        return listParroquias;
    }

    /**
     * @param listParroquias the listParroquias to set
     */
    public void setListParroquias(List<Parroquia> listParroquias) {
        this.listParroquias = listParroquias;
    }

    /**
     * @return the listProvincias
     */
    public List<Provincia> getListProvincias() {
        return listProvincias;
    }

    /**
     * @param listProvincias the listProvincias to set
     */
    public void setListProvincias(List<Provincia> listProvincias) {
        this.listProvincias = listProvincias;
    }

    /**
     * @return the listNacionalidad
     */
    public List<Nacionalidad> getListNacionalidad() {
        return listNacionalidad;
    }

    /**
     * @param listNacionalidad the listNacionalidad to set
     */
    public void setListNacionalidad(List<Nacionalidad> listNacionalidad) {
        this.listNacionalidad = listNacionalidad;
    }

    /**
     * @return the listApelativos
     */
    public List<Apelativo> getListApelativos() {
        return listApelativos;
    }

    /**
     * @param listApelativos the listApelativos to set
     */
    public void setListApelativos(List<Apelativo> listApelativos) {
        this.listApelativos = listApelativos;
    }

    /**
     * @return the listPaisesDom
     */
    public List<Pais> getListPaisesDom() {
        return listPaisesDom;
    }

    /**
     * @param listPaisesDom the listPaisesDom to set
     */
    public void setListPaisesDom(List<Pais> listPaisesDom) {
        this.listPaisesDom = listPaisesDom;
    }

    /**
     * @return the listCiudadesDom
     */
    public List<Ciudad> getListCiudadesDom() {
        return listCiudadesDom;
    }

    /**
     * @param listCiudadesDom the listCiudadesDom to set
     */
    public void setListCiudadesDom(List<Ciudad> listCiudadesDom) {
        this.listCiudadesDom = listCiudadesDom;
    }

    /**
     * @return the listPaisesTrab
     */
    public List<Pais> getListPaisesTrab() {
        return listPaisesTrab;
    }

    /**
     * @param listPaisesTrab the listPaisesTrab to set
     */
    public void setListPaisesTrab(List<Pais> listPaisesTrab) {
        this.listPaisesTrab = listPaisesTrab;
    }

    /**
     * @return the listCiudadesTrab
     */
    public List<Ciudad> getListCiudadesTrab() {
        return listCiudadesTrab;
    }

    /**
     * @param listCiudadesTrab the listCiudadesTrab to set
     */
    public void setListCiudadesTrab(List<Ciudad> listCiudadesTrab) {
        this.listCiudadesTrab = listCiudadesTrab;
    }

    /**
     * @return the editarFicha
     */
    public boolean isEditarFicha() {
        return editarFicha;
    }

    /**
     * @param editarFicha the editarFicha to set
     */
    public void setEditarFicha(boolean editarFicha) {
        this.editarFicha = editarFicha;
    }
    //</editor-fold>

    /**
     * Creates a new instance of CuentaJSFManagedBean
     */
    public CuentaJSFManagedBean() {
        usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
    }
    
    public static List<Pais> cloneList(List<Pais> list) {
        List<Pais> clone = new ArrayList<Pais>(list.size());
        for (Pais item : list) {
            clone.add(item.clone());
        }
        return clone;
    }
    
    public static List<Ciudad> cloneListCiu(List<Ciudad> list) {
        List<Ciudad> clone = new ArrayList<Ciudad>(list.size());
        for (Ciudad item : list) {
            clone.add(item.clone());
        }
        return clone;
    }
    
    @PostConstruct
    private void recuperarDatos() {
        profesor = profesorFacade.finbyCodigo(usr.getUsuCodigo());
        listPaises = paisFacade.findAllorde();
        listPaisesDom = cloneList(listPaises);
        listPaisesTrab = cloneList(listPaises);
        listApelativos = apelativoFacade.findAllOrdenados();
        listNacionalidad = nacionalidadFacade.findAllOrdenados();
        recuperarListas();
    }
    
    public void recuperarListas() {
        if (profesor.getCodPaisOrigen() != null) {
            listCiudades = ciudadFacade.finbyPais(profesor.getCodPaisOrigen());
            if (profesor.getCodPaisOrigen().equals("1")) {
                listProvincias = provinciaFacade.findByPais(profesor.getCodPaisOrigen());
                if (profesor.getCodigoProvincia() != null) {
                    listCantones = cantonFacade.findByPaisAndProv(profesor.getCodPaisOrigen(), profesor.getCodigoProvincia());
                    listParroquias = parroquiaFacade.findByPaisAndProvAndCan(profesor.getCodPaisOrigen(), profesor.getCodigoProvincia(), profesor.getCodigoCanton());
                }
            }
        }
        if (profesor.getPaisDomProfesor() != null) {
            listCiudadesDom = ciudadFacade.finbyPais(profesor.getPaisDomProfesor());
        }
        if (profesor.getPaisTrabProfesor() != null) {
            listCiudadesTrab = ciudadFacade.finbyPais(profesor.getPaisTrabProfesor());
        }
    }
    
    public void cargarListas(String tipo) {
        if (tipo.equals("Canton")) {
            profesor.setCodigoParroquia(null);
            profesor.setCodigoCanton(null);
            listCantones = cantonFacade.findByPaisAndProv(profesor.getCodPaisOrigen(), profesor.getCodigoProvincia());
        } else if (tipo.equals("Parr")) {
            profesor.setCodigoParroquia(null);
            listParroquias = parroquiaFacade.findByPaisAndProvAndCan(profesor.getCodPaisOrigen(), profesor.getCodigoProvincia(), profesor.getCodigoCanton());
        }
    }
    
    public void cargarCiudades(String tipo) {
        if (tipo.equals("Nacim")) {
            profesor.setCodigoProvincia(null);
            profesor.setCodigoCanton(null);
            profesor.setCodigoParroquia(null);
            profesor.setCodCiudadOrigen(null);
            listCiudades = ciudadFacade.finbyPais(profesor.getCodPaisOrigen());
        } else if (tipo.equals("Dom")) {
            profesor.setCiudadDomProfesor(null);
            listCiudadesDom = ciudadFacade.finbyPais(profesor.getPaisDomProfesor());
        } else if (tipo.equals("Trab")) {
            profesor.setCiudadTrabProfesor(null);
            listCiudadesTrab = ciudadFacade.finbyPais(profesor.getPaisTrabProfesor());
        }
        
    }

    public void editarButton_processAction(ActionEvent ae) {
        editarFicha = false;
    }
    
    public void guardarDatosButton_processAction(ActionEvent ae) {
        try {
            Apelativo apelativo = new Apelativo(profesor.getApelativo().getCodigoApelativo());
            profesor.setApelativo(apelativo);
            Nacionalidad nac = new Nacionalidad(profesor.getNacionalidad().getCodigoNacionalidad());
            profesor.setNacionalidad(nac);
            profesor.setFechaUltmodific(new Date());
            profesor.setUsuarioUltmodific(usr.getUsuCedPass());            
            profesorFacade.edit(profesor, FacesContext.getCurrentInstance());
            editarFicha = true;
            profesor = profesorFacade.finbyCodigo(usr.getUsuCodigo());
            recuperarListas();
            JsfUtil.addSuccessMessage(null, "Datos actualizados");
            RequestContext.getCurrentInstance().update("formFicha");
        } catch (Exception e) {
            JsfUtil.addErrorMessage(null, "No puedo actualizar los datos.");
            navJSFManagedBean.setMsgError("No puedo actualizar los datos.");
            RequestContext.getCurrentInstance().update("dialogMessage");
            RequestContext.getCurrentInstance().execute("errorWidget.show();");
        }
    }
    
    public String cancelarDatosButton_processAction() {
        editarFicha = true;
        profesor = profesorFacade.finbyCodigo(usr.getUsuCodigo());
        return null;
    }
}
