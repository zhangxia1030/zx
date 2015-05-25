package draw;

public class TestAward {
	public static void main(String[] args) {
		int m = 188;
		for(int i=0; i < 3; i++)
		{
			if(i==0)System.out.println((m/3)+(m%3));
			else
			System.out.println(m/3);
		}
	}
}
