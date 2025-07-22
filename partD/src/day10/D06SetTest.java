package day10;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

// Set : 집합. 1) 동일한 값의 데이터는 중복없이 저장
//             2) Hashset, LinkedHashSet, TreeSet 구현 클래스
//             3) 인덱스가 없습니다.(순서가 없습니다.)
//             4) 활용예시 - 인터넷서비스의 접속자 -ip, 아이디 수집 중......
//                          중복값 제거 또는 중복값 확인에 활용 됩니다.
public class D06SetTest {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        // 1. 데이터 추가
        set.add("junwoo");
        set.add("yuna");
        set.add("sangmin");
        set.add("yuna");

        // 2. set 의 크기
        System.out.println("set 크기 : " + set.size()); // 3

        // 3. toString 출력
        set.add("dahyeon");
        System.out.println("set : " + set); // 순서 없음 : 출력 순서는 랜덤

        // 오류 : 인덱스로 접근하는 get 메소드 없습니다.
        // for (int i = 0; i < set.size(); i++)
        //     set.get(i);

        // 4.
        System.out.println("반복문 출력은 인덱스 없는 형식만 가능");
        for (String s : set) {
            System.out.println(s);
        }

        // HashSet 은 해시테이블에서 데이터를 저장/관리
        // LinkedHashSet 은 '다음 입력값의 주소' 포인터를 저장. ✅ 데이터 입력 순서 유지

        Set<String> linkSet = new LinkedHashSet<>();
        // 5. LinkedHashSet 데이터 추가
        System.out.println("LinkedHashSet 데이터");
        linkSet.add("junwoo");
        linkSet.add("yuna");
        linkSet.add("sangmin");
        linkSet.add("junwoo");
        linkSet.add("jaypark");

        System.out.println(linkSet);

        // 6. 데이터 제거 : 값으로 제거
        boolean result = linkSet.remove("junwoo");
        System.out.println(" LinkSet.remove(\"junwoo\") : " + result);
        result = linkSet.remove("trump"); // remove 는 리턴 타입이 boolean
        System.out.println(" LinkSet.remove(\"trump\") : " + result);
        System.out.println("확인 출력 : " + linkSet);

        // 7. TreeSet : 이진 트리 탐색이 가능한 자료구조(정렬)
        Set<String> treeSet = new TreeSet<>(set); 
        System.out.println("TreeSet ------");
        System.out.println(treeSet);
    }
}
