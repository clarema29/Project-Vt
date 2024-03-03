package com.senaproject.service;

import com.senaproject.dto.ProductoDTO;
import com.senaproject.model.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    Producto save(Producto producto);
    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    Producto update(Producto producto);

    void delete(Long id);




}
