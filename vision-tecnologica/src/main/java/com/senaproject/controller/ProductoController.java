package com.senaproject.controller;


import com.senaproject.model.Categoria;
import com.senaproject.model.Producto;
import com.senaproject.model.Usuario;
import com.senaproject.repository.CategoriaRepository;
import com.senaproject.service.ProductoService;
import com.senaproject.service.UploadFileService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
    @Autowired
    private ProductoService productoService;
    @Autowired
    private UploadFileService upload;


    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "productos/show";
    }

    @GetMapping("/create")
    public String create() {

        return "productos/create";
    }

    @PostMapping("/save")
    public String save(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
        LOGGER.info("Este es el objeto producto {}", producto);
        Usuario u = new Usuario(1L, "", "", "", "", "", "", "");
        producto.setUsuario(u);
        //imagen
        if (producto.getId()==null){ //cuando se crea un producto
            String nombreImage = upload.saveImage(file);
            producto.setImagen(nombreImage);
        }
        else{}


        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Producto producto = new Producto();
        Optional<Producto> optionalProducto = productoService.findById(id);
        producto = optionalProducto.get();

        model.addAttribute("producto", producto);
        LOGGER.info("Producto buscado: {}", producto);

        return "productos/edit";
    }

    @PostMapping("/update")
    public String update(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
        Producto p = new Producto();
        p = productoService.findById(producto.getId()).get();
        if(file.isEmpty()){ // cuando se edita el producto pero no la img
            producto.setImagen(p.getImagen());
        }
        else {//Cuando se edita la imagen
            //eliminar cuando no sea la img por defecto
            if (!p.getImagen().equals("default.jpg")){
                upload.deleteImage(p.getImagen());
            }
            String nombreImage = upload.saveImage(file);
            producto.setImagen(nombreImage);
        }
        producto.setUsuario(p.getUsuario());
        productoService.update(producto);
        return "redirect:/productos";

    }
    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable Long id){
        Producto p = new Producto();
        p = productoService.findById(id).get();
        //eliminar cuando no sea la img por defecto
        if (!p.getImagen().equals("default.jpg")){
            upload.deleteImage(p.getImagen());
        }
        productoService.delete(id);
        return "redirect:/productos";
    }

}
