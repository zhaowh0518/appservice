/**
 * 
 */
package com.disappearwind.app.service;

import com.disappearwind.app.model.AppVersion;

public interface IAppVersionService {

	/**
	 * 获取某个渠道最新的版本信息
	 */
	public AppVersion getAppVersion(String apptoken);
}
