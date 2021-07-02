package com.SiGeBan.controllers;

import javax.servlet.ServletConfig;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;


import com.SiGeBan.models.services.IUsuariosService;
import com.SiGeBan.models.services.UsuariosService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class Controllers {

	@Autowired
	@Qualifier("usuariosService")
	private UsuariosService usuariosService;


	public UsuariosService getUsuariosService() {
		return usuariosService;
	}


	public void setUsuariosService(UsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}


	public void init(ServletConfig config) {
	}


	@RequestMapping("IrALogin.html")
	public ModelAndView eventoRedireccionarLogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;

	}
	
	@RequestMapping("IrAMisCuentas.html")
	public ModelAndView eventoRedireccionarMisCuentas() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("MisCuentas");
		return mv;

	}

	@RequestMapping("AccionLoguear.html")
	public ModelAndView accionLoguear(String txtUsuario) {

		System.out.println(txtUsuario);
		ModelAndView mv = new ModelAndView();
		mv.addObject("txtUsuario", usuariosService.obtenerUsuariosPorUsuario(txtUsuario));
		mv.setViewName("usuarioLogueado");
		return mv;
	}

	@RequestMapping("IrAAdd.html")
	public ModelAndView abrirAdd() {

		ModelAndView model = new ModelAndView();
		model.setViewName("add");
		return model;

	}
	
	@RequestMapping("IrAUsuarios.html")
	public ModelAndView abrirUsuarios() {

		ModelAndView model = new ModelAndView();
		model.setViewName("Usuarios");
		return model;

	}

	@RequestMapping("IrACuentas.html")
	public ModelAndView abrirCuentas() {

		ModelAndView model = new ModelAndView();
		model.setViewName("Cuentas");
		return model;

	}
	
	@RequestMapping("IrAAddAccount.html")
	public ModelAndView abrirAddAccount() {

		ModelAndView model = new ModelAndView();
		model.setViewName("addaccount");
		return model;

	}

	@RequestMapping("IrATransferencias.html")
	public ModelAndView abrirTransferencias() {

		ModelAndView model = new ModelAndView("transferencias");
		// model.setViewName("transferencias");
		return model;

	}

	/*public Controllers() {
		// TODO Auto-generated constructor stub
	}*/

}
