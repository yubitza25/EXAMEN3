package com.merino.facturacion.almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.merino.facturacion.almacen.entity.categoria;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<categoria, Integer>{
	public categoria findByNombre(String nombre);
	public List<categoria> findByNombreContaining (String nombre);
}
