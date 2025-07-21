# 자바 함수형 인터페이스 

## 객관식 문제 (5문제)

### 1. 다음 중 자바 8에서 제공하는 기본 함수형 인터페이스가 아닌 것은? 4
1) Function<T, R>
2) Predicate<T>
3) Consumer<T>
4) BiSupplier<T>
5) Supplier<T>

### 2. 다음 코드의 실행 결과는? 2
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.stream()   // List 를 Stream 타입으로 변경하기
     .filter(name -> name.length() > 3);
     // 람다식 결과 '참이 리턴되는 값으로 새로운 스트림 생성' 인자는 Predicate 구현 객체
     .forEach(s -> System.out.println(s)); // forEach 메소드 인자는 Consumer 구현 객체
// 수업시간에 안해본 stream 메소드 입니다. 테스트 해보세요.

// 람다식 name -> name.length() > 3 의미해석? 인자 name, 리턴 name.length() > 3 결과
```
1) Alice, Bob, Charlie
2) Alice, Charlie
3) Bob
4) Charlie
5) 컴파일 에러

### 3. Function<T, R> 인터페이스의 추상 메서드는? 2
1) test(T t)
2) apply(T t)
3) accept(T t)
4) get()
5) compare(T o1, T o2) 참고 : 래퍼클래스에 있는 메소드.

### 4. 다음 코드에서 빈 칸에 들어갈 수 있는 것은? 3
```java
______<Integer> mod11 = () -> 11 % 2; // 인자는 없고, 리턴은 나머지연산 실행 결과
Integer result = mod11.get();
```
1) Function
2) Consumer
3) Supplier
4) Predicate
5) Comparator

### 5. 함수형 인터페이스에 대한 설명으로 옳지 않은 것은? 2
1) 람다 표현식으로 더 간결하게 표현할 수 있다
2) 추상메소드가 하나이고 default 메소드는 가질 수 없다. (있다)
3) 익명 클래스 형식으로 객체를 생성할 수 있다.
4) 추상 메소드가 2개 일때 @FunctionalInterface 를 표시하면 오류가 발생한다.
5) 메소드의 인자로 함수형 인터페이스 구현 객체를 사용할 수 있다.

참고 : @FunctionalInterface 어노테이션은 함수형 인터페이스를 알리는 주석.

---

## 빈칸 문제 (3문제)

### 1. 다음 코드의 빈칸을 채우세요.
```java
Supplier<String> supplier = () -> "Hello World"; 
Consumer<String> consumer = s -> System.out.println(s);

String message = supplier._______();
consumer._______(message);
```
**답: get, accept**

### 2. 다음 코드의 빈칸을 채우세요.
```java
Function<String, __________> stringLength = (x) -> x.length();
int length = stringLength.__________("Java");
```
**답: Integer, apply**

### 3. 다음 함수형 인터페이스를 람다식으로 바꾸고 내용을 설명하세요.

```java
Predicate<String> f5 = new Predicate<String>() {
      @Override
      public boolean test(String t) {
        return t.length() < 10;
      }
};
System.out.println(f5.test("abc**1234"));
```

**답: Predicate<String> f5 = (t)-> t.length()<10**
      람다식 조건이 10보다 작으면 true. 인자의 길이가 9라서 true를 리턴함.

