package thread;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *边生产边消费模式，处理速度快，但是这种方式有可能导致队列有数据没处理完全
 *
 */
public class ProductAndConsumer {
	
	private class Product implements Runnable
	{
		private BlockingQueue<Integer> queue = null;
		
		private AtomicInteger ai = null;
		
		public Product(BlockingQueue<Integer> queue, AtomicInteger ai)
		{
			this.queue = queue;
			this.ai = ai;
		}

		@Override
		public void run() {
			
			while(ai.incrementAndGet() < 996)
			{
				int n = new Random().nextInt(1000);
				try {
					//如果队列是满的话，会阻塞当前线程
					queue.put(n);
					System.out.println("生产者["+Thread.currentThread()+"], 生产:"+n+",数量："+ai.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private class Consumer implements Runnable
	{
		private BlockingQueue<Integer> queue = null;
		
		public Consumer(BlockingQueue<Integer> queue)
		{
			this.queue = queue;
		}
		
		@Override
		public void run() {
			
			try {
				
				while(queue.size() > 0)
				{
					System.out.println("消费者["+Thread.currentThread()+"], 消费:"+queue.take()+", 队列数量："+queue.size());
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		//队列初始值必须大于生产总值，不然阻塞会死机
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(1000);
		
		ExecutorService ep = Executors.newCachedThreadPool();
		ExecutorService ec = Executors.newCachedThreadPool();
		
		ProductAndConsumer pc = new ProductAndConsumer();
		
		AtomicInteger ai = new AtomicInteger(0);
		
		Runnable rn = pc.new Product(queue,ai);
		
		//生产者
		for(int i=0; i < 5; i++)
		{
			ep.execute(rn);
		}
		
		//关闭线程池
		ep.shutdown();
		
		Runnable rc = pc.new Consumer(queue);
		
		//消费者
		for(int j=0; j < 7; j++)
		{
			ec.execute(rc);
		}
		
		//关闭线程池
		ec.shutdown();
		
		Thread.sleep(1000);
		System.out.println(queue.size()+","+ai.intValue());
	}
	
}
