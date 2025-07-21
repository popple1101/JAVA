package day09;

// shift 연산은 비트를 왼쪽 또는 오른쪽으로 이동합니다.
// 1. 맨왼쪽의 부호를 고려하는 연산(부호 비트는 변경안함)
// 2. 부호를 고려하지 않는 연산
public class D02ShiftTest {
    public static void main(String[] args) {
        int a = 25;
        System.out.println(to32BitBinary(a) + " " + a);
        int result = a >> 1; // 오른쪽으로 1비트 이동
        System.out.println("1. right shift - 정수의 나누기 2와 같은 동작");
        System.out.println(to32BitBinary(result) + " " + result);
        result = a >> 2;
        System.out.println(to32BitBinary(result) + " " + result);
        result = a >> 3;
        System.out.println(to32BitBinary(result) + " " + result);
        System.out.println(to32BitBinary(a) + " " + a);

        System.out.println("2. left shift - 정수의 곱하기 2와 같은 동작");
        System.out.println(to32BitBinary(a) + " " + a);
        result = a << 1; // 왼쪽으로 1비트 이동
        System.out.println(to32BitBinary(result) + " " + result);
        result = a << 2;
        System.out.println(to32BitBinary(result) + " " + result);
        result = a << 3;
        System.out.println(to32BitBinary(result) + " " + result);

        a = -25;
        System.out.println(to32BitBinary(a) + " " + a);
        System.out.println("음수의 오른쪽 shift 1회");
        // 질문 : 오른쪽 shift 연산에서 왼쪽에 새로 들어오는 bit는? 부호 비트와 같음
        System.out.println(to32BitBinary(a >> 1));

        System.out.println("음수의 왼쪽 shift 1회");
        System.out.println(to32BitBinary(a << 1));

        // 오른쪽 shift 연산에서 부호를 고려하지 않는 연산 >>> 은 새로 들어오는 비트를 무조건 0

        

        

    }

    private static String to32BitBinary(int x) {
        return String.format("%32s", Integer.toBinaryString(x)).replace(" ", "0");
    }
}

/*
 * 4비트 예시 shitf 연산
 * 
 * 1. 부호를 반영하는 오른쪽 shift
 * 오른쪽 양수 양수     0 0 1 0
 *                     0 0 0 1 (왼쪽 빈자리는 부호와 같게 만든다.)
 *            음수     1 0 1 0
 *                     1 1 0 1
 * 
 * 2. 왼쪽 shift
 * 양수                0 0 1 0
 *         1회         0 1 0 0 (오른쪽 빈자리는 무조건 0)
 *         2회         1 0 0 0 (오버플로우 발생)
 * 
 * 3. 부호가 없는 오른쪽 shift - 정수 표기에 unsigned 방식은 음수가 없습니다.
 *    왼쪽 빈자리는 무조건 0
 */