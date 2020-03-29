package bit.com.a.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;


import org.springframework.stereotype.Component;

import bit.com.a.model.Youtube;

//자동생성되도록 만드는 어노테이션
@Component		//autowired
public class YoutubeParser {
	String urls="https://www.youtube.com/results?search_query=";
	ArrayList<String> htmls = new ArrayList<String>();
	
	
	public ArrayList<String> search(String s){
		htmls.clear();
		BufferedReader br = null;
		
		try {
			String ss = URLEncoder.encode(s, "utf-8");
			System.out.println(ss);
			
			//url.net
				URL url = new URL(urls + ss);
					br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String msg = "";
			while((msg = br.readLine()) != null) {
				//contains() :  괄호안에 문자열 이 있는지 찾는다.
				if(msg.trim().contains("class=\"yt-uix-tile-link yt-ui-ellipsis yt-ui-ellipsis-2 yt-uix-sessionlink")) {
					htmls.add(msg.trim());
				}
			}
				
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return htmls;
		
	}
	
	public String toUrl(String msg) {
		String tt = "";
		if(msg.indexOf("&") == -1) {
			tt = msg;
		}else {
			tt = msg.substring(0,msg.indexOf("&"));
		}
		return tt;
		
	}
	
	public ArrayList<Youtube> getTitles(String key) {
		ArrayList<Youtube> af = new ArrayList<Youtube>();
		int i = 0;
		ArrayList<String> asd = search(key);
		
		for(int j=0; j<asd.size(); j++) {
			
			try {
				String [] fu = asd.get(i).split("\"");
				String url = URLDecoder.decode(fu[5], "EUC-KR");
				String title = URLDecoder.decode(fu[11], "EUC-KR");
				
				Youtube dto = new Youtube(title, toUrl(url), "");
				af.add(dto);
				
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				
			}
			
			i++;
		}
		return af;
		
		
		
		
	}// end of gettitle class
	
	
	
	
	

}//end of parser class
