package org.ejemplo.servicios;

import org.ejemplo.exceptions.ClienteException;
import org.ejemplo.modelos.Cliente;
import org.ejemplo.repository.ClienteRepository;
import org.ejemplo.validations.ClienteValidations;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteValidations clienteValidations;

    public ClienteService(ClienteRepository clienteRepository, ClienteValidations clienteValidations) {
        this.clienteRepository = clienteRepository;
        this.clienteValidations = clienteValidations;
    }

    public void crearCliente(Cliente cliente) throws ClienteException {
        clienteValidations.validateNombreCliente(cliente.getNombre());

        clienteRepository.save(cliente);
    }

    public void eliminarCliente(Integer id) throws ClienteException {
        if (!clienteValidations.clienteExists(id)) {
            throw new ClienteException(HttpStatus.PRECONDITION_FAILED, "El cliente no existe", "ClienteExcepcion");
        }

        clienteRepository.deleteById(id);
    }

    public void actualizarCliente(Integer id, Cliente cliente) throws ClienteException{
        clienteValidations.validateClienteData(cliente);

        Cliente existingCliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteException(HttpStatus.PRECONDITION_FAILED, "El cliente no existe.", "ClienteException"));

        existingCliente.setNombre(cliente.getNombre());
        existingCliente.setDni(cliente.getDni());
        existingCliente.setCuit(cliente.getCuit());
        existingCliente.setDireccion(cliente.getDireccion());
        existingCliente.setTelefono(cliente.getTelefono());

        clienteRepository.save(existingCliente);
    }
}
