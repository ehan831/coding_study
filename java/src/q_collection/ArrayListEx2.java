package q_collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListEx2 {
    public static void main(String[] args) {
        ArrayList<Student> result = method( );
        System.out.println( result );
//        // 여기서 출력
//        for(Student ss:result) {
//            System.out.println(ss);
//        }

        // 표준화 출력, Enumeration -> Iterator
        Iterator it = result.iterator( );
        while (it.hasNext( )) {
            System.out.println( it.next( ) );
        }
    }


    static ArrayList<Student> method() {
        Student a = new Student( "홍길자", 20 );
        Student b = new Student( "홍길숙", 30 );
        Student c = new Student( "홍길동", 40 );

        ArrayList<Student> arr = new ArrayList( 3 );
        arr.add( a );
        arr.add( b );
        arr.add( c );

        return arr;
    }
}

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " 학생은 " + age + "세 입니다";
    }
}
