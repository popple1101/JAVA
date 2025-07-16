# 자바 상속과 다형성 문제
(12/15)
## 📝 객관식 (5개)

### 1. 다음 중 상속의 특징으로 올바르지 않은 것은? 2
① 자식 클래스는 부모 클래스의 모든 멤버를 상속받는다 <br>
② 자바에서는 다중 상속을 지원한다 <br>
③ private 멤버는 상속되지만 접근할 수 없다 <br>
④ 커스텀 생성자는 상속되지 않는다 <br> 

### 2. 다음 코드의 실행 결과는? 2
```java
class Parent {
    void method() { System.out.print("Parent "); }
}
class Child extends Parent {
    void method() { System.out.print("Child "); }
}
public class Test {
    public static void main(String[] args) {
        Parent p = new Child();
        p.method();
    }
}
```
① Parent <br>
② Child <br>
③ Parent Child <br>
④ 컴파일 오류 <br>

### 3. 다음 중 메서드 오버라이딩의 조건으로 올바르지 않은 것은? 4
① 메서드명이 같아야 한다 <br>
② 매개변수의 개수와 타입이 같아야 한다 <br>
③ 반환형이 같아야 한다 <br>
④ 접근 제한자는 부모보다 더 제한적이어야 한다 <br>

### 4. 다음 중 다형성의 장점이 아닌 것은? 3
① 코드의 재사용성 증가 <br>
② 유지보수의 편의성 <br>
③ 실행 속도의 향상 <br>
④ 확장성과 유연성 제공 <br>

### 5. super 키워드의 사용법으로 올바르지 않은 것은? 4
① super.method() - 부모 클래스의 메서드 호출 <br>
② super() - 부모 클래스의 생성자 호출 <br>
③ super.field - 부모 클래스의 필드 접근<br>
④ super.super.method() - 조부모 클래스의 메서드 호출

---

## 🔤 빈칸 채우기 (5개)

### 1. 자바에서 클래스 간의 상속을 나타내는 키워드는 **______**이다. extends

### 2. 다음 코드에서 빈칸을 채우시오. @Overriding
```java
class Animal {
    void sound() { System.out.println("Some sound"); }
}
class Dog extends Animal {
    ______ 
    void sound() { System.out.println("Woof"); }
}
```

### 3. 부모 클래스의 생성자를 호출하는 키워드는 **______** 이며, 이는 자식 클래스 생성자의 **______** 줄에 와야 한다. super / 첫 번째

### 4. 다음 코드에서 빈칸을 채우시오. double
```java
class Shape {
    protected int x, y;
    public Shape(int x, int y) {
        this.x = x; this.y = y;
    }
}
class Circle extends Shape {
    private int radius;
    public Circle(int x, int y, int radius) {
        ______(x, y); 
        this.radius = radius;
    }
}
```

### 5. 런타임에 객체의 실제 타입에 따라 메서드가 호출되는 것을 **______** 바인딩이라고 한다. 동적

---

## ✏️ 단답식 (5개)

### 1. 자바에서 모든 클래스가 기본적으로 상속받는 최상위 클래스의 이름은 무엇인가? Object

### 2. 부모 클래스의 메서드를 자식 클래스에서 재정의하는 것을 무엇이라고 하는가? Overriding

### 3. 하나의 참조변수로 여러 타입의 객체를 참조할 수 있는 특성을 무엇이라고 하는가? 다형성

### 4. 다음 코드에서 출력되는 결과를 쓰시오. 20 10
```java
class A {
    int x = 10;
}
class B extends A {
    int x = 20;
    void print() {
        System.out.println(x + " " + super.x);
    }
}
public class Test {
    public static void main(String[] args) {
        B b = new B();
        b.print();
    }
}
```

### 5. 부모 클래스에서 속성과 메소드의 접근 제한으로 자식 클래스에서만 사용할 수 있도록 하는 것은? 
       커스텀 생성자 (protected)

---
