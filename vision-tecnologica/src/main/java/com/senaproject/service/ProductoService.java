package com.senaproject.service;

import com.senaproject.dto.ProductoDTO;
import com.senaproject.model.Producto;
import com.senaproject.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public Producto save(Producto producto) {

        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }
    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }
    @Override
    public Producto update(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }
}
