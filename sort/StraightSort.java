package sort;

public class StraightSort {
    static int count;

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void printArr(int[] a) {
        for (int num : a) {
            System.out.print(" " + num);
        }
        System.out.println();
    }

    /**
     * 단순 선택 정렬
     * 
     * @param a
     * @param n
     */
    static void selectionSort(int[] a, int n) {
        count = 0;
        for (int i = 0; i < n - 1; i++) {
            int min = i; // 아직 정렬되지 않은 부분에서 가장 작은 인덱스를 저장
            for (int j = i + 1; j < n; j++) {
                if (a[j] > a[min])
                    min = j;
                swap(a, i, min);
                count++;
            }
        }
    }

    static void selectionSort(int[] a) {
        selectionSort(a, a.length);
    }

    static void insertionSort(int[] a, int n) {
        count = 0;
        for (int i = 1; i < n; i++) {
            int j;
            int temp = a[i];
            for (j = i; j > 0 && a[j - 1] > temp; j--) {
                a[j] = a[j - 1];
                count++;
            }
            a[j] = temp;
            count++;
        }
    }

    static void insertionSort(int[] a) {
        insertionSort(a, a.length);
    }

    public static void main(String[] args) {
        int[] arr1 = { 22, 5, 11, 31, 120, 68, 70 };

        System.out.println("단순 선택 정렬 전");
        printArr(arr1);

        System.out.println();
        selectionSort(arr1);
        System.out.println("단순 선택 정렬 후");
        printArr(arr1);
        System.out.println("count: " + count);

        int[] arr2 = { 22, 5, 11, 31, 120, 68, 70 };
        System.out.println();
        insertionSort(arr2);
        System.out.println("단순 삽입 정렬 후");
        printArr(arr2);
        System.out.println("count: " + count);

    }

}
