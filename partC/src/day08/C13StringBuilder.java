package day08;

// 문자열 저장 객체(클래스 타입) : String(불변객체), StringBuilder(1.5버전), StringBuffer(1.0버전)
// String 과 StringBuilder 비교
public class C13StringBuilder {

    public static void main(String[] args) {
        // 불변 객체
        String str = new String("Hello~");
        // 불변 객체 ❌ : 데이터의 상태를 바꿀 수 있는 객체
        StringBuilder sb = new StringBuilder("Hello~");

        System.out.println("~~~~~ 초기 상태의 참조값 ~~~~~");
        System.out.println("str hashcode : " + Integer.toHexString(str.hashCode()));
        System.out.println("sb hashcode : " + Integer.toHexString(sb.hashCode()));

        // 각 str, sb 에 문자열 "자바!!" 를 연결합니다.
        str += "자바!!";
        sb.append("자바!!");
        System.out.println("~~~~~ 다른 문자열 연결 후 ~~~~~");
        System.out.println("String str : " + str);
        System.out.println("StringBuilder str : " + sb);

        System.out.println("~~~~~ 다른 문자열 연결 후 참조값 ~~~~~");
        System.out.println("str hashcode : " + Integer.toHexString(str.hashCode()));
        System.out.println("sb hashcode : " + Integer.toHexString(sb.hashCode())); // 초기 상태와 같은 값

        // 문자열의 메소드 중 일부는 CharSequence 인터페이스의 구현(재정의) 메소드
        System.out.println(str.length());
        System.out.println(str.charAt(2));
        System.out.println(str.toString());
        System.out.println(str.isEmpty()); // default 메소드로 정의

        System.out.println(sb.length());
        System.out.println(sb.charAt(2));
        System.out.println(sb.toString());
        System.out.println(sb.isEmpty()); // default 메소드로 정의
        // 결론 : 🔥 String, StringBuilder 는 CharSequence 인터페이스를 구현한 클래스이다.
    }

}
