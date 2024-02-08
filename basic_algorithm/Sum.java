package basic_algorithm;

public class Sum {
    public static void main(String[] args) {
        System.out.println("sumof(1, 3): " + sumof(3, 7));
        System.out.println("sumof(7): " + sumof(7));

        System.out.println("arithSequen(3, 4, 3): " + arithSequen(3, 4, 3));
    }

    /**
     * 1부터 n까지의 모든 정수의 합을 구하여 반환
     */
    static int sumof(int n) {
        return sumof(1, n);
    }

    /**
     * 
     * @return 정수 a, b 를 포함하여 그 사이의 모든 정수의 합
     */
    static int sumof(int a, int b) {
        int start = a > b ? b : a;
        int end = a > b ? a : b;
        return (int) ((start + end) * ((end - start + 1) / (double) 2));
    }

    /**
     * 등차수열의 합을 반환하며 마지막 항인 제 n항의 값을 출력
     * 
     * @param a 첫째 항의 값
     * @param d 차수
     * @param n 마지막 제 n항
     * @return 첫 번째 항부터 n번째 항까지의 합계
     */
    static int arithSequen(int a, int d, int n) {
        return arithSequen(a, d, n, false);
    }

    static int arithSequen(int a, int d, int n, boolean print) {
        int l = a + (n - 1) * d;
        int s = (n * (a + l)) / 2;
        if (print)
            System.out.printf("----Method arithSequen-----\n제%d항: %d \n---------------------------\n", n, l);
        return s;
    }
}
