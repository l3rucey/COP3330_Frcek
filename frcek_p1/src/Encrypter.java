import java.lang.reflect.Array;

public class Encrypter {

    // converts string to int then initializes array
    public int[] toAnArray(String s) {
        int[] array = new int[4]; // make this dynamic later
        int size = array.length;
        int num = Integer.parseInt(s);

        // initialize array
        for (int i = 1; i <= size; i++) {
            array[size - i] = (num % 10);
            num = (num/10);
        }

        return array;
    }

    public String encryptMethod(int[] s) {
        int[] array = new int[4];
        array = s;
        String newString = "";
        //array = toAnArray(s);
        int i, temp;

        // add each digit by 7 then mod by 10
        for (i = 0; i < 4; i++) {
            array[i] = ((array[i] + 7)%10);
        }

        // Swap
        temp = array[0];
        array[0] = array[2];
        array[2] = temp;
        temp = array[1];
        array[1] = array[3];
        array[3] = temp;

        // convert to string
        for (i = 0; i < 4; i++) {
            newString += array[i];
            //System.out.println(newString);
        }

        return newString;
    }

    public String encrypt(String s) {
        s = encryptMethod(toAnArray(s));
        //System.out.println(s);

        return s;
    }
}
