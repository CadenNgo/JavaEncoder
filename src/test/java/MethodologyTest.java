

import org.junit.Test;

import static org.junit.Assert.*;

public class MethodologyTest {

    @Test
    public void testEncode() {

        Dictionary dictionary = new Dictionary();
        Methodology methodology = new Methodology(dictionary);

        String encodedText = methodology.encode("HELLO WORLD","F".charAt(0));
        assertEquals("Encoded text should match", "FC/GGJ RJMG.", encodedText);
    }

    @Test
    public void testDecode() {
        Dictionary dictionary = new Dictionary();
        Methodology methodology = new Methodology(dictionary);

        String decodedText = methodology.decode("FC/GGJ RJMG.");
        assertEquals("Decoded text should match", "HELLO WORLD", decodedText);
    }
}