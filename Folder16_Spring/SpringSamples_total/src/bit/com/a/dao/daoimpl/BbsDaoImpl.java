package bit.com.a.dao.daoimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.BbsDao;
import bit.com.a.model.BbsDto;

@Repository
public class BbsDaoImpl implements BbsDao {
	
	@Autowired
	SqlSession sqlSession;			
	String ns = "Bbs.";
	
	
	
	@Override
	public List<BbsDto> getBbsList() {
		List<BbsDto> list = sqlSession.selectList(ns + "getBbsList");
		return list;
	}

}
