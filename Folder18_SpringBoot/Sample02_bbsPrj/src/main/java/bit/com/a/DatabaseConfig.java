package bit.com.a;

import javax.sql.DataSource;

//import javax.sql.DataSource;



import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class DatabaseConfig {
	
	@Bean  // 객체 생성 annotaion
	public SqlSessionFactory sqlsessionFactory(DataSource ds)throws Exception{
		//mybatis 설정시 
		System.out.println("DatabaseConfig sqlsessionFactory");
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		//sqlSessionFactoryBean.setDataSource(datasource);
//		sqlSessionFactoryBean.setDataSource(datasource);
		sqlSessionFactoryBean.setDataSource(ds);
		
		//org.springframework.core.io.Resource;
		Resource[] arrResource = new PathMatchingResourcePatternResolver().getResources("classpath:sqls/*.xml");
		sqlSessionFactoryBean.setMapperLocations(arrResource);
		sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
		
		return (SqlSessionFactory)sqlSessionFactoryBean.getObject();
		
		
	}//end of method
	
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	

}

