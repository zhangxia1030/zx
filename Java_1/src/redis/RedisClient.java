package redis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.SortingParams;



public class RedisClient {
	
	//��Ƭ����������
	//����Ƭ����Ⱥ���ʵȵ�
    private Jedis jedis;//����Ƭ��ͻ�������
    private JedisPool jedisPool;//����Ƭ���ӳ�
    private ShardedJedis shardedJedis;//��Ƭ��ͻ�������
    private ShardedJedisPool shardedJedisPool;//��Ƭ���ӳ�
    
    public RedisClient() 
    { 
        initialPool(); 
        initialShardedPool(); 
        shardedJedis = shardedJedisPool.getResource(); 
        jedis = jedisPool.getResource(); 
        
        
    } 
 
    /**
     * ��ʼ������Ƭ��
     */
    private void initialPool() 
    { 
        // �ػ������� 
        JedisPoolConfig config = new JedisPoolConfig(); 
        config.setMaxActive(20); 
        config.setMaxIdle(5); 
        config.setMaxWait(1000l); 
        config.setTestOnBorrow(false); 
        
        jedisPool = new JedisPool(config,"127.0.0.1",6379);
    }
    
    /** 
     * ��ʼ����Ƭ�� 
     */ 
    private void initialShardedPool() 
    { 
        // �ػ������� 
        JedisPoolConfig config = new JedisPoolConfig(); 
        config.setMaxActive(20); 
        config.setMaxIdle(5); 
        config.setMaxWait(1000l); 
        config.setTestOnBorrow(false); 
        // slave���� 
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>(); 
        shards.add(new JedisShardInfo("127.0.0.1", 6379, "master")); 
        shards.add(new JedisShardInfo("127.0.0.1", 6380, "salveof1")); 
        shards.add(new JedisShardInfo("127.0.0.1", 6381, "salveof2")); 

        // ����� 
        shardedJedisPool = new ShardedJedisPool(config, shards); 
    } 

    public void show() {
    	sharedString();
        jedisPool.returnResource(jedis);
        shardedJedisPool.returnResource(shardedJedis);
    } 
    
    public void sharedString() {
    	jedis.set("user", "name:zx;age:40");
    	System.err.println(jedis.get("user"));
    	
    	System.err.println("========================");
    	//shardedJedis.set("ur", "1234");
    	System.err.println(shardedJedis.get("user"));
    	System.err.println(shardedJedis.get("user"));
    }
    
    public void testString() {
        //-----�������----------  
        jedis.set("name","xinxin");//��key-->name�з�����value-->xinxin  
        System.out.println(jedis.get("name"));//ִ�н����xinxin  
        
        jedis.append("name", " is my lover"); //ƴ��
        System.out.println(jedis.get("name")); 
        
        jedis.del("name");  //ɾ��ĳ����
        System.out.println(jedis.get("name"));
        //���ö����ֵ��
        jedis.mset("name","liuling","age","23","qq","476777389");
        jedis.incr("age"); //���м�1����
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
        
    }
    
    public static void main(String[] args) {
		new RedisClient().show();
	}
}