package app_bancoNet.dao.admin;

import java.io.IOException;
import java.util.Date;
import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import app_bancoNet.modelo.admin.Usuario;

/**
 * Objeto de Acceso a Datos para Usuarios
 * 
 * @author jonnathan simbana
 *
 */
@Stateless
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Guarda los datos de un usuario
	 * 
	 * @param usuarioDTO
	 * @throwsIOException
	 */
	public void guardarUsuario(Usuario usuarioDTO, long idUsuario) throws IOException {
		try {
			usuarioDTO.setFechaRegistro(new Date());
			usuarioDTO.setUsuarioRegistro(idUsuario);
			em.persist(usuarioDTO);
		} catch (Exception ex) {
			throw new IOException("ERROR: " + ex.getMessage());
		}
	}

}
