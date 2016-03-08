package test;

public class Test16
{
	public static void main(String[] args)
	{
		new Test16().sort1();
	}
	
	private void sort1()
	{
		int[] n = {2,1,6,3,8,3,9,0,1,4,5};
		
		int temp,m;
		for(int i=0; i < n.length; i++)
		{
			temp = n[i];
			for(int j=i+1; j < n.length; j++)
			{
				if(temp < n[j])
				{
					m = n[j];
					n[j]=temp;
					n[i]=m;
					
					temp = m;
				}
			}
		}
		
		for(int u : n)
		{
			System.out.println(u);
		}
	}
}
