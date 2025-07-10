package day02;

// String 클래스 타입의 객체 특징
public class B02StringTest {

    public static void main(String[] args) {
        String n1 = "모모";
        String n2 = "사나";

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n1.hashCode()); // B01 momo 의 참조값 16진수. hashcode() 메소드는 10진수
        System.out.println(n2.hashCode()); // n1는 1529088, n2는 1574252

        n1 = "momo";
        n2 = "sana";

        System.out.println(n1.hashCode() + "," + n2.hashCode()); // n1은 3357380, n2는 3522689 로 변경

        // 문자열 : immutable(불변) 객체
        //                 특정 문자열이 메모리에 저장되었어요. 그 주소가 100이라면
        //                 주소 100에는 다른 문자열로 바뀌어서 저장될 수 없어요.
        // 결론 : n1과 같은 변수가 참조하는 문자열이 바뀌면  참조값도 변경된다.(객체가 새로 생성된다.)

        String n3 = "모모";
        String n4 = "sana";

        System.out.println(n3.hashCode() + "," + n4.hashCode()); // n3은 1529088, n4는 3522689

        
    }

}
