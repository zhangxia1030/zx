package thread;

public class RunnableTest {
	
	public static void main(String[] args) {
		
		Runnable1 r1 = new Runnable1();
		
		new Thread(r1, "01").start();
		new Thread(r1, "03").start();
		
		//2个窗口一共卖了100张
	}

}

class Runnable1 implements Runnable
{
	private int ticket = 10;
	
	@Override
	public void run() {
		while(ticket > 0)
		{
			System.out.println("窗口:"+Thread.currentThread().getName()+",卖了1个，剩余："+(ticket--));
		}
	}
}
