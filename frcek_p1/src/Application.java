import java.util.Arrays;

public class Application {
    public static void main(String[] args) {

        Encrypter myEncrypter = new Encrypter();
        String encryptedValue = myEncrypter.encrypt("5678");

        Decrypter myDecrypter = new Decrypter();
        String decryptedValue = myDecrypter.decrypt("0189");

        System.out.println(encryptedValue);
        System.out.println(decryptedValue);

    }
}
