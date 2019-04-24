//package c_array;
//
//public class Student {
//    static String name;
//    static int kor, eng, math;
//    static int total;
//    static double avg;
//
//    public int cal_Total() {
//        total = kor+eng+math;
//        return total;
//    }
//    public double cal_Average() {
//        avg=(double)total/3;
//        return avg;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public int getTotal() {
//        return total;
//    }
//    public double getAvg() {
//        return avg;
//    }
//    public int getKor() {
//        return kor;
//    }
//    public void setKor(int kor) {
//        this.kor = kor;
//    }
//    public int getEng() {
//        return eng;
//    }
//    public void setEng(int eng) {
//        this.eng = eng;
//    }
//    public int getMath() {
//        return math;
//    }
//    public void setMath(int math) {
//        this.math = math;
//    }
//
//    // 멤버변수 출력하기 위한 메소드
//    public String toString() {
//        return getName()+"/"+getTotal()+"/"+getAvg();
//    }
//}

package i_class_array;

public class Student {

    // 멤버 변수 (member field)
    private String name;
    private int kor, eng, math;
    private int total = cal_Total();
    private double avg = cal_Average();

    // 멤버 메소드
    public int cal_Total() {
        total = kor + eng + math;
        return total;
    }

    public double cal_Average() {
        avg = (double)total/3;
        return avg;
    }

    // 멤버변수 출력하기 위한 메소드
    public String toString() {
        return (name+  "학생 총점: " + total + " / 평균: " + avg);
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public void setMath(int math) {
        this.math = math;
    }


    //getter
    public String getName() {
        return name;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMath() {
        return math;
    }

    public int getTotal() {
        return total;
    }

    public double getAvg() {
        return avg;
    }
}
