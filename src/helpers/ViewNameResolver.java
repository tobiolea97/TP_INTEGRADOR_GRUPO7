package helpers;

import frgp.utn.edu.ar.dto.UserSessionDto;

public class ViewNameResolver {
	
	public static String resolveViewName(
		UserSessionDto userSessionDto,
		String servletPath
	){
		
		if(userSessionDto == null && servletPath.equals("/login.html"))
			return "login";
		
		if(userSessionDto == null)
			return "redirect:/login.html";
		
		String userType = userSessionDto.getUserType().toUpperCase().toString(); 
		
		switch(userType)
		{
			case "ADMIN":
				if(servletPath.equals("/adminHome.html")) return "adminHome";
				if(servletPath.equals("/adminClientes.html")) return "adminClientes";
				if(servletPath.equals("/adminCuentas.html")) return "adminCuentas";
				if(servletPath.equals("/crearCliente.html")) return "crearCliente";
				if(servletPath.equals("/modificarCliente.html")) return "modificarCliente";
				if(servletPath.equals("/crearCuenta.html")) return "crearCuenta";
				if(servletPath.equals("/modificarCuenta.html")) return "modificarCuenta";
				if(servletPath.equals("/accionCuenta.html")) return "accionCuenta";
				if(servletPath.equals("/accionCliente.html")) return "accionCuenta";
				if(servletPath.equals("/listadoClientes.html")) return "listadoClientes";
				return "redirect:/adminHome.html";
			case "CUSTOMER":
				if(servletPath.equals("/clienteHome.html")) return "clienteHome";
				if(servletPath.equals("/transferir.html")) return "transferir";
				if(servletPath.contains("Transacciones")) return "transacciones";
				return "redirect:/clienteHome.html";
			case "DEFAULT": return "redirect:/login.html";
		}
		return "redirect:/login.html";
	}

}
