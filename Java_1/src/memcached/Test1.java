package memcached;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import entity.User;

import net.rubyeye.xmemcached.KeyIterator;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class Test1 {
	
	MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("127.0.0.1:11211"));

    MemcachedClient memcachedClient;
    
    {
    	 try {
			memcachedClient = builder.build();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    private final void test1()
    {
    	try {


	           memcachedClient.set("hello", 0, "Hello,xmemcached");

	           String value = memcachedClient.get("hello");

	           System.out.println("hello=" + value);

	           memcachedClient.delete("hello");

	           value = memcachedClient.get("hello");

	           System.out.println("hello=" + value);

	           // close memcached client

	           memcachedClient.shutdown();

	       } catch (MemcachedException e) {

	           System.err.println("MemcachedClient operation fail");

	           e.printStackTrace();

	       } catch (TimeoutException e) {

	           System.err.println("MemcachedClient operation timeout");

	           e.printStackTrace();

	       } catch (InterruptedException e) {

	           // ignore

	       }catch (IOException e) {

	           System.err.println("Shutdown MemcachedClient fail");

	           e.printStackTrace();

	       }

    }
    
    private final void testObject()
    {
    	User user = new User();
    	user.setAge(1001);
    	user.setName("张三1");
    	
    	try {
    		System.out.println(user);
			boolean flag = memcachedClient.add("test1", 0, user);
			User uu = memcachedClient.get("test1");
			System.out.println(uu+":"+uu.getAge()+","+uu.getName());
			
			memcachedClient.shutdown();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private final void testList()
    {
    	User user = new User();
    	user.setAge(100);
    	user.setName("张三");
    	
    	User user1 = new User();
    	user1.setAge(1001);
    	user1.setName("张三111");
    	
    	List<User> list = new ArrayList<User>();
    	list.add(user);
    	list.add(user1);
    	
    	try {
    		System.out.println(list);
			boolean flag = memcachedClient.add("list", 100, list);
			List uu = memcachedClient.get("list");
			
			memcachedClient.shutdown();
			System.out.println(uu);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }
    
    private final void testGet()
    {
    	try {
    		User uu = memcachedClient.get("test");
    		System.out.println(uu+":"+uu.getAge()+","+uu.getName());
    		
    		memcachedClient.shutdown();
    	} catch (TimeoutException e) {
    		e.printStackTrace();
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	} catch (MemcachedException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    private final void testAll()
    {
    	try {
    		KeyIterator it=memcachedClient.getKeyIterator(AddrUtil.getOneAddress("localhost:11211"));
    		while(it.hasNext())
    		 {
    		    String key=it.next();
    		    System.out.println(key);
    		 }
			memcachedClient.shutdown();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    private final void get()
    {
    	User uu;
		try {
			uu = memcachedClient.get("storeMessage_15051842918");
			//memcachedClient.touch("test1", 10);
			System.out.println(uu);
			memcachedClient.shutdown();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	public static void main(String[] args) {
		//new Test1().testObject();
		//new Test1().testAll();
		new Test1().get();
	}
	
}
