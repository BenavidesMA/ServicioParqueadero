/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Moto extends Vehiculo {
    public Moto(String placa,String modelo, Propietario propietario) {
        super(placa, modelo, propietario);
    }
    
    @Override
    public double calcularTarifa(){
        return 1500;
    }
}
