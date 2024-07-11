package com.merino.facturacion.almacen.service;
import com.merino.facturacion.almacen.entity.Producto;
import java.util.List;

public interface ProductoService {
	public List<Producto> findAll();
    public Producto findById(int id);
    public Producto findByNombre(String nombre);
    public List<Producto> findByNombreContaining(String nombre);
    public Producto create(Producto obj);
    public Producto update(Producto obj);
    public int delete(int id);
}
