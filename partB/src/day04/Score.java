package day04;

public class Score {
    private String name;
    private int kor;
    private int eng;
    private int math;
    // private으로 하는 이유는?

    // 커스텀 생성자만 만들기 : 4개의 변수를 초기화
    public Score(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    // 예시 1: 한번 초기화 된 값이 수정되지 않아야 한다면 setter 정의 안할 수 있습니다.
    // 예시 2: 커스텀 생성자 이름 name 초기화, setter 가 3개의 점수를 저장하도록 할 수도 있습니다.
    public Score(String name) {
        this.name = name;
    }

    // setter 가 3개의 점수를 모두 저장
    public void setScores(int kor, int eng, int math) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    // getter 만들기
    public String getName() {
        return this.name;
    }

    public int getKor() {
        return this.kor;
    }

    public int getEng() {
        return this.eng;
    }

    public int getMath() {
        return this.math;
    }

    // toString 재정의하기
    @Override
    public String toString() {
        return String.format("%s : %d %d %d", name, kor, eng, math);
    }
}
