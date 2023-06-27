package org.utn.Models;

import org.utn.Repositorios.ClienteRepo;
import org.utn.Utilidades.Utilidades;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que se encarga de gestionar los clientes
 *
 * @author Eliana Rojas
 * @author Matias Siano
 * @see ClienteRepo
 */
public class GestionClientes {
    /**
     * Instancia de la clase ClienteRepo
     */
    private ClienteRepo clienteRepo = new ClienteRepo();

    //region metodos

    /**
     * Método que se encarga de pedirle los datos del cliente por consola al administrador
     *
     * @return Cliente para que sea agregado al archivo clientes.json
     */
    public Cliente pedirDatosCliente() {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente();
        TipoDePlan tipoPlan;
        Genero genero;
        int opcion;

        System.out.println("Ingrese los datos del nuevo cliente:");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        cliente.setNombre(nombre);

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        cliente.setApellido(apellido);

        System.out.print("Email: ");
        String email = scanner.nextLine();
        cliente.setEmail(email);

        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        cliente.setPassword(password);

        System.out.print("Género: FEMENINO, MASCULINO, NO_BINARIO, OTRO;  ");
        String generoStr = scanner.nextLine();

        try {
            genero = (Genero.valueOf(generoStr.toUpperCase()));
            cliente.setGenero(genero);

        } catch (IllegalArgumentException e) {
            System.out.println("Genero incorrecto");
        }

        System.out.print("Domicilio: ");
        String domicilio = scanner.nextLine();
        cliente.setDomicilio(domicilio);

        System.out.print("¿Es premium? (true/false): ");
        boolean isPremium = scanner.nextBoolean();
        cliente.setPremium(isPremium);


        try {
            if (cliente.isPremium()) {

                System.out.println("Tipo de Plan ---> 1.INDIVIDUAL, 2.DUO, 3. FAMILIAR : ");

                do {
                    System.out.print("Ingrese el número de opción: ");
                    opcion = scanner.nextInt();

                    if ((opcion < 1 || opcion > 3)) {
                        System.out.println("Opción inválida. Intente nuevamente.");
                    }
                } while (opcion < 1 || opcion > 3);

                switch (opcion) {
                    case 1:
                        tipoPlan = TipoDePlan.DUO;
                        cliente.setTipoDePlan(tipoPlan);
                        break;
                    case 2:
                        tipoPlan = TipoDePlan.INDIVIDUAL;
                        cliente.setTipoDePlan(tipoPlan);
                        break;
                    case 3:
                        tipoPlan = TipoDePlan.FAMILIAR;
                        cliente.setTipoDePlan(tipoPlan);
                        break;
                }
            } else {

                tipoPlan = TipoDePlan.GRATIS;
                cliente.setTipoDePlan(tipoPlan);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de plan incorrecto");
        }


        System.out.print("Ingrese su fecha de nacimiento (dd/mm/aaaa): ");
        String fechaNacimiento = scanner.nextLine();
        cliente.setDomicilio(fechaNacimiento);

        return cliente;

    }

    // pedir datos de registro de un nuevo cliente

    /**
     * Método que se encarga de pedirle los datos por consola a un nuevo usuario que desea registrarse en el sistema
     *
     * @return Cliente para que sea agregado al archivo clientes.json
     */
    public Cliente registroNuevoCliente() {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente();
        TipoDePlan tipoPlan;
        Genero genero;
        int opcion;

        System.out.println("Bienvenida/o a Spoti-J! A continuación ingrese sus datos: \n");
        Utilidades.imprimirLineas();

        try {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            cliente.setNombre(nombre);

            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            cliente.setApellido(apellido);

            if (nombre.matches("[\\p{N}\\p{S}]") || apellido.matches("[\\p{N}\\p{S}]")) {
                throw new InputMismatchException("Debe ingresar solo letras.No se admiten numeros");

            }
        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.print("Ingrese su fecha de nacimiento (dd/mm/aaaa): ");
            String fechaNacimiento = scanner.nextLine();

            cliente.setFechaNacimiento(fechaNacimiento);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.print("Domicilio: ");
        String domicilio = scanner.nextLine();
        cliente.setDomicilio(domicilio);

        try {
            System.out.print("Ingrese su correo electrónico: ");
            String email = scanner.nextLine();

            cliente.setEmail(email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.print("Ingrese una contraseña de 6 caracteres alfanuméricos: ");
            String password = scanner.nextLine();

            cliente.setPassword(password);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.print("Género: FEMENINO, MASCULINO, NO_BINARIO, OTRO;  ");
            String generoStr = scanner.nextLine();
            genero = (Genero.valueOf(generoStr.toUpperCase()));
            cliente.setGenero(genero);

        } catch (IllegalArgumentException e) {
            System.out.println("Género incorrecto");
        }


        System.out.print("Desea contratar un plan premium? : 1.Si / 2.No \n ");
        int rta = scanner.nextInt();
        boolean isPremium = rta == 1;

        cliente.setPremium(isPremium);


        try {
            if (cliente.isPremium()) {

                System.out.println("Tipo de Plan ---> 1.INDIVIDUAL, 2.DUO, 3. FAMILIAR :\n ");

                TipoDePlan.INDIVIDUAL.mostrarInformacionPlan();
                TipoDePlan.DUO.mostrarInformacionPlan();
                TipoDePlan.FAMILIAR.mostrarInformacionPlan();

                do {
                    System.out.print("\nIngrese el número de opción: ");
                    opcion = scanner.nextInt();

                    if ((opcion < 1 || opcion > 3)) {
                        System.out.println("Opción inválida. Intente nuevamente.");
                    }
                } while (opcion < 1 || opcion > 3);

                switch (opcion) {
                    case 1:
                        tipoPlan = TipoDePlan.DUO;
                        cliente.setTipoDePlan(tipoPlan);
                        break;
                    case 2:
                        tipoPlan = TipoDePlan.INDIVIDUAL;
                        cliente.setTipoDePlan(tipoPlan);
                        break;
                    case 3:
                        tipoPlan = TipoDePlan.FAMILIAR;
                        cliente.setTipoDePlan(tipoPlan);
                        break;
                }
            } else {

                tipoPlan = TipoDePlan.GRATIS;
                cliente.setTipoDePlan(tipoPlan);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de plan incorrecto");
        }

        return cliente;

    }

    /**
     * Método que se encarga de agregar un cliente al archivo clientes.json
     *
     * @param cliente Cliente que se desea agregar
     */
    public void agregarCliente(Cliente cliente) {
        List<Cliente> listaClientes = clienteRepo.listar();
        try {
            for (Cliente c : listaClientes) {
                if (c.getId() == cliente.getId()) {
                    throw new IllegalArgumentException("El id del cliente ya existe");
                }
            }
            listaClientes.add(cliente);
            System.out.println("Cliente agregado exitosamente");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        clienteRepo.guardar();
    }

    // mostrar un cliente por id

    /**
     * Método que se encarga de mostrar un cliente por id
     *
     * @param id Id del cliente que se desea mostrar
     */
    public void mostrarClientePorId(int id) {
        List<Cliente> listaClientes = clienteRepo.listar();
        try {
            for (Cliente c : listaClientes) {
                if (c.getId() == id) {
                    System.out.println(c);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Método que se encarga de listar todos los clientes del archivo clientes.json
     */
    public void listarClientes() {
        clienteRepo.listar().forEach(System.out::println);
    }

    // mostrar todos los clientes

    /**
     * Método que se encarga de mostrar todos los clientes del archivo clientes.json
     */
    public void mostrarClientes() {
        List<Cliente> listaClientes = clienteRepo.listar();
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }

    /**
     * Método que se encarga de eliminar un cliente del archivo clientes.json
     * Setea el atributo usuarioActivo en false para dar la baja lógica del cliente
     *
     * @param cliente Cliente que se desea eliminar (baja lógica)
     */
    public void eliminarCliente(Cliente cliente) {

        try {
            if (cliente.getId() == 0) {
                throw new IllegalArgumentException("El id del cliente no puede ser cero 0");
            } else {
                cliente.setUsuarioActivo(false);
                System.out.println("Cliente " + cliente.getNombre() + " eliminado exitosamente");
                System.out.println("Estado de usuario: " + cliente.isUsuarioActivo());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método que se encarga de modificar un cliente del archivo clientes.json
     *
     * @param cliente Cliente que se desea modificar
     */
    public void modificarCliente(Cliente cliente) {
        try {
            if (cliente.getId() == 0) {
                throw new IllegalArgumentException("El id del cliente no puede ser cero 0");
            } else {
                clienteRepo.modificar(cliente);
                System.out.println("Cliente" + cliente.getNombre() + "modificado exitosamente");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método que se encarga de mostrar el id del último cliente agregado
     * Me sirve para capturar el último id de la lista de clientes y que el id de un nuevo cliente agregado por el administrador o que se registre, sea generado de forma correcta
     *
     * @return Id del último cliente agregado
     */
    public int idUltimoCliente() {
        List<Cliente> listaClientes = clienteRepo.listar();
        // si la lista esta vacia, el id del primer cliente es 0
        if (listaClientes.isEmpty()) {
            return 0;
        }
        // si la lista no esta vacia, el id del ultimo cliente es el tamaño de la lista -1
        Cliente ultimo = listaClientes.get(listaClientes.size() - 1);
        return ultimo.getId();
    }

    /**
     * Método que se encarga de verificar si el email ingresado por el usuario existe en el archivo clientes.json
     *
     * @param email Email que se desea verificar
     * @return Cliente que se desea verificar
     */
    public Cliente existeCliente(String email) {
        List<Cliente> listaClientes = clienteRepo.listar();
        for (Cliente cliente : listaClientes) {
            // si el email ingresado es igual al email de un cliente existente, devuelvo ese cliente
            if (cliente.email.equals(email)) {
                return cliente;
            }
        }
        // si el email ingresado no existe, lanzo una excepcion
        throw new RuntimeException("El email ingresado no existe ");

    }

    /**
     * Lista los clientes premium que encuentra al recorrer el archivo clientes.json
     */
    public void listarClientesPremium() {
        List<Cliente> listaClientes = clienteRepo.listar();
        for (Cliente cliente : listaClientes) {
            if (cliente.isPremium()) {
                System.out.println(cliente);
            }
        }
    }

    /**
     * Lista los clientes free que encuentra al recorrer el archivo clientes.json
     */
    public void listarClientesFree() {
        List<Cliente> listaClientes = clienteRepo.listar();
        for (Cliente cliente : listaClientes) {
            if (!cliente.isPremium()) {
                System.out.println(cliente);
            }
        }
    }

    /**
     * Lista los administradores que encuentra al recorrer el archivo clientes.json
     */
    public void listarAdministradores() {
        List<Cliente> listaClientes = clienteRepo.listar();
        for (Cliente cliente : listaClientes) {
            if (cliente.isAdmin()) {
                System.out.println(cliente);
            }
        }
    }

    /**
     * Método que se encarga de cambiar el rol de un cliente a administrador
     *
     * @return true si el rol del cliente se cambió a administrador
     */
    public boolean cambiarAdministrador() {
        boolean admin = false;
        System.out.println("Ingrese el id del cliente que desea cambiar su rol a administrador");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        List<Cliente> listaClientes = clienteRepo.listar();
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == id) {
                // si el id ingresado es igual al id de un cliente existente, cambio el rol del cliente a administrador
                cliente.setAdmin(true);
            }
        }
        return admin;
    }

    /**
     * Método que se encarga de buscar un cliente por su id
     *
     * @param id Id del cliente que se desea buscar
     * @return Cliente que contiene el id que coincide con el que se desea buscar
     */
    public Cliente buscarClienteId(int id) {
        List<Cliente> listaClientes = clienteRepo.listar();
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == id) {
                // si el id ingresado es igual al id de un cliente existente, devuelvo ese cliente
                return cliente;
            }
        }
        // si el id ingresado no existe, lanzo una excepcion
        throw new RuntimeException("El id ingresado no existe ");
    }

    /**
     * Método que se encarga de cambiar de plan cuando el cliente lo solicita dentro del menú
     *
     * @param cliente Cliente que desea cambiar de plan
     */
    public void cambiarPlan(Cliente cliente) {
        // si el cliente es free, le muestro los planes que puede elegir
        if (!cliente.isPremium()) {

            Scanner scanner = new Scanner(System.in);
            TipoDePlan tipoPlan;
            int opcion;

            // seteo el cliente como premium
            cliente.setPremium(true);

            System.out.println("Seleccione un Tipo de Plan ---> 1.INDIVIDUAL, 2.DUO, 3. FAMILIAR : ");
            TipoDePlan.INDIVIDUAL.mostrarInformacionPlan();
            TipoDePlan.DUO.mostrarInformacionPlan();
            TipoDePlan.FAMILIAR.mostrarInformacionPlan();

            do {
                System.out.print("Ingrese el número de opción: ");
                opcion = scanner.nextInt();

                if ((opcion < 1 || opcion > 3)) {
                    System.out.println("Opción inválida. Intente nuevamente.");
                }
            } while (opcion < 1 || opcion > 3);

            switch (opcion) {
                case 1:
                    tipoPlan = TipoDePlan.DUO;
                    cliente.setTipoDePlan(tipoPlan);
                    break;
                case 2:
                    tipoPlan = TipoDePlan.INDIVIDUAL;
                    cliente.setTipoDePlan(tipoPlan);
                    break;
                case 3:
                    tipoPlan = TipoDePlan.FAMILIAR;
                    cliente.setTipoDePlan(tipoPlan);
                    break;
            }
            System.out.println("El cliente " + cliente.getNombre() + " ahora es premium");
        } else {
            // si el cliente es premium, lo seteo como free
            cliente.setPremium(false);
            // seteo el plan del cliente como gratis
            cliente.setTipoDePlan(TipoDePlan.GRATIS);
            System.out.println("El cliente " + cliente.getNombre() + " ahora es free");
        }

        clienteRepo.modificar(cliente);
    }


    //endregion
}
