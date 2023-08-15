package org.ejemplo.modelos;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DetalleFactura")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "producto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false)
    private Double precioUnitario;

    @Column (name = "precio_total", nullable = false)
    private Double precioTotal;

    @Column (name = "factura", nullable = false)
    private Integer factura;
}
