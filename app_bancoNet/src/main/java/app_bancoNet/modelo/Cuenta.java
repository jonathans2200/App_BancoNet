package app_bancoNet.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import app_bancoNet.modelo.admin.Usuario;

import javax.persistence.CascadeType;
import java.io.Serializable;
import java.util.Date;

/**
 * Creacion de modelo para la tabla para los saber los las cuentas de los
 * usuarios
 * 
 * @author jonnathan simbaña
 *
 */
@Entity
@Table(name = "cuenta")
public class Cuenta extends Auditoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "numero", nullable = false, unique = true, length = 20)
	private String numero;

	@Column(name = "sado_actual", nullable = false, length = 10, scale = 2)
	private double saldoActual;

	@Column(name = "ultima_transaccion")
	private Date ultimaTransaccion;
	
	@Column(name = "tipo_cuenta")
	private String tipoCuenta;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false)
	private Cliente cliente;

	public Cuenta() {
	}

	public Cuenta(Long id) {
		super.setId(id);
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}

	public Date getUltimaTransaccion() {
		return ultimaTransaccion;
	}

	public void setUltimaTransaccion(Date ultimaTransaccion) {
		this.ultimaTransaccion = ultimaTransaccion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Cuenta [numero=" + numero + ", saldoActual=" + saldoActual + ", ultimaTransaccion=" + ultimaTransaccion
				+ ", tipoCuenta=" + tipoCuenta + ", usuario=" + usuario + ", cliente=" + cliente + "]";
	}


}
