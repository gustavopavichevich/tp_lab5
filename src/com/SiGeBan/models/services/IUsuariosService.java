package com.SiGeBan.models.services;

import org.springframework.stereotype.Service;

import com.SiGeBan.models.entity.Usuario;

//@Service
public interface IUsuariosService{
	public Usuario obtenerUsuariosPorUsuario(String usser);
}
