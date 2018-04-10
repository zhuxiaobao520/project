package performance;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.lovo.util.PerformaceMonitor;



/**
 * 声明性能测试切面
 * @author 1
 *
 */

@Component
@Aspect
public class PerformanceTest {
	
	@Around("execution(* com.lovo.sgproj.service.imp.*.*(..)) or execution(* com.lovo.sgproj.dao.imp.*.*(..))")
	public Object testService(ProceedingJoinPoint joinPoint) throws Throwable{
		
				//前置增强
				String className=joinPoint.getTarget().getClass().getName();	//获取目标对象包全�?
				String methodName=joinPoint.getSignature().getName();		//获取方法�?
				PerformaceMonitor.begin(className+"."+methodName);
				
				Object object=joinPoint.proceed();//调用目标对象方法
				
				//后置增强
				PerformaceMonitor.end();
			
				return object;
	}
	
	
	
}
