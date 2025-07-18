# 자바 추상 클래스와 인터페이스


### 1. 다음 중 추상 클래스에 대한 설명으로 올바른 것은? 4

① 추상 클래스는 생성자를 가질 수 없다 <br>
② 추상 클래스는 일반 메서드를 가질 수 없다 <br>
③ 추상 클래스는 인스턴스를 직접 생성할 수 있다 <br>
④ 추상 클래스는 추상 메서드와 일반 메서드를 모두 가질 수 있다 <br>
⑤ 추상 클래스는 다중 상속이 가능하다 <br>



### 2. 인터페이스에 대한 설명으로 틀린 것은? 2(3)

① 인터페이스의 변수는 자동으로 public static final이다 <br>
② 자바 8 버전 이후에는 default 메서드와 static 메소드를 가질 수 있다 <br>
③ 인터페이스는 생성자를 가질 수 있다 <br>
④ 인터페이스는 다중 구현이 가능하다 <br>
⑤ 인터페이스의 메서드는 기본적으로 public abstract이다 <br>


### 3. 다음 코드의 실행 결과는? 2(1)

```java
interface Flyable {
    // @Override
    default void fly() {
        System.out.println("Flying high");
    }
}

class Bird implements Flyable {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

public class Test {
    public static void main(String[] args) {
        // 익명 클래스로 인터페이스 구현. 익명클래스로 객체 생성
        Flyable bird = new Flyable(){ // 디폴트 메소드때문에, 오버라이드 할 수 있음.
        };
        bird.fly();
    }
}
```

① Flying high <br>
② Bird is flying <br>
③ 컴파일 에러 <br>
④ 런타임 에러 <br> 
⑤ 아무것도 출력되지 않음 <br>


### 4. 다음 중 올바른 코드는? 3

① 
```java
abstract class A {
    abstract A() { }  // abstract X
}
```

② 
```java
interface B {
    private int x = 10; // private X -> 인터페이스의 기본 권한은 public만 가능
}
```

③ 
```java
abstract class C {
    abstract void method();
    void normalMethod() { }  
}
```

④ 
```java
interface D {
    void method() {} // {} -> X : 메소드 정의 있으면 오류
}
```

⑤ 
```java
class E extends A, B { }  // 상속은 다중상속 불가
```


### 5. 다음 코드에서 컴파일 에러가 발생하는 이유는? 4

```java
abstract class Shape {
    abstract double getArea();
}

class Circle extends Shape {
    double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
}
```

① Shape 클래스가 추상 클래스이므로 <br>
② Circle 클래스에 생성자가 있으므로 <br>
③ radius 변수가 private이 아니므로 <br>
④ 추상 메서드 getArea()를 구현하지 않았으므로 <br>
⑤ 컴파일 에러가 발생하지 않음 <br>


### 6. 다음 클래스 정의의 오류를 해결하기 위한 방법은? class 키워드 앞에, 그리고 2개의 추상메소드 선언 void 앞에 abstract 키워드 작성하기

```java
class Vehicle {
    protected String brand;
    
    public Vehicle(String brand) {
        this.brand = brand;
    }
    
    void start(int timeout); 
    
    void stop(); 
}
```

### 7. 다음 인터페이스 구현 코드의 빈칸을 채우시오. default - 반드시 재정의 하지 않아도 되는 메소드 (일반적인 접근권한 default 와는 다른 의미이다.)

```java
interface Drawable {
    int MAX_SIZE = 100; // 앞에 public static final 상수
    void draw();         
    _______ void print() {  
        System.out.println("Drawing...");
    }
}
```

### 8. 다음 다중 인터페이스 구현 코드의 빈칸을 채우시오. void read() / Writable

```java
interface Readable {
    ______________
}

interface Writable {
    void write();
}

class File implements Readable, _______ {
    public void read() {
        System.out.println("Reading file");
    }
    
    public void write() {
        System.out.println("Writing file");
    }
}
```

#### 9. Comparable 인터페이스에 대한 설명으로 올바른 것은? 3

① compareTo() 메서드는 boolean 타입을 반환한다 <br> // 정수값 반환
② 음수를 반환하면 현재 객체가 매개변수보다 크다는 의미이다 <br> // 작다
③ 0을 반환하면 두 객체가 같다는 의미이다 <br> 
④ Comparable을 구현하면 자동으로 equals() 메서드도 재정의된다 <br> // X
⑤ compareTo() 메서드는 static 메서드이다 <br> // ✅ 참고 : 래퍼크래스에 두 값 비교를 하는 static 메소드가 있습니다. -> compare


#### 10. Cloneable 인터페이스에 대한 설명으로 틀린 것은? 5(4)

```java
class Person implements Cloneable { 
    String name;
    int age;
    
    // 🔥 Object 의 clone() 은 protected 이며 자식인 Person 이 접근 권한 변경함. 더 개방적인 pyublic
    public Object clone() throws CloneNotSupportedException { // 리턴 타입 Object
        return super.clone();
    }
}

// 비교
@Override // Cloneable 인터페이스 재정의
    protected Member clone() throws CloneNotSupportedException { // 예외 처리 위임. 기본이 protected : 자식에게 제한없이 접근 가능하게
        return (Member) super.clone(); // Member로 캐스팅
    } 
```
//  ✅ 참고 : 마커인터페이스란 위에서 살펴본 바와 같이 인터페이스 내부에 상수도, 메소드도 없는 인터페이스를 말합니다.

① Cloneable은 마커 인터페이스이다 <br> 
② clone() 메서드는 Object 클래스에 정의되어 있다 <br>
③ implements Cloneable을 명시하지 않으면 CloneNotSupportedException이 발생한다 <br>
④ clone() 메서드는 '깊은 복사'를 자동으로 수행한다 <br> // 얕은 복사
⑤ clone() 메서드는 protected로 선언되어 있으며 public 으로 접근 방식을 변경할 수 있다. <br>

#### 11. Comparable 인터페이스 구현 코드의 오류를 수정하세요. //

```java
class Product implements Comparable<Product> {
    private String name;
    private double price;
    
    public int compareTo(Product other) {
        return this.price - other.price;
    }
}
```

#### 12. 위의 Product 를 예시로 객체 복사의 '깊은 복사'와 '얕은 복사' 의 차이점은?
-> deep copy 는 참조값 속성 일 때, 참조값을 복사하지 않고 객체 자체를 새로 생성하여 복사 (내용까지 통째로 새로 복사)
-> shallow copy 는 참조값 속성 일 때, 참조값(주소)를 복사합니다. -> 일반적인 clone() 의 동작 (주소만 복사)



#### 13. 다음 빈칸을 O, X 로 표기하세요. (위에서부터 차례대로) O X O
                                          (다른 패키지 전제)
| 접근 제어자   | 같은 클래스 | 같은 패키지 | 자식(하위) 클래스 | 전체 접근 |
|---------------|-------------|--------------|--------------|------------|
| `private`     |            | ❌           | ❌           | ❌         |
| (default)      | ⭕           | ⭕           |            | ❌         |
| `protected`   | ⭕           | ⭕           |            | ❌         |
| `public`      | ⭕           | ⭕           | ⭕           | ⭕         |


#### 14. 상속 시 접근 권한 변경 규칙에 대한 설명입니다. O, X 를 표시하세요.

- 하위 클래스에서 부모 클래스의 접근 제어자를 변경할 수 있다. ( O )    
- 더 좁은 범위로는 접근 권한을 줄일 수 있다. ( X ) // 
- protected 접근 권한을 public 으로 변경할 수 있다. ( O )

