package thread;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {
	
	public static void main(String[] args) {
		
		ExecutorService ex =  Executors.newCachedThreadPool();
		File file = new File("E:\\");
		for(File f : file.listFiles())
		{
			ex.execute(new DirName(f.listFiles()));
		}
		
		ex.shutdown();
	}
	
	public static void method1(String name) {

		FileWriter fw = null;

		try {

		//如果文件存在，则追加内容；如果文件不存在，则创建文件

		File f=new File("D:\\123.txt");

		fw = new FileWriter(f, true);

		} catch (IOException e) {

		e.printStackTrace();

		}

		PrintWriter pw = new PrintWriter(fw);

		pw.println(name);

		pw.flush();

		try {

		fw.flush();

		pw.close();

		fw.close();

		} catch (IOException e) {

		e.printStackTrace();

		}

		}
}

class DirName implements Runnable{
	
	File[] fs = null;
	
	public DirName(File[] fs)
	{
		this.fs = fs;
	}
	
	@Override
	public void run() {
		try {
			getName(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void getName(File[] files) throws IOException
	{
		for(File file : files)
		{
			if(file.isDirectory())
			{
				getName(file.listFiles());
			}
			else{
				System.out.println(file.getName());
				//BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("D:\\123.txt"), true)));  
				//out.write(file.getName());
				Test1.method1(file.getName());
			}
		}
	}
}
