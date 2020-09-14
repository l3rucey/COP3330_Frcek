import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        /*
        int[] a = {1, 3, 5};
        String b = "1234";
        int num2 = Integer.parseInt(b);

        System.out.println(Arrays.toString(a));
        System.out.println(b);
        */
        Encrypter encrypt = new Encrypter("1234");

        encrypt.printDat();
        encrypt.toAnArray();
    }
}
