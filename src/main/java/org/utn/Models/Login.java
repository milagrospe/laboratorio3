package org.utn.Models;

import java.io.Serializable;

/**
 * Esta clase se encarga de manejar el login de los usuarios
 * @author Eliana Rojas
 */
public class Login {

    /**
     * Variable estática que contiene el usuario logueado
     */
    private static Cliente logueado = null;

    /**
     * Constante que indica la Cantidad de intentos restantes para loguearse
     */
    private int intentosRestantes;

    GestionClientes gestionClientes = new GestionClientes();

    /**
     * Constructor de la clase Login
     * Inicializa los intentos restantes en 3
     */
    public Login() {
        this.intentosRestantes = 3;
    }

    /**
     * Método que chequea si el usuario tiene intentos restantes
     * @return true si tiene intentos restantes, false si no
     */
    public boolean tieneIntentosRestantes() {
        return this.intentosRestantes > 0;
    }

    /**
     * Metodo que devuelve la cantidad de intentos restantes
     * @param intentosRestantes cantidad de intentos restantes
     */
    public void setIntentosRestantes(int intentosRestantes) {
        this.intentosRestantes = intentosRestantes;
    }

    /**
     * Chequea si el usuario existe y si la password es correcta buscando ambos parametros en el archivo clientes.json
     * Si lo encuentra lo guarda en la variable estatica logueado de tipo Cliente
     * @param email contiene el email ingresado por el usuario
     * @param password contiene el password ingresado por el usuario
     * @return true si el usuario existe y la password es correcta, false si no
     */
    public boolean iniciarSesion(String email, String password) {

        Cliente cliente = gestionClientes.existeCliente(email);

        if (cliente.getPassword().equals(password)) {

            logueado = cliente;

            return true;
        }
        this.intentosRestantes--;
        return false;
    }

    /**
     * Chequea si el usuario esta logueado
     * @return true si esta logueado, false si no
     */
    public static boolean estaLogueado(){
        return logueado != null;
    }

    /**
     * Chequea si el usuario logueado es administrador
     * @return true si es administrador, false si no
     */
    public static boolean esAdministrador(){
        return logueado.isAdmin();
    }

    /**
     * Me permite retornar al objeto tipo Cliente que contiene los datos del usuario logueado
     * @return objeto tipo Cliente logueado
     */
    public static Cliente getLogueado() {
        return logueado;
    }

}
