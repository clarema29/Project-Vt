package com.senaproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nombre;
    private String descripcion;
    private  int cantidad;
    private double precio;
    private String imagen;

    @ManyToOne(targetEntity = Categoria.class)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    private Usuario usuario;

}
