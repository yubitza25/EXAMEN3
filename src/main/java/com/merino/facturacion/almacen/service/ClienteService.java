package com.merino.facturacion.almacen.service;

import com.merino.facturacion.almacen.entity.Cliente;
import java.util.List;

public interface ClienteService {
    public List<Cliente> findAll();
    public Cliente findById(int id);
    public Cliente findByNombre(String nombre);
    public List<Cliente> findByNombreContaining(String nombre);
    public Cliente create(Cliente obj);
    public Cliente update(Cliente obj);
    public int delete(int id);
}
