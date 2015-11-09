package thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Group1 {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService pro = Executors.newCachedThreadPool();
		CountDownLatch p = new CountDownLatch(1);
		CountDownLatch p1 = new CountDownLatch(15);
		
		ExecutorService cu = Executors.newCachedThreadPool();
		CountDownLatch c = new CountDownLatch(1);
		
		for(int i=0; i < 15; i++)
		{
			pro.execute(new proucde(p,p1));
		}
		
		for(int i=0; i < 25; i++)
		{
			cu.execute(new customer(c));
		}
		
		p.countDown();
		p1.await();
		c.countDown();
		
		pro.shutdown();
		cu.shutdown();
		
	}
	
}

class proucde implements Runnable
{
	
	CountDownLatch p =null;
	CountDownLatch c =null;
	
	public proucde(CountDownLatch p,CountDownLatch c) {
		this.p=p;
		this.c=c;
	}

	@Override
	public void run() {
		
		try {
			p.await();
			Thread.currentThread().sleep(new Random().nextInt(400)*100L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			c.countDown();
		}
		System.out.println("生产者...");
	}
	
}

class customer implements Runnable
{
	CountDownLatch p =null;
	
	public customer(CountDownLatch p) {
		this.p=p;
	}
	
	public customer() {
	}
	
	@Override
	public void run() {
		try {
			p.await();
			Thread.currentThread().sleep(new Random().nextInt(100)*100L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("消费者......");
	}
	
}
