package day05;

import java.util.Arrays;

public class B23SortTest {

    public static void main(String[] args) {
        double[] darr1 = new double[10];

        for (int i = 0; i < darr1.length; i++) {
            darr1[i] = Math.random();
            darr1[i] = Math.floor(darr1[i] * 100) / 100;
            // floor() 메소드로 소수점 이하 2자리 랜덤 값 만들기
        }
        // 선택정렬 같은 값으로 실행할 배열
        double[] darr2 = darr1.clone(); // darr1 배열을 복사해서 darr2 로 참조

        System.out.println("랜덤 double 배열 1 : " + Arrays.toString(darr1));
        System.out.println("랜덤 double 배열 2 : " + Arrays.toString(darr2));

        // 실행 시간 비교 : 성능 측정 nanoTime() 메소드
        long startTime = System.nanoTime();
        new B23SortTest().bubbleSort(darr1);
        long endTime = System.nanoTime();
        System.out.println("double 배열 정렬 후(bubbleSort) : " + Arrays.toString(darr1));
        System.out.println("실행 시간 : " + (endTime - startTime) + "ns");
        // bubbleSort : 23932200ns

        startTime = System.nanoTime();
        new B23SortTest().selectionSort(darr2);
        endTime = System.nanoTime();
        System.out.println("double 배열 정렬 후(selectionSort) : " + Arrays.toString(darr2));
        System.out.println("실행 시간 : " + (endTime - startTime) + "ns");
        // selectionSort : 2544200ns
    }
    // 참고 ✅ 참고 : 정렬(알고리즘)의 성능 측정 -> 시간복잡도. 표기 Big-O. n은 데이터갯수
    // 버블 정렬, 선택정렬 : O(n의 제곱)
    // 병합 정렬, 퀵 정렬... : O(n log n) < O(n의 제곱)
    // Arrays.sort() 등 라이브러리는 성능이 좋은 알고리즘 사용합니다.

    double[] darr1 = new double[10]; // 배열이 10개인 실수형 darr1 선언

    void selectionSort(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // System.out.println("==== i=" + i + " ====");
            for (int j = i + 1; j < arr.length; j++) {
                // System.out.print(" j=" + j + " 비교: arr[" + i + "]=" + arr[i] + " > arr[" + j
                // + "]=" + arr[j]);
                if (arr[i] > arr[j]) {
                    // System.out.println(" → 교환!");
                    double temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    // System.out.println(" => arr: " + Arrays.toString(arr));
                } else {
                    // System.out.println(" → 교환 안 함");
                }
            }
            System.out.println(String.format("i=%d %s", i, Arrays.toString(arr)));
        }
    }

    // 인접한 2개 값을 비교
    void bubbleSort(double[] arr) {
        System.out.println("#### 버블정렬 ####");
        for (int i = 0; i < arr.length - 1; i++) {
            // System.out.println("----- i=" + i + " -----");
            for (int j = 0; j < arr.length - i - 1; j++) {
                // System.out.println(
                // " j=" + j + " 비교: arr[" + j + "]=" + arr[j] + " > arr[" + (j + 1) + "]=" +
                // arr[j + 1]);
                double temp;
                if (arr[j] > arr[j + 1]) {
                    // System.out.println(" -> 교환!");
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // System.out.println(" => arr: " + Arrays.toString(arr));
                } else {
                    // System.out.println(" -> 교환 안함!");
                }
            }
            System.out.println(String.format("i=%d %s", i, Arrays.toString(arr)));
        }
    }
}