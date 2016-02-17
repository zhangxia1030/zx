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
	//造数据，测试下面各个方法读取数据性能
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
	
	//生成字符串
	private String bulidPhone()
	{
		Long lo = new Random().nextLong();
		return String.valueOf(lo);
	}
	
	/**
	 * @Title: readTxt1
	 * @Description: 使用常规的jdk的io解析输出文件数据
	 * @throws IOException 
	 */ 
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
	
	/**
	 * @Title: readTxt2
	 * @Description: 使用Scanner扫面文件解析文件数据
	 * @throws IOException 
	 */ 
	@Test
	public void readTxt2() throws IOException
	{
		long start = System.currentTimeMillis();
		File file = new File("D:\\phone.txt");
		InputStream is = new FileInputStream(file);
		Scanner scan = new Scanner(is,"UTF-8");
		
		while(scan.hasNextLine())
		{
			//System.out.println(scan.nextLine());
			scan.nextLine();
			//scan.next();
		}
		
		is.close();
		scan.close();
		
		long end = System.currentTimeMillis();
		System.out.println("readTxt2方法，使用内存="+(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())+",使用时间毫秒="+(end-start));
	}
	
	/**
	 * @Title: readTxt3
	 * @Description: 使用org.apache.commons.io.FileUtils，apache工具类解析文件
	 * @throws IOException 
	 */ 
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
