package app_bancoNet.dao;

import java.io.IOException;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import app_bancoNet.modelo.Cuenta;

@Stateless
public class CuentaDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Guarda los datos de una cuenta
	 * 
	 * @throws IOException
	 */
	public void guardarCuenta(Cuenta cuentaDTO, long idUsuario) throws IOException {
		try {
			cuentaDTO.setFechaRegistro(new Date());
			cuentaDTO.setUsuarioRegistro(idUsuario);
			em.persist(cuentaDTO);
		} catch (Exception ex) {
			throw new IOException("ERROR: " + ex.getMessage());
		}
	}

	/**
	 * Reduce el saldo de una cuenta segun su id.
	 * 
	 * @throws IOException
	 */
	public void actualizarSaldoCuentaRetiro(long idCuenta, double valorTrans) throws IOException {
		try {
			em.createQuery("UPDATE CuentaDTO c SET c.saldoActual = c.saldoActual - :valorTrans, "
					+ "c.ultimaTransaccion = :ultimaTransaccion " + "WHERE c.id = :idCuenta")
					.setParameter("valorTrans", valorTrans).setParameter("ultimaTransaccion", new Date())
					.setParameter("idCuenta", idCuenta).executeUpdate();
		} catch (Exception ex) {
			throw new IOException("ERROR: " + ex.getMessage());
		}
	}

	/**
	 * Aumenta el saldo de una cuenta segun su id.
	 * 
	 * @throws IOException
	 */
	public void actualizarSaldoCuentaDeposito(long idCuenta, double valorTrans) throws IOException {
		try {
			em.createQuery("UPDATE CuentaDTO c SET c.saldoActual = c.saldoActual + :valorTrans, "
					+ "c.ultimaTransaccion = :ultimaTransaccion " + "WHERE c.id = :idCuenta")
					.setParameter("valorTrans", valorTrans).setParameter("ultimaTransaccion", new Date())
					.setParameter("idCuenta", idCuenta).executeUpdate();
		} catch (Exception ex) {
			throw new IOException("ERROR: " + ex.getMessage());
		}
	}

	/**
	 * Obtiene el saldo de una cuenta segun su id.
	 * 
	 * @throws IOException
	 */
	public double obtenerSaldoCuenta(long idCuenta) throws IOException {
		try {
			return em.createQuery("SELECT c.saldoActual FROM CuentaDTO c " + "WHERE c.id = :idCuenta", Double.class)
					.setParameter("idCuenta", idCuenta).getSingleResult();
		} catch (Exception ex) {
			throw new IOException("ERROR: " + ex.getMessage());
		}
	}

}
