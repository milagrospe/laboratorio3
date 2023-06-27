import org.utn.Models.*;
import org.utn.Utilidades.Utilidades;

import java.util.Scanner;

/**
 * Esta clase se encarga de iniciar la aplicacion y de mostrar el menu principal
 * @autor Eliana Rojas
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Instancia de la clase GestionClientes
         */
        GestionClientes gestionClientes = new GestionClientes();

        /**
         * Constante que almacena el id del ultimo cliente registrado
         */
        int cantidadClientes = gestionClientes.idUltimoCliente();

        /**
         * Se setea el contador de id de la clase Cliente con el id del ultimo cliente registrado
         */
        Cliente.setContadorId(cantidadClientes);

        /**
         * Se llama al metodo iniciarApp
         */
        iniciarApp();

    }

    /**
     * Inicia el menu principal de la aplicacion
     */
    public static void iniciarApp(){

        Scanner scanner = new Scanner(System.in);
        String title = "Seleccione una opcion ";
        System.out.println(title);
        Utilidades.imprimirLineas(title);
        System.out.println("1.Ingresar \n2.Registrarse\n ");

        int opcion = scanner.nextInt();
        GestionClientes gestionClientes = new GestionClientes();
        if( opcion == 1){
            FormLogin.dibujarMenu();
        } else if (opcion == 2){
            Cliente nuevoCliente = gestionClientes.registroNuevoCliente();
            gestionClientes.agregarCliente(nuevoCliente);
            FormLogin.dibujarMenu();
        } else {
            System.out.println("\nLa opción ingresada es incorrecta");
        }
    }

}
