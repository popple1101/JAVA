package day06;

public class C01ParentChildTest {
    public static void main(String[] args) {
        MyParent p = new MyParent();
        p.message = "Hello";
        p.num = 99;
        System.out.println(p.message + ", " + p.num);
        // 1. 속성 상속 확인
        MyChildA ca = new MyChildA();
        ca.message = "Hi!!!";
        ca.num = 1;
        System.out.println(ca.message + ", " + ca.num);

        // 2. 메소드 상속 확인
        String temp = p.myConcat();
        System.out.println("부모 객체 메소드 실행 : " + temp);
        System.out.println("자식 객체 메소두드 실행 : " + ca.myConcat());

        // 3. 🔥 부모 생성자 실행 확인
        System.out.println("기본 생성자 초기값 확인(부모) : " + p.name);
        System.out.println("기본 생성자 초기값 확인(자식) : " + ca.name); // unknown
    }
}

class MyParent {
    String message;
    int num;
    String name;

    MyParent() {
        this.name = "unknown";
    }

    String myConcat() {
        return message + " * " + num;
    }

}

// extends 키워드로 상속받을 부모 클래스를 지정합니다.
class MyChildA extends MyParent {

    // Quiz: 여기에 생략되어 있는 코드는? 정답 : 기본 생성자는 부모 생성자 super() 호출
}