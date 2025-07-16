package day06;

public class C05ShapeParent {
    public static void main(String[] args) {
        TShape rec = new TRectangle(10, 10, 220, 190, "yellow");
        TShape cir = new TCircle(10, 20, 0, 0, "blue");
        TShape tri = new TTriangle(50, 100, 400, 500, "orange");

        System.out.println(rec.getId());
        System.out.println(cir.getId());
        System.out.println(tri.getId());

        rec.draw();
        cir.draw();
        tri.draw();
    }
}

class TShape {
    private int posX;
    private int posY;
    private int width;
    private int height;
    private String color;
    private int id;

    private static int count = 0;

    TShape() {
        count++;
        this.id = count;
        this.color = "black";
    }

    TShape(int posX, int posY, int width, int height, String color) {
        this(); // 기본생성자 호출
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("shape id[%d] pos(%d, %d) size(%d, %d) %s",
                id, posX, posY, width, height, color);
    }

    // setter
    public void move(int offsetX, int offsetY) {
        this.posX += offsetX;
        this.posY += offsetY;
    }

    // setter
    public void resize(int offsetW, int offsetH) {
        this.width += offsetW;
        this.height += offsetH;
    }

    public void color(String color) {
        this.color = color;
    }

    public double calcArea() { // 넓이 계산 후 리턴
        return width * height;
    }

    public void draw() {
        System.out.println("도형 그리기 : " + this.toString() + "  area: " + calcArea());
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public int[] getPosition() {
        return new int[] { posX, posY };
    }

    public int[] getSize() {
        return new int[] { width, height };
    }

}

class TRectangle extends TShape {

    // 부모클래스의 커스텀 생성자를 사용하기 위해서 자식 클래스도 정의합니다.
    TRectangle() {
        super(); // 생략 가능
    }

    TRectangle(int posX, int posY, int width, int height, String color) {
        super(posX, posY, width, height, color);
    }

    @Override
    public void draw() {
        super.draw(); // 부모가 정의 draw() 실행하기
        System.out.println("■■■■■■■■■■■");
        System.out.println("■         ■");
        System.out.println("■         ■");
        System.out.println("■         ■");
        System.out.println("■         ■");
        System.out.println("■■■■■■■■■■■");
    }

}

class TTriangle extends TShape {

    TTriangle() {
        super(); // 생략 가능
    }

    TTriangle(int posX, int posY, int width, int height, String color) {
        super(posX, posY, width, height, color);
    }

    @Override
    public double calcArea() {
        return super.calcArea() / 2; // 삼각형의 넓이
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("    #    ");
        System.out.println("   ###   ");
        System.out.println("  #####  ");
        System.out.println(" ####### ");
        System.out.println("#########");
    }

}

class TCircle extends TShape {
    // 원에 필요한 반지름을 새로운 속성으로 추가
    private int radius;
    private static final double PI = 3.14; // 상수로 선언.

    TCircle() {
        super(); // 생략 가능
    }

    TCircle(int posX, int posY, int width, int height, String color) {
        super(posX, posY, width, height, color);
    }

    @Override
    public double calcArea() {
        return radius * radius * PI;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("   @@@@  ");
        System.out.println(" @      @ ");
        System.out.println("@        @");
        System.out.println("@        @");
        System.out.println(" @      @ ");
        System.out.println("   @@@@    ");
    }
}
