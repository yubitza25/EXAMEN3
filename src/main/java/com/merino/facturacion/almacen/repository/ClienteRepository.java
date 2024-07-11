package com.merino.facturacion.almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.merino.facturacion.almacen.entity.Cliente;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    public Cliente findByNombre(String nombre);
    public List<Cliente> findByNombreContaining(String nombre);
    public Cliente findByDocumento(String documento);
}
