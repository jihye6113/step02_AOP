package kosta.exam;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 * 공통기능 구현 - 사전, 사후처리(around 형식)
 * */
public class TimerAdvice {

	public Object around(ProceedingJoinPoint joinPoint) throws Throwable { // 뭔가를 리턴하긴 할텐데, 무슨 타입이든 상관 없기에 Object
		// 사전처리
		// 타겟대상의 메서드 이름 구하기
		String methodName = joinPoint.getSignature().getName();
		System.out.println("[LOG] " + methodName + " 호출되기 전.");
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object obj = joinPoint.proceed(); // 실제 타겟대상 호출(joinPoint call) // doFilter 같은 역할
		
		// 사후처리
		sw.stop();
		System.out.println("[LOG] " + methodName + "의 리턴값 = " + obj);
		System.out.println("[LOG] " + methodName + "의 총 걸린 시간: " + sw.getTotalTimeMillis() + "ms");
		System.out.println("[LOG] " + methodName + " 호출 완료");
		
		return obj;
	}
}
