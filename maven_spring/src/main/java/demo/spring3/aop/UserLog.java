package demo.spring3.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserLog {

//	@Before("execution(* demo.spring3.aop.UserServiceImpl.getUserById(String))")
//	@After("execution(* demo.spring3.aop.UserServiceImpl.getUserById(String))")
	@Around("execution(* demo.spring3.aop.*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		
		System.out.println("start---->"+ String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", new Date()));

		Object retObj = null;
		try {
			System.out.println("signature---->" + pjp.getSignature());
			retObj = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("end---->"+ String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", new Date()));
		
		return retObj;
	}

}
