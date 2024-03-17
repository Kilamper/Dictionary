package tests;

import org.junit.Before;
import org.junit.Test;
import source.Diccionario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Clase de pruebas diccionario con varios elementos
 * 
 * @author Armas Pérez, Kilian
 * @author Carballo Ramos, Pablo
 * @author Cruz Pérez, Saúl Antonio
 */
public class TestManyItemsDict {
    private Diccionario d;

    @Before
    public void init() {
        d = new Diccionario();
        d.add("Madrid", 14);
        d.add("Barca", 5);
        d.add("Milan", 7);
        d.add("Bayer", 6);
        d.add("Las Palmas", 0);
        d.add("Ancelotti", "Vinicius");
        d.add("Pimineta", "Moleiro");
        d.add("Haaland", "Mbappe");
    }
    
    /**
     * Prueba de len con un diccionario con varios elementos
     */
    @Test
    public void testLen() {
        int dLen = d.size();
        assertEquals("El tamaño debe ser 8", 8, dLen);
    }
    
    /**
     * Prueba de print con un diccionario con varios elementos
     */
    @Test
    public void testPrint() {
        String dLen = d.toString();
        assertEquals("Resultado esperado:",
        "{Madrid : 14, Barca : 5, Milan : 7, Bayer : 6, Las Palmas : 0, Ancelotti : Vinicius, Pimineta : Moleiro, Haaland : Mbappe}", dLen);
    }
    
    /**
     * Prueba de add con un diccionario con varios elementos
     */
    @Test
    public void testAdd() {
        d.add("Betis", 0);
        d.add("Villareal", 0);
        String dLen = d.toString();
        assertEquals("No añade bien",
        "{Madrid : 14, Barca : 5, Milan : 7, Bayer : 6, Las Palmas : 0, Ancelotti : Vinicius, Pimineta : Moleiro, Haaland : Mbappe, Betis : 0, Villareal : 0}", 
        dLen);
    }
    
    /**
     * Prueba de Override con un diccionario con varios elementos
     */
    @Test
    public void testOverride() {
        d.add("Madrid", 15);
        d.add("Haaland", "Valverde");
        d.add("Las Palmas", "a primera");
        String dLen = d.toString();
        assertEquals("No modifica bien",
        "{Madrid : 15, Barca : 5, Milan : 7, Bayer : 6, Las Palmas : a primera, Ancelotti : Vinicius, Pimineta : Moleiro, Haaland : Valverde}",
        dLen);
    }
    
    /**
     * Prueba de get en un diccionario con varios elementos
     */
    @Test
    public void testGet() {
        assertEquals("No obtiene el elemento correctamente", 14, d.get("Madrid"));
        assertEquals("No obtiene el elemento correctamente", 7, d.get("Milan"));
        assertEquals("No obtiene el elemento correctamente", 0, d.get("Las Palmas"));
        assertEquals("No obtiene el elemento correctamente", "Mbappe", d.get("Haaland"));
        assertEquals("Si no se encuentra en el diccionario imprime un mensaje", "no está", d.get("Betis", "no está"));
    }

    /**
     * Prueba de elminar con un diccionario con varios elementos
     */
    @Test
    public void testPop() {
        Object p = d.pop("Madrid");
        Object p2 = d.pop("Haaland");
        Object p3 = d.pop("Las Palmas");
        String dLen = d.toString();
        assertEquals("No elimina bien", 14, p);
        assertEquals("No elimina bien", "Mbappe", p2);
        assertEquals("No elimina bien", 0, p3);
        assertEquals("No devuelve el valor eliminado",
        "{Barca : 5, Milan : 7, Bayer : 6, Ancelotti : Vinicius, Pimineta : Moleiro}",
        dLen);
        assertNull("Si se elimina un elemento debe retornar null al intentar encontrarlo", d.get("Madrid"));
        assertNull("Si no se encuentra el elemento debe retornar null al intentar encontrarlo", d.get("No está"));
    }
    
    /**
     * Prueba de popitem con un diccionario con varios elementos
     */
     @Test
     public void testPopitem() {
         Object p = d.popitem();
         Object p2 = d.popitem();
         assertEquals("No elimina el último elemento correctamente", "Haaland : Mbappe", p.toString());
         assertEquals("No elimina el último elemento correctamente", "Pimineta : Moleiro", p2.toString());
     }
    
    /**
     * Prueba de elminar todos los elementos
     */
    @Test
    public void testClear() {
        d.clear();
        String dLen = d.toString();
        assertEquals("No elimina bien", "{}", dLen);
    }
    
    /**
     * Prueba de setdefault con un diccionario con varios elementos
     */
    @Test
    public void testSetdefault() {
        Object ya_esta = d.setdefault("Madrid", "ya esta en la lista");
        d.setdefault("Pep", "Guardiola");
        assertEquals("Si está en la lista devuelve su valor", 14, ya_esta);
        assertEquals("Si no está en la lista lo añade",
        "{Madrid : 14, Barca : 5, Milan : 7, Bayer : 6, Las Palmas : 0, Ancelotti : Vinicius, Pimineta : Moleiro, Haaland : Mbappe, Pep : Guardiola}",
        d.toString());
    }
    
    /**
     * Prueba de copy con un diccionario con varios elementos
     */
    @Test
    public void testCopy() {
        Diccionario nd = d.copy();
        assertEquals("No copia correctamente", d, nd);
    }
    
    /**
     * Prueba de items con un diccionario con varios elementos
     */
    @Test
    public void testItems() {
        Object[][] items = d.items();
        assertEquals("No guarda los items correctamente", "Madrid", items[0][0]);
        assertEquals("No guarda los items correctamente", 14, items[0][1]);
        assertEquals("No guarda los items correctamente", "Barca", items[1][0]);
        assertEquals("No guarda los items correctamente", 5, items[1][1]);
        assertEquals("No guarda los items correctamente", "Haaland", items[7][0]);
        assertEquals("No guarda los items correctamente", "Mbappe", items[7][1]);
    }
    
    /**
     * Prueba de keys con un diccionario con varios elementos
     */
    @Test
    public void testKeys() {
        Object[] keys = d.keys();
        assertEquals("No guarda las keys correctamente", "Madrid", keys[0]);
        assertEquals("No guarda las keys correctamente", "Barca", keys[1]);
        assertEquals("No guarda las keys correctamente", "Ancelotti", keys[5]);
        assertEquals("No guarda las keys correctamente", "Haaland", keys[7]);
    }
    
    /**
     * Prueba de values con un diccionario con varios elementos
     */
    @Test
    public void testValues() {
        Object[] values = d.values();
        assertEquals("No guarda los values correctamente", 14, values[0]);
        assertEquals("No guarda los values correctamente", 5, values[1]);
        assertEquals("No guarda los values correctamente", "Vinicius", values[5]);
        assertEquals("No guarda los values correctamente", "Mbappe", values[7]);
    }
    
    
}
