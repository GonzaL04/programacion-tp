package org.ejemplo.validations;

import org.ejemplo.exceptions.ClienteException;
import org.ejemplo.exceptions.ProductoException;
import org.ejemplo.modelos.Cliente;
import org.ejemplo.repository.ClienteRepository;
import org.springframework.http.HttpStatus;

public class ClienteValidations implements Validation{

    private final ClienteRepository clienteRepository;

    public ClienteValidations(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void validateNombreCliente(String nombre) throws ClienteException {

    }

    public Boolean clienteExists(Integer id){
        return clienteRepository.existsById(id);
    }

    public void validateClienteData(Cliente cliente) throws ClienteException {
        if (cliente.getNombre().isEmpty() || cliente.getNombre().isBlank()) {
            throw new ClienteException(HttpStatus.PRECONDITION_FAILED, "El nombre del producto es requerido", "ClienteExcepcion");
        }
        if (cliente.getDireccion().isEmpty() || cliente.getDireccion().isBlank()) {
            throw new ClienteException(HttpStatus.PRECONDITION_FAILED, "El precio del producto es requerido", "ClienteExcepcion");
        }
        if (cliente.getTelefono().isEmpty() || cliente.getTelefono().isBlank()) {
            throw new ClienteException(HttpStatus.PRECONDITION_FAILED, "El precio del producto es requerido", "ClienteExcepcion");
        }
    }


    @Override
    public void validarTexto(String nombre) throws ClienteException {
        if (nombre.isBlank() && nombre.isEmpty()) {
            throw new ClienteException(HttpStatus.PRECONDITION_FAILED, "El nombre no puede ser nulo", "ClienteExcepcion");
        }
    }
}