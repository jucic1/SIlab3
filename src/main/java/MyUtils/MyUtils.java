package MyUtils;

public class MyUtils {
    public static int[] invertArray(int[] array) {
        int[] temp = new int[array.length];
        int index = 0;
        for (int i = array.length-1; i >= 0; i--) {
            temp[index] = array[i];
            index++;
        }
        return temp;
    }
}
