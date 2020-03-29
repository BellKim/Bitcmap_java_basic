package bit.com.a.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.model.MemberDto;

@Mapper
@Repository
public interface MemberDao {

	public int getId(String id);
	
	public int addmember(MemberDto dto);
	
	public MemberDto login(MemberDto dto);
	
	
}
