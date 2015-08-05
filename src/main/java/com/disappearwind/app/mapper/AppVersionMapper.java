package com.disappearwind.app.mapper;

import com.disappearwind.app.model.AppVersion;

public interface AppVersionMapper {
	AppVersion selectAppVersion(String apptoken);
}