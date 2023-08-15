package org.ejemplo.validations;

import org.ejemplo.exceptions.ClienteException;
import org.ejemplo.exceptions.ProductoException;
import org.ejemplo.modelos.Cliente;
import org.ejemplo.repository.ClienteRepository;
import org.springframework.http.HttpStatus;

public class ClienteValidations {

    private final ClienteRepository clienteRepository;

    public ClienteValidations(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void validateNombreCliente(String nombre) throws ClienteException {
        if (nombre.isBlank() && nombre.isEmpty()) {
            throw new ClienteException(HttpStatus.PRECONDITION_FAILED, "El nombre no puede ser nulo", "ClienteExcepcion");
        }
    }

    public Boolean clienteExists(Integer id){
        return clienteRepository.existsById(id);
    }

    public void validateClienteData(Cliente cliente) throws ClienteException {
        if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) {
            throw new ClienteException(HttpStatus.PRECONDITION_FAILED, "El nombre del producto es requerido", "ClienteExcepcion");
        }
        if (cliente.getDni() == null ) {
            throw new ClienteException(HttpStatus.PRECONDITION_FAILED, "La descripción del producto es requerida", "ClienteExcepcion");
        }
        if (cliente.getCuit() == null) {
            throw new ClienteException(HttpStatus.PRECONDITION_FAILED, "El stock del producto es requerido", "ClienteExcepcion");
        }
        if (cliente.getDireccion() == null) {
            throw new ClienteException(HttpStatus.PRECONDITION_FAILED, "El precio del producto es requerido", "ClienteExcepcion");
        }
        if (cliente.getTelefono() == null) {
            throw new ClienteException(HttpStatus.PRECONDITION_FAILED, "El precio del producto es requerido", "ClienteExcepcion");
        }
    }
}