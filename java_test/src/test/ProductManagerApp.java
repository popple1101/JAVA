/*
1. initProductList 메소드 실행하여 주어진 4개의 Product 객체로 list 를 초기화 합니다.
2. 새로운 상품 등록은 addProduct 메소드로 합니다.
   -> 상품의 pid 는 4자리 정수 111 ~ 9999 범위
   랜덤값으로 초기화 하고 상품 제목과 가격은 콘솔 입력을 받습니다.
3. list 에 저장된 전체 상품 목록 출력과 상품명 검색을 구현합니다.


*/

package test;

import java.util.ArrayList;
import java.util.List;

public class ProductManagerApp {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        initProductList(list); // 빈칸1 ✅
        System.out.println("ㅁㅁㅁㅁ 상품 관리 프로그램입니다. ㅁㅁㅁㅁ");
        boolean status = true;
        while (status) {
            System.out.println("\n작업 메뉴를 선택하세요.");
            System.out.println("[A] 상품 추가    [R] 상품 삭제    [U] 가격 변경  \n"
                    + "[L] 전체 상품 목록    [S] 상품 조회    [E] 종료  ");
            String menu = System.console().readLine("선택 >>>> ");
            try {
                switch (menu.toUpperCase()) {
                    case "A":
                        addProduct(list);
                        break;
                    case "R":
                        int index = Integer.parseInt(System.console().readLine("\t삭제할 인덱스 입력 >>>>")); // 빈칸2(수정) ✅
                        if (confirm("삭제")) {
                            Product p = list.remove(index); // 빈칸3 ✅ <- 재확인 ✅
                            System.out.println("\t삭제 데이터 : " + p);
                        } else {
                            System.out.println("\t삭제를 취소했습니다.");
                        }
                        break;
                    case "U":
                        index = Integer.parseInt(System.console().readLine("\t수정할 인덱스 입력 >>>>"));
                        double pr = Double.parseDouble(System.console().readLine("\t판매 가격 입력 >>>> ")); // 빈칸4 ✅
                        if (confirm("가격 변경")) {
                            list.get(index).setPrice(pr); // 빈칸5 ✅
                            System.out.println("\t업데이트 결과 : " + list.get(index)); // 빈칸6 <- 재확인 ✅
                        } else {
                            System.out.println("\t가격 변경을 취소했습니다.");
                        }
                        break;
                    case "L":
                        System.out.println("\t\t상품리스트");
                        for (int i = 0; i < list.size(); i++) // 빈칸7 ✅
                            System.out.println("\t" + i + ": " + list.get(i));
                        break;
                    case "S":
                        String find = System.console().readLine("\t찾는 상품 제목 단어 입력 >>> "); // 빈칸8 ✅
                        for (int i = 0; i < list.size(); i++) {
                            Product p = list.get(i);// 빈칸9 <- 재확인 ✅
                            if (p.getTitle().contains(find)) {
                                System.out.println("\t" + i + ": " + p);
                            }
                        }
                        break;
                    case "E":
                        status = !status; // 빈칸10 ✅
                        break;

                    default:
                        System.out.println("잘못된 메뉴 선택입니다.");
                        break;
                } // switch end
            } catch (NumberFormatException e) { // 빈칸11 ✅
                System.out.println("숫자만 입력하세요.");
            }
        } // while end
    } // main end

    private static void initProductList(List<Product> list) {
        Product p1 = new Product(1212, "LG그램", 345600.0);
        Product p2 = new Product(2499, "LG스탠바이", 190100.0);
        Product p3 = new Product(1213, "삼성OLED", 554500.0);
        Product p4 = new Product(4546, "바디프랜드", 632000.0);
        Product p5 = new Product(7890, "삼성 갤럭시북", 452000.0);

        list.addAll(List.of(p1, p2, p3, p4, p5)); // 빈칸12 ✅
    }

    private static void addProduct(List<Product> list) {
        // 빈칸13 <- 재확인 ✅
        double rndNum = Math.random();
        int range = 8888;
        int id = (int) (rndNum * range) + 1111;

        String title = System.console().readLine("\t상품 제목 입력 >>> ");
        double price = Double.parseDouble(System.console().readLine("\t상품 가격 입력 >>> "));
        if (confirm("상품 등록")) {
            Product p = new Product(id, title, price);
            list.add(p); // 빈칸14 <- 재재재확인 ✅
            System.out.println("\t등록 확인 : " + p);
        } else {
            System.out.println("\t등록 취소했습니다.");
        }
    }

    private static boolean confirm(String task) {
        String yn = System.console().readLine(task + "을(를) 실행할까요?(확인:엔터, 취소:N)  ");
        return yn.length() != 0 && yn.toUpperCase().equals("N") ? false : true;
    }
}
