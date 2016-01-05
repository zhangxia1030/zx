package entity;


/**   
 * 版权所有：2015-欣网视讯
 * 项目名称：Java_1   
 *
 * 类描述：
 * 类名称：entity.GoodPeople     
 * 创建人：zx 
 * 创建时间：2015-12-30 下午03:51:36   
 * 修改人：
 * 修改时间：2015-12-30 下午03:51:36   
 * 修改备注：   
 * @version   V1.0    
 */
  
public class GoodPeople extends People {
	
	/**
	 * @Fields good : 好人
	 */ 
	private String good;
	
	/**
	 * @Fields name : 人名
	 */ 
	private String name;

	/**
	 * @Title: getGood
	 * @Description: 获取好人
	 * @return 
	 */ 
	public String getGood() 
	{
		return good;
	}

	public void setGood(String good)  throws Exception
	{
		this.good = good;
	}

	/**
	 * @see entity.People#getName()
	 */
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	
}
