package search;

/**
 * Binary Search(이진 검색): 데이터가 이미 정렬된 상태여야만 수행 가능
 */
public class BinSearch {

    static int binSearch(int[] arr, int key) {
        return binSearch(arr, arr.length, key);
    }

    static int binSearch(int[] arr, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        // 1) while
        // do {
        // int pc = (pl + pr) / 2;
        // if (arr[pc] == key)
        // return pc;
        // else if (arr[pc] < key)
        // pl = pc + 1;
        // else
        // pr = pc - 1;
        // } while (pl <= pr);
        // return -1;

        // 2) for
        for (int i = pl; i <= pr; i++) {
            int pc = (pl + pr) / 2;
            if (arr[pc] == key)
                return pc;
            if (arr[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        }
        return -1;
    }

    static void showBinSearch(int[] arr, int key) {
        int pl = 0;
        int pr = arr.length - 1;

        int count = 0;
        for (int i = 0; i <= count; i++) {
            System.out.printf("%d|", i);

            for (int k = 0; k < arr.length; k++) {
                System.out.printf(" %d ", arr[k]);
            }

            for (int j = pl; j <= pr; j++) {
                int pc = (pl + pr) / 2;
                if (arr[pc] == key) {
                }
                if (arr[pc] < key) {
                    pl = pc + 1;
                } else {
                    pr = pc - 1;
                }
                count++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(binSearch(arr1, 3));
        System.out.println(binSearch(arr1, 9));

        // showBinSearch(arr1, 2);

    }
}
