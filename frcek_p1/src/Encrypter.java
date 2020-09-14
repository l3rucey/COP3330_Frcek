public class Encrypter {
    private String numString;

    public Encrypter(String s) {
        numString = s;
    }

    // converts string to int then initializes array
    public int[] toAnArray() {
        int[] array = new int[4]; // make this dynamic later
        int size = array.length;
        int num = Integer.parseInt(numString);

        // initialize array
        for (int i = 1; i <= size; i++) {
            array[size - i] = (num % 10);
            num = (num/10);
        }

        return array;
    }

    public int[] encryptMethod() {
        int[] array = new int[4];
        array = toAnArray();
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

        return array;
    }

    // testing array
    public void printDat() {
        int i = 0;
        int[] newArray = new int[4];
        newArray = encryptMethod();

        for (i = 0; i < 4; i++) {
            System.out.printf("Arrayyyyyy[%d] = %d\n", i, newArray[i]);
        }
    }
}
