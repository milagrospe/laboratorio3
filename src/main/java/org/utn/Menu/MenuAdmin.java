package org.utn.Menu;

import org.utn.Models.*;
import org.utn.Utilidades.Color;
import java.util.Scanner;
import static org.utn.Utilidades.Utilidades.dibujarRectanguloTexto;

/**
 * Esta clase se encarga de dibujar el menu de administrador y de llamar a los metodos de las clases que se encargan de la gestion de clientes, administradores y canciones
 * @author Eliana Rojas
 *
 */
public class MenuAdmin {

    /**
     * Muestra el menu principal del administrador y lo inicia
     */
    public void iniciarMenuAdmin() {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {
            mostrarMenuPrincipal();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarSubMenuClientes("Gestion Clientes");
                    int opcionSubmenuClientes = scanner.nextInt();
                    manejarOpcionSubMenuClientes(opcionSubmenuClientes);

                    break;

                case 2:
                    mostrarSubMenuCanciones("Gestion Canciones");
                    int opcionSubMenuCanciones = scanner.nextInt();
                    manejarOpcionSubMenuCanciones(opcionSubMenuCanciones);

                    break;
                case 3:
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
     * Metodo que se encarga de mostrar las opciones del menu princiapal de un administrador
     */
    public void mostrarMenuPrincipal() {

        String titulo = "Menu Principal";
        dibujarRectanguloTexto(titulo);

        System.out.println(Color.azul + "1. Gestion Clientes");
        System.out.println("2. Gestion Canciones" + Color.b);

        System.out.println(Color.amarillo + "3. Salir");
        System.out.print(Color.rojo + "Elige una opción: \n" + Color.b);
    }

    /**
     * Metodo que se encarga de mostrar las acciones que puede realizar el administrador en el submenu Gestion Clientes
     * @param opcion  opcion elegida por el administrador
     */
    public void mostrarSubMenuClientes(String opcion) {

        String titulo = " Submenú de " + opcion ;
        dibujarRectanguloTexto(titulo);
        System.out.println("\n");

        System.out.println("1. Dar de alta un Cliente ");
        System.out.println("2. Modificar datos de un cliente "); // falta testear
        System.out.println("3. Dar de baja un Cliente ");
        System.out.println("4. Listar todos los Clientes ");
        System.out.println("5. Listar todos los Clientes Free ");
        System.out.println("6. Listar todos los Clientes Premium ");
        System.out.println("7. Listar Administradores");
        System.out.println("8. Volver al menú principal ");
        System.out.print("Elige una opción: ");
    }

    /**
     * Metodo que se encarga de mostrar las acciones que puede realizar el administrador en el submenu Gestion Canciones
     * @param opcion opcion elegida por el administrador
     */
    public void mostrarSubMenuCanciones(String opcion){

        String titulo = " Submenú de " + opcion;
        dibujarRectanguloTexto(titulo);

        System.out.println("1. Dar de alta una Cancion ");
        System.out.println("2. Modificar datos de una Cancion");
        System.out.println("3. Dar de baja una Cancion ");
        System.out.println("4. Listar todas las canciones ");
        System.out.println("5. Volver al menú principal ");
        System.out.print("Elige una opción: ");

    }


    /**
     * Este metodo se encarga de manejar las opciones del submenu de  gestionClientes
     * @param opcionSubMenuClientes opcion elegida por el administrador
     */
    public void manejarOpcionSubMenuClientes(int opcionSubMenuClientes) {

        GestionClientes gestionClientes = new GestionClientes();
        switch (opcionSubMenuClientes) {

            case 1:

                Cliente cliente = gestionClientes.pedirDatosCliente();
                gestionClientes.agregarCliente(cliente);
                break;
            case 2:

                Cliente clienteAModificar = gestionClientes.buscarClienteId(5);
                gestionClientes.modificarCliente(clienteAModificar);

                break;
            case 3:

                Cliente bajaCliente = gestionClientes.buscarClienteId(2);
                System.out.println(bajaCliente);
                gestionClientes.eliminarCliente(bajaCliente);

                break;
            case 4:

                gestionClientes.mostrarClientes();
                break;
            case 5:

                gestionClientes.listarClientesFree();

                break;
            case 6:

                gestionClientes.listarClientesPremium();
                break;
            case 7:
                gestionClientes.listarAdministradores();
                break;
            case 8:
                System.out.println("Volviendo al menu principal...");
                break;
            default:
                System.out.println("Opción inválida. Introduce un número válido.");
                break;
        }
    }

    /**
     * Este metodo se encarga de manejar las opciones del submenu de  gestionCanciones
     * @param opcionSubMenuCanciones opcion elegida por el administrador
     */
    public void manejarOpcionSubMenuCanciones(int opcionSubMenuCanciones) {

        GestionCancion gestionCancion = new GestionCancion();
        Scanner scanner = new Scanner(System.in);

        switch (opcionSubMenuCanciones) {
            case 1:

                gestionCancion.agregarCancionPorTeclado();
                break;
            case 2:

                gestionCancion.mostrarTodas();
                gestionCancion.modificarCancion();
                break;
            case 3:

                gestionCancion.mostrarTodas();
                System.out.println("Ingrese el id de la cancion que desea eliminar: ");
                int idCancionEliminar = scanner.nextInt();
                Cancion cancionEliminar = gestionCancion.buscarPorID(idCancionEliminar);
                gestionCancion.eliminarCancion(cancionEliminar);
                break;
            case 4:

                gestionCancion.mostrarTodas();
                break;
            case 5:
                System.out.println("Volviendo al menu principal...");
                break;
            default:
                System.out.println("Opción inválida. Introduce un número válido.");
                break;
        }
    }


}