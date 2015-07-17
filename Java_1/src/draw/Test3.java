package draw;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Test3 {
	
	public static void main(String[] args) throws InterruptedException {
		//new Test3().test1();
		Map<String, String> params = new HashMap<String, String>();
		for(int i=0; i < 80; i++)
		{
			String xml = HttpXmlClient.get("http://zx-code.iteye.com/blog/2227710");
			Thread.currentThread().sleep(1000*(new Random().nextInt(5)*10));
		}
		//System.out.println(xml);
		System.out.println(new Random().nextInt(5));
	} 
	
	private void test1()
	{
		String nowTime="20150514140156640";
		String nowTime1="20150514162604187";
		int chrono = (Integer.parseInt(nowTime1.substring(8, 10)) / 2) + 1;
		System.out.println(chrono);
	}
}
