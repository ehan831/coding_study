package b_operator;

/**
 * 비교 연산자: > < = ...
 */
//public class Ex04_Comparable {
//    public static void main(String[] args) {
//        int k=77, e=88, m=99;
//        double avg = (double)(k+e+m)/3;
//
//        if(avg >= 90) {
//            System.out.println("A학점");
//        }else if(avg >= 80) {
//            System.out.println("B학점");
//        }else{
//            System.out.println("C학점");
//        }
//    }
//}

// 위에 것을 스위치로 해보자

public class Ex04_Comparable {
    public static void main(String[] args) {
        int k = 77, e = 88, m = 99;
        double avg = (double) (k + e + m) / 3;
        String score = "";

        switch ((int) avg / 10) {
            case 10:
            case 9:
                score = "A학점";
                break;
            case 8:
                score = "B학점";
                break;
            case 7:
                score = "C학점";
                break;
            default:
                score = "낙제점";
        }
        System.out.println( score );
    }
}