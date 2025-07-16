package day06;

public class MyC05ShapeParent {

    public static void main(String[] args) {
        Shape rtg = new Shape();
        // rtg.setPosX(10);
        // rtg.setPosY(10);
        // rtg.setWidth(20);
        // rtg.setHeight(20);
        // rtg.setColor("red");
        rtg.getId();
        rtg.move(1, 2);
        rtg.resize(3, 4);
        rtg.color("red");
        rtg.calcArea();

        Shape trg = new Shape();
        // trg.setPosX(15);
        // trg.setPosY(15);
        // trg.setWidth(30);
        // trg.setHeight(30);
        // trg.setColor("blue");
        trg.getId();
        trg.move(1, 2);
        trg.resize(3, 4);
        trg.color("blue");
        trg.calcArea();

        Shape cir = new Shape();
        // cir.setPosX(20);
        // cir.setPosY(20);
        // cir.setWidth(40);
        // cir.setHeight(40);
        // cir.setColor("white");
        cir.getId();
        cir.move(1, 2);
        cir.resize(3, 4);
        // cir.color();
        cir.calcArea();

        rtg.draw();
        trg.draw();
        cir.draw();

    }
}

// 사각형
class Renctangle extends Shape {

}

// 삼각형
class Triangle extends Shape {

}

// 원
class Circle extends Shape {

}

// 도형(부모 클래스)
class Shape {
    private int posX, posY, width, height;
    private String color;
    private static int id;

    static int count = 0;

    ///////////////// getter/setter /////////////////////////
    public int getId() {
        return id;

    }

    public static void setId(int id) {
        Shape.id = id;

    }

    public String getColor() {
        return color;

    }

    public void setColor(String color) {
        this.color = color;

    }

    public int getHeight() {
        return height;

    }

    public void setHeight(int height) {
        this.height = height;

    }

    public int getWidth() {
        return width;

    }

    public void setWidth(int width) {
        this.width = width;

    }

    public int getPosY() {
        return posY;

    }

    public void setPosY(int posY) {
        this.posY = posY;

    }

    public int getPosX() {
        return posX;

    }

    public void setPosX(int posX) {
        this.posX = posX;

    }
    ///////////////////////////////////////

    // 기본 생성자
    Shape() {
        setId(count++);
        this.color = "black";
    }

    // 커스텀 생성자
    Shape(int posX, int posY, int width, int height) {
        super();
    }

    // 기능1 : move
    public void move(int offsetX, int offsetY) {
        setPosX(offsetX);
        setPosY(offsetY);
    }

    // 기능2 : resize
    public void resize(int offsetW, int offsetH) {
        setWidth(offsetW);
        setHeight(offsetH);
    }

    // 기능3 : color
    public void color(String color) {
        setColor(color);
    }

    // 기능4 : calcArea
    public int calcArea() {
        int area = posX * posY;
        return area;
    }

    //
    public void draw() {
        System.out.println(String.format("posX : %d, posY : %d, width : %d, height : %d, color : %s, id : %d",
                posX, posY, width, height, color, id));
    }

}
