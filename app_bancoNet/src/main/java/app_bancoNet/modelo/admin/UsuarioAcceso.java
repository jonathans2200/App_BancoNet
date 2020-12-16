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
 * Creacion de modelo para la tabla  para los saber los usuarios que han accedido 
 * 
 * @author jonnathan simbaña
 *
 */

@Entity
@Table(name = "usuario_accesos")
@SuppressWarnings("serial")
public class UsuarioAcceso extends Auditoria implements Serializable{

	
	@Column(name= "ubicacion",  nullable = false, length = 500)
	private String ubicacion;
	
	@Column(name= "dispositivo",  nullable = false, length = 500)
	private String Dispositivo;
	
	@Column(name= "acceso")
	private boolean acceso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuarioDTO;

	public UsuarioAcceso(){

	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDispositivo() {
		return Dispositivo;
	}

	public void setDispositivo(String dispositivo) {
		Dispositivo = dispositivo;
	}

	public boolean getAcceso() {
		return acceso;
	}

	public void setAcceso(boolean acceso) {
		this.acceso = acceso;
	}

	public Usuario getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(Usuario usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
}
