package frgp.utn.edu.ar.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="NroCliente")
	private int nroCliente;
	
	@Column(name="Dni",nullable=false,unique=true)
	private int dni;
	
	@Column(name="Sexo",nullable=false)
	private String sexo;
	
	@Column(name="IdPais",nullable=false)
	private int idPais;
	
	@Column(name="FechaNacimiento",nullable=false)
	private LocalDate fechaNacimiento;
	
	@Column(name="Direccion",nullable=true)
	private String direccion;
	
	@OneToOne(cascade= { CascadeType.ALL})
	@JoinColumn(name="IdProvincia")
	private Provincia prov;

	@OneToOne(cascade= { CascadeType.ALL})
	@JoinColumn(name="IdLocalidad")
	private Localidad loc;
	
	@OneToOne(cascade= { CascadeType.ALL})
	@JoinColumn(name="UserName")
	private Usuario usuario;
	
	@Column(name="EstadoLinea", columnDefinition="Boolean default true")
	private boolean estadoCliente;
	
	//CONSTRUCTORES
	public Cliente() {
		
	}
	
	//GETTERS AND SETTERS
	public int getNroCliente() {
		return nroCliente;
	}
	
	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Provincia getProv() {
		return prov;
	}

	public void setProv(Provincia prov) {
		this.prov = prov;
	}

	public Localidad getLoc() {
		return loc;
	}

	public void setLoc(Localidad loc) {
		this.loc = loc;
	}

	public boolean isEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(boolean estadoCliente) {
		this.estadoCliente = estadoCliente;
	}

	@Override
	public String toString() {
		return  nroCliente + ", usuario=" + usuario + ", dni=" + dni + ", sexo=" + sexo
				+ ", idPais=" + idPais + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + ", prov="
				+ prov + ", loc=" + loc + ", estadoCliente=" + estadoCliente;
	}


	
	
}
