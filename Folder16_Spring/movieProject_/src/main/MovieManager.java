package main;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MovieManager
{
  public static List<MovieVo> getCGVdata()
  {
    List<MovieVo> list = new ArrayList();
    try
    {
      Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();
      
      Elements titles = doc.select("div.box-contents strong.title");
      
      Elements likes = doc.select("div.box-contents span.count strong i");
      
      System.out.println("likes =- " + likes);
      
      Elements poster = doc.select("div.box-image span.thumb-image img[src]");
      
      System.out.println("이 미 지  포스터 주소  = poster = " + poster);
      
      Elements poster1 = doc.select("div.box-image span.thumb-image img[alt]");
      System.out.println("이 미 지111= poster111 = " + poster1);
      for (int i = 0; i < 7; i++)
      {
        Element eTitle = (Element)titles.get(i);
        String title = eTitle.text();
        String posterLoc = ((Element)poster.get(i)).attr("src");
        System.out.println(title + " ");
        
        MovieVo vo = new MovieVo();
        vo.setTitle(title);
        
        vo.setPosterLoc(posterLoc);
        list.add(vo);
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return list;
  }
}
