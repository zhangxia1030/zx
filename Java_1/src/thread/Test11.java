package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import draw.HttpXmlClient;

public class Test11 {
	
	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch begin = new CountDownLatch(1);
		CountDownLatch end = new CountDownLatch(100);
		
		ExecutorService es = Executors.newCachedThreadPool();
		
		for(int i=0; i < 1; i++ )
		{
			es.execute(new Conn1(begin,end));
		}
		
		begin.countDown();
		
		//end.await();
		es.shutdown();
		
	}
	
}

class Conn1 implements Runnable
{
	CountDownLatch cl = null;
	CountDownLatch end = null;
	
	public Conn1(CountDownLatch cl,CountDownLatch end)
	{
		this.cl = cl;
		this.end = end;
	}
	
	@Override
	public void run() {
		
		try {
			cl.await();
			//String xml = HttpXmlClient.get("http://tengxunjiaju.j9.53dns.net/action/baoming/save_apply");
			//String xml = HttpXmlClient.get("http://zx-code.iteye.com/blog/2248068");
			//String xml = HttpXmlClient.get("http://192.168.21.7:8080/m_activity_test/13101?loginmobile=15952040609&imsi=460011122334&imsimobile=&deviceid=1DDA72B5F1651AD83E6683612AF4B2C5&imei=312020931201&platform=android&channel=jsmcc&version=4.0&time=20150104221237&day=20150104&sign=D30A730B196B410865363D2B147EE3BC");
			//String xml = HttpXmlClient.get("http://localhost:8080/act_tplmgr/index");
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", "1ca39659e51845569af37346a5fe1493");
			params.put("name", "123111");
			params.put("phone", "1230983w4");
			params.put("houseStyle", "1");
			params.put("budget", "20");
			params.put("city", "1");
			String xml = HttpXmlClient.post("http://tengxunjiaju.j9.53dns.net/action/baoming/save_apply",params);
			System.out.println(xml);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally{
			end.countDown();
		}
	}
	
}
