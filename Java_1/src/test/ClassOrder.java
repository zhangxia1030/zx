package test;

public class ClassOrder {
	
	/**
	 * 静态变量
	 */
	public static String staticStr = "Static variable";
	
	/**
	 * 静态块
	 */
	static{
		System.out.println(staticStr);
		staticStr = "Static variable clob";
	}
	
	/**
	 * 类块
	 */
	{
		System.out.println("Class {}");
	}
	
	/**
	 * 变量定义
	 */
	private String name = "zhangsan";

	public String getName() {
		System.out.println(name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		/**
		 * 执行顺序：
		 * 1. 先执行static，加载类时候静态变量就执行了，然后执行静态块，给静态变量赋值
		 * 2. 每次new一个对象都会执行{}，所以这个可以用来对一些变量每次初始化。
		 * 3. 最后执行变量
		 * 4. 当在次new一个对象时候，静态变量不会再次执行了，因为该类已经加载到方法区了。
		 */
		System.out.println("-- "+ClassOrder.staticStr);
		ClassOrder co1 = new ClassOrder();
		ClassOrder co2 = new ClassOrder();
		System.out.println(ClassOrder.staticStr);
		System.out.println(co2.staticStr);
		co1.getName();
		co2.getName();
	}
	
}
