package ex1_xml4_list;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext( "ex1_list.xml" );

        ListBean bean = context.getBean( "bean", ListBean.class );
        for(Integer i: bean.getIntList()) {
            System.out.println(i );
        }
        for(MemberBean mb: bean.getMemberList()) {
            System.out.println(mb.getName() + "/" + mb.getMessage());
        }
    }
}
