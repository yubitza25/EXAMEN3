package com.merino.facturacion.almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.merino.facturacion.almacen.entity.Producto; // Importa la entidad Producto
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Producto findByNombre(String nombre); // Cambia el tipo de retorno a Producto
    List<Producto> findByNombreContaining(String nombre); // Cambia el tipo de retorno a List<Producto>
}
