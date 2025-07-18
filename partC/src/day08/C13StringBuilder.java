package day08;

// 문자열 저장 객체(클래스 타입) : String(불변객체), StringBuilder(1.5버전), StringBuffer(1.0버전)
// String 과 StringBuilder 비교
public class C13StringBuilder {

    public static void main(String[] args) {
        // 불변 객체
        String str = new String("Hello~");
        // 불변(가변) 객체 ❌ : 데이터의 상태를 바꿀 수 있는 객체
        StringBuilder sb = new StringBuilder("Hello~");

        System.out.println("~~~~~ 초기 상태의 참조값 ~~~~~"); // 객체가 다르니까 참조값 다름
        System.out.println("str hashcode : " + Integer.toHexString(str.hashCode()));
        System.out.println("sb hashcode : " + Integer.toHexString(sb.hashCode()));

        // 각 str, sb 에 문자열 "자바!!" 를 연결합니다.
        str += "자바!!"; // 새로은 Stromg 객체가 생성
        sb.append("자바!!");
        System.out.println("~~~~~ 다른 문자열 연결 후 ~~~~~");
        System.out.println("String str : " + str);
        System.out.println("StringBuilder str : " + sb);

        System.out.println("~~~~~ 다른 문자열 연결 후 참조값 ~~~~~");
        System.out.println("str hashcode : " + Integer.toHexString(str.hashCode())); // 새 객체가 생성됐으니까 주소값 바뀜
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

        // String 문자열 메소드는 인자 타입으로 CharSequence 것이 몇가지 있습니다.
        str = "Hello~ java, react~";
        StringBuilder temp = new StringBuilder("java");
        System.out.println(str.contains(temp)); // true
        System.out.println(str.replace(temp, "자바")); // Hello~ 자바, react~

        // 🔥 StringBuilder 는 문자열 저장 가변객체를 생성합니다.
        // 문자열을 변경하려면 append(), insert(), delete(), replace(), reverse() 실행합니다. //
        // return 타입이 StringBuilder 인 것이 문자열 변경함.
        // -> 리턴 타입이 StringBuilder 이므로 메소드를 체이닝 방식으로 작성할 수 있습니다.
        temp.append(" 자바").append(",").append(10).replace(2, 4, "*");
        // "va" 문자열을 "*" 로 치환
        System.out.println(temp);

    }

}

/*
 * -String: 문자열 붙일수록 속도 점점 느려짐 (O(n²))
 * -StringBuilder: 문자열 붙일수록 여전히 빠름 (O(n))
 * 
 * *그럼 "내부"가 뭐냐?
 * -String 객체는 내부에 char[] 배열을 갖고 있는데
 * -이 배열은 생성 이후 절대 수정할 수 없게 설계돼 있음
 * -그래서 문자열의 값이 변하면 새로운 char[] 배열을 가진 객체가 만들어져
 */
