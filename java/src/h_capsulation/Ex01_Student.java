package h_capsulation;

// 서로 다른 자료형의 변수들 + 메소드들
/**
 캡슐화 - 서로 다른 권한을 부여하는 것
    1. 멤버변수 - private
    2. 멤버메소드 - public


 */
public class Ex01_Student {
    String name;
    int kor, eng, math;
    int total;
    double avg;

    int calTotal() {
        total = kor + eng + math;
        return total;
    }

    double calAverage() {
        avg = (double)total/3;
        return avg;
    }

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
}
