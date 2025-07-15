package day05;

import java.util.Arrays;

public class B22SortAlgorithm {

    public static void main(String[] args) {

        int[] nums = { 32, 14, 31, 39, 41, 17 };

        for (int i = 0; i < nums.length - 1; i++) { // 1개 빼고 나머지 5개 부터 -1씩 비교하는 반복문
            for (int j = i + 1; j < nums.length; j++) { //
                int temp; // 변수의 값 교환을 위한 임시 변수
                if (nums[i] > nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            System.out.println(String.format("i=%d %s", i, Arrays.toString(nums)));
        }

        // selectionSort 메소드 실행
        int[] nums2 = { 88, 45, 23, 78, 56, 99, 84, 55, 78, 34 };
        selectionSort(nums2);
        System.out.println("num2 정렬 후 : " + Arrays.toString(nums2));
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { // 1개 빼고 나머지 5개 부터 -1씩 비교하는 반복문
            for (int j = i + 1; j < arr.length; j++) { //
                int temp; // 변수의 값 교환을 위한 임시 변수
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(String.format("i=%d %s", i, Arrays.toString(arr)));
        }
    }
}
