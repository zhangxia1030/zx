package test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test15
{
	public static void main(String[] args)
	{
		new Test15().bigData();
	}
	
	@SuppressWarnings("unchecked")
	private void bigData()
	{
		Set<String> set = new TreeSet<String>(new Comparator(){

			@Override
			public int compare(Object o1, Object o2)
			{
				long n = Long.valueOf((String) o1)-Long.valueOf((String) o2); 
				if(n > 0)return 1;
				if(n == 0)return 0;
				if(n < 0)return -1;
				
				return 1;
			}
			
		});
		
		for(int i=0; i < 100; i++)
		{
			set.add(new Random().nextInt(100)+"");
		}
		
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}
