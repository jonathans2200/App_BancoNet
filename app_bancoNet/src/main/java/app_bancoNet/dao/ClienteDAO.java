package app_bancoNet.dao;

import java.io.IOException;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import app_bancoNet.modelo.Cliente;

/**
 * Objeto de Acceso a Datos para Clientes
 * 
 * @author jonathan simbanañ
 *
 */

@Stateless
public class ClienteDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Guarda los datos de un cliente
	 */
	public void guardarCliente(Cliente clienteDTO, long idUsario) throws IOException {
		try {
			clienteDTO.setFechaRegistro(new Date());
			clienteDTO.setUsuarioRegistro(idUsario);
			em.persist(clienteDTO);
		} catch (Exception ex) {
			throw new IOException("ERROR: " + ex.getMessage());
		}
	}

	/**
	 * Obtien el id del cliente por su identificacion
	 * 
	 * @param identificacion
	 * @return
	 * @throws IOException
	 */
	public long obtenerIdCliente(String identificacion) throws IOException {
		try {
			return em
					.createQuery("SELECT ct.cliente.id " + "FROM CuentaDTO ct "
							+ "WHERE ct.cliente.identificacion = :identificacion", Long.class)
					.setParameter("identificacion", identificacion).getSingleResult();
		} catch (Exception ex) {
			throw new IOException("ERROR: " + ex.getMessage());
		}
	}

	/**
	 * Obtiene el id del cliente por el id del usuraio
	 * 
	 * @param idUsuario
	 * @return
	 * @throws IOException
	 */
	public long obtenerIdCliente(long idUsuario) throws IOException {
		try {
			return em.createQuery("SELECT ct.cliente.id " + "FROM CuentaDTO ct " + "WHERE ct.usuario.id = :idUsuario",
					Long.class).setParameter("idUsuario", idUsuario).getSingleResult();
		} catch (Exception ex) {
			throw new IOException("ERROR: " + ex.getMessage());
		}
	}

}
