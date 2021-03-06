package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidades.*;


public interface ClienteDao {

	public List<Cliente> ObtenerListadoClientes(boolean estado);
	public Cliente ObtenerClientexNroCliente(int nroCliente);
	public Cliente ObtenerClientexDNI(int dni, Boolean activo);
	public Cliente ObtenerClientexUsuario(Usuario usuario);
	public boolean GuardarCliente(Cliente cli);
	public Long ContarClientesActivos();

}
