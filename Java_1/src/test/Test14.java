package test;

public class Test14
{
	public static void main(String[] args)
	{
		new Test14().hunwen123();
	}
	
	private void hunwen123()
	{
		String n = "123456";
		char[] chn = n.toCharArray();
		char[] result = new char[n.length()];
		int m = n.length();
		for(char c : chn)
		{
			result[m-1] = c;
			m--;
		}
		
		System.out.println(String.valueOf(result));
	}
	
	private void hunwen()
	{
		String n = "123456";
		StringBuffer sb = new StringBuffer();
		for(int i=n.length()-1; i >= 0; i--)
		{
			sb.append(n.charAt(i));
		}
		
		System.out.println(sb);
	}
}
