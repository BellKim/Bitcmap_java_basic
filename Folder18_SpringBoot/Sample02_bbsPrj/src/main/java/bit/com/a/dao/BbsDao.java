package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.model.BbsDto;
import bit.com.a.model.BbsParam;

@Mapper
@Repository
public interface BbsDao {
	

	
	public List<BbsDto> getBbsList(BbsParam param);
	
	public int getBbsCount(BbsParam param);

}
