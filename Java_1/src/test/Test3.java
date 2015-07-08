package test;

public class Test3 {
	
	public static void main(String[] args) {
		
		Father father = new Son();
		
		father.getPeopleInfo();
		System.out.println(((Son)father).getWork());
		System.out.println(father.name);
		
	}
}

class Father {
	
	String name = "父亲";
	private int age = 30;
	private String sex = "男";
	
	private String work = "Java";
	
	
	
	public String getWork() {
		return work;
	}


	public void setWork(String work) {
		this.work = work;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}

	public void getPeopleInfo()
	{
		System.out.println("姓名："+this.name+",年龄:"+this.age+",性别:"+this.sex);
	}
}

class Son extends Father{
	
	String name = "儿子";
	private int age = 10;
	private String sex = "男";
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public void getPeopleInfo()
	{
		System.out.println("姓名："+this.name+",年龄:"+this.age+",性别:"+this.sex);
	}
}
