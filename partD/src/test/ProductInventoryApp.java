package test;

import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ProductInventoryApp {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        readProduct(list);

    }
    
    public void readProduct(List<Product> list) {
        String line = null;
        StringBuilder sb = new StringBuilder();
        String fileName = "products.csv";

        try (
        FileReader fr = new FileReader("products.csv");
        Scanner sc = new Scanner(fr);

        ) {
            while (sc.hasNext()) {
                line = sc.nextLine();
                sb.append(line).append("\n");
        }
        System.out.println(sb);
        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        }

    }

    
}

@Getter
@Setter
@AllArgsConstructor
class Product {

    private String name;
    private int cnt;
    private int price;

    @Override
    public String toString() {
        return name + "," + cnt + "," + price;
    }
}

/*
 * 3. 1번 csv 파일에 아래와 같은 JavaKeyWord 객체의 값을 저장하세요.
 * 
 * JavaKeyWord k1 = new JavaKeyWord("final","최종의",1);
 * JavaKeyWord k2 = new JavaKeyWord("construct","건설하다",2);
 */