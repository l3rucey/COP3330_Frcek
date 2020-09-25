public class Application {
    /*
    public static void main(String[] args) {

        Encrypter myEncrypter = new Encrypter();
        String encryptedValue = myEncrypter.encrypt("7835");

        Decrypter myDecrypter = new Decrypter();
        String decryptedValue = myDecrypter.decrypt("0245");

        System.out.println(encryptedValue);
        System.out.println(decryptedValue);

    }

    */
    private static void f() {
        int[] xs = {0, 0, 0};

        try {
            xs[3] = 10;
            System.out.println(xs[3]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(-5);
        }
    }
}
