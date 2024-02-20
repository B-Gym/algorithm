package sort;

public class HeapSort {
    /*
     * Heap의 요소를 배열로 저장할 때 부모와 자식의 인덱스
     * Parent idx = arr[(Child idx-1)/2];
     * Left Child idx = arr[Parent idx * 2 + 1]
     * Right Child idx = arr[Parent idx * 2 + 2]
     */
    static void printArr(int[] a) {
        for (int i : a)
            System.out.print(" " + i);
        System.out.println();
    }

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void downHeap(int[] a, int left, int right) {
        int temp = a[left];
        int child;
        int parent;

        for (parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1;
            int cr = cl + 1;

            child = (cr <= right && a[cr] > a[cl]) ? cr : cl; // 두 자식 중에 더 큰 값을 가진 자식 선정
            System.out.println("child: " + child);
            if (temp >= a[child])
                break;
            a[parent] = a[child];
        }
        a[parent] = temp; // parent = child 조건으로 자식 인덱스에 부모의 값을 저장

        System.out.println("----test----");
        printArr(a);
        System.out.println("-------------");
    }

    static void heapSort(int[] a) {
        heapSort(a, a.length);
    }

    static void heapSort(int[] a, int n) {
        // heap 상태로 만들기
        for (int i = (n - 1) / 2; i >= 0; i--) {
            System.out.println("i: " + i);
            downHeap(a, i, n - 1);
        }

        System.out.printf("\n\n\n--swap--\n\n\n\n");
        // heap sort : 최상위 루트(a[0]는 항상 높은 값만 적재
        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);
            downHeap(a, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = { 22, 5, 11, 32, 120, 68, 70 };
        System.out.println("Before Heap Sort : Array a");
        printArr(a);

        System.out.println();
        heapSort(a);
        System.out.println("After Heap Sort : Array a");
        printArr(a);
    }
}
