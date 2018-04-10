package util;

/**
 * 性能监控�?(线程不安�?)
 * @author 1
 *
 */
public class MethodPerformace {

	private long begin;		//方法执行�?始系统时�?
	private long end;			//方法执行结束系统时间
	private String name;		//执行的方法名
	
	public MethodPerformace() {
		// TODO Auto-generated constructor stub
	}

	public MethodPerformace(String name) {
		super();
		this.name = name;
		this.begin=System.currentTimeMillis();
	}
	
	//打印性能监控结果
	public void performace(){
		this.end=System.currentTimeMillis();
		
		long elapse=end-begin;
		PropertyUtil.writeFile(this.name, elapse+"");
		System.out.println(name+"方法执行耗时�?"+elapse+"毫秒");
	}
	
	//重置性能监控
	public void reset(String name){
		this.name=name;
		this.begin=System.currentTimeMillis();
	}
}
