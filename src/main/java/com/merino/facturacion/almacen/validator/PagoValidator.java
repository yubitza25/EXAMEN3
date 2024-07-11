package com.merino.facturacion.almacen.validator;

import com.merino.facturacion.almacen.entity.Pago;
import com.merino.facturacion.almacen.exception.ValidateServiceException;

public class PagoValidator {
    public static void save(Pago pago) {
        if (pago.getDocumentoInquilino() == null || pago.getDocumentoInquilino().trim().isEmpty()) {
            throw new ValidateServiceException("El documento del inquilino es requerido");
        }
        if (pago.getDocumentoInquilino().length() > 15) {
            throw new ValidateServiceException("El documento del inquilino es muy extenso");
        }
        
        if (pago.getFecha() == null) {
            throw new ValidateServiceException("La fecha es requerida");
        }
        
        if (pago.getMontoPago() == null) {
            throw new ValidateServiceException("El monto de pago es requerido");
        }
        if (pago.getMontoPago().compareTo(new java.math.BigDecimal("0.00")) <= 0) {
            throw new ValidateServiceException("El monto de pago debe ser mayor a 0");
        }

        if (pago.getMetodoPago() == null || pago.getMetodoPago().trim().isEmpty()) {
            throw new ValidateServiceException("El método de pago es requerido");
        }
        if (pago.getMetodoPago().length() > 20) {
            throw new ValidateServiceException("El método de pago es muy extenso");
        }

        if (pago.getDescripcion() == null || pago.getDescripcion().trim().isEmpty()) {
            throw new ValidateServiceException("La descripción es requerida");
        }
        if (pago.getDescripcion().length() > 255) {
            throw new ValidateServiceException("La descripción es muy extensa");
        }
    }
}
