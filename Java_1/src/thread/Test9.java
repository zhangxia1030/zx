package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test9 {
	
	
	public static void main(String[] args) {
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(3);
		
		ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 5, 1000, TimeUnit.MILLISECONDS, workQueue,new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable r,
                    ThreadPoolExecutor executor) {
            	System.out.println("线程池状态已满,"
      				  + "线程池中计划被执行的任务总数：" + executor.getTaskCount() + ","
      				  + "执行完毕的任务数：" + executor.getCompletedTaskCount() + ","
      				  + "线程池中同时存在最大线程数：" + executor.getLargestPoolSize() + ","
      				  + "当前正在执行的任务数：" + executor.getActiveCount() + ","
      				  + "线程池中当前线程数：" + executor.getPoolSize());
            }
		});
            	
		for(int i=0; i < 15; i++)
		{
			pool.execute(new Th1());
		}
		
		try {
			System.out.println("================================");
			Thread.sleep(6*1000);
			pool.execute(new Th1());
			pool.execute(new Th1());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		pool.shutdown();
	}
	
}

class Th1 implements Runnable
{
	@Override
	public void run() {
		System.out.println(Thread.currentThread());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
