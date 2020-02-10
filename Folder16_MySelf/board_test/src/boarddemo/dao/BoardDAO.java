package boarddemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import boarddemo.dto.BoardDTO;
import boarddemo.dto.PageDTO;


public class BoardDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private BoardDAO() {
	}

	private static BoardDAO dao = new BoardDAO();

	public static BoardDAO getInstance() {
		return dao;
	}
	
	private Connection init() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");

		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String user = "hr";
		String password = "a1234";
		return DriverManager.getConnection(url, user, password);
	}// end start()

	private void exit() throws SQLException {
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}// end exit()
	
	public int rowTotalCount(HashMap<String, String> map) {//키, value //(서치를위한기능추가) 		
		//페이지번호 순서도
		int cnt = 0;
		try {
			conn = init();
			System.out.println("map:"+map.get("searchKey"));
			String sql = "select count(*) from board";
			
			if(map.get("searchKey") != null ) {				
				if (map.get("searchKey").equals("subject") || 
						map.get("searchKey").equals("writer") || map.get("searchKey").equals("content")) { 
				sql+=" where lower("+map.get("searchKey") +") like ?";
				}
			}
			pstmt = conn.prepareStatement(sql);
			if(map.get("searchKey") != null ) {
				if (map.get("searchKey").equals("subject") || 
						map.get("searchKey").equals("writer")||
						map.get("searchKey").equals("content"))	{			
			pstmt.setString(1, "%"+
			   map.get("searchWord").toLowerCase()+"%");
				}
			}
			rs = pstmt.executeQuery();
			if(rs.next())
				cnt = rs.getInt(1);
					

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(" 총 레코드수 출력 -> cnt : " + cnt); //총 레코드수
		return cnt;
		
	}
	
	

	public List<BoardDTO> listMethod(PageDTO pdto) {	
		List<BoardDTO> aList = new ArrayList<BoardDTO>();
		try {
			conn = init();
			//String sql="select * from board order by ref desc";
			/*String sql ="select b.* "+ 
					"from (select rownum as rm, a.* " + 
					"from (select * from board " + 
					"order by ref desc,re_step asc)a)b " +
					"where b.rm>=? and b.rm<=?";*/
			
			String sql ="select b.* "+ 
					"from (select rownum as rm, a.* " + 
					"from (select * from board ";
			if(pdto.getSearchKey()!= null) {
				if(pdto.getSearchKey().equals("subject")||
					pdto.getSearchKey().equals("writer")||
					pdto.getSearchKey().equals("content"))//검색기능추가
				sql+="where lower(" + pdto.getSearchKey() + ") like '%"+pdto.getSearchWord()+"%'";
			}
					sql+="order by ref desc,re_step asc)a)b ";
					sql+="where b.rm>=? and b.rm<=?";
					//?,? 값 각각 start row, end row
			//(서치를위한기능추가)
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pdto.getStartRow());
			pstmt.setInt(2, pdto.getEndRow());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setRe_level(rs.getInt("re_level"));
				dto.setUpload(rs.getString("upload"));
				aList.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return aList;
	}//end listMethod()////////////////////
	
	public BoardDTO viewMeethod(int num) {//num에 해당하는 레코드를 뽑아내자 . 왜 BoardDTO 인가? 에 대해서 생각해보자.  
		/* list.jsp 에서 <td><a href="view.do?num=${dto.num}">${dto.subject }</a></td>  부분에 있는 것. */
		
		BoardDTO dto = null;
		
		try {
			conn = init();
			String sql = "select * from board where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			//결과값은 하나만 리턴되거나 없다. num값을 집어넣기 때문에.
			if (rs.next()) {
				dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setSubject(rs.getString("subject"));
				dto.setEmail(rs.getString("email"));
				dto.setContent(rs.getString("content"));
				dto.setUpload(rs.getString("upload"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dto;
		
		
	}//end viewMethod()
	
	
	public void readCountMethod(int num) {  
		try {
			conn = init();
			String sql = "update board set readcount=readcount+1 where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}//end readCountMethod();;;;
	
	public void insertMethod(BoardDTO dto) {  
		try {
			conn = init();
			//제목글이면....
			if(dto.getRe_level()==0) {
				String sql = "insert into board(num,reg_date,writer";
				sql+=",email,subject,content,upload,ref,re_step";
				sql+=",re_level) values(board_seq.nextval,";
				sql+="sysdate,?,?,?,?,?,board_seq.nextval,0,0)";
				
				System.out.println(sql);
				pstmt = conn.prepareStatement(sql);//board_seq.nextval = ref = num			
				pstmt.setString(1, dto.getWriter());
				pstmt.setString(2, dto.getEmail());
				pstmt.setString(3, dto.getSubject());
				pstmt.setString(4, dto.getContent());
				pstmt.setString(5, dto.getUpload());
				
				pstmt.executeUpdate();
			}
			//답변글이면 
			else {
				String sql = "insert into board(num,reg_date,writer";
				sql+=",email,subject,content,upload,ref,re_step";
				sql+=",re_level) values(board_seq.nextval,";
				sql+="sysdate,?,?,?,?,?,?,?,?)";//ref re_step re_level 3가지 
				
				System.out.println(sql);
				pstmt = conn.prepareStatement(sql);//board_seq.nextval = ref = num			
				pstmt.setString(1, dto.getWriter());
				pstmt.setString(2, dto.getEmail());
				pstmt.setString(3, dto.getSubject());
				pstmt.setString(4, dto.getContent());
				pstmt.setString(5, dto.getUpload());
				pstmt.setInt(6, dto.getRef());
				pstmt.setInt(7, dto.getRe_step());
				pstmt.setInt(8, dto.getRe_level());
				
				
				
				pstmt.executeUpdate();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}//end insertMethod();;;;
	
	public void reStepMethod(HashMap<String, Integer> map) {  
		try {
			conn = init();
	
			String sql = "update board set re_step=re_step+1";
			sql+=" where ref=? and re_step>?"; 
			
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);//board_seq.nextval = ref = num			
			
			pstmt.setInt(1, map.get("ref"));
			pstmt.setInt(2, map.get("re_step"));
			pstmt.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}//end insertMethod();;;;
	
	public String fileMethod(int num) {
		String filename = null;
		try {
			conn=init();
			String sql = "SELECT upload FROM board WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				filename = rs.getString("upload");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return filename;
	}//end fileMethod()
	
	
	public void updateMethod(BoardDTO dto) {
		try {
			conn = init();
			String sql = "update board set subject=?,";
			sql += "email=?,content=?,upload=? where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getUpload());
			pstmt.setInt(5, dto.getNum());
			pstmt.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}//end updatemethod;;;
	
	
	public void deleteMethod(int num) {
		try {
			conn = init();
			String sql ="delete from board where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}//end deleteMethod()
	
	
	
	
	
	
	/*
	public void searchMethod(String searchKey, String searchWord) {
		try {
			conn=init();
			String sql = "";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchKey);
			pstmt.setString(2, searchWord);
			pstmt.executeQuery();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}//end searchMethod() ;;;;;;;;;;;;;;;;;;;;;;
*/	
	
}// end class



