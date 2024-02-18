package sort;

public class BubbleSort {
    static int count;

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void bubbleSortDesc(int[] a, int n) {
        count = 0;
        int k = 0;
        while (k < n - 1) {
            int last = n - 1;
            for (int j = n - 1; j > k; j--) {
                if (a[j - 1] < a[j])
                    swap(a, j - 1, j);
                last = j;
            }
            k = last;
            count++;
        }
    }

    static void bubbleSortDesc(int[] a) {
        bubbleSortDesc(a, a.length);
    }

    static void bubbleSort(int[] a, int n) {
        count = 0;
        int k = 0;
        while (k < n - 1) {
            int last = n - 1;
            for (int j = n - 1; j > k; j--) {
                if (a[j - 1] > a[j])
                    swap(a, j - 1, j);
                last = j;
            }
            k = last;
            count++;
        }
    }

    static void bubbleSort(int[] a) {
        bubbleSort(a, a.length);
    }

    static void printArr(int[] a) {
        for (int num : a) {
            System.out.print(" " + num);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = { 22, 5, 11, 31, 120, 68, 70 };

        System.out.println("버블 정렬 전");
        printArr(arr1);

        System.out.println();
        bubbleSort(arr1);
        System.out.println("버블 정렬 후 (오름순)");
        printArr(arr1);
        System.out.println("count: " + count);

        int[] arr2 = { 22, 5, 11, 31, 120, 68, 70 };

        System.out.println();
        bubbleSortDesc(arr2);
        System.out.println("버블 정렬 후 (내림순)");
        printArr(arr2);
        System.out.println("count: " + count);

    }
}
