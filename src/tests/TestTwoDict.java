package tests;

import org.junit.Before;
import org.junit.Test;
import source.Diccionario;

import static org.junit.Assert.assertEquals;

/**
 * Clase de pruebas diccionario con dos elementos
 * 
 * @author Armas Pérez, Kilian
 * @author Carballo Ramos, Pablo
 * @author Cruz Pérez, Saúl Antonio
 */
public class TestTwoDict {
    private Diccionario d;

    @Before
    public void init() {
        d = new Diccionario();
        d.add("Eren", "Yeager");
        d.add("Mikasa", "Ackerman");
    }
    
    /**
     * Prueba de size con un diccionario con dos elementos
     */
    @Test
    public void testLen() {
        assertEquals("El tamaño debe ser 2 después de inicializar", 2, d.size());
    }
    
    /**
     * Prueba de print con un diccionario con dos elementos
     */
    @Test
    public void testPrint() {
        String dString = d.toString();
        assertEquals("Resultado esperado: {Eren : Yeager, Mikasa : Ackerman}", "{Eren : Yeager, Mikasa : Ackerman}", dString);
    }
    
    /**
     * Prueba de add con un diccionario con dos elementos
     */
    @Test
    public void testAdd() {
        d.add("Armin", "Arlert");
        String dString = d.toString();
        assertEquals("No se añade correctamente", "{Eren : Yeager, Mikasa : Ackerman, Armin : Arlert}", dString);
    }
    
    /**
     * Prueba de Override con un diccionario con dos elementos
     */
    @Test
    public void testOverride() {
        d.add("Eren", "Kruger");
        String dString = d.toString();
        assertEquals("No se modifica correctamente", "{Eren : Kruger, Mikasa : Ackerman}", dString);
    }
    
    /**
     * Prueba de pop con un diccionario con dos elementos
     */
    @Test
    public void testPop() {
        Object p = d.pop("Mikasa");
        String dString = d.toString();
        assertEquals("No se elimina correctamente", "{Eren : Yeager}", dString);
        assertEquals("No se devuelve el valor correcto", "Ackerman", p);
    }
    
    /**
     * Prueba de clear con un diccionario con dos elementos
     */
    @Test
    public void testClear() {
        d.clear();
        int dLen = d.size();
        assertEquals("El tamaño debe ser 0 después de eliminar", 0, dLen);
    }
    
    /**
    * Prueba popitem con un diccionario con dos elementos
    */
    @Test
    public void testPopitem() {
        Object p = d.popitem();
        assertEquals("No devuelve el último valor añadido", "Mikasa : Ackerman", p.toString());
        assertEquals("La longitud debe ser 1", 1, d.size());
    }

    /**
     * Prueba copy con un diccionario con dos elementos
     */
    @Test
    public void testCopy() {
        Diccionario nd = d.copy();
        assertEquals("No realiza la copia correctamente", d, nd);
    }

    /**
     * Prueba update con un diccionario con dos elementos
     */
    @Test
    public void testUpdate() {
        Diccionario nd = new Diccionario(5);
        nd.add("Eren", "Fundador/de Ataque/Martillo de Guerra");
        nd.add("Armin", "Colosal");
        d.update(nd);
        String dString = d.toString();
        assertEquals("No actualiza el diccionario correctamente", 
            "{Eren : Fundador/de Ataque/Martillo de Guerra, Mikasa : Ackerman, Armin : Colosal}", dString);
    }

    /**
     * Prueba items con un diccionario con dos elementos
     */
    @Test
    public void testItems() {
        Object[][] dItems = d.items();
        assertEquals("No se devuelven los elementos correctamente", "Eren", dItems[0][0]);
        assertEquals("No se devuelven los elementos correctamente", "Yeager", dItems[0][1]);
        assertEquals("No se devuelven los elementos correctamente", "Mikasa", dItems[1][0]);
        assertEquals("No se devuelven los elementos correctamente", "Ackerman", dItems[1][1]);
    }

    /**
     * Prueba keys con un diccionario con dos elementos
     */
    @Test
    public void testKeys() {
        Object[] dKeys = d.keys();
        assertEquals("No se devuelven los elementos correctamente", "Eren", dKeys[0]);
        assertEquals("No se devuelven los elementos correctamente", "Mikasa", dKeys[1]);
    }

    /**
     * Prueba values con un diccionario con dos elementos
     */
    @Test
    public void testValues() {
        Object[] dValues = d.values();
        assertEquals("No se devuelven los elementos correctamente", "Yeager", dValues[0]);
        assertEquals("No se devuelven los elementos correctamente", "Ackerman", dValues[1]);
    }
}
