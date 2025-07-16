package day05;

public class B29StringArray {
    public static void main(String[] args) {
        String[] names = new String[3];
        names[0] = "Alice";
        // 참고 : 배열의 (객체)의 인스턴스 메소드 없습니다. 단, 상속 받은 clone() 사용 가능
        System.out.println(names.length); // 배열의 크기(속성) 3
        System.out.println(names[0].length()); // 문자열의 길이(메소드) 5

        for (String temp : names) {
            System.out.println(temp);
            if (temp != null) // NullPointerException 방지
                System.out.println(temp.toUpperCase());
        }
    }
}
