package day09;

import java.util.ArrayList;
import java.util.List;

// ArrayList : List 인터페이스를 구현한 클래스
public class D03ArrayList {
    public static void main(String[] args) {
        // ArrayList 만들기
        List<String> list = new ArrayList<>(); // 왼쪽은 인터페이스 이름. 오른쪽은 구현한 클래스 이름

        // 데이터 저장하기
        list.add("apple"); // 인덱스 0
        list.add("samsung");
        list.add("xiaomi");
        list.add("lg");
        list.add("hansung"); // 인덱스 4
        System.out.println(list);

        // 리스트의 크기(가변적)
        int size = list.size();
        System.out.println("리스트의 크기 : " + size);

        // 리스트 항목 삭제 : 리스트 크기 변경 // 객체를 추가,수정할 필요 없고 객체 참조할 필요도 없기 때문에  새 객체를 만들어줄 필요가 없음
        String result = list.remove(1);
        System.out.println("remove 리턴 : " + result);
        System.out.println("삭제 후 list : " + list);
        System.out.println("삭제 후 list 크기 : " + list.size());

        // 리스트 인덱스를 [ ] 기호로 지정하지 않고 get(인덱스) 메소드
        System.out.println("리스트 1개씩 가져오기");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\t" + list.get(i));
        }

        // 리스트의 특정 위치 값 변경 : set(인덱스,값)
        list.set(list.size() - 1, "asus");
        System.out.println("마지막 요소 값 변경");
        for (String s : list) { // list.get(i) 역할
            System.out.println("\t" + s);
        }

        // 특정 요소 찾기
        list.add("xiaomi"); // 같은 문자열 하나 추가
        list.add("tesla"); // 같은 문자열 하나 추가
        System.out.println(list);
        System.out.println("xiaomi의 위치 찾기");
        System.out.println("\tlist.indexOf : " + list.indexOf("xiaomi")); // 1
        System.out.println("\tlist.lastIndexOf : " + list.lastIndexOf("xiaomi")); // 4
        // 없는 요소 찾으면 -1 리턴

        System.out.println("특정 데이터의 저장 여부 : contatins");
        System.out.println("\txiaomi 있음 ? " + list.contains("xiaomi")); // true
        System.out.println("\tfacebook 있음 ? " + list.contains("facebook")); // false

        // 정렬
        list.sort(null);
        System.out.println("정렬 후 : " + list);
    }
}

/*
 * 자바 Collection
 * - 객체를 다루는(읽기,쓰기,탐색,....) 자료구조
 * - List, Set, Map 기본 자료구조
 * List, Set, Map 등은 인터페이스
 * 따라서, 인터페이스를 구현한 클래스가 실제로 사용
 * 제너릭 타입 사용합니다.
 * 
 * - List 는 배열과 유사
 * Set 은 수학 집합의 개념
 * Map 은 key 를 이용해서 데이터 접근
 */