package app_bancoNet.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_cuenta")
public class TipoCuenta extends Auditoria implements Serializable {
	@Column(name = "codigoCuenta", nullable = false, unique = true, length = 20)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String codigoCuenta;
	
	@Column(name = "descripcion", nullable = false, unique = true, length = 20)
	private String descripcion;

}
