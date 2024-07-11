package com.merino.facturacion.almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.merino.facturacion.almacen.entity.Pago;
import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    public List<Pago> findByDocumentoInquilino(String documentoInquilino);
    public List<Pago> findByMetodoPago(String metodoPago);
    public List<Pago> findByMontoPagoGreaterThanEqual(java.math.BigDecimal montoPago);
}
