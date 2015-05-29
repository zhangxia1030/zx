package draw;

import java.util.HashMap;
import java.util.Map;

import entity.Result;

public class Test2 {
	public static void main(String[] args) {
		
		/***
		Map<String, String> params = new HashMap<String, String>();
		params.put("params", getParm());
		
		String xml = HttpXmlClient.post("http://127.0.0.1:8080/draw_service/draw.do", params);
		
		Result result = XmlUtil.xml2Bean(xml, Result.class);
		
		if(result.getResultObject().isWinFlag() == true && result.getResultObject().getPkgNum().equals("1066"))
		{
			System.out.println("========================================");
			System.out.println(result.toString());
			System.out.println("========================================");
		}
		else
		{
			System.out.println(result.toString());
		}
		*/
		
		new Test2().test();
	}
	
	private void test()
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("params", getParm());
		
		int count = 0;
		int award = 0;
		
		while(count < 10)
		{
			count++;
			
			String xml = HttpXmlClient.post("http://127.0.0.1:8080/draw_service/draw.do", params);
			
			Result result = XmlUtil.xml2Bean(xml, Result.class);
			
			if(result != null && result.getResultObject().isWinFlag())
			{
				System.out.println("========================================");
				System.out.println(result.toString());
				System.out.println("========================================");
				award++;
			}
			else
			{
				System.out.println(result.toString());
			}
		}
		
		System.out.println("==========="+count+",中奖数量:"+award);
	}
	
	private void test1()
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("params", getParm());
		
		int count = 0;
		
		while(true)
		{
			String xml = HttpXmlClient.post("http://192.168.21.7:8080/draw_service/draw.do", params);
			
			Result result = XmlUtil.xml2Bean(xml, Result.class);
			
			if(result.getResultObject().isWinFlag())
			{
				System.out.println("========================================");
				System.out.println(result.toString());
				System.out.println("========================================");
				count++;
				break;
			}
			else
			{
				System.out.println(result.toString());
			}
		}
		
		System.out.println("==============="+count);
	}
	
	public static String getParm()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<params>");
		sb.append("<para name=\"stageId\" count=\"1\">");
		sb.append("<value><![CDATA[10003100]]></value>");
		sb.append("</para>");
		sb.append("<para name=\"mobile\" count=\"1\">");
		sb.append("<value><![CDATA[13605201444]]></value>");
		sb.append("</para>");
		sb.append("<para name=\"brand\" count=\"1\">");
		sb.append("<value><![CDATA[]]></value>");
		sb.append("</para>");
		sb.append("<para name=\"area\" count=\"1\">");
		sb.append("<value><![CDATA[16]]></value>");
		sb.append("</para>");
		sb.append("<para name=\"sessionId\" count=\"1\">");
		sb.append("<value><![CDATA[]]></value>");
		sb.append("</para>");
		sb.append("<para name=\"userIp\" count=\"1\">");
		sb.append("<value><![CDATA[]]></value>");
		sb.append("</para>");
		sb.append("<para name=\"giftPkgNums\" count=\"1\">");
		sb.append("<value><![CDATA[1195,1196,1197]]></value>");
		sb.append("</para>");
		sb.append("<para name=\"resultType\" count=\"1\">");
		sb.append("<value><![CDATA[xml]]></value>");
		sb.append("</para>");
		sb.append("<para name=\"channel\" count=\"1\">");
		sb.append("<value><![CDATA[wap]]></value>");
		sb.append("</para>");
		sb.append("<para name=\"county\" count=\"1\">");
		sb.append("<value><![CDATA[0]]></value>");
		sb.append("</para>");
		sb.append("<para name=\"password\" count=\"1\">");
		sb.append("<value><![CDATA[]]></value>");
		sb.append("</para>");
		sb.append("<para name=\"userId\" count=\"1\">");
	    sb.append("<value><![CDATA[]]></value>");
		sb.append("</para>");
		sb.append("</params>");
		
		return sb.toString();
	}
}
