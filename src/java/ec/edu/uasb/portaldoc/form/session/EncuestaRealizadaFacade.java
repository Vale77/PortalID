/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.form.session;

import ec.edu.uasb.portaldoc.form.datamodel.EncuEvalDocente;
import ec.edu.uasb.portaldoc.form.entities.EncuestaRealizada;
import ec.edu.uasb.portaldoc.form.entities.EncuestaRealizadaPK;
import ec.edu.uasb.portaldoc.form.entities.Respuesta;
import ec.edu.uasb.seg.entities.Usuario;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author victor.barba
 */
@Stateless
public class EncuestaRealizadaFacade extends AbstractFacade<EncuestaRealizada> implements EncuestaRealizadaFacadeLocal {

    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;
//    private static final Logger LOG = Logger.getLogger(EncuestaRealizadaFacade.class.getName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncuestaRealizadaFacade() {
        super(EncuestaRealizada.class);
    }

//    private BigDecimal findSecuencialBy(String tabla) {
//        Query q = em.createNativeQuery("SELECT numseq FROM SEQNO WHERE tabla = ?");
//        q.setParameter(1, tabla);
//        return (BigDecimal) q.getSingleResult();
//    }
    private BigDecimal addSecuencial(String tabla) {
        Query q = em.createNativeQuery("SELECT numseq FROM seqno  with(rowlock)  WHERE tabla = ?");
        q.setParameter(1, tabla);
        BigDecimal numSec = (BigDecimal) q.getSingleResult();
        q = em.createNativeQuery("UPDATE seqno SET numseq = ? + 1  WHERE tabla = ?");
        q.setParameter(1, numSec);
        q.setParameter(2, tabla);
        q.executeUpdate();
        return numSec;

    }

    @Override
    public List encuestasDisponibles(Long codCoordinador, String tipo) {
        if (tipo.equals("EVAL_DOCENTE")) {
            return getEvalDocentes(codCoordinador);
        } else if (tipo.equals("EVAL_PROGRAMA")) {
            return getEvalPrograma(codCoordinador);
        }
        return null;
    }

    private List getEvalDocentes(Long codCoordinador) {
        Query q;
        StringBuilder sb = new StringBuilder();
        sb.append(" DECLARE @MATERIA TABLE (CODIGO_PROFESOR NUMERIC(8,0),NOMBRE_PROFESOR VARCHAR(100), APELLIDO_PROFESOR VARCHAR(100), NOMBRE_MATERIA VARCHAR(512),CODIGO_NIVEL INT, PROGRAMA VARCHAR(1024),");
        sb.append(" CODIGO_COORDINADOR VARCHAR(384), CODIGO_ESP VARCHAR(4),  CODIGO_MATERIA NUMERIC(9,0), ANIO INT,   TRIMESTRE VARCHAR(75), IDENTIF_MATERIA VARCHAR(15),CICLO VARCHAR(384))");
        sb.append(" INSERT INTO @MATERIA( CODIGO_PROFESOR,NOMBRE_PROFESOR , APELLIDO_PROFESOR , NOMBRE_MATERIA,CODIGO_NIVEL, PROGRAMA,CODIGO_COORDINADOR, ");
        sb.append(" CODIGO_ESP,  CODIGO_MATERIA, ANIO, TRIMESTRE, IDENTIF_MATERIA ,CICLO )");
        sb.append(" SELECT DISTINCT CODIGO_PROFESOR,NOMBRE_PROFESOR , APELLIDO_PROFESOR , NOMBRE_MATERIA,CODIGO_NIVEL, PROGRAMA,CODIGO_COORDINADOR, CODIGO_ESP,  CODIGO_MATERIA, ANIO, TRIMESTRE, IDENTIF_MATERIA ,CICLO FROM VISTA_COORDINADOR_PROGRAMA");

        sb.append(" SELECT DISTINCT cal.CODIGO_PROFESOR, ENC.CODIGO_ENCUESTA, ENC.TITULO, ENC.REFERENCIA, cal.ANIO, cal.CICLO, cal.FECHA_INICIO, cal.FECHA_FIN,cal.CODIGO_PARALELO ,");
        sb.append(" cal.CODIGO_MATERIA, VISTA_COORDINADOR_PROGRAMA.NOMBRE_PROFESOR, VISTA_COORDINADOR_PROGRAMA.APELLIDO_PROFESOR, ");
        sb.append(" VISTA_COORDINADOR_PROGRAMA.TRIMESTRE, VISTA_COORDINADOR_PROGRAMA.NOMBRE_MATERIA,VISTA_COORDINADOR_PROGRAMA.IDENTIF_MATERIA, ");
        sb.append(" VISTA_COORDINADOR_PROGRAMA.PROGRAMA,'' MENCION,VISTA_COORDINADOR_PROGRAMA.CODIGO_ESP,VISTA_COORDINADOR_PROGRAMA.CODIGO_NIVEL, ");
        sb.append("(select count(*)  from EVALUACION.ENCUESTA_REALIZADA where codigo_alumno = VISTA_COORDINADOR_PROGRAMA.CODIGO_COORDINADOR  ");
        sb.append(" and anio = CAL.ANIO and ciclo = CAL.CICLO and codigo_materia = CAL.CODIGO_MATERIA and ENCUESTA_REALIZADA.codigo_esp = VISTA_COORDINADOR_PROGRAMA.CODIGO_ESP  ");
        sb.append(" and codigo_encuesta = ENC.CODIGO_ENCUESTA and codigo_profesor = CAL.CODIGO_PROFESOR AND TIPO_REGISTRO = 'C' and CODIGO_NIVEL = cal.CODIGO_NIVEL) ESTADO, ");
        sb.append(" IIF(getdate() between cal.fecha_inicio and cal.fecha_fin + 1,'S','N') HABILITADO ");
        sb.append(" FROM EVALUACION.ENCUESTA_CALENDARIO AS cal INNER JOIN EVALUACION.ENCUESTA AS ENC ON cal.CODIGO_ENCUESTA = ENC.CODIGO_ENCUESTA INNER JOIN ");
        sb.append(" @MATERIA as VISTA_COORDINADOR_PROGRAMA ON cal.ANIO = VISTA_COORDINADOR_PROGRAMA.ANIO AND cal.CICLO = VISTA_COORDINADOR_PROGRAMA.CICLO AND ");
        sb.append(" cal.CODIGO_ESP = VISTA_COORDINADOR_PROGRAMA.CODIGO_ESP AND cal.CODIGO_PROFESOR = VISTA_COORDINADOR_PROGRAMA.CODIGO_PROFESOR AND ");
        sb.append(" cal.CODIGO_MATERIA = VISTA_COORDINADOR_PROGRAMA.CODIGO_MATERIA AND cal.CODIGO_NIVEL = VISTA_COORDINADOR_PROGRAMA.CODIGO_NIVEL ");
        sb.append(" WHERE  CAL.FECHA_INICIO <= getdate()   ");
        sb.append(" AND CAL.TIPO_ENCUESTA = 'C' AND VISTA_COORDINADOR_PROGRAMA.CODIGO_COORDINADOR = ? AND ENC.USO='S' AND CAL.ESTADO_ENCUESTA = 'A' ");
        sb.append(" ORDER BY CAL.FECHA_FIN DESC, VISTA_COORDINADOR_PROGRAMA.APELLIDO_PROFESOR,VISTA_COORDINADOR_PROGRAMA.NOMBRE_PROFESOR ");
//        System.out.println(sb.toString());
        q = em.createNativeQuery(sb.toString(), EncuEvalDocente.class);
        return q.setParameter(1, codCoordinador).setHint("eclipselink.refresh", true).getResultList();
    }

    private List getEvalPrograma(Long codCoordinador) {
        Query q;
        StringBuilder sb = new StringBuilder();
        sb.append("DECLARE @PROGRAMA TABLE (  PROGRAMA VARCHAR(500),CODIGO_ESP VARCHAR(4),   ANIO INT, CICLO VARCHAR(384), CODIGO_COORDINADOR VARCHAR(384) )")
                .append(" INSERT INTO @PROGRAMA( PROGRAMA ,CODIGO_ESP ,  ANIO ,  CICLO,  CODIGO_COORDINADOR ) ")
                .append(" SELECT DISTINCT   PROGRAMA ,CODIGO_ESP ,   ANIO ,  1, CODIGO_COORDINADOR FROM dbo.VISTA_COORDINADOR_PROGRAMA ")
                .append(" SELECT DISTINCT cal.CODIGO_PROFESOR, ENC.CODIGO_ENCUESTA, ENC.TITULO, ENC.REFERENCIA, cal.ANIO, cal.CICLO, cal.FECHA_INICIO, cal.FECHA_FIN,cal.CODIGO_PARALELO , ")
                .append(" cal.CODIGO_MATERIA, '' NOMBRE_PROFESOR, '' APELLIDO_PROFESOR, ")
                .append(" '' TRIMESTRE, '' NOMBRE_MATERIA,''IDENTIF_MATERIA, ")
                .append(" VISTA_COORDINADOR_PROGRAMA.PROGRAMA,'' MENCION,VISTA_COORDINADOR_PROGRAMA.CODIGO_ESP,-1 CODIGO_NIVEL, ")
                .append("(select count(*)  from EVALUACION.ENCUESTA_REALIZADA where codigo_alumno = VISTA_COORDINADOR_PROGRAMA.CODIGO_COORDINADOR  ")
                .append(" and anio = CAL.ANIO and ciclo = CAL.CICLO and codigo_materia = CAL.CODIGO_MATERIA and ENCUESTA_REALIZADA.codigo_esp = VISTA_COORDINADOR_PROGRAMA.CODIGO_ESP  ")
                .append(" and codigo_encuesta = ENC.CODIGO_ENCUESTA and codigo_profesor = CAL.CODIGO_PROFESOR AND TIPO_REGISTRO = 'C' and CODIGO_NIVEL = cal.CODIGO_NIVEL) ESTADO, ")
                .append(" IIF(getdate() between cal.fecha_inicio and cal.fecha_fin + 1,'S','N') HABILITADO ")
                .append(" FROM EVALUACION.ENCUESTA_CALENDARIO AS cal INNER JOIN EVALUACION.ENCUESTA AS ENC ON cal.CODIGO_ENCUESTA = ENC.CODIGO_ENCUESTA INNER JOIN ")
                .append(" @PROGRAMA VISTA_COORDINADOR_PROGRAMA ON cal.ANIO = VISTA_COORDINADOR_PROGRAMA.ANIO AND cal.CICLO = VISTA_COORDINADOR_PROGRAMA.CICLO AND ")
                .append(" cal.CODIGO_ESP = VISTA_COORDINADOR_PROGRAMA.CODIGO_ESP AND cal.CODIGO_PROFESOR = -1 AND ")
                .append(" cal.CODIGO_MATERIA = -1 AND cal.CODIGO_NIVEL = -1 ")
                .append(" WHERE  CAL.FECHA_INICIO <= getdate()   ")
                .append(" AND CAL.ESTADO_ENCUESTA = 'A' AND CAL.TIPO_ENCUESTA = 'O' AND VISTA_COORDINADOR_PROGRAMA.CODIGO_COORDINADOR = ? AND ENC.USO='S'  ")
                .append(" ORDER BY  VISTA_COORDINADOR_PROGRAMA.PROGRAMA ");
//        System.out.println(sb.toString());
        q = em.createNativeQuery(sb.toString(), EncuEvalDocente.class);
        return q.setParameter(1, codCoordinador).setHint("eclipselink.refresh", true).getResultList();
    }

    @Override
    public String createEncuesta(Long codCoordinador, EncuEvalDocente encuEvalDocente, List<Respuesta> respuestas, FacesContext context, String tipo) {

        Query q;
        q = em.createNativeQuery("select count(*) from EVALUACION.ENCUESTA_REALIZADA  WITH (NOLOCK) where CODIGO_ALUMNO = ? and ANIO = ? and CICLO = ? and "
                + "CODIGO_ENCUESTA = ? and CODIGO_MATERIA = ? and  CODIGO_PROFESOR = ? and TIPO_REGISTRO = 'C' "
                + "and CODIGO_ESP=? and CODIGO_NIVEL = ?");
        q.setParameter(1, codCoordinador);
        q.setParameter(2, encuEvalDocente.getEncuEvalDocentePK().getAnio());
        q.setParameter(3, encuEvalDocente.getCiclo());
        q.setParameter(4, encuEvalDocente.getCodigoEncuesta());
        q.setParameter(7, encuEvalDocente.getEncuEvalDocentePK().getCodigoEsp());
        if (tipo.equals("Coordinados")) {
            q.setParameter(5, encuEvalDocente.getEncuEvalDocentePK().getCodigoMateria());
            q.setParameter(6, encuEvalDocente.getEncuEvalDocentePK().getCodigoProfesor());
            q.setParameter(8, encuEvalDocente.getEncuEvalDocentePK().getCodigoNivel());
        } else {
            q.setParameter(5, Long.parseLong("-1"));
            q.setParameter(6, Long.parseLong("-1"));
            q.setParameter(8, Long.parseLong("-1"));
        }
        if ((Integer) q.getSingleResult() != 0) {
            return "<br/><br/>Encuesta ya fue realizada ! ";
        } else {
            EncuestaRealizada enc = new EncuestaRealizada();
            EncuestaRealizadaPK encPk = null;
            if (tipo.equals("Coordinados")) {
                encPk = new EncuestaRealizadaPK(codCoordinador, encuEvalDocente.getEncuEvalDocentePK().getAnio(), encuEvalDocente.getCiclo(), encuEvalDocente.getEncuEvalDocentePK().getCodigoMateria(),
                        encuEvalDocente.getCodigoEncuesta(), encuEvalDocente.getEncuEvalDocentePK().getCodigoProfesor(), "C",
                        encuEvalDocente.getEncuEvalDocentePK().getCodigoEsp(), encuEvalDocente.getEncuEvalDocentePK().getCodigoNivel(),
                        encuEvalDocente.getEncuEvalDocentePK().getCodigoParalelo());
            } else {
                encPk = new EncuestaRealizadaPK(codCoordinador, encuEvalDocente.getEncuEvalDocentePK().getAnio(), encuEvalDocente.getCiclo(), Long.parseLong("-1"),
                        encuEvalDocente.getCodigoEncuesta(), Long.parseLong("-1"), "C",
                        encuEvalDocente.getEncuEvalDocentePK().getCodigoEsp(), Long.parseLong("-1"),
                        encuEvalDocente.getEncuEvalDocentePK().getCodigoParalelo());
            }
            enc.setEncuestaRealizadaPK(encPk);
            enc.setFecha(new Date());
            enc.setRealizada('1');
            try {
                this.create(enc);
                for (Respuesta r : respuestas) {
                    em.persist(r);
                }
            } catch (Exception e) {
                return "Error. No puedo generar Transacción (EncuestaRealizada).<br/><br/>Por Favor, informe al CallCenter de la Universidad Andina Simon Bolivar <br/>sobre este error.<br/><br/>Gracias !";
            }
            if (tipo.equals("Coordinados")) {
                registraRecordatorio(codCoordinador, context, enc, "Coordinador", "Coordinados");
                registraRecordatorio(encuEvalDocente.getEncuEvalDocentePK().getCodigoProfesor(), context, enc, "Docente", "Coordinados");
            } else {
                registraRecordatorio(codCoordinador, context, enc, "Coordinador", encuEvalDocente.getPrograma());
            }
        }

        return null;
    }

    private void registraRecordatorio(Long codCoordinador, FacesContext context, EncuestaRealizada enc, String destino, String origen) {

        StringBuilder sbCab = new StringBuilder();
        StringBuilder sbDet = new StringBuilder();
        BigDecimal sec;
        StringBuilder mensaje;

        Query query = em.createNativeQuery("select CODIGO_PROFESOR,CED_PAS_PROFESOR,NOMBRE_PROFESOR,APELLIDO_PROFESOR,NR_MEMO,EMAIL_PROFESOR from PROFESOR  WITH (NOLOCK) where CODIGO_PROFESOR = ?", Usuario.class);
        query.setParameter(1, codCoordinador);
        Usuario user = (Usuario) query.getSingleResult();

        sec = addSecuencial("RECORDATORIO");

        mensaje = this.genMensaje(user, context, enc, destino, origen);

        sbCab.append(" INSERT INTO RECORDATORIO_PROFESOR ( CODIGO_RECORDATORIO,CODIGO_PROFESOR,EMAIL_RECORDATORIO,");
        sbCab.append(" ESTADO_RECORDATORIO,USUARIO_CREA,USUARIO_ULTMODIFIC,FECHA_CREA,FECHA_ULTMODIFIC,CC_RECORDATORIO, ASUNTO_RECORDATORIO) ");
        sbCab.append(" VALUES (?, ?, ?, 'A', 'iUASB', 'iUASB', getdate(),getdate(),?,? )");
        query = em.createNativeQuery(sbCab.toString());
        query.setParameter(1, sec);//CODIGO_RECORDATORIO
        query.setParameter(2, codCoordinador);
        query.setParameter(3, mensaje.toString());//
        query.setParameter(4, "johana.orozco@uasb.edu.ec;evaluaciones@uasb.edu.ec");
//        query.setParameter(4, "victor.barba@uasb.edu.ec");//user.getUsuEmail()
//        query.setParameter(4, "victor.barba@uasb.edu.ec");//johana.orozco@uasb.edu.ec;dga@uasb.edu.ec
        if (destino.equals("Coordinador")) {
            if (origen.equals("Coordinados")) {
                query.setParameter(5, "Evaluacion del Coordinador - Docente");
            } else {
                query.setParameter(5, "Evaluacion del Comite - Programa");
            }
        } else {
            query.setParameter(5, "Evaluacion del Coordinador");
        }
        query.executeUpdate();

        sbDet.append("INSERT INTO PROGRAMA_RECORDATORIO ( CODIGO_RECORDATORIO,FECHA_PROGRAMA, MENSAJE_RECORDATORIO,");
        sbDet.append("USUARIO_CREA,USUARIO_ULTMODIFIC,FECHA_CREA,FECHA_ULTMODIFIC,ESTADO_PROGRAMA,FORMATO_MENSAJE_PROGRAMA,PERFIL_CORREO) ");
        sbDet.append("VALUES ( ?,convert (datetime,CONVERT(char, convert(datetime, getdate()),112) ),?,'iUASB','iUASB',getdate(),getdate(),'A','H','Eval')");
        query = em.createNativeQuery(sbDet.toString());
        query.setParameter(1, sec);
        query.setParameter(2, mensaje.toString());
        query.executeUpdate();

    }

    private StringBuilder genMensaje(Usuario user, FacesContext fcontext, EncuestaRealizada enc, String destino, String origen) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "EC"));
        StringBuilder sbHtml = new StringBuilder();

        sbHtml.append("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'><html xmlns='http://www.w3.org/1999/xhtml'>");
        sbHtml.append("<head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /><title></title>");
        sbHtml.append("</head>");
        sbHtml.append("<body>");
        sbHtml.append(" Estimado(a) ").append(user.getUsuNombreUsuario().toUpperCase()).append(" ").append(user.getUsuApellUsuario().toUpperCase()).append("<br><br><br>");

        if (destino.equals("Coordinador")) {
            sbHtml.append(" El ").append(formatter.format(new Date())).append(" ha realizado la evaluación de el comite al <br><br>");
            if (origen.equals("Coordinados")) {
                StringBuilder sbQuery = new StringBuilder("Select DISTINCT ");
                sbQuery.append(" 'Profesor(a): '+VISTA_COORDINADOR_PROGRAMA.NOMBRE_PROFESOR +' '+VISTA_COORDINADOR_PROGRAMA.APELLIDO_PROFESOR+'<br>' +");
                sbQuery.append(" CICLO_ACADEMICO.NOMBRE_CICLO  +'<br>'  +");
                sbQuery.append(" 'TRIMESTRE: '+  VISTA_COORDINADOR_PROGRAMA.TRIMESTRE  + '<br>'  + ");
                sbQuery.append(" 'MATERIA: '+ VISTA_COORDINADOR_PROGRAMA.NOMBRE_MATERIA +'<br>'  + ");
                sbQuery.append(" 'PROGRAMA: '+  VISTA_COORDINADOR_PROGRAMA.PROGRAMA  + '<br>'  ");
                sbQuery.append(" FROM  VISTA_COORDINADOR_PROGRAMA INNER JOIN");
                sbQuery.append(" EVALUACION.ENCUESTA_REALIZADA ON VISTA_COORDINADOR_PROGRAMA.ANIO = ENCUESTA_REALIZADA.ANIO AND ");
                sbQuery.append(" VISTA_COORDINADOR_PROGRAMA.CICLO = ENCUESTA_REALIZADA.CICLO AND ");
                sbQuery.append(" VISTA_COORDINADOR_PROGRAMA.CODIGO_MATERIA = ENCUESTA_REALIZADA.CODIGO_MATERIA AND ");
                sbQuery.append(" VISTA_COORDINADOR_PROGRAMA.CODIGO_COORDINADOR = ENCUESTA_REALIZADA.CODIGO_ALUMNO AND ");
                sbQuery.append(" VISTA_COORDINADOR_PROGRAMA.CODIGO_NIVEL = ENCUESTA_REALIZADA.CODIGO_NIVEL AND ");
                sbQuery.append(" VISTA_COORDINADOR_PROGRAMA.CODIGO_ESP = ENCUESTA_REALIZADA.CODIGO_ESP AND VISTA_COORDINADOR_PROGRAMA.CODIGO_ESP = ? AND ");
                sbQuery.append(" VISTA_COORDINADOR_PROGRAMA.CODIGO_PROFESOR = ENCUESTA_REALIZADA.CODIGO_PROFESOR INNER JOIN ");
                sbQuery.append(" CICLO_ACADEMICO ON ENCUESTA_REALIZADA.ANIO = CICLO_ACADEMICO.ANIO AND ENCUESTA_REALIZADA.CICLO = CICLO_ACADEMICO.CICLO ");
                sbQuery.append(" where ENCUESTA_REALIZADA.ANIO = ? and ENCUESTA_REALIZADA.CICLO = 1 and ENCUESTA_REALIZADA.CODIGO_MATERIA = ? and  ENCUESTA_REALIZADA.CODIGO_PROFESOR = ? ");
                sbQuery.append(" and ENCUESTA_REALIZADA.CODIGO_ALUMNO = ? and ENCUESTA_REALIZADA.CODIGO_ENCUESTA = ?  and ENCUESTA_REALIZADA.TIPO_REGISTRO = 'C' ");
                sbQuery.append(" and ENCUESTA_REALIZADA.CODIGO_NIVEL = ? and ENCUESTA_REALIZADA.CODIGO_PARALELO = ?");
                Query q = em.createNativeQuery(sbQuery.toString());
                q.setParameter(1, enc.getEncuestaRealizadaPK().getCodigoEsp());
                q.setParameter(2, enc.getEncuestaRealizadaPK().getAnio());
                q.setParameter(3, enc.getEncuestaRealizadaPK().getCodigoMateria());
                q.setParameter(4, enc.getEncuestaRealizadaPK().getCodigoProfesor());
                q.setParameter(5, enc.getEncuestaRealizadaPK().getCodigoAlumno());
                q.setParameter(6, enc.getEncuestaRealizadaPK().getCodigoEncuesta());
                q.setParameter(7, enc.getEncuestaRealizadaPK().getCodigoNivel());
                q.setParameter(8, enc.getEncuestaRealizadaPK().getCodigoParalelo());
                sbHtml.append(q.getSingleResult().toString().toUpperCase()).append("<br><br>");
            } else {
                sbHtml.append("Programa: ").append(origen.toUpperCase()).append("<br><br>");
            }
            sbHtml.append(" Gracias por su aporte. ").append("<br><br>");
        } else {
            sbHtml.append(" El ").append(formatter.format(new Date())).append(" se ha realizado su evaluación por parte de su coordinador <br><br>");
            sbHtml.append(" Para mayor detalle puede ingresar al siguiente link:  http://sistemas.uasb.edu.ec/PortalD <br><br>");
        }
        sbHtml.append("Atentamente,<br><br><br>Dirección General Académica.<br>");
        sbHtml.append("Telef: (593 2) 3 228 085 ext. 2208 / 3208<br>");
        sbHtml.append("Quito, Ecuador<br>");
        HttpServletRequest o = (HttpServletRequest) fcontext.getExternalContext().getRequest();
        String s = o.getRequestURL().toString();
        sbHtml.append("<p align='left'><img src='").append(s.substring(0, s.indexOf("/", 15))).append(fcontext.getExternalContext().getRequestContextPath()).append("/resources/images/logocolor.png' alt='logouasb' width='225' height='75' /></p>");
        sbHtml.append("</body>");
        return sbHtml;
    }
}
