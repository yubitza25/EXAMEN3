package com.merino.facturacion.almacen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.merino.facturacion.almacen.entity.Cliente;
import com.merino.facturacion.almacen.exception.GeneralServiceException;
import com.merino.facturacion.almacen.exception.ValidateServiceException;
import com.merino.facturacion.almacen.repository.ClienteRepository;
import com.merino.facturacion.almacen.service.ClienteService;
import com.merino.facturacion.almacen.validator.ClienteValidator;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findById(int id) {
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
    public Cliente findByNombre(String nombre) {
        try {
            return repository.findByNombre(nombre);
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findByNombreContaining(String nombre) {
        try {
            return repository.findByNombreContaining(nombre);
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }

    @Transactional
    @Override
    public Cliente create(Cliente obj) {
        try {
            ClienteValidator.save(obj);
            Cliente clienteExistente = repository.findByDocumento(obj.getDocumento());
            if (clienteExistente != null) {
                throw new ValidateServiceException("Ya hay un registro con ese documento");
            }
            return repository.save(obj);
        } catch (ValidateServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }

    @Override
    @Transactional
    public Cliente update(Cliente obj) {
        try {
            ClienteValidator.save(obj);
            Cliente clienteDb = findById(obj.getId());

            Cliente clienteExistente = repository.findByDocumento(obj.getDocumento());
            if (clienteExistente != null && obj.getId() != clienteExistente.getId()) {
                throw new ValidateServiceException("Ya hay un registro con ese documento");
            }

            clienteDb.setNombre(obj.getNombre());
            clienteDb.setDocumento(obj.getDocumento());
            clienteDb.setTelefono(obj.getTelefono());
            clienteDb.setDireccion(obj.getDireccion());
            clienteDb.setEmail(obj.getEmail());

            return repository.save(clienteDb);
        } catch (ValidateServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }

    @Transactional
    @Override
    public int delete(int id) {
        try {
            Cliente clienteDb = findById(id);
            if (clienteDb == null) {
                return 0;
            } else {
                repository.delete(clienteDb);
                return 1;
            }
        } catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor", e);
        }
    }
}
