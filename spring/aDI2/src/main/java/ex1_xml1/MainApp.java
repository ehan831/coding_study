package ex1_xml1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		// 객체 주입

		ApplicationContext context = 
				new ClassPathXmlApplicationContext( "applicationContext.xml" );
		
		MessageBean bean1 = (MessageBean)context.getBean("ko");
		bean1.sayHello("홍길자");

		MessageBean bean2 = (MessageBean)context.getBean("en");
		bean2.sayHello("hong1111");

		MessageBean bean3 = (MessageBean)context.getBean("en");
		bean3.sayHello("hong2222");
//		
	}

}
