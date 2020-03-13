package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.BbsDao;
import bit.com.a.model.BbsDto;
import bit.com.a.model.BbsParam;

@Repository
public class BbsDaoImpl implements BbsDao {
	
	@Autowired
	SqlSession sqlSession;			
	String ns = "Bbs.";
	
	
	
//	@Override
//	public List<BbsDto> getBbsList() {
//		List<BbsDto> list = sqlSession.selectList(ns + "getBbsList");
//		return list;
//	}
	
	@Override
	public List<BbsDto> getBbsList(BbsParam param) {
		List<BbsDto> list = sqlSession.selectList(ns+"getBbsList", param);
		return list;
	}
	

	@Override
	public boolean writeBbs(BbsDto bbsdto) {
		int res = sqlSession.insert(ns+"writeBbs", bbsdto);
		return res>0?true:false;
	}

	@Override
	public BbsDto getBbs(int seq) {
		// TODO seq를 d입력해서 detail 전체를 받아오는것. 
		return sqlSession.selectOne(ns+"getBbs", seq);
	}


	@Override
	public int getBbsCount(BbsParam param) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns+"getBbsCount", param);
	}
	
	
	

}//end of class BbsDaoImpl
