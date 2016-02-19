package test;

public class Test11
{
	public static void main(String[] args)
	{
		String n = "hello";
		String m = "hello";
		System.out.println(n.hashCode()+","+m.hashCode());
		
		String y = new String("hello");
		String t = new String("hello");
		System.out.println(y.hashCode()+","+t.hashCode());
		System.out.println(y==t);
		
		System.out.println(new Test11());
		System.out.println(new String("hello"));
	}
}
