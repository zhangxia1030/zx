package thread;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test8 {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> block = new ArrayBlockingQueue<Integer>(20);
		for(int i=0; i < 20; i++)
		{
			block.offer(i);
		}
		
		ExecutorService product = Executors.newCachedThreadPool();
		Iterator<Integer> it = block.iterator();
		for(int i=0; i < 5; i++)
		{
			product.execute(new BlockTest(it));
		}
		
		product.shutdown();
	}
}

class BlockTest implements Runnable
{
	Iterator<Integer> it = null;
	
	public BlockTest(Iterator<Integer> it) {
		this.it = it;
	}

	@Override
	public void run() {
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
