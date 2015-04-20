package test;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class Test_Char {
	
	@Test
	public void testChar() throws UnsupportedEncodingException
	{
		String name = "ÄãºÃ£¬ÊÀ½ç";
		System.out.println(new String(name.getBytes("gbk")));
	}
	
}
