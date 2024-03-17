package tests;

import org.junit.Before;
import org.junit.Test;
import source.Diccionario;

import static org.junit.Assert.assertEquals;

/**
 * Clase de pruebas diccionario con un elemento
 * 
 * @author Armas Pérez, Kilian
 * @author Carballo Ramos, Pablo
 * @author Cruz Pérez, Saúl Antonio
 */
public class TestOneDict {
    private Diccionario d;

    @Before
    public void init() {
        d = new Diccionario();
        d.add("Madrid", 14);
    }
    
    /**
     * Prueba de size con un diccionario con un elemento
     */
    @Test
    public void testLen() {
        assertEquals("El tamaño debe ser 1", 1, d.size());
        d.popitem();
        assertEquals("El tamaño debe ser 0 después de eliminar", 0, d.size());
    }
    
    /**
     * Prueba de print con un diccionario con un elemento
     */
    @Test
    public void testPrint() {
        String dLen = d.toString();
        assertEquals("Resultado esperado: {Madrid : 14}", "{Madrid : 14}", dLen);
    }
    
    /**
     * Prueba de add con un diccionario con un elemento
     */
    @Test
    public void testAdd() {
        d.add("Barca", 5);
        String dLen = d.toString();
        assertEquals("No añade bien", "{Madrid : 14, Barca : 5}", dLen);
    }
    
    /**
     * Prueba de Override con un diccionario con un elemento
     */
    @Test
    public void testOverride() {
        d.add("Madrid", "15");
        String dLen = d.toString();
        assertEquals("No modifica bien", "{Madrid : 15}", dLen);
    }
    
    /**
     * Prueba de pop con un diccionario con un elemento
     */
    @Test
    public void testPop() {
        Object p = d.pop("Madrid");
        String dLen = d.toString();
        assertEquals("No elimina bien", "{}", dLen);
        assertEquals("No devuelve el valor eliminado", 14, p);
    }
    
    /**
     * Prueba de clear con un diccionario con un elemento
     */
    @Test
    public void testClear() {
        d.clear();
        String dLen = d.toString();
        assertEquals("No elimina bien", "{}", dLen);
    }
    
    /**
     * Prueba de setdefault con un diccionario con un elemento
     */
    @Test
    public void testSetdefault() {
        Object ya_esta = d.setdefault("Madrid", "14");
        d.setdefault("Las Palmas", "a primera");
        assertEquals("Si ya está la clave debe devolver el valor", 14, ya_esta);
        assertEquals("Si no está lo añade", d.toString(), "{Madrid : 14, Las Palmas : a primera}");
    }
    
    /**
    * Prueba popitem con un diccionario con un elemento
    */
    @Test
    public void testPopitem() {
        assertEquals("La longitud debe ser 1", 1, d.size());
        Object p = d.popitem();
        assertEquals("No devuelve el último valor añadido", "Madrid : 14", p.toString());
        assertEquals("La longitud debe ser 0", 0, d.size());
    }
}
