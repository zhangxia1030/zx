/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */
package draw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class QuickStart {

    public static void main(String[] args) throws Exception {
    	
    	ExecutorService es = Executors.newCachedThreadPool();
    	Runnable rn = new PP(0L);
    	for(int i=0; i < 10; i++)
    	{
    		es.execute(rn);
    	}
    	
    	es.shutdown();
    }
    
}


class PP implements Runnable
{
	
	Long count = 0L;
	
	public PP(Long count)
	{
		this.count = count;
	}
	
	@Override
	public void run(){
        while(true)
        {
        	System.out.println(count++);
        	try {
				if(iteratorP())
				{
					System.exit(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
	}
	
	private static Boolean iteratorP() throws Exception{
    	CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost("http://localhost:8080/act_tplmgr/login");
            List <NameValuePair> nvps = new ArrayList <NameValuePair>();
            nvps.add(new BasicNameValuePair("account", Test4.getRandomString(new Random().nextInt(10))));
            nvps.add(new BasicNameValuePair("password", Test4.getRandomString(new Random().nextInt(10))));
            //nvps.add(new BasicNameValuePair("password", "o&sU"));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            CloseableHttpResponse response2 = httpclient.execute(httpPost);

            try {
                System.out.println(nvps);
                HttpEntity entity2 = response2.getEntity();
                // do something useful with the response body
                // and ensure it is fully consumed
                String str = EntityUtils.toString(entity2);
                if(str.indexOf("loginForm") == -1)
    			{
                	EntityUtils.consume(entity2);
                	System.out.println("====================================");
                	System.out.println(nvps);
                	System.out.println(str);
                	return true;
    			}
                EntityUtils.consume(entity2);
            } finally {
                response2.close();
            }
        } finally {
            httpclient.close();
        }
		return false;
    }
}
