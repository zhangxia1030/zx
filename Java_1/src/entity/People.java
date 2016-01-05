package entity;

/**
 * 版权所有：2015-欣网视讯 项目名称：Java_1
 * 
 * 类描述： 类名称：entity.People 创建人：zx 创建时间：2015-12-30 下午03:41:13 修改人： 修改时间：2015-12-30
 * 下午03:41:13 修改备注：
 * 
 * @version V1.0
 */

public class People
{

	/**
	 * name:姓名
	 * 
	 * @since Ver 1.1
	 */
	private String name;

	/**
	 * age:年齡
	 * 
	 * @since Ver 1.1
	 */
	private int age;

	/**
	 * @Fields className : 班级
	 */
	private String className;

	/**
	 * @Title: getName
	 * @Description: 获取年龄
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @Title: setName
	 * @Description: 设置年龄
	 * @param name
	 */
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

	public String getClassName()
	{
		return className;
	}

	public void setClassName(String className)
	{
		this.className = className;
	}

	/**
	 * @Title: sys
	 * @Description: 输出name
	 * @param name
	 */
	public void sys(String name)
	{
		System.out.println(name);
	}

}
