/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
public class VehiculoTest {
    
    @Test
    public void testTarifaCarro() {
        Propietario p = new Propietario("Benavides", 31023123, 1234123);
        Vehiculo v = new Carro("AAA111", "Mazda", p);

        assertEquals(3000, v.calcularTarifa());
    }

    @Test
    public void testTarifaMoto() {
        Propietario p = new Propietario("Juan", 11231231, 1323424);
        Vehiculo v = new Moto("BBB222", "Yamaha", p);

        assertEquals(1500, v.calcularTarifa());
    }

    @Test
    public void testTarifaCamion() {
        Propietario p = new Propietario("Cris", 2342341, 1231233);
        Vehiculo v = new Camion("CCC333", "Volvo", p);

        assertEquals(5000, v.calcularTarifa());
    }
    
}
