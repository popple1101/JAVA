package day07.interf;

// 기능에 대한 정의
public interface Beable {

    // public abstract String bealble(); // 인터페이스에서 public abstract 키워드 생략
    String beable();
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