package sort;

public class MergeSort {
    static void mergeSort(int[] a, int[] b, int[] c) {
        mergeSort(a, a.length, b, b.length, c, c.length);
    }

    static void mergeSort(int[] a, int na, int[] b, int nb, int[] c, int nc) {
        int pa = 0;
        int pb = 0;
        int pc = 0;

        while (pa < na && pb < nb) // 배열 a와 b의 구성요소를 비교하여 더 작은 수를 저장
            c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];

        // 두 배열 간 비교 후 저장하는 절차를 마친 후 구성요소가 남은 배열의 구성요소를 복사
        while (pa < na)
            c[pc++] = a[pa++];

        while (pb < nb)
            c[pc++] = b[pb++];
    }

    static void printArr(int[] a) {
        for (int i : a)
            System.out.print(" " + i);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = { 2, 4, 6, 8, 11, 13 };
        int[] b = { 1, 2, 3, 4, 9, 16, 21 };
        int[] c = new int[a.length + b.length];

        // 병합할 두 배열은 정렬된 상태여야 함
        System.out.println("Array a");
        printArr(a);
        System.out.println("Array b");
        printArr(b);

        System.out.println("----merge----");
        mergeSort(a, b, c);
        printArr(c);

    }
}
