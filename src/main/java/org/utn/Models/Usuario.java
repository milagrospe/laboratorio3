package org.utn.Models;

import java.util.Objects;

/**
 * Clase abstracta que representa a un usuario del sistema
 * @author Eliana Rojas
 * @author Matias Siano
 */

public  abstract class Usuario {

    /**
     * Atributos de la clase Usuario
     */
    /**
     * Nombre del usuario
     */
    protected String nombre;

    /**
     * Apellido del usuario
     */
    protected String apellido;

    /**
     * Email del usuario
     */
    protected String email;

    /**
     * Password del usuario
     */
    protected String password;

    /**
     * Indica si el usuario es administrador o no
     */
    protected boolean admin;

    /**
     * Contador de id de usuarios
     */
    private static int contadorId = 0 ;

    /**
     * Id del usuario
     */
    protected int id;

    /**
     * Indica si el usuario esta activo o no
     */
    protected boolean usuarioActivo = true;


    //region Constructores

    /**
     * Constructor de la clase Usuario
     * Inicializa el contador de id de usuarios
     */
    public Usuario() {
        this.id = ++Usuario.contadorId;
    }

    /**
     * Constructor de la clase Usuario
     * Inicializa el contador de id de usuarios
     * @param nombre nombre del usuario
     * @param apellido apellido del usuario
     * @param email email del usuario
     * @param password password del usuario
     */
    public Usuario(String nombre, String apellido, String email,String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.admin = false;
        this.id = ++Usuario.contadorId;
    }

    /**
     * Constructor para leer un cliente del json con un id que ya existe
     * @param nombre nombre del usuario
     * @param apellido apellido del usuario
     * @param email email del usuario
     * @param password password del usuario
     * @param id id del usuario
     */
    public Usuario(String nombre, String apellido, String email, String password, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.admin = false;
        this.id = id;
    }

    //endregion

    //region Getters y Setters

    /**
     * Devuelv el nombre del usuario
     * @return nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setea el nombre del usuario
     * @param nombre nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el apellido del usuario
     * @return apellido del usuario
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Setea el apellido del usuario
     * @param apellido apellido del usuario
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Devuelve el email del usuario
     * @return email del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setea el email del usuario
     * @param email email del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve el password del usuario
     * @return password del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setea el password del usuario
     * @param password password del usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Devuelve si el usuario es administrador o no
     * @return true si es administrador, false si no lo es
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Setea si el usuario es administrador o no
     * @param admin true si es administrador, false si no lo es
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    /**
     * Devuelve el contador de id de usuarios
     * @return contador de id de usuarios
     */
    public static int getContadorId() {
        return contadorId;
    }

    /**
     * Setea el contador de id de usuarios
     * @param contadorId contador de id de usuarios
     */
    public static void setContadorId(int contadorId) {
        Usuario.contadorId = contadorId;
    }

    /**
     * Devuelve el id del usuario
     * @return id del usuario
     */
    public int getId() {
        return id;
    }

    /**
     * Setea el id del usuario
     * @param id id del usuario
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve si el usuario esta activo o no
     * @return true si esta activo, false si no lo esta
     */
    public boolean isUsuarioActivo() {
        return usuarioActivo;
    }

    /**
     * Setea si el usuario esta activo o no
     * @param usuarioActivo true si esta activo, false si no lo esta
     */
    public void setUsuarioActivo(boolean usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }

    //endregion

    // region toString

    /**
     * Devuelve un String con los datos del usuario
     * @return String con los datos del usuario
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Datos del Usuario con id: ");
        sb.append(id).append('\'');
        sb.append("Nombre = '").append(nombre).append('\'');
        sb.append(", Apellido = '").append(apellido).append('\'');
        sb.append(", email = '").append(email).append('\'');
        sb.append(", password = '").append(password).append('\'');
        sb.append(", isAdmin = '").append(admin).append('\'');

        return sb.toString();
    }

    //endregion

    // region Equals & HashCode

    /**
     * Compara si dos usuarios son iguales
     * @param o usuario a comparar
     * @return true si son iguales, false si no lo son
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id && Objects.equals(email, usuario.email);
    }

    /**
     * Devuelve el hashcode del usuario
     * @return hashcode del usuario
     */
    @Override
    public int hashCode() {
        return Objects.hash(email, id);
    }
}
