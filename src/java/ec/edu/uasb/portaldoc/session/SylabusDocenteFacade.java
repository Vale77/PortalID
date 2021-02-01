/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.session;

import ec.edu.uasb.bean.exceptions.SyllabusException;
import ec.edu.uasb.portaldoc.entities.AsignaturaSyllabus;
import ec.edu.uasb.portaldoc.entities.Coordinador;
import ec.edu.uasb.portaldoc.entities.SylabusDocente;
import ec.edu.uasb.portaldoc.entities.SylabusDocentePK;
import ec.edu.uasb.seg.entities.Usuario;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author victor.barba
 */
@Stateless
public class SylabusDocenteFacade extends AbstractFacade<SylabusDocente> implements SylabusDocenteFacadeLocal {

    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @EJB
    private SylabusContenidoFacadeLocal sylabusContenidoFacade;
    @EJB
    private SylabusBiblioFacadeLocal sylabusBiblioFacade;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SylabusDocenteFacade() {
        super(SylabusDocente.class);
    }

    @Override
    public SylabusDocente findById(AsignaturaSyllabus docentePK) throws SyllabusException {
        SylabusDocente c = null;
        try {
            StringBuilder sb = new StringBuilder("SELECT s FROM SylabusDocente s");
            sb.append(" WHERE s.sylabusDocentePK.anio = ").append(docentePK.getAnio())
                    .append(" and s.sylabusDocentePK.ciclo = ").append(docentePK.getCiclo())
                    .append(" and s.sylabusDocentePK.codigoMateria = ").append(docentePK.getAsignaturaSyllabusPK().getCodigoMateria())
                    .append(" and s.sylabusDocentePK.codigoProfesor = ").append(docentePK.getAsignaturaSyllabusPK().getCodigoProfesor())
                    .append(" and s.sylabusDocentePK.codigoNivel = ").append(docentePK.getAsignaturaSyllabusPK().getCodigoNivel())
                    .append(" and s.sylabusDocentePK.vacCodnum = ").append(docentePK.getAsignaturaSyllabusPK().getVacCodnum())
                    .append(" and s.sylabusDocentePK.codParalelo = ").append(docentePK.getAsignaturaSyllabusPK().getCodParalelo())
                    .append(" and s.sylabusDocentePK.codPrograma = ").append(docentePK.getAsignaturaSyllabusPK().getCodPrograma());
            Query q = em.createQuery(sb.toString());
            c = (SylabusDocente) q.setHint("eclipselink.refresh", true).getSingleResult();
        } catch (NoResultException ex) {
            throw new SyllabusException("No existe sílabo registrado! ");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }

    @Override
    public void enviaCorreo(String profile_name, String recipients, String copy_recipients, String blind_copy_recipients, String psubject, String pmensaje, String body_format) {
        Query query = em.createNativeQuery("{call msdb.dbo.sp_send_dbmail(?,?,?,?,?,?,?)}");
        query.setParameter(1, profile_name);
        query.setParameter(2, recipients);
        query.setParameter(3, copy_recipients);
        query.setParameter(4, blind_copy_recipients);
        query.setParameter(5, psubject);
        query.setParameter(6, pmensaje);
        query.setParameter(7, body_format);
        query.executeUpdate();
    }

    @Override
    public void registraMoodle(Long anio, Long codigoMateria) {
        Query query = em.createNativeQuery("EXEC dbo.sp_registraMoodle @anio = ?,@asignatura = ?");
        query.setParameter(1, anio);
        query.setParameter(2, codigoMateria);
        query.executeUpdate();
    }

    @Override
    public void copy(AsignaturaSyllabus copiaSelected, AsignaturaSyllabus asignaturaSelected, Usuario usr) {
        SylabusDocente newSy;
        SylabusDocentePK newSpk = new SylabusDocentePK(copiaSelected.getAnio(), copiaSelected.getCiclo(), copiaSelected.getAsignaturaSyllabusPK().getCodigoMateria(),
                copiaSelected.getAsignaturaSyllabusPK().getCodigoProfesor(), copiaSelected.getAsignaturaSyllabusPK().getCodigoNivel(),
                copiaSelected.getAsignaturaSyllabusPK().getVacCodnum(), copiaSelected.getAsignaturaSyllabusPK().getCodParalelo(), copiaSelected.getAsignaturaSyllabusPK().getCodPrograma());

        SylabusDocente newOriginal = em.find(SylabusDocente.class,
                new SylabusDocentePK(asignaturaSelected.getAnio(), asignaturaSelected.getCiclo(), asignaturaSelected.getAsignaturaSyllabusPK().getCodigoMateria(),
                        asignaturaSelected.getAsignaturaSyllabusPK().getCodigoProfesor(), asignaturaSelected.getAsignaturaSyllabusPK().getCodigoNivel(),
                        asignaturaSelected.getAsignaturaSyllabusPK().getVacCodnum(), asignaturaSelected.getAsignaturaSyllabusPK().getCodParalelo(), asignaturaSelected.getAsignaturaSyllabusPK().getCodPrograma()));
        if (copiaSelected.getExiste() == 0) {
            newSy = new SylabusDocente(newSpk);
        } else {
            newSy = em.find(SylabusDocente.class, newSpk);
        }
        newSy.setNumeroClases(newOriginal.getNumeroClases());
        newSy.setNumeroCreditos(newOriginal.getNumeroCreditos());
        newSy.setModalidad(newOriginal.getModalidad());
        newSy.setHorario(newOriginal.getHorario());
        newSy.setDescripcionMateria(newOriginal.getDescripcionMateria());
        newSy.setObjetivoGeneral(newOriginal.getObjetivoGeneral());
        newSy.setObjetivoEspecifico(newOriginal.getObjetivoEspecifico());
        newSy.setArticAmbiCurricular(newOriginal.getArticAmbiCurricular());
        newSy.setArticCampFormacion(newOriginal.getArticCampFormacion());
        newSy.setArticOtrasCarac(newOriginal.getArticOtrasCarac());
        newSy.setArticUnidCurricular(newOriginal.getArticUnidCurricular());
        newSy.setProcesoDocente(newOriginal.getProcesoDocente());
        newSy.setProcesoDocenteAcomp(newOriginal.getProcesoDocenteAcomp());
        newSy.setProcesoDocenteActiv(newOriginal.getProcesoDocenteActiv());
        newSy.setEvaluacion(newOriginal.getEvaluacion());
        newSy.setEvaluacionElementos(newOriginal.getEvaluacionElementos());
        newSy.setBibliografia(newOriginal.getBibliografia());
        newSy.setObservaciones(newOriginal.getObservaciones());
        newSy.setObservacionesUtilRec(newOriginal.getObservacionesUtilRec());
        newSy.setCoaHorasParcticas(newOriginal.getCoaHorasParcticas());
        newSy.setCoaTrabajoAutonomo(newOriginal.getCoaTrabajoAutonomo());
        newSy.setCcdSeguimientoTutoria(newOriginal.getCcdSeguimientoTutoria());
        newSy.setLugarAtencion(newOriginal.getLugarAtencion());
        newSy.setFechaCrea(new Date());
        newSy.setFechaUltmodific(newSy.getFechaCrea());
        newSy.setUsuarioCrea(usr.getUsuCedPass());
        newSy.setUsuarioUltmodific(usr.getUsuCedPass());
        newSy.setEstadoSylabus('P');
        newSy.setEstadoEnvio('P');
//        SylabusContenidoPK scPKOriginal = new SylabusContenidoPK(asignaturaSelected.getAnio(), asignaturaSelected.getCiclo(),
//                asignaturaSelected.getAsignaturaSyllabusPK().getCodigoMateria(), asignaturaSelected.getAsignaturaSyllabusPK().getCodigoNivel(),
//                asignaturaSelected.getAsignaturaSyllabusPK().getVacCodnum(), asignaturaSelected.getAsignaturaSyllabusPK().getCodParalelo(),
//                asignaturaSelected.getAsignaturaSyllabusPK().getCodPrograma(), asignaturaSelected.getAsignaturaSyllabusPK().getCodigoProfesor(), null, 'C');

        if (copiaSelected.getExiste() == 0) {
            em.persist(newSy);
        } else {
            newSy.setAprobadoPor(null);
            newSy.setFechaAprobacion(null);
            newSy.setObservacionCoordinador(null);
            em.merge(newSy);
            eliminarDetalles(copiaSelected);
        }
        insertarDetalles(copiaSelected, asignaturaSelected);
    }

    private void eliminarDetalles(AsignaturaSyllabus copiaSelected) {
        StringBuilder sb = new StringBuilder();
        sb.append(" DELETE FROM interfaseOcu.dbo.SYLABUS_CONTENIDO ")
                .append(" WHERE ANIO = ? and CICLO = 1 and CODIGO_MATERIA = ? and CODIGO_PROFESOR = ? and CODIGO_NIVEL = ? ")
                .append(" and VAC_CODNUM = ? and COD_PARALELO = ?  and COD_PROGRAMA = ? and TIPO = 'C' ");
        Query q = em.createNativeQuery(sb.toString());
        q.setParameter(1, copiaSelected.getAnio());
        q.setParameter(2, copiaSelected.getAsignaturaSyllabusPK().getCodigoMateria());
        q.setParameter(3, copiaSelected.getAsignaturaSyllabusPK().getCodigoProfesor());
        q.setParameter(4, copiaSelected.getAsignaturaSyllabusPK().getCodigoNivel());
        q.setParameter(5, copiaSelected.getAsignaturaSyllabusPK().getVacCodnum());
        q.setParameter(6, copiaSelected.getAsignaturaSyllabusPK().getCodParalelo());
        q.setParameter(7, copiaSelected.getAsignaturaSyllabusPK().getCodPrograma());
        q.executeUpdate();
        sb = new StringBuilder();
        sb.append(" DELETE FROM interfaseOcu.dbo.SYLABUS_BIBLIO ")
                .append(" WHERE ANIO = ? and CICLO = 1 and CODIGO_MATERIA = ? and CODIGO_PROFESOR = ? and CODIGO_NIVEL = ? ")
                .append(" and VAC_CODNUM = ? and COD_PARALELO = ?  and COD_PROGRAMA = ? ");
        q = em.createNativeQuery(sb.toString());
        q.setParameter(1, copiaSelected.getAnio());
        q.setParameter(2, copiaSelected.getAsignaturaSyllabusPK().getCodigoMateria());
        q.setParameter(3, copiaSelected.getAsignaturaSyllabusPK().getCodigoProfesor());
        q.setParameter(4, copiaSelected.getAsignaturaSyllabusPK().getCodigoNivel());
        q.setParameter(5, copiaSelected.getAsignaturaSyllabusPK().getVacCodnum());
        q.setParameter(6, copiaSelected.getAsignaturaSyllabusPK().getCodParalelo());
        q.setParameter(7, copiaSelected.getAsignaturaSyllabusPK().getCodPrograma());
        q.executeUpdate();
    }

    private void insertarDetalles(AsignaturaSyllabus copiaSelected, AsignaturaSyllabus asignaturaSelected) {
        StringBuilder sb = new StringBuilder();
        sb.append(" INSERT INTO interfaseOcu.dbo.SYLABUS_CONTENIDO ")
                .append(" (ANIO ,CICLO  ,CODIGO_MATERIA  ,CODIGO_PROFESOR  ,CODIGO_NIVEL  ,VAC_CODNUM  ,COD_PARALELO, COD_PROGRAMA , ")
                .append(" TIPO ,TEMA  ,CLASE  ,SUBTEMA  ,ORDEN  ,BIBLIOGRAFIA ) ")
                .append(" SELECT ANIO, CICLO, ?, ?, ?, ?, ?, ?,  TIPO, TEMA, CLASE, SUBTEMA, ORDEN, BIBLIOGRAFIA ")
                .append(" FROM interfaseOcu.dbo.SYLABUS_CONTENIDO ")
                .append(" WHERE ANIO = ? and CICLO = ? and CODIGO_MATERIA = ? and CODIGO_PROFESOR = ? and CODIGO_NIVEL = ? ")
                .append(" and VAC_CODNUM = ? and COD_PARALELO = ?  and COD_PROGRAMA = ? and TIPO = 'C' ");
        Query q = em.createNativeQuery(sb.toString());
        q.setParameter(1, copiaSelected.getAsignaturaSyllabusPK().getCodigoMateria());
        q.setParameter(2, copiaSelected.getAsignaturaSyllabusPK().getCodigoProfesor());
        q.setParameter(3, copiaSelected.getAsignaturaSyllabusPK().getCodigoNivel());
        q.setParameter(4, copiaSelected.getAsignaturaSyllabusPK().getVacCodnum());
        q.setParameter(5, copiaSelected.getAsignaturaSyllabusPK().getCodParalelo());
        q.setParameter(6, copiaSelected.getAsignaturaSyllabusPK().getCodPrograma());
        q.setParameter(7, asignaturaSelected.getAnio()).setParameter(8, asignaturaSelected.getCiclo());
        q.setParameter(9, asignaturaSelected.getAsignaturaSyllabusPK().getCodigoMateria()).setParameter(10, asignaturaSelected.getAsignaturaSyllabusPK().getCodigoProfesor());
        q.setParameter(11, asignaturaSelected.getAsignaturaSyllabusPK().getCodigoNivel()).setParameter(12, asignaturaSelected.getAsignaturaSyllabusPK().getVacCodnum());
        q.setParameter(13, asignaturaSelected.getAsignaturaSyllabusPK().getCodParalelo()).setParameter(14, asignaturaSelected.getAsignaturaSyllabusPK().getCodPrograma());
        q.executeUpdate();
        sb = new StringBuilder();
        sb.append(" INSERT INTO interfaseOcu.dbo.SYLABUS_BIBLIO ")
                .append(" (ANIO, CICLO, CODIGO_MATERIA, CODIGO_PROFESOR, CODIGO_NIVEL, VAC_CODNUM, COD_PARALELO, COD_PROGRAMA, BIBLIOGRAFIA)")
                .append(" SELECT ANIO, CICLO, ?, ?, ?, ?, ?, ?,BIBLIOGRAFIA  ")
                .append(" FROM interfaseOcu.dbo.SYLABUS_BIBLIO ")
                .append(" WHERE ANIO = ? and CICLO = ? and CODIGO_MATERIA = ? and CODIGO_PROFESOR = ? and CODIGO_NIVEL = ? ")
                .append(" and VAC_CODNUM = ? and COD_PARALELO = ?  and COD_PROGRAMA = ? ");
        q = em.createNativeQuery(sb.toString());
        q.setParameter(1, copiaSelected.getAsignaturaSyllabusPK().getCodigoMateria());
        q.setParameter(2, copiaSelected.getAsignaturaSyllabusPK().getCodigoProfesor());
        q.setParameter(3, copiaSelected.getAsignaturaSyllabusPK().getCodigoNivel());
        q.setParameter(4, copiaSelected.getAsignaturaSyllabusPK().getVacCodnum());
        q.setParameter(5, copiaSelected.getAsignaturaSyllabusPK().getCodParalelo());
        q.setParameter(6, copiaSelected.getAsignaturaSyllabusPK().getCodPrograma());
        q.setParameter(7, asignaturaSelected.getAnio()).setParameter(8, asignaturaSelected.getCiclo());
        q.setParameter(9, asignaturaSelected.getAsignaturaSyllabusPK().getCodigoMateria()).setParameter(10, asignaturaSelected.getAsignaturaSyllabusPK().getCodigoProfesor());
        q.setParameter(11, asignaturaSelected.getAsignaturaSyllabusPK().getCodigoNivel()).setParameter(12, asignaturaSelected.getAsignaturaSyllabusPK().getVacCodnum());
        q.setParameter(13, asignaturaSelected.getAsignaturaSyllabusPK().getCodParalelo()).setParameter(14, asignaturaSelected.getAsignaturaSyllabusPK().getCodPrograma());
        q.executeUpdate();
    }

    /* Aprobacion del syllabus*/
    @Override
    public void edit(Usuario usr, SylabusDocente sylabusDocente, AsignaturaSyllabus asignaturaSelected, FacesContext fcontext) {
//        System.out.println("moodle "+sylabusDocente.getSylabusDocentePK().getAnio()+" "+ asignaturaSelected.getAsignaturaSyllabusPK().getCodigoMateria());
//        registraMoodle(sylabusDocente.getSylabusDocentePK().getAnio(), asignaturaSelected.getAsignaturaSyllabusPK().getCodigoMateria());
        StringBuilder mensaje;
        super.edit(sylabusDocente);
        /* mensaje para el docente*/

        try {
            Query query = em.createNativeQuery("select CODIGO_PROFESOR,CED_PAS_PROFESOR,NOMBRE_PROFESOR,"
                    + "APELLIDO_PROFESOR,NR_MEMO,EMAIL_PROFESOR from PROFESOR   WITH (NOLOCK) where CODIGO_PROFESOR = ? ", Usuario.class);
            query.setParameter(1, sylabusDocente.getSylabusDocentePK().getCodigoProfesor());
            Usuario docente = (Usuario) query.getSingleResult();

            mensaje = this.genMensaje("docente", sylabusDocente, docente, asignaturaSelected, fcontext);

            if (sylabusDocente.getEstadoEnvio() == 'P' && sylabusDocente.getEstadoSylabus() == 'P' && sylabusDocente.getObservacionCoordinador() != null) {
                this.enviaCorreo("Soporte Servicios", docente.getUsuEmail(), "soporteservicios@uasb.edu.ec", "johana.orozco@uasb.edu.ec;" + asignaturaSelected.getEmailArea(), "Sílabo: con observaciones", mensaje.toString(), "HTML");
////                this.enviaCorreo("Soporte Servicios", "juancarlos.lozada@uasb.edu.ec", null, null, "Sílabo: con observaciones", mensaje.toString(), "HTML");
            } else if (sylabusDocente.getEstadoEnvio() == 'E' && sylabusDocente.getEstadoSylabus() == 'A') {
                this.enviaCorreo("Soporte Servicios", docente.getUsuEmail(), "soporteservicios@uasb.edu.ec", "johana.orozco@uasb.edu.ec;" + asignaturaSelected.getEmailArea(), "Sílabo: aprobado", mensaje.toString(), "HTML");
////                    this.enviaCorreo("Soporte Servicios", "juancarlos.lozada@uasb.edu.ec", null, null, "Sílabo: aprobado", mensaje.toString(), "HTML");
            }
        } catch (NoResultException ex) {
        }
        /* mensaje para el coordinador*/
        try {
            Query query = em.createNativeQuery("select CODIGO_PROFESOR,CED_PAS_PROFESOR,NOMBRE_PROFESOR,APELLIDO_PROFESOR,NR_MEMO,EMAIL_PROFESOR from PROFESOR   WITH (NOLOCK) where CODIGO_PROFESOR = ? ", Usuario.class
            );
            query.setParameter(
                    1, usr.getUsuCodigo());
            Usuario coordinador = (Usuario) query.getSingleResult();
            mensaje = this.genMensaje("coordinador", sylabusDocente, coordinador, asignaturaSelected, fcontext);
////            this.enviaCorreo("Soporte Servicios", "juancarlos.lozada@uasb.edu.ec", null, null, "Sílabo: revisado", mensaje.toString(), "HTML");
            this.enviaCorreo("Soporte Servicios", coordinador.getUsuEmail(), "soporteservicios@uasb.edu.ec", "johana.orozco@uasb.edu.ec;" + asignaturaSelected.getEmailArea(), "Sílabo: revisado", mensaje.toString(), "HTML");
        } catch (NoResultException ex) {
        }
    }

    private StringBuilder genMensaje(String destino, SylabusDocente sylabusDocente, Usuario usr, AsignaturaSyllabus asignaturaSelected, FacesContext fcontext) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "EC"));
        StringBuilder sbHtml = new StringBuilder();

        if (destino.equals("docente")) {
            sbHtml.append(" Estimado(a) docente <br>").append(usr.getUsuNombreUsuario().toUpperCase()).append(" ").append(usr.getUsuApellUsuario().toUpperCase()).append("<br><br><br>");
            sbHtml.append(" El ").append(formatter.format(new Date())).append(" , su coordinador ha ");
            if (sylabusDocente.getEstadoEnvio() == 'P' && sylabusDocente.getEstadoSylabus() == 'P' && sylabusDocente.getObservacionCoordinador() != null) {
                sbHtml.append(" registrado ").append("<span style='font-weight: bold;color: blue'>'observaciones'</span> al sílabo de:").append("<br><br>");
            } else if (sylabusDocente.getEstadoEnvio() == 'E' && sylabusDocente.getEstadoSylabus() == 'A') {
                sbHtml.append("<span style='font-weight: bold;color: blue;text-transform: uppercase'>aprobado</span>").append(" el sílabo de:").append("<br><br>");
            }
            sbHtml.append(" Asignatura: ").append(asignaturaSelected.getNombreMateria()).append(" - ").append(asignaturaSelected.getIdentifMateria()).append("<br>")
                    .append(" Paralelo: ").append(asignaturaSelected.getNombreParalelo()).append("<br>")
                    .append(" Trimestre: ").append(asignaturaSelected.getNombreNivel()).append("<br>")
                    .append(" Programa: ").append(asignaturaSelected.getPrograma()).append("<br><br>")
                    .append(" Por favor, le pedimos entrar al sistema http://sistemas.uasb.edu.ec/PortalD , proceder a revisar el Sílabo, ")
                    .append(" entrando a la opción 'Sylabus' del menú Principal.").append("<br><br>");
        } else {
            sbHtml.append(" Estimado(a) coordinador <br>").append(usr.getUsuNombreUsuario().toUpperCase()).append(" ").append(usr.getUsuApellUsuario().toUpperCase()).append("<br><br><br>");
            sbHtml.append(" El ").append(formatter.format(new Date())).append(" , usted ha registrado ");
            if (sylabusDocente.getEstadoEnvio() == 'P' && sylabusDocente.getEstadoSylabus() == 'P' && sylabusDocente.getObservacionCoordinador() != null) {
                sbHtml.append("<span style='font-weight: bold;color: blue'>observaciones</span> al sílabo de").append("<br><br>");
            } else if (sylabusDocente.getEstadoEnvio() == 'E' && sylabusDocente.getEstadoSylabus() == 'A') {
                sbHtml.append(" la ").append("<span style='font-weight: bold;color: blue'>aprobación</span>").append(" del sílabo de :").append("<br><br>");
            }
            sbHtml.append(" Asignatura: ").append(asignaturaSelected.getNombreMateria()).append(" - ").append(asignaturaSelected.getIdentifMateria()).append("<br>")
                    .append(" Paralelo: ").append(asignaturaSelected.getNombreParalelo()).append("<br>")
                    .append(" Trimestre: ").append(asignaturaSelected.getNombreNivel()).append("<br>")
                    .append(" Programa: ").append(asignaturaSelected.getPrograma()).append("<br><br>");
        }

        sbHtml.append(" Gracias por su aporte. ").append("<br><br>");
        sbHtml.append("Atentamente,<br><br><br>Dirección General Académica.<br>");
        sbHtml.append("Telef: (593 2) 3 228 085 ext. 2208 / 3208<br>");
        sbHtml.append("Quito, Ecuador<br>");
        HttpServletRequest o = (HttpServletRequest) fcontext.getExternalContext().getRequest();
        String s = o.getRequestURL().toString();
        sbHtml.append("<p align='left'><img src='").append(s.substring(0, s.indexOf("/", 15))).append(fcontext.getExternalContext().getRequestContextPath()).append("/resources/images/logocolor.png' alt='logouasb' width='225' height='75' /></p>");
        sbHtml.append("</body>");
        return sbHtml;
    }

    /**/

 /* Registro del syllabus*/
    /**
     *
     * @param docente
     * @param user
     * @param asignatura
     * @param context
     */
    @Override
    public void edit(SylabusDocente docente, Usuario user, AsignaturaSyllabus asignatura, FacesContext context) {
        StringBuilder mensaje;
        super.edit(docente);

        // para el docente
        mensaje = this.genMensaje(user, context, docente, asignatura, "docente", null);
        this.enviaCorreo("Soporte Servicios", user.getUsuEmail(), "soporteservicios@uasb.edu.ec", "johana.orozco@uasb.edu.ec;" + asignatura.getEmailArea(), "Sílabo: enviado al coordinador", mensaje.toString(), "HTML");
////        this.enviaCorreo("Soporte Servicios", "juancarlos.lozada@uasb.edu.ec", "juancarlos.lozada@uasb.edu.ec", "victor.barba@uasb.edu.ec;", "Sílabo: enviado al coordinador", mensaje.toString(), "HTML");

        // para el coordinador
        StringBuilder sbQuery = new StringBuilder("SELECT DISTINCT   CODIGO_COORDINADOR AS COORDINADOR, profesor.NOMBRE_PROFESOR, ");
        sbQuery.append(" profesor.APELLIDO_PROFESOR, ISNULL(PROFESOR.EMAIL_PROFESOR,'')+';'+ISNULL(PROFESOR.EMAILSEC_PROFESOR,'') EMAIL, programa as NOMBRE_ESCUELA ")
                .append(" from VISTA_COORDINADOR_PROGRAMA   WITH (NOLOCK) inner join profesor ")
                .append(" on VISTA_COORDINADOR_PROGRAMA.CODIGO_COORDINADOR =profesor.CODIGO_PROFESOR ")
                .append(" WHERE VISTA_COORDINADOR_PROGRAMA.ANIO = ? AND VISTA_COORDINADOR_PROGRAMA.CICLO = ? AND VISTA_COORDINADOR_PROGRAMA.CODIGO_PROFESOR = ? ")
                .append(" AND VISTA_COORDINADOR_PROGRAMA.CODIGO_MATERIA = ? AND VISTA_COORDINADOR_PROGRAMA.CODIGO_NIVEL = ?")
                .append(" AND VISTA_COORDINADOR_PROGRAMA.COD_PARALELO = ? AND VISTA_COORDINADOR_PROGRAMA.VAC_CODNUM = ? AND VISTA_COORDINADOR_PROGRAMA.CODIGO_ESP = ?");
        Query q = em.createNativeQuery(sbQuery.toString(), Coordinador.class);
        q.setParameter(1, docente.getSylabusDocentePK().getAnio());
        q.setParameter(2, docente.getSylabusDocentePK().getCiclo());
        q.setParameter(3, docente.getSylabusDocentePK().getCodigoProfesor());
        q.setParameter(4, docente.getSylabusDocentePK().getCodigoMateria());
        q.setParameter(5, docente.getSylabusDocentePK().getCodigoNivel());
        q.setParameter(6, docente.getSylabusDocentePK().getCodParalelo());
        q.setParameter(7, docente.getSylabusDocentePK().getVacCodnum());
        q.setParameter(8, docente.getSylabusDocentePK().getCodPrograma());

        List<Coordinador> coordinadores = q.getResultList();
        for (Coordinador coor : coordinadores) {
            mensaje = this.genMensaje(user, context, docente, asignatura, "coordinador", coor);
            this.enviaCorreo("Soporte Servicios", coor.getMail(), "soporteservicios@uasb.edu.ec", "johana.orozco@uasb.edu.ec;" + asignatura.getEmailArea(), "Sílabo docente: " + coor.getNombres().toUpperCase() + " " + coor.getApellido().toUpperCase(), mensaje.toString(), "HTML");
////            this.enviaCorreo("Soporte Servicios", "juancarlos.lozada@uasb.edu.ec", "juancarlos.lozada@uasb.edu.ec", "victor.barba@uasb.edu.ec;", "Sílabo docente: " + coor.getNombres().toUpperCase() + " " + coor.getApellido().toUpperCase(), mensaje.toString(), "HTML");
        }
    }

    private StringBuilder genMensaje(Usuario user, FacesContext fcontext, SylabusDocente docente, AsignaturaSyllabus asignatura, String destino, Coordinador coor) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "EC"));
        StringBuilder sbHtml = new StringBuilder();

        sbHtml.append("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'><html xmlns='http://www.w3.org/1999/xhtml'>");
        sbHtml.append("<head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /><title></title>");
        sbHtml.append("</head>");
        sbHtml.append("<body>");
        if (destino.equals("docente")) {
            sbHtml.append(" Estimado(a) <br>").append(user.getUsuNombreUsuario().toUpperCase()).append(" ").append(user.getUsuApellUsuario().toUpperCase()).append("<br><br><br>");
            sbHtml.append(" El ").append(formatter.format(new Date())).append(" usted ha ");
            if (asignatura.getEstadoEnvio() == null || !asignatura.getEstadoEnvio().equals("E")) {
                sbHtml.append("<span style='font-weight: bold;color: blue'>enviado</span>").append(" el siguiente sílabo, a su coordinador: <br><br>");
            } else {
                sbHtml.append("<span style='font-weight: bold;color: blue'>actualizado</span>").append(" el siguiente sílabo y lo ha enviado a su coordinador: <br><br>");
            }
        } else {
            sbHtml.append(" Estimado(a) <br>").append(coor.getNombres().toUpperCase()).append(" ").append(coor.getApellido().toUpperCase());
            sbHtml.append("<br>Coordinador del programa ").append(coor.getNombreEscuela()).append("<br><br>");
            sbHtml.append(" El ").append(formatter.format(new Date())).append(" el docente ");
            sbHtml.append(user.getUsuNombreUsuario().toUpperCase()).append(" ").append(user.getUsuApellUsuario().toUpperCase());
            if (asignatura.getEstadoEnvio() == null || !asignatura.getEstadoEnvio().equals("E")) {
                sbHtml.append(" ha ").append("<span style='font-weight: bold;color: blue'>enviado</span>");
            } else {
                sbHtml.append(" ha ").append("<span style='font-weight: bold;color: blue'>actualizado</span>");
            }
            sbHtml.append(" el sílabo de la siguiente asignatura: <br><br>");
        }
        StringBuilder sbQuery = new StringBuilder("Select distinct ");
        sbQuery.append(" 'Asignatura: '+ VCP.NOMBRE_MATERIA+' - '+ VCP.IDENTIF_MATERIA+'<br>' +")
                .append(" 'Paralelo: '+VCP.NOMBRE_PARALELO+' <br>' +")
                .append(" 'Trimestre: '+VCP.TRIMESTRE+'<br>'+")
                .append(" 'Programa: '+VCP.PROGRAMA+' <br>'+")
                .append(" 'Ciclo académico: ' +CICLO_ACADEMICO.NOMBRE_CICLO +'<br>' ")
                .append(" FROM (SYLABUS_DOCENTE SY WITH (NOLOCK) ")
                .append(" INNER JOIN CICLO_ACADEMICO CICLO_ACADEMICO ON (SY.ANIO = CICLO_ACADEMICO.ANIO AND SY.CICLO = CICLO_ACADEMICO.CICLO)) ")
                .append(" INNER JOIN VISTA_COORDINADOR_PROGRAMA VCP ON  ")
                .append(" (VCP.ANIO = SY.ANIO AND VCP.CICLO = SY.CICLO   AND VCP.CODIGO_MATERIA = SY.CODIGO_MATERIA ")
                .append(" AND VCP.CODIGO_PROFESOR = SY.CODIGO_PROFESOR   AND VCP.CODIGO_NIVEL = SY.CODIGO_NIVEL ")
                .append(" AND VCP.VAC_CODNUM = SY.VAC_CODNUM   AND VCP.COD_PARALELO = SY.COD_PARALELO   AND VCP.CODIGO_ESP = SY.COD_PROGRAMA) ")
                .append(" WHERE SY.ANIO = ? AND SY.CICLO = ? AND SY.CODIGO_PROFESOR = ?  AND SY.CODIGO_MATERIA = ? ")
                .append(" AND SY.CODIGO_NIVEL = ?  AND SY.ESTADO_ENVIO = 'E' AND SY.COD_PARALELO = ?  AND SY.VAC_CODNUM = ? AND SY.COD_PROGRAMA = ? ");
        Query q = em.createNativeQuery(sbQuery.toString());
        q.setParameter(1, docente.getSylabusDocentePK().getAnio());
        q.setParameter(2, docente.getSylabusDocentePK().getCiclo());
        q.setParameter(3, docente.getSylabusDocentePK().getCodigoProfesor());
        q.setParameter(4, docente.getSylabusDocentePK().getCodigoMateria());
        q.setParameter(5, docente.getSylabusDocentePK().getCodigoNivel());
        q.setParameter(6, docente.getSylabusDocentePK().getCodParalelo());
        q.setParameter(7, docente.getSylabusDocentePK().getVacCodnum());
        q.setParameter(8, docente.getSylabusDocentePK().getCodPrograma());
        try {
            sbHtml.append(q.getSingleResult().toString().toUpperCase()).append("<br><br>");
        } catch (NoResultException e) {
            return null;
        }

        if (destino.equals("coordinador")) {
            sbHtml.append(" Por favor, le pedimos entrar al sistema http://sistemas.uasb.edu.ec/PortalD , proceder a revisar y aprobar el Sílabo ");
            sbHtml.append(" si así lo considera, entrando a la opción 'Sylabus' del menú Principal.").append("<br><br>");
        }
        sbHtml.append(" Gracias por su aporte. ").append("<br><br>");
        sbHtml.append("Atentamente,<br><br><br>Dirección General Académica.<br>");
        sbHtml.append("Telef: (593 2) 299 3669 / (593 2) 299 3670<br>");
        sbHtml.append("Quito, Ecuador<br>");
        HttpServletRequest o = (HttpServletRequest) fcontext.getExternalContext().getRequest();
        String s = o.getRequestURL().toString();
        sbHtml.append("<p align='left'><img src='").append(s.substring(0, s.indexOf("/", 15))).append(fcontext.getExternalContext().getRequestContextPath()).append("/resources/images/logocolor.png' alt='logouasb' width='225' height='75' /></p>");
        sbHtml.append("</body>");
        return sbHtml;
    }

}
