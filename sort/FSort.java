package sort;

/**
 * 도수정렬
 */
public class FSort {
    static void printArr(int[] a) {
        for (int i : a)
            System.out.print(" " + i);
        System.out.println();
    }

    static void fSort(int[] a) {
        int max = a[0];
        for (int num : a)
            if (max < num)
                max = num;

        fSort(a, a.length, max);
    }

    static void fSort(int[] a, int max) {
        fSort(a, a.length, max);
    }

    static void fSort(int[] a, int n, int max) {
        // 도수분포표 만들기
        int[] f = new int[max + 1];
        for (int i = 0; i < n; i++)
            f[a[i]]++;

        // 누적도수분포표 만들기
        for (int i = 1; i <= max; i++)
            f[i] += f[i - 1];

        // 목적 배열 만들기
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[--f[a[i]]] = a[i];
        }

        // 베열 복사하기
        System.arraycopy(t, 0, a, 0, n);
    }

    public static void main(String[] args) {
        int[] a = { 5, 7, 0, 2, 4, 10, 3, 1, 3 };

        System.out.println("Before fSort : Array a");
        printArr(a);

        System.out.println();
        fSort(a);
        System.out.println("After fSort : Array a");
        printArr(a);
    }
}
