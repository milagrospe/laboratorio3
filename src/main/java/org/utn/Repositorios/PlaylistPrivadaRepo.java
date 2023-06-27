package org.utn.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.utn.Models.Cancion;
import org.utn.Models.Playlist;
import org.utn.Models.PlaylistPrivada;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistPrivadaRepo implements IRepository<PlaylistPrivada> {

    /**
     * Atributo de tipo File que representa el archivo json donde se guardan las playlist privadas
     */
    public final File archivoPlaylistPrivada = new File("src/main/java/org/utn/Archivos/playlistPrivada.json");
    /**
     * Atributo de tipo ObjectMapper que se encarga de leer y escribir el archivo json
     */
    public final ObjectMapper mapper = new ObjectMapper();
    /**
     * Atributo de tipo List que representa la lista de playlists privadas
     */
    public List<PlaylistPrivada> listaPlaylistPrivada;


    //region Overrides

    /**
     * Metodo para cargar el Jason de Playlist Privadas
     */

    @Override
    public void cargar() {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, PlaylistPrivada.class);
            this.listaPlaylistPrivada = mapper.readValue(archivoPlaylistPrivada, collectionType);
        } catch (IOException e) {
            this.listaPlaylistPrivada = new ArrayList<>();
        }
    }

    /**
     * Metodo para guardar en el Json de playlists privadas
     */
    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivoPlaylistPrivada, this.listaPlaylistPrivada);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para agregar una Playlist al Json de Playlist Privadas
     *
     * @param objeto
     */
    @Override
    public void agregar(PlaylistPrivada... objeto) {
        cargar();
        this.listaPlaylistPrivada.addAll(List.of(objeto));
        guardar();
    }

    /**
     * Metodo que devuelve la lista de playlist privadas del Json
     *
     * @return lista de Playlist Privadas
     */
    @Override
    public List<PlaylistPrivada> listar() {
        cargar();
        return this.listaPlaylistPrivada;
    }

    @Override
    public boolean buscar(PlaylistPrivada objeto) {
        return false;
    }

    /**
     * Metodo que modifica una playlist privada del Json
     *
     * @param objeto
     */
    @Override
    public void modificar(PlaylistPrivada objeto) {
        cargar();
        for (PlaylistPrivada playlistPriv : listaPlaylistPrivada) {
            if (playlistPriv.equals(objeto)) {
                playlistPriv.setNombre(objeto.getNombre());
                playlistPriv.setListaCanciones(objeto.getListaCanciones());
                playlistPriv.setIdCliente(objeto.getIdCliente());
                break;
            }
        }
        guardar();
    }

    /**
     * Metodo que elimina una playlist privada del Json
     *
     * @param objeto
     */
    @Override
    public void eliminar(PlaylistPrivada objeto) {
        cargar();
        this.listaPlaylistPrivada.remove(objeto);
        guardar();
    }
    //endregion
}
