package com.merino.facturacion.almacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.merino.facturacion.almacen.entity.Pago;
import com.merino.facturacion.almacen.service.PagoService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/pagos") // Cambiar a la ruta deseada, por ejemplo: www.localhost:8081/api/pagos
public class PagoController {

    @Autowired
    private PagoService service;

    @GetMapping()
    public ResponseEntity<List<Pago>> getAll() {
        List<Pago> pagos = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(pagos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pago> getById(@PathVariable("id") int id) {
        Pago pago = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(pago);
    }

    @PostMapping
    public ResponseEntity<Pago> create(@RequestBody Pago pago) {
        Pago pagoDb = service.create(pago);
        return ResponseEntity.status(HttpStatus.CREATED).body(pagoDb);
    }

    @PutMapping
    public ResponseEntity<Pago> update(@RequestBody Pago pago) {
        Pago pagoDb = service.update(pago);
        return ResponseEntity.status(HttpStatus.OK).body(pagoDb);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
