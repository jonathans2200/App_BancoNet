package app_bancoNet.dao.admin;



import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import app_bancoNet.modelo.admin.UsuarioAcceso;



/**
 * Objeto de Acceso a Datos para Usuario Accesos
 * 
 * @author jonnathan simbana
 *
 */

@Stateless
public class UsuarioAccesoDAO {

	@PersistenceContext
	private EntityManager em;
	
	/**
     * Guarda un acceso a la banca virtual
     */
	public void guardarUsuarioAcceso(UsuarioAcceso usuarioAccesoDTO, long idUsuario) throws  IOException {
		try {
			usuarioAccesoDTO.setFechaRegistro(new Date());
			usuarioAccesoDTO.setUsuarioRegistro(idUsuario);
			em.persist(usuarioAccesoDTO);
		}catch(Exception ex) {
			throw new  IOException("ERROR: " + ex.getMessage());
		}
	}
	
	/**
     * Obtiene la lista de acceso de un usuario a la banca virtual
     */
    public List<UsuarioAcceso> obtenerUsuarioAcceso(long idUsuario) throws  IOException {
        try{
            return em.createQuery("SELECT ua FROM UsuarioAccesoDTO ua WHERE ua.usuarioDTO.id = :idUsuario",
					UsuarioAcceso.class)
                    .setParameter("idUsuario",  idUsuario)
					.getResultList();
        }catch (Exception ex) {
            throw new  IOException("ERROR: " + ex.getMessage());
        }
    }
	
}
