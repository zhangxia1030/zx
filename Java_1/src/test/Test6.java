package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.User;

public class Test6 {
	
	public static void main(String[] args) {
		
		List<User> list = new ArrayList<User>();
		while(true) 
		{
			User user = new User();
			user.setAge(new Random().nextInt(100));
			user.setName("zhangni");
			list.add(user);
			user = null;
		}
		
	}
	
}
