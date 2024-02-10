package search;

/**
 * Sequential Search(순차 검색)
 */
public class SeqSearch {

    /**
     * 
     * @param arr
     * @param n
     * @param key
     * @return 순차 검색 실패시 배열 내에 key값이 없으므로 -1 반환하고 순차 검색 성공시 해당 key값이 든 배열의 인덱스를 반환
     */
    static int seqSearch(int[] arr, int n, int key) {
        // 1) while문
        // int i = 0;
        // while (true) {
        // if (i == n)
        // return -1;
        // if (arr[i] == key)
        // return i;
        // i++;
        // }

        // 2) for문
        for (int i = 0; i < n; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    /**
     * 보초법(sentinel method)로 선형 검색
     * 
     * @param arr
     * @param n
     * @param key
     * @return
     */
    static int seqSearchSen(int[] arr, int n, int key) {
        int i = 0;
        arr[n] = key;

        while (true) {
            if (arr[i] == key)
                break;
            i++;
        }
        return i == n ? -1 : i;
    }

    static void showSeqSearch(int[] arr, int key) {
        int idx = 0;
        System.out.print("  |");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %d ", i);
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print("----");
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            System.out.print("  |");
            for (int k = 0; k < arr.length; k++) {
                if (k == i) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.printf("\n %d|", i);
            for (int j = 0; j < arr.length; j++) {
                System.out.printf(" %d ", arr[j]);
            }
            System.out.println();
            if (arr[i] == key) {
                idx = i;
                break;
            }
        }

        System.out.printf("\n%d은 x[%d]에 있습니다.", key, idx);
    }

    static int searchIdx(int[] arr, int key, int[] idx) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                if (count >= idx.length) {
                    int[] temp = new int[idx.length + 1];
                    for (int j = 0; j < idx.length; j++) {
                        temp[j] = idx[j];
                    }
                    idx = temp;
                }
                idx[count] = i;
                count++;
            }

        }
        // for (int num : idx) {
        // System.out.println(num);
        // }
        return idx[0] == -1 ? 0 : idx.length;
    }

    public static void main(String[] args) {

        int[] arr = { 6, 4, 3, 2, 1, 9, 8 };
        showSeqSearch(arr, 1);

        int[] arr2 = { 1, 9, 2, 9, 4, 6, 7, 9 };
        System.out.println(searchIdx(arr2, 9, new int[] { -1 }));
    }
}
