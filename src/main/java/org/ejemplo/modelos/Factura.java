package org.ejemplo.modelos;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "facturas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "nro1", nullable = false)
    private String nro1;

    @Column (name = "nro2", nullable = false)
    private String nro2;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private List<DetalleFactura> detalleFacturas;

    @Column (name = "precio_total", nullable = false)
    private Double precioTotal;
}
