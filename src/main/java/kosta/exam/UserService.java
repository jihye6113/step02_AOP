package kosta.exam;

public class UserService {

	public void testHello() {
		System.out.println("UserService의 testHello() 핵심 로직입니다.");
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean examHello() {
		System.out.println("UserService의 examHello() 핵심 로직입니다.");
		try {
			Thread.sleep(2500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
