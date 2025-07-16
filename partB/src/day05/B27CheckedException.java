package day05;

import java.io.IOException;

public class B27CheckedException {

    public static void main(String[] args) {
        Score s1 = new Score();
        // s1.setScore(-9); // score 값 오류 !! IOException 발생시켰으므로 예외처리 필수
        try {
            s1.setScore(-9);
        } catch (Exception e) {
            System.out.println("예외 발생 : " + e.getMessage() + ", " + e.getClass()); // class
                                                                                   // java.lang.IllegalArgumentException
        }
    }
}

class Score {
    private int score; // 0~100

    public int getScore() {
        return score;
    }

    // 여기서 직접 try~catch 안하면 사용하는 main 으로 위임(떠넘기기)
    public void setScore(int score) throws IOException {
        if (score >= 0 && score <= 100) {
            this.score = score;
        } else {
            // 잘못된 값 -> 개발자가 임의로 예외 발생 처리
            // throw new IllegalArgumentException("score 값 오류!!"); // Checked 예외 X
            throw new IOException("score 값 오류!!"); // Checked 예외
        }
    }

}