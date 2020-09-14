public class Encrypter {
    private String numString;

    public Encrypter(String s) {
        numString = s;
    }

    public void toAnArray(String s) {
        int[] array1 = new int[4];
        int num = Integer.parseInt(s);

        for (int i = 0; i < 4; i++) {
            array1[i] = (num % 4);
        }

    }

    public void printDat() {
        System.out.println(Integer.parseInt(numString));
    }
}
