package test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.junit.Test;

public class TestFile {
	
	//@Test
	public void makeFile() throws IOException
	{
		File file = new File("D:\\phone.txt");
		
		OutputStream os = new BufferedOutputStream(new FileOutputStream(file));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os));
		
		//2百万
		for(int i=0; i < 2000000; i++)
		{
			bw.write(bulidPhone());
			bw.newLine();
		}
		
		bw.close();
		os.close();
	}
	
	@SuppressWarnings("unused")
	private String bulidPhone()
	{
		Long lo = new Random().nextLong();
		return String.valueOf(lo);
	}
	
	@Test
	public void readTxt1() throws IOException
	{
		long start = System.currentTimeMillis();
		File file = new File("D:\\phone.txt");
		Reader in = new FileReader(file);
		BufferedReader br = new BufferedReader(in);
		while(br.ready())
		{
			//System.out.println(br.readLine());
			br.readLine();
		}
		
		in.close();
		br.close();
		long end = System.currentTimeMillis();
		System.out.println("readTxt1方法，使用内存="+(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())+",使用时间毫秒="+(end-start));
	}
	
	@Test
	public void readTxt2() throws IOException
	{
		long start = System.currentTimeMillis();
		File file = new File("D:\\phone.txt");
		InputStream is = new FileInputStream(file);
		Scanner scan = new Scanner(is,"UTF-8");
		
		while(scan.hasNextLine())
		{
			//System.out.println(scan.next());
			scan.next();
		}
		
		is.close();
		scan.close();
		
		long end = System.currentTimeMillis();
		System.out.println("readTxt2方法，使用内存="+(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())+",使用时间毫秒="+(end-start));
	}
	
	@Test
	public void readTxt3() throws IOException
	{
		long start = System.currentTimeMillis();
		File file = new File("D:\\phone.txt");
		
		LineIterator it = FileUtils.lineIterator(file, "UTF-8");
		
		while(it.hasNext())
		{
			it.next();
		}
		
		it.close();
		
		long end = System.currentTimeMillis();
		System.out.println("readTxt3方法，使用内存="+(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())+",使用时间毫秒="+(end-start));
	}
}
