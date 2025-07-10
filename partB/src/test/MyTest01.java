package test;

import java.util.Scanner;

public class MyTest01 {
    public static void main(String[] args) {

        // String a = new String("hello");
        // String b = new String("hello");

        // System.out.println(a);
        // System.out.println(b);

        // System.out.println(a == b); // false (서로 다른 객체(주소값)라서)
        // System.out.println(a.equals(b)); // true (내용이 같아서)

        Scanner sc = new Scanner(System.in);

        System.out.print("하루 담배 몇 대 피시나요?\n");
        int sgr = sc.nextInt();

        System.out.print("금연 하실 생각 없으신가요? ('넹','놉'으로 대답)\n");
        String answer = sc.next();
        while (!(answer.equals("넹") || answer.equals("놉"))) {
            System.out.println("넹이나 놉으로 적어주세요!");
            System.out.print("금연 하실 생각 없으신가요? ('넹','놉'으로 대답)\n");
        }
        if (answer.equals("넹\n")) {
            if (sgr > 20) {
                System.out.println("당신은 하루에 " + sgr + "대 피십니다.");
                System.out.println("'흡연 중독 말기'입니다.\n");
            } else if (sgr >= 11 && sgr <= 20) {
                System.out.println("당신은 하루에 " + sgr + "대 피십니다.");
                System.out.println("'흡연 중독 중기'입니다.\n");

            } else {
                System.out.println("당신은 하루에 " + sgr + "대 피십니다.");
                System.out.println("이 참에 금연하세요.\n");
            }
        } else {
            System.out.println("당신은 하루에 " + sgr + "대 피십니다.");
            System.out.println("안녕히계세요.\n");
        }
        sc.close();
    }
}
