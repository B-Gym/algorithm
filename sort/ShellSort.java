package sort;

public class ShellSort {
    static int count;

    static void printArr(int[] a) {
        for (int num : a) {
            System.out.print(" " + num);
        }
        System.out.println();
    }

    static void shellSort(int[] a, int n) {
        for (int h = n / 2; h > 0; h /= 2) {
            for (int i = h; i < n; i++) {
                int j;
                int temp = a[i];
                for (j = i - h; j >= 0 && a[j] > temp; j -= h) {
                    a[j + h] = a[j];
                    count++;
                }
                a[j + h] = temp;
                count++;
            }
            count++;
        }
    }

    static void shellSort(int[] a) {
        shellSort(a, a.length);
    }

    public static void main(String[] args) {
        int[] arr1 = { 22, 5, 11, 31, 120, 68, 70 };

        System.out.println("쉘 정렬 전");
        printArr(arr1);

        System.out.println();
        shellSort(arr1);
        System.out.println("쉘 정렬 후");
        printArr(arr1);
        System.out.println("count: " + count);
    }
}
