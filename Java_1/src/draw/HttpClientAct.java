package draw;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * User: DEDE
 * Date: 15-3-19
 * Time: 下午1:05
 * 说明：
 */
public class HttpClientAct {
    private org.apache.commons.httpclient.HttpClient client = null;
    private MultiThreadedHttpConnectionManager connectionManager;

    public HttpClientAct() {
        this(150, 30000, 30000, 1024 * 1024);
    }

    public HttpClientAct(int maxConPerHost, int conTimeOutMs, int soTimeOutMs,
                         int maxSize) {
        connectionManager = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams params = connectionManager.getParams();
        params.setDefaultMaxConnectionsPerHost(maxConPerHost);
        params.setConnectionTimeout(conTimeOutMs);
        params.setSoTimeout(soTimeOutMs);

        HttpClientParams clientParams = new HttpClientParams();
        // 忽略cookie 避免 Cookie rejected 警告
        clientParams.setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
        client = new org.apache.commons.httpclient.HttpClient(clientParams,
                connectionManager);
    }

    public JSONObject postJSONObject(String url, JSONObject jsonObject) {
        JSONObject rtnObj = null;
        PostMethod postMethod = null;
        String responseStr = null;
        int statusCode = 0;
        try {
            postMethod = new PostMethod(url);
            // 200 表示OK
            HttpMethodParams param = postMethod.getParams();
            param.setContentCharset("UTF-8");
            RequestEntity entity = new StringRequestEntity(jsonObject.toJSONString(), "text/html", "UTF-8");
            postMethod.setRequestEntity(entity);
            statusCode = client.executeMethod(postMethod);
            if (statusCode != HttpStatus.SC_OK) {
                // 失败
                return rtnObj;
            }
            // 处理乱码
            postMethod.getParams().setContentCharset("UTF-8");
            // 获得返回结果
            responseStr = postMethod.getResponseBodyAsString();
            rtnObj = JSON.parseObject(responseStr);
        } catch (Exception e) {
            String errorTip = "";
            if (StringUtils.indexOfIgnoreCase(e.getMessage(), "Network is unreachable") > -1) {
                errorTip = "无法连接 Network is unreachable";
            } else if (StringUtils.indexOfIgnoreCase(e.getMessage(), "connect timed out") > -1) {
                errorTip = "连接超时 connect timed out";
            } else if (StringUtils.indexOfIgnoreCase(e.getMessage(), "Read timed out") > -1) {
                errorTip = "处理超时 Read timed out";
            }
            errorTip = "【调用流量商品化接口出现异常(" + errorTip + ")】  url:" + url + " JSONDATA:" + jsonObject.toJSONString();
            rtnObj.put("statusCode", statusCode);
            rtnObj.put("error", true);
            rtnObj.put("msg", errorTip);
            System.out.println(rtnObj.toJSONString());
        } finally {
            // 释放连接
            if (postMethod != null) {
                postMethod.releaseConnection();
            }

        }
        return rtnObj;
    }
    
    public String postXmlObject(String url, String parm) {
        String rtnObj = null;
        PostMethod postMethod = null;
        String responseStr = null;
        int statusCode = 0;
        try {
            postMethod = new PostMethod(url);
            // 200 表示OK
            HttpMethodParams param = postMethod.getParams();
            param.setContentCharset("UTF-8");
            RequestEntity entity = new StringRequestEntity(parm, "text/html", "UTF-8");
            postMethod.setRequestEntity(entity);
            statusCode = client.executeMethod(postMethod);
            if (statusCode != HttpStatus.SC_OK) {
                // 失败
                return rtnObj;
            }
            // 处理乱码
            postMethod.getParams().setContentCharset("UTF-8");
            // 获得返回结果
            responseStr = postMethod.getResponseBodyAsString();
            rtnObj = responseStr;
        } catch (Exception e) {
            String errorTip = "";
            if (StringUtils.indexOfIgnoreCase(e.getMessage(), "Network is unreachable") > -1) {
                errorTip = "无法连接 Network is unreachable";
            } else if (StringUtils.indexOfIgnoreCase(e.getMessage(), "connect timed out") > -1) {
                errorTip = "连接超时 connect timed out";
            } else if (StringUtils.indexOfIgnoreCase(e.getMessage(), "Read timed out") > -1) {
                errorTip = "处理超时 Read timed out";
            }
            errorTip = "【调用流量商品化接口出现异常(" + errorTip + ")】  url:" + url + " JSONDATA:" + parm;
            System.out.println(rtnObj);
        } finally {
            // 释放连接
            if (postMethod != null) {
                postMethod.releaseConnection();
            }

        }
        return rtnObj;
    }

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("1", "1");
        System.out.println(new HttpClientAct().postJSONObject("http://www.baidu.com", jsonObject).toJSONString());
    }
}
