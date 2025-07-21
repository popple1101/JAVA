package day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// List 를 불변 객체로 만들어 보기
// of : static 메소드
public class D04MemberList {
    public static void main(String[] args) {
        List<String> names = List.of("apple", "kiwi", "mango", "banana");
        System.out.println(names);

        // names.add("melon"); // 불변 객체로 만들어져서 값을 추가,삭제 못함(사이즈 못바꿈). => 오류
        // names.set(2,"망고"); // 오류
        System.out.println(names);

        String[] temp = { "apple", "kiwi", "mango", "banana" };
        List<String> fruits = Arrays.asList(temp); // 불변객체? yes
        // fruits.add("melon");

        System.out.println("Member 타입 객체로 테스트");
        Member m1 = new Member(1, "김준우", 3.4);
        Member m2 = new Member(2, "김유나", 1.9);
        Member m3 = new Member(2, "임은상", 5.4);
        Member m4 = new Member(2, "양상민", 6.3);

        List<Member> members = List.of(m1, m2, m3, m4); // 불변 객체
        // 1) members 를 순서대로 출력하기(toString)
        System.out.println("members 출력");
        for (Member m : members) { // m = members.get(i)
            System.out.println(m);
        }
        System.out.println("members 출력 한번더");

        for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i));
        }
        
        // 2) 2번 인덱스의 값 가져와서 이름 출력하기
        System.out.println("2번 인덱스 객체의 이름 : " + members.get(2).getName());
        
        // 3) members 정렬 확인하기 : 오류 => 불변 객체이므로 sort 못합니다. (이유: Arrays.asList() , List.of())
        // members.sort(null); // sort 메소드는 members 리스트를 변경합니다. 

        // 🔥 가변 객체로 변경하기
        List<Member> members2 = new ArrayList<>(members);
        // members2.sort(null); // 오류 : members2 의 데이터들이 비교 기준이 없음.

        members2.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        // compare 와 compareTo 메소드 비교는 C12번 소스 파일 참고
        System.out.println("정렬 후 (name 비교) : ");
        for (Member m : members2) {
            System.out.println("\t" + m);
        }
    }
}

/*
 * static 메소드는 가변 객체를 만들 수 없다.
 */