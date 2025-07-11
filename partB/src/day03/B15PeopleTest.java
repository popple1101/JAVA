package day03;

public class B15PeopleTest {

    // People 클래스 활용
    public static void main(String[] args) {
        People junwoo = new People();
        People sana = new People();

        String name = junwoo.getName();
        System.out.println("회원이름 : " + name); // 객체의 기본값 null

        // junwoo 객체에게 name 필드를 "김준우" 하고 싶은데......

        junwoo.setName("김준우");
        junwoo.setAge(29);
        junwoo.setAdult(true);
        sana.setName("최사나");
        sana.setAge(30);
        sana.setAdult(false);

        System.out.println("junwoo 회원 이름 : " + junwoo.getName());
        System.out.println("junwoo 회원 나이 : " + junwoo.getAge());
        System.out.println("junwoo 회원 성인 : " + junwoo.isAdult());

        System.out.println("sana 회원 이름 : " + sana.getName());
        System.out.println("sana 회원 나이 : " + sana.getAge());
        System.out.println("sana 회원 성인 : " + sana.isAdult());

        // 참고
        // int age; // 오류 : 지역변수 기본값이 없습니다.
        // System.out.println(age);

    }

}
