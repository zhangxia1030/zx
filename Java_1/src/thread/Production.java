package thread;

import java.io.File;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Production  implements Runnable{
	 
	private BlockingQueue<File> block;
	
	private File file;
	
	public Production(BlockingQueue<File> block, File file) {
		this.block = block;
		this.file = file;
	}

	@Override
	public synchronized void run() {
		try {
			putFile(file.listFiles());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void putFile(File[] fs) throws InterruptedException
	{
		if(fs == null)return;
		
		for(File f : fs)
		{
			if(f.isFile())
			{
				block.offer(f);
			}
			else
			{
				putFile(f.listFiles());
			}
		}
	}

}
