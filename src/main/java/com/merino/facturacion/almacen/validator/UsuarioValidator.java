/*package com.merino.facturacion.almacen.validator;

import com.merino.facturacion.almacen.entity.Usuario;
import com.merino.facturacion.almacen.exception.ValidateServiceException;

public class UsuarioValidator {
	public static void save(Usuario Usuario) {
		if(Usuario.getEmail()==null || Usuario.getEmail().trim().isEmpty()) {
			throw new ValidateServiceException("El email es requerido");
		}
		if(Usuario.getPassword()==null || Usuario.getPassword().trim().isEmpty()) {
			throw new ValidateServiceException("La contraseña es requerido");
		}
		if(Usuario.getPassword().length()>100) {
			throw new ValidateServiceException("El password es muy extenso");
		}
		
	}
}
*/