/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import javax.ejb.Local;

/**
 *
 * @author johana.orozco
 */
@Local
public interface ConsultaFacadeLocal {

    public java.util.List ejecutaSqlList(java.lang.String sql);

    public java.lang.String actTesMonUasb(java.lang.String[] testMon);
    
}
