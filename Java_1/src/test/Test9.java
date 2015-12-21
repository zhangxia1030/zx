package test;

import java.util.HashMap;
import java.util.Map;

public class Test9 {
	public static void main(String[] args) {
		String str = "123,";
		System.out.println(str.lastIndexOf(","));
		if(str.lastIndexOf(",") == str.length()-1)
		{
			
			System.out.println(str);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(map.get("name"));
	}
}
