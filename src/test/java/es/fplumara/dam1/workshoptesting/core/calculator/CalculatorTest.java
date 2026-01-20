package es.fplumara.dam1.workshoptesting.core.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    static Calculator calculator;
    @Test
    public void sumasSimple() {
        int resultado = 4 + 5;
        assertEquals(6, resultado, "el resultado es incorrecto");
    }
    @BeforeAll
    public static void setUp() {
                calculator = new Calculator();
    }

    @Test
    public void divisionEnteraPorero(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(4,0);
        });
        assertEquals("División por cero no permitida",ex.getMessage());

    }


}
