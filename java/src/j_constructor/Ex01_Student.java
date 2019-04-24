package j_constructor;

public class Ex01_Student {

    // 멤버 변수 (member field)
    private String name;
    private int kor, eng, math;
    private int total;
    private double avg;
    // 생성자 함수가 하나도 없으면? > 자바 컴파일러가 자동으로 생성
    // public Student(){}

    public Ex01_Student() {
        this.name="익명";
        this.kor=50;
        this.eng=50;
        this.math=50;
    }

    // 생성자 - 멤버변수 초기화
    // 클래스 명과 동일해야 한다.
    // 리턴형을 반드시 없애야 한다. void 도 안됨.
    public Ex01_Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    // 멤버 메소드
    int cal_Total() {
        total = kor+eng+math;
        return total;
    }
    double cal_Average() {
        avg=(double)total/3;
        return avg;
    }


    // 멤버변수 출력하기 위한 메소드
    public String toString() {
        return (name+  "학생 총점: " + total + " / 평균: " + avg);
    }

    // getter, setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }
}