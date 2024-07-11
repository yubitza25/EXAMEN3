package com.merino.facturacion.almacen.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.merino.facturacion.almacen.entity.Pago;
import com.merino.facturacion.almacen.exception.GeneralServiceException;
import com.merino.facturacion.almacen.exception.ValidateServiceException;
import com.merino.facturacion.almacen.repository.PagoRepository;
import com.merino.facturacion.almacen.service.PagoService;
import com.merino.facturacion.almacen.validator.PagoValidator;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Pago> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Pago findById(int id) {
        try {
            Pago pago = repository.findById(id)
                    .orElseThrow(() -> new ValidateServiceException("No hay un registro con ese ID"));
            return pago;
        } catch (ValidateServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pago> findByDocumentoInquilino(String documentoInquilino) {
        try {
            return repository.findByDocumentoInquilino(documentoInquilino);
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pago> findByMetodoPago(String metodoPago) {
        try {
            return repository.findByMetodoPago(metodoPago);
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pago> findByMontoPagoGreaterThanEqual(BigDecimal montoPago) {
        try {
            return repository.findByMontoPagoGreaterThanEqual(montoPago);
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }

    @Override
    @Transactional
    public Pago create(Pago obj) {
        try {
            PagoValidator.save(obj);
            // Guardamos el pago
            return repository.save(obj);
        } catch (ValidateServiceException e) {
            throw new ValidateServiceException(e.getMessage());
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }

    @Override
    @Transactional
    public Pago update(Pago obj) {
        try {
            PagoValidator.save(obj);
            Pago pagoDb = findById(obj.getId());
            
            // Actualizamos los datos del pago
            pagoDb.setDocumentoInquilino(obj.getDocumentoInquilino());
            pagoDb.setFecha(obj.getFecha());
            pagoDb.setMontoPago(obj.getMontoPago());
            pagoDb.setMetodoPago(obj.getMetodoPago());
            pagoDb.setDescripcion(obj.getDescripcion());
            
            return repository.save(pagoDb);
        } catch (ValidateServiceException e) {
            throw new ValidateServiceException(e.getMessage());
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }

    @Override
    @Transactional
    public int delete(int id) {
        try {
            Pago pagoDb = findById(id);
            if (pagoDb == null) {
                return 0;
            } else {
                repository.delete(pagoDb);
                return 1;
            }
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }
}
