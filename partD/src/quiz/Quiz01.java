package quiz;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Quiz01 {
    public static void main(String[] args) {
        // 1번 csv 파일을 읽어와서 List<JavaKeyWord> 로 변환하는 메소드를 만드세요.
        // try-with-resources : try 구문에서 사용한 입출력 리소스(장치)를 자동으로 해제(개발자가 직접 close()를 호출하지 않아도 됨)
        List<JavaKeyWord> list = new ArrayList<>();

        JavaKeyWord k1 = new JavaKeyWord("final", "최종의", 1);
        JavaKeyWord k2 = new JavaKeyWord("construct", "건설하다", 2);

        list.addAll(List.of(k1, k2));

        readCSV(); // 처음 파일 읽기
        writeCSV(list); // 그 파일에 데이터 쓰기
        readCSV();
    }

    // 2. 1번 csv 파일을 읽어와서 List<JavaKeyWord> 로 변환하는 메소드를 만드세요.
    public static void readCSV() {
        String line = null; // 행 초기화
        StringBuilder sb = new StringBuilder(); // sb 라는 가변객체 문자열 생성 (문자열을 효율적으로 누적하기 위해)
        System.out.println("---- 파일을 읽어봅시다 ----");

        try (
                // FileReader : 문자열 기반 텍스트 파일을 읽는 클래스
                FileReader fr = new FileReader("C:\\Class250616\\java_workspace\\partD\\java_keyword.csv",
                        Charset.forName("UTF-8")); // 해당 경로에 있는 파일을 찾는거
                Scanner sc = new Scanner(fr);) { // Scanner는 내부적으로 Readable 인터페이스를 구현한 객체를 인자로 받을 수 있음. FileReader는 Scanner 생성자의 인자로 전달 가능
                                                 // Reader의 '하위 클래스'이므로 '인자'로 전달가능
            while (sc.hasNext()) { // .hasNext() : 읽어올 다음 줄이 있는지 에 대한 T/F
                line = sc.nextLine(); // 다음 줄을 line에 저장
                sb.append(line).append("\n"); // sb 라는 문자열 객체에 하나씩 추가하고 줄바꿈 (가변객체라 append() 함수 쓰는거)
            }
            System.out.println(sb.toString()); // sb 문자열 (전체)출력
        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        }
    }

    public static void writeCSV(List<JavaKeyWord> list) {
        String filename = "C:\\Class250616\\java_workspace\\partD\\java_keyword.csv";
        try (
                FileWriter fw = new FileWriter(filename, Charset.forName("UTF-8"), true);
                PrintWriter pw = new PrintWriter(fw);) {
            int line = 0;
            // String test = list.toString(); // ❌ 내 오류 코드
            // String[] lines = test.split("\\s+"); // ❌ 내 오류 코드
            for (int i = 0; i < list.size(); i++) { // 반복문 돌려야 리스트 하나씩 출력가능
                pw.println(list.get(i)); // 0번째 : final,최종의,1 // 1번째 : construct,건설하다,2
                line++; // 반복문이 2번 돌았으니 line값 = 2
            }
            System.out.println(line + " 행이 저장되었습니다.");
        } catch (Exception e) {
            System.out.println("예외 발생 : " + e.getMessage());
        }
    }
}

@Getter
@Setter
@AllArgsConstructor
class JavaKeyWord {

    private String keyword;
    private String korean;
    private int level;

    @Override
    public String toString() {
        return keyword + "," + korean + "," + level;
    }
}

/*
 * 3. 1번 csv 파일에 아래와 같은 JavaKeyWord 객체의 값을 저장하세요.
 * 
 * JavaKeyWord k1 = new JavaKeyWord("final","최종의",1);
 * JavaKeyWord k2 = new JavaKeyWord("construct","건설하다",2);
 */