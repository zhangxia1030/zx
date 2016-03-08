package test;

public class Test17
{
	public static void main(String[] args)
	{
		Y y = new Y();
		y.age = 10;
		y.name = "hello";
		
		System.out.println(y);
		System.out.println("=======================");
		
		T t = new Y();
		t.name = "uuu";
		t.age = 100;
		((Y)t).grade = "123456";
		System.out.println(t);
	}
}

class Y extends T{
	
	String grade = null;
	
	String name = null;
	
	@Override
	public String toString()
	{
		return grade+","+super.name+","+name+","+super.age;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getGrade()
	{
		return grade;
	}

	public void setGrade(String grade)
	{
		this.grade = grade;
	}
}

class T{
	 
	String name = null;
	int age = 0;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	
}
