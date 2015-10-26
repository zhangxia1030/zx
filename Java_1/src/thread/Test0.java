package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test0 {
	
	public static void main(String[] args) {
		
		ExecutorService es = Executors.newCachedThreadPool();
		
		ScheduledExecutorService  ses = Executors.newScheduledThreadPool(5);
		
		//ses.schedule(new T1(), 1000, TimeUnit.MILLISECONDS);
		
		ses.scheduleAtFixedRate(new T1(), 1, 2, TimeUnit.SECONDS);
		
		//ses.scheduleWithFixedDelay(new T1(), 1000, 1000, TimeUnit.MILLISECONDS);
		
		
		//ses.execute(new T1());
		
		//ses.shutdown();
		
	}
	
}

class T1 implements Runnable
{
	
	private int room = 10;
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread()+":"+room);
	}
	
}
