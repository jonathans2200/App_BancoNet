package app_bancoNet.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Creacion de modelo para la tabla  para los clientes
 * 
 * @author jonnathan simbaña
 *
 */
@Entity
@Table(name = "clientes")
public class Cliente extends Auditoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name= "cedula",  nullable = false, length = 13, unique = true)
	private String identificacion;
	
	@Column(name= "nombres",  nullable = false, length = 100)
	private String nombres;
	
	@Column(name= "apellidos", nullable = false, length = 100)
	private String apellidos;
	
	@Column(name= "correo", nullable = false, length = 100)
	private String correo;
	
	@Column(name= "fecha_nacimiento", nullable = false)
	private Date fechaNacimiento;
	
	@Column(name= "telefono", nullable = false, length = 10)
	private String telefono;
	
	@Column(name= "celular", nullable = false, length = 10)
	private String celular;
	
	@Column(name= "calle_principal", nullable = false, length = 200)
	private String callePrincipal;
	
	@Column(name= "calle_secuntaria", length = 200)
	private String calleSecundaria;


	@JoinColumn(name = "estado_civil", referencedColumnName = "id", nullable = false)
	private String estadoCivil;
	
	
	@JoinColumn(name = "genero", referencedColumnName = "id", nullable = false)
	private String  genero;
	
	
	
	public Cliente() {
	}

	public Cliente(long id) {
		super.setId(id);
	}

	public String nombreCompleto() {
		return nombres.toUpperCase() + " " + apellidos.toUpperCase();
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCallePrincipal() {
		return callePrincipal;
	}
	public void setCallePrincipal(String callePrincipal) {
		this.callePrincipal = callePrincipal;
	}
	public String getCalleSecundaria() {
		return calleSecundaria;
	}
	public void setCalleSecundaria(String calleSecundaria) {
		this.calleSecundaria = calleSecundaria;
	}


	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombreCompleto(){
		return nombres + " " + apellidos;
	}
	
	@Override
	public String toString() {
		return "Cliente [identificacion=" + identificacion + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono
				+ ", celular=" + celular + ", callePrincipal=" + callePrincipal + ", calleSecundaria=" + calleSecundaria
				+ ", estadoCivil=" + estadoCivil + ", genero=" + genero + "]";
	}
	
}
