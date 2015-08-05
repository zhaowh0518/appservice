package com.disappearwind.app.service;

import java.util.List;

import com.disappearwind.app.model.SysConfig;

/**
 * 系统参数配置
 *
 */
public interface ISysConfigService {

	List<SysConfig> selectSysConfig();
}
