# 자바 배열과 예외 처리 문제

(2/8)

## 객관식 문제 (1~4번)

### 1. 다음 코드의 출력 결과는? 3
```java
int[] arr = {10, 20, 30, 40, 50};
System.out.println(arr.length);
arr[2] = 100;
System.out.println(arr[2]);
```

① 4, 30  
② 5, 30  
③ 5, 100  
④ 4, 100  

### 2. 다음 중 객체 배열에 대한 설명으로 올바른 것은? 1(2)
```java
String[] names = new String[3];
names[0] = "Alice";
```

① names 배열의 모든 요소는 자동으로 빈 문자열("")로 초기화된다  
② names[1]과 names[2]는 null 값을 가진다  
③ names.length는 실제 저장된 문자열의 개수를 반환한다  
④ 배열 크기는 동적으로 변경할 수 있다  

### 3. 다음 코드에서 발생하는 예외는? 2
```java
public class Test {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        System.out.println(numbers[5]);
    }
}
```

① NullPointerException  
② ArrayIndexOutOfBoundsException  
③ IllegalArgumentException  
④ NumberFormatException  

### 4. 다음 try-catch 구문에서 출력 결과는? 3 (2)
```java
try {
    int result = 10 / 0;
    System.out.println("계산 완료");
} catch (ArithmeticException e) {
    System.out.println("연산 오류");
} finally {
    System.out.println("마무리");
}
System.out.println("프로그램 종료");
```

① 계산 완료, 마무리, 프로그램 종료  
② 연산 오류, 마무리, 프로그램 종료  
③ 연산 오류, 프로그램 종료  
④ 마무리, 프로그램 종료  

## 빈칸 채우기 문제 (5~8번)

### 5. 다음 코드의 빈칸을 채우시오. 🔥🔥🔥
```java
Student[] students = new Student[3];
students[0] = new Student("김철수", 20);
students[1] = new Student("이영희", 22);

for (int i = 0; i < students.______; i++) {
    if (students[i] != ______) { 
        System.out.println(students[i].getName());
    }
}
```

빈칸 ①: length  
빈칸 ②: student[2] (null) //NullPoionterException 발생

### 6. 다음 2차원 배열 코드의 빈칸을 채우시오.
```java
int[][] matrix = {{1, 2, 3, 4}, {4, 5, 6 , 7}, {7, 8, 9, 10}};

for (int i = 0; i < matrix.______; i++) {
    for (int j = 0; j < matrix[i].______; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

빈칸 ①: length  
빈칸 ②: length+1 (length)

### 7. 다음 예외 처리 코드의 빈칸을 채우시오.
```java
public void divide(int a, int b) ______ ArithmeticException {
    if (b == 0) {
        ______ new ArithmeticException("0으로 나눌 수 없습니다");
    }
    System.out.println(a / b);
}
```

빈칸 ①: throws  
빈칸 ②: int (throw) 

### 8. 다음 배열 복사 코드의 빈칸을 채우시오.
```java
int[] original = {1, 2, 3, 4, 5};
int[] copy = new int[original.______]; // new int[...]는 정수 길이 값

for (int i = 0; i < original.______; i++) {
    copy[i] = original[i];
}

// 또는 System.arraycopy 사용
System.______(original, 0, copy, 0, original.______);
```

빈칸 ①: clone() (length)
빈칸 ②: length
빈칸 ③: arraycopy 
빈칸 ④: length 

// "기본 자료형은 0 / false, 참조형은 null!"