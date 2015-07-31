package weather;

import java.util.List;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWS;
import cn.com.webxml.WeatherWSSoap;


public class WeatherClient {
	 public static void main(String[] args) {
		  WeatherWS fs = new WeatherWS();
		  WeatherWSSoap soap = fs.getWeatherWSSoap();
		  ArrayOfString aString = soap.getRegionCountry();
		  List<String> string = aString.getString();
		  System.out.println(string);
     }
}
