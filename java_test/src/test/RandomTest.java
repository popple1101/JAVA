package test;

public class RandomTest {
    public static void main(String[] args) {

        for (int i = 0; i < 1000000; i++) {
            int val = (int) (Math.random() * 8888);
            if (val == 8888) {
                System.out.println("8888 나옴!! ❗");
                break;
            }
        }
        System.out.println("끝");
    }
}
