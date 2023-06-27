package org.utn.Models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class PlaylistPrivada extends Playlist implements Serializable {
    /**
     * Atributos de la clase Playlist Privada
     */
    private int idCliente;

    //region Constructores

    /**
     * Contructor vacio de la clase playlist privada
     */
    public PlaylistPrivada() {
    }

    /**
     * Contructor con parametros de la clase Playlist Privada
     *
     * @param nombre
     * @param idPlaylist
     * @param listaCanciones
     * @param idCliente
     */
    public PlaylistPrivada(String nombre, int idPlaylist, List<Cancion> listaCanciones, int idCliente) {
        super(nombre, idPlaylist, listaCanciones);
        this.idCliente = idCliente;
    }

    //endregion

    //region Getters y Setters

    /**
     * Devuelve el ID del cliente asociado a la playlist
     *
     * @return
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Setea el ID del cliente en la playlist privada
     *
     * @param idCliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    //endregion

    /**
     * Override del metodo toString
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }
}