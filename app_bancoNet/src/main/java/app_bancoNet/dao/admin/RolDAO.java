package app_bancoNet.dao.admin;



import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import app_bancoNet.modelo.admin.Rol;



@Stateless
public class RolDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Obtiene la lista de los roles
	 * 
	 * @author jonnathan simbana
	 * @return
	 * @throws  IOException
	 */
	public List<Rol> listarRoles() throws  IOException {
		try{
			return em.createQuery("SELECT NEW ec.edu.ups.dto.administracion.RolDTO(r.id, r.codigo, r.nombre) " +
					"FROM RolDTO r", Rol.class)
					.getResultList();
		}catch (Exception ex) {
			throw new  IOException("ERROR: " + ex.getMessage());
		}
	}
}
