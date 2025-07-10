package day02;

public class B03StringForTest {

    public static void main(String[] args) {
        
        String test = "테스트";
        // for(초기값;조건식;감소식)
        for (int i = 0; i < 5; i++) {
            test = test + " " + i; // 기존 test 문자열에 공백과 i값을 연결해서 test 변수로 참조
            System.out.println(test);
        }
        // test가 초기값 이후 5번이 변경됩니다. -> 6개의 문자열 객체가 생성
        // 객체를 사용하는 관점에서 동일하게 유지하고 싶다면 StringBuffer, StringBuilder 클래스 사용
    }
}
