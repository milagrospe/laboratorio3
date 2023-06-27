package org.utn.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.utn.Models.Cancion;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Milagros Pecar
 * @version 1.0
 */
public class CancionRepo implements IRepository<Cancion> {

    /**
     * Constante archivoCanciones
     */
    public final File archivoCanciones = new File("src/main/java/org/utn/Archivos/canciones.json");
    /**
     * Constante mapper
     */
    public final ObjectMapper mapper = new ObjectMapper();
    /**
     * Constante listaCanciones
     */
    public List<Cancion> listaCanciones;


//region OVerrides

    /**
     * Carga la info de un archivo .json a una lista
     */
    @Override
    public void cargar() {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Cancion.class);
            this.listaCanciones = mapper.readValue(archivoCanciones, collectionType);
        } catch (IOException e) {
            this.listaCanciones = new ArrayList<>();
        }
    }

    /**
     *Guarda la informacion de una lista en un archivo .json
     */
    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivoCanciones, this.listaCanciones);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Busca una cancion en un archivo .json
     * @param objeto de clase Cancion
     * @return retorna true si se encuentra la cancion, false si no se encuentra
     */
    @Override
    public boolean buscar(Cancion objeto) {
        boolean cancionEncontrada = false;
        cargar();
        for (Cancion c : this.listaCanciones) {
            if (objeto.getIdCancion() == c.getIdCancion()) {
                cancionEncontrada = true;
            }
        }
        return cancionEncontrada;
    }

    /**
     * Busca cancion por nombre
     * @param nombre de tipo String
     * @return retorna una cancion buscada a partir del nombre
     */

    public Cancion buscarPorNombre(String nombre){
        cargar();
        Cancion cancionEncontrada = new Cancion();
        List<Cancion> listaCanciones = listar();
        for(Cancion c :listaCanciones)
        {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                cancionEncontrada = c;
            }
        }
        return cancionEncontrada;
    }

    /**
     * Busca cancion por album
     * @param album de tipo String
     * @return retorna la cancion buscada a partir del album
     */
    public Cancion buscarPorAlbum(String album){
        cargar();
        Cancion cancionEncontrada = new Cancion();
        List<Cancion> listaCanciones = listar();
        for(Cancion c :listaCanciones)
        {
            if (c.getAlbum().equalsIgnoreCase(album)) {
                cancionEncontrada = c;
            }
        }
        return cancionEncontrada;
    }

    /**
     * Busca cancion por artista
     * @param artista de tipo String
     * @return retorna la cancion buscada a partir del artista
     */
    public Cancion buscarPorArtista(String artista){
        cargar();
        Cancion cancionEncontrada = new Cancion();
        List<Cancion> listaCanciones = listar();
        for(Cancion c :listaCanciones)
        {
            if (c.getArtista().equalsIgnoreCase(artista)) {
                cancionEncontrada = c;
            }
        }
        return cancionEncontrada;
    }


    /**
     * Modifica datos de un archivo .json
     * @param objeto de clase cancion
     */
    @Override
    public void modificar(Cancion objeto) {
        cargar();

        for(Cancion c : this.listaCanciones){
            if(c.getIdCancion() == objeto.getIdCancion()) {
                c.setNombre(objeto.getNombre());
                c.setAlbum(objeto.getAlbum());
                c.setArtista(objeto.getArtista());
                c.setComentarios(objeto.getComentarios());
                c.setDuracion(objeto.getDuracion());
                c.setGenero(objeto.getGenero());
                c.setReproduciendo(objeto.isReproduciendo());
                break;
            }
        }
        guardar();
    }

    /**
     * Elimina una cancion de un archivo .json
     * @param objeto de clase Cancion
     */
    @Override
    public void eliminar(Cancion objeto) {
        cargar();

        this.listaCanciones.remove(objeto);

        guardar();
    }

    /**
     * Devuelve una lista de canciones cuya informacion es obtenida de un archivo .json
     * @return retorna una lista de canciones
     */
    @Override
    public List<Cancion> listar() {
        cargar();
        return this.listaCanciones;
    }

    /**
     * Agrega x cantidad de canciones
     * @param objeto de clase Cancion
     */
    @Override
    public void agregar (Cancion ... objeto){
        cargar();
        this.listaCanciones.addAll(List.of(objeto));
        guardar();
    }
//endregion

//region Metodos

    /**
     * Busca una cancion por ID en un archivo .json
     * @param id de tipo entero
     * @return retorna una objeto de clase cancion a partir de un id pasado por parametro
     */
    public Cancion buscaCancionPorID(int id) {
        Cancion cancionEncontrada = new Cancion();
        cargar();
        for (Cancion c : this.listaCanciones) {
            if (id == c.getIdCancion()) {
                cancionEncontrada = c;
                break;
            }
        }
        return cancionEncontrada;
    }


    /**
     * Busca el id de la ultima cancion agregada en un archivo .json
     * @return retorna el ultimo id
     */
    public int buscarUltimoID(){
        cargar();
        int ultimoId = 0;

        for(Cancion c : this.listaCanciones){
            ultimoId++;
        }
        return ultimoId;
    }

    /**
     * Setea el genero de una cancion de un archivo .json     *
     * @param cancion de tipo cancion
     */
    public void setearGenero(Cancion cancion){
        cargar();
        for (Cancion c : this.listaCanciones){
            if(c.getIdCancion() == cancion.getIdCancion()){
                c.setGenero(cancion.getGenero());
                break;
            }
        }
        cargar();

    }

    /**
     *Setea el estado del atributo reproduciendo de una cancion contenida en un archivo .json
     */
    public void setReproduciendo(Cancion cancion){
        cargar();
        List<Cancion> lista = listar();
        for(Cancion c : lista){
            if(c.getIdCancion() == cancion.getIdCancion()){
                if(c.isReproduciendo()){
                    c.setReproduciendo(false);
                    break;
                }else{
                    c.setReproduciendo(true);
                    break;
                }
            }
        }
        guardar();
    }
    /**
     * Busca cancion que se encuentra reproduciendo
     * @return retorna nulo si la cancion no es encontrada
     */

    public Cancion buscaCancionReproducida(){
        cargar();
        Cancion cancionReproducida = new Cancion();
        List<Cancion> lista = listar();

        for (Cancion c : lista){
            if(c.isReproduciendo()){
                cancionReproducida = c;
                break;
            }
        }
        return cancionReproducida;
    }



//endregion
}

