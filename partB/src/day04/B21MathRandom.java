package day04;

import java.util.Arrays;

public class B21MathRandom {
    public static void main(String[] args) {
        int[] result = new int[6]; // 뽑을 공 : 6개
        int[] balls = new int[45]; // 총 공 : 45개

        for (int i = 0; i < 45; i++)
            balls[i] = i + 1; // 명령문이 하나만 반복할 때는 {} 생략

        // 간단 테스트
        for (int i = 0; i < 6; i++) {
            // System.out.println(Math.random()); // 0보다 크고 1보다 작은 실수
            double rndNum = Math.random(); // 0.0 이상 1.0 미만의 랜덤 실수 생성
            // 1) 공을 뽑을 index 랜덤 만들기
            int range = 45 - i; // 0보다 크고 (45-i) 보다 작은 랜덤값으로 범위 줄여나감
            System.out.print(rndNum * range + "\t"); // 0보다 크고 range 보다 작은 실수
            System.out.println((int) (rndNum * range)); // 잘림. Math.round() 반올림
            int ballIndex = (int) (rndNum * range);

            // 2) 랜덤 인덱스로 공 뽑기 -> result 배열에 저장
            result[i] = balls[ballIndex];

            // 3) ballIndex 위치의 값은 빼고 복사하여 새로운 배열로 계속하기
            // 메소드 실행 결과 - balls
            balls = newBalls(balls, ballIndex);
            // (1) 리턴 저장 balls 주소 (2) 인자의 balls 주소 : 배열이름은 동일. 주소는 다름
            // (2)번은 newBalls 실행하고 나면 참조되지 않는다. => JVM이 GC(garbage Collection)
            // 🔥 메모리 누수 : 참조는 되고 있으나 사용하지 않는다.
            System.out.println(Arrays.toString(result)); // 공 6개 배열
            System.out.println(Arrays.toString(balls)); // 남은 공 배열

        }

    }
    // 배열 복사 메소드 : System 클래스

    // 뽑힌 공 인덱스 ballIndex 의 값을 빼고 새로운 배열 만들기 // 남은 공 배열 보여주는거
    private static int[] newBalls(int[] balls, int ballIndex) {
        int[] result = new int[balls.length - 1];
        // 예시: balls.length 가 45이면 새로 만드는 배열은 44개
        // 그리고 ballIndex 가 7이면
        // 첫번째 복사는 0부터 6까지 7개 복사
        System.arraycopy(balls, 0, result, 0, ballIndex); // 7개
        // 두번째 복사는 8번 인덱스 부터 45-7-1 = 37개
        // target 배열 result는 7번 인덱스부터 저장 시키기
        System.arraycopy(balls, ballIndex + 1, result, ballIndex, balls.length - 1 - ballIndex);

        return result;
    }

    // 두 배열 합치기 : System 클래스 메소드의 복사를 활용해 보세요.
    private static int[] mergeOfArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length]; // arr1 크기 + arr2 크기

        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);

        return result; // 배열의 참조값을 전달하기
    }
}

/*
 *
 * 1. 45개의 ball 배열을 만든다.(1 ~ 45) clear
 * 2. 랜덤 1개를 뽑는다.(인덱스 0 ~ 44)
 * 3. 랜덤 1개의 값을 빼고 새로운 배열 만들기
 * 2,3번 반복
 * 
 * System.arraycopy(원본배열, 원본시작인덱스, 복사배열, 복사시작인덱스, 복사길이)
 */