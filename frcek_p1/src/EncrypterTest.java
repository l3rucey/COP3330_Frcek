import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EncrypterTest {
    @Test
    public void testEncrypt() {
        Encrypter myEncrypter = new Encrypter();
        assertEquals("0189", myEncrypter.encrypt("1234"));
    }

    @Test
    public void testDecrypt() {
        Decrypter myDecrypter = new Decrypter();
        assertEquals("1234", myDecrypter.decrypt("0189"));
    }

}