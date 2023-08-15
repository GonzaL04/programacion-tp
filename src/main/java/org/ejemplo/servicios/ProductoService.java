package org.ejemplo.servicios;

import org.ejemplo.exceptions.ProductoException;
import org.ejemplo.modelos.Producto;
import org.ejemplo.repository.ProductoRepository;
import org.ejemplo.validations.ProductoValidations;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;
    private final ProductoValidations productoValidations;

    public ProductoService(ProductoRepository productoRepository, ProductoValidations productoValidations){
        this.productoRepository = productoRepository;
        this.productoValidations = productoValidations;
    }

    public void registrarProducto(Producto producto) throws ProductoException {
        productoValidations.validateExistingProduct(producto.getCodigo());
        productoValidations.validateProductoData(producto);
        producto.setFechaActualizacion(new Date());
        productoRepository.save(producto);
    }

    public void actualizarProducto(String codigo, Producto producto) throws ProductoException {
        productoValidations.validateProductoData(producto);

        Producto existingProducto = productoRepository.findById(codigo)
                .orElseThrow(() -> new ProductoException(HttpStatus.PRECONDITION_FAILED, "El producto no existe.", "ProductoException"));

        existingProducto.setNombre(producto.getNombre());
        existingProducto.setDescripcion(producto.getDescripcion());
        existingProducto.setStock(producto.getStock());
        existingProducto.setPrecio(producto.getPrecio());
        existingProducto.setFechaActualizacion(new Date());

        productoRepository.save(existingProducto);
    }

    public void eliminarProducto(String codigo) throws ProductoException {
        if (!productoValidations.productoExists(codigo)) {
            throw new ProductoException(HttpStatus.PRECONDITION_FAILED, "El producto no existe.", "ProductoException");
        }

        productoRepository.deleteById(codigo);
    }

    // Codigo nuevo

    public String guardarProducto(Producto producto){
        productoRepository.save(producto);
        return "Producto cargado correctamente";
    }

    public List<Producto> retornarProducto(){
        return productoRepository.findAll();
    }
}
