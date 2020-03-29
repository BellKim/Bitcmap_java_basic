package bit.com.a.model;

import java.io.Serializable;


/*

CREATE TABLE YOUTUBE(
	SEQ NUMBER PRIMARY KEY,
	VNAME VARCHAR2(100) NOT NULL,
	ID VARCHAR2(50) NOT NULL,
	TITLE VARCHAR2(200) NOT NULL,
	CATEGORY VARCHAR2(200) NOT NULL,
	WDATE DATE NOT NULL
);

CREATE SEQUENCE SEQ_YOUTUBE
START WITH 1
INCREMENT BY 1;

ALTER TABLE YOUTUBE ADD CONSTRAINT
FK_YOUTUBE FOREIGN KEY(ID)
REFERENCES MEMBER(ID);

*/
public class Youtube implements Serializable {
	private String title;
	private String url;
	private String img;

	
	public Youtube() {
		// TODO Auto-generated constructor stub
	}

	public Youtube(String title, String url, String img) {
		super();
		this.title = title;
		this.url = url;
		this.img = img;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}



	@Override
	public String toString() {
		return "Youtube [title=" + title + ", url=" + url + ", img=" + img + "]";
	}
	
	public String getVname() {
		return toUrl(this.url);
	}
	
	public String toUrl(String msg) {
		String tt = "";
		if(msg.indexOf("=") == -1) {
			tt = msg;
		}else {
			tt = msg.substring(msg.indexOf("=")+1);
		}
		return tt;
		
	}
	

}//end of youtube
