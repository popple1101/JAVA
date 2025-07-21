package day08;

import java.util.Arrays;

public class C12ProductProblem {

    public static void main(String[] args) {
        Product[] products = new Product[4];

        products[0] = new Product("LG 스탠바이", 450000);
        products[1] = new Product("USB 1TB", 42456.34);
        products[2] = new Product("갤럭시 플립", 12345.78);
        products[3] = new Product("아이폰", 42456.12);

        System.out.println(products[0].compareTo(products[1])); // 407543
        System.out.println("~~~~~ products 배열 정렬 ~~~~~");

        Arrays.sort(products); // compareTo 재정의가 정확해야 정렬이 됩니다. 정렬 함수 (compareTo 자동 호출함)

        for (Product p : products) {
            System.out.println(p);
        }
        System.out.println("~~~~~ 실수 Double 과 double 비교 메소드 ~~~~~");

        Double a = 123.45; // 래퍼 클래스 타입
        Double b = 234.56;
        System.out.println("Double 타입 실수 비교 : " + a.compareTo(b)); // -1
        System.out.println("Double 타입 실수 비교 : " + b.compareTo(a)); // 1

        double c = 123.45;
        double d = 234.56;
        System.out.println("double 타입 실수 비교 : " + Double.compare(c, d)); // -1
        System.out.println("double 타입 실수 비교 : " + Double.compare(d, c)); // 1

        // 얕은 복사 확인을 위한 객체 생성과 전달
        Company c1 = new Company("LG전자", "서울시 서초구");
        products[0].setCompany(c1);

        Product pclone = null;

        try {
            pclone = (Product) products[0].clone(); // 복제 실행

        } catch (CloneNotSupportedException e) {
            System.out.println("clone 예외!!!");
        }
        System.out.println("~~~~~ 얕은 복사 테스트 ~~~~~~");
        System.out.println("복제 후의 아래의 두 객체는 데이터 내용이 같아야 합니다.");
        System.out.println("products[0] : " + products[0]);
        System.out.println("pclone : " + pclone);
        System.out.println("\t Product 타입 객체 참조값 확인");
        System.out.println("그러나 복제 후의 아래의 두 객체는 주소는 다릅니다. (새로운 객체로 복제)");
        System.out.println(products[0].hashCode() + "," + Integer.toHexString(products[0].hashCode()));
        System.out.println(pclone.hashCode() + "," + Integer.toHexString(pclone.hashCode()));
        // products[0] 의 company 주소와 복제한 pclone 의 company 주소가 같은 얕은 복사
        System.out.println("~~~~~ 복제된 객체의 멤버 변수 company 객체의 참조값 확인 ~~~~~");
        System.out.println("멤버 변수 Company 객체 복사는 참조값 복사. 참조값 동일");
        System.out.println("products[0].getCompany() : " + products[0].getCompany());
        System.out.println("pclone.getCompany() : " + pclone.getCompany());
        // 🔥 clone() 의 기본 동작이 '얕은 복사'이므로 멤버 값 중 객체는 참조값을 전달합니다.
        // 깊은 복사는 각각 company 객체가 다른 주소 즉 새로운 객체로 복사되는 것 입니다.
    }
}

class Company {
    public static Company c1;
    private String name;
    private String address;

    Company(String name, String address) {
        this.name = name;
        this.address = address;
    }
}

class Product implements Comparable<Product>, Cloneable {
    private String name; // String : 불변객체
    private double price; // 3안은 double -> Double

    // 얕은 복사를 확인하기 위한 객체 정의
    private Company company; // 클래스 안에 속성이 클래스 타입

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Product other) {
        // Product 객체의 비교는 '가격'으로 한다.
        return (int) (this.price - other.price);
        // 1안) 42456.34 - 42456.12 과 42456.12 - 42456.34 를 강제로 int 변환하면 0
        //      => 2개가 같은 값 처리됨. 소수점 이하 자리 비교와 정확한 정렬 못함.
        // return Double.compare(this.price, other.price); // 2안) // 실수 안전 비교 함수
        // return this.price.compareTo(other.price); // 객체 정렬 기준
        // 3안) 단, private Double price; 로 변경해야함
    }

    @Override
    public String toString() {
        return String.format("%s (%f)", name, price);
    }
}
