package draw;

public class Test3 {
	
	public static void main(String[] args) {
		new Test3().test1();
	} 
	
	private void test1()
	{
		String nowTime="20150514140156640";
		String nowTime1="20150514162604187";
		int chrono = (Integer.parseInt(nowTime1.substring(8, 10)) / 2) + 1;
		System.out.println(chrono);
	}
}
