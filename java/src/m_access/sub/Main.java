package m_access.sub;

public class Main {
    public static void main(String[] args) {
        Access me = new Access();
//        me.a = "프라이빗 변경";
        me.b = "퍼블릭 변경";
        me.c = "디폴트 변경";
        me.d = "프로텍티드 변경";
        me.output();
    }
}
