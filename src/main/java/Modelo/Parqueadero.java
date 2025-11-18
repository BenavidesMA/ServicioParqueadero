/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.ArrayList;
/**
 *
 * @author Usuario
 */

public class Parqueadero {
    private ArrayList<Vehiculo> vehiculosDentro = new ArrayList<>();
    private int capacidad;

    public Parqueadero(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean ingresarVehiculo(Vehiculo v) {
        if (vehiculosDentro.size() < capacidad) {
            v.registrarEntrada();
            vehiculosDentro.add(v);
            return true;
        }
        return false;
    }

    public double retirarVehiculo(String placa) {
        for (Vehiculo v : vehiculosDentro) {
            if (v.placa.equals(placa)) {
                v.registrarSalida();
                vehiculosDentro.remove(v);
                return v.calcularTarifa();
            }
        }
        return -1;
    }
}
