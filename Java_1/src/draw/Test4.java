package draw;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Test4 {
	
	public static void main(String[] args) throws InterruptedException {
		//new Test3().test1();
		
		while(true)
		{
			Map<String, String> params = new HashMap<String, String>();
			params.put("password", getRandomString(new Random().nextInt(16)));
			String xml = HttpXmlClient.post("http://dev.joinlinking.com/flowersMall/manager_auxiliary/index.jsp", params);
			System.out.println(xml.indexOf("请输入密码"));
			if(xml.indexOf("请输入密码") != 505)
			{
				break;
			}
		}
		
	}
	
	/**
	 * 生成随机密码
	 * @param length
	 * @return
	*/
	 public static String getRandomString(int length) { 
		 StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzQWERTYUIOPASDFGHJKLZXCFVBNM-=.!@#$%^&*()"); 
		 StringBuffer sb = new StringBuffer(); 
		 Random r = new Random(); 
		 int range = buffer.length(); 
		 for (int i = 0; i < length; i ++) { 
			 sb.append(buffer.charAt(r.nextInt(range)));
		 }
	 return sb.toString(); 
	}



}
