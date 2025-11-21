/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
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
public class ParqueaderoTest {
    
    @Test
    public void testIngresarVehiculo() {
        Parqueadero p = new Parqueadero(5);
        Propietario prop = new Propietario("Ana", 123, 555);
        Vehiculo v = new Carro("ABC123", "Mazda", prop);

        boolean resultado = p.ingresarVehiculo(v);

        assertTrue(resultado);
    }
    
     @Test
    public void testNoIngresarCuandoEstaLleno() {
        Parqueadero p = new Parqueadero(1);
        Propietario prop = new Propietario("Ana", 2344452, 46545);

        p.ingresarVehiculo(new Carro("AAA111", "Mazda", prop));
        boolean resultado = p.ingresarVehiculo(new Carro("BBB222", "Chevy", prop));

        assertFalse(resultado);
    }
    
    @Test
    public void testBuscarPorPlaca() {
        Parqueadero p = new Parqueadero(5);
        Propietario prop = new Propietario("Isabella", 544123, 21234);
        Vehiculo v = new Moto("XYZ987", "Yamaha", prop);

        p.ingresarVehiculo(v);

        Vehiculo resultado = p.buscarPorPlaca("XYZ987");
        assertNotNull(resultado);
        assertEquals("XYZ987", resultado.getPlaca());
    }
    
    @Test
    public void testRetirarVehiculo() {
        Parqueadero p = new Parqueadero(5);
        Propietario prop = new Propietario("Sofia", 12233, 555323);
        Vehiculo v = new Carro("DDD444", "Toyota", prop);

        p.ingresarVehiculo(v);
        double tarifa = p.retirarVehiculo("DDD444");

        assertEquals(3000, tarifa);
    }
}
