package com.mcnc.practice.demo.user.mapper;

import com.mcnc.practice.demo.user.domain.UserVo;
public interface UserMapper {
	// 로그인
	UserVo getUserAccount(String userId);
	
	int getlockCnt(String userId);
	
	void addlockCnt(String userId);

}
