package org.utn.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.utn.Models.Cliente;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase se encarga de guardar, cargar, agregar, buscar y modificar los clientes en el archivo json
 * @author Eliana Rojas
 * @author Matias Siano
 * @see Cliente
 * @see IRepository
 */
public class ClienteRepo implements IRepository<Cliente> {

    /**
     * Atributos de la clase
     */

    /**
     * Atributo de tipo File que representa el archivo json donde se guardan los clientes
     */
    private final File archivo = new File("src/main/java/org/utn/Archivos/clientes.json");

    /**
     * Atributo de tipo ObjectMapper que se encarga de leer y escribir el archivo json
     */
    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Atributo de tipo List que representa la lista de clientes
     */
    private List<Cliente> listaClientes;

    /**
     * Metodo que se encarga de cargar los clientes del archivo json
     */
    @Override
    public void cargar() {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Cliente.class);
            this.listaClientes = mapper.readValue(archivo, collectionType);
        } catch (Exception e) {
            System.out.println("Entre al catch de cargar()");
            System.out.println("e = " + e);
            this.listaClientes = new ArrayList<>();
        }
    }

    /**
     * Metodo que se encarga de guardar los clientes en el archivo json
     */
    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, this.listaClientes);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo guardar el archivo", e);

        }
    }

    /**
     * Metodo que se encarga de agregar uno o varios cliente/s al archivo json
     * @param obj Cliente/s a agregar
     */
    @Override
    public void agregar(Cliente... obj) {

        cargar();
        listaClientes.addAll(List.of(obj));
        guardar();

    }

    /**
     * Metodo que se encarga de buscar un cliente en el archivo json
     * @param objeto Cliente a buscar
     * @return true si el cliente se encuentra en el archivo json, false si no se encuentra
     */
    @Override
    public boolean buscar(Cliente objeto) {
        cargar();
        for (Cliente c : this.listaClientes) {
            if (c.getId() == objeto.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que se encarga de modificar un cliente en el archivo json
     * @param cliente Cliente a modificar
     */
    @Override
    public void modificar(Cliente cliente) {
        cargar();

        for (Cliente c : this.listaClientes) {
            if(c.getId() == cliente.getId()){
                c.setGenero(cliente.getGenero());
                c.setDomicilio(cliente.getDomicilio());
                c.setPremium(cliente.isPremium());
                c.setTipoDePlan(cliente.getTipoDePlan());
                c.setApellido(cliente.getApellido());
                c.setNombre(cliente.getNombre());
                c.setEmail(cliente.getEmail());
                c.setPassword(cliente.getPassword());

                System.out.println("Usuario modificado exitosamente");
                break;
            }
        }

        guardar();


    }

    /**
     * Metodo que se encarga de eliminar un cliente del archivo json
     * @param cliente Cliente a eliminar
     */
    public void eliminar(Cliente cliente) {
        cargar();
        for (Cliente c : this.listaClientes) {

            if (c.getId() == cliente.getId()) {
                this.listaClientes.remove(c);
                break;
            }
        }
        guardar();
    }

    /**
     * Metodo que se encarga de listar los clientes del archivo json
     * @return Lista de clientes
     */
    @Override
    public List<Cliente> listar() {
        cargar();
        return this.listaClientes;
    }

}
