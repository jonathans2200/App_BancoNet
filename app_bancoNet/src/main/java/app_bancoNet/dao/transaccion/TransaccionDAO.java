package app_bancoNet.dao.transaccion;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import app_bancoNet.modelo.transaccion.Comprobante;

@Stateless
public class TransaccionDAO {

@PersistenceContext
    private EntityManager em;

    /**
     * Guardar un comprobante y sus detalles
     * @author jonnathan simbana
     * @param comprobante
     * @throws GeneralException
     */
    public void guardarComprobante(Comprobante comprobante) throws IOException  {
        try {
            comprobante.setFechaRegistro(new Date());
            comprobante.setUsuarioRegistro((long) 1);
            em.persist(comprobante);
        }catch (Exception ex){
            throw new IOException("ERROR: " + ex.getMessage());
        }
    }

    /**
     * Guardar un comprobante Retiro
     * @param comprobante
     * @throws IOException 
     * @throws GeneralException
     */
    public void guardarComprobanteRetiro(Comprobante comprobante) throws IOException {
        // Argea losa tributos de auditoria a los detalles
        if (comprobante.getDetallesRetiro() != null) {
            comprobante.getDetallesRetiro().forEach((detalle) -> {
                detalle.setFechaRegistro(new Date());
                detalle.setUsuarioRegistro((long) 1);
            });
        }
        guardarComprobante(comprobante);
    }

    /**
     * Guardar un comprobante Retiro
     * @param comprobante
     * @throws GeneralException
     */
    public void guardarComprobanteDeposito(Comprobante comprobante) throws  IOException {
        // Argea losa tributos de auditoria a los detalles
        if ( comprobante.getDetallesDeposito() != null) {
            comprobante.getDetallesDeposito().forEach((detalle) -> {
                detalle.setFechaRegistro(new Date());
                detalle.setUsuarioRegistro((long) 1);
            });
        }
        guardarComprobante(comprobante);
    }


    /**
     *
     * @param idTransacion
     * @throws GeneralException
     */
    public void actualizarNumeroTransaccion(Long idTransacion) throws  IOException {
        try {
            em.createQuery("UPDATE TransaccionDTO T set t.numeroSiguiente = t.numeroSiguiente + t.numeroSumador " +
                    "WHERE t.id = :idTransacion")
                    .setParameter("idTransacion",  idTransacion)
                    .executeUpdate();
        }catch (Exception ex){
            throw new IOException("ERROR: " + ex.getMessage());
        }
    }

  
}
