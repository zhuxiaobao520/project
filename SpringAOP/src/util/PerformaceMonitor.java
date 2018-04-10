package util;

/**
 * 性能监控工具（线程安全）
 * @author 1
 *
 */
public class PerformaceMonitor {

	private static ThreadLocal<MethodPerformace> mLocal=new ThreadLocal<>();
	
	
	//�?始�?�能监控
	public static void begin(String name){
		
		MethodPerformace methodPerformace=mLocal.get();
		if(methodPerformace==null){
			methodPerformace=new MethodPerformace(name);
			mLocal.set(methodPerformace);
		}else {
			methodPerformace.reset(name);
		}
		
	}
	public static void end(){
		MethodPerformace performace=mLocal.get();
		if(performace!=null){
			performace.performace();
		}
		
	}
}
