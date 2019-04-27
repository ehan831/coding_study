package m_access;

import m_access.sub.Access;

public class Main {
    public static void main(String[] args) {
        Access me = new Access();
//        me.a = "프라이빗 변경";
        me.b = "퍼블릭 변경";
//        me.c = "디폴트 변경";
//        me.d = "프로텍티드 변경";
        me.output();
    }
}

// 퍼블릭만 접근 가능, 다른 패키지에 있을 때에는!!