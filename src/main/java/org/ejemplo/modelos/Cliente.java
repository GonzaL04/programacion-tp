package org.ejemplo.modelos;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name= "dni", nullable = false)
    private Long dni;

    @Column (name= "cuit", nullable = false)
    private Long cuit;

    @Column (name= "direccion", nullable = false)
    private String direccion;

    @Column (name= "telefono", nullable = false)
    private String telefono;
}
