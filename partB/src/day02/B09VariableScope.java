package day02;

/*
 * 변수의 사용가능한 범위 (Scope)
 * : 변수가 선언된 위치에 따라 결정.
 */
public class B09VariableScope { // 클래스 시작
    static String message = "hello"; // 전역(global) scope - 클래스 범위로 선언된 변수

    public static void main(String[] args) {
        System.out.println(message);
        hello(); // B09VariableScope.hello() 로 사용하지 않은 이유 : 같은 클래스 소속.
        print("hi~자바");

        int point = 100; // 지역변수

        for (int i = 0; i < 5; i++) {
            // 변수 i는 for문 scope
            System.out.println("im for");
        }
        // System.out.println(i); // 오류. main 메소드 scope 은 i 변수 없음.
    } // main 끝

    private static void print(String data) {
        // 메소드의 인자로 선언된 변수는 해당 메소드 scope 으로 사용 (지역변수)
        System.out.println(data);
    }

    private static void hello() {
        System.out.println(message + "****");
    }

} // 클래스 끝
