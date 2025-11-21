/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Usuario
 */
public class FacturaTest {
    
   @Test
    public void testCalculoTotalCarro() {
        Propietario p = new Propietario("Miguel", 1345345, 134534);
        Vehiculo v = new Carro("ABC123", "Mazda", p);

        Factura f = new Factura(v, 3);

        assertEquals(9000, f.getTotal());
    }

    @Test
    public void testCalculoTotalMoto() {
        Propietario p = new Propietario("Edwin", 15345, 14555543);
        Vehiculo v = new Moto("XYZ987", "Yamaha", p);

        Factura f = new Factura(v, 4);

        assertEquals(6000, f.getTotal());
    }

    @Test
    public void testHorasSimuladas() {
        Propietario p = new Propietario("Martin", 432341, 145343);
        Vehiculo v = new Camion("TTT999", "Volvo", p);

        Factura f = new Factura(v, 2);

        assertEquals(2, f.getHorasSimuladas());
    }

    @Test
    public void testGetVehiculo() {
        Propietario p = new Propietario("Oswaldo", 1242344, 5345341);
        Vehiculo v = new Moto("M123", "Suzuki", p);

        Factura f = new Factura(v, 1);

        assertEquals(v, f.getVehiculo());
    }
    
}
