package l_innerclass;

class Outer {
    class Inner {
        void najabara() {
            System.out.println("호출해주세요");
        }
    }
}

public class InnerTest {
    public static void main(String[] args) {
        Outer o = new Outer();  // 밖에서부터 하나씩 호출하기
        Outer.Inner in = o.new Inner();
        in.najabara();
    }
}

// Inner 가 static 이면 한번에 Outer.Inner 를 호출할 수 있다.

//class Outer {
//    static class Inner {
//        void najabara() {
//            System.out.println("호출해주세요");
//        }
//    }
//}
//
//public class InnerTest {
//    public static void main(String[] args) {
//        Outer.inner in = new Outer.Inner();  // 밖에서부터 하나씩 호출하기
//        in.najabara();
//    }
//}