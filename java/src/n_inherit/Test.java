package n_inherit;

public class Test {
    public static void main(String[] args) {
        /** 1. 클래스 생성과 메소드 호출 확인 */
//        Parent p = new Parent( );
//        p.gene( );
//        p.job( );
//        // 부모 클래스는 자식 클래스에 접근이 안된다.
//        System.out.println( "==========" );
//
//        Child c = new Child( );  // 부모 생성자를 부르고, 그 다음에 자식 생성자를 부
//        c.gene( );
//        c.study( );
//        c.job( );    // 자식 클래스는 부모 클래스에 접근이 가능하다.
//        System.out.println( "==========" );

        /** 2. 자식-부모 섞어서 만들어보기 */
//        Child cp = new Parent();    // no
        Parent pc = new Child( );    // ok
        pc.gene( );  // 부모가 아니라 자식 메소드가 불러진다?! Overriding
        pc.job( );
//        pc.study(); // no!
        ((Child) pc).study( );  // 형변환은 밑에서 언급함

        /**
         overriding
         - 부모,자식 간의 메소드가 동일
         - 인자 동일 / 리턴형 동일
         - 접근 지정자는 같거나 크거나 | 동일하게 사용하는 것을 추천함
         - 부모 변수에서 자식의 멤버를 호출해줌
         */

        /**
         개발자 입장에서 상속이란?
         1. 자식 클래스는 부모 클래스의 멤버를 사용 - 그냥 호출
         2. 부모 클래스에 없는 경우 - 만들어 쓰기
         3. 부모 클래스에 있는데 수정이 필요함 - overriding
         */

        /** 3. 형변환 (casting) - 상속관계에서만 가능
         String a = new String("헬로우")
         StringBuffer b = (StringBuffer)a;
         */

//        Child c = new Child();
//        Parent p = (Parent)c;
//        c.study();

        Parent pp = new Child( );
        pp.gene( );
        pp.job( );
        ((Child) pp).study( );   // 형변환해서 부르기
        System.out.println( "===========" );

        /** 4. instanceof 연산자 */
        Child c = new Child( );
        if (c instanceof Child) {
            System.out.println( "자식의 객체임" );
        }
        if (c instanceof Parent) {
            System.out.println( "부모의 객체임" );
        }
        if (c instanceof Object) {
            System.out.println( "오브젝트의 객체임" );
            // 자바의 모든 클래스는 Object 를 상속 받는다. extends Object 가 숨겨져 있는 것.
        }
    }
}
