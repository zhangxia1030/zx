package draw;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


public class HttpclientSoap {

	public static void main(String[] args){
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String soapRequestData = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
"<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">"+
  "<soap12:Body>"+
    "<getRegionDatasetResponse xmlns=\"http://WebXml.com.cn/\">"+
      "<getRegionDatasetResult>"+
        "<xsd:schema>schema</xsd:schema>xml</getRegionDatasetResult>"+
    "</getRegionDatasetResponse>"+
  "</soap12:Body>"+
"</soap12:Envelope>";
		
		String  str = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
"<DataSet xmlns=\"http://WebXml.com.cn/\">"+
  "<schema xmlns=\"http://www.w3.org/2001/XMLSchema\">schema</schema>xml</DataSet>";
		
		HttpPost httppost = new HttpPost("http://webservice.webxml.com.cn/WebServices/WeatherWS.asmx");
		/*把Soap请求数据添加到PostMethod*/
		//byte[] b = soapRequestData.getBytes("utf-8");
		//InputStream is = new ByteArrayInputStream(b,0,b.length);
		try {
			HttpEntity re = new StringEntity(str,HTTP.UTF_8);
			//httppost.setHeader("Content-Type","application/soap+xml; charset=utf-8");
			//httppost.setHeader("Content-Length", String.valueOf(soapRequestData.length()));
			httppost.setEntity(re);			
			HttpResponse response = httpClient.execute(httppost);
			System.out.println(EntityUtils.toString(httppost.getEntity()));
			System.out.println(response.getStatusLine());
			System.out.println(EntityUtils.toString(response.getEntity()));			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			httpClient.getConnectionManager().shutdown();
		}
		
	}
}


