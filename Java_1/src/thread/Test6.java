package thread;

import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test6 {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> block = new ArrayBlockingQueue<Integer>(1);
		for(int i=0; i < 10; i++)
		{
			block.offer(i);
		}
		
		Iterator<Integer> it = block.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
