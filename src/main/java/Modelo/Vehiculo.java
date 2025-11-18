/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;

/**
 *
 * @author Usuario
 */
public abstract class Vehiculo implements Registrable{
    protected String placa;
    protected String modelo;
    protected Propietario propietario;
    protected LocalDateTime horaEntrada;
    protected LocalDateTime horaSalida;

    public Vehiculo(String placa, String modelo, Propietario propietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }
    
    public void registrarEntrada() {
        this.horaEntrada = LocalDateTime.now();
    }

    public void registrarSalida() {
        this.horaSalida = LocalDateTime.now();
    }

    public abstract double calcularTarifa();
    
    public abstract String tipoVehiculo();
}
