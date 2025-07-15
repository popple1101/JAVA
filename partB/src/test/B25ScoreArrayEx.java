package test;

import java.util.Arrays;

public class B25ScoreArrayEx {
    public static void main(String[] args) {
        StudentScore sana = new StudentScore();
        StudentScore momo = new StudentScore("김모모", 78, 100, 88);

        sana.updataScores(99, 90, 89);
        momo.setKor(92);
        System.out.println();
        System.out.println("sana 성적 : " + Arrays.toString(sana.getScores()) + " avg : " + sana.getAverage() + " , "
                + sana.getGrade()); // sana 성적 : [99, 90, 89] avg : 92.66, A
        System.out.println("momo 성적 : " + Arrays.toString(momo.getScores()) + " avg : " + momo.getAverage() + " , "
                + momo.getGrade()); // momo 성적 : [99, 100, 88] avg : 93.33, A

        // scores 배열 테스트
        int[] temp = momo.getScores(); // 참조값 전달
        temp[2] = 11; // MATH 인덱스
        System.out.println(momo.getMath()); // 객체의 배열 요소값이 수정됩니다.
        // 🔥 -> 배열을 리턴할 때(getXXX 메소드) 선택하기 : 참조값 vs 새로운 배열
        System.out.println(Arrays.toString(momo.getScores()));

        System.out.println("사나의 최대 점수 : " + sana.getMaxScore());
        System.out.println("사나의 최소 점수 : " + sana.getMinScore());
        System.out.println("모모의 최대 점수 : " + momo.getMaxScore());
        System.out.println("모모의 최소 점수 : " + momo.getMinScore());
    }
}

class StudentScore {

    private String name;
    private int[] scores; // 국어, 영어 수학 점수를 저장하는 배열

    // 상수 정의 (배열 인덱스) : final 키워드는 변수의 값을 변경할 수 없도록 설정합니다.
    private static final int KOR = 0;
    private static final int ENG = 1;
    private static final int MATH = 2;

    // 기본 생성자
    public StudentScore() { // ctor -> 기본생성자 단축키
        this.scores = new int[3]; // 3개 과목
    }

    // 매개변수 생성자(커스텀 생성자)
    public StudentScore(String name, int kor, int eng, int math) {
        this(); // 자신의 기본생성자 호출. this가 생성된 객체 자신. 첫줄에 작성
        this.name = name;
        // this.scores = new int[3]; // 빈칸
        this.scores[KOR] = kor;
        this.scores[ENG] = eng;
        this.scores[MATH] = math;
    }

    // 이름 getter/setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 국어 점수 getter/setter
    public int getKor() {
        return scores[KOR];
    }

    public void setKor(int kor) {
        this.scores[KOR] = kor;
    }

    // 영어 점수 getter/setter
    public int getEng() {
        return scores[ENG];
    }

    public void setEng(int eng) {
        this.scores[ENG] = eng;
    }

    // 수학 점수 getter/setter
    public int getMath() {
        return scores[MATH];
    }

    public void setMath(int math) {
        this.scores[MATH] = math;
    }

    // 점수 배열 전체 getter
    public int[] getScores() {
        return scores.clone(); // 외부에서 배열요소를 변경할 수 없도록 새로운 배열 리턴
        // return this.scores; // 참조값 리턴
    }

    // 총점 계산
    public int getTotal() {
        int total = 0;
        for (int score : scores) { // score = scores[i]
            total += score;
        }
        return total;
    }

    // 평균 계산 - 소수점 이하 둘째자리
    public double getAverage() {
        return Math.floor((double) getTotal() / scores.length * 100) / 100;
        // return Math.floor(getTotal() * 100 / scores.length) / 100; <- 이거 고민해봐야함.
    }

    // 등급 계산 (평균 기준)
    public String getGrade() {
        int avg = (int) getAverage();
        return switch (avg / 10) { // 몫 : 정수/정수만 몫 구할 수 있음
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> "F";
        };
    }

    // 모든 점수 업데이트
    public void updataScores(int kor, int eng, int math) {
        // 빈칸
        setKor(kor);
        setEng(eng);
        setMath(math);
    }

    // 최고 점수 찾기
    public int getMaxScore() {
        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }

    // 최소 점수 찾기
    public int getMinScore() {
        int min = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        return min;
    }

}