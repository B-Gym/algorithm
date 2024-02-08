package basic_algorithm;

import java.util.*;

/**
 * MaxMin: 입력받은 2~4개의 값 혹은 정수 배열 내에 정수 중에서 최댓값을 구하는 프로그램
 */
public class MaxMin {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        // System.out.println("세 정수를 입력하면 최댓값을 구합니다.");
        // System.out.print("a: ");
        // int a = sc.nextInt();
        // System.out.print("b: ");
        // int b = sc.nextInt();
        // System.out.print("c: ");
        // int c = sc.nextInt();

        // System.out.println("최댓값은 " + max(a, b, c) + "입니다.");

        System.out.println("max(2, 4, 7, 3): " + max(2, 4, 7, 3));
        System.out.println("min(2, 4, 7, 3): " + min(2, 4, 7, 3));
    }

    static int max(int a, int b) {
        int[] temp = { a, b };
        return max(temp);
    }

    static int max(int a, int b, int c) {
        int[] temp = { a, b, c };
        return max(temp);
    }

    static int max(int a, int b, int c, int d) {
        int[] temp = { a, b, c, d };
        return max(temp);
    }

    static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    static int min(int a, int b) {
        int[] temp = { a, b };
        return min(temp);
    }

    static int min(int a, int b, int c) {
        int[] temp = { a, b, c };
        return min(temp);
    }

    static int min(int a, int b, int c, int d) {
        int[] temp = { a, b, c, d };
        return min(temp);
    }

    static int min(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }
}