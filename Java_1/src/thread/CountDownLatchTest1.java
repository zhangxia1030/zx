package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest1 {

    // 模拟并发登录网址，查看服务器峰值
    public static void main(String[] args) throws InterruptedException {

        // 锁住所有线程，等待并发执行
        final CountDownLatch begin = new CountDownLatch(1);  


        final ExecutorService exec = Executors.newFixedThreadPool(10);  

        for (int index = 0; index < 10; index++) 
        {
            final int NO = index + 1;  
            
            Runnable run = new Runnable() 
            {
                public void run() {  
                    try {  
                        // 等待，所有一起执行
                        begin.await();
                        //开始模拟登录等待。。。
                        Thread.sleep((long) (Math.random() * 10000));  
                        System.out.println("No." + NO + " execute");  
                    } catch (InterruptedException e) 
                    {  
                    	e.printStackTrace();
                    } 
                    finally {  
                    }  
                }  
            };  
            exec.submit(run);
        }  
        
        System.out.println("开始执行");  
        // begin减一，开始并发执行
        begin.countDown();  
        
        //关闭执行
        exec.shutdown();  
    }
}
