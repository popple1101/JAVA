package Study;

// .java 소스파일, public 클래스, 파일명

public class B01ObjectTest {

    public static void main(String[] args) {

        // 객체 생성, 참조

        Score momo = new Score();
        
        momo.name = "모모";
        momo.kor = 99;
        momo.eng = 89;
        momo.math = 88;

        System.out.println("momo 의 정보 : " + momo);
        // 참조값, 패키지명.클래스명@주소, 16진수

        System.out.println("---- : " + momo.name + "," + momo.kor + "," + momo.eng + "," + momo.math);

        // 참조값 복사
        Score momo2 = momo; 

        System.out.println("momo2 의 정보 : " + momo);
        System.out.println("---- : " + momo2.name + "," + momo2.kor + "," + momo2.eng + "," + momo2.math);

        momo.name = "momo"; momo.kor= 100; momo.eng = 100; momo.math = 100; 
        System.out.println("momo의 정보 : " + momo.name); // 참조값 변경X
    }
    // Score 객체 수 : 1개

}

// 클래스 Score

class Score {
    // 필드, 속성, 프로퍼티
    String name; 
    int kor;
    int eng;
    int math;

    // 메소드 : 다음 진도
}