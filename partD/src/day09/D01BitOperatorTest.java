package day09;

// 비트 단위의 AND, OR, XOR, NOT 연산
public class D01BitOperatorTest {
    public static void main(String[] args) {
        System.out.println("1. 10진수 값의 2진수 문자열 출력");
        System.out.println("Integer.toBinaryString(24) : " + Integer.toBinaryString(24));
        // int 는 32비트(4바이트) : 32자리 문자열 출력하려면
        // System.out.println("32자리 문자열 : "
        // + String.format("%32s", Integer.toBinaryString(24)
        // .replace(" ", "0")));
        System.out.println("32자리 문자열 :" + String.format("%32s", Integer.toBinaryString(24)).replace(" ", "0"));
        System.out.println("비트 연산이란 ? 값을 2진수로 표현하여 비트 단위로 연산을 수행");
        System.out.println("\n\n");

        System.out.println("2. Bit AND - 두개의 값이 모두 1인 비트를 mask");
        int result = 24 & 129;
        System.out.println("24 & 129 = " + result);
        System.out.println(to32BitBinary(24));
        System.out.println(to32BitBinary(129));
        System.out.println(to32BitBinary(result));

        System.out.println("3. Bit OR - 두개의 값의 '1' 비트를 합치기");
        result = 24 | 129;
        System.out.println("24 | 129 = " + result);
        System.out.println(to32BitBinary(24));
        System.out.println(to32BitBinary(129));
        System.out.println(to32BitBinary(result));

        System.out.println("4. Bit 배타적 OR - 두개의 값 같은 비트를 탐색(2개의 비트가 다를 때 1)");
        result = 24 ^ 136;
        System.out.println("24 ^ 136 = " + result);
        System.out.println(to32BitBinary(24));
        System.out.println(to32BitBinary(136));
        System.out.println(to32BitBinary(result));

        System.out.println("4. Bit Not - 비트의 반전");
        result = ~24;
        System.out.println("result : " + result); // 음수 표현은 '2의 보수 방식'으로 표현. ~ not 연산 +1
        System.out.println(to32BitBinary(24) + "(양수 24)");
        System.out.println(to32BitBinary(result) + "(24의 비트 반전 -25)");
        System.out.println(to32BitBinary(-24) + " 24의 2의 보수 (-24)");

        // 10진수를 2진수로 바꿀 때 : 163 = 128 + 32 + 2 + 1 => 00000000 00000000 00000000
        // 10100011
        // 2진수의 자리값은 .... 4096 2048 1024 512 256 128 64 32 16 8 4 2 1

        System.out.println("참고 : 2진수 문자열을 10진수 int로 변환 ");
        System.out.println("10100011 : " + Integer.parseInt("10100011", 2));
        // 모든 음수값은 맨 좌측 bit가 '-1' 붙임
        System.out.println("-10100011 : "
                + Integer.parseInt("-10100011", 2));

        // 모든 2진수를 양수로 변환합니다. 음수는 - 기호로 사용
        // 오류 : 매우 큰 양수값으로 처리해서 int 범위 오버플로우
        // System.out.println("-10100011 : " +
        // Integer.parseInt("11111111111111111111111110100011", 2));

    }

    private static String to32BitBinary(int x) {
        return String.format("%32s", Integer.toBinaryString(x)).replace(" ", "0");
    }

    // 양수를 음수(음수를 양수)로 변화하는 메소드 : 부호 반전 + 1
    /*
     * 4비트의 음수표현 예시(2의 보수)
     *           Not +1
     * 0001 (1) 1110 1111
     * 0010 (2) 1101 1110
     * 0011 (3) 1100 1101
     * 0100 (4) 1011 1100
     * 0101 (5) 1010 1011
     * 0110 (6) 1001 1010
     * 0111 (7) 1000 1001
     * 1000 (-8)
     * 1001 (-7)
     * 1010 (-6)
     * 1011 (-5)
     * 1100 (-4)
     * 1101 (-3)
     * 1110 (-2)
     * 1111 (-1)
     */
}
