package tests;

import org.junit.Before;
import org.junit.Test;
import source.Diccionario;

import static org.junit.Assert.assertEquals;

/**
 * Clase de pruebas diccionario vacío
 * 
 * @author Armas Pérez, Kilian
 * @author Carballo Ramos, Pablo
 * @author Cruz Pérez, Saúl Antonio
 */
public class TestEmptyDict {
    private Diccionario d;

    @Before
    public void init() {
        d = new Diccionario();
    }
    
    /**
     * Prueba de len con un diccionario vacío
     */
    @Test
    public void testLen() {
        int dLen = d.size();
        assertEquals("El tamaño debe ser 0 después de inicializar", 0, dLen);
    }
    
    /**
     * Prueba de print con un diccionario vacío
     */
    @Test
    public void testPrint() {
        String dLen = d.toString();
        assertEquals("Resultado esperado: {}", "{}", dLen);
    }
    
    /**
     * Prueba de add con un diccionario vacío
     */
    @Test
    public void testAdd() {
        d.add("Madrid", 14);
        String dLen = d.toString();
        assertEquals("No añade bien", "{Madrid : 14}", dLen);
    }
    
}