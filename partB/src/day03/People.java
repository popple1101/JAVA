package day03;

// 자바에서 데이터를 저장하는 목적 VO(Value Object) 클래스의 기본 형식입니다.
// 클래스 접근 권한은 일반적으로 public
public class People {
    // 객체의 특징값을 저장하는 변수는 private
    // 전역(scope) 변수는 기본값이 있습니다.
    private String name;
    private int age;
    private boolean isAdult; // setAdult, isAdult

    // 값의 접근 : 메소드 구현(public 권한)
    // 값을 가져오기 getter(getXXXX), 값을 저장 setter(setXXXX)

    // getter : 리턴 타입 주의
    // name 가져오기 - this 키워드는 객체의 필드를 가르키는 단어.
    public String getName() {
        return this.name;
    }

    // setter : 인자 타입 주의
    public void setName(String name) { // name 변수에 원하는 값이 입력
        this.name = name;
        // 🔥 this는 객체가 만들어졌을 때 자기 자신을 가리킵니다.
        // this.name 은 객체의 name 필드 = 인자로 전달된 name

    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdult() {
        return this.isAdult;
    }

    public void setAdult(boolean isAdult) {
        this.isAdult = isAdult;
    }
}

// getter 리턴타입(출력타입)
// setter 인자타입(입력타입)