package org.utn.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.utn.Models.Cancion;
import org.utn.Models.Playlist;
import org.utn.Models.PlaylistPrivada;
import org.utn.Models.PlaylistPublica;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistPublicaRepo implements IRepository<PlaylistPublica> {

    /**
     * Atributo de tipo File que representa el archivo json donde se guardan las playlist publicas
     */
    public final File archivoPlaylistPublica = new File("src/main/java/org/utn/Archivos/playlistPublica.json");
    /**
     * Atributo de tipo ObjectMapper que se encarga de leer y escribir el archivo json
     */
    public final ObjectMapper mapper = new ObjectMapper();
    /**
     * Atributo de tipo List que representa la lista de playlists publicas
     */
    public List<PlaylistPublica> listaPlaylistPublica;


    //region Overrides

    /**
     * Metodo para cargar el Jason de Playlist Publicas
     */
    @Override
    public void cargar() {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, PlaylistPublica.class);
            this.listaPlaylistPublica = mapper.readValue(archivoPlaylistPublica, collectionType);
        } catch (IOException e) {
            this.listaPlaylistPublica = new ArrayList<>();
        }
    }

    /**
     * Metodo para guardar en el Json de playlists publicas
     */
    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivoPlaylistPublica, this.listaPlaylistPublica);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para agregar una Playlist al Json de Playlist Publicas
     *
     * @param objeto
     */
    @Override
    public void agregar(PlaylistPublica... objeto) {
        cargar();
        this.listaPlaylistPublica.addAll(List.of(objeto));
        guardar();
    }

    /**
     * Metodo que devuelve la lista de playlist publicas del Json
     *
     * @return lista de Playlist Publicas
     */
    @Override
    public List<PlaylistPublica> listar() {
        cargar();
        return this.listaPlaylistPublica;
    }

    @Override
    public boolean buscar(PlaylistPublica objeto) {
        return false;
    }

    /**
     * Metodo que modifica una playlist publica del Json
     *
     * @param objeto
     */
    @Override
    public void modificar(PlaylistPublica objeto) {
        cargar();
        for (PlaylistPublica playlistPub : listaPlaylistPublica) {
            if (playlistPub.equals(objeto)) {
                playlistPub.setNombre(objeto.getNombre());
                playlistPub.setListaCanciones(objeto.getListaCanciones());
                break;
            }
        }
        guardar();
    }

    /**
     * Metodo que elimina una playlist publica del Json
     *
     * @param objeto
     */
    @Override
    public void eliminar(PlaylistPublica objeto) {
        cargar();
        for (PlaylistPublica playlistPublica : this.listaPlaylistPublica) {
            if (listaPlaylistPublica.equals(objeto)) {
                this.listaPlaylistPublica.remove(playlistPublica);
                break;
            }
        }
        guardar();
    }
//endregion
}
