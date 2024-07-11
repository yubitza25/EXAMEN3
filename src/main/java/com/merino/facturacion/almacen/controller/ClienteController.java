package com.merino.facturacion.almacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.merino.facturacion.almacen.entity.Cliente;
import com.merino.facturacion.almacen.service.ClienteService;
import java.util.List;

@RestController
@RequestMapping("api/clientes") // www.localhost:8081/api/clientes
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping()
    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> clientes = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(clientes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable("id") int id) {
        Cliente cliente = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        Cliente clienteDb = service.create(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDb);
    }

    @PutMapping
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        Cliente clienteDb = service.update(cliente);
        return ResponseEntity.status(HttpStatus.OK).body(clienteDb);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
