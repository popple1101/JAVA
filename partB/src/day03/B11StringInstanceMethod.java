package day03;

// String 클래스의 인스턴스 메소드
//                      ㄴ 생성된 객체를 대상으로 실행하며 객체의 값에따라 결과가 다름

public class B11StringInstanceMethod {
    public static void main(String[] args) {
        String message = "hello";
        // String temp = new String("hello"); // 세 개 중 참조값이 다른 하나가 temp
        // String temp2 = "hello";

        // message 문자열 객체의 인스턴스 메소드(자바스크립트, 파이썬 등 거의 유사)
        message = "hello~  java!!"; // 문자열 을 구성하는 문자의 위치 0 부터 시작
        System.out.println(message); // message.toString() 실행. //toString()클래스를 재정의했기 때문에 참조값이 안나옴

        // 각 메소드가 어떤 형식의 데이터를 리턴하는가?
        // 🔥 인스턴스 메소드 실행으로 원래 문자열 객체의 상태가 변하지 않는다.
        // ㄴ 리턴 타입이 String 경우 , 새로운 문자열이 만들어집니다.

        System.out.println(message.length()); // 14 // int
        System.out.println(message.charAt(4)); // o // Char
        System.out.println(message.toUpperCase()); // HELLO~ JAVA!! // String
        System.out.println(message.indexOf("java")); // 8 // int
        System.out.println(message.startsWith("hello")); // true // boolean
        System.out.println(message.endsWith("java")); // false // boolean
        System.out.println(message.replace("", "*")); // *h*e*l*l*o*~* * *j*a*v*a*!*!* // String
        System.out.println(message.substring(1, 4)); // ell // String (4-1=3개)
        System.out.println(message.substring(3)); // lo~ java!! // String
        System.out.println(message.indexOf(" ")); // 6 // int
        System.out.println(message.indexOf("*")); // -1 // int. 없는 문자열이면 -1
        System.out.println(message.lastIndexOf(" ")); // 7 // int
        System.out.println(message.concat("??")); // hello~ java!!?? // String
        System.out.println(message.equals("hello~  java!!")); // true // boolean
        // 주의 : 자바는 문자열 같은지 비교할 때 == 안됩니다. (참조값 비교)
        // 꼭 equals 쓰세요.

        // 위의 메소드를 다른 값으로 실행 시켜 보세요.

        //
        String test = "  ";
        System.out.println(test.isBlank()); // true // test.length() > 0, 공백만 있으면 true
        System.out.println(test.isEmpty()); // false // 문자열의 길이가 0일 때 true

        // 정규식 패턴을 검사 : 예시) 핸드폰 번호 010-숫자4자리-숫자4자리
        String regex = "^010-\\d{4}-\\d{4}$";
        String hpnum = "010-4183-7642"; // 011-345-6666

        System.out.println(hpnum.matches(regex)); // true
        System.out.println("011-345-6666".matches(regex)); // false
        System.out.println("01034566666".matches(regex)); // false
        // - 기호를 선택적.
        System.out.println("01034566666".matches("^010-?\\d{4}-?\\d{4}$")); // true ? - 0 또는 1회

        String name = "김준우냠냠"; // 이름은 한글만 허용
        // 순서는 없고, 가능한 문자셋을 [] 기호 안에 나열, 범위는 a-z 또는 A-Z
        // + 기호는 반드시 한글자 이상.
        regex = "^[가-힣]{2,5}+$"; // "^[가-힣]+$";
        System.out.println(name.matches(regex)); // true
        System.out.println("JunWoo".matches(regex)); // false
        // 영문자 검사
        System.out.println("junWoo".matches("^[A-Z][a-zA-Z\\s]+$")); // true

    }
}

// 문자열은 불변객체
