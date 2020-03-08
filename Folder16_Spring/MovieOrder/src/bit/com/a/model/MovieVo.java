package bit.com.a.model;

import java.io.Serializable;

public class MovieVo
  implements Serializable
{
  private String title;
  private int like;
  private String posterLoc;
  
  public MovieVo() {}
  
  public MovieVo(String title, int like, String posterLoc)
  {
    this.title = title;
    this.like = like;
    this.posterLoc = posterLoc;
  }
  
  public MovieVo(String title, int like)
  {
    this.title = title;
    this.like = like;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setTitle(String title)
  {
    this.title = title;
  }
  
  public int getLike()
  {
    return this.like;
  }
  
  public void setLike(int like)
  {
    this.like = like;
  }
  
  public String getPosterLoc()
  {
    return this.posterLoc;
  }
  
  public void setPosterLoc(String posterLoc)
  {
    this.posterLoc = posterLoc;
  }
  
  public String toString()
  {
    return "MovieVo [title=" + this.title + ", like=" + this.like + ", posterLoc=" + this.posterLoc + "]";
  }
}
