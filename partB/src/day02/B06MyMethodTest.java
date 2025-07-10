package day02;

public class B06MyMethodTest {

    public static void main(String[] args) {
        MyClass.hello();
        MyClass.message = "HI,HELLO!";
        System.out.println(MyClass.message);
        MyClass.hello("한국어");
        MyClass.hello("영어");
        System.out.println("MyClassMessage 변수 문자열 : " + MyClass.getMessage());
        System.out.println("MyClassMessage 변수 문자열의 길이 : " + MyClass.getMessageLength());
        System.out.println("getStringInfo 변수 문자열의 길이 : " + MyClass.getStringInfo("자바가재밌누"));

    }

}

/*
 * 메소드의 형식.
 * ㄴ 정해진 기능을 처리. 재사용성을 위한 함수 형식
 * ㄴ 입력과 출력. 입력은 메소드 인자, 출력은 메소드 리턴
 * ㄴ 인자, 리턴 유무 조합으로 4가지 형식 가능
 * 
 * static 키워드 : 객체를 new 연산으로 만들지 않고 클래스이름으로 바로 사용할 수 있는 형식
 * static 는 객체 개념과 상관이 없다.
 */
class MyClass {

    // 메소드 인자가 없는 것 vs 있는 것
    static String message;

    static void hello() {
        System.out.println("--------------------");
        System.out.println("Welcome!! 자바");
        System.out.println("--------------------");

    }

    static void hello(String language) {
        System.out.println("--------------------");
        System.out.println("Welcome!! " + language); // language 변수는 메소드 입력값 -> 인자로 선언
        System.out.println("--------------------");
    }

    // 리턴 있는 메소드
    static String getMessage() {
        return message;
    }

    static int getMessageLength() {
        return message.length(); // length() : 문자열의 길이를 구하는 메소드
    }

    // getStringInfo(문자열) 실행하면 문자열의 길이 리턴하는 메소드
    static int getStringInfo(String data) { //
        return data.length();
    }
}