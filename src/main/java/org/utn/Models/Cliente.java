package org.utn.Models;

import java.io.Serializable;

/**
 * Esta clase representa a un cliente del sistema
 *
 * @author Eliana Rojas
 * @see Genero
 * @see TipoDePlan
 */
public class Cliente extends Usuario implements Serializable {

    //region Properties

    /**
     * Genero del cliente
     * Es una enumeracion
     */
    public Genero genero;
    /**
     * Domicilio del cliente
     */
    private String domicilio;
    /**
     * Booleano que indica si el cliente es premium o no
     */
    private boolean premium;
    /**
     * Tipo de plan del cliente
     * Es una enumeracion
     */
    private TipoDePlan tipoDePlan;
    /**
     * Fecha de nacimiento del cliente
     */
    private String fechaNacimiento;

    //endregion


    //region Constructores

    /**
     * Constructor vacio
     */
    public Cliente() {
        super();
    }

    /**
     * Este constructor se usa para crear el cliente cargado por el administrador o para crear un nuevo cliente que se registra en el sistema
     * @param nombre del cliente
     * @param apellido del cliente
     * @param email del cliente
     * @param password del cliente
     * @param genero del cliente
     * @param domicilio del cliente
     * @param premium indica si el cliente es premium o no
     * @param tipoDePlan del cliente
     * @param fechaNacimiento del cliente
     */

    public Cliente(String nombre, String apellido, String email,
                   String password,
                   Genero genero, String domicilio, boolean premium, TipoDePlan tipoDePlan, String fechaNacimiento) {
        super(nombre, apellido, email, password);
        this.genero = genero;
        this.domicilio = domicilio;
        this.premium = premium;
        this.tipoDePlan = tipoDePlan;
        this.fechaNacimiento = fechaNacimiento;
    }


    public Cliente(String nombre, String apellido, String email, String password, int id,
                   Genero genero, String domicilio, boolean premium, TipoDePlan tipoDePlan, String fechaNacimiento) {
        super(nombre, apellido, email, password, id);
        this.genero = genero;
        this.domicilio = domicilio;
        this.premium = premium;
        this.tipoDePlan = tipoDePlan;
        this.fechaNacimiento = fechaNacimiento;
    }


    //endregion

    //region Getters y Setters

    /**
     * Devuelve el genero del cliente
     * @return genero del cliente
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Setea el genero del cliente
     * @param genero del cliente
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Devuelve el domicilio del cliente
     * @return String con el domicilio del cliente
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Setea el domicilio del cliente
     * @param domicilio del cliente
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Devuelve si el cliente es premium o no
     * @return booleano que indica si el cliente es premium o no
     */
    public boolean isPremium() {
        return premium;
    }

    /**
     * Setea si el cliente es premium o no
     * @param premium booleano que indica si el cliente es premium o no
     */
    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    /**
     * Devuelve el tipo de plan del cliente
     * @return tipo de plan del cliente
     */
    public TipoDePlan getTipoDePlan() {
        return tipoDePlan;
    }

    /**
     * Setea el tipo de plan del cliente
     * @param tipoDePlan del cliente
     */
    public void setTipoDePlan(TipoDePlan tipoDePlan) {
        this.tipoDePlan = tipoDePlan;
    }

    /**
     * Devuelve la fecha de nacimiento del cliente
     * @return fecha de nacimiento del cliente
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Setea la fecha de nacimiento del cliente
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    //endregion


    /**
     * Devuelve un String con los datos del cliente
     * @return
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append(", Id Cliente=").append(id);

        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append("genero=").append(genero);
        sb.append(", domicilio='").append(domicilio).append('\'');


        sb.append(", password='").append(password).append('\'');

        sb.append(", isPremium=").append(premium);
        sb.append(", tipoDePlan=").append(tipoDePlan);

        sb.append(", isAdmin=").append(admin);


        sb.append('}');
        return sb.toString();
    }

    //endregion
}
