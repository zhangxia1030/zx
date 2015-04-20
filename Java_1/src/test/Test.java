package test;

import java.math.BigDecimal;

public class Test {
	public static void main(String[] args) {
		Double d1=0.0333D;
		Double d2=0.0333D;
		Double d3=0.0333D;
		System.out.println(String.valueOf(d1+d2+d3));
		
		BigDecimal b1 = new BigDecimal("0.0333");
		BigDecimal b2 = new BigDecimal("0.0333");
		BigDecimal b3 = new BigDecimal("0.0333");
		System.out.println(b1.add(b2).add(b3).doubleValue());
		System.out.println(b1.doubleValue());
		
		BigDecimal bd = new BigDecimal(0);
		String[] str = {"0.0333","0.0333","0.0333"};
		for(String s : str)
		{
			bd = bd.add(new BigDecimal(s));
		}
		
		System.out.println(bd.doubleValue());
	}
}
