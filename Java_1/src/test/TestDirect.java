package test;

public class TestDirect {
	
	public static void main(String[] args) {
		
		int[][] arr = new int[7][7];
		
		arr[0][0] = 3;
		arr[0][1] = 2;
		arr[1][0] = 2;
		arr[1][1] = 1;
		arr[2][0] = 1;
		arr[2][2] = 1;
		arr[3][0] = 2;
		arr[3][1] = 1;
		arr[3][2] = 2;
		arr[4][1] = 2;
		arr[4][2] = 3;
		arr[4][3] = 4;
		arr[4][5] = 8;
		arr[4][5] = 8;
		arr[5][3] = 5;
		arr[5][4] = 6;
		arr[5][5] = 7;
		arr[5][6] = 8;
		arr[6][3] = 6;
		arr[6][4] = 7;
		arr[6][5] = 8;
		
		//arr[2][1] arr[3][5]
		int m = 0;
		int min = 1;
		for(int i=2; i < arr.length; i++)
		{
			for(int j=1; j < arr.length; j++)
			{
				m=arr[i][j];
				//if(m == 0)break;
				System.out.println(arr[i][j]);
			}
		}
	}
	
}
