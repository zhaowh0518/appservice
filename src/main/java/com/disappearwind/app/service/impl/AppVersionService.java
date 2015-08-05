/**
 * 
 */
package com.disappearwind.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.disappearwind.app.mapper.AppVersionMapper;
import com.disappearwind.app.model.AppVersion;
import com.disappearwind.app.service.IAppVersionService;

@Service
@Repository
public class AppVersionService implements IAppVersionService {

	@Autowired
	private AppVersionMapper appVersionMapper;

	public AppVersion getAppVersion(String apptoken) {
		return appVersionMapper.selectAppVersion(apptoken);
	}
}
