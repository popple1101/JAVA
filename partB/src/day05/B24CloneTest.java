package day05;

public class B24CloneTest {
    // clone() 은 Object 클래스 최상위 부모로부터 상속

    public static void main(String[] args) throws Exception {
        Student sana = new Student("최사나", 29);
        Student sanaClone = sana.clone();
        System.out.println("sanaClone : " + sanaClone.getName() + "," + sanaClone.getAge());

        System.out.println("sana 주소 : " + sana);
        System.out.println("sanaClone 주소 : " + sanaClone);
    }
}

class Student implements Cloneable {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {

        return (Student) super.clone(); // super 는 Object 부모 클래스
        // 부모가 물려준 clone() 메소드 실행합니다.
        // 리턴 타입이 Object 입니다. -> Student 로 캐스팅
    }
}