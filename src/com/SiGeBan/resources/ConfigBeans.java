package com.SiGeBan.resources;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.SiGeBan.models.dao.ConfigHibernate;
import com.SiGeBan.models.dao.UsuariosDAO;
import com.SiGeBan.models.services.IUsuariosService;
import com.SiGeBan.models.services.UsuariosService;

@Configuration
public class ConfigBeans {
	ConfigHibernate configHibernate;

//	@Bean(initMethod="iniDB",destroyMethod="destroyDB")
	public void init() {
		new InitDB().iniciarBase();
	}
	
	@Qualifier("usuarioService")
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public IUsuariosService usuarioService() {
		return new UsuariosService();
	}

}
