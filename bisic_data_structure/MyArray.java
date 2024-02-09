package bisic_data_structure;

public class MyArray {
    public static void main(String[] args) {
        // int[] a = getRandomArr(5);
        int[] a = { 1, 2, 3, 4, 5 };
        int[] b = a.clone();
        int[] c = clone(b);
        int[] d = c;

        a[0] = 444;
        b[3] = 222;
        c[1] = 333;
        d[0] = 111;

        printArr(a);
        printArr(b);
        printArr(c);
        printArr(d);

        System.out.println("c == d: " + equals(c, d));

    }

    /**
     * 1차원 배열 내 요소 출력
     * 
     * @param arr
     */
    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                if (i == 0) {
                    System.out.printf("[ %d,", arr[i]);
                } else {
                    System.out.printf(" %d,", arr[i]);
                }
            } else {
                System.out.printf(" %d ]\n", arr[i]);
            }
        }
    }

    /**
     * 
     * @param arr
     * @return 매개변수로 전달받은 arr의 구성요소들을 복사한 배열 반환
     */
    static int[] clone(int[] arr) {
        int[] temp = new int[arr.length];
        int idx = 0;
        for (int value : arr) {
            temp[idx] = value;
            idx++;
        }
        return temp;
    }

    /**
     * 
     * @param arr
     * @return 배열 내 요소들 중 최댓값 반환
     */
    static int maxOf(int[] arr) {
        int max = arr[0];
        for (int value : arr) {
            max = value > max ? value : max;
        }
        return max;
    }

    /**
     * 
     * @param length : 반환할 배열의 길이
     * @return 상수 FROM와 TO 사이의 정수 중 랜덤하게 추출된 요솟값으로 구성된 배열 반환
     */
    static int[] getRandomArr(int length) {
        final int FROM = -100;
        final int TO = 100;
        return getRandomArr(FROM, TO, length);
    }

    /**
     * 
     * @param a      : 배열 내 요솟값 범위
     * @param b      : 배열 내 요솟값 범위
     * @param length : 반환할 배열의 길이
     * @return : 정수 a와 b 사이의 정수 중 랜덤하게 추출된 요솟값으로 구성된 배열 반환
     */
    static int[] getRandomArr(int a, int b, int length) {
        try {
            if (length < 0) {
                Exception e = new Exception("배열의 길이가 잘못 설정되었습니다.");
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[i] = getRandomNum(a, b);
        }
        return temp;
    }

    /**
     * a와 b 사이의 정수 중 무작위 값을 뽑기
     * 
     * @param a
     * @param b
     * @return 정수 a와 b 를 포함한 두 정수 사이의 정수 중 무작위로 추출한 값 반환
     */
    static int getRandomNum(int a, int b) {
        int from = Math.min(a, b);
        int to = Math.max(a, b);

        return (int) (Math.random() * (Math.abs(to - from) + 1)) + from;
    }

    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, arr.length - i - 1);
        }
    }

    static int sumOf(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return sum;
    }

    static boolean equals(int[] a, int[] b) {
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

}
