/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public class GestorArchivos {
    
    private final String NOMBRE_ARCHIVO = "vehiculos.txt";

    public void guardarVehiculos(ArrayList<Vehiculo> lista) {
        try (PrintWriter out = new PrintWriter(new FileWriter(NOMBRE_ARCHIVO))) {

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");

            for (Vehiculo v : lista) {
                out.println(
                    v.tipoVehiculo() + ";" +
                    v.getPlaca() + ";" +
                    v.getModelo() + ";" +
                    v.getPropietario().getNombre() + ";" +
                    v.getPropietario().getCedula() + ";" +
                    v.getPropietario().getTelefono() + ";" +
                    v.getHoraEntrada().format(formato)
                );
            }

        } catch (IOException e) {
            System.err.println("Error al guardar vehículos: " + e.getMessage());
        }
    }


    public ArrayList<Vehiculo> cargarVehiculos() {
        ArrayList<Vehiculo> lista = new ArrayList<>();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");

        File archivo = new File(NOMBRE_ARCHIVO);
        if (!archivo.exists()) {
            return lista; 
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                String tipo      = datos[0];
                String placa     = datos[1];
                String modelo    = datos[2];
                String nombre    = datos[3];
                int cedula       = Integer.parseInt(datos[4]);
                int telefono     = Integer.parseInt(datos[5]);
                LocalTime hora   = LocalTime.parse(datos[6], formato);

                Propietario p = new Propietario(nombre, cedula, telefono);
                Vehiculo v;

                switch (tipo) {
                    case "moto" -> v = new Moto(placa, modelo, p);
                    case "carro" -> v = new Carro(placa, modelo, p);
                    default -> v = new Camion(placa, modelo, p);
                }

                v.setHoraEntrada(hora);

                lista.add(v);
            }

        } catch (IOException e) {
            System.err.println("Error al cargar vehículos: " + e.getMessage());
        }

        return lista;
    }
}
