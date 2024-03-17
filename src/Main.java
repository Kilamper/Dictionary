/**
 * Test Suite para la clase Diccionario
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import tests.TestTwoHundredDict;

@RunWith(Suite.class)
@SuiteClasses({ tests.TestEmptyDict.class,
                tests.TestOneDict.class, 
                tests.TestManyItemsDict.class, 
                TestTwoHundredDict.class
          })

public class Main {
    public static void main(String[] args) {
        // Ejecución de las pruebas
        org.junit.runner.JUnitCore.main("Main");
    }
}
