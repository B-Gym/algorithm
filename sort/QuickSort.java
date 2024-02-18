package sort;

public class QuickSort {
    static int count;

    static void printArr(int[] a) {
        for (int num : a) {
            System.out.print(" " + num);
        }
        System.out.println();
    }

    static void quickSort(int[] a, int l, int r) {
        int pl = l;
        int pr = r;
        int pivot = a[(pl + pr) / 2];

        // 피벗을 기준으로 피벗의 왼편은 피벗보다 작은 수를, 오른 편에는 피벗보다 큰 수를 가지도록 정렬
        do {
            while (a[pl] < pivot)
                pl++;
            while (a[pr] > pivot)
                pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        if (l < pr)
            quickSort(a, l, pr);
        if (r > pl)
            quickSort(a, r, pl);
    }

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] a, int n) {
        quickSort(a, 0, n - 1);
    }

    static void quickSort(int[] a) {
        quickSort(a, a.length);
    }

    public static void main(String[] args) {
        int[] arr1 = { 22, 5, 11, 31, 120, 68, 70 };

        System.out.println("퀵 정렬 전");
        printArr(arr1);

        System.out.println();
        quickSort(arr1);
        System.out.println("퀵 정렬 후");
        printArr(arr1);
        // System.out.println("count: " + count);
    }
}
