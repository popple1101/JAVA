package test;

import java.util.ArrayList;
import java.util.List;

import day09.Member;

public class Test02 {
    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();

        // 프로그램 시작 시
        System.out.println("회원 관리 프로그램입니다.\n");
        boolean status = true;

        // 메인 메뉴 출력
        do {
            System.out.println("작업 메뉴를 선택하세요.");
            String menu = System.console()
                    .readLine("[A] 회원 추가  [R] 회원 삭제  [U] 회원 포인트 변경\n[S] 회원 목록  [N] 이름 조회  [E] 종료\n선택 >>> ");

            switch (menu.toUpperCase()) {
                case "A":
                    addMember(list);

                    break;
                case "R":
                    rmMember(list);
                    break;
                case "U":
                    updatePoint(list);
                    break;
                case "S":
                    showList(list);
                    break;
                case "N":
                    searchName(list);
                    break;
                case "E":
                    status = !status;
                    System.out.println("프로그램이 종료되었습니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다.");
                    break;
            }
        } while (status);
    }

    // 확인 프롬프트
    public static boolean confirm(String state) {
        String yn = System.console().readLine(state + "을(를) 실행할까요?(확인:엔터, 취소:N)");
        return yn.length() != 0 && yn.toUpperCase().equals("N") ? false : true; // yn.length
    }

    // 회원 추가(Add Member)
    public static void addMember(List<Member> list) {
        int inputId = Integer.parseInt(System.console().readLine("회원 id 입력 >>> "));
        String inputName = System.console().readLine("회원 이름 입력 >>> ");
        double rndNum = Math.random();
        int range = 50;
        if (confirm("회원 추가")) {

            if (rndNum < 0.5) {
                list.add(new Member(inputId, inputName, (int)(rndNum*range+1)));
                System.out.println("성공");
            } else {
                System.out.println("실패");

            }
            
        } else {
            System.out.println("등록 작업을 취소하였습니다.");
        }
    }

    // 회원 삭제 (Remove Member)
    public static void rmMember(List<Member> list) {
        int rmIdx = Integer.parseInt(System.console().readLine("삭제할 인덱스 입력 >>>> "));
        if (confirm("회원 삭제")) {
            list.remove(list.get(rmIdx));
        } else {
            System.out.println("삭제하지 않았습니다.");
        }
    }

    // 회원 포인트 변경 (Update Point)
    public static void updatePoint(List<Member> list) {
        int udIdx = Integer.parseInt(System.console().readLine("수정할 인덱스 입력 >>>> "));
        double newPoint = Double.parseDouble(System.console().readLine("새로운 포인트 입력 >>>> "));

        if (confirm("포인트 변경")) {
            list.get(udIdx).setPoint(newPoint);
        } else {
            System.out.println("포인트 변경을 취소했습니다.");
        }
    }

    // 회원 목록 (Show Members)
    public static void showList(List<Member> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ":" + list.get(i));
        }
        // 왜 이건 for-Each 문으로 구현할 수 없는가.
    }

    // 이름 조회 (Search by Name)
    public static void searchName(List<Member> list) {
        String searchName = System.console().readLine("조회할 이름 입력 >>> ");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().contains(searchName)) {
                System.out.println(list.get(i));
            }
        }
    }
}
