package m_access;

import m_access.sub.Access;

// 상속 좀 받아보기, 상속 받으면 피키지가 달라도 프로텍티드 가능
public class SubClassMain extends Access {
    public static void main(String[] args) {
        SubClassMain me = new SubClassMain( );
//        me.a = "프라이빗 변경";
        me.b = "퍼블릭 변경";
//        me.c = "디폴트 변경";
        me.d = "프로텍티드 변경";
        me.output( );
    }
}