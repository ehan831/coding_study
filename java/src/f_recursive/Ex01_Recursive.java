package f_recursive;

public class Ex01_Recursive {
//    public static void main(String[] args) {
//
//        int sum = 0;
//        // 1부터 10까지의 합 구하기
//        for (int i = 1; i <=10 ; i++) {
//            // sum+=i;
//
//            int exsum = sum;
//            sum = exsum+i;
//            System.out.println(sum + "=" + exsum + "+" + i);
//        }
//    }

    public static void main(String[] args) {
        // 재귀함수!!!!!
        int sum = 0;
        sum = sumFunc( 10 );
        System.out.println( "총합: " + sum );
    }

    // sumFunc 안에서 sumFunc을 호출함. 자칫하다간 무한 루프로 동작할 수 있다. 조심해서 쓰고, break point 를 잡아주자.
    static int sumFunc(int i) {
        if(i==1) return 1;
        return i + sumFunc(i-1 );
    }
}

