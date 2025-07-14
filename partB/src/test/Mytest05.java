/*
B21MathRandom.java 관련 문제
- 배열 만들기
- Math.random()으로 랜덤 인덱스 추출
- System.arraycopy()로 배열 복사 (원소 제거)
*/

package test;

import java.util.Arrays;

public class Mytest05 {

    public static void main(String[] args) {

        String[] pickedCard = new String[5]; // 뽑는 카드 개수
        String[] deck = new String[52]; // 총 카드

        String[] shapes = { "♠", "♥", "♣", "♦" };
        String[] numbers = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

        // deck 만들기
        int index = 0;
        for (int i = 0; i < shapes.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                deck[index] = shapes[i] + numbers[j];
                index++;
            }
        }

        // 카드 뽑기
        for (int i = 0; i < 5; i++) { // 5번 뽑아야하니까 5번 for문 돌린다.
            double rndNum = Math.random(); // 실수형 rndNum 변수에 0.0부터1.0 사이의 무작위 실수값을 저장.
            int range = 52 - i; // 정수형 범위 변수에 52-i(=50,49,48,47,46) 반복한 값을 저장
            int randomIndex = (int) (range * rndNum); // 정수형 무작위인덱스 값에 범위*무작위수 값을 저장
            pickedCard[i] = deck[randomIndex];
            System.out.println("뽑힌 카드 : " + Arrays.toString(pickedCard));
            System.out.println("남은 카드 수 : " + deck.length);
            System.out.println("남은 카드들 : " + Arrays.toString(deck));

        }

    }

    public static int[] removeCard(int[] deck, int cardIndex) {
        int[] newCard = new int[5];
        System.arraycopy(deck, 0, newCard, 0, cardIndex);
        System.arraycopy(deck, cardIndex + 1, newCard, cardIndex, cardIndex - 1);

        return newCard;
    }
}

// System.arraycopy(원본배열, 원본시작인덱스, 복사배열, 복사시작인덱스, 복사길이)