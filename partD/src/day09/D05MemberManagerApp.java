package day09;

import java.util.ArrayList;
import java.util.List;

public class D05MemberManagerApp {
    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();
        // list 초기화 메소드 실행
        initMemberList(list); // list 변수 참조값 전달
        System.out.println("회원 관리 프로그램입니다.");
        boolean status = true;
        while (status) {
            System.out.println("\n작업 메뉴를 선택하세요.");
            System.out.println("[A] 회원 추가  [R] 회원 삭제  [U] 회원 포인트 변경" +
                    "\n[S] 회원 목록  [N] 이름 조회  [E] 종료");
            String menu = System.console().readLine("선택 >>> ");
            // 인덱스, 회원 id 입력 : 잘못된 문자 입력하면 Integer.parseInt() 메소드 예외 생깁니다.
            // 단순 처리 : switch 문을 try 구문으로 묶어서 예외 발생하면 다시 반복 처음 메뉴 입력 실행하기
            switch (menu.toUpperCase()) {
                case "A":
                    addMember(list); // id, 이름 입력. point는 기본값 100
                    break;

                case "N":
                    String find = System.console().readLine("\t조회할 이름 입력 >>> ");
                    int count = 0;
                    for (int i = 0; i < list.size(); i++) { 
                        Member m = list.get(i);
                        if (m.getName().contains(find)) {
                            count++;
                            System.out.println("count : " + count);
                            // 순서대로 인덱스 i 의 데이터 가져와서 getter 이름값이 contains(find)
                            System.out.println("\t" + i + ":  " + m);
                        }
                    }
                    if (count == 0)
                        System.out.println("count : " + count);
                        System.out.println("\t조회 데이터가 없습니다.");
                    break;
                case "R":
                    int index = Integer.parseInt(System.console().readLine("\t삭제할 인덱스 입력 >>>>"));
                    Member m = list.remove(index); // 리턴값은 삭제한 index 위치의 데이터
                    if (confirm("회원 삭제")) {
                        System.out.println("\t삭제 데이터 확인 : " + m);
                    } else {
                        System.out.println("\t삭제하지 않았습니다.");
                    }
                    break;
                case "U":
                    index = Integer.parseInt(
                            System.console().readLine("\t수정할 인덱스 입력 >>>>"));
                    double point = Double.parseDouble(System.console().readLine("\t포인트 입력 >>> "));
                    if (confirm("포인트 변경")) {
                        list.get(index).setPoint(point);
                        // ✅ index 의 객체를 가져와서 (Member 타입) setter 로 point 값 변경
                        System.out.println("\t업데이트 결과 : " + list.get(index));
                    } else {
                        System.out.println("\t포인트 변경을 취소했습니다.");
                    }
                    break;
                case "S":
                    System.out.println("\t\t회원 리스트");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("\t" + i + ":  " + list.get(i));
                    }
                    break;
                case "E":
                    status = false;
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다.");
                    break;
            }
        }
    }

    // 프로그램 실행할 때 마다 4개의 객체를 리스트에 저정하고 시작 : list 초기화
    // 메소드 인자는 main 메소드의 ArrayList 객체의 주소를 저장. (객체의 주소를 공유)
    private static void initMemberList(List<Member> list) {
        Member m1 = new Member(1, "김준우", 133.4);
        Member m2 = new Member(2, "김유나", 111.9);
        Member m3 = new Member(3, "임은상", 85.4);
        Member m4 = new Member(4, "양상민", 96.3);

        // 불변 객체 리스트가 메소드의 인자로 모든 요소를 가변 객체 list 에 추가
        list.addAll(List.of(m1, m2, m3, m4)); // Member가 부모인 자식 클래스는 다 된다.
    }

    private static void addMember(List<Member> list) {
        int id = Integer.parseInt(System.console().readLine("\t고객 id 입력 >>> "));
        String name = System.console().readLine("\t고객 이름 입력 >>> ");
        if (confirm("회원 등록")) {
            Member m = new Member(id, name, 100);
            list.add(m);
            System.out.println("\t등록회원 : " + m);
        } else {
            System.out.println("\t등록 작업을 취소하였습니다.");
        }
    }

    // 추가,삭제, 변경 작업 반영할 때 확인 받는 메시지 출력 메소드
    private static boolean confirm(String task) {
        String yn = System.console().readLine(task + " 을(를) 실행할까요?(확인:엔터, 취소:N) ");
        // 엔터를 누르면 참 리턴
        return yn.length() != 0 && yn.toUpperCase().equals("N") ? false : true;
    }

}

/*
 * Math.random() : 0이상 1.0 미만
목표공식
1 ~ 50 정수	    (int)(Math.random() * 50) + 1
10 ~ 99 정수	(int)(Math.random() * 90) + 10
0 ~ 9 정수	    (int)(Math.random() * 10)
(int)Math.ceil(Math.random() * range); 

1 ~ N	(int)(Math.random() * N) + 1
A ~ B	(int)(Math.random() * (B - A + 1)) + A
0 ~ N-1	(int)(Math.random() * N)

반올림해서 소수점 버리기 : int num = (int)Math.round(Math.random() * 50 + 1);

if (m.getName().contains("김")) {
    int bonus = (int)(Math.random() * 50) + 10;
    m.setPoint(m.getPoint() + bonus);
}
 */