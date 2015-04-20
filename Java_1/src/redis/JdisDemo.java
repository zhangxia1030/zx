package redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class JdisDemo {  

    @SuppressWarnings("unchecked") 
    public void testDeom(){  
        Jedis  redis = new Jedis ("localhost",6379);//����redis 

        //hset key field value����ϣ��key�е���field��ֵ��Ϊvalue�� 
        redis.hset("yyweb", "music", "m.yy.com"); 
        redis.hset("yyweb", "mall", "mai.yy.com"); 
        redis.hset("yyweb", "duowan", "www.duowan.com"); 
        //���ع�ϣ��key�У�һ�������������ֵ�� 
        List list = redis.hmget("yyweb","music","mall","duowan"); 
        for(int i=0;i<list.size();i++){ 
            System.out.println(list.get(i)); 
        } 

        //ͬʱ�����field - value(��-ֵ)�����õ���ϣ��key�С� 
        Map map = new HashMap();
        map.put("uid", "10000"); 
        map.put("username", "chenxu"); 
        redis.hmset("hash", map); 
        //�õ�map�����username��ֵ 
        System.out.println(redis.hget("hash", "username")); 

        //HGETALL key���ع�ϣ��key�У����е����ֵ�� 
        Map<String,String> maps = redis.hgetAll("hash"); 
        for(Map.Entry entry: maps.entrySet()) { 
             System.out.print(entry.getKey() + ":" + entry.getValue() + "\t");
        } 
    }

    public static void main(String[] args)  throws Exception{         
        JdisDemo jedis = new JdisDemo();  
        jedis.testDeom();  
    }  
}  
