package com.merino.facturacion.almacen.service;

import com.merino.facturacion.almacen.entity.Pago;
import java.math.BigDecimal;
import java.util.List;

public interface PagoService {
    public List<Pago> findAll();
    public Pago findById(int id);
    public List<Pago> findByDocumentoInquilino(String documentoInquilino);
    public List<Pago> findByMetodoPago(String metodoPago);
    public List<Pago> findByMontoPagoGreaterThanEqual(BigDecimal montoPago);
    public Pago create(Pago obj);
    public Pago update(Pago obj);
    public int delete(int id);
}
