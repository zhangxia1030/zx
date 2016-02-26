package test;

public class Test13
{
	public static void main(String[] args)
	{
		People p = new Child(10);
		p.sys();
		p.sy();
	}
}

class People {
	
	int n = 0;
	
	public People()
	{
		System.out.println("People");
	}
	
	public People(int n)
	{
		System.out.println("People n");
	}
	
	public void sys()
	{
		System.out.println("People sys "+n);
	}
	
	public void sy()
	{
		System.out.println("People sy "+n);
	}
}

class Child extends People {
	
	int n = 1;
	
	public Child()
	{
		System.out.println("Child");
	}
	
	public Child(int n)
	{
		super(1);
		System.out.println("Child n");
	}
	
	public void sys()
	{
		super.sy();
	}
}
