package org.ejemplo.controladores;

import org.ejemplo.exceptions.ClienteException;
import org.ejemplo.exceptions.ProductoException;
import org.ejemplo.modelos.Producto;
import org.ejemplo.servicios.ClienteService;
import org.ejemplo.modelos.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")

public class ClienteController {

    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> registryCliente(@RequestBody Cliente cliente) {
        try {
            clienteService.crearCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cargado correctamente");
        } catch (ClienteException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable(value = "id") Integer id) {
        try {
            clienteService.eliminarCliente(id);
            return ResponseEntity.status(HttpStatus.OK).body("Producto eliminado correctamente");
        } catch (ClienteException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCliente(@RequestBody Cliente cliente) {
        try {
            Integer id = cliente.getId();
            clienteService.actualizarCliente(id, cliente);
            return ResponseEntity.ok("Cliente actualizado correctamente.");
        } catch (ClienteException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }
}
