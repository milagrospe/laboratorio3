package org.utn.Models;

/**
 * Enum que contiene los tipos de plan que puede tener un cliente
 *
 * @author Eliana Rojas
 */
public enum TipoDePlan {

    GRATIS(0, 1),
    DUO(549, 2),
    INDIVIDUAL(399, 1),
    FAMILIAR(649, 4);

    /**
     * Atributos
     */
    private int precio;
    private double cantidadDeUsuarios;

    /**
     * Constructor
     *
     * @param precio             del plan
     * @param cantidadDeUsuarios que permite el plan
     */
    TipoDePlan(int precio, double cantidadDeUsuarios) {
        this.precio = precio;
        this.cantidadDeUsuarios = cantidadDeUsuarios;
    }


    // region Getters y Setters

    /**
     * Devuelve el precio del plan
     *
     * @return precio del plan
     */
    public int getPrecio() {
        return this.precio;
    }

    /**
     * Devuelve la cantidad de usuarios que permite el plan
     *
     * @return cantidad de usuarios que permite el plan
     */
    public double getCantidadDeUsuarios() {
        return this.cantidadDeUsuarios;
    }

    //endregion

    // region metodos

    /**
     * Muestra la informacion del plan
     */
    public void mostrarInformacionPlan() {
        System.out.println("El plan " + this.name() + " tiene un precio de $" + this.precio + " y permite " + this.cantidadDeUsuarios + " usuarios");
    }

    //endregion

}
