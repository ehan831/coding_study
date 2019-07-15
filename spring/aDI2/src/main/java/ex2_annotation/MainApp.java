package ex2_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Member;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext cxt = new ClassPathXmlApplicationContext( "ex2_annotation.xml" );

//        둘이 동일한 표현
//        MemberBean mem = cxt.getBean( "memberBean", MemberBean.class );
//        MemberBean mem = (MemberBean)cxt.getBean( "memberBean"); // 똑같은 클래스 명에서 앞 글자만 소문자로 하면 그걸 알아서 찾아줌
//        mem.output();
        MemberDao dao = cxt.getBean( "memberDao", MemberDao.class );
        dao.insert();
    }
}
