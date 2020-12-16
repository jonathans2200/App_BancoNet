package app_bancoNet.modelo.transaccion;


import javax.persistence.Entity;
import javax.persistence.Table;

import app_bancoNet.modelo.Auditoria;
import app_bancoNet.modelo.Cuenta;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Creacion de modelo para los comprobantes
 */
@Entity
@Table(name = "comprobantes")
@SuppressWarnings("serial")
public class Comprobante extends Auditoria implements Serializable {

    @Column(name="numero",  nullable = false, length = 10)
    private Long numero;

    @Column(name="fecha",  nullable = false)
    private Date fecha;

    @Column(name="observacion", length = 200)
    private String observacion;

    @Column(name="debe", length = 10, scale = 2)
    private double debe;

    @Column(name="haber", length = 10, scale = 2)
    private double haber;

    @Column(name="saldo", length = 10, scale = 2)
    private double saldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_id", referencedColumnName = "id")
    private Cuenta cuenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaccion_id", referencedColumnName = "id")
    private Transaccion transaccion;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "comprobante_id", referencedColumnName = "id")
    private List<DetalleDeposito> detallesDeposito;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "comprobante_id", referencedColumnName = "id")
    private List<DetalleRetiro> detallesRetiro;

    public Comprobante(){

    }

    public Comprobante(long id){
        super.setId(id);
    }

  

    public void addDetalleRetiro(DetalleRetiro detalle){
        detallesRetiro.add(detalle);
    }

    public void addDetalleDeposito(DetalleDeposito detalle){
        detallesDeposito.add(detalle);
    }

    public void replaceDetalleRetiro(int index, DetalleRetiro detalle){
        detallesRetiro.set(index, detalle);
    }

    public int indexDetalleRetiro(DetalleRetiro detalle){
        return detallesRetiro.indexOf(detalle);
    }

    public void replaceDetalleDeposito(int index, DetalleDeposito detalle){
        detallesDeposito.set(index, detalle);
    }

    public int indexDetalleDeposito(DetalleDeposito detalle){
        return detallesDeposito.indexOf(detalle);
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public double getDebe() {
        return debe;
    }

    public void setDebe(double debe) {
        this.debe = debe;
    }

    public double getHaber() {
        return haber;
    }

    public void setHaber(double haber) {
        this.haber = haber;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public List<DetalleDeposito> getDetallesDeposito() {
        return detallesDeposito;
    }

    public void setDetallesDeposito(List<DetalleDeposito> detallesDeposito) {
        this.detallesDeposito = detallesDeposito;
    }

    public List<DetalleRetiro> getDetallesRetiro() {
        return detallesRetiro;
    }

    public void setDetallesRetiro(List<DetalleRetiro> detallesRetiro) {
        this.detallesRetiro = detallesRetiro;
    }
}
