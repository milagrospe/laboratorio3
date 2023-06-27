package org.utn.Menu;

import org.utn.Models.*;
import org.utn.Utilidades.Color;

import java.util.Scanner;

import static org.utn.Utilidades.Utilidades.dibujarRectanguloTexto;

/**
 * Esta clase se encarga de dibujar el menu de un cliente dependiendo si es free o premium
 *
 * @author Eliana Rojas
 */
public class MenuCliente {

    /**
     * Instancias de las clases que se encargan de la gestion de clientes, playlist y canciones
     */
    GestionClientes gestionClientes = new GestionClientes();
    GestionPlaylistPrivada gestionPlaylistPrivada = new GestionPlaylistPrivada();
    GestionCancion gestionCancion = new GestionCancion();

    /**
     * Instancia tipo de plan inicializada en null
     */
    TipoDePlan tipoPlan;

    /**
     * Instancia de la clase Biblioteca
     */
    Biblioteca biblioteca = new Biblioteca();


    /**
     * Muestra el menu principal del cliente free y lo inicia
     */
    public void iniciarMenuClienteFree() {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {


            mostrarMenuClienteFree();
            opcion = scanner.nextInt();

            Cliente clienteLogueado = Login.getLogueado();
            int idClienteActual = clienteLogueado.getId();

            switch (opcion) {
                case 1:

                    System.out.println("Mis playlist");

                    biblioteca.mostrarBibliotecaCliente(idClienteActual);

                    break;
                case 2:

                    biblioteca.mostrarBibliotecaCliente(idClienteActual);
                    biblioteca.ingresoPlaylistUsuarioFree(idClienteActual);

                    break;
                case 3:

                    Cliente cliente = gestionClientes.buscarClienteId(idClienteActual);

                    gestionClientes.cambiarPlan(cliente);
                    FormLogin.dibujarMenu();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Introduce un número válido.");
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Renderiza las opciones del menu principal de un cliente free
     */
    public void mostrarMenuClienteFree() {

        String titulo = "Bienvenido a Spoti-J - Free";
        dibujarRectanguloTexto(titulo);

        System.out.println(Color.azul + "1. Ver mis Playlists");
        System.out.println("2. Seleccionar una Playlist");
        System.out.println("3. Cambiar a Premium");
        System.out.println(Color.amarillo + "4. Salir" + Color.b);
        System.out.print(Color.rojo + "Elige una opción: \n" + Color.b);
    }

    /**
     * Muestra el menu principal del cliente premium y lo inicia
     */
    public void iniciarMenuClientePremium() {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 6) {

            mostrarMenuClientePremium();
            Cliente clienteLogueado = Login.getLogueado();
            int idClienteActual = clienteLogueado.getId();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:

                    biblioteca.mostrarBibliotecaCliente(idClienteActual);

                    break;
                case 2:

                    PlaylistPrivada playlist = biblioteca.crearPlaylistDesdeBiblioteca(idClienteActual);

                    gestionCancion.switchBusquedaCanciones();

                    gestionPlaylistPrivada.agregarCancion(playlist);

                    biblioteca.mostrarBibliotecaCliente(idClienteActual);
                    break;
                case 3:

                    biblioteca.mostrarBibliotecaCliente(idClienteActual);
                    biblioteca.escucharDesdeBiblioteca();

                    break;
                case 4:
                    biblioteca.eliminarDesdeBiblioteca();

                    break;
                case 5:
                    System.out.println("Cambiar a plan free");
                    Cliente cliente = gestionClientes.buscarClienteId(idClienteActual);
                    gestionClientes.cambiarPlan(cliente);
                    FormLogin.dibujarMenu();

                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Introduce un número válido.");
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Renderiza las opciones del menu principal de un cliente premium
     */
    public void mostrarMenuClientePremium() {

        String titulo = "Bienvenido a Spoti-J - Premium";
        dibujarRectanguloTexto(titulo);

        System.out.println(Color.azul + "1. Ver mis playlist");
        System.out.println("2. Crear una nueva playlist");
        System.out.println("3. Seleccionar y ...");
        System.out.println("\t\tescuchar una canción");
        System.out.println("\t\tagregar una canción ");
        System.out.println("\t\teliminar una canción ");
        System.out.println("4. Eliminar Playlist");
        System.out.println("5. Quiero pasarme al plan Free");
        System.out.println(Color.amarillo + "6. Salir" + Color.b);
        System.out.print(Color.rojo + "Elige una opción: \n" + Color.b);
    }
}