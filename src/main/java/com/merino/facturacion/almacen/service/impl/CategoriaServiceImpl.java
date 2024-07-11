package com.merino.facturacion.almacen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.merino.facturacion.almacen.entity.categoria;
import com.merino.facturacion.almacen.exception.GeneralServiceException;
import com.merino.facturacion.almacen.exception.NoDataServiceException;
import com.merino.facturacion.almacen.exception.ValidateServiceException;
import com.merino.facturacion.almacen.repository.CategoryRepository;
import com.merino.facturacion.almacen.service.CategoriaService;
import com.merino.facturacion.almacen.validator.CategoriaValidator;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoryRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<categoria> findAll() {
		try {
			return repository.findAll();
		}catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	@Override
	public categoria findById(int id) {
		try {
			categoria categoriaDb= repository.findById(id)
					.orElseThrow(()-> new ValidateServiceException("No hay un registro con ese ID"));
			
			return categoriaDb;
		}catch (ValidateServiceException e){
			throw e;
		}catch (Exception e) {
			throw new GeneralServiceException("Error en el servidor");
		}
	}

	@Transactional(readOnly = true)
	@Override
	public categoria findByNombre(String nombre) {
		try {
			return repository.findByNombre(nombre);
		}catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	@Override
	public List<categoria> findByNombreContaining(String nombre) {
		try {
			return repository.findByNombreContaining(nombre) ;
		}catch (Exception e) {
			throw e;
		}
	}

	@Transactional
	@Override
	public categoria create(categoria obj) {
		try {
			CategoriaValidator.save(obj);
			categoria categoria=findByNombre(obj.getNombre());
			if(categoria!=null) {
				throw new ValidateServiceException("Ya hay un registro con ese nombre");
			}
			//Guardamos la categoria
			obj.setActivo(true);
			return repository.save(obj);
		}catch (ValidateServiceException e) {
			throw new ValidateServiceException(e.getMessage());
		} catch(Exception e) {
			throw new GeneralServiceException("Error");
		}
	}

	@Override
    @Transactional
    public categoria update(categoria obj) {
        try {
            CategoriaValidator.save(obj);
            categoria categoriaDb=findById(obj.getId());
            
            categoria categoria=findByNombre(obj.getNombre());
            if(categoria!=null && obj.getId()!=categoria.getId()) {
                throw new ValidateServiceException("Ya hay un registro con ese nombre");
            }
            categoriaDb.setNombre(obj.getNombre());
            return repository.save(categoriaDb);
        }catch (ValidateServiceException e) {
            throw new ValidateServiceException(e.getMessage());
        }catch (Exception e) {
            throw new GeneralServiceException("Error en el servidor");
        }
    }


	@Transactional
	@Override
	public int delete(int id) {
		try {
			categoria categoriaDb = findById(id);
           if(categoriaDb==null) {
        	   return 0;
           }else {
        	   repository.delete(categoriaDb);
        	   return 1;
           }
		}catch (Exception e) {
			throw e;
		}
	}
}

