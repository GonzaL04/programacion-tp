package org.ejemplo.controladores;

import org.ejemplo.exceptions.ProductoException;
import org.ejemplo.modelos.Producto;
import org.ejemplo.servicios.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> registryProduct(@RequestBody Producto producto) {
        try {
            productoService.registrarProducto(producto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Producto registrado correctamente");
        } catch (ProductoException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProduct(@RequestBody Producto producto) {
        try {
            String codigo = producto.getCodigo();
            productoService.actualizarProducto(codigo, producto);
            return ResponseEntity.ok("Producto actualizado correctamente.");
        } catch (ProductoException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @PostMapping("/delete/{codigo}")
    public ResponseEntity<String> deleteProduct(@PathVariable(value = "codigo") String codigo) {
        try {
            productoService.eliminarProducto(codigo);
            return ResponseEntity.status(HttpStatus.OK).body("Producto eliminado correctamente");
        } catch (ProductoException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }
}
