package test;

public class Test4 {
	
	public static void main(String[] args) {
		//System.out.println(oper(0, 0, 1, 2));
		int[][] values = new int[9][10];
		operVlaue(values);
	}
	
	private static int[][] operVlaue(int[][] values)
	{
		int[] v1 = null;
		for(int i=0; i < values.length; i++)
		{
			v1 = values[i];
			for(int j=0; j < v1.length; j++)
			{
				int value = oper(0,0,i,j);
				if(value == 5)
				{
					System.out.println(i+","+j);
				}
			}
		} 
		
		return values;
	}
	
	private static int oper(int x1,int y1,int x2, int y2)
	{
		return (int) (Math.pow((x1-x2),2)+ Math.pow((y1-y2),2));
	}
}
