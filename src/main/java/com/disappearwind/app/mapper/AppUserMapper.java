package com.disappearwind.app.mapper;

import com.disappearwind.app.model.AppUser;

public interface AppUserMapper {
	Integer selectIDByDeviceNum(String deviceNum);	
    int insert(AppUser record);
}