package thread;

import java.io.File;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Consumption implements Runnable {

	private BlockingQueue<File> block;
	
	public Consumption(BlockingQueue<File> block) {
		this.block = block;
	}



	@Override
	public void run() {
		while(block.size()  > 0)
		{
			File f;
			try {
				f = block.take();
				System.out.println(Thread.currentThread().getName()+":"+f.getName()+":"+block.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
