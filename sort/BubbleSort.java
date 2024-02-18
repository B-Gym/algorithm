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
        for (int i = 0; i < n - 1; i++) {
            int exchg = 0;
            for (int j = n - 1; j > i; j--) {
                count++;
                if (a[j - 1] < a[j]) {
                    swap(a, j - 1, j);
                    exchg++;
                }
                if (exchg == 0)
                    break;
            }
        }
    }

    static void bubbleSortDesc(int[] a) {
        bubbleSortDesc(a, a.length);
    }

    static void bubbleSort(int[] a, int n) {
        count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                count++;
                if (a[j - 1] > a[j])
                    swap(a, j - 1, j);
            }
        }
    }

    static void bubbleSort(int[] a) {
        // bubbleSort(a, a.length);
        count = 0;
        int k = 0;
        int n = a.length;
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
        bubbleSort(arr1, arr1.length);
        System.out.println("버블 정렬(버전 1) 후 (오름순))");
        printArr(arr1);
        System.out.println("count: " + count);

        int[] arr2 = { 22, 5, 11, 31, 120, 68, 70 };

        System.out.println();
        bubbleSortDesc(arr2);
        System.out.println("버블 정렬(버전 2) 후 (내림순))");
        printArr(arr2);
        System.out.println("count: " + count);

        int[] arr3 = { 22, 5, 11, 31, 120, 68, 70 };

        System.out.println();
        bubbleSort(arr3);
        System.out.println("버블 정렬(버전 3) 후 (오름순))");
        printArr(arr3);
        System.out.println("count: " + count);
    }
}
