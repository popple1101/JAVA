package day09;

import java.util.ArrayList;
import java.util.List;

public class D05MyMemberManagerApp {
    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();
        System.out.println("회원 관리 프로그램입니다.");
        boolean status = true;
        while (status) {
            System.out.println("작업 메뉴를 선택하세요.");
            System.out.println("[A] 회원 추가  [R] 회원 삭제  [U] 회원 포인트 변경  [S] 회원 목록  [E] 종료");
            String menu = System.console().readLine("선택 >>> ");

            switch (menu.toUpperCase()) {
                case "A": // 회원 추가
                    addMember(list); // id, 이름입력. point는 기본값 100
                    break;
                case "R": // 회원 삭제
                    removeMember(list);
                    break;
                case "U": // 포인트 변경
                    updatePoint(list);
                    break;
                case "S": // 회원 목록
                    memberList(list);
                    break;
                case "E": // 종료
                    status = false;
                    break;
            }
        }
    }

    // 회원 추가
    private static void addMember(List<Member> list) {
        int id = Integer.parseInt(System.console().readLine("회원 id 입력 >>>> "));
        String name = System.console().readLine("회원 이름 입력 >>>> ");
        Member m = new Member(id, name, 100);
        list.add(m);
    }

    // 회원 삭제
    private static void removeMember(List<Member> list) {
        // int index = Integer.parseInt(System.console().readLine("삭제할 인덱스 입력 >>>> "));
        // list.remove(index);
        String rmName = System.console().readLine("삭제할 이름 입력 >>>> ");
        System.out.println(rmName);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(rmName)) { // 문자열 비교할 때는 .equals() 사용
                list.remove(i);
            }
        }
    }

    // 회원 포인트 변경
    private static void updatePoint(List<Member> list) {
        int index = Integer.parseInt(System.console().readLine("수정할 인덱스 입력 >>>> "));
        System.out.println(index);
        double point = Double.parseDouble(System.console().readLine("변경할 포인트 입력 >>>> "));
        list.get(index).setPoint(point);
        // list.set(index, new Member(list.get(index).getId(), list.get(index).getName(), point)); // 비효율 코드
    }

    // 회원 목록
    private static void memberList(List<Member> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out
                    .println(list.get(i) + "\t" + String.format("[%s 회원님은 인덱스가 %d 번 입니다.]", list.get(i).getName(), i));
        }
    }
}
