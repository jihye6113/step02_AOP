package kosta.exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("kosta/exam/springAopContext.xml");
		
		MessageService service = context.getBean("service", MessageService.class); 
		// MessageServiceImple이 아닌 인터페이스 기반으로 접근해야된다.
		// springAopContext.xml에서 proxy-target-class="true"로 하면 impl 방식으로도 가능하다.
		
		service.korHello();
		
		System.out.println("------------------");
		service.engHello();
		
		System.out.println("------------------");
		String re = service.hello();
		System.out.println("리턴 값: " + re);
		
		System.out.println("------------------");
		int i = service.hello("지혜");
		System.out.println("리턴 값: " + i);
		
		System.out.println("------------------");
		////////////////////////////////////////////////
		UserService user = context.getBean("userService", UserService.class);
		
		user.testHello();
		
		System.out.println("------------------");
		user.examHello();
	}

}
