package day10;

import java.util.HashMap;
import java.util.Map;

public class D10WordCountEx {
    public static void main(String[] args) {
        String lyrics = """
                Longing for you
                Waiting for you
                Hold me
                Hold me in your eyes
                너라는 걸
                너뿐인 걸 모르겠니
                I will be your love

                오 빨간 운동화 짧은 청바지
                참 어째도 해결이 안 될 것 같은 곱슬머리
                하지만 왜일까 자꾸 끌리는 내 마음이
                어쩌면 사랑 아닐까

                Longing for you
                Waiting for you
                Hold me
                Hold me in your eyes
                너라는 걸
                너뿐인 걸 모르겠니
                I will be your love
                """;

        // \s 정규식 기호는 공백, 탭, 줄바꿈. 문자열을 단어로 분리하는 기준
        String[] words = lyrics.split("\\s+");
        System.out.println("단어의 갯수 : " + words.length);

        // 앞의 getOrDefault 메소드를 사용해서 단어가 나온 횟수 Map으로 저장하기
        // 횟수의 합계(sum) = words.length (검증)

        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        int sum = 0;
        int maxCount = 0; // maxCount 4회인 단어가 여러개
        StringBuilder sb = new StringBuilder(); // maxCount 단어들을 저장

        for (String key : countMap.keySet()) {
            int val = countMap.get(key);
            System.out.println(key + " (" + val + " 회)");
            sum += val; // value(단어의 출현 횟수) 누적합계
            // 출현 횟수 최대값 찾기
            if (val > maxCount) // 현재의 val 와 최대횟수 maxCount 비교
                maxCount = val;
        }
        // maxCount 에 해당하는 단어를 sb에 추가
        for (String key : countMap.keySet()) {
            if(countMap.get(key) == maxCount) // value 가 maxCount 와 같은지 비교
                sb.append(key).append(","); // 단어 추가
        }

        System.out.println("단어의 갯수 : " + countMap.size()); // 중복된 단어 없이
        System.out.println("단어의 총 출현 횟수 : " + sum);
        System.out.println("최다 출현 단어 : " + sb.toString() + " 횟수 : " + maxCount);

        // 내 코드
        // wordCount.put(key, wordCount.getOrDefault(key, 0) + 1);

        // int sum;
        // System.out.println(wordCount.values());
        // for (int i = 0; i < words.length; i++) {
        // sum += wordCount.values();
        // }

        // for (String key : wordCount.keySet()) {
        // System.out.println(key + ":" + wordCount.get(key));
        // }
    }
}
