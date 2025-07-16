package day06;

public class C02ParentChildTest {
    public static void main(String[] args) {
        YourParent yp = new YourParent();
        yp.setMessage("Welcome!!");
        System.out.println("부모의 메시지 : " + yp.getMessage());

        YourChild yc = new YourChild();
        yc.setMessage("Welcome!!");
        System.out.println("자식의 메시지 : " + yc.getMessage());
        yc.setName("모모");
        System.out.println("자식 이름 : " + yc.getName());

    }
}

class YourChild extends YourParent {

    // 부모가 정의한 setMessage() 재정의 가능함. -> 기능 수행을 변경.
    // ✅ 부모가 public -> 자식도 반드시 public
    public void setMessage(String message) {
        // this.message = message; // private 접근. 오류
        super.setMessage("👩🏻‍🦰" + message); // super 키워드 : 부모 객체
        // super 를 안쓰면 자식의 setMessage() 를 실행하면서 무한으로 self 호출(재귀)
    }

    @Override
    public void setName(String name) {
        this.name = "👨🏻‍🦲" + name;
    }

}

class YourParent {
    private String message;
    private int num;
    protected String name; // ✅ protected : 자식만 접근할 수 있도록 합니다.

    YourParent() {
        this.message = "unknown";
    }

    // Object 자바크래스를 상속. toString() 재정의. 참조값이 아닌 속성값들 출력
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%s %s (%d)", name, message, num);
    }

    // getter and setter : 주의)) class 가 default 일 때 메소드 public 의미 없음. default
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}