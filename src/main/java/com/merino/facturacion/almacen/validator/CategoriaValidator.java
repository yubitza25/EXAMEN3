package com.merino.facturacion.almacen.validator;

import com.merino.facturacion.almacen.entity.categoria;
import com.merino.facturacion.almacen.exception.ValidateServiceException;

public class CategoriaValidator {
	public static void save(categoria categoria) {
		if(categoria.getNombre()==null || categoria.getNombre().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre es requerido");
		}
		if(categoria.getNombre().length()>100) {
			throw new ValidateServiceException("El nombre es muy extenso");
		}
		
	}
}
