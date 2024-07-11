/*package com.merino.facturacion.almacen.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.merino.facturacion.almacen.entity.Usuario;
//import com.merino.facturacion.almacen.entity.usuario;
import com.merino.facturacion.almacen.exception.GeneralServiceException;
import com.merino.facturacion.almacen.exception.ValidateServiceException;
import com.merino.facturacion.almacen.repository.UsuarioRepository;
import com.merino.facturacion.almacen.service.UsuarioService;
import com.merino.facturacion.almacen.validator.UsuarioValidator;
//import com.merino.facturacion.almacen.validator.UsuarioValidator;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	private UsuarioRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		try {
			return repository.findAll();
		}catch (Exception e) {
			throw new GeneralServiceException("Error en el servidor");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(int id) {
		try {
			Usuario usuarioDb= repository.findById(id)
					.orElseThrow(()-> new ValidateServiceException("No hay un registro con ese ID"));
			
			return usuarioDb;
		}catch (ValidateServiceException e){
			throw e;
		}catch (Exception e) {
			throw new GeneralServiceException("Error en el servidor");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Usuario create(Usuario obj) {
		try {
			UsuarioValidator.save(obj);
			Usuario usuario=findByEmail(obj.getEmail());
			if(usuario!=null) {
				throw new ValidateServiceException("Ya hay un registro con ese nombre");
			}
			//Guardamos la usuario
			obj.setActivo(true);
			return repository.save(obj);
		}catch (ValidateServiceException e) {
			throw new ValidateServiceException(e.getMessage());
		} catch(Exception e) {
			throw new GeneralServiceException("Error");
		}
	}

	@Override
	public Usuario update(Usuario obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int activate(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deactivate(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}*/
