package day10;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class D07MapTest {
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    // 1 . ✅ 데이터 저장(추가, 변경)
    map.put("t1", "사나");
    map.put("t2", "모모");
    map.put("t3", "나연");
    map.put("t4", "다현");
    map.put("t1", "나나"); // key "t1" 의 value 가 사나 -> 나나로 변경

    // 2. map 의 크기
    System.out.println("map 크기 : " + map.size());

    // 3. toString 출력
    System.out.println("map : " + map);

    // 4. LinkedHashMap
    // 생성자로 전달된 map 의 값을 linkMap 에 저장하기
    Map<String, String> linkMap = new LinkedHashMap<>();
    linkMap.put("t1", "사나");
    linkMap.put("t2", "모모");
    linkMap.put("t3", "나연");
    linkMap.put("t4", "다현");
    System.out.println("linkedHashMap : " + linkMap);

    // 5. TreeMap
    Map<String, String> treeMap = new TreeMap<>(map);
    System.out.println("treeMap : " + treeMap);

    // 6. ✅ key 로 value 가져오기
    String temp = treeMap.get("t1");
    System.out.println("t1 의 value :  " + temp);
    temp = treeMap.get("t2");
    System.out.println("t2 의 value :  " + temp);

    // ✅ keySet
    System.out.println("keyset : " + treeMap.keySet());
    // 7. map 의 반복문
    System.out.println("~~~ keyset 반복 ~~~");
    for (String key : treeMap.keySet()) {
      // map 의 key 값만 모아서 set 을 만들고(keyset) 여기서 key를 가져와 반복
      System.out.println(key + ":" + treeMap.get(key));
    }

    System.out.println("Map.Entry 내부클래스는 k,v 를 한쌍으로 저장.");
    System.out.println("\nentry set : " + treeMap.entrySet().toString());
    System.out.println("~~~ entry set 반복문(stream) ~~~");
    System.out.println("key와 value 의 getter 는 entry 타입에서 각각 가져올 수 있음.");
    // for 문 작성해보세요.
    treeMap.entrySet().stream().forEach(entry -> System.out.println(entry + "   " + entry.getKey() + ", " + entry.getValue()));
    
    System.out.println("value : " + treeMap.values());

    
    
    }
}
/*
 * hash(해시함수)
 * 입력값 --> 해시함수 --> 출력값
 * 
 * "abc"
 * 3.14        hash   --> 고유한 식별값(고정길이)을 만듭니다.   --> 객체의 참조값(hashcode)
 * 999
 * Member객체(속성)
 * Set 또는 Map 에 저장된 요소(객체) -> 각각의 요소를 저장하면 접근을 위한 참조값이 필요합니다. 참조값은 해시함수를 사용하여 해시테이블에 저장합니다.
 * Map 은 key값을 입력으로 하여 해시값을 생성합니다. -> value 객체의 참조값
 * ✅ Map 을 예시로하면 'key', 'key의 객체가 저장된 참조값(해시)'를 표 형식으로 저장
 * 
 * 해시 함수 사용 예시 : 비밀번호 저장 등에 사용.
 * 
 * ✅ 해시 함수 특징 :
 * 1) 해시값을 다시 평문(입력값)으로 변환할 수 없음.
 * 2) 입력값이 다르면 해시값도 다른 값이 나와야 함.(알고리즘의 중요성)
 */
