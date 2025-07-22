package test;

import java.util.ArrayList;
import java.util.List;

import day09.Member;
import java.util.*;

public class Test01{
    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();  // 문제1: ArrayList 생성
        // list 초기화 메소드 실행
        initMemberList(list); // list 변수 참조값 전달
        System.out.println("회원 관리 프로그램입니다.");
        boolean status = true;
        while (status) {
            System.out.println("\n작업 메뉴를 선택하세요.");
            System.out.println("[A] 회원 추가  [R] 회원 삭제  [U] 회원 포인트 변경" +
                    "\n[S] 회원 목록  [N] 이름 조회  [E] 종료");
            String menu = System.console().readLine("선택 >>> ");

            switch (menu.toUpperCase()) {  // 문제2: 대문자 변환 메소드
                case "A":
                    addMember(list);
                    break;

                case "N":
                    String find = System.console().readLine("\t조회할 이름 입력 >>> ");
                    int count = 0;
                    for (int i = 0; i < list.size(); i++) {  // 문제3: 리스트 크기 반환 메소드
                        Member m = list.get(i);  // 문제4: 인덱스로 요소 가져오는 메소드
                        if (m.getName().contains(find)) {  // 문제5: 문자열 포함 여부 확인 메소드
                            count++;
                            System.out.println("count : " + count);
                            System.out.println("\t" + i + ":  " + m);
                        }
                    }
                    if (count == 0) {
                        System.out.println("count : " + count);
                        System.out.println("\t조회 데이터가 없습니다.");
                    }
                    break;
                    
                case "R":
                    int index = Integer.parseInt(  // 문제6: 문자열을 int로 변환하는 메소드
                            System.console().readLine("\t삭제할 인덱스 입력 >>>>"));
                    Member m = list.remove(index);  // 문제7: 특정 인덱스 요소 삭제하고 반환하는 메소드
                    if (confirm("회원 삭제")) {
                        System.out.println("\t삭제 데이터 확인 : " + m);
                    } else {
                        System.out.println("\t삭제하지 않았습니다.");
                    }
                    break;
                    
                case "U":
                    index = Integer.parseInt(  // 틀린 부분 - 의도적 오류
                            System.console().readLine("\t수정할 인덱스 입력 >>>>"));
                    double point = Double.parseDouble(  // 문제8: 문자열을 double로 변환하는 메소드
                            System.console().readLine("\t포인트 입력 >>> "));
                    if (confirm("포인트 변경")) {
                        list.get(index).setPoint(point);  // 문제9: point 값을 설정하는 setter 메소드
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

    private static void initMemberList(List<Member> list) {
        // 각 회원의 포인트를 50~150 사이의 랜덤값으로 설정
        Member m1 = new Member(1, "김준우", Math.random() * 100 + 50);  // 문제10: 50~150 랜덤값
        Member m2 = new Member(2, "김유나", Math.random() * 100 + 50);
        Member m3 = new Member(3, "임은상", Math.random() * 100 + 50);
        Member m4 = new Member(4, "양상민", Math.random() * 100 + 50);

        // 불변 객체 리스트의 모든 요소를 가변 객체 list에 추가
        list.addAll(List.of(m1, m2, m3, m4));  // 문제11: 컬렉션의 모든 요소를 추가하는 메소드
    }

    private static void addMember(List<Member> list) {
        int id = Integer.parseInt(System.console().readLine("\t고객 id 입력 >>> "));
        String name = System.console().readLine("\t고객 이름 입력 >>> ");
        if (confirm("회원 등록")) {
            Member m = new Member(id, name, Math.random() * 100 + 50);
            list.add(m);  // 문제12: 리스트에 요소 추가하는 메소드
            System.out.println("\t등록회원 : " + m);
        } else {
            System.out.println("\t등록 작업을 취소하였습니다.");
        }
    }

    private static boolean confirm(String task) {
        String yn = System.console().readLine(task + " 을(를) 실행할까요?(확인:엔터, 취소:N) ");
        // 엔터를 누르면 참 리턴
        return yn.length() != 0 && yn.toUpperCase().equals("N") ? false : true;  // 문제13: 문자열 길이 반환 메소드
    }
}

/*
=== 오류 찾기 문제 ===
문제14: case "U" 부분에서 잘못된 메소드가 사용되었습니다. 
        어떤 부분이 잘못되었고, 올바른 코드는 무엇인지 쓰시오.

잘못된 부분: _________________________
올바른 코드: _________________________
*/