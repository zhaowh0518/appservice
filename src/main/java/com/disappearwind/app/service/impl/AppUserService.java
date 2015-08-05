/**
 * 
 */
package com.disappearwind.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.disappearwind.app.mapper.AppUserMapper;
import com.disappearwind.app.model.AppUser;
import com.disappearwind.app.service.IAppUserService;

@Service
@Repository
public class AppUserService implements IAppUserService {
	
	@Autowired
	private AppUserMapper appUserMapper;

	public Integer getAppUserID(String deviceNum) {
		return appUserMapper.selectIDByDeviceNum(deviceNum);
	}
	public int AddAppUser(AppUser user){
		return appUserMapper.insert(user);
	}
}
