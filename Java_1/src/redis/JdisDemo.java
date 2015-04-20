package redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class JdisDemo {  

    @SuppressWarnings("unchecked") 
    public void testDeom(){  
        Jedis  redis = new Jedis ("localhost",6379);//连接redis 

        //hset key field value将哈希表key中的域field的值设为value。 
        redis.hset("yyweb", "music", "m.yy.com"); 
        redis.hset("yyweb", "mall", "mai.yy.com"); 
        redis.hset("yyweb", "duowan", "www.duowan.com"); 
        //返回哈希表key中，一个或多个给定域的值。 
        List list = redis.hmget("yyweb","music","mall","duowan"); 
        for(int i=0;i<list.size();i++){ 
            System.out.println(list.get(i)); 
        } 

        //同时将多个field - value(域-值)对设置到哈希表key中。 
        Map map = new HashMap();
        map.put("uid", "10000"); 
        map.put("username", "chenxu"); 
        redis.hmset("hash", map); 
        //得到map下面的username的值 
        System.out.println(redis.hget("hash", "username")); 

        //HGETALL key返回哈希表key中，所有的域和值。 
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
