package org.utn.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlaylistPublica extends Playlist implements Serializable {


    //region Constructores

    /**
     * Contructor vacio playlist publica
     */
    public PlaylistPublica() {
    }

    /**
     * Contructor con parametros de las playlist publicas
     *
     * @param nombre
     * @param idPlaylist
     * @param listaCanciones
     */
    public PlaylistPublica(String nombre, int idPlaylist, List<Cancion> listaCanciones) {
        super(nombre, idPlaylist, listaCanciones);
    }

    //endregion
}
