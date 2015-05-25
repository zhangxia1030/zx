package test;

public class ClassVarible {
	
	public static void main(String[] args) {
		A a = new B();
		A aa = new A();
		System.out.println(aa.name);
		System.out.println(a.getName());
	}
}

class A {
	
	String name = "包铁山";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

class B extends A {
	
	String name = "包拯";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
