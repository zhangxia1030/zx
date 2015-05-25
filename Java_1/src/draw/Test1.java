package draw;

import com.alibaba.fastjson.JSONObject;


public class Test1 {

	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("params", setParm());
        System.out.println(jsonObject.toString());
		HttpClientAct hca = new HttpClientAct();
		String result = hca.postXmlObject("http://127.0.0.1:8080/draw_service/draw.do", jsonObject.toJSONString());
		System.out.println(result);
	}

	public static String setParm()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<params>");
		sb.append("<para name=\"stageId\" count=\"1\">");
		sb.append("<value><![CDATA[10002520]]></value>");
		sb.append("</para>");
		sb.append("<para name=\"mobile\" count=\"1\">");
		sb.append("<value><![CDATA[15252490245]]></value>");
		sb.append("</para>");
		sb.append("<para name=\"brand\" count=\"1\">");
		sb.append("<value><![CDATA[]]></value>");
		sb.append("</para>");
		sb.append("<para name=\"area\" count=\"1\">");
		sb.append("<value><![CDATA[0]]></value>");
		sb.append("</para>");
		sb.append("<para name=\"sessionId\" count=\"1\">");
		sb.append("<value><![CDATA[]]></value>");
		sb.append("</para>");
		sb.append("<para name=\"userIp\" count=\"1\">");
		sb.append("<value><![CDATA[]]></value>");
		sb.append("</para>");
		sb.append("<para name=\"giftPkgNums\" count=\"1\">");
		sb.append("<value><![CDATA[1075,1076]]></value>");
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
