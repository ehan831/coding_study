package ex1_xml2_ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		MemberBean mem = context.getBean("mem", MemberBean.class);
		mem.output();
	}
}

