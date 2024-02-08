package basic_algorithm;

import java.util.Arrays;

/**
 * Median: 중앙값 구하는 프로그램
 */
public class Median {

    public static void main(String[] args) {
        System.out.println("median(3,8,7): " + median(3, 8, 7));
        System.out.println("median(1,3,2): " + median(1, 3, 2));
        System.out.println("median(3,9,4): " + median(3, 9, 4));

    }

    /**
     * median: 3 개의 정수 중에서 중앙값을 계산
     */
    static int median(int a, int b, int c) {
        // 1)
        // if (a >= b)
        // if (b >= c)
        // return b;
        // else if (a <= c)
        // return a;
        // else
        // return c;
        // else if (a > c)
        // return a;
        // else if (b > c)
        // return c;
        // else
        // return b;

        int[] temp = { a, b, c };
        return median(temp);
    }

    /**
     * median: 홀수 개의 정수 원소를 가진 배열 내 중앙값을 계산
     */
    static int median(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length / 2];

    }
}
