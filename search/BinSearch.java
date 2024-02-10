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
        int idx = -1;

        System.out.print("  |");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %d ", i);
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print("----");
        }
        System.out.println();

        for (int j = pl; j <= pr; j++) {
            int pc = (pl + pr) / 2;

            if (pc != 0) {
                System.out.print(" |");
                for (int k = 0; k < arr.length; k++) {
                    if (k == pc) {
                        System.out.print("+");
                    } else if (k == pr) {
                        System.out.print("  →");
                    } else if (k == pl) {
                        System.out.print("  ←  ");
                    } else {
                        System.out.print("   ");
                    }
                }
                System.out.println();
                System.out.printf("%d| ", pc);
                for (int k = 0; k < arr.length; k++) {
                    System.out.printf(" %d ", arr[k]);
                }
                System.out.println();
            }

            if (arr[pc] == key) {
                idx = pc;
                break;
            }
            if (arr[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }

        }

        if (idx == -1) {
            System.out.printf("\n%d은 x에 없습니다.", key);
        } else
            System.out.printf("\n%d은 x[%d]에 있습니다.", key, idx);

    }

    static int binSearchX(int[] arr, int key) {
        int pl = 0;
        int pr = arr.length - 1;

        for (int i = pl; i <= pr; i++) {
            int pc = (pl + pr) / 2;
            if (arr[pc] == key) {
                while (arr[pc] == key) {
                    // System.out.println("test: " + pc);
                    pc--;
                }
                return pc + 1;
            }
            if (arr[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 5, 6, 8, 9 };
        // System.out.println(binSearch(arr1, 3));
        // System.out.println(binSearch(arr1, 9));

        // showBinSearch(arr1, 3);

        int[] arr2 = { 1, 3, 5, 7, 7, 7, 7, 8, 8, 9, 9 };
        System.out.println(binSearchX(arr2, 7));

    }
}
