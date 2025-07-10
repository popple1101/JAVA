// 2025-07-10 오늘의 문제
/*
 * 1. 2(String)
 * 2. true
 *    false
 * 3. false (참조값이 서로 달라서)
 *    true (참조값이  서로 같아서)
 * 4.
 *  public static void main(String[] args) {
        Student hong = new Student();
        hong.name = "홍길동";
        hong.age = 20;
        System.out.println(hong);
    }

}

class Student {
    String name;
    int age;

    // toString() 메소드를 여기에 작성
    @Override
    public String toString() {
        return "이름: " + name + ", 나이: " + age;
    }

 * 
 * 5. 2
 * 6. 
 * public class MyTest03 {

    public static void main(String[] args) {
        System.out.println(MyCalculator.powerOfTwo(10));
    }

}

class MyCalculator {
    // 2의 n승 계산하기(n=0일 때 결과는 1)
    static int powerOfTwo(int count) {
        int result = 1;
        for (int i = 0; i < count; i++) {
            result *= 2; // result = result*2
        }
        return result;

    }
}
 *   
 * 7. byte 는 8bit가 1byte고, 255개 즉, - 128 ~ 127 범위를 가진다. 그래서 128은 출력되지 못하고 오버플로우가 된다.
 * 8. 변수 x는 for문에서만 쓸 수 있는 지역변수이다.
 * 9. 
 * int grade;

        String temp = System.console().readLine("학점 : ");
        grade = Integer.valueOf(temp);

        switch (grade / 10) {
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                break;
            case 6:
                System.out.println("D");
                break;
            default:
                System.out.println("F");
                break;
        }
 */

package test;

public class MyTest03 {

    public static void main(String[] args) {
        System.out.println(MyCalculator.factorial(10));
    }

}

class MyCalculator {

    static int factorial(int n) {
        int result = 1;

        for (int i = 1; i < n + 1; i++) {
            result = result * i;
            System.out.println("i = " + i + ", " + "result = " + result);
        }
        return result;

    }
}

// n=0, 1
// n=1, 1 1
// n=2, 2 1*2
// n=3, 6 1*3
// n=4, 24 1*2*3*4

/*
 * 
 * n=1 , result = 1
 * n=2 , result = 2
 * n=3 , result = 6
 */