/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author victor.barba
 */
@Entity
public class Coordinador implements Serializable {

    private static final long serialVersionUID = 105L;
    @Id
    @Column(name = "COORDINADOR")
    private Long codigo;
    @Column(name = "NOMBRE_PROFESOR")
    private String nombres;
    @Column(name = "APELLIDO_PROFESOR")
    private String apellido;
    @Column(name = "EMAIL")
    private String mail;
    @Column(name = "NOMBRE_ESCUELA")
    private String nombreEscuela;

    public Coordinador() {
    }

    public Coordinador(Long codigo, String nombres, String apellido, String mail,String nombreEscuela) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellido = apellido;
        this.mail = mail;
        this.nombreEscuela= nombreEscuela;
    }

    @Override
    public String toString() {
        return "Coordinador{" + "codigo=" + codigo + ", nombres=" + nombres + ", apellido=" + apellido + ", mail=" + mail + ", nombreEscuela=" + nombreEscuela + '}';
    }



    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNombreEscuela() {
        return nombreEscuela;
    }

    public void setNombreEscuela(String nombreEscuela) {
        this.nombreEscuela = nombreEscuela;
    }
}
