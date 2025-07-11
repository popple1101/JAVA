package day03;

// 우리(개발자)가 정의하는 클래스에 인스턴스 메소드 추가해보기
public class B12ScoreInstanceMethod {
    public static void main(String[] args) {
        Score junwoo = new Score();

        junwoo.name = "김준우";
        junwoo.kor = 99;
        junwoo.eng = 123;
        junwoo.math = 88;

        System.out.println(junwoo);
        System.out.println("----객체의 값 유효성 검사하기----");
        System.out.println("name : " + junwoo.isNameValid());
        System.out.println("kor : " + junwoo.isKorValid());
        System.out.println("eng : " + junwoo.isEngValid());
        System.out.println("math : " + junwoo.isMathValid());
        System.out.println("모든 점수 : " + junwoo.isScoresValid());
        System.out.println("---------------------------------");
        System.out.println("점수 수정 중......");

        // junwoo.eng = 100;
        if (junwoo.isScoresValid()) {
            // 점수 합계
            System.out.println("총점 : " + junwoo.sum());
            System.out.println("평균 : " + junwoo.avg());
            System.out.println("학점 : " + junwoo.getGrade());

        } else {
            // 이스케이플 문자 \\, \"
            System.out.println("점수값 오류 (\"모든 과목의 점수는 \\0 ~ 100\\ 로 합니다.\")");
        }
        System.out.println("학점 : " + (junwoo.isScoresValid() ? junwoo.getGrade() : 'E')); // 'E'

    }
}

class Score {

    String name;
    int kor;
    int eng;
    int math;

    // 점수의 합계 구하기
    int sum() {
        return kor + eng + math;
    }

    double avg() {
        // 나눗셈 결과를 실수로 하고 싶다면...... 2개의 정수 중 하나를 실수로 변경
        // 강제 형변환-casting. 값 앞에 (double)변수명. primitive 타입끼리 변환
        // ㄴ 정수와 실수(기본형)는 둘다 수치 - 강제 캐스팅, Double.valueOf 모두 가능
        // ㄴ 문자열(객체)과 실수는 성격이 다름. -> 강제 캐스팅 X, Double.valueOf 만 가능
        return (double) sum() / 3;
    }

    // 평균 : 90 점 이상 A, 80점 이상 B, 70점 이상 'C', 그 외에는 'F' - char 리턴
    // 정수 / 정수 = 정수(몫)
    char getGrade() {

        int avg = sum() / 3;
        char grade;

        switch (avg / 10) {
            case 10, 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6, 5, 4, 3, 2, 1, 0:
                grade = 'F';
                break;

            default:
                grade = 'E'; // 오류를 뜻하는 약속.
                break;
        }
        return grade;
    }

    // 이름 패턴 검사 - 참 또 거짓 리턴메소드 isXXXXXX
    // "^[가-힣]+$";
    boolean isNameValid() { // 인스턴스 메소드는 객체의 값을
        return name.matches("^[가-힣]{2,5}$");
    }

    boolean isScoresValid() {
        return isKorValid() && isEngValid() && isMathValid();
    }

    // kor : 0 ~ 100 isKorValid
    boolean isKorValid() {
        return kor >= 0 && kor <= 100;
    }

    // eng : 0 ~ 100 isEngValid
    boolean isEngValid() {
        return eng >= 0 && eng <= 100;
    }

    // math : 0 ~ 100 isMathValid
    boolean isMathValid() {
        return math >= 0 && math <= 100;
    }

    @Override
    public String toString() { // overrding (재정의)
        // return name + " : " + kor + ", " + eng + ", " + math;

        return String.format("%s : %d, %d, %d", name, kor, eng, math); // d: Decimal , s : String
        // "출력 포맷을 데이터형식 기호로 작성", 순서대로 값을 나열
    }

}