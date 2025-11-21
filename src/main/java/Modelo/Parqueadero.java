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

    private GestorArchivos gestor = new GestorArchivos();
    private ArrayList<Vehiculo> vehiculosDentro = new ArrayList<>();
    private int capacidad;

    public Parqueadero(int capacidad) {
        this.capacidad = capacidad;
    }

    public ArrayList<Vehiculo> getVehiculosDentro() {
        return vehiculosDentro;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setVehiculosDentro(ArrayList<Vehiculo> vehiculosDentro) {
        this.vehiculosDentro = vehiculosDentro;
    }

    public boolean eliminarManual(String placa) {
        for (Vehiculo v : vehiculosDentro) {
            if (v.getPlaca().equals(placa)) {
                vehiculosDentro.remove(v);
                gestor.guardarVehiculos(vehiculosDentro);
                return true;
            }
        }
        return false;
    }

    public boolean placaExiste(String placa) {
        for (Vehiculo v : vehiculosDentro) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return true;
            }
        }
        return false;
    }

    public Vehiculo buscarPorPlaca(String placa) {
        for (Vehiculo v : vehiculosDentro) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    public boolean ingresarVehiculo(Vehiculo v) {
        if (v == null) {
            return false;
        }

        if (vehiculosDentro.size() < capacidad) {
            v.registrarEntrada();
            boolean ok = vehiculosDentro.add(v);

            if (ok) {
                gestor.guardarVehiculos(vehiculosDentro);
            }

            return ok;
        }

        return false;
    }

    public double retirarVehiculo(String placa) {
        for (int i = 0; i < vehiculosDentro.size(); i++) {
            Vehiculo v = vehiculosDentro.get(i);
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                v.registrarSalida();
                double tarifa = v.calcularTarifa();

                vehiculosDentro.remove(i);

                gestor.guardarVehiculos(vehiculosDentro);
                return tarifa;
            }
        }
        return -1;
    }
}
