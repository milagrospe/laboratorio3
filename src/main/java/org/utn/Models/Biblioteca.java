package org.utn.Models;

import org.utn.Repositorios.PlaylistPrivadaRepo;
import org.utn.Repositorios.PlaylistPublicaRepo;
import org.utn.Utilidades.Color;
import org.utn.Utilidades.Utilidades;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {


    /**
     * Este metodo muestra la biblioteca del cliente (playlist publicas y privadas si fuese un usuario Premium)
     *
     * @param idCliente
     * @author Agostina Cardinali
     */
    public void mostrarBibliotecaCliente(int idCliente) {
        PlaylistPrivadaRepo playlistPrivadaRepo = new PlaylistPrivadaRepo();
        PlaylistPublicaRepo playlistPublicaRepo = new PlaylistPublicaRepo();
        Utilidades utilidades = new Utilidades();
        List<PlaylistPrivada> playlistPrivadas = new ArrayList<>();
        playlistPrivadas = playlistPrivadaRepo.listar();
        List<PlaylistPublica> playlistPublicas = new ArrayList<>();
        playlistPublicas = playlistPublicaRepo.listar();
        GestionClientes gestionClientes = new GestionClientes();
        Cliente cliente = new Cliente();
        cliente = gestionClientes.buscarClienteId(idCliente);
        String titulo = "Playlists Publicas";
        utilidades.dibujarRectanguloTexto(Color.celeste + titulo + Color.b);
        for (PlaylistPublica playlistPublica : playlistPublicas) {
            System.out.println(playlistPublica);
            utilidades.imprimirLineas();
        }
        if (cliente.isPremium()) {
            titulo = "Playlists Privadas";
            utilidades.dibujarRectanguloTexto(Color.celeste + titulo + Color.b);
            for (PlaylistPrivada playlistPrivada : playlistPrivadas) {
                if (playlistPrivada.getIdCliente() == idCliente) {
                    System.out.println(playlistPrivada);
                    utilidades.imprimirLineas();
                }
            }
        }
    }

    /**
     * Este metodo es el menu de ingreso a las playlist publicas para un usuario Free
     *
     * @param idCliente
     * @author Agostina Cardinali
     */
    public void ingresoPlaylistUsuarioFree(int idCliente) {
        Scanner scanner = new Scanner(System.in);
        GestionPlaylistPublica gestionPlaylistPublica = new GestionPlaylistPublica();
        int idPlaylist = 0;
        PlaylistPublica playlistActiva;
        System.out.println("Ingrese ID de la playlist a la que desea escuchar");
        try {
            idPlaylist = scanner.nextInt();
            scanner.reset();
        } catch (InputMismatchException e) {
            e.getMessage();
        }
        playlistActiva = gestionPlaylistPublica.existePlaylist(idPlaylist);
        try {
            if (playlistActiva != null) {
                gestionPlaylistPublica.verCanciones(playlistActiva);
                menuPlaylistPublica(playlistActiva);
            } else {
                throw new IllegalArgumentException("ID no existe, ingrese otro ID");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Este metodo elimina una playlist privada de un usuario Premiun a partir del ID de la playlist
     *
     * @author Agostina Cardinali
     */
    public void eliminarDesdeBiblioteca() {

        Scanner scanner = new Scanner(System.in);
        GestionPlaylistPrivada gestionPlaylistPrivada = new GestionPlaylistPrivada();
        int idPlaylist = 0;

        System.out.println("Ingrese ID de la playlist que desea eliminar");
        try {
            idPlaylist = scanner.nextInt();
            scanner.reset();
        } catch (InputMismatchException e) {
            e.getMessage();
        }
        if (idPlaylist <= 3) {
            System.out.println("Ingrese un ID de una playlist propia");
        } else {
            gestionPlaylistPrivada.eliminarPlaylist(idPlaylist);
        }
    }

    /**
     * Este metodo reproduce una cancion de una playlist publica o privada
     *
     * @author Agostina Cardinali
     */
    public void escucharDesdeBiblioteca() {

        Scanner scanner = new Scanner(System.in);
        GestionPlaylistPrivada gestionPlaylistPrivada = new GestionPlaylistPrivada();
        GestionPlaylistPublica gestionPlaylistPublica = new GestionPlaylistPublica();
        int idPlaylist = 0;
        Playlist playlistActiva;

        System.out.println("Ingrese ID de la playlist que desea escuchar");
        try {
            idPlaylist = scanner.nextInt();
            scanner.reset();
        } catch (InputMismatchException e) {
            e.getMessage();
        }
        try {
            if (idPlaylist <= 3) {
                playlistActiva = gestionPlaylistPublica.existePlaylist(idPlaylist);
                menuPlaylistPublica((PlaylistPublica) playlistActiva);
            } else if (idPlaylist > 3) {
                playlistActiva = gestionPlaylistPrivada.existePlaylist(idPlaylist);
                menuPlaylistPrivada((PlaylistPrivada) playlistActiva);
            } else {
                throw new IllegalArgumentException("ID no existe, ingrese otro ID");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Este metodo llama al metodo para crear una playlist privada que se encuentra en Gestion
     *
     * @param idCliente
     * @return PlaylistPrivada
     * @author Agostina Cardinali
     */
    public PlaylistPrivada crearPlaylistDesdeBiblioteca(int idCliente) {
        GestionPlaylistPrivada gestionPlaylistPrivada = new GestionPlaylistPrivada();
        PlaylistPrivada playlistPrivada = gestionPlaylistPrivada.crearPlaylist(idCliente);

        return playlistPrivada;
    }

    /**
     * Este metodo es el menu para un usuario Premiun cuando ya esta dentro de una playlist
     *
     * @param playlistPrivActiva
     * @author Agostina Cardinali
     */
    public void menuPlaylistPrivada(PlaylistPrivada playlistPrivActiva) {
        Scanner scanner = new Scanner(System.in);
        GestionPlaylistPrivada gestionPlaylistPriv = new GestionPlaylistPrivada();
        int opcion;
        System.out.println("Que desea hacer?");
        System.out.println("1. Escuchar cancion");
        System.out.println("2. Agregar cancion");
        System.out.println("3. Eliminar cancion");
        opcion = scanner.nextInt();
        switch (opcion) {
            case 1: //escuchar cancion
                GestionCancion gestionCancion = new GestionCancion();
                gestionCancion.menuReproduccionPlaylistPrivada(playlistPrivActiva);
                //gestionCancion.menuReproduccionPlaylistPrivada(playlistPrivActiva.getIdPlaylist());
                break;
            case 2:
                gestionPlaylistPriv.agregarCancion(playlistPrivActiva);
                break;
            case 3:
                gestionPlaylistPriv.eliminarCancion(playlistPrivActiva);
                break;
        }
    }

    /**
     * Este metodo es el menu para usuario Premiun y Free que acceden a una playlist Publica
     *
     * @param playlistPubActiva
     */
    public void menuPlaylistPublica(PlaylistPublica playlistPubActiva) {
        GestionCancion gestionCancion = new GestionCancion();
        gestionCancion.menuReproduccionPlaylistPublica(playlistPubActiva);
    }
}
