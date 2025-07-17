package day07.interf;

// 기능에 대한 정의
public interface Beable {

    // public abstract String bealble(); // 인터페이스에서 public abstract 키워드 생략
    String beable();

    default void println() {
        System.out.println("🔥 인터페이스 default 메소드는 반드시 재정의하지 않아도 됩니다.");
        System.out.println("초반에 추상메소드만 있는 인터페이스를 사용하는 클래스A가 있어요.");
        System.out.println("그 인터페이스A에 새로운 기능이 필요하게 되었어요.");
        System.out.println("새로운 기능을 추상메소드로 하면 어떤 일이 벌어질까요????");
        System.out.println("클래스A가 오류가 생겨요. 이전 제품에 문제가 생깁니다.");
        System.out.println("이전 구현 클래스A에는 영향이 없도록 하기 위헤 새로운 기능은 default 메소드 사용");
    }
}

interface Cookable {
    int MAX_TIME = 20; // public static final 키워드가 생략되어있음.

    void cook(String material); // 요리하다.
}

interface Runnable extends Beable {
    String run(int speed); // 달리다
}

interface Thinkable {
    void think(String what);

    int calculate(int a, int b);

}