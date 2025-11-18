/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Vista;

import java.util.*;
import java.time.*;
import Modelo.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Usuario
 */
public class ServicioParqueadero {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero(20);

        while (true) {
            System.out.println("\n========= MENU PARQUEADERO =========");
            System.out.println("1. Ingresar vehiculo");
            System.out.println("2. Listar vehiculos dentro");
            System.out.println("3. Retirar vehiculo");
            System.out.println("4. Eliminar vehiulo manualmente");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            String opcion = sc.nextLine();

            
            if (opcion.equals("1")) {
                
                System.out.println("\n--- Registrar vehiculo ---");

                System.out.print("Ingrese tipo de vehiculo (moto / carro / camion): ");
                String tipo = sc.nextLine().toLowerCase();

                if (!tipo.equals("moto") && !tipo.equals("carro") && !tipo.equals("camion")) {
                    System.out.println("Tipo invalido.");
                    continue;
                }

                
                System.out.print("Nombre propietario: ");
                String nombre = sc.nextLine();

                System.out.print("Cedula: ");
                String cedStr = sc.nextLine();
                int cedula = 0;
                if (cedStr.matches("\\d+")) {
                    cedula = Integer.parseInt(cedStr);
                } else {
                    System.out.println("Cedula inválida.");
                    continue;
                }

                System.out.print("Telefono: ");
                String telStr = sc.nextLine();
                int telefono = 0;
                if (telStr.matches("\\d+")) {
                    telefono = Integer.parseInt(telStr);
                } else {
                    System.out.println("Telefono invalido.");
                    continue;
                }

                Propietario propietario = new Propietario(nombre, cedula, telefono);

                
                System.out.print("Placa: ");
                String placa = sc.nextLine();

                if (placa.isEmpty()) {
                    System.out.println("Placa invalida.");
                    continue;
                }

                System.out.print("Modelo: ");
                String modelo = sc.nextLine();

                if (modelo.isEmpty()) {
                    System.out.println("Modelo invalido.");
                    continue;
                }

                Vehiculo v = null;

                if (tipo.equals("moto")) {
                    v = new Moto(placa, modelo, propietario);
                } else if (tipo.equals("carro")) {
                    v = new Carro(placa, modelo, propietario);
                } else {
                    v = new Camion(placa, modelo, propietario);
                }

                boolean ingreso = parqueadero.ingresarVehiculo(v);

                if (ingreso) {
                    System.out.println("Vehiculo ingresado exitosamente.");
                } else {
                    System.out.println("Parqueadero lleno. No se puede ingresar el vehiculo.");
                }

            } else if (opcion.equals("2")) {
                
                System.out.println("\n--- Vehiculos dentro ---");

                ArrayList<Vehiculo> lista = parqueadero.getVehiculosDentro();

                if (lista.isEmpty()) {
                    System.out.println("No hay vehiculos dentro.");
                } else {
                    for (Vehiculo x : lista) {
                        System.out.println("-------------------------------------");
                        System.out.println("Tipo de vehiculo: " + x.tipoVehiculo());
                        System.out.println("Placa: " + x.getPlaca());
                        System.out.println("Modelo: " + x.getModelo());
                        System.out.println("Propietario: " + x.getPropietario().getNombre());
                        System.out.println("Cedula: " + x.getPropietario().getCedula());
                        System.out.println("Telefono: " + x.getPropietario().getTelefono());
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
                        System.out.println("Hora de entrada: " + x.getHoraEntrada().format(formato));
                      
                    }
                }

                int plazasDisponibles = parqueadero.getCapacidad() - lista.size();
                System.out.println("\nPlazas disponibles: " + plazasDisponibles);

            } else if (opcion.equals("3")) {
                System.out.println("\n--- RETIRAR VEHICULO ---");
                System.out.print("Ingrese la placa del vehiculo: ");
                String placaRetiro = sc.nextLine();

                Vehiculo vehiculoRetirar = null;

                
                for (Vehiculo v : parqueadero.getVehiculosDentro()) {
                    if (v.getPlaca().equalsIgnoreCase(placaRetiro)) {
                        vehiculoRetirar = v;
                        break;
                    }
                }

                if (vehiculoRetirar == null) {
                    System.out.println("No existe un vehiulo con esa placa dentro del parqueadero.");
                    break;
                }

               
                System.out.print("Cuantas horas estuvo el vehiculo? (Solo numeros enteros): ");
                String horasStr = sc.nextLine();

                int horasSimuladas;

                if (horasStr.matches("\\d+")) {
                    horasSimuladas = Integer.parseInt(horasStr);
                } else {
                    System.out.println("Error: Debe ingresar un nuero entero vaido.");
                    break;
                }

                
                Factura factura = new Factura(vehiculoRetirar, horasSimuladas);

                
                parqueadero.getVehiculosDentro().remove(vehiculoRetirar);

              
                System.out.println("------Factura generada------");
                System.out.println("Vehiculo: " + vehiculoRetirar.getPlaca());
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
                System.out.println("Hora de entrada: " + vehiculoRetirar.getHoraEntrada().format(formato));
                System.out.println("Horas cobradas: " + horasSimuladas);
                System.out.println("Total a pagar: $" + factura.getTotal());
                System.out.println("----------------------------");


            } else if (opcion.equals("4")) {
      
                System.out.println("\n--- Eliminar vehiculo manualmente ---");
                System.out.print("Ingrese placa: ");
                String placa = sc.nextLine();

                boolean eliminado = parqueadero.eliminarManual(placa);

                if (eliminado) {
                    System.out.println("Vehiculo eliminado de forma manual.");
                } else {
                    System.out.println("No existe un vehiculo con esa placa.");
                }

            } else if (opcion.equals("5")) {
                System.out.println("Saliendo del sistema...");
                break;
            } else {
                System.out.println("Opcion invalida.");
            }
        }
    }
}
