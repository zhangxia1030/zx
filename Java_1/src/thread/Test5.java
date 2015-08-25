package thread;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test5 {
	
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<File> block = new ArrayBlockingQueue<File>(100002210);
		
		File file = new File("E://");
		
		System.out.println("=============================================="+file.listFiles().length);
		CountDownLatch cd = new CountDownLatch(Integer.MAX_VALUE);
		
		ExecutorService product = Executors.newCachedThreadPool();
		for(File f : file.listFiles())
		{
			cd.countDown();
			product.execute(new Production(block, f));
		}
		
		product.shutdown();
		cd.await(60*2, TimeUnit.SECONDS);
		System.out.println("==============================================");
		
		ExecutorService consum = Executors.newCachedThreadPool();
		System.out.println("=============================================="+block.size());
		for(int i=0; i < 10; i++)
		{
			consum.execute(new Consumption(block));
		}
		System.out.println("=============================================="+block.size());
		consum.shutdown();
	}
	
}
