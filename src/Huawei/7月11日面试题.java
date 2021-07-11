import java.util.LinkedList;

public class Main {
    //大数组，三种元素，0，1，2
    //Paixu
    public static void main(String[] args) {
        int[] array = {1, 2, 1, 2, 3, 3};
        LinkedList<Integer> array1 = new LinkedList<Integer>();
//        LinkedList<Integer> a = new LinkedList<>();
        LinkedList<Integer> array2 = new LinkedList<Integer>();
        LinkedList<Integer> array3 = new LinkedList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 1) {
                array1.add(array[i]);
            } else if(array[i] == 2) {
                array2.add(array[i]);
            } else if(array[i]==3)
                array3.add(array[i]);
        }
        int l1 = array1.size();
        int l2 = array2.size();

        int[] sortedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (i < l1)
                sortedArray[i] = array1.get(i);
            else if (i >= l1 && i < (l1 + l2))
                sortedArray[i] = array2.get(i - l1);
            else
                sortedArray[i] = array3.get(i - l1 - l2);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(sortedArray[i]);
        }

    }
}
