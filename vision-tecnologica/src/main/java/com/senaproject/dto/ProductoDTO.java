package com.senaproject.dto;

import com.senaproject.model.Categoria;
import com.senaproject.model.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {


    private Long id;
    private  String nombre;
    private String descripcion;
    private  int cantidad;
    private double precio;
    private String imagen;


    private Categoria categoria;

    private Usuario usuario;
}
