import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class DictionaryTest {

    private Dictionary dictionary;

    @Before
    public void setUp() {
        // Create a new instance of Dictionary before each test
        dictionary = new Dictionary();
    }

    @Test
    public void testGetPosition() {
        assertEquals(0, dictionary.getPosition('A'));
    }

    @Test
    public void testCheckIfExists() {
        assertTrue(dictionary.checkIfExists('D'));
        // Non-existent character
        assertFalse(dictionary.checkIfExists('@'));
    }

    @Test
    public void testGetKeyBasedOnValue() {
        assertEquals('A', dictionary.getKeyBasedOnValue(0));
    }
}