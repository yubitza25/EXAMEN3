package com.merino.facturacion.almacen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.merino.facturacion.almacen.entity.Producto;
import com.merino.facturacion.almacen.exception.GeneralServiceException;
import com.merino.facturacion.almacen.exception.ValidateServiceException;
import com.merino.facturacion.almacen.repository.ProductoRepository;
import com.merino.facturacion.almacen.service.ProductoService;
import com.merino.facturacion.almacen.validator.ProductoValidator;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Producto findById(int id) {
        try {
            return repository.findById(id)
                .orElseThrow(() -> new ValidateServiceException("No hay un registro con ese ID"));
        } catch (ValidateServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Producto findByNombre(String nombre) {
        try {
            return repository.findByNombre(nombre);
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<Producto> findByNombreContaining(String nombre) {
        try {
            return repository.findByNombreContaining(nombre);
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }

    @Transactional
    @Override
    public Producto create(Producto obj) {
        try {
            ProductoValidator.save(obj);
            Producto existingProducto = findByNombre(obj.getNombre());
            if (existingProducto != null) {
                throw new ValidateServiceException("Ya hay un registro con ese nombre");
            }
            obj.setActivo(true);
            return repository.save(obj);
        } catch (ValidateServiceException e) {
            throw new ValidateServiceException(e.getMessage());
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }

    @Transactional
    @Override
    public Producto update(Producto obj) {
        try {
            ProductoValidator.save(obj);
            Producto productoDb = findById(obj.getId());
            Producto existingProducto = findByNombre(obj.getNombre());
            if (existingProducto != null && obj.getId() != existingProducto.getId()) {
                throw new ValidateServiceException("Ya hay un registro con ese nombre");
            }
            productoDb.setNombre(obj.getNombre());
            productoDb.setBarcode(obj.getBarcode());
            productoDb.setCategoria(obj.getCategoria());
            productoDb.setPrecio(obj.getPrecio());
            productoDb.setStock(obj.getStock());
            productoDb.setActivo(obj.getActivo());
            return repository.save(productoDb);
        } catch (ValidateServiceException e) {
            throw new ValidateServiceException(e.getMessage());
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }

    @Transactional
    @Override
    public int delete(int id) {
        try {
            Producto productoDb = findById(id);
            if (productoDb == null) {
                return 0;
            } else {
                repository.delete(productoDb);
                return 1;
            }
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }
}
