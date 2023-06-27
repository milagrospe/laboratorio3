package org.utn.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Playlist {

    /**
     * Atributos de la clase Playlist
     */

    protected String nombre;

    /**
     * id de la playlist
     */
    protected int idPlaylist;

    /**
     * Lista de canciones de la playlist
     */
    protected List<Cancion> listaCanciones = new ArrayList<Cancion>();

    //region Constructores

    /**
     * Constructor por defecto
     */
    public Playlist() {
    }

    /**
     * Constructor con parametros
     *
     * @param nombre         de la playlist
     * @param idPlaylist     de la playlist
     * @param listaCanciones de la playlist
     */
    public Playlist(String nombre, int idPlaylist, List<Cancion> listaCanciones) {
        this.nombre = nombre;
        this.idPlaylist = idPlaylist;
        this.listaCanciones = listaCanciones;
    }

    //endregion

    //region Getters y Setters

    /**
     * Devuelve el id de la playlist
     *
     * @return id de la playlist
     */
    public int getIdPlaylist() {
        return idPlaylist;
    }

    /**
     * Setea el id de la playlist
     *
     * @param idPlaylist
     */
    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    /**
     * Devuelve el nombre de la playlist
     *
     * @return nombre de la playlist
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setea el nombre de la playlist
     *
     * @param nombre de la playlist
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la lista de canciones de la playlist
     *
     * @return lista de canciones de la playlist
     */
    public List<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    /**
     * Setea la lista de canciones de la playlist
     *
     * @param listaCanciones de la playlist
     */
    public void setListaCanciones(List<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    //endregion

    //region Metodos

    /**
     * Devuelve un String con el nombre de la playlist, el id y la lista de canciones
     *
     * @return String con el nombre de la playlist, el id y la lista de canciones
     */
    @Override
    public String toString() {
        return "Playlist: " + nombre + "\t| ID: " + idPlaylist + "\nCanciones:" + listaCanciones;
    }

    /**
     * Compara si dos objetos son iguales en funcion de su id
     *
     * @param o objeto a comparar
     * @return true si son iguales, false si no lo son
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return idPlaylist == playlist.idPlaylist;
    }

    /**
     * Devuelve el hashcode de la playlist
     *
     * @return hashcode de la playlist
     */
    @Override
    public int hashCode() {
        return Objects.hash(idPlaylist);
    }
}