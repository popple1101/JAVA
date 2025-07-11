## 자바 Quiz 2


### 1. static 키워드에 대한 설명으로 올바른 것은? c
a) static 변수는 객체마다 각각 다른 값을 가진다 X (객체)
b) static 메소드는 인스턴스 변수에 직접 접근할 수 있다 X (객체)
c) static 변수는 클래스가 메모리에 로드될 때 생성된다
d) static 메소드는 this 키워드를 사용할 수 있다 X (객체)

### 2. 다음 코드의 출력 결과는? c
```java
public class Test {
    static int count = 0;
    
    public Test() {
        count++;
    }
    
    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = new Test();
        System.out.println(Test.count);
    }
}
```
a) 0
b) 1
c) 2
d) 컴파일 오류

### 3. 기본 생성자에 대한 설명으로 틀린 것은? b(c)
a) 매개변수가 없는 생성자이다
b) 명시적으로 생성자를 만들지 않으면 자동으로 제공된다
c) 리턴 값은 기본값이 null 이다.
d) 객체가 생성될 때만 실행된다.

### 4. 다음 클래스에서 컴파일 오류가 발생하는 것은? b
```java
public class Test {
    static int staticVar = 10;
    int instanceVar = 20;
    
    // 다음 중 오류가 발생하는 것은?
}
```
a) `public static void method1() { System.out.println("static"); }` <br/> X
b) `public void method2() { System.out.println(staticVar); }` <br/>
c) `public static void method3() { System.out.println(instanceVar); }` <br/>
d) `public static void method4() { method1(); }`  <br/> X


### 5. 다음 코드에서 빈칸을 채우시오.
```java
public class Counter {
    private int count = 0;
    private static int totalCount = 0;  // 모든 카운터가 공유하는 변수
    
    public void increment() {
        count++;
        totalCount++;  // 공유 변수 증가
    }
    
    public static int getTotalCount() {  // 객체 생성 없이 호출 가능한 메소드
        return totalCount;
    }
}
```

### 6. 다음 코드에서 빈칸을 채우시오.
```java
public class Calculator {
    private int result;
    
    public Calculator() {  // 기본 생성자
        result = 0;
    }
    
    public void add(int num) {  // 반환형이 없는 인스턴스 메소드
        result += num;
    }
    
    public int getResult() {  // 결과를 반환하는 인스턴스 메소드
        return result;
    }
}
```

### 7. 다음 코드에서 빈칸을 채우시오.
```java
public class MathUtils {
    public static final double PI = 3.14159;  // 클래스 상수
    
    public static double calculateArea(double radius) {  // 인스턴스 생성 없이 호출
        return PI * radius * radius;  // 위에서 선언한 상수 사용
    }
}
```

### 8. 다음 코드에서 빈칸을 채우시오.
```java
public class Car {
    private String brand;
    private int speed;
    private static int maxSpeed = 200;  // 모든 자동차가 공유하는 최고 속도
    
    // 기본 생성자
    public Car() {
        brand = "Unknown";
        speed = 0;
    }
    
    public static void printMaxSpeed() {  // 객체 생성 없이 호출 가능
        System.out.println("Max speed: " + maxSpeed);
    }
}
```

### 9. 다음 코드에서 기본 생성자의 역할을 설명하고, 출력 결과를 예측하시오.
-> new 연산 때 실행되고, 리턴이 없다.  출력 결과 : Name: Anonymous, Grade: 1
```java
public class Student {
    private String name;
    private int grade;
    
    // 기본 생성자
    public Student() {
        name = "Anonymous";
        grade = 1;
    }
    
    public void printInfo() {
        System.out.println("Name: " + name + ", Grade: " + grade);
    }
    
    public static void main(String[] args) {
        Student s = new Student();
        s.printInfo();
    }
}
```

### 10. 다음 코드의 실행 결과를 예측하고, 그 이유를 설명하시오.
-> Instance: 1, Static: 1
   Instance: 1, Static: 2 
   이유 : instanceCount 변수는 인스턴스 변수이고, staticCount 변수는 static 변수이므로 static 변수는 메모리를 공유하기 때문에 누적이 된다.
```java
public class Counter {
    private int instanceCount = 0;
    private static int staticCount = 0;
    
    public Counter() {
        instanceCount++;
        staticCount++;
    }
    
    public void printCounts() {
        System.out.println("Instance: " + instanceCount + ", Static: " + staticCount);
    }
    
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        c1.printCounts();
        c2.printCounts();
    }
}
```
/*
💡 Q1. "static 메서드가 클래스 단위로 존재한다"는 말의 의미?
✅ 설명:
static 메서드는 객체를 만들지 않아도 사용할 수 있는 메서드예요.

즉, 클래스 이름으로 직접 호출할 수 있음.

그래서 ***"클래스 단위로 존재한다"는 건 → 객체(instance)에 소속되지 않고, 클래스 자체에 소속된다***는 의미예요.

🔍 예시:
java
복사
편집
public class MathUtil {
    public static int square(int x) {
        return x * x;
    }
}

// 이렇게 호출 가능:
int result = MathUtil.square(5);  // 객체 안 만들어도 호출됨
반대로 인스턴스 메서드는?
java
복사
편집
MathUtil util = new MathUtil();
int result = util.instanceMethod();  // 인스턴스 만들어야 호출 가능
💡 Q2. 인스턴스 메서드는 static 변수에 왜 자유롭게 접근 가능해?
✅ 설명:
static 변수는 클래스에 하나만 존재해요.

객체가 몇 개든 공통된 공간에 있는 변수예요.

인스턴스 메서드는 호출될 때 이미 객체가 만들어져 있으니,
→ 클래스 소속(static) 변수에 접근할 수 있는 조건을 이미 갖추고 있음.

🔍 그림으로 생각:
java
복사
편집
class MyClass {
    static int count = 0;
    void increment() {
        count++;  // 인스턴스 메서드에서 static 변수 접근
    }
}
→ 객체가 이 메서드를 실행하더라도, count는 클래스에 "붙어" 있기 때문에 그냥 쓸 수 있는 거예요.

💡 Q3. 내가 쓴 표현:
"static 메소드는 static이라 변수를 같은 접근자인 static 변수만 받을 수 있음."
→ 이 표현 70% 정도는 맞지만, 좀 더 정확하게 고치면:

❌ 문제점:
"같은 접근자인..." 이라는 표현은 헷갈릴 수 있음.

static vs non-static은 **접근자(access modifier)**가 아니라 **속성 또는 소속(scope)**이에요.

✅ 더 정확한 표현:
"static 메서드는 인스턴스 없이 호출되기 때문에, 인스턴스 변수에는 직접 접근할 수 없고, 클래스(static) 변수만 사용할 수 있다."

💡 Q4. 왜 static 메서드는 인스턴스 생성 전에 호출 가능한가?
✅ 설명:
클래스가 메모리에 로딩되는 순간, static 메서드와 static 변수는 이미 메모리에 올라가 있음.

그래서 객체가 아직 없어도 바로 사용할 수 있음.

🔍 예시:
java
복사
편집
class Hello {
    static void sayHi() {
        System.out.println("Hi!");
    }
    
    public static void main(String[] args) {
        Hello.sayHi();  // 객체 안 만들었지만 호출 가능
    }
}
→ 여기서 sayHi()는 객체를 만들기 전에 바로 호출했죠?
그 이유는 static 메서드는 클래스가 로드될 때 함께 올라가기 때문이에요.

📌 정리 요약:
개념	설명
static 메서드	클래스 단위, 객체 없이 호출 가능
인스턴스 메서드	객체를 통해서만 호출 가능
static 변수	클래스 전체에서 하나, 객체가 공유
인스턴스 변수	각 객체마다 별도 존재
static 메서드는 왜 인스턴스 변수 접근 불가?	객체가 없을 수도 있어서 안전하지 않음
인스턴스 메서드는 왜 static 변수 접근 가능?	클래스에 있는 것이니까 당연히 접근 가능

----
1. 프로그램 시작

JVM이 실행되고 main() 메서드를 찾는다.

2.클래스 로딩

Car 같은 클래스가 처음 사용될 때 JVM이 .class 파일을 읽어 메서드 영역(Method Area) 에 클래스를 로딩한다.

3. static 멤버 할당

클래스 로딩 시점에

static 변수 (예: maxSpeed) 와

static 메서드 (예: printMaxSpeed()) 가 메서드 영역에 올라간다.
→ 이 시점부터 Car.maxSpeed 나 Car.printMaxSpeed() 처럼 객체 없이 바로 접근 가능.

4. main() 실행

JVM이 main() 메서드를 호출하고, 코드가 실행되기 시작한다.

5. 객체 생성 (new Car())

new 연산자가 실행되면

힙(Heap) 영역에 Car 객체 인스턴스가 만들어진다.

이 객체는 인스턴스 변수들 (brand, speed 등) 을 가진다.

6. 참조변수 생성 및 연결

스택(Stack) 영역에 myCar 같은 참조변수가 생성되고,

이 변수는 힙에 생성된 Car 객체를 가리킨다.

7. 객체를 통한 인스턴스 멤버 접근

myCar.brand = "Kia"; 처럼 객체를 통해 인스턴스 변수에 접근 가능.

*/