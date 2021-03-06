package frgp.utn.edu.ar.controllers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.entidades.Transaccion;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.negocioImpl.ClienteNegImpl;
import frgp.utn.edu.ar.negocioImpl.CuentaNegImpl;
import frgp.utn.edu.ar.negocioImpl.TransaccionNegImpl;

@Controller
public class TransferenciaController {
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");

	@RequestMapping("TransferirDinero.html")
	public ModelAndView eventclickTransferir(@RequestParam("nroCliente") int nroCliente,@RequestParam("cbuDestino") int cbuDestino,@RequestParam("cmbBoxCuentasCliente") int cuentaOrigen,@RequestParam("monto") float monto,@RequestParam("btnTransferir") String btnTransferir) {
		
		ModelAndView mv = new ModelAndView();
		ClienteNegImpl cliNegImpl = (ClienteNegImpl)appContext.getBean("clienteNegImpl");
		CuentaNegImpl cuentaNegImpl = (CuentaNegImpl)appContext.getBean("cuentaNegImpl");
		
		Cliente cli = cliNegImpl.ObtenerClientexNroCliente(nroCliente);
		List<Cuenta> lista = cuentaNegImpl.ObtenerListadoCuentasxCliente(cli);
		

		if(btnTransferir!=null) {
			
			TransaccionNegImpl transaccionNegImpl = (TransaccionNegImpl)appContext.getBean("transaccionNegImpl");
			
			Cuenta ctaOrigen = cuentaNegImpl.ObtenerCuentaxNroCuenta(cuentaOrigen);
			Cuenta ctaDestino = cuentaNegImpl.ObtenerCuentaxCBU(cbuDestino);
			
			if(ctaDestino != null) {
				
				if(ctaOrigen.getNroCuenta() == ctaDestino.getNroCuenta()) {
				    
					String cuentasIguales = "*No se puede transferir a la misma cuenta de origen.";
					mv.addObject("cuentasIguales", cuentasIguales); 
				}
				else
				{
					if(ctaOrigen.getSaldo()>=monto) {
						boolean estado = transaccionNegImpl.GenerarTransferencia(ctaOrigen, ctaDestino, monto);
						
						if(estado) {
							String transferenciaExitosa = "correcto";
							mv.addObject("transferenciaExitosa",transferenciaExitosa);
						}
						else {
							String transferenciaFallida = "fallo";
							mv.addObject("transferenciaFallida", transferenciaFallida);
						}
					}
					else {
						String montoInsuficiente = String.valueOf(ctaOrigen.getSaldo());
						mv.addObject("montoInsuficiente", montoInsuficiente);
					}
				}
			}
			else {
				String cuentaInexistente = "no existe";
				mv.addObject("cuentaInexistente", cuentaInexistente); 
			}

			
			mv.addObject("Cliente",cli);
			mv.addObject("ListaCuentasCliente", lista);
			
			mv.setViewName("transferir");
		}

		return mv;
	}
}
