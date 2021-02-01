/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.session;

import ec.edu.uasb.portaldoc.entities.AsignaturaSyllabus;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author victor.barba
 */
@Stateless
public class AsignaturaSyllabusFacade extends AbstractFacade<AsignaturaSyllabus> implements AsignaturaSyllabusFacadeLocal {

    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsignaturaSyllabusFacade() {
        super(AsignaturaSyllabus.class);
    }

    @Override
    public List<AsignaturaSyllabus> getAsignatSyllabus(Long anio, Long docente) {
        StringBuilder sb = new StringBuilder();
        /*  sb.append(" SELECT DISTINCT VCP.ANIO, VCP.CICLO, VCP.CODIGO_MATERIA, VCP.CODIGO_NIVEL, VCP.VAC_CODNUM,VCP.COD_PARALELO, VCP.CODIGO_PROFESOR,");
        sb.append(" VCP.NOMBRE_MATERIA, VCP.IDENTIF_MATERIA,VCP.NOMBRE_PARALELO, VCP.TRIMESTRE NOMBRE_NIVEL, VCP.RESPONSABLE_MATERIA, VCP.CODIGO_ESP, ");
        sb.append(" SY.ESTADO_SYLABUS, SY.APROBADO_POR, SY.ESTADO_ENVIO, SY.OBSERVACION_COORDINADOR, VCP.AREA, VCP.PROGRAMA,VCP.CODIGO_COORDINADOR, ");
        sb.append(" NUMCLASES HORAS_MATERIA_DICTAR, NCREDITOS, VCP.REGSILABO,VCP.APELLIDO_COORDINADOR, VCP.NOMBRE_COORDINADOR,VCP.EMAIL_COORDINADOR, "
                + "(SELECT distinct CONCAT(NOMBRE_COMPLETO,';')  AS [data()] FROM V_SECRETARIA WHERE ARE_CODIGO = VCP.CODIGO_FACULTAD and PRG_CODIGO = VCP.CODIGO_ESP AND ANIO_ACAD = VCP.ANIO For XML PATH (''))  SECRETARIA,  ");
        sb.append(" (SELECT distinct CONCAT(EMAIL,';')  AS [data()] FROM V_SECRETARIA WHERE ARE_CODIGO = VCP.CODIGO_FACULTAD and PRG_CODIGO = VCP.CODIGO_ESP For XML PATH (''))  EMAIL_AREA ");
        sb.append(" FROM VISTA_COORDINADOR_PROGRAMA VCP LEFT OUTER JOIN SYLABUS_DOCENTE SY ON VCP.CODIGO_PROFESOR = SY.CODIGO_PROFESOR AND ");
        sb.append(" VCP.CODIGO_NIVEL = SY.CODIGO_NIVEL AND VCP.CODIGO_MATERIA = SY.CODIGO_MATERIA AND VCP.CODIGO_ESP = SY.COD_PROGRAMA AND ");
        sb.append(" VCP.ANIO = SY.ANIO AND VCP.CICLO = SY.CICLO AND VCP.VAC_CODNUM = SY.VAC_CODNUM AND VCP.COD_PARALELO = SY.COD_PARALELO ");
        sb.append(" WHERE  VCP.ANIO = ? AND VCP.CICLO = 1 AND VCP.RESPONSABLE_MATERIA = 'S' AND VCP.CODIGO_PROFESOR = ? AND VCP.CODIGO_NIVEACAD <> '3' ");
        sb.append(" ORDER BY  VCP.PROGRAMA,VCP.NOMBRE_MATERIA, VCP.CODIGO_NIVEL,VCP.COD_PARALELO ");*/

        sb.append("EXECUTE interfaseOcu.dbo.sp_asignatura_silabo @codanio=");
        sb.append(anio);
        sb.append(", @coddocente=");
        sb.append(docente);
        Query q = em.createNativeQuery(sb.toString(), AsignaturaSyllabus.class);
        q.setParameter(1, anio).setParameter(2, docente);
        List<AsignaturaSyllabus> tmp = q.getResultList();
        return tmp;
    }

    @Override
    public List<AsignaturaSyllabus> getCordinadosSyllabus(Long anio, Long coordinador) {
        StringBuilder sb = new StringBuilder();
        sb.append(" DECLARE @temp_table table(are_codigo int ,prg_codigo int ,email_area varchar(512)) ");
        sb.append(" insert into @temp_table select are_codigo,prg_codigo,email FROM V_SECRETARIA  ");
        sb.append(" SELECT DISTINCT VCP.ANIO, VCP.CICLO, VCP.CODIGO_MATERIA, VCP.CODIGO_NIVEL,VCP.VAC_CODNUM, VCP.NOMBRE_MATERIA, VCP.IDENTIF_MATERIA, VCP.CODIGO_PROFESOR, ");
        sb.append(" VCP.NOMBRE_PROFESOR, VCP.APELLIDO_PROFESOR,VCP.NOMBRE_PARALELO,   VCP.RESPONSABLE_MATERIA, VCP.TRIMESTRE NOMBRE_NIVEL,VCP.COD_PARALELO, SY.ESTADO_SYLABUS,VCP.CODIGO_ESP, ");
        sb.append("VCP.REGSILABO, ");
        sb.append(" SY.ESTADO_ENVIO, SY.OBSERVACION_COORDINADOR,0 HORAS_MATERIA_DICTAR,0 NCREDITOS,  VCP.AREA, VCP.PROGRAMA,");
        sb.append(" (SELECT distinct CONCAT(email_area,';')  AS [data()] FROM @temp_table WHERE are_codigo = VCP.CODIGO_FACULTAD and prg_codigo = VCP.CODIGO_ESP For XML PATH (''))    EMAIL_AREA");
//        sb.append(" (SELECT distinct CONCAT(EMAIL,';')  AS [data()] FROM V_SECRETARIA WHERE ARE_CODIGO = VCP.CODIGO_FACULTAD and PRG_CODIGO = VCP.CODIGO_ESP For XML PATH (''))    EMAIL_AREA");
        //sb.append(" '' EMAIL_AREA");
        sb.append(" FROM  VISTA_COORDINADOR_PROGRAMA VCP INNER JOIN SYLABUS_DOCENTE SY ON VCP.CODIGO_PROFESOR = SY.CODIGO_PROFESOR AND ");
        sb.append(" VCP.CODIGO_NIVEL = SY.CODIGO_NIVEL AND VCP.CODIGO_MATERIA = SY.CODIGO_MATERIA AND VCP.CODIGO_ESP = SY.COD_PROGRAMA AND ");
        sb.append(" VCP.ANIO = SY.ANIO AND VCP.CICLO = SY.CICLO AND VCP.VAC_CODNUM = SY.VAC_CODNUM AND VCP.COD_PARALELO = SY.COD_PARALELO ");
        sb.append(" WHERE  VCP.ANIO = ? AND VCP.CICLO = 1 AND VCP.CODIGO_COORDINADOR = ? AND SY.ESTADO_ENVIO = 'E' AND VCP.RESPONSABLE_MATERIA = 'S' AND VCP.CODIGO_NIVEACAD <> '3' ");
        sb.append(" ORDER BY  VCP.PROGRAMA,VCP.NOMBRE_MATERIA, VCP.CODIGO_NIVEL,VCP.COD_PARALELO ");
        Query q = em.createNativeQuery(sb.toString(), AsignaturaSyllabus.class);
        q.setParameter(1, anio).setParameter(2, coordinador);
        List<AsignaturaSyllabus> tmp = q.getResultList();
        return tmp;
    }

    @Override
    public List<AsignaturaSyllabus> getListaAcopiarSyllabus(Long anio, Long docente, Long asignatura) {
        StringBuilder sb = new StringBuilder();
        sb.append(" select DISTINCT VCP.ANIO, VCP.CICLO, VCP.CODIGO_MATERIA, VCP.CODIGO_NIVEL,VCP.VAC_CODNUM, VCP.NOMBRE_MATERIA,VCP.IDENTIF_MATERIA, ")
                .append(" VCP.NOMBRE_PARALELO, VCP.TRIMESTRE NOMBRE_NIVEL,VCP.COD_PARALELO, VCP.CODIGO_ESP,VCP.CODIGO_PROFESOR,  VCP.AREA, VCP.PROGRAMA, (IIF(SY.USUARIO_CREA is null,0,1 )) EXISTE ")
                .append(" FROM  VISTA_COORDINADOR_PROGRAMA VCP LEFT OUTER JOIN SYLABUS_DOCENTE SY ON VCP.CODIGO_PROFESOR = SY.CODIGO_PROFESOR ")
                .append(" AND  VCP.CODIGO_NIVEL = SY.CODIGO_NIVEL AND VCP.CODIGO_MATERIA = SY.CODIGO_MATERIA AND VCP.CODIGO_ESP = SY.COD_PROGRAMA ")
                .append(" AND  VCP.ANIO = SY.ANIO AND VCP.CICLO = SY.CICLO AND VCP.VAC_CODNUM = SY.VAC_CODNUM AND VCP.COD_PARALELO = SY.COD_PARALELO ")
                .append(" WHERE  VCP.ANIO = ? AND VCP.CICLO = 1 AND VCP.CODIGO_PROFESOR = ? ")
                .append(" AND VCP.CODIGO_MATERIA = ? AND ((SY.ESTADO_SYLABUS = 'P' AND SY.ESTADO_ENVIO = 'P')  or SY.ESTADO_SYLABUS is null) ")
                .append(" ORDER BY  VCP.PROGRAMA,VCP.NOMBRE_MATERIA, VCP.CODIGO_NIVEL,VCP.COD_PARALELO ");
        Query q = em.createNativeQuery(sb.toString(), AsignaturaSyllabus.class);
        q.setParameter(1, anio).setParameter(2, docente).setParameter(3, asignatura);
        List<AsignaturaSyllabus> tmp = q.getResultList();
        return tmp;
    }
}
