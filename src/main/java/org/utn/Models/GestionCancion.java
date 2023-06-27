package org.utn.Models;

import org.utn.Repositorios.CancionRepo;
import org.utn.Utilidades.Utilidades;

import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

import static org.utn.Utilidades.Utilidades.dibujarRectanguloTexto;

/**
 * @author Milagros Pecar
 * @version 1.0
 */
public class GestionCancion {
    /**
     * Constante repo
     */
    CancionRepo repo = new CancionRepo();
    /**
     * Constante scan
     */
    Scanner scan = new Scanner(System.in);
    /**
     * Constante scanString
     */
    Scanner scanString = new Scanner(System.in);

//region Metodos

    /**
     * Menu que permite buscar canciones segun su nombre, album, artista o genero
     */
    public void menuBusquedaCanciones() {
        Scanner scanString = new Scanner(System.in);
        int eleccion, salir = 0;
        String datoIngresado;
        boolean error = false;

        do {
            try {
                switchBusquedaCanciones();
                System.out.println("Desea volver al menu de busqueda? 1- Continuar  0- Salir");
                salir = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opcion valida"); //volver a menu
                error = true;
                break; // por ahora ayuda a salir del bucle cuando se tira una excepcion

            }

        } while (salir != 0);
    }

    /**
     * Muestra el menu switch para buscar canciones por nombre, album, artista o genero
     */
    public void switchBusquedaCanciones() {
        Scanner scanString = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        String datoIngresado;
        int eleccion = 0;
        boolean encontrar = false;
        Cancion cancionBuscada = new Cancion();

        dibujarRectanguloTexto("Busqueda de canciones");
        Utilidades.imprimirLineas();
        System.out.println("1- Nombre");
        System.out.println("2- Album");
        System.out.println("3- Artista");
        System.out.println("4- Genero");
        Utilidades.imprimirLineas();
        //scan.reset();
        eleccion = scan.nextInt();

        switch (eleccion) {
            case 1:
                do {
                    System.out.println("Ingrese el nombre de la cancion");
                    datoIngresado = scanString.nextLine();
                    cancionBuscada = buscarPorNombre(datoIngresado);
                    encontrar = buscarCancion(cancionBuscada);
                    if (encontrar) {
                        mostrarPorNombre(datoIngresado);
                    } else {
                        System.out.println("Nombre no encontrado");
                    }
                } while (encontrar == false);

                break;

            case 2:
                do {
                    System.out.println("Ingrese el nombre del album");
                    datoIngresado = scanString.nextLine();
                    cancionBuscada = buscarPorAlbum(datoIngresado);
                    encontrar = buscarCancion(cancionBuscada);
                    if (encontrar) {
                        mostrarPorAlbum(datoIngresado);
                    } else {
                        System.out.println("Album no encontrado");
                    }
                } while (encontrar == false);
                break;

            case 3:
                do {
                    System.out.println("Ingrese el nombre del artista");
                    datoIngresado = scanString.nextLine();
                    cancionBuscada = buscarPorArtista(datoIngresado);
                    encontrar = buscarCancion(cancionBuscada);
                    if (encontrar) {
                        mostrarPorArtista(datoIngresado);
                    } else {
                        System.out.println("Artista no encontrado");
                    }
                } while (encontrar == false);
                break;

            case 4:
                do {
                    System.out.println("Ingrese el genero");
                    datoIngresado = scanString.nextLine();
                    cancionBuscada = buscarPorGenero(datoIngresado);
                    encontrar = buscarCancion(cancionBuscada);
                    if (encontrar) {
                        mostrarPorGenero(datoIngresado);
                    } else {
                        System.out.println("Genero no encontrado");
                    }
                } while (encontrar == false);
                break;

            default:
                System.out.println("Opcion no valida. Vuelva a intentarlo");
                break;
        }
    }


    /**
     * Muestra todas las canciones de una lista
     */
    public void mostrarTodas() {
        repo.cargar();
        List<Cancion> listaCanciones = repo.listar();
        if (listaCanciones != null) {
            for (Cancion c : listaCanciones) {
                mostrarUnaCancion(c);
            }
        } else {
            System.out.println("El archivo se encuentra vacio");
        }
    }

    /**
     * Muestra una cancion
     *
     * @param cancion de clase Cancion
     */
    public void mostrarUnaCancion(Cancion cancion) {

        System.out.println(cancion.toString());
    }

    /**
     * Muestra canciones segun el nombre pasado por parametro
     *
     * @param nombre de tipo String
     */
    public void mostrarPorNombre(String nombre) {
        repo.cargar();
        List<Cancion> listaCanciones = repo.listar();
        for (Cancion c : listaCanciones) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                mostrarUnaCancion(c);
            }
        }
    }

    /**
     * Busca una cancion por nombre
     *
     * @param nombre de tipo String
     * @return retorna la cancion encontrada
     */

    public Cancion buscarPorNombre(String nombre) {
        Cancion cancionEncontrada = repo.buscarPorNombre(nombre);
        return cancionEncontrada;
    }

    /**
     * Busca una cancion por album
     *
     * @param album de tipo String
     * @return retorna la cancion encontrada
     */
    public Cancion buscarPorAlbum(String album) {
        Cancion cancionEncontrada = repo.buscarPorAlbum(album);
        return cancionEncontrada;
    }

    /**
     * Busca una cancion por artista
     *
     * @param artista de tipo String
     * @return retorna la cancion encontrada
     */
    public Cancion buscarPorArtista(String artista) {
        Cancion cancionEncontrada = repo.buscarPorArtista(artista);
        return cancionEncontrada;
    }

    /**
     * Muestra canciones segun el artista pasado por parametro
     *
     * @param artista de tipo String
     */
    public void mostrarPorArtista(String artista) {
        repo.cargar();
        List<Cancion> listaCanciones = repo.listar();
        for (Cancion c : listaCanciones) {
            if (c.getArtista().equalsIgnoreCase(artista)) {
                mostrarUnaCancion(c);
            }
        }
    }

    /**
     * Muestra canciones segun el album pasado por parametro
     *
     * @param album de tipo String
     */
    public void mostrarPorAlbum(String album) {
        repo.cargar();
        List<Cancion> listaCanciones = repo.listar();
        for (Cancion c : listaCanciones) {
            if (c.getAlbum().equalsIgnoreCase(album)) {
                mostrarUnaCancion(c);
            }
        }
    }

    /**
     * Muestra canciones segun el nombre pasado por parametro
     *
     * @param generoBusqueda de tipo String
     */
    public void mostrarPorGenero(String generoBusqueda) {
        repo.cargar();
        String genero;
        List<Cancion> listaCanciones = repo.listar();
        for (Cancion c : listaCanciones) {
            genero = devolverGeneroString(c);
            if (generoBusqueda.equalsIgnoreCase(genero)) {
                mostrarUnaCancion(c);
            }
        }
    }

    /**
     * Busca cancion por genero
     *
     * @param generoBusqueda de tipo String
     * @return retorna una cancion
     */
    public Cancion buscarPorGenero(String generoBusqueda) {
        repo.cargar();
        String genero;
        Cancion cancionBuscada = new Cancion();
        List<Cancion> listaCanciones = repo.listar();
        for (Cancion c : listaCanciones) {
            genero = devolverGeneroString(c);
            if (generoBusqueda.equalsIgnoreCase(genero)) {
                cancionBuscada = c;
            }
        }
        return cancionBuscada;
    }

    /**
     * Metodo que devuelve el genero de una cancion de tipo String
     *
     * @param c de tipo Cancion
     * @return retorna el genero de una cancion en formato String
     */
    public String devolverGeneroString(Cancion c) {
        String generoString = "";

        if (c.getGenero().equals(GeneroCancion.KPOP)) {
            generoString = "Kpop";
        } else if (c.getGenero().equals(GeneroCancion.POP)) {
            generoString = "Pop";
        } else if (c.getGenero().equals(GeneroCancion.REGGAETON)) {
            generoString = "Reggaeton";
        } else if (c.getGenero().equals(GeneroCancion.METAL)) {
            generoString = "Metal";
        } else if (c.getGenero().equals(GeneroCancion.RAP)) {
            generoString = "Rap";
        } else if (c.getGenero().equals(GeneroCancion.ROCK)) {
            generoString = "Rock";
        }
        return generoString;
    }

    /**
     * Agrega x cantidad de canciones
     *
     * @param c de tipo cancion
     */
    public void agregarCanciones(Cancion... c) {

        repo.agregar(c);
    }

    /**
     * Menu para agregar canciones por teclado
     */
    public void agregarCancionPorTeclado() {

        int salir, ultimoID, eleccion;
        Cancion nuevaCancion = new Cancion();
        dibujarRectanguloTexto("Biblioteca de canciones");
        Utilidades.imprimirLineas();
        mostrarTodas();
        Utilidades.imprimirLineas();

        try {
            do {
                System.out.println("1- Agregar canciones");
                System.out.println("2- Salir");
                eleccion = scan.nextInt();
                switch (eleccion) {

                    case 1:

                        System.out.println("1- Ingrese el nombre de la cancion");
                        nuevaCancion.setNombre(scanString.nextLine());
                        System.out.println("2- Ingrese el nombre del artista");
                        nuevaCancion.setArtista(scanString.nextLine());
                        System.out.println("3- Ingrese el nombre del album");
                        nuevaCancion.setAlbum(scanString.nextLine());
                        System.out.println("4- Ingrese el genero: Kpop, Metal, Pop, Rap, Reggaeton o Rock");
                        String genero = scanString.nextLine();
                        seteoGenero(nuevaCancion, genero);
                        System.out.println("5- Ingrese la duracion");
                        nuevaCancion.setDuracion(scanString.nextLine());
                        System.out.println("6- Ingrese comentarios");
                        nuevaCancion.setComentarios(scanString.nextLine());
                        ultimoID = repo.buscarUltimoID() + 1;
                        nuevaCancion.setIdCancion(ultimoID);
                        repo.agregar(nuevaCancion);

                        break;

                    case 2:
                        System.out.println("Hasta pronto");
                        break;

                    default:
                        System.out.println("Opcion no valida. Vuelva a intentarlo");
                        break;
                }
                System.out.println("Desea seguir agregando canciones? 1- Continuar  0- Salir");
                salir = scan.nextInt();

            } while (salir != 0);

        } catch (InputMismatchException e) {

            System.out.println("Ingrese un dato correcto");

        }

    }

    /**
     * Elimina una cancion
     *
     * @param c de tipo Cancion
     */
    public void eliminarCancion(Cancion c) {

        repo.eliminar(c);
        System.out.println("Cancion eliminada!");
    }

    /**
     * Busca una cancion
     *
     * @param c de tipo Cancion
     * @return retorna true si encuentra la cancion, false si no la encuentra
     */
    public boolean buscarCancion(Cancion c) {
        boolean encontrar = repo.buscar(c);

        return encontrar;
    }

    /**
     * Menu para modificar una cancion por teclado
     */
    public void modificarCancion() {
        repo.cargar();
        mostrarTodas();
        Cancion cancionModificada = new Cancion();
        int eleccion, cancionElegida;
        int salir = 0;
        do {
            try {

                System.out.println("Ingrese el ID de la cancion a modificar");
                cancionElegida = scan.nextInt();
                cancionModificada = repo.buscaCancionPorID(cancionElegida);

                System.out.println("Ingrese el numero del dato a cambiar");
                System.out.println("1- Nombre");
                System.out.println("2- Artista");
                System.out.println("3- Album");
                System.out.println("3- Album");
                System.out.println("4- Genero");
                System.out.println("5- Duracion");
                System.out.println("6- Comentarios");

                eleccion = scan.nextInt();

                switch (eleccion) {
                    case 1:
                        System.out.println("Ingrese el nuevo nombre");
                        cancionModificada.setNombre(scanString.nextLine());
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo artista");
                        cancionModificada.setArtista(scanString.nextLine());
                        break;
                    case 3:
                        System.out.println("Ingrese el nuevo nombre del album");
                        cancionModificada.setAlbum(scanString.nextLine());
                        break;
                    case 4:
                        System.out.println("Ingrese el nuevo genero");
                        String genero = scanString.nextLine();
                        seteoGenero(cancionModificada, genero);
                        break;
                    case 5:
                        System.out.println("Ingrese la nueva duracion");
                        cancionModificada.setDuracion(scanString.nextLine());
                        break;

                    case 6:
                        System.out.println("Ingrese comentarios");
                        cancionModificada.setComentarios(scanString.nextLine());
                        break;

                    default:
                        System.out.println("Opcion no valida. Vuelva a intentarlo");
                        break;
                }
                repo.modificar(cancionModificada);
                System.out.println("Desea seguir modificando datos? Presione 0 para salir o cualquier otro numero para continuar");
                salir = scan.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Ingrese un dato correcto");    //volver menu ppal
            }
        } while (salir != 0);


    }

    /**
     * Busca el id de la ultima cancion agregada a un archivo
     *
     * @return retorna el id de la ultima cancion agregada a un archivo
     */
    public int buscarUltimoID() {

        return repo.buscarUltimoID();
    }

    /**
     * Setea el genero de una cancion
     *
     * @param c      de tipo Cancion
     * @param genero de tipo String
     */
    public void seteoGenero(Cancion c, String genero) {

        if (genero.equalsIgnoreCase("Rock")) {
            c.setGenero(GeneroCancion.ROCK);
        } else if (genero.equalsIgnoreCase("Pop")) {
            c.setGenero(GeneroCancion.POP);
        } else if (genero.equalsIgnoreCase("Kpop")) {
            c.setGenero(GeneroCancion.KPOP);
        } else if (genero.equalsIgnoreCase("Reggaeton")) {
            c.setGenero(GeneroCancion.REGGAETON);
        } else if (genero.equalsIgnoreCase("Rap")) {
            c.setGenero(GeneroCancion.RAP);
        } else if (genero.equalsIgnoreCase("Metal")) {
            c.setGenero(GeneroCancion.METAL);
        }
        repo.setearGenero(c);
    }

    /**
     * Setea el estado del atributo reproduciendo
     *
     * @param cancion de tipo Cancion
     */
    public void seteoReproduciendo(Cancion cancion) {
        repo.setReproduciendo(cancion);
    }

    /**
     * Busca cancion reproducida
     *
     * @return retorna la cancion que se encuentra reproduciendo. Si no se encuentra ninguna retorna null
     */
    public Cancion buscarCancionReproducida() {
        Cancion cancionReproducida = repo.buscaCancionReproducida();
        return cancionReproducida;
    }

    /**
     * Busca cancion por id
     *
     * @param id de tipo int
     * @return retorna la cancion buscada a partir del id
     */
    public Cancion buscarPorID(int id) {

        Cancion cancionBuscada = repo.buscaCancionPorID(id);

        return cancionBuscada;
    }

    /**
     * Muestra un menu de reproduccion de canciones
     */
    public void menuReproduccion() {
        String opcion;
        int eleccion = 0;
        int busqueda = 0;
        int id;

        dibujarRectanguloTexto("Reproductor");
        try {
            do {
                Cancion cancionNoReproducir = new Cancion();
                Cancion cancionReproducida = buscarCancionReproducida();
                boolean encontrar = buscarCancion(cancionReproducida);

                if (encontrar) {

                    mostrarCancionReproducida(cancionReproducida);
                    int duracion = 30;
                    for (int segundos = 0; segundos <= duracion; segundos++) {

                        System.out.print("\u2588"); // Carácter especial que representa un bloque sólido

                        try {
                            Thread.sleep(200); // Espera 0.2 segundos
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("\n1- Buscar canciones 2- Volver al menu principal\n");
                    busqueda = scan.nextInt();

                } else {
                    System.out.println("\n<< Ninguna cancion reproduciendo >>");
                    System.out.println("\n1- Buscar canciones 2- Volver al menu principal");
                    busqueda = scan.nextInt();
                }

                switch (busqueda) {

                    case 1:
                        switchBusquedaCanciones();
                        cancionNoReproducir = cancionReproducida;
                        seteoReproduciendo(cancionNoReproducir);
                        System.out.println("Ingrese el numero de cancion que desea reproducir");
                        id = scan.nextInt();
                        cancionReproducida = buscarPorID(id);
                        seteoReproduciendo(cancionReproducida);
                        break;

                    case 2:
                        System.out.println("Hasta la proxima");
                        seteoReproduciendo(cancionReproducida);
                        eleccion = 1;
                        break;
                }
            } while (eleccion == 0);
        } catch (InputMismatchException e) {
            System.out.println("Opcion invalida");
        }
    }

    public void menuReproduccionPlaylistPrivada(PlaylistPrivada playlistActiva) {
        int eleccion = 0;
        int busqueda = 0;
        Cancion cancion = new Cancion();
        GestionPlaylistPrivada gestionPlaylistPrivada = new GestionPlaylistPrivada();
        dibujarRectanguloTexto("Reproductor");
        do {
            gestionPlaylistPrivada.verCanciones(playlistActiva);
            System.out.println("Ingrese ID de la cancion que desea reproducir");
            try {
                eleccion = scan.nextInt();

            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
            cancion = existeEnPlaylist(eleccion, playlistActiva.getListaCanciones());
            try {
                if (cancion != null) {
                    mostrarCancionReproducida(cancion);
                    int duracion = 30;
                    for (int segundos = 0; segundos <= duracion; segundos++) {

                        System.out.print("\u2588"); // Carácter especial que representa un bloque sólido

                        try {
                            Thread.sleep(200); // Espera 0.2 segundos
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    throw new IllegalArgumentException("No existe esa cancion en la playlist, ingrese otro id");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("\n1- Volver a la playlist | 2- Volver al menu principal\n");
            busqueda = scan.nextInt();
            switch (busqueda) {
                case 1:
                    menuReproduccionPlaylistPrivada(playlistActiva);
                    break;
                case 2:
                    System.out.println("Hasta la proxima");
                    eleccion = 1;
                    break;
            }
        } while (eleccion == 0);
    }

    public void menuReproduccionPlaylistPublica(PlaylistPublica playlistActiva) {
        int eleccion = 0;
        int busqueda = 0;
        Cancion cancion = new Cancion();
        GestionPlaylistPublica gestionPlaylistPublica = new GestionPlaylistPublica();
        dibujarRectanguloTexto("Reproductor");
        do {
            gestionPlaylistPublica.verCanciones(playlistActiva);
            System.out.println("Ingrese ID de la cancion que desea reproducir");
            try {
                eleccion = scan.nextInt();

            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
            cancion = existeEnPlaylist(eleccion, playlistActiva.getListaCanciones());
            try {
                if (cancion != null) {
                    mostrarCancionReproducida(cancion);
                    int duracion = 30;
                    for (int segundos = 0; segundos <= duracion; segundos++) {

                        System.out.print("\u2588"); // Carácter especial que representa un bloque sólido

                        try {
                            Thread.sleep(200); // Espera 0.2 segundos
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    throw new IllegalArgumentException("No existe esa cancion en la playlist, ingrese otro id");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("\n1- Volver a la playlist | 2- Volver al menu principal\n");
            busqueda = scan.nextInt();
            switch (busqueda) {
                case 1:
                    menuReproduccionPlaylistPublica(playlistActiva);
                    break;
                case 2:
                    System.out.println("Hasta la proxima");
                    eleccion = 1;
                    break;
            }
        } while (eleccion == 0);
    }

    /**
     * Muestra la cancion reproducida
     *
     * @param cancionReproducida de tipo Cancion
     */
    public void mostrarCancionReproducida(Cancion cancionReproducida) {
        System.out.println("<<< Reproduciendo " + cancionReproducida.getNombre() + " de " + cancionReproducida.getArtista() + " >>>");
    }


    /**
     * Busca por id una cancion y retorna la Cancion
     *
     * @param id de tipo int
     * @return retorna una cancion o null si no la encuentra
     */
    public Cancion existe(int id) {
        List<Cancion> listaCanciones = repo.listar();
        for (Cancion cancion : listaCanciones) {
            if (cancion.getIdCancion() == id) {
                return cancion;
            }
        }
        return null;
    }

    /**
     * Busca por id una cancion y la retorna si existe. Recibe una lista de canciones por parametro     *
     *
     * @param id                 de tipo int
     * @param listaCancionesUser de tipo lista
     * @return retorna la cancion o null si no existe en la playlist
     */
    public Cancion existeEnPlaylist(int id, List<Cancion> listaCancionesUser) {
        for (Cancion cancion : listaCancionesUser) {
            if (cancion.getIdCancion() == id) {
                return cancion;
            }
        }
        return null;
    }


//endregion
}

