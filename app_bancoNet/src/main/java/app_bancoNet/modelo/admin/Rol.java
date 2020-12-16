package app_bancoNet.modelo.admin;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import app_bancoNet.modelo.Auditoria;

/**
 * Creacion de modelo para la tabla  para los saber los roles de los usuarios 
 * 
 * @author jonnathan simbaña
 *
 */
@Entity
@Table(name = "roles")
public class Rol extends Auditoria implements Serializable{
	
	
	@Column(name = "codigo", nullable = false, length = 20, unique = true)
	private String codigo;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "descripcion", length = 200)
	private String descripcion;

	public Rol(){

	}

	public Rol(long id, String codigo, String nombre){
		super.setId(id);
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "[ " + codigo + " ] " + nombre;
	}

}
