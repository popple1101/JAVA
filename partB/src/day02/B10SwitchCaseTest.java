package day02;

public class B10SwitchCaseTest {
    public static void main(String[] args) {

        String op; // + , - , * , / 값만 사용합니다.

        boolean status = true;

        while (status) {
            op = System.console().readLine("연산 선택하기 (+, -, *, /) | 종료는 N 입력 >>> ");

            switch (op) {
                case "+":
                    System.out.println("더하기 선택 하셨습니다.");
                    break;
                case "-":
                    System.out.println("빼기 선택 하셨습니다.");
                    break;
                case "*":
                    System.out.println("곱하기 선택 하셨습니다.");
                    break;
                case "/":
                    System.out.println("나누기 선택 하셨습니다.");
                    break;
                case "N", "n":
                    status = false; // 종료 조건
                    break;
                default:
                    System.out.println("질못된 선택 입니다. +, -, *, / 값만 사용합니다.");
                    break;
            }
        }
    }
}
