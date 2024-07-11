package com.merino.facturacion.almacen.service;

import com.merino.facturacion.almacen.entity.categoria;
import java.util.List;

public interface CategoriaService {
	public List<categoria> findAll();
	public categoria findById(int id);
	public categoria findByNombre(String nombre);
	public List<categoria> findByNombreContaining(String nombre);
	public categoria create(categoria obj);
	public categoria update(categoria obj);
	public int delete(int id);
}
