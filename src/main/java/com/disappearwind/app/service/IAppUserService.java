/**
 * 
 */
package com.disappearwind.app.service;

import com.disappearwind.app.model.AppUser;

public interface IAppUserService {
	/**
	 * 根据设备的序列号获取用户的ID
	 */
	public Integer getAppUserID(String deviceNum);
	/**
	 * 添加，插入一个用户
	 */
	public int AddAppUser(AppUser user);
}
