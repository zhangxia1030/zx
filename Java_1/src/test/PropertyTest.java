package test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;

import property.Property1;

import entity.Grade;
import entity.User;

public class PropertyTest {
	
	public static void main(String[] args) throws IntrospectionException {
		Grade g = new Grade();
		PropertyDescriptor pd = new PropertyDescriptor("ggName", Grade.class);
		PropertyDescriptor uu = new PropertyDescriptor("user", Grade.class);
		System.out.println(pd.toString());
		uu.setPropertyEditorClass(Property1.class);
		
		g.setGgName("001");
		Property1 p1 = new Property1();
		p1.setAsText("nihao,10");
		g.setUser((User) p1.getValue());
		System.out.println(p1.getValue());
	}
	
}
