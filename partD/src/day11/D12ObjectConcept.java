package day11;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class D12ObjectConcept {

    public static void main(String[] args) {
        
        String test = "java";
        String test2 = "java";
        String test3 = new String("java"); // 새로운 객체

        System.out.println("동일성 확인 ------ ");
        System.out.println("test==test3 : " + test==test3); // false
        System.out.println("test==test2 : " + test==test2); // true : 문자열은 불변 객체

        System.out.println("동등성 확인 ------ ");

        System.out.println(test.equals(test3)); // true
        System.out.println(test.equals(test2)); // true
    }
}

// @EqualsAndHashCode // '동등성'을 구현 재정의 코드 생성
@ToString
@Getter
@Setter // final 아닌 것만 setter 만들어집니다.
// @RequiredArgsConstructor    // final 키워드 속성을 초기화 하는 인자를 갖습니다.
@AllArgsConstructor      // 모든 속성을 초기화하는 인자를 갖습니다.
class People {
    // final : 값을 변경 못함. 생성자에서 초기화 필수!!
    private final int  id;
    private final String name;
    private double etc;

    // @RequiredArgsConstructor 에 해당하는 코드
    public People(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // @EqualsAndHashCode 의 실제코드
    @Override
    public int hashCode() { // 속성값이 같으면 강제로 hashcode 같은 동일하게 계산합니다.
        final int prime = 31; // 소수
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        long temp;
        temp = Double.doubleToLongBits(etc); // 실수를 소수점 고려하지 않고 2진수 형태로 long 타입생성
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) { // 속성값이 모두 같으면 참을 리턴. obj 는 this의 비교대상
        if (this == obj) // 참조값이 같으면
            return true;
        if (obj == null) // 널이면 
            return false;
        if (getClass() != obj.getClass()) // 클래스 타입이 다르면
            return false;
        People other = (People) obj; // 다운 캐스팅
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (Double.doubleToLongBits(etc) != Double.doubleToLongBits(other.etc))
            return false;
        return true;
    }
    

}