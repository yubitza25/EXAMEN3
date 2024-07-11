package com.merino.facturacion.almacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.merino.facturacion.almacen.entity.Producto; // Asegúrate de importar la entidad Producto
import com.merino.facturacion.almacen.service.ProductoService; // Asegúrate de importar el servicio ProductoService

import java.util.List;

@RestController
@RequestMapping("/api/productos") // Endpoint base para los productos
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public ResponseEntity<List<Producto>> getAll() {
        List<Producto> productos = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id") int id) {
        Producto producto = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(producto);
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto producto) {
        Producto productoDb = service.create(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable("id") int id, @RequestBody Producto producto) {
        producto.setId(id); // Asignar el id al producto que se está actualizando
        Producto productoDb = service.update(producto);
        return ResponseEntity.status(HttpStatus.OK).body(productoDb);
    }


    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id) {
        return service.delete(id);
    }
}
