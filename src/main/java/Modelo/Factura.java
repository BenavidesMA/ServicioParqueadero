/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.time.Duration;

/**
 *
 * @author Usuario
 */
public class Factura {
    private Vehiculo vehiculo;
    private double total;

    public Factura(Vehiculo vehiculo, int horasSimuladas) {
        this.vehiculo = vehiculo;
        calcularTotal(horasSimuladas);
    }

   private void calcularTotal(int horasSimuladas) {
        double tarifaBase = vehiculo.calcularTarifa();
        total = horasSimuladas * tarifaBase;
    }

    public double getTotal() {
        return total;
    }
}