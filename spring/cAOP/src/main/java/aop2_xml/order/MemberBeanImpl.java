package aop2_xml.order;


public class MemberBeanImpl implements MemberBean {

    public void register() {
        System.out.println( "register 함수 호출" );
    }

    public boolean update(String name) {
        System.out.println( "update 함수 호출" );
        return false;
    }
}
