package com.SiGeBan.models.services;

import com.SiGeBan.models.dao.UsuariosDAO;
import com.SiGeBan.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("usuariosService")
public class UsuariosService {

	@Autowired
	private UsuariosDAO usuarioDAO = null;

	public Usuario obtenerUsuariosPorUsuario(String user) {
		return usuarioDAO.obtenerUsuariosPorUsuario(user);
	}

	//
//	public void setDataAccess(UsuariosDAO dataAccess) {
//		this.dataAccess = dataAccess;
//	}
//
//	public ArrayList<Usuarios> obtenerUsuarioss() {
//		return dataAccess.obtenerUsuarios();
//	}
////
//	public Usuarios obtenerUnRegistro(String nombreUser) {
//		return dataAccess.obtenerUsuariosPorNombre(nombreUser);
//	}
//
//	public void insertarUsuarios(Usuarios usuario) {
//		 dataAccess.insertarUsuarios(usuarios);
//
//	}
//
//	public void eliminarUsuarios(Integer idUser) {
//		dataAccess.eliminarUsuarios(idUser);
//
//	}
//
//	public void actualizarUsuarios(Usuarios usuario) {
//		dataAccess.actualizarUsuarios(usuario);
//
//	}

}
