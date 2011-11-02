package org.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserInfoDao {
	
	public static java.sql.Timestamp stringToSqlTimestamp(String str){
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		java.util.Date date = null;
		java.sql.Timestamp timestamp = null;
		
		try {
			date = df.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		timestamp = new java.sql.Timestamp( date.getTime() );
		
		return timestamp;
		
	}

	public static void main(String[] args) {

		String resource = "Configuration.xml";
		Reader reader = null;
		SqlSession sqlSession = null;
		SqlSessionFactory sqlMapperFactory = null;
		try {
			// 1. 从XML中构建SqlSessionFactory
			reader = Resources.getResourceAsReader(resource);
			sqlMapperFactory = new SqlSessionFactoryBuilder().build(reader);

			// 2. 从SqlSessionFactory中获取SqlSession
			sqlSession = sqlMapperFactory.openSession();
			
			
			// select 
		    UserInfoDTO dto = (UserInfoDTO) sqlSession.selectOne("UserInfoMapper.getUserInfo", 61);
		    System.out.println( "---------------->" + dto.getMemo() );
			
			// select DATE类型的查询
//			java.sql.Timestamp timestamp = stringToSqlTimestamp("2010-12-8 8:44:42");
//			UserInfoDTO userInfoDto = (UserInfoDTO) sqlSession.selectOne("UserInfoMapper.getUserInfoByBirthday", timestamp);
			
			// select 传入多个参数
//			Map<String, Object> hashMap = new HashMap<String, Object>();
//			hashMap.put( "arg1", 24 );
//			hashMap.put( "arg2", stringToSqlTimestamp("2010-12-8 8:44:42") );
//			UserInfoDTO userInfoDTO = (UserInfoDTO) sqlSession.selectOne("UserInfoMapper.getUserInfoByAgeAndBirthday", hashMap);
//			
//			System.out.println(userInfoDTO);
			
			
			// insert
//			UserInfoDTO dto = new UserInfoDTO();
////			dto.setId(1);
//			dto.setName("paulo");
//			dto.setAge(24);
//			dto.setBirthday(new java.sql.Timestamp( new java.util.Date().getTime() ));
//			String clobString = "This is a Clob Type.";
//			dto.setMemo(clobString);
////			dto.setMemo(null);
//			
//			sqlSession.insert("UserInfoMapper.addUserInfo", dto);
//			sqlSession.commit();
			
			
//			// update 把number和integer类型的字段更新为空
//			Map map = new HashMap();
//			map.put("arg1", 99);
//			sqlSession.update("UserInfoMapper.updateNumberToNull",map);
//			
//			sqlSession.commit();
			
			sqlSession.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	
	}
}
