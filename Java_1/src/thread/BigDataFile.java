package thread;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BigDataFile {
	
	private class DealFile implements Runnable
	{
		 
		//存放遍历的结果  
		BlockingQueue<File> bFile = null;
		
		//每个线程独有的file文件夹
		File file = null;
		
		public DealFile(BlockingQueue<File> bFile, File file)
		{
			this.bFile = bFile;
			this.file = file;
		}

		@Override
		public void run() {
			getFileName(file.listFiles());
		}
		
		/**
		 * 迭代遍历文件夹。
		 * */
		private final void getFileName(File[] fileDirectory)
		{
			for(File file : fileDirectory)
			{
				if(file.isDirectory())
				{
					//继续迭代处理
					getFileName(file.listFiles());
				}
				else
				{
					//输出文件的名称
					System.out.println(file.getName());
					bFile.add(file);
				}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		/**
		 * 由于LinkedBlockingQueue实现是线程安全的，实现了先进先出等特性，是作为生产者消费者的首选，LinkedBlockingQueue 
		 * 可以指定容量，也可以不指定，不指定的话，默认最大是Integer.MAX_VALUE，
		 * 其中主要用到put和take方法，put方法在队列满的时候会阻塞直到有队列成员被消费，take方法在队列空的时候会阻塞，
		 * 直到有队列成员被放进来。
		 * */
		BlockingQueue<File> bFile = new LinkedBlockingQueue<File>();
		
		//需要遍历的文件夹
		File file = new File("D://");
		
		//线程池
		ExecutorService es = Executors.newCachedThreadPool();
		
		BigDataFile bf = new BigDataFile();
		
		/**
		 * new File("D://") 文件夹下面有几个文件夹new 几个线程执行。
		 * */
		for(File f : file.listFiles())
		{
			if(f.isDirectory())
			{
				es.execute(bf.new DealFile(bFile, f));
			}
			else
			{
				System.out.println(f.getName());
				bFile.add(f);
			}
		}
		
		//关闭线程池
		es.shutdown();
	}
	
}
