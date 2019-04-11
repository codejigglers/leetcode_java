import java.util.ArrayList;

public class HeapSort {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        input.add(6);
        input.add(7);
        input.add(8);
        input.add(9);
        input.add(10);
        input.add(11);

        heapify(input);
        add(input, 12);
        add(input, 13);
        add(input, 15);
        System.out.println(pop(input));
        System.out.println(pop(input));
        System.out.println(pop(input));
        System.out.println(pop(input));
        System.out.println(pop(input));
        System.out.println(pop(input));
        System.out.println(pop(input));
        System.out.println(pop(input));
        System.out.println(pop(input));
        System.out.println(pop(input));
        System.out.println(pop(input));
        System.out.println(pop(input));
        System.out.println(pop(input));
        System.out.println(pop(input));
    }

    ArrayList<Integer> arrayList;
    int N;

    public HeapSort() {
        this.arrayList = new ArrayList<>();
        this.N = arrayList.size();
    }

    public static int pop(ArrayList<Integer> arrayList) {
        int temp = arrayList.get(0);
        arrayList.set(0, arrayList.get(arrayList.size() - 1));
        arrayList.set(arrayList.size() - 1, temp);
        int toReturn = arrayList.get(arrayList.size() - 1);
        arrayList.remove(arrayList.size() - 1);
        sink(0, arrayList);
        return toReturn;
    }

    public static void heapify(ArrayList<Integer> array) {
        int i = array.size() / 2;
        i = i - 1;
        while (i >= 0) {
            if (((2 * (i + 1)) + 1) < array.size() && array.get(i) < array.get((2 * (i + 1)) - 1) && array.get(i) < array.get((2 * (i + 1)))) {
                if (array.get((2 * (i + 1)) - 1) > array.get((2 * (i + 1)))) {
                    int temp = array.get(i);
                    array.set(i, array.get((2 * (i + 1)) - 1));
                    array.set((2 * (i + 1)) - 1, temp);
                    sink((2 * (i + 1)) - 1, array);
                } else {
                    int temp = array.get(i);
                    array.set(i, array.get(((2 * (i + 1)))));
                    array.set(((2 * (i + 1))), temp);
                    sink((2 * (i + 1)), array);
                }
            } else if (((2 * (i + 1))) < array.size() && array.get(i) < array.get((2 * (i + 1)))) {
                int temp = array.get(i);
                array.set(i, array.get((2 * (i + 1))));
                array.set((2 * (i + 1)), temp);
                sink(((2 * (i + 1))), array);

            } else if (((2 * (i + 1)) - 1) < array.size() && array.get(i) < array.get((2 * (i + 1)) - 1)) {
                int temp = array.get(i);
                array.set(i, array.get((2 * (i + 1)) - 1));
                array.set((2 * (i + 1)) - 1, temp);
                sink((2 * (i + 1)) - 1, array);
            }
            i -= 1;
        }
    }

    public static void sink(int k, ArrayList<Integer> arrayList) {
        int N = arrayList.size();
        while ((2 * (k + 1)) - 1 < N) {
            int j = (2 * (k + 1)) - 1;

            if (j < N) {
                if (j + 1 < N && arrayList.get(j) < arrayList.get(j + 1)) {
                    j += 1;
                }
            }
            if (arrayList.get(k) < arrayList.get(j)) {
                int temp = arrayList.get(k);
                arrayList.set(k, arrayList.get(j));
                arrayList.set(j, temp);
            }
            k = j;
        }
    }

    private static void swimUp(int k, ArrayList<Integer> arrayList) {
        while (k > 1 && arrayList.get((k - 1) / 2) < arrayList.get(k)) {
            int temp = arrayList.get((k - 1) / 2);
            arrayList.set((k - 1) / 2, arrayList.get(k));
            arrayList.set(k, temp);
            k = (k - 1) / 2;
        }
    }

    //When we are adding an element to a heap, we just use the
    private static void add(ArrayList<Integer> arrayList, int k) {
        arrayList.add(k);
        swimUp(arrayList.size() - 1, arrayList);
    }

}
