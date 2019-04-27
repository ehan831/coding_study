package m_access.sub;

/**
 접근 지정자
    - private: 해당 클래스 안에서만 접근 허용
    - public: 모든 접근을 허용
    - default(아무 지정하지 않는 경우): 해당 패키지만 적용
    - protected: 다른 패키지인 경우 상속 관계만 허용
                 동일한 패키지인 경우 허용

 범위 기준: private < default < protected < public

 */

public class Access {
    private String a = "프라이빗 데이터";
    public String b = "퍼블릭 데이터";
    String c = "디폴트 데이터";
    protected String d = "프로텍티드 데이터";

    public void output() {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

}
