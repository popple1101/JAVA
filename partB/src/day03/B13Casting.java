package day03;

public class B13Casting {
    /*
     * 기본형식 데이터 타입간의 변환 : 캐스팅 casting
     * byte < short < int < long < float < double
     * 
     * 1. 자동 캐스팅 : 표현의 범위가 더 큰쪽으로 대입하는 경우
     * 2. 강제 캐스팅 : 작은 쪽으로
     */
    public static void main(String[] args) {
        double test = 23; // double 변수 = int 값;

        int num = (int) 2147483648L; // int 변수 = long 값; 은 값이 잘림. 강제로 변환

        System.out.println(test); // 23.0
        System.out.println(num); // -2147483648

        // B12 번에서 변수를 사용했다면 double temp = sum(); 변수를 선언하지 않고
        // 바로 실수로 변환하기 위해 (double) sum / 3
    }
}
