package app_bancoNet.modelo.transaccion;




import javax.persistence.Entity;
import javax.persistence.Table;

import app_bancoNet.modelo.Auditoria;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import java.io.Serializable;
/**
 * Creacion de modelo para la tabla detalle de los depostios
 */
@Entity
@Table(name = "detalles_depositos")

public class DetalleDeposito extends Auditoria implements Serializable {

    @Column(name="cantidad", nullable = false, length = 10, scale = 2)
    private int cantidad;

    @Column(name="monto", nullable = false, length = 10, scale = 2)
    private double monto;

    @Column(name="valor", nullable = false, length = 10, scale = 2)
    private double valor;

    @Column(name="observacion", length = 200)
    private String observacion;

   
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

   
}
