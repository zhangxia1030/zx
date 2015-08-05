package weather;

import cn.com.webxml.MobileCodeWS;
import cn.com.webxml.MobileCodeWSSoap;

public class Test1 {
	 public static void main(String[] args) {
		  MobileCodeWS we = new MobileCodeWS();
		  MobileCodeWSSoap soap = we.getMobileCodeWSSoap();
		  String str = soap.getMobileCodeInfo("15005605366", null);
		  System.out.println(str);
    }
}
