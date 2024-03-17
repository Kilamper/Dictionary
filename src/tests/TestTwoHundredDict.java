package tests;

import org.junit.Before;
import org.junit.Test;
import source.Diccionario;

import static org.junit.Assert.assertEquals;

/**
 * Clase de pruebas diccionario con 200 elementos
 * 
 * @author Armas Pérez, Kilian
 * @author Carballo Ramos, Pablo
 * @author Cruz Pérez, Saúl Antonio
 */
public class TestTwoHundredDict {
    private Diccionario d;

    @Before
    public void init() {
        d = new Diccionario(300);
        for (int i = 1; i <= 200; i++) {
            d.add("c" + i, "clave" + i);
        }
    }

    /**
     * Prueba de len con un diccionario con 200 elementos
     */
    @Test
    public void testLen() {
        int dLen = d.size();
        assertEquals("El tamaño debe ser 200", 200, dLen);
    }

    /**
     * Prueba de print con un diccionario con 200 elementos
     */
    @Test
    public void testPrint() {
        String dString = d.toString();
        StringBuilder cadena = new StringBuilder("{");
        for (int i = 1; i < 200; i++) {
            cadena.append("c").append(i).append(" : ").append("clave").append(i).append(", ");
        }
        cadena.append("c200 : clave200}");
        assertEquals("No es el resultado esperado", cadena.toString(), dString);
    }
}