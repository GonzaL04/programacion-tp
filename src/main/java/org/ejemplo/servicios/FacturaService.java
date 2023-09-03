package org.ejemplo.servicios;

import lombok.extern.slf4j.Slf4j;
import org.ejemplo.modelos.Factura;
import org.ejemplo.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FacturaService {
    @Autowired
    FacturaRepository facturaRepository;

    public String guardar(Factura factura) {
        facturaRepository.save(factura);
        return "ok";
    }

    public List<Factura> retornar(){
        return facturaRepository.findAll();
    }

}