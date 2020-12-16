package app_bancoNet.modelo.admin;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import app_bancoNet.modelo.Auditoria;
/**
 * Creacion de modelo para la tabla  para los saber los usuarios 
 * 
 * @author jonnathan simbaña
 *
 */


@Entity
@Table(name = "usuarios")

public class Usuario extends Auditoria implements Serializable {

	@Column(name = "nombre",  nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "correo",  nullable = false, length = 100, unique = true)
	private String correo;
	
	@Column(name = "contrasena",  nullable = false, length = 100)
	private String contresena;

	@Column(name = "es_cliente")
	private boolean esCliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rol_id", referencedColumnName = "id")
	private Rol rol;

	public Usuario (){

	}

	public Usuario (long id){
		super.setId(id);
	}
	
	public boolean isEsCliente() {
		return esCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public boolean esCliente() {
		return esCliente;
	}

	public void setEsCliente(boolean esCliente) {
		this.esCliente = esCliente;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getContresena() {
		return contresena;
	}

	public void setContresena(String contresena) {
		this.contresena = contresena;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [nombre=" + nombre + ", correo=" + correo + ", contresena="
				+ contresena + ", rol=" + rol + "]";
	}

}
