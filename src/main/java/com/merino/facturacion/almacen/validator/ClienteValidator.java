package com.merino.facturacion.almacen.validator;

import com.merino.facturacion.almacen.entity.Cliente;
import com.merino.facturacion.almacen.exception.ValidateServiceException;

public class ClienteValidator {
    public static void save(Cliente cliente) {
        if(cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            throw new ValidateServiceException("El nombre es requerido");
        }
        if(cliente.getNombre().length() > 100) {
            throw new ValidateServiceException("El nombre es muy extenso");
        }
        
        if(cliente.getDocumento() == null || cliente.getDocumento().trim().isEmpty()) {
            throw new ValidateServiceException("El documento es requerido");
        }
        if(cliente.getDocumento().length() > 15) {
            throw new ValidateServiceException("El documento es muy extenso");
        }
        
        if(cliente.getTelefono() == null || cliente.getTelefono().trim().isEmpty()) {
            throw new ValidateServiceException("El teléfono es requerido");
        }
        if(cliente.getTelefono().length() > 15) {
            throw new ValidateServiceException("El teléfono es muy extenso");
        }
        
        if(cliente.getDireccion() == null || cliente.getDireccion().trim().isEmpty()) {
            throw new ValidateServiceException("La dirección es requerida");
        }
        if(cliente.getDireccion().length() > 100) {
            throw new ValidateServiceException("La dirección es muy extensa");
        }
        
        if(cliente.getEmail() == null || cliente.getEmail().trim().isEmpty()) {
            throw new ValidateServiceException("El email es requerido");
        }
        if(cliente.getEmail().length() > 50) {
            throw new ValidateServiceException("El email es muy extenso");
        }
    }
}
