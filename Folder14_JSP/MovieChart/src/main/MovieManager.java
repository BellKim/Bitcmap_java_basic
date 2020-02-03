package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MovieManager{
	
	public static List<MovieVo> getCGVdata() {
		
		Document doc;
		List<MovieVo> list = new ArrayList<MovieVo>();
		
		try {
			doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();
			
			//영화제목 받아오기. 
			Elements titles = doc.select("div.box-contents strong.title");
			
			
		/*
			 <div class="box-contents">
                <a href="/movies/detail-view/?midx=82999">
                    <strong class="title">남산의 부장들</strong>
                </a>
		*/
			//관람자수 받아오기 

/*
			<span class="like"> 
                            <button class="btn-like" value="82999">영화 찜하기</button>
                            <span class="count"> 
                                <strong><i>6,673</i><span>명이 선택</span></strong> 
                                <i class="corner-RT"></i><i class="corner-LT"></i><i class="corner-LB"></i><i class="corner-RB"></i><i class="corner-arrow"></i>
                            </span>
                            <a class="link-reservation" href="/ticket/?MOVIE_CD=20022399&MOVIE_CD_GROUP=20022198">예매</a>
                        </span>
*/
				Elements likes = doc.select("div.box-contents span.count strong i");
											//큰테두리			테그명의 카운트의		테그명의 i 
				
//				<span class="count"> 
//                <strong><i>6,673</i><span>명이 선택</span></strong> 


		for (int i = 0; i < 7; i++) {
			Element eTitle = titles.get(i);
			String title = eTitle.text();
			System.out.println(title + " ");
			
			Element eLike = likes.get(i);
			String slike = eLike.text().replace(",", "");
			System.out.println(slike);
			
			int like = Integer.parseInt(slike);
			
			MovieVo vo  = new MovieVo();
			vo.setTitle(title);
			vo.setLike(like);
			list.add(vo);
		}
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}

}//end of class