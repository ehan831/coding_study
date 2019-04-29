package z_useful;

public class EqualsEx {
    public static void main(String[] args) {

        Student a = new Student( "012345", "홍길동" );
        Student b = new Student( "012345", "홍길동" );

        if (a.equals( b )) {
            System.out.println( "같은 학생" );
        } else {
            System.out.println( "다른 학생" );
        }
        System.out.println( a );
        System.out.println( b );

//        if (a.hakbun.equals( b.hakbun )) {
//            System.out.println( "같은 학생" );
//        } else {
//            System.out.println( "다른 학생" );
//        }
//        System.out.println( a );
//        System.out.println( b );
    }
}

class Student {
    String hakbun, name;

    Student() {
    }

    Student(String hakbun, String name) {
        this.hakbun = hakbun;
        this.name = name;
    }

    public boolean equals(Object obj) {
        Student other = (Student) obj;
        if (hakbun.equals( other.hakbun )) return true;
        else return false;
    }

    public String toString() {
        return "[" + hakbun + "]" + name;
    }


}
