package mini;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import draw.HttpXmlClient;

public class ProductAgent {
	
	private void add()
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("categoryName", "热门");
		params.put("id", UUID.randomUUID().toString().replace("-", ""));
		params.put("createTime", "2015-11-24 15:50:30");
		params.put("position", "1");
		String xml = HttpXmlClient.post("http://127.0.0.1/productCenter//procuctAgentCategory/saveProcuctAgentCategory.do", params);
	}
	
	private void update()
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("categoryName", "热门007");
		params.put("id", "9f0dbe6f9f9243ad891cc4009acc0dcc");
		params.put("createTime", "2015-11-24 15:50:30");
		params.put("updateTime", "2015-11-26 15:50:30");
		params.put("position", "1");
		String xml = HttpXmlClient.post("http://127.0.0.1/productCenter//procuctAgentCategory/updateProductAgentCategory.do", params);
	}
	
	private void queryProductAgentCategory()
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", "");
		params.put("source", "'热门007'");
		params.put("pageNo", "1");
		params.put("pageSize", "10");
		String xml = HttpXmlClient.post("http://127.0.0.1/productCenter//procuctAgentCategory/queryProductAgentCategory.do", params);
	}
	
	private void queryProductAgentCategoryById()
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("categoryId", "9f0dbe6f9f9243ad891cc4009acc0dcc");
		String xml = HttpXmlClient.post("http://127.0.0.1/productCenter//procuctAgentCategory/queryProductAgentCategoryById.do", params);
	}
	
	private void deleteProductAgentCategoryById()
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("categoryId", "'9f0dbe6f9f9243ad891cc4009acc0dcc'");
		String xml = HttpXmlClient.post("http://127.0.0.1/productCenter//procuctAgentCategory/deleteProductAgentCategoryById.do", params);
	}
	
	public static void main(String[] args) {
		//new ProductAgent().add();
		//new ProductAgent().update();
		//new ProductAgent().queryProductAgentCategory();
		//new ProductAgent().queryProductAgentCategoryById();
		new ProductAgent().deleteProductAgentCategoryById();
	}
}
