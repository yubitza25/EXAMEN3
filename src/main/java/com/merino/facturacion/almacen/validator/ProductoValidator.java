package com.merino.facturacion.almacen.validator;

import java.math.BigDecimal;

import com.merino.facturacion.almacen.entity.Producto;
import com.merino.facturacion.almacen.exception.ValidateServiceException;

public class ProductoValidator {
    public static void save(Producto producto) {
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new ValidateServiceException("El nombre es requerido");
        }
        if (producto.getNombre().length() > 100) {
            throw new ValidateServiceException("El nombre es muy extenso");
        }
        if (producto.getBarcode() == null || producto.getBarcode().trim().isEmpty()) {
            throw new ValidateServiceException("El código de barras es requerido");
        }
        if (producto.getBarcode().length() > 64) {
            throw new ValidateServiceException("El código de barras es muy extenso");
        }
        if (producto.getCategoria() == null) {
            throw new ValidateServiceException("La categoría es requerida");
        }
        if (producto.getPrecio() == null || producto.getPrecio().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidateServiceException("El precio debe ser mayor que cero");
        }
        if (producto.getStock() < 0) {
            throw new ValidateServiceException("El stock no puede ser negativo");
        }
    }
}
