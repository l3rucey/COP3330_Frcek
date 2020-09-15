public class Decrypter {

    // converts string to int, initializes array
    public int[] toAnArray(String s) {
        int[] array = new int[4];
        int num = Integer.parseInt(s);

        // initialize array
        for (int i = 1; i <= 4; i++) {
            array[4 - i] = (num % 10);
            num = (num/10);
        }

        return array;
    }

    // actual decryption process
    public String decryptionProcess(int[] s) {
        int i, temp;
        int[] array = new int[4];
        array = s;
        String newString = "";

        // Change array elements values
        for (i = 0; i < 4; i++) {
            array[i] = ((array[i] - 7));
            if ((array[i]) < 0) {
                array[i] = (array[i] + 10);
            } else {
                array[i] = (array[i] % 10);
            }
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
        }

        return newString;
    }

    // calls helper functions, returns decrypted string
    public String decrypt(String s) {
        s = decryptionProcess(toAnArray(s));

        return s;
    }
}
