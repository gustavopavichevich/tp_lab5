package com.SiGeBan.controllers;

import javax.servlet.ServletConfig;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.SiGeBan.models.dao.DaoMovimientos;
import com.SiGeBan.models.services.IUsuariosService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class Controllers {

/*
	@Autowired
	@Qualifier("servicioMovimientos") 
	private NegMovimientos negocioMovimiento;
*/
	@Autowired
	private IUsuariosService usuarioService;


	public void init(ServletConfig config) {
		ApplicationContext appContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		usuarioService = (IUsuariosService) appContext.getBean("init");
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
		mv.addObject("txtUsuario", usuarioService.obtenerUsuariosPorUsuario(txtUsuario));
	//	mv.addObject("txtPrueba","si le pongo un texto cualquiera anda, pero no toma el post");
		mv.setViewName("usuarioLogueado");
		return mv;
	}

	@RequestMapping("IrAMovimientos.html")
	public ModelAndView listMovement() {
		DaoMovimientos Movs = new DaoMovimientos();
/*//esto funciona trae un registro de la tabla tipos de movimientos.
 * 	
		System.out.println("Entro en controller listMovement");
		ModelAndView mv = new ModelAndView();
		String _listMovement=Movs.prueba2();
		mv.addObject("listmovimientos", _listMovement);
		mv.setViewName("movementhistory");
		return mv;
*/
		
		ObjectMapper mapper = new ObjectMapper();
		List listMovement=(List)Movs.ListarMovimientos();
		ModelAndView model = new ModelAndView("movementhistory");
		String json = "";
		try 
		{ 
			json = mapper.writeValueAsString(listMovement); 
		} 
		catch (Exception e) 
		{
			e.printStackTrace(); 
		}
		model.addObject("listmovimientos", json);
		return model;
		
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
