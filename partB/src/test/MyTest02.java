// 업글한 계산기

package test;

public class MyTest02 {
    public static void main(String[] args) {

        int data1;
        int data2;

        String op;
        boolean status = true;

        String temp1 = System.console().readLine("첫 번째 값 : ");
        String temp2 = System.console().readLine("두 번째 값 : ");

        data1 = Integer.valueOf(temp1);
        data2 = Integer.valueOf(temp2);

        // while (status) {
        op = System.console().readLine("연산 기호 선택(+,-,*,/) : ");

        switch (op) {

            case "+":
                System.out.println("add : " + Cal.add(data1, data2));
                break;
            case "-":
                System.out.println("sub : " + Cal.sub(data1, data2));
                break;
            case "*":
                System.out.println("mul : " + Cal.mul(data1, data2));
                break;
            case "/":
                System.out.println("div : " + Cal.div(data1, data2));
                break;
            case "N", "n":
                status = false;
                break;
            default:
                System.out.println("연산 기호만 입력해주세요.");
                break;
        }
        // }
    }
}

class Cal {

    static int add(int num1, int num2) {
        return num1 + num2;
    }

    static int sub(int num1, int num2) {
        return num1 + num2;
    }

    static int mul(int num1, int num2) {
        return num1 + num2;
    }

    static int div(int num1, int num2) {
        if (num2 == 0) {
            System.out.println("0말구");
            return 0;
        }
        return num1 + num2;
    }
}