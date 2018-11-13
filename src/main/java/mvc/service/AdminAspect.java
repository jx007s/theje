package mvc.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AdminAspect {

	HttpSession session;
	HttpServletResponse response;
	
	@Pointcut("execution(* mvc.controll.admin..*.*(..))")
	void adminTarget() {}
	
	
	@Around("adminTarget()")
	Object loginArround(ProceedingJoinPoint joinPoint) throws Throwable {
		Object res = null;
		
		System.out.println("loginArround() 실행");
		
		for (Object obj : joinPoint.getArgs()) {
			if(obj instanceof HttpSession ) {
				session = (HttpSession)obj;
			}
			
			if(obj instanceof HttpServletResponse ) {
				response = (HttpServletResponse)obj;
			}
			 
		}
		
		if(session.getAttribute("pid")==null) {
			
			response.sendRedirect("/board/");
			return res;
		}
		
		res = joinPoint.proceed();
		
		return res;
	}
}
