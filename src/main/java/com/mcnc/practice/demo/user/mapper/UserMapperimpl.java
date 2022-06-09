package com.mcnc.practice.demo.user.mapper;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mcnc.practice.demo.user.Controller.UserController;
import com.mcnc.practice.demo.user.domain.UserVo;

@Repository
public class UserMapperimpl implements UserMapper{
	
	private static final Logger logger = LoggerFactory.getLogger(UserMapperimpl.class);
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	static final String NAMESPACE = "com.mcnc.practice.demo.user.mapper.UserMapper";

	@Override
	public UserVo getUserAccount(String userId){
		// TODO Auto-generated method stub
		
		UserVo userVo = new UserVo();
		
		try {
			
			userVo = sessionTemplate.selectOne(NAMESPACE+".getUserAccount",userId);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("ERROR>>>>>"+e.getMessage());
		}
		
		return userVo;
	}

	@Override
	public int getlockCnt(String userId) {
		// TODO Auto-generated method stub
		
		int lockCnt = 0;
		
		try {

			lockCnt = sessionTemplate.selectOne(NAMESPACE+".getlockCnt", userId);
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
		
		
		return lockCnt;
	}

	@Override
	public void addlockCnt(String userId) {
		// TODO Auto-generated method stub
		int lockCnt = 0;
		
		try {
			lockCnt = getlockCnt(userId);
			
			lockCnt++;
			
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("userId", userId);
			paramMap.put("lockCnt",lockCnt);
			
			int i = sessionTemplate.update(NAMESPACE+".addlockCnt", paramMap);
			
			if(i<1) {
				throw new Exception("update 실패");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
		
		
	}
}
